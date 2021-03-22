package dev.enterprise.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

public class Response {

    private PrintWriter out;
    private HashMap<String, String> headers;
    private String body;


    public Response(OutputStream o){
        out = new PrintWriter(o);
    }

    public void send(){

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
