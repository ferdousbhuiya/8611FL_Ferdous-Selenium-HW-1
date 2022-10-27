package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends Base {



    @FindBy(xpath="//span[text()='Proceed to checkout']")
    private WebElement proceedToCheckOut;

    public AddressPage() {
        PageFactory.initElements(driver, this);
    }

    public ShippingPage clickOnCheckOut() throws Throwable {
        proceedToCheckOut.click();
        return new ShippingPage();
    }

}
