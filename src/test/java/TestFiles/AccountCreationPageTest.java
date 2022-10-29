package TestFiles;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.*;

import static org.testng.AssertJUnit.assertTrue;

public class AccountCreationPageTest extends Base {
    @Test(groups = "Sanity")
    public void SuccessfulLoginTest1() throws Throwable {
        IndexPage indexPage =new IndexPage();
        LoginPage loginPage = new LoginPage();
        AccountCreationPage accountCreationPage = new AccountCreationPage();
        String nemail= prop.getProperty("nemail");
        indexPage.clickSignInButton();
        loginPage.setEmailForNewAccount(nemail);
        loginPage.cliconcreatenewaccount();
        String flag = accountCreationPage.validateAcountCreatePage();
        Assert.assertEquals(flag, "AUTHENTICATION");
    }
}
