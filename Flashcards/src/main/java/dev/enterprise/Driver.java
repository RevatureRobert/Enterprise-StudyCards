package dev.enterprise;

import dev.enterprise.model.QandA;
import dev.enterprise.repo.QandADao;
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


    public static void main(String[] args) throws SQLException, ExecutionException, InterruptedException, IOException {
        ServerSocket server = new ServerSocket();
//
//        System.out.println("waiting on a connection attempt");
//
////        server.accept();  //  it is blocking the stack waiting for a connection
        server.bind(new InetSocketAddress(9999), 2);
//
        Socket s = server.accept();




        RequestHandler req = new RequestHandler(s);

        req.handle();
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
