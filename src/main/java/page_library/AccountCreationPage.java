package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends Base {

    @FindBy(xpath = "//h3[contains(text(),'Your personal information')]")
    WebElement formTitle;

public AccountCreationPage() {
        PageFactory.initElements(driver, this);
    }
    public String validateAcountCreatePage() throws Throwable {
        return formTitle.getText();
    }

}
