package dev.enterprise;

import dev.enterprise.server.FlashcardServer;

import java.io.IOException;

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
