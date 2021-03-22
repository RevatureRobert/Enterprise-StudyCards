package dev.enterprise.server;

import dev.enterprise.util.ApplicationUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * This will be the entry point of the application. It works
 *      directly with the server socket to open a connection,
 *      utilize the thread pool for concurrent requests, perform
 *      request logic to send to the handler on another thread,
 *      and have the ability to perform the shutdown logic.
 */
public class FlashcardServer {

    /**
     * The port the server should run on and be listening on
     */
    private int port;
    ServerSocket serverSocket;

    /**
     * A boolean to determine whether the application should
     *      be running.
     */
    private boolean running = true;
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


    /**
     * Logic to shutdown the running application.
     * @throws InterruptedException
     * @throws IOException
     */
    public void stop() throws InterruptedException, IOException {
        running = false;
        serverSocket.close();
        util.getThreadActivatah().shutdown();
        util.getThreadActivatah().awaitTermination(5, TimeUnit.SECONDS);
        util.getThreadActivatah().shutdownNow();
    }

    /**
     * Logic to start the application and send the request to the handler
     *      on a different thread.
     * @throws IOException
     */
    public void start() throws IOException {
        while (running) {
            Socket socket = serverSocket.accept();
            // use thread here
            util.getThreadActivatah().execute(() -> new RequestHandler(socket).handle());
        }
    }
}
