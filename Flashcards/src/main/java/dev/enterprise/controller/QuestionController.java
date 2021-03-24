package dev.enterprise.controller;

import com.google.gson.Gson;
import dev.enterprise.model.QandA;
import dev.enterprise.model.Topic;
import dev.enterprise.service.QuestionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionController {

    QuestionService qs;

    public QuestionController(QuestionService qs) {
        this.qs = qs;
    }

    public void getQuestion(HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        QandA q = new QandA();
        q.setQuestion("Here is a booger of a question");
        q.setTopic(Topic.JAVA);
        res.getWriter().println(new Gson().toJson(q));
    }

    public void findQuestionById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        resp.setContentType("application/json");
        QandA q = qs.getById(id);
        Gson gson = new Gson();
        resp.getWriter().println(gson.toJson(q));
    }
}
