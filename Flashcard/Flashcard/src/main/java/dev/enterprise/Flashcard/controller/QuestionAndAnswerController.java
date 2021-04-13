package dev.enterprise.Flashcard.controller;

import dev.enterprise.Flashcard.model.QuestionAndAnswer;
import dev.enterprise.Flashcard.repository.QuestionAndAnswerRepository;
import dev.enterprise.Flashcard.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionAndAnswerController {

    @Autowired
    private QuestionAndAnswerRepository repo;

    @Autowired
    private PersistenceService service;

    @GetMapping
    public List<QuestionAndAnswer> getAllQuestions(
            @RequestParam(value = "question", defaultValue = "", required = false) String question,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "offset", required = false, defaultValue = "50") int offset)
    {
        if (question == null || question.equals("")) {
            return repo.findAll(PageRequest.of(page, offset, Sort.by("id"))).toList();
        } else {
            List<QuestionAndAnswer> questions = new LinkedList<>();
            questions.add(repo.findByQuestion(question));
            return questions;
        }
    }

    @PostMapping
    public QuestionAndAnswer saveQuestionAndAnswer(@RequestBody QuestionAndAnswer q) {
        return repo.save(q);
    }

    @PutMapping
    public QuestionAndAnswer updateQuestionAndAnswer(@RequestBody QuestionAndAnswer q) {
        return service.updateQuestion(q);
    }

    @GetMapping("/{topic}")
    public List<QuestionAndAnswer> findAllByTopic(
            @PathVariable("topic") String topic,
            @RequestParam(value = "page",defaultValue = "0", required = false) int page,
            @RequestParam(value = "offset", defaultValue = "25", required = false) int offset){
        return repo.findAllByTopic(topic, PageRequest.of(page, offset));
    }

    @GetMapping("/answered")
    public List<QuestionAndAnswer> findAllAnswered(@RequestParam(value = "page",defaultValue = "0", required = false) int page,
                                                   @RequestParam(value = "offset", defaultValue = "25", required = false) int offset,
                                                   @RequestParam(value = "topic", required = false) String topic){
        if(topic == null) {
            return repo.findAllByReferenceLinkNotNull(PageRequest.of(page, offset));
        } else {
            return repo.findAllByReferenceLinkNotNullAndTopicName(topic, PageRequest.of(page, offset));
        }
    }
}
