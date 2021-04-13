package dev.enterprise.Flashcard.controller;

import dev.enterprise.Flashcard.model.Topic;
import dev.enterprise.Flashcard.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepository repo;


    @GetMapping
    public List<Topic> getAllTopics(){return repo.findAll();}

    @PostMapping
    public Topic saveTopic(@RequestBody Topic topic){
        return repo.save(topic);
    }
}
