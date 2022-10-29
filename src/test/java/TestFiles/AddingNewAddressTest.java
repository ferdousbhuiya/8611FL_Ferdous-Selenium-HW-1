package TestFiles;

import base.Base;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_library.IndexPage;
import page_library.LoginPage;
import page_library.MyAddressesPage;

import static org.testng.AssertJUnit.assertTrue;

public class AddingNewAddressTest extends Base {



    @Test
    public void addingNewAddressTest() {

        IndexPage indexPage= new IndexPage();
        LoginPage loginPage = new LoginPage();
        MyAddressesPage myAddressesPage = new MyAddressesPage();
        indexPage.clickSignInButton();
        String userName = prop.getProperty("app_user");
        String password = prop.getProperty("app_password");
        loginPage.signInTovalidAccount(userName, password);
        loginPage.clickMyAddresses();
        myAddressesPage.clickAddNewAddressButton();
        WebElement addressesHeader = myAddressesPage.yourAddressesHeader;

        assertTrue("this h2 header should be displayed", addressesHeader.isDisplayed());
    }
}
