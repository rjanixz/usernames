package com.intertec.service;

import com.intertec.domain.User;
import com.intertec.repository.RestrictedWordRepository;
import com.intertec.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceTest {

    private static final String VALID_USERNAME = "superJohn";
    private static final String INVALID_USERNAME = "coffee_abuser";
    private static final String TWICE_USERNAME = "ironman";

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestrictedWordRepository restrictedWordRepository;

    private UserService userService;

    @Before
    public void initDatabase() {

        // userRepository and restrictedWordRepository contains initial data defined in Application.java

        // instancing user service
        this.userService = new UserService(userRepository, restrictedWordRepository);

    }


    /**
     * Test a valid username
     */
    @Test
    public void addValidUsername() {
        Result<Boolean, List<String>> result = this.userService.checkUsername(VALID_USERNAME);

        assertThat(result.isSuccess()).isTrue();
    }

    /**
     * Test an invalid username.
     * username contains a restricted word
     *
     */
    @Test()
    public void addInvalidUsername() {
        Result<Boolean, List<String>> result = this.userService.checkUsername(INVALID_USERNAME);

        assertThat(result.isSuccess()).isFalse();
        assertThat(result.suggestions()).isNotEmpty();
    }

    /**
     * Test adding a username twice
     * first it is ok but second time should mark it as invalid and suggest a different username
     */
    @Test
    public void addUsernameTwice() {

        // Adding for first time
        Result<Boolean, List<String>> result1 = this.userService.checkUsername(TWICE_USERNAME);
        assertThat(result1.isSuccess()).isTrue(); // we expect it to be ok
        this.userRepository.save(new User(TWICE_USERNAME)); // so we save it

        // Adding for second time
        Result<Boolean, List<String>> result2 = this.userService.checkUsername(TWICE_USERNAME);
        assertThat(result2.isSuccess()).isFalse(); // we expect it to fail
        assertThat(result2.suggestions()).isNotEmpty(); // and a suggestion list
    }
}
