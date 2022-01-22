package tn.sahbi.akram.petclinic.model.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import tn.sahbi.akram.petclinic.model.Owner;
import tn.sahbi.akram.petclinic.model.services.PetService;
import tn.sahbi.akram.petclinic.model.services.PetTypeService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;
    @Mock
    private PetTypeService petTypeService;
    @Mock
    private PetService petService;
    private Owner owner;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(petTypeService, petService);
        owner = new Owner();
        owner.setId(1L);
        owner.setLastName("sahbi");
        owner.setFirstName("akram");

    }

    @Test
    @Order(1)
    void save() {
        ownerMapService.save(owner);
        assertEquals(owner.getFirstName(), ownerMapService.findById(1L).getFirstName());
    }

    @Order(2)
    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }



    @Order(3)
    @Test
    void findByLastName() {
        ownerMapService.save(owner);
        Owner actualOwner = ownerMapService.findByLastName("sahbi");
        System.out.println(actualOwner);
        assertEquals("akram", actualOwner.getFirstName());
    }

    @Order(4)
    @Test
    void delete() {
        ownerMapService.save(owner);
        ownerMapService.delete(owner);
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(0, owners.size());
    }
}
