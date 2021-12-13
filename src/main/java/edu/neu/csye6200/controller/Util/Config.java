package edu.neu.csye6200.controller.Util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Singleton Config
 */
public class Config {
    private final Map<String, String> configuration = new HashMap<>();
    private static final Config instance = new Config();

    private Config() {
        String configFilename = "config.ini";

    }

    public static String get(String param) {
        Map<String, String> config = Config.getInstance().getConfiguration();
        if (!config.containsKey(param))
            throw new IllegalArgumentException("No such parameters");
        return config.get(param);
    }

    public static Config getInstance() {
        return instance;
    }

    public Map<String, String> getConfiguration() {
        return configuration;
    }

    public static void main(String[] args) {
        Config.get("hello");
    }
}
