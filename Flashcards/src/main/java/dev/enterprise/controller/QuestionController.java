package dev.enterprise.controller;

import com.google.gson.Gson;
import dev.enterprise.model.QandA;
import dev.enterprise.model.Topic;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionController {

    public void getQuestion(HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        QandA q = new QandA();
        q.setQuestion("Here is a booger of a question");
        q.setTopic(Topic.JAVA);
        res.getWriter().println(new Gson().toJson(q));
    }
}
