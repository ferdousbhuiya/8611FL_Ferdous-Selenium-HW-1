package TestFiles;

import base.Base;
import org.testng.annotations.Test;
import page_library.HomePage;
import page_library.IndexPage;
import page_library.SignInPage;

import static org.testng.AssertJUnit.assertTrue;

public class SigninTest extends Base {

    @Test
    public void testSignIn(){
        IndexPage indexPage =new IndexPage();
        SignInPage signInPage = new SignInPage();
        HomePage homePage= new HomePage();
        String userName= prop.getProperty("app_user");
        String password = prop.getProperty("app_password");
        indexPage.clickSignInButton();
        signInPage.signIn(userName,password);
        assertTrue(homePage.myAccountHeadingText.isDisplayed());
    }
}
