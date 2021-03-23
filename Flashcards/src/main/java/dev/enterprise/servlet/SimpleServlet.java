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

        resp.addHeader("Content-Type","text/plain");
        System.out.println(request.getBody());

        resp.getWriter().println("HTTP/1.1 200 OK");
        for(String s : resp.getHeaderNames()){
            resp.getWriter().println(s + ": " + resp.getHeader(s));
        }
        resp.getWriter().println();

        if(request.getBody() == null){
            resp.getWriter().println("The body was not in sufficient format");
            resp.getWriter().flush();
            return;
        }


        Gson gson = new Gson();
        HashMap<String, String> jsonBodyContent = gson.fromJson(request.getBody(), HashMap.class);



        try {
            Topic topic = Topic.valueOf(jsonBodyContent.get("topic"));
            QandA question = new QandA(jsonBodyContent.get("id"), topic);
            QuestionService qs = new QuestionService(new QandADao());
            qs.save(question);
            resp.getWriter().println("The post was successful");
            resp.getWriter().flush();
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resp.getWriter().println("something went wrong");
            resp.getWriter().flush();
        }
    }
}
