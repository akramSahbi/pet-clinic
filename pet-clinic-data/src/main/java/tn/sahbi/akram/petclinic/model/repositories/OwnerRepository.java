package tn.sahbi.akram.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.sahbi.akram.petclinic.model.Owner;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findByLastName(String lastName);
}
