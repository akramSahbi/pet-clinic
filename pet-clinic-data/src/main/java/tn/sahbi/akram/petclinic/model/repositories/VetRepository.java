package tn.sahbi.akram.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.sahbi.akram.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
