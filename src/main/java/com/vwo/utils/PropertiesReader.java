package com.vwo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {


    public static String readKey(String key) {
        FileInputStream fileInputStream;
        Properties p = new Properties();

        {
            try {
                fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties");
                p.load(fileInputStream);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return p.getProperty(key);
    }
}





