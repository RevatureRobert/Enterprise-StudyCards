package dev.enterprise.controller;

import com.google.gson.Gson;
import dev.enterprise.model.QandA;
import dev.enterprise.service.QuestionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SingleQuestionByIdController extends FrontController{

    QuestionService qs;

    public SingleQuestionByIdController(QuestionService qs) {
        this.qs = qs;
    }


    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res) {
        int id = Integer.parseInt(req.getParameter("id"));
        res.setContentType("application/json");
        QandA q = qs.getById(id);
        Gson gson = new Gson();
        try {
            res.getWriter().println(gson.toJson(q));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
