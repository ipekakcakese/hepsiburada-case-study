package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLib {

    @FindBy(xpath="//*[@id=\"txtUserName\"]")
    private WebElement emailAddress;

    @FindBy(xpath="//*[@id=\"txtPassword\"]")
    private WebElement password;

    @FindBy(xpath="//*[@id=\"btnLogin\"]")
    private WebElement loginButtonEmail;

    @FindBy(xpath="//*[@id=\"btnEmailSelect\"]")
    private WebElement loginButtonPassword;
    private String URL = "https://www.hepsiburada.com/uyelik/giris";



    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButtonEmail() {
        return loginButtonEmail;
    }

    public WebElement getLoginButtonPassword() {
        return loginButtonPassword;
    }

    public String getURL() {
        return URL;
    }
}
