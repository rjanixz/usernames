package com.intertec.service;

import com.intertec.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This service provide functionality to validate even if a new user name is available or not.
 * Also provide username suggestions when a username is not available
 */
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result<Boolean, List<String>> checkUsername(final String username) {
        return new Result<Boolean, List<String>>() {
            @Override
            public Boolean isSuccess() {
                return userRepository.findByUsername(username).isEmpty();
            }

            @Override
            public List<String> results() {
                return suggest(username);
            }

            /**
             * Representation in a JSON Format so FE app can understand the result.
             *
             * // TODO use an api to do the JSON conversion
             */
            public String toJson() {
                // added quotes to the string
                List<String> quotedList = results().stream().map(r -> "\"" + r + "\"").collect(Collectors.toList());

                // simulating a json format
                return String.format("{\"success\":%s, \"suggestions\":[%s]}",
                        isSuccess(), String.join(",", quotedList));
            }
        };
    }


    private List<String> suggest(String username) {

        // TODO generate the suggestions
        return Arrays.asList("suggestion_1", "suggestion_2", "suggestion_3");
    }
}
