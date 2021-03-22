package dev.enterprise.server;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler {

    private Socket socket;

    public RequestHandler(Socket socket){
        this.socket = socket;
    }

    public void handle() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Map<String, String> headers = new HashMap<>();
            String method;
            String uri;
            String httpVersion;
            String body = "";
            String responseBody = "in the body now!!!";

            String line = in.readLine();
            System.out.println(line);
            String[] firstLine = line.split(" ");
            method = firstLine[0];
            uri = firstLine[1];
            httpVersion = firstLine[2];

            while (!(line = in.readLine()).equals("")) {
                System.out.println("still in the while");
                // logic for getting headers
                String[] header = line.split(": ");
                headers.put(header[0], header[1]);
            }
            System.out.println(headers.get("Content-Length"));
            int amount = 0;
            // logic for getting the body info
            while (socket.getInputStream().available() != 0) {
                line = in.readLine();
                if (line.equals("")) {
                    break;
                }
                System.out.println("still in the body while");
                body += line;
            }

            headers.remove("Content-Length");


            System.out.println(headers);
            System.out.println(body);
//        in.close();

            out.println(httpVersion + " 200 OK");
            out.println("Content-Length: "+ responseBody.length());
            for (String headerName : headers.keySet()) {
                out.println(headerName + ": " + headers.get(headerName));
            }
            out.println();
            out.println(responseBody);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
