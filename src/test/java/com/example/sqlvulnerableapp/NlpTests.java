package com.example.sqlvulnerableapp;

import com.example.sqlvulnerableapp.repo.UserEntity;
import com.example.sqlvulnerableapp.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NlpTests {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void testSqlInjectionNotMalicous() {
        List<UserEntity> users = Arrays.asList(
                new UserEntity("Alice", "alice@example.com"),
                new UserEntity("Bob", "bob@example.com")
        );

        userRepository.saveAll(users);
        // Simulate a SQL injection attack

        String maliciousInput = "' OR '1'='1";

        // Attempt to use the malicious input in a repository method
        // Assuming you have a method 'findByName' that could be vulnerable
        List<UserEntity> result = userRepository.findUsersByNameSafe(maliciousInput);

        // Verify the repository method is not exploited by the injection
        // For example, it should not return all users in the database
        assertThat(result).isEmpty(); // or use other assertions as per your logic

        // Additional tests can include checking the repository method does not throw
        // unexpected exceptions and the database integrity is maintained.
    }
    @Test
    public void testSqlInjectionMalicious() {
        List<UserEntity> users = Arrays.asList(
                new UserEntity("Alice", "alice@example.com"),
                new UserEntity("Bob", "bob@example.com")
        );

        userRepository.saveAll(users);
        // Simulate a SQL injection attack

        String maliciousInput = "' OR '1'='1";

        // Attempt to use the malicious input in a repository method
        // Assuming you have a method 'findByName' that could be vulnerable
        List<UserEntity> result = userRepository.findUsersByNameUnsafe(maliciousInput);

        // Verify the repository method is exploited by the injection
        // For example, it should not return all users in the database
        assertThat(result).containsAll(users);
    }
}