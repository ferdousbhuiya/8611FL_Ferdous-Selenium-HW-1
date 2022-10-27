package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class IndexPage extends Base
{

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement myStoreLogo;

    @FindBy(name="submit_search")
    private WebElement searchButton;
    @FindBy(id = "search_query_top")
    public WebElement searchInput;
    @FindBy(xpath = "//span[@class='lighter']")
    public WebElement searchedItem;

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement accountCreationEmailBox;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
            public WebElement createAnAccountBtn;

    Base base = new Base();
    public IndexPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickOnSignIn() throws Throwable {
        clickElement(signInButton);
        return new LoginPage();
    }

    public boolean validateLogo()  {
        return myStoreLogo.isDisplayed();
    }

    public String getMyStoreTitle() {
        return driver.getTitle();
    }

    public SearchResultPage searchProduct(String productName) throws Throwable {
        base.sendKeysToElements(searchedItem, productName);
        base.moveToElements(searchButton);
        searchButton.click();
        //Thread.sleep(3000);
        return new SearchResultPage();
    }
    public SignInPage clickSignInButton() {
        clickElement(signInButton);
        return new SignInPage();
    }
    public void setSearchInput(String item) {
        sendKeysToElements(searchInput, item);
    }
    public void clickSearchButton() {
        clickElement(searchButton);
    }
    public ProductPage searchItems(String items) {
        setSearchInput(items);
        clickSearchButton();
        return new ProductPage();
    }

    public String getCurrURL()  {
        String homePageURL=driver.getCurrentUrl();
        return homePageURL;
    }

    public AccountCreationPage createAccountPage()
    {LoginPage loginPage= new LoginPage();
        base.sendKeysToElements(accountCreationEmailBox, prop.getProperty("nemail"));
        clickElement(createAnAccountBtn);
        return new AccountCreationPage();
    }




}
