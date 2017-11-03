package com.intertec;

import com.intertec.domain.User;
import com.intertec.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx, UserRepository userRepository) {
        return args -> {
            LOGGER.info("Starting Spring boot");

            // testing repository
            userRepository.save(new User("rjanixz"));
            userRepository.save(new User("rasian"));

            // fetch all users
            LOGGER.info("findAll found with findAll():");
            LOGGER.info("-------------------------------");
            for (User user : userRepository.findAll()) {
                LOGGER.info(user.toString());
            }
            LOGGER.info("");
        };
    }
}
