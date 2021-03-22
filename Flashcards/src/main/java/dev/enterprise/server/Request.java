package dev.enterprise.server;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Request {

    private BufferedReader in;
    private InputStream rawInput;
    private String body;
    private String method;
    private String uri;
    private HashMap<String, String> headers;

    public Request(InputStream i) {
        headers = new HashMap<>();
        rawInput = i;
        this.in = new BufferedReader(new InputStreamReader(i));
        try {
            parse();
        } catch (IOException e) {
            System.err.println("the request could not be built, the error message is: " + e.getMessage());
        }
    }

    private void parse() throws IOException {

        String line = in.readLine();
        String[] firstLine = line.split(" ");
        method = firstLine[0];
        uri = firstLine[1];

        // logic for getting headers
        while (!(line = in.readLine()).equals("")) {
            String[] header = line.split(": ");
            headers.put(header[0], header[1]);
        }


        // logic for getting the body info
        while (rawInput.available() != 0) {
            line = in.readLine();
            body += line;
        }
    }

    public String getBody() {
        return body;
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }
}
