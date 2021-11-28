package genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Utils {
    // waitForPageToLoad() method is used to implicitly wait for "generic" seconds
    public static void waitForPageToLoad(int second){
        Driver.driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }

    public static void waitForElementLoad(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void moveElement(WebDriver driver, WebElement webElement) throws InterruptedException {
        String browser = PropertiesFile.getBrowser();
        Actions actions = new Actions(driver);
        if (browser.equalsIgnoreCase("chrome"))
            actions.moveToElement(webElement).build().perform();
        else if (browser.equalsIgnoreCase("firefox")) {
            int x = webElement.getLocation().getX() + (webElement.getSize().getWidth() / 2);
            int y = webElement.getLocation().getY() + (webElement.getSize().getHeight() / 2);

            try {
                actions.moveByOffset(x, y).build().perform();
            } catch (MoveTargetOutOfBoundsException e) {
                actions.moveToElement(webElement).build().perform();
            }

            Thread.sleep(1000);
        }
    }
}
