package dev.enterprise;

import dev.enterprise.model.QandA;
import dev.enterprise.repo.QandADao;
import dev.enterprise.server.FlashcardServer;
import dev.enterprise.server.RequestHandler;
import dev.enterprise.service.QuestionService;
import dev.enterprise.util.ApplicationUtil;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import java.net.Socket;

public class Driver {


    public static void main(String[] args) throws IOException {

        FlashcardServer server = new FlashcardServer(9999);
        server.start();
        server.start();

//        ServerSocket server = new ServerSocket();
////
////        System.out.println("waiting on a connection attempt");
////
//////        server.accept();  //  it is blocking the stack waiting for a connection
//        server.bind(new InetSocketAddress(9999), 2);
////
//        Socket s = server.accept();
////
////        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
//////        DataInputStream in = new DataInputStream(s.getInputStream());
//////        OutputStream out = s.getOutputStream();
//////        out.write(54);
//////        out.flush();
////        String line = "";
////        while((line = in.readLine()) != null){
////            System.out.println(line);
////        }
//////        server.accept();
////
////        System.out.println("connection attempt successful");
//
//
////
////        QuestionService qs = new QuestionService(new QandADao());
////        Future<QandA> f = qs.getById(4);
////
////        Future<Integer> f2 = qs.save(new QandA());
////
////        ApplicationUtil.INSTANCE.getThreadActivatah().shutdownNow();
//
//
//        RequestHandler req = new RequestHandler(s);
//
//        req.handle();

    }
}

class Headers implements Enumeration<String> {

    private String[] elements;
    private int index;

    public Headers(String... elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasMoreElements() {
        return this.index == elements.length-1;
    }

    @Override
    public String nextElement() {
        return elements[index++];
    }
}
