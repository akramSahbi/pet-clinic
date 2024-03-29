package tn.sahbi.akram.petclinic.model.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tn.sahbi.akram.petclinic.model.PetType;
import tn.sahbi.akram.petclinic.model.services.PetTypeService;

import java.util.Set;

@Service
@Profile("map")
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }
}
