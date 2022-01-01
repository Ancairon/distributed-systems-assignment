package org.hua.dit.dsproject.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


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
    public void newPet(@RequestBody Pet pet) {
        petService.newPet(pet);
    }

    @DeleteMapping(path = "/pets/delete/{serialNumber}")
    public void deletePet(@PathVariable("serialNumber") int serialNumber) {
        petService.deletePet(serialNumber);
    }

    @PutMapping(path = "/pets/modify/{serialNumber}")
    public void modifyPet(@PathVariable("serialNumber") int serialNumber, @RequestParam(required = false) String race, @RequestParam(required = false) char sex) {
        petService.updatePet(serialNumber, race, sex);
    }
}
