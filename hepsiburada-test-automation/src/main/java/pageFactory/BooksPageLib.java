package pageFactory;

import genericLib.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BooksPageLib {
    @FindBy(css=".categoryBanner:nth-child(1) > a")
    private WebElement bestSellersButton;

    @FindBy(css =".search-item:nth-child(2)")
    private WebElement  productItemArea;

    @FindBy(css=".search-item:nth-child(2) .add-to-basket")
    private WebElement addToCardFirstBook;

    public WebElement getBestSellersButton() {
        return bestSellersButton;
    }

    public WebElement getProductItemArea() {
        return productItemArea;
    }

    public WebElement getAddToCardFirstBook() {
        return addToCardFirstBook;
    }
    public BooksPageLib isBooksPage() {
        Assert.assertTrue(bestSellersButton.isDisplayed(), "best seller button is not displayed on page");
        return this;
    }
    public void addToBasketBook(WebDriver driver) {
       isBooksPage();
        getBestSellersButton().click();
        try {
            Utils.moveElement(driver,getProductItemArea());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getAddToCardFirstBook().click();
    }
}
