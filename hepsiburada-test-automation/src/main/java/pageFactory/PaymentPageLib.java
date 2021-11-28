package pageFactory;

import genericLib.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PaymentPageLib {

    @FindBy(id="continue_step_btn")
    private WebElement continueStepButton;

    @FindBy(xpath="//*[text()='Anında Havale']")
    private WebElement instantRemittanceButton;

    @FindBy(xpath="//*[text()='Ödeme yöntemleri']")
    private WebElement payMethod;

    @FindBy(css=".sardesPaymentPage-Accordion-accordion_tab .sardesPaymentPage-MoneyTransfer-bank_name")
    private List<WebElement> saleMethodBankNames;

    public WebElement getContinueStepButton() {
        return continueStepButton;
    }

    public WebElement getInstantRemittanceButton() {
        return instantRemittanceButton;
    }

    public WebElement getPayMethod() {
        return payMethod;
    }

    public List<WebElement> getSaleMethodBankNames() {
        return saleMethodBankNames;
    }

    public String selectPaymentMethodAndGetName(){
        Utils.waitForElementLoad(getPayMethod());
        if (getInstantRemittanceButton().isDisplayed()) {
            getInstantRemittanceButton().click();
            getSaleMethodBankNames().get(0).click();
        }
        String salesMethodBankName = getSaleMethodBankNames().get(0).getText();
        getContinueStepButton().click();
        return salesMethodBankName;
    }
}
