package tn.sahbi.akram.petclinic.model.services.springdatajpa;

import tn.sahbi.akram.petclinic.model.PetType;
import tn.sahbi.akram.petclinic.model.repositories.PetTypeRepository;
import tn.sahbi.akram.petclinic.model.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

public class PetTypeSpringDataJpaService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeSpringDataJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);

        return petTypes;
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
