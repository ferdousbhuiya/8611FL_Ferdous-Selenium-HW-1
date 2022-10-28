package TestFiles;

import base.Base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.HomePage;
import page_library.IndexPage;
import page_library.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class LoginPageTest extends Base {

    @Test(groups = "smoke")
    public void validateloginPageTest() {
        LoginPage loginPage = new LoginPage();
        IndexPage indexPage = new IndexPage();
        indexPage.clickSignInButton();
        WebElement alreadyRegisteredString = loginPage.alreadyRegisteredSubHeading;
        assertTrue(alreadyRegisteredString.isDisplayed());
    }
}