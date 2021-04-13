package dev.enterprise.Flashcard.service;

import dev.enterprise.Flashcard.controller.QuestionAndAnswerController;
import dev.enterprise.Flashcard.model.Participant;
import dev.enterprise.Flashcard.model.QuestionAndAnswer;
import dev.enterprise.Flashcard.model.ReferenceLink;
import dev.enterprise.Flashcard.model.Topic;
import dev.enterprise.Flashcard.repository.ParticipantRepository;
import dev.enterprise.Flashcard.repository.QuestionAndAnswerRepository;
import dev.enterprise.Flashcard.repository.ReferenceLinkRepository;
import dev.enterprise.Flashcard.repository.TopicRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistenceService {

    @Autowired
    private QuestionAndAnswerRepository questionRepo;

    @Autowired
    private TopicRepository topicRepo;

    @Autowired
    private ReferenceLinkRepository referenceRepo;

    @Autowired
    private ParticipantRepository participantRepo;

    public QuestionAndAnswer updateQuestion(QuestionAndAnswer q){
        QuestionAndAnswer question = questionRepo.findByQuestion(q.getQuestion());
        Topic topic = null;
        if(q.getTopic() != null) {
            topic = topicRepo.findByTopic(q.getTopic().getTopic());
        }
        Participant p = null;
        if(q.getResponsible() != null){
            p = participantRepo.findByName(q.getResponsible().getName());
        }
        ReferenceLink rl = null;
        if(q.getReferenceLink() != null ){
            rl = referenceRepo.findByAddress(q.getReferenceLink().getAddress());
        }
        question.setQuestion(q.getQuestion());
        question.setAnswer(q.getAnswer());
        question.setResponsible(p);
        question.setTopic(topic);
        question.setReferenceLink(rl);
        return question;

    }

}
