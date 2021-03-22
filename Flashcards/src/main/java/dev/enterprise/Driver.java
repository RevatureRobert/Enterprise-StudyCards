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

/**
 * The entry point for the application to start the server.
 */
public class Driver {


    public static void main(String[] args) throws IOException, InterruptedException {

        FlashcardServer server = new FlashcardServer(9999);
        server.start();
        server.stop();

    }
}
