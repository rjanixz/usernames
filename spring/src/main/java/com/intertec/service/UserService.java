package com.intertec.service;

import com.intertec.domain.RestrictedWord;
import com.intertec.repository.RestrictedWordRepository;
import com.intertec.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This service provide functionality to validate even if a new user name is available or not.
 * Also provide username suggestions when a username is not available
 */
@Service
@Transactional
public class UserService {

    /** Describes the maximum number of suggestions provided to the user. */
    private static final int NUM_OF_SUGGESTIONS = 14;
    /** Describes the maximum number that the app will try to generate the defined number of suggestions. */
    private static final int MAXIMUM_NUMBER_OF_ATTEMPTS = 3;
    /** Describes the amount of character to be added to the suggested usernames */
    private static final int SUFFIX_LENGTH = 6;

    private final UserRepository userRepository;
    private final RestrictedWordRepository restrictedWordRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, RestrictedWordRepository restrictedWordRepository) {
        this.userRepository = userRepository;
        this.restrictedWordRepository = restrictedWordRepository;
    }

    public Result<Boolean, List<String>> checkUsername(final String username) {
        return new Result<Boolean, List<String>>() {

            @Override
            public Boolean isSuccess() {
                return isValid(username);
            }

            @Override
            public List<String> suggestions() {

                List<String> suggestions = new ArrayList<>();

                // Suggestions are only generated when the username is already taken or contains restricted words
                if(!isSuccess()) {
                    LOGGER.info("Getting suggestions list");
                    suggestions = suggest(username);

                    // sorting
                    Collections.sort(suggestions);
                }

                return suggestions;
            }

            /**
             * Representation in a JSON Format so FE app can understand the result.
             *
             * // TODO use an api to do the JSON conversion
             */
            public String toJson() {
                // added quotes to the string
                List<String> quotedList = suggestions().stream().map(r -> "\"" + r + "\"").collect(Collectors.toList());

                // simulating a json format
                return String.format("{\"success\":%s, \"suggestions\":[%s]}",
                        isSuccess(), String.join(",", quotedList));
            }
        };
    }

    /**
     * This function is in charge of generate username suggestions based on the original username.
     * @param username the original requested username
     * @return a list of suggestions
     */
    private List<String> suggest(final String username) {

        String newUsername = username;

        boolean isInvalid = containsRestrictedWord(username);
        if(isInvalid){
            // In this point, first we need to remove the restricted words
            LOGGER.info("Username is invalid: {}", username);
            newUsername = removeRestrictedWord(username);
            LOGGER.info("Username fixed to: {}", newUsername);
        }

        final String preffixUserName = newUsername;
        List<String> suggestions = new ArrayList<>();

        int attempt = 0;
        int suggestionsPending = NUM_OF_SUGGESTIONS;

        // Iterating until it reaches the Maximum number of attempts
        // or It has reached the Maximum number of suggestions
        while(attempt < MAXIMUM_NUMBER_OF_ATTEMPTS &&
                suggestionsPending > 0) {

            LOGGER.info("Attempt No. {} Pending suggestions: {}", attempt + 1, suggestionsPending);
            IntStream.range(0, suggestionsPending).forEach(idx -> {

                String suggestedUserName = preffixUserName + randomSuffix();

                // Validating suggested username
                if(isValid(suggestedUserName)) {
                    LOGGER.info("Generated valid suggestion: {} ", suggestedUserName);
                    suggestions.add(suggestedUserName);
                }

            });

            attempt++;  // next attempt
            suggestionsPending = NUM_OF_SUGGESTIONS - suggestions.size(); //pending suggestions
        }

        LOGGER.info("Generated {} suggestions", suggestions.size());
        return suggestions;
    }

    /**
     * This function validates if the given username contains any restricted word
     */
    private boolean containsRestrictedWord(final String username) {

        // This list is cached to improve performance
        List<RestrictedWord> restrictedWords = restrictedWordRepository.findAll();

        // checking if the username contains any restricted word
        return restrictedWords.parallelStream()
                .anyMatch(rw -> StringUtils.contains(username, rw.getWord()));
    }

    /**
     * This function is in charge of removing any restricted word that the given username may contains.
     * @param username the given username
     * @return the username without restricted words
     */
    private String removeRestrictedWord(final String username) {

        // First the restricted words list is retrieved.
        // This list is cached to improve performance
        List<RestrictedWord> restrictedWords = restrictedWordRepository.findAll();

        // Parallel stream cannot be used here since It need to remove one restricted word at time
        // to get one single result
        // Then each restricted word is removed from the username
        return restrictedWords.stream()
                .filter(rw -> StringUtils.contains(username, rw.getWord()))
                .map(rw -> rw.getWord())
                .reduce(username, (preResult, rw) -> StringUtils.replace(preResult, rw, StringUtils.EMPTY));

    }

    /**
     * This functions validates if the user name is valid.
     * To consider a username valid it must not exist in database and
     * must not contains any restricted word
     * @param username The username to evaluate
     * @return true if the username is valid, false otherwise
     */
    private boolean isValid(String username) {

        // initially a username is considered valid until it fails one of the validations
        boolean isTaken = false;
        boolean isValid = true;

        // Step #1 validating if the username is already taken
        isTaken = !userRepository.findByUsername(username).isEmpty();

        if(!isTaken) {
            // Step #2 username is available, checking if contains any restricted word
            isValid = !containsRestrictedWord(username);
        }

        // returns TRUE if and only if the username doesn't exists in database and doesn't contains
        // any restricted word
        return !isTaken && isValid;
    }

    /**
     * This function is in charge of generate a random suffix.
     * Here RandomStringGenerator from apache commons text is used to minimize the probability
     * of generating a restricted word.
     *
     * The suffix has a length equals to the minimum username valid, so in case of the username is
     * exactly a restricted word a random suggestion with the minimum length will be generated.
     *
     * @return a random alphanumeric suffix string
     */
    private String randomSuffix(){
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(CharacterPredicates.DIGITS, CharacterPredicates.LETTERS)
                .build();

        return generator.generate(SUFFIX_LENGTH);
    }
}
