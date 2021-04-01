package dev.enterprise.controller;

import dev.enterprise.repo.QandADao;
import dev.enterprise.service.QuestionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Handler {
    QuestionController questionController;
    SingleQuestionByIdController sqbiController;
    SessionController sessionController;
    BlandController bland;

    public Handler(QuestionController questionController,
                   SingleQuestionByIdController sqbiController,
                   SessionController sessionController,
                   BlandController bland) {
        this.questionController = questionController;
        this.sqbiController = sqbiController;
        this.sessionController = sessionController;
        this.bland = bland;
    }

    public FrontController route(HttpServletRequest req, HttpServletResponse res) {
        switch (req.getRequestURI()) {
            case "/Flashcards/question.json":
                return sqbiController;
            case "/Flashcards/something.json":
                return sqbiController;
        }
        return null;
    }
}
