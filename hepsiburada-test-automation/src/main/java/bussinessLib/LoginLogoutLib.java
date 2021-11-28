package bussinessLib;

import genericLib.Driver;
import genericLib.Utils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageFactory.LoginPageLib;

public class LoginLogoutLib {
    public static void LoginToApp(String emailAddress, String password){

        try {
            LoginPageLib loginPageObj = PageFactory.initElements(Driver.driver, LoginPageLib.class);

            loginPageObj.getEmailAddress().clear();
            loginPageObj.getEmailAddress().sendKeys(emailAddress);
            loginPageObj.getLoginButtonEmail().click();
            Utils.waitForPageToLoad(5);
            loginPageObj.getPassword().clear();
            loginPageObj.getPassword().sendKeys(password);
            loginPageObj.getLoginButtonPassword().click();

        } catch (Exception e) {
            Assert.fail(e.toString());
        }

    }

}
