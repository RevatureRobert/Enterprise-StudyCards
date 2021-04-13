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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "question")}, name = "q_and_a")
public class QuestionAndAnswer {

    @Id
    @GeneratedValue(generator = "q_and_a_id_seq")
    private int id;

    @NotNull
    private String question;

    private String answer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reference_link")
    private ReferenceLink referenceLink;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "responsible")
    private Participant responsible;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topic")
    private Topic topic;
}
