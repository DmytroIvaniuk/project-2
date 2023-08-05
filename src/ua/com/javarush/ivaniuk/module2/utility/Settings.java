package ua.com.javarush.ivaniuk.module2.utility;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Settings {
    private HashMap<String, Integer> maxValues = new HashMap<>();
    private final String PROPERTIES_PATH = "resources/settings.properties";

    public Settings() {
        Properties properties = new Properties();
        try (FileInputStream fin = new FileInputStream(PROPERTIES_PATH)) {
            properties.load(fin);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла.");
        }
        for (String name : properties.stringPropertyNames()) {
            maxValues.put(name, Integer.parseInt(properties.getProperty(name)));
        }
    }

    public HashMap<String, Integer> getMaxValues() {
        return maxValues;
    }

    public int getIslandWidth() {
        return maxValues.get("islandWidth");
    }

    public int getIslandHeight() {
        return maxValues.get("islandHeight");
    }
}
