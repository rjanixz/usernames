package com.intertec.web.rest;

import com.intertec.domain.User;
import com.intertec.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    private Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    private UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        LOGGER.info("REST request to save user : {} ", user);
        if(user.getId() != null) {
            return ResponseEntity.badRequest().header("Error", "Users cannot have duplicate ids").body(null);
        }

        User result = userRepository.save(user);

        return ResponseEntity.created(new URI("/api/users/" + result.getId()))
                .header("Success").body(result);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        LOGGER.info("REST request to delete user: {} ", id);
        userRepository.delete(id);
        return ResponseEntity.ok().header("Success").build();

    }
}
