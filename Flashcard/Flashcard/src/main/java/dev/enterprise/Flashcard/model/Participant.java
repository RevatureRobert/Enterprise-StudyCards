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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Participant {

    @Id
    @GeneratedValue(generator = "participant_id_seq")
    private int id;
    @NotNull
    private String name;

}
