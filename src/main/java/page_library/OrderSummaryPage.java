package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends Base {



    @FindBy(xpath="//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrderBtn;

    public void OrderSummary() {
        PageFactory.initElements(driver, this);
    }

    public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
        confirmOrderBtn.click();
        return new OrderConfirmationPage();
    }
}
