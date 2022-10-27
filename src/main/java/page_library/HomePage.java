package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    @FindBy(xpath="//span[text()='My wishlists']")
    public WebElement myWishList;

    @FindBy(xpath = "//span[text()='Order history and details']")
    public WebElement orderHistory;

    @FindBy(xpath = "//h1[@class='page-heading']")
    public  WebElement myAccountHeadingText;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    public boolean validateMyWishList() throws Throwable {
        return myWishList.isDisplayed();
    }

    public boolean validateOrderHistory() throws Throwable {
        return orderHistory.isDisplayed();
    }


    public void signIn()
    {
        IndexPage indexPage = new IndexPage();
        SignInPage signInPage = new SignInPage();
        //HomePage homePage = new HomePage();
        String userName= prop.getProperty("app_user");
        String password = prop.getProperty("app_password");
        indexPage.clickSignInButton();
        signInPage.signIn(userName,password);
    }
    public String getCurrURL() throws Throwable {
        HomePage homePage = new HomePage();
        return homePage.getCurrURL();
    }


}
