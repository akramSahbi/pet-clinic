package tn.sahbi.akram.petclinic.model.services.map;

import tn.sahbi.akram.petclinic.model.Vet;
import tn.sahbi.akram.petclinic.model.services.CrudService;
import tn.sahbi.akram.petclinic.model.services.VetService;

import java.util.Set;

public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
