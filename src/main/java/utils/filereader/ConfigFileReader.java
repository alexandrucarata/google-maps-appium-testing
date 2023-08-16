package utils.filereader;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigFileReader {
    private static final String PROPERTY_FILE_PATH = "src/main/resources/config.properties";

    @SneakyThrows
    public static String getProperty(String name) {
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream(PROPERTY_FILE_PATH), StandardCharsets.UTF_8));
        return properties.getProperty(name);
    }
}
