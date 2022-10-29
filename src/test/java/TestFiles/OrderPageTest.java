package TestFiles;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_library.*;

public class OrderPageTest extends Base {
    private IndexPage index;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;
    public IndexPage indexPage;
    public ProductPage productPage;


    @Test(groups = "Regression")
    public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
        //Log.startTestCase("verifyTotalPrice");
        index = new IndexPage();
        String item = prop.getProperty("item_for_quantity");
        indexPage.searchItems(item);
        productPage.addingItemsToCart();
        //searchResultPage=index.searchProduct(productName);
        //addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(qty);
        addToCartPage.selectSize(size);
        addToCartPage.clickOnAddToCart();
        orderPage = addToCartPage.clickOnCheckOut();
        Double unitPrice = orderPage.getUnitPrice();
        Double totalPrice = orderPage.getTotalPrice();
        Double totalExpectedPrice = (unitPrice * (Double.parseDouble(qty))) + 2;
        Assert.assertEquals(totalPrice, totalExpectedPrice);

    }

    @Test
    public void changeQuantityTest() {
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        AddingToCartPage addingToCartPage = new AddingToCartPage();
        String item = prop.getProperty("item_for_quantity");
        indexPage.searchItems(item);
        productPage.clickItem();
        addingToCartPage.clickOnPlusIcon();
        String quantityWanted = prop.getProperty("quantity");
        Assert.assertEquals(quantityWanted, addingToCartPage.quantityValue.getAttribute("value"));


    }
}
