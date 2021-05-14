package tn.sahbi.akram.petclinic.model.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.sahbi.akram.petclinic.model.Owner;
import tn.sahbi.akram.petclinic.model.repositories.OwnerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnersSpringDataJpaServiceTest {
    public static final String SAHBI = "sahbi";
    @Mock
    private OwnerRepository ownerRepository;
    @InjectMocks
    private OwnersSpringDataJpaService ownersSpringDataJpaService;

    private final Long OWNER_ID = 1L;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findById() {
        when(ownerRepository.findById(OWNER_ID)).thenReturn(Optional.of(getOwner()));
        Owner actualOwner = ownersSpringDataJpaService.findById(OWNER_ID);
        assertEquals(getOwner().getId(), actualOwner.getId());
    }

    @Test
    void save() {
        Owner actualOwner = ownersSpringDataJpaService.save(getOwner());
        verify(ownerRepository).save(any());
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(Set.of(getOwner()));
        Set<Owner> actualOwners = ownersSpringDataJpaService.findAll();
        assertEquals(1, actualOwners.size());
    }

    @Test
    void delete() {
        ownersSpringDataJpaService.delete(getOwner());
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownersSpringDataJpaService.deleteById(OWNER_ID);
        verify(ownerRepository).deleteById(any());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(SAHBI)).thenReturn(Optional.of(getOwner()));
        Owner actualOwner = ownersSpringDataJpaService.findByLastName(SAHBI);
        assertEquals(getOwner().getId(), actualOwner.getId());
    }

    private Owner getOwner() {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName(SAHBI);
        owner.setFirstName("akram");
        return owner;
    }
}