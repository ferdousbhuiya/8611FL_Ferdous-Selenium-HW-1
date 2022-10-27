package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingToCartPage extends Base {
    @FindBy(id = "color_13")
    public WebElement orangeColor;
    @FindBy(id = "bigpic")
    public WebElement orangeDress;
    @FindBy(xpath = "//a[@class='btn btn-default button-plus product_quantity_up']")
    public WebElement plusButton;

    @FindBy(xpath = "//p[@id='quantity_wanted_p']/input")
    public WebElement quantityValue;

    public AddingToCartPage() {
        PageFactory.initElements(driver, this);
    }

    public void changeColor(WebElement color) {
        clickElement(color);
    }
    public void clickOnPlusIcon(){
        clickElement(plusButton);
    }

}
