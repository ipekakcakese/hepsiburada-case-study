package pageFactory;

import genericLib.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePageLib {
    @FindBy(css=".sf-MenuItems-1-U3X:nth-child(9)")
    private WebElement categoryBooksMenu;

    @FindBy(css =".sf-ChildMenuItems-3bApg > .sf-ChildMenuItems-aeXwv:nth-child(1)")
    private WebElement menuItemBooks;

    @FindBy(id="shoppingCart")
    private WebElement myBasketButton;


    public WebElement getCategoryBooksMenu() {
        return categoryBooksMenu;
    }

    public WebElement getMenuItemBooks() {
        return menuItemBooks;
    }

    public WebElement getMyBasketButton() {
        return myBasketButton;
    }

    public void goToBooksPage(WebDriver driver) {
        try {
            Utils.moveElement(driver, getCategoryBooksMenu());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getMenuItemBooks().click();
    }

    public void goToBasketPage() {
        getMyBasketButton().click();
    }

}
