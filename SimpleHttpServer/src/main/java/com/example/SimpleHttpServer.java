package com.example;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer {
    private static final  Logger logger = LoggerFactory.getLogger(SimpleHttpServer.class);

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create( new InetSocketAddress("0.0.0.0", 8080), 100);
        server.createContext("/api", new HttpRequestHandler());
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores * 2);
        server.setExecutor(executor);
        server.start();
        logger.info("Server is running on port 8080");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Server is stopping...");
            server.stop(5);
            executor.shutdown();
            logger.info("Server is stopped");
        }));

    }
}