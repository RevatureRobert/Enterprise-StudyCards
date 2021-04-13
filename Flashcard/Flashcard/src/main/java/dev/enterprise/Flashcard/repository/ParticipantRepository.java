package dev.enterprise.Flashcard.repository;

import dev.enterprise.Flashcard.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ParticipantRepository extends JpaRepository<Participant, Integer> {

    Participant findByName(String name);
}
