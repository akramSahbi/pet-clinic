package tn.sahbi.akram.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.sahbi.akram.petclinic.model.*;
import tn.sahbi.akram.petclinic.model.services.OwnerService;
import tn.sahbi.akram.petclinic.model.services.PetTypeService;
import tn.sahbi.akram.petclinic.model.services.SpecialtiesService;
import tn.sahbi.akram.petclinic.model.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService) {
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
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
        owner1.setAddress("borj louzir");
        owner1.setCity("ariana");
        owner1.setPhone("28744783");

        Pet bissa = new Pet();
        bissa.setPetType(cat);
        bissa.setOwner(owner1);
        bissa.setName("Bissa");
        bissa.setBirthdate(LocalDate.of(2019, 2, 15));
        owner1.getPets().add(bissa);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("monia");
        owner2.setLastName("bousselmi");
        owner2.setAddress("borj louzir");
        owner2.setCity("ariana");
        owner2.setPhone("20747198");

        Pet riki = new Pet();
        riki.setPetType(dog);
        riki.setOwner(owner2);
        riki.setName("Riky");
        riki.setBirthdate(LocalDate.of(1990, 2, 15));
        owner2.getPets().add(riki);

        ownerService.save(owner2);

        System.out.println("------------------Loaded owners!------------------");

        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        radiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        surgery = specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        dentistry = specialtiesService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("nihed");
        vet1.setLastName("mosbeh");
        vet1.getSpecialties().add(radiology);
        vet1.getSpecialties().add(surgery);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("rim");
        vet2.setLastName("selmi");
        vet2.getSpecialties().add(dentistry);
        vetService.save(vet2);

        System.out.println("------------------Loaded vets!------------------");
    }
}
