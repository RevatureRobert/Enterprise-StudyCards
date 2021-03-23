package dev.enterprise.controller;

import dev.enterprise.server.FlashcardRequest;
import dev.enterprise.server.FlashcardResponse;

import java.io.PrintWriter;
import java.util.HashMap;
@Deprecated
/**
 * An example of a controller. The application logic dealing with
 *      the read operations of the request and the mutation of the
 *      response should happen here.
 */
public class BlandController {

    public void blandGet(FlashcardRequest req, FlashcardResponse res){
        PrintWriter out = res.getOutputWriter();
        String body = res.getBody();
        HashMap<String, String> headers = res.getHeaders();

        body = "{\"name\":\"gerald\", \"age\":15}";
        headers.put("Content-Type","application/json");

        out.println("HTTP/1.1 200 OK");
        out.println("Content-Length: "+ body.length());
        for (String headerName : headers.keySet()) {
            out.println(headerName + ": " + headers.get(headerName));
        }
        out.println();
        out.println(body);
        out.flush();
    }
}
