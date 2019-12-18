package app.util;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {

    public static String getProperty(String nameParam) throws IOException {
        Properties properties = new Properties();
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("config.properties")).getPath();
        properties.load(new FileInputStream(rootPath));
        return properties.getProperty(nameParam);
    }
}
