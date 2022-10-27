package TestFiles;

import base.Base;
import org.testng.annotations.Test;
import page_library.HomePage;
import page_library.IndexPage;
import page_library.LoginPage;
import page_library.SignInPage;

import static org.testng.AssertJUnit.assertTrue;

public class HomePageTest extends Base {

    private IndexPage indexPage;
    private HomePage homePage;
    private SignInPage signInPage;
    @Test
    public void wishListTest() {

        indexPage =new IndexPage();
        signInPage = new SignInPage();
        homePage= new HomePage();
        String userName= prop.getProperty("app_user");
        String password = prop.getProperty("app_password");
        indexPage.clickSignInButton();
        signInPage.signIn(userName,password);
        assertTrue(homePage.myWishList.isDisplayed());

    }
    @Test
    public void orderHistoryAndDetailsTest()  {
        indexPage =new IndexPage();
        signInPage = new SignInPage();
        homePage= new HomePage();
        String userName= prop.getProperty("app_user");
        String password = prop.getProperty("app_password");
        indexPage.clickSignInButton();
        signInPage.signIn(userName,password);
        assertTrue(homePage.orderHistory.isDisplayed());
    }

}
