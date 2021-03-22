package dev.enterprise.server;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

// implement HttpServletResponse

/**
 * This will model the Response being sent to the client. The
 *  *      Servlet api has an interface for doing so, the
 *  *      HttpServletResponse.
 */
public class FlashcardResponse {

    private PrintWriter outputWriter;
    private HashMap<String, String> headers;
    private String body = "";


    public FlashcardResponse(OutputStream o){
        outputWriter = new PrintWriter(o);
        headers = new HashMap<>();
    }

    public PrintWriter getOutputWriter() {
        return outputWriter;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
