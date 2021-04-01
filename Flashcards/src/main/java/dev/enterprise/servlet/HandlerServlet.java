package dev.enterprise.servlet;

import dev.enterprise.controller.FrontController;
import dev.enterprise.controller.Handler;
import dev.enterprise.controller.SingleQuestionByIdController;
import dev.enterprise.repo.QandADao;
import dev.enterprise.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"*.json"})
public class HandlerServlet extends HttpServlet {

    Handler handler;
    FrontController controller;

    public HandlerServlet(Handler handler) {
        this.handler = handler;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller = handler.route(req, resp);
        if(controller != null){
            controller.handle(req, resp);
        } else {

        }
    }
}
