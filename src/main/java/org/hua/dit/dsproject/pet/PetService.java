package org.hua.dit.dsproject.pet;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PetService {
    public String helloWorld(){
        Pet mypet = new Pet("Labrador Retriever", 'M', LocalDate.of(2010, 9, 8), 2109321);
        return mypet.toString();
    }
}
