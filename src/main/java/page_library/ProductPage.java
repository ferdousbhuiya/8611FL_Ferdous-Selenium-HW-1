package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage extends Base {
    @FindBy(xpath = "//img[@src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']")
    public WebElement item;
    @FindBy(xpath = "//ul[@class='product_list grid row']/li[1]/div/div[2]/div[2]/a[2]")
    public WebElement addToCartButton;

    @FindBy(id = "add_to_cart")
    public WebElement addCartConfirmation;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public void hover() {
        moveToElements(item);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickItem() {
        clickElement(item);
    }

    public AddingToCartPage addingItemsToCart() {
        hover();
        clickAddToCartButton();
        return new AddingToCartPage();
    }

}
