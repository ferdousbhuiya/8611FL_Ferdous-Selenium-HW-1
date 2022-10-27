package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends Base {

    @FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
    private WebElement confirmMessag;

    public OrderConfirmationPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateConfirmMessage() {
        return confirmMessag.getText();
    }

}
