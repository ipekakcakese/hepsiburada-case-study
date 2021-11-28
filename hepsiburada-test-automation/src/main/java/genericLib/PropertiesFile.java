package genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
    static Properties prop = new Properties();
    static String projectPath = System.getProperty("user.dir");

    public static void getProperties() {
        try {
            InputStream input = new FileInputStream(projectPath + "/src/test/resources/properties/config.properties");
            prop.load(input);
            String browser = prop.getProperty("browser");
            Driver.browserName = browser;
            System.out.println(browser);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    public static String getBrowser() {
        try {
            InputStream input = new FileInputStream(projectPath + "/src/test/resources/properties/config.properties");
            prop.load(input);
            return prop.getProperty("browser");
        } catch (Exception exp) {
            exp.printStackTrace();
            return "";
        }
    }

    public static void setProperties() {
        try {
            OutputStream output = new FileOutputStream(projectPath + "/src/test/resources/properties/config.properties");
            prop.setProperty("browser", "firefox");
            prop.store(output, "setting firefox");
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
