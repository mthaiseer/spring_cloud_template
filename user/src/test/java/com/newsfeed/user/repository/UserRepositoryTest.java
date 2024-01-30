package com.newsfeed.user.repository;

import com.newsfeed.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    User user;

    @BeforeEach
    public void setupData() {

        user = User.builder()
                .email("test@email.com")
                .customerName("test_user")
                .build();
    }


    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserFetchLoadSuccess() {
        List<User> allUsers = userRepository.findAll();
        assertNotNull(allUsers);
        assertEquals(3, allUsers.size());

    }

    @Test
    public void testAddUserSuccess() {
        userRepository.save(user);
        assertNotNull(user.getCustomerId());
        List<User> allUsers = userRepository.findAll();
        assertEquals(4, allUsers.size());

    }

    @Test
    public void testFetchByEmail() {
        //setup
        userRepository.save(user);
        assertNotNull(user.getCustomerId());

        //when
        User user = userRepository.findByEmail("test@email.com");

        //expected
        assertNotNull(user);
    }


    @Test
    public void testFetchByEmailInvalidFail() {
        //setup

        //when
        User user = userRepository.findByEmail("invalid@email.com");

        //expected
        assertNull(user);
    }
}
