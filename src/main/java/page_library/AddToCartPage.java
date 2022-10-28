package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends Base {
Base base = new Base();

    @FindBy(id="quantity_wanted")
    public WebElement quantity;

    @FindBy(name="group_1")
    public WebElement size;

    @FindBy(xpath="//span[text()='Add to cart']")
    public WebElement addToCartBtn;

    @FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
    public WebElement addToCartMessag;

    @FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
    public WebElement proceedToCheckOutBtn;

    public AddToCartPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterQuantity(String quantity1) throws Throwable {
        sendKeysToElements(quantity, quantity1);
    }

    public void selectSize(String size1) throws Throwable {
        moveToElements( size);
    }

    public void clickOnAddToCart() throws Throwable {
        addToCartBtn.click();
    }

    public boolean validateAddtoCart() throws Throwable {
        wait();
       // action.fluentWait(driver, addToCartMessag, 10);
        return addToCartMessag.isDisplayed();
    }

    public OrderPage clickOnCheckOut() throws Throwable {

        wait();
        //action.fluentWait(driver, proceedToCheckOutBtn, 10);
        proceedToCheckOutBtn.click();
        return new OrderPage();
    }


}
