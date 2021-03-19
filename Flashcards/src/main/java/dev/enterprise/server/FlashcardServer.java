package dev.enterprise.server;

import dev.enterprise.util.ApplicationUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class FlashcardServer {

    private int port;
    ServerSocket serverSocket;
    private boolean running;
    ApplicationUtil util;

    public FlashcardServer(int port) {
        this.port = port;

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        util = ApplicationUtil.INSTANCE;
    }


    public void stop() throws InterruptedException, IOException {
        running = false;
        serverSocket.close();
        util.getThreadActivatah().shutdown();
        util.getThreadActivatah().awaitTermination(5, TimeUnit.SECONDS);
        util.getThreadActivatah().shutdownNow();
    }

    public void start() throws IOException {
        while (running) {
            Socket socket = serverSocket.accept();
            // use thread here

        }
    }
}
