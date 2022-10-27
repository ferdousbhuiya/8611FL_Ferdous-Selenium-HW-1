package TestFiles;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.AccountCreationPage;
import page_library.HomePage;
import page_library.IndexPage;
import page_library.LoginPage;

import java.util.HashMap;

public class AccountCreationPageTest extends Base {

    private IndexPage indexPage;
    private LoginPage loginPage;
    private AccountCreationPage acountCreationPage;
    private HomePage homePage;



    @Test
    public void verifyCreateAccountPageTest(String email) throws Throwable {
       // Log.startTestCase("verifyCreateAccountPageTest");
        indexPage= new IndexPage();
        loginPage=indexPage.clickOnSignIn();
        acountCreationPage=loginPage.createNewAccount(email);
        boolean result=acountCreationPage.validateAcountCreatePage();
        Assert.assertTrue(result);
        //Log.endTestCase("verifyCreateAccountPageTest");
    }


    @Test
    public void verifyCreateAccountPageTest() throws Throwable {
        acountCreationPage=indexPage.createAccountPage();
        Assert.assertTrue(acountCreationPage.validateAcountCreatePage());

    }



}
