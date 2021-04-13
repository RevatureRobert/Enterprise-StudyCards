package dev.enterprise.Flashcard.repository;

import dev.enterprise.Flashcard.model.ReferenceLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceLinkRepository extends JpaRepository<ReferenceLink, Integer> {

    ReferenceLink findByAddress(String address);
}
