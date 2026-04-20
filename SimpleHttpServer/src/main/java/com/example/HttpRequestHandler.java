package com.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class HttpRequestHandler implements HttpHandler {
    private static final Map<String, SessionData> cachedSessions  = new LinkedHashMap<>(50) {
        @Override
        public boolean removeEldestEntry(Map.Entry<String, SessionData> eldest) {
            return size() > 50;
        }
    };
    private static final AtomicLong requestCounter = new AtomicLong(0);
    private static final Logger logger = LoggerFactory.getLogger(HttpRequestHandler.class);

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        long requestId = requestCounter.incrementAndGet();
        String sessionId = "session-" + requestId;
        SessionData sessionData = new SessionData(sessionId, exchange.getRemoteAddress().toString());
        cachedSessions.put(sessionId, sessionData);

        logger.debug("Request # {}, sessions cache size {}", requestId, cachedSessions.size());

        String response = String.format("Request# %s counted. Total session: %d", requestId, cachedSessions.size());
        exchange.sendResponseHeaders(200, response.length());
        try(OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
