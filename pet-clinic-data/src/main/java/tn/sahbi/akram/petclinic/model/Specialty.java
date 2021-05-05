package tn.sahbi.akram.petclinic.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Specialty extends BaseEntity {
    private String description;
}
