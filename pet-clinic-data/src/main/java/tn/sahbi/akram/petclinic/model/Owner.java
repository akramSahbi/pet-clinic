package tn.sahbi.akram.petclinic.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
@Getter
@Setter
@NoArgsConstructor

public class Owner extends Person {
    private String address;
    private String city;
    private String phone;

    @Builder
    public Owner(String firstName, String lastName, String address, String city, String phone, Set<Pet> pets) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.pets = pets;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
}
