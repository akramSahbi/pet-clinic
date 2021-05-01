package tn.sahbi.akram.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.sahbi.akram.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
