package dev.enterprise.servlet;

import dev.enterprise.controller.QuestionController;
import dev.enterprise.repo.QandADao;
import dev.enterprise.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new QuestionController(new QuestionService(new QandADao())).findQuestionById(req, resp);

    }
}
