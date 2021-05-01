package tn.sahbi.akram.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.sahbi.akram.petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
