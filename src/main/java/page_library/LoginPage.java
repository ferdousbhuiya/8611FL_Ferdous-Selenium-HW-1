package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {


    @FindBy(id="email")
    private WebElement userName;

    @FindBy(id="passwd")
    private WebElement password;

    @FindBy(id="SubmitLogin")
    private WebElement signInBtn;

    @FindBy(name="email_create")
    private WebElement emailForNewAccount;

    @FindBy(name="SubmitCreate")
    private WebElement createNewAccountBtn;
Base base = new Base();
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
        //base.moveToElements( userName);
        base.sendKeysToElements(userName, uname);
        base.sendKeysToElements(password, pswd);
        clickElement(signInBtn);

        //signInBtn.click();
        //Thread.sleep(2000);
        homePage=new HomePage();
        return homePage;
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
        base.sendKeysToElements(emailForNewAccount, newEmail);
        createNewAccountBtn.click();
        return new AccountCreationPage();
    }
}
