package org.hua.dit.dsproject.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository UserRepository) {
        return args -> {
            User myuser = new User(123, "username_1", "password_1");

            UserRepository.saveAll(List.of(myuser));
        };
    }
}
