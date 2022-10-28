package TestFiles;

import base.Base;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page_library.IndexPage;
import page_library.LoginPage;
import page_library.SignInPage;

import static org.testng.AssertJUnit.assertTrue;

public class ClickSignInTest extends Base {

    @Test(groups = "smoke")
    public void testSignIn() {
        LoginPage loginPage = new LoginPage();
        IndexPage indexPage = new IndexPage();
        indexPage.clickSignInButton();
        WebElement alreadyRegisteredString = loginPage.alreadyRegisteredSubHeading;
        assertTrue(alreadyRegisteredString.isDisplayed());
    }

}
