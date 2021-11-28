package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryPageLib {
    @FindBy(css=".modal_bank_details_lfXb9 > .detail_20j8y:nth-child(1) > span:nth-child(2)")
    private WebElement orderSummaryBankName;

    public WebElement getOrderSummaryBankName() {
        return orderSummaryBankName;
    }

    public String getSelectedBankName(){
        return getOrderSummaryBankName().getText();
    }
}
