package tn.sahbi.akram.petclinic.model.services.map;

import org.springframework.stereotype.Service;
import tn.sahbi.akram.petclinic.model.Specialty;
import tn.sahbi.akram.petclinic.model.services.SpecialtiesService;

import java.util.Set;

@Service
public class SpecialitiesMapService extends AbstractMapService<Specialty, Long> implements SpecialtiesService {
    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }
}
