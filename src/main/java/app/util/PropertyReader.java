package app.util;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {

    public static String getProperty(String nameParam) throws IOException {
        Properties properties = new Properties();
        File fileProperties = new File(Objects.requireNonNull(PropertyReader.class.getClassLoader().getResource("properties")).getFile());
        //File file = new File("C:\\IdeaProjects\\PP01\\src\\main\\resources\\properties");
        properties.load(new FileReader(fileProperties));
        return properties.getProperty(nameParam);
    }
}
