package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends Base
{

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    public WebElement myStoreLogo;

    @FindBy(name="submit_search")
    public WebElement searchButton;
    @FindBy(id = "search_query_top")
    public WebElement searchInput;
    @FindBy(xpath = "//span[@class='lighter']")
    public WebElement searchedItem;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    public WebElement signInButton;

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
        Thread.sleep(3000);
        return new SearchResultPage();
    }
    public void clickSignInButton() {
        clickElement(signInButton);
        new LoginPage();
    }
    public void setSearchInput(String item) {
        sendKeysToElements(searchInput, item);
    }
    public void clickSearchButton() {
        clickElement(searchButton);
    }


    public void searchItems(String items) {
        setSearchInput(items);
        clickSearchButton();

    }

    public String getCurrURL()  {
        String homePageURL=driver.getCurrentUrl();
        return homePageURL;
    }






}
