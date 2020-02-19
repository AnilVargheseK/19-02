
package com.util.notisfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    
     private static final Properties properties = new Properties();

    private PropertiesLoader() {
    }

    public static void initialise() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesInputStream = null;
        try {
            propertiesInputStream = classLoader.getResourceAsStream("notis_properties.properties");  
            System.out.println(propertiesInputStream+"   <--------");
//            properties.load(new FileInputStream("notis_properties.properties")); 
            properties.load(propertiesInputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (propertiesInputStream != null) {
                propertiesInputStream.close();
            }
        }
    }

    public static String getProperty(String key) throws IOException {
        PropertiesLoader.initialise();
        return properties.getProperty(key);
    }
    
}
