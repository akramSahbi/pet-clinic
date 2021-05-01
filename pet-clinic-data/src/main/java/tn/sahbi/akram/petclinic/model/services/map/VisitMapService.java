package tn.sahbi.akram.petclinic.model.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tn.sahbi.akram.petclinic.model.Visit;
import tn.sahbi.akram.petclinic.model.services.VisitService;

import java.util.Set;

@Service
@Profile("map")
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit visit)
    {
        if (visit == null || visit.getPet() == null || visit.getPet().getId() == null ||
        visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit.reason: NULL!");
        }

        return super.save(visit);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
