package TestFiles;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page_library.*;

public class EndToEndTest extends Base {
    private IndexPage index;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;
    private LoginPage loginPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;
    private OrderSummaryPage orderSummary;
    private OrderConfirmationPage orderConfirmationPage;



    @Test
    public void endToEndTest(String productName, String qty, String size) throws Throwable {
        //Log.startTestCase("endToEndTest");
        index= new IndexPage();
        searchResultPage=index.searchProduct(productName);
        addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(qty);
        addToCartPage.selectSize(size);
        addToCartPage.clickOnAddToCart();
        orderPage=addToCartPage.clickOnCheckOut();
        loginPage=orderPage.clickOnCheckOut();
        addressPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),addressPage);
        shippingPage=addressPage.clickOnCheckOut();
        shippingPage.checkTheTerms();
        paymentPage=shippingPage.clickOnProceedToCheckOut();
        orderSummary=paymentPage.clickOnPaymentMethod();
        orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
        String actualMessage=orderConfirmationPage.validateConfirmMessage();
        String expectedMsg="Your order on My Store is complete.";
        Assert.assertEquals(actualMessage, expectedMsg);
        //Log.endTestCase("endToEndTest");
    }

}
