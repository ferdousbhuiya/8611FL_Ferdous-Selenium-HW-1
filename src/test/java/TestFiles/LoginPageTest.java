package TestFiles;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.HomePage;
import page_library.IndexPage;
import page_library.LoginPage;

public class LoginPageTest extends Base {
    private IndexPage indexPage;
    private LoginPage loginPage;
    private HomePage homePage;


    @Test(groups = {"Smoke","Sanity"})
    public void loginTest(String uname, String pswd) throws Throwable {
        //Log.startTestCase("loginTest");
        indexPage= new IndexPage();
        //Log.info("user is going to click on SignIn");
        loginPage=indexPage.clickOnSignIn();
        //Log.info("Enter Username and Password");
        //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        //homePage=loginPage.login(uname,pswd,homePage);
        String actualURL=driver.getCurrentUrl();
        String expectedURL="http://automationpractice.com/index.php?controller=my-account";
        //Log.info("Verifying if user is able to login");
        Assert.assertEquals(actualURL, expectedURL);
        //Log.info("Login is Sucess");
        //Log.endTestCase("loginTest");
    }

}
