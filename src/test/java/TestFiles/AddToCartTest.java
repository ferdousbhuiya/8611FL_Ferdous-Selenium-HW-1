package TestFiles;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.*;

import static org.testng.AssertJUnit.assertTrue;

public class AddToCartTest extends Base {

    @Test
    public void addingItemsToCartTest() throws InterruptedException {

        IndexPage indexPage = new IndexPage();
        HomePage homePage = new HomePage();
        ProductPage productPage =new ProductPage();
        String item =prop.getProperty("item_to_search") ;
        indexPage.searchItems(item);
        productPage.addingItemsToCart();
        assertTrue("this confirmation should appear after clicking add button", productPage.addCartConfirmation.isDisplayed());
    }

    @Test
    public void addToCartTest(String productName, String qty, String size) throws Throwable {
        //Log.startTestCase("addToCartTest");
        SearchResultPage searchResultPage;
        IndexPage index= new IndexPage();
        AddToCartPage addToCartPage;
        searchResultPage=index.searchProduct(productName);
        addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(qty);
        addToCartPage.selectSize(size);
        addToCartPage.clickOnAddToCart();
        boolean result=addToCartPage.validateAddtoCart();
        Assert.assertTrue(result);
        //Log.endTestCase("addToCartTest");

    }

}
