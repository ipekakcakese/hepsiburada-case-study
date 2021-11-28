package genericLib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    public static WebDriver driver = null;
    public static String browserName = null;
    public static WebDriver getDriver() {
        PropertiesFile.getProperties();
        if(browserName.equalsIgnoreCase("chrome")) {
            //initializing and starting the chrome browser
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }else if(browserName.equalsIgnoreCase("firefox")) {
            //initializing and starting the firefox browser
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        return driver;
    }
}
