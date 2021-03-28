package tn.sahbi.akram.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.sahbi.akram.petclinic.model.Owner;
import tn.sahbi.akram.petclinic.model.PetType;
import tn.sahbi.akram.petclinic.model.Vet;
import tn.sahbi.akram.petclinic.model.services.OwnerService;
import tn.sahbi.akram.petclinic.model.services.PetTypeService;
import tn.sahbi.akram.petclinic.model.services.VetService;
import tn.sahbi.akram.petclinic.model.services.map.OwnerMapService;
import tn.sahbi.akram.petclinic.model.services.map.VetMapService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
        this.vetService = vetService;

    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("dog");
        dog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        cat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("akram");
        owner1.setLastName("sahbi");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("monia");
        owner2.setLastName("bousselmi");
        ownerService.save(owner2);

        System.out.println("------------------Loaded owners!------------------");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("nihed");
        vet1.setLastName("mosbeh");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("rim");
        vet2.setLastName("selmi");
        vetService.save(vet2);

        System.out.println("------------------Loaded vets!------------------");
    }
}
