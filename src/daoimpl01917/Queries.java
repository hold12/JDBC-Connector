package daoimpl01917;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.text.MessageFormat;

/**
 * Created by awo on 25/04/17.
 */
public class Queries {
    public static String getSQL(String propertyName) {
        File file = new File("resources/sql.properties");
        FileInputStream fileInputStream;
        Properties properties = null;

        try {
            fileInputStream = new FileInputStream(file);

            properties = new Properties();
            properties.load(fileInputStream);

            fileInputStream.close();
        } catch (IOException e) {
            System.err.println("Could read file \"resources/sql.properties\".");
        }

        return properties.getProperty(propertyName);
    }

    public static String getFormatted(String propertyName, String... args) {
        return MessageFormat.format(getSQL(propertyName), args);
    }
}
