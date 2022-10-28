package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {


    @FindBy(id="email")
    WebElement userName;

    @FindBy(id="passwd")
    WebElement password;

    @FindBy(id="SubmitLogin")
    WebElement signInBtn;

    @FindBy(name="email_create")
    WebElement emailForNewAccount;

    @FindBy(name="SubmitCreate")
    WebElement createNewAccountBtn;
    @FindBy(id = "email")
    WebElement userNameInput;
    @FindBy(id = "passwd")
    WebElement passwordInput;
    @FindBy(id = "SubmitLogin")
    public WebElement submitLoginButton;
    @FindBy(xpath = "//form[@id='login_form']//h3")
    public WebElement alreadyRegisteredSubHeading;
    @FindBy(xpath = "//div[@class='row addresses-lists']/div/ul/li[3]/a")
    WebElement myAddresses;


Base base = new Base();
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
        base.moveToElements(userName);
        base.sendKeysToElements(userName, uname);
        base.sendKeysToElements(password, pswd);
        signInBtn.click();
        Thread.sleep(2000);
        addressPage=new AddressPage();
        return addressPage;
    }

    public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
        sendKeysToElements(emailForNewAccount, newEmail);
        hoverOverElement(createNewAccountBtn);
        createNewAccountBtn.click();
        return new AccountCreationPage();
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

    public HomePage signInTovalidAccount(String userName, String password) {
        setUserNameInput(userName);
        setPasswordInput(password);
        clickSubmitButton();
        return new HomePage();
    }

    public void setEmailForNewAccount(String emailnew)
    {
        sendKeysToElements(emailForNewAccount,emailnew);
    }
    public void cliconcreatenewaccount()
    {
        clickElement(createNewAccountBtn);
    }
}
