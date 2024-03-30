package com.example.httpserver.config;

import com.example.httpserver.util.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private static Configuration currentConfiguration;

    private ConfigurationManager() {

    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void loadConfigurationFile(String filePath) {
        FileReader reader = null;
        try {
            reader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new HttpConfigurationException(e);
        }

        currentConfiguration = Json.fromJson(reader, Configuration.class);
    }

    public Configuration getCurrentConfiguration() {
        if (currentConfiguration == null) {
            throw new HttpConfigurationException("No current configuration Set.");
        }
        return currentConfiguration;
    }
}
