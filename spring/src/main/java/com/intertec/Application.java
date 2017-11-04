package com.intertec;

import com.intertec.domain.RestrictedWord;
import com.intertec.domain.User;
import com.intertec.repository.RestrictedWordRepository;
import com.intertec.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class Application {

    private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx, UserRepository userRepository,
                                               RestrictedWordRepository restrictedWordRepository) {
        return args -> {
            LOGGER.info("Starting Spring boot");

            // initial usernames
            userRepository.save(new User("rjanixz"));
            userRepository.save(new User("rasian"));

            // initial restricted words
            restrictedWordRepository.save(new RestrictedWord("cannabis"));
            restrictedWordRepository.save(new RestrictedWord("abuse"));
            restrictedWordRepository.save(new RestrictedWord("crack"));
            restrictedWordRepository.save(new RestrictedWord("damn"));
            restrictedWordRepository.save(new RestrictedWord("drunk"));
            restrictedWordRepository.save(new RestrictedWord("grass"));

        };
    }
}
