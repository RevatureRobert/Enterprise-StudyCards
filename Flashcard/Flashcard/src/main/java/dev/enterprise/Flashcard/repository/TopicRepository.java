package dev.enterprise.Flashcard.repository;

import dev.enterprise.Flashcard.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    Topic findByTopic(String topic);
}
