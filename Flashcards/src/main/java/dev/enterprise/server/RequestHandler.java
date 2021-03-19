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

    public void handle() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Map<String, String> headers = new HashMap<>();
        String method;
        String uri;
        String httpVersion;
        String body = "";

        String line = in.readLine();
        System.out.println(line);
        String[] firstLine = line.split(" ");
        method = firstLine[0];
        uri = firstLine[1];
        httpVersion = firstLine[2];

        while(!(line = in.readLine()).equals("")){
            System.out.println("still in the while");
            // logic for getting headers
            String [] header = line.split(": ");
            headers.put(header[0], header[1]);
        }
        System.out.println(headers.get("Content-Length"));
        int amount = 0;
        // logic for getting the body info
        while((line = in.readLine()) != null){
            if(line.equals("")){
                break;
            }
            System.out.println("still in the body while");
            body += line;
        }


        System.out.println(headers);
        System.out.println(body);
        in.close();

        out.write("We have your request, and are holding it hostage");
        out.flush();

//
//        while((line = in.readLine()) != null){
//            System.out.println(line);
//            if(line.equals("")){
//                System.out.println("stream is done");
//                break;
//            }
//        }
//        System.out.println(headers.get("Content-Length"));
//        while(in.ready() && (line = in.readLine()) != null){
//            if(line.length() == 0){
//                break;
//            }
//            System.out.println(line);
//            System.out.println("another line read");
//        }

    }
}
