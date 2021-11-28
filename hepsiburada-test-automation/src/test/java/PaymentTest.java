import bussinessLib.LoginLogoutLib;
import genericLib.Driver;
import genericLib.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageFactory.*;

import java.io.File;


public class PaymentTest {
    WebDriver driver = Driver.getDriver();
    LoginPageLib loginPageObj = PageFactory.initElements(driver, LoginPageLib.class);
    HomePageLib homePageObj = PageFactory.initElements(driver, HomePageLib.class);
    BasketPageLib basketPageLib = PageFactory.initElements(driver, BasketPageLib.class);
    BooksPageLib booksPageLib = PageFactory.initElements(driver, BooksPageLib.class);
    DeliveryPageLib deliveryPageLib = PageFactory.initElements(driver, DeliveryPageLib.class);
    PaymentPageLib paymentPageLib = PageFactory.initElements(driver,PaymentPageLib.class);
    SummaryPageLib summaryPageLib = PageFactory.initElements(driver, SummaryPageLib.class);


    @BeforeTest
    public void beforeTest() {
        driver.get(loginPageObj.getURL());
        driver.manage().window().maximize();
        Utils.waitForPageToLoad(10);
        LoginLogoutLib.LoginToApp("appipek@gmail.com", "Ia123456");
        Utils.waitForPageToLoad(10);
    }

    @Test
    public void instantRemittanceTest() {
        homePageObj.goToBooksPage(driver);
        booksPageLib.addToBasketBook(driver);
        homePageObj.goToBasketPage();
        basketPageLib.nextStep();
        deliveryPageLib.nextStep();
        String salesMethodBankName = paymentPageLib.selectPaymentMethodAndGetName();
        String orderSummaryBankName = summaryPageLib.getSelectedBankName();
        Assert.assertTrue(orderSummaryBankName.equals(salesMethodBankName));
 }

    @AfterMethod
    public void afterTest(ITestResult result) {
        if(ITestResult.FAILURE==result.getStatus()){
            try{
                // To create reference of TakesScreenshot
                TakesScreenshot screenshot=(TakesScreenshot)driver;
                // Call method to capture screenshot
                File src=screenshot.getScreenshotAs(OutputType.FILE);
                // Copy files to specific location
                // result.getName() will return name of test case so that screenshot name will be same as test case name
                String projectPath = System.getProperty("user.dir");
                FileUtils.copyFile(src, new File(projectPath+"\\src\\test\\resources\\screenshots\\" + result.getName() +".png"));
                System.out.println("Successfully captured a screenshot");
            }catch (Exception e){
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
        driver.quit();
    }

}
