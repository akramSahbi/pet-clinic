package tn.sahbi.akram.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.sahbi.akram.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
