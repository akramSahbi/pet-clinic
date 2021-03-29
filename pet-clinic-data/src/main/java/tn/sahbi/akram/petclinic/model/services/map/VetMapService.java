package tn.sahbi.akram.petclinic.model.services.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.sahbi.akram.petclinic.model.Specialty;
import tn.sahbi.akram.petclinic.model.Vet;
import tn.sahbi.akram.petclinic.model.services.SpecialtiesService;
import tn.sahbi.akram.petclinic.model.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtiesService specialtiesService;

    @Autowired
    public VetMapService(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object != null) {
            if (object.getSpecialties() != null) {
                Set<Specialty> specialties = object.getSpecialties();
                specialties.forEach(specialty -> {
                    if (specialty.getId() == null) {
                        Specialty savedSpecialty = specialtiesService.save(specialty);
                        specialty.setId(savedSpecialty.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
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
