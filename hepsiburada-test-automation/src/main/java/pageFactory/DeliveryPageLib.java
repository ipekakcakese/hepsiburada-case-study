package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryPageLib {
    @FindBy(id="continue_step_btn")
    private WebElement continueStepButton;


    public WebElement getContinueStepButton() {
        return continueStepButton;
    }

    public void nextStep(){
        getContinueStepButton().click();
    }
}
