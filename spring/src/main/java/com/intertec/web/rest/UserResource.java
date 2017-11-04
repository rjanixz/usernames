package com.intertec.web.rest;

import com.intertec.domain.User;
import com.intertec.repository.UserRepository;
import com.intertec.service.Result;
import com.intertec.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * This class provides the needed rest endpoints to the FE app to maintain
 * the Users in database
 */
@RestController
@RequestMapping("/api")
public class UserResource {

    private Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    private UserRepository userRepository;
    private UserService userService;

    public UserResource(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        LOGGER.info("REST request to save user : {} ", user);
        if(user.getId() != null) {
            return ResponseEntity.badRequest().header("Error", "Users cannot have duplicate ids").body(null);
        }

        // validating username
        Result<Boolean, List<String>> result = userService.checkUsername(user.getUsername());

        if(result.isSuccess()) {

            User newUser = userRepository.save(user);
            LOGGER.info("User saved successfully");

            return ResponseEntity.created(new URI("/api/users/" + newUser.getId()))
                    .header("Success").body(newUser);
        } else {

            LOGGER.info("Username is not valid.");
            return ResponseEntity.ok().header("Already taken").body(result.toJson());
        }

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        LOGGER.info("REST request to delete user: {} ", id);
        userRepository.delete(id);
        return ResponseEntity.ok().header("Success").build();

    }
}
