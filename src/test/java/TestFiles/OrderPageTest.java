package TestFiles;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.AddToCartPage;
import page_library.IndexPage;
import page_library.OrderPage;
import page_library.SearchResultPage;

public class OrderPageTest extends Base {
    private IndexPage index;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;



    @Test(groups = "Regression")
    public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
        //Log.startTestCase("verifyTotalPrice");
        index= new IndexPage();
        searchResultPage=index.searchProduct(productName);
        addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(qty);
        addToCartPage.selectSize(size);
        addToCartPage.clickOnAddToCart();
        orderPage=addToCartPage.clickOnCheckOut();
        Double unitPrice=orderPage.getUnitPrice();
        Double totalPrice=orderPage.getTotalPrice();
        Double totalExpectedPrice=(unitPrice*(Double.parseDouble(qty)))+2;
        Assert.assertEquals(totalPrice, totalExpectedPrice);
        //Log.endTestCase("verifyTotalPrice");
    }
}
