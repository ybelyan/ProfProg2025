package com.example;

import java.util.Arrays;

public class SessionData {
    private final String sessionId;
    private final String clientAddress;
    private final byte[] analyticsData;
    private final long timestamp;

    public SessionData(String sessionId, String clientAddress) {
        this.sessionId = sessionId;
        this.clientAddress = clientAddress;
        this.analyticsData = new byte[1024*1024];
        Arrays.fill(analyticsData, (byte)sessionId.hashCode());
        this.timestamp = System.currentTimeMillis();
    }
}
