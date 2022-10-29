package TestFiles;

import base.Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_library.HomePage;
import page_library.IndexPage;
import page_library.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class HomePageTest extends Base {

    private IndexPage indexPage;
    private HomePage homePage;
    private LoginPage loginPage;

    @Test(groups = "Authentication")
    public void HomePageTest() throws Throwable {
        IndexPage indexPage =new IndexPage();
        LoginPage loginPage = new LoginPage();
        HomePage homePage= new HomePage();
        String userName= prop.getProperty("app_user");
        String password = prop.getProperty("app_password");
        indexPage.clickSignInButton();
        loginPage.signInTovalidAccount(userName,password);
        assertTrue(homePage.validateOrderHistory());
    }
}
