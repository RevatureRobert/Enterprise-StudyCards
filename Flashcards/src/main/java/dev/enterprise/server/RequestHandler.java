package dev.enterprise.server;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.Socket;

/**
 * This class will take the socket from the FlashcardServer and run the needed logic.
 *      This will construct a Request and Response, given the socket, and find the
 *      Servlet associated with that uri and call the corresponding servlet method to the
 *      request method.
 */
public class RequestHandler {

    /**
     * The socket to be stored with the Handler, this is essentially where we store
     *      the session of the request. This RequestHandler object will have access
     *      to and the context of the request and response lifecycle.
     */
    private Socket socket;

    public RequestHandler(Socket socket){
        this.socket = socket;
    }

    /**
     * The method to actually perform the logic of the Handler. This will
     *      construct the request object, construct the response object,
     *      find the servlet, and call the servlets method with the information
     *      from the socket.
     */
    public void handle() {

        // build the request with the sockets input stream
        // create a response with the sockets output stream
        // determine the correct controller to handle the logic and send the
        //      request and response to it for handling

        // TODO: implement the HttpServletResponse in the FlashcardResponse class
        // TODO: extend the HttpServlet class in the SimpleServlet class
        // TODO: register the servlet with the application
        // TODO: fix the bugs
        // TODO: connect the controller to the service layer to gather information
        //      from the db and send it back to the client in json format.

        try {
            HttpServletRequest req = new FlashcardRequest(socket.getInputStream());
            HttpServletResponse res = new FlashcardResponse(socket.getOutputStream());
            HttpServlet servlet = ServletUtil.getServlet(req.getRequestURI());
            ServletUtil.invoke(servlet, req, res, HttpMethodNames.valueOf(req.getMethod()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
