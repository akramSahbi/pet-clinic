package tn.sahbi.akram.petclinic.model.services;

import tn.sahbi.akram.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
