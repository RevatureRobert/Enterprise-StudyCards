package dev.enterprise.servlet;

import dev.enterprise.controller.SessionController;
import sun.security.krb5.internal.KDCOptions;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.AffineTransformOp;
import java.io.IOException;

//@WebServlet(name = "session",
//        urlPatterns = {"/session", "/happy", "*.sess", "*.session"},
//        loadOnStartup = 1,
//        initParams =
//            @WebInitParam(
//                    name = "hello",
//                    value = "servlet world",
//                    description = "This is just an example of providing " +
//                            "initialization parameters to a servlet."))
@WebServlet(urlPatterns = "/session")
public class SessionServlet extends HttpServlet {

//    public SessionServlet() {
//        System.out.println("constructor");
//    }
//
//    @Override
//    public void init() throws ServletException {
////        System.out.println(this.getInitParameter("hello"));
////        System.out.println(this.getInitParameterNames().nextElement());
////        System.out.println(this.getServletContext().getInitParameter("global"));
////        System.out.println("init");
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("service");
//    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new SessionController().createSession(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new SessionController().printSessionAttribute(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new SessionController().endSession(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("welcome.html").forward(req, resp);
    }
}
