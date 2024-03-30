package com.example.httpserver;

import com.example.httpserver.config.Configuration;
import com.example.httpserver.config.ConfigurationManager;
import com.example.httpserver.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class HttpServer {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

    public static void main(String[] args) {
        LOGGER.info("Server stating...");

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        configurationManager.loadConfigurationFile("src/main/resources/http.json");

        Configuration configuration = configurationManager.getCurrentConfiguration();

        LOGGER.info("Using Port: " + configuration.getPort());
        LOGGER.info("Using WebRoot: " + configuration.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(configuration.getPort(), configuration.getWebroot());
            serverListenerThread.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
