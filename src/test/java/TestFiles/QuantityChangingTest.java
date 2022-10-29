package TestFiles;

import base.Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_library.AddingToCartPage;
import page_library.IndexPage;
import page_library.ProductPage;

import static org.testng.AssertJUnit.assertEquals;

public class QuantityChangingTest extends Base {
    @Test(groups = {"smoke","Regression"})
    public void changeQuantityTest(){
        IndexPage indexPage = new IndexPage();
        ProductPage productPage = new ProductPage();
        AddingToCartPage addingToCartPage = new AddingToCartPage();
        String item = prop.getProperty("item_to_search");
        indexPage.searchItems(item);
        productPage.clickItem();
        addingToCartPage.clickOnPlusIcon();
        String quantityWanted=prop.getProperty("quantity");
        assertEquals(quantityWanted,addingToCartPage.quantityValue.getAttribute("value"));


    }
}
