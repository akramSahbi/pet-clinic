package tn.sahbi.akram.petclinic.model.services;

import tn.sahbi.akram.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
