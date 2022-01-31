package org.hua.dit.dsproject.pet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.List;

@Configuration
public class PetConfig {

    @Bean
    CommandLineRunner commandLineRunner(PetRepository petRepository) {
        return args -> {
            Pet mydog = new Pet(1, "Sample Race", 'M', new Date(2022, 1, 1), "1");

            petRepository.saveAll(List.of(mydog));
        };
    }
}