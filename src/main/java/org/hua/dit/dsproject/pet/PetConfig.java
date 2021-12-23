package org.hua.dit.dsproject.pet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PetConfig {

    @Bean
    CommandLineRunner commandLineRunner(PetRepository petRepository) {
        return args -> {
            Pet mydog = new Pet("Labrador Retriever", 'M', LocalDate.of(2010, 9, 8), "ABC123");

            petRepository.saveAll(List.of(mydog));
        };

    }
}
