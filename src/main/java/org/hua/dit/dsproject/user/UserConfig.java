package org.hua.dit.dsproject.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerForUser(UserRepository userRepository) {
        return args -> {
            User citizen = new User("1", "citizen", "pass", "ROLE_CITIZEN");
            User employee = new User("2", "employee", "pass", "ROLE_EMPLOYEE");
            User vet = new User("3", "vet", "pass", "ROLE_VET");
            User admin = new User("4", "admin", "pass", "ROLE_ADMIN");

            userRepository.saveAll(List.of(citizen, employee, vet, admin));
        };
    }
}