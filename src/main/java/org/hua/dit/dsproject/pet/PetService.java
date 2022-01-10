package org.hua.dit.dsproject.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> listAllPets() {
        return petRepository.findAll();
    }

    public void newPet(Pet pet) {
        petRepository.save(pet);
    }

    public void deletePet(int serialNumber) {
        petRepository.deleteById(serialNumber);
    }

    public Optional<Pet> findPet(int id){
        return petRepository.findById(id);
    }

    @Transactional
    public void updatePet(int serialNumber, String race, char sex) {
        Optional<Pet> pet = petRepository.findById(serialNumber);
        if (pet.isPresent()) {
            Pet thePet = pet.get();
            thePet.setRace(race);
            thePet.setSex(sex);
        }

    }
}
