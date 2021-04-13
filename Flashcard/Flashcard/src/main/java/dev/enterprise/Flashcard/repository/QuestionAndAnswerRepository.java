package dev.enterprise.Flashcard.repository;

import dev.enterprise.Flashcard.model.QuestionAndAnswer;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionAndAnswerRepository extends JpaRepository<QuestionAndAnswer, Integer> {

    QuestionAndAnswer findByQuestion(String question);

    @Query("select q from QuestionAndAnswer q where lower(q.topic.topic) = lower(?1) order by id ")
    List<QuestionAndAnswer> findAllByTopic(String topicName, Pageable pagination);

    public List<QuestionAndAnswer> findAllByReferenceLinkNotNull(Pageable pagination);

    @Query("select q from QuestionAndAnswer q where lower(q.topic.topic) = lower(?1) and q.referenceLink is not null order by id")
    public List<QuestionAndAnswer> findAllByReferenceLinkNotNullAndTopicName(String topicName, Pageable pagination);
}
