package dev.enterprise.Flashcard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "address")}, name = "reference_link")
public class ReferenceLink {

    @Id
    @GeneratedValue(generator = "reference_link_id_seq")
    private int id;

    @NotNull
    private String address;
}
