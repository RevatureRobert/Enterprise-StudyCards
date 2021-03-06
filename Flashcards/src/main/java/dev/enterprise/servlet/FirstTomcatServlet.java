package dev.enterprise.servlet;

import dev.enterprise.controller.QuestionController;
import dev.enterprise.repo.QandADao;
import dev.enterprise.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstTomcatServlet extends HttpServlet {


    public FirstTomcatServlet() {
        System.out.println("constructor of first");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init in first");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().println("<h1>welcome to servlets</h1>");
        new QuestionController(new QuestionService(new QandADao())).getQuestion(resp);
    }
}
