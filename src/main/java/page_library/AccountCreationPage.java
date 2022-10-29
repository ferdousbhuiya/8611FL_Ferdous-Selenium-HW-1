package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends Base {

    @FindBy(xpath = "//h1")
    WebElement formTitle;

public AccountCreationPage() {
        PageFactory.initElements(driver, this);
    }
    public String validateAcountCreatePage() throws Throwable {
        return formTitle.getText();
    }

}
