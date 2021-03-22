package dev.enterprise.servlet;

import com.google.gson.Gson;
import dev.enterprise.model.QandA;
import dev.enterprise.model.Topic;
import dev.enterprise.repo.QandADao;
import dev.enterprise.server.FlashcardRequest;
import dev.enterprise.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * This implementation of a http servlet should call the controller and
 *      take care of any connection based configuration such as cors, security,
 *      headers, etc.
 */
public class SimpleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getContentType().equalsIgnoreCase("application/json"))
            throw new IllegalArgumentException("request must be in JSON format");

        if (!(req instanceof FlashcardRequest))
            throw new IllegalArgumentException("request is not an instance of FlashcardResponse");
        FlashcardRequest request = (FlashcardRequest) req;

        System.out.println(request.getBody());

        Gson gson = new Gson();
        HashMap<String, String> jsonBodyContent = gson.fromJson(request.getBody(), HashMap.class);

        try {
            Topic topic = Topic.valueOf(jsonBodyContent.get("topic"));
            QandA question = new QandA(jsonBodyContent.get("id"), topic);
            QuestionService qs = new QuestionService(new QandADao());
            qs.save(question);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
