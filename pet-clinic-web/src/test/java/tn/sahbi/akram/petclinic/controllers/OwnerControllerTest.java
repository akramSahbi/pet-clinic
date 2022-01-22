package tn.sahbi.akram.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.sahbi.akram.petclinic.model.Owner;
import tn.sahbi.akram.petclinic.model.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    private OwnerService ownerService;
    @InjectMocks
    private OwnerController ownerController;
    private MockMvc mockMvc;

    private Set<Owner> owners;


    @BeforeEach
    void setUp() {
        owners = getOwners();
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));

    }

    private Set<Owner> getOwners() {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("akram");
        owner1.setLastName("sahbi");
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("nihed");
        owner2.setLastName("mosbeh");
        Set<Owner> ownersSet = new HashSet<>();
        ownersSet.add(owner1);
        ownersSet.add(owner2);
        return ownersSet;
    }
}
