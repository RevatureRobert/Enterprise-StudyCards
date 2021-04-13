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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "topic")})
public class Topic {

    @Id
    @GeneratedValue(generator = "topic_id_seq")
    private int id;
    @NotNull
    private String topic;
}
