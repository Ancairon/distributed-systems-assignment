package org.hua.dit.dsproject.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping(path = "/pets/list")
    public List<Pet> getPet() {
        return petService.listAllPets();
    }

    @PostMapping(path = "/pets/new")
    //We need to add a check for the owner's ID here, to check that it exists
    public void newPet(@RequestBody Pet pet) {
        petService.newPet(pet);
    }

    @PostMapping(path = "/vet/modify")
    @ResponseBody
    public String modifyPet(@RequestBody Pet pet) {

        int response = petService.petRepository.PetExists(pet.getSerialNumber());
        if (response==0){
            return "No pets found with that serial number.";
        }

        petService.updatePet(pet.getSerialNumber(), pet.getMedical_history());
        return "Updated!";
    }

    @GetMapping(path = "/findPet/{serialNumber}")
    public Optional<Pet> getPet(@PathVariable("serialNumber") int serialNumber) {
        return petService.findPet(serialNumber);
    }

    @DeleteMapping(path = "/pets/delete/{serialNumber}")
    public void deletePet(@PathVariable("serialNumber") int serialNumber) {
        petService.deletePet(serialNumber);
    }
}
