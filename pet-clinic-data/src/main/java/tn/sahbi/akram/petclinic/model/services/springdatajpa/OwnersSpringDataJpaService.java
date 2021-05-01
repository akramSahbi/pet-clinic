package tn.sahbi.akram.petclinic.model.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tn.sahbi.akram.petclinic.model.Owner;
import tn.sahbi.akram.petclinic.model.repositories.OwnerRepository;
import tn.sahbi.akram.petclinic.model.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnersSpringDataJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnersSpringDataJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<Owner>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName).orElse(null);
    }
}
