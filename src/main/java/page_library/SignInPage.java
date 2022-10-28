package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Base {
    /*
    @FindBy(id = "email")
    public WebElement userNameInput;
    @FindBy(id = "passwd")
    public WebElement passwordInput;
    @FindBy(id = "SubmitLogin")
    public WebElement submitLoginButton;
    @FindBy(xpath = "//form[@id='login_form']//h3")
    public WebElement alreadyRegisteredSubHeading;
    @FindBy(xpath = "//div[@class='row addresses-lists']/div/ul/li[3]/a")
    WebElement myAddresses;

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    public void setUserNameInput(String key) {
        sendKeysToElements(userNameInput, key);
    }

    public void setPasswordInput(String key) {
        sendKeysToElements(passwordInput, key);
    }

    public void clickSubmitButton() {
        clickElement(submitLoginButton);
    }
    public MyAddressesPage clickMyAddresses(){
        clickElement(myAddresses);
        return new MyAddressesPage();
    }

    public HomePage signIn(String userName, String password) {
        setUserNameInput(userName);
        setPasswordInput(password);
        clickSubmitButton();
        return new HomePage();
    }

    */
}
