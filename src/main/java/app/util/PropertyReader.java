package app.util;

import java.io.*;
import java.util.Properties;

public class PropertyReader {

    public static String getProperty(String nameParam) throws IOException {
        Properties properties = new Properties();
        File file = new File("C:\\IdeaProjects\\PP01\\src\\main\\resources\\properties");
        properties.load(new FileReader(file));
        return properties.getProperty(nameParam);
    }
}
