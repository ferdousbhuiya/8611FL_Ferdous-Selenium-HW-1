package TestFiles;

import base.Base;
import org.testng.annotations.Test;
import page_library.IndexPage;
import page_library.ProductPage;

import static org.testng.AssertJUnit.assertTrue;

public class AddToCartTest extends Base {
    @Test
    public void addingItemsToCartTest() throws InterruptedException {

        IndexPage indexPage = new IndexPage();
        ProductPage productPage = new ProductPage();
        String item = prop.getProperty("item_to_search");
        indexPage.searchItems(item);
        productPage.addingItemsToCart();
        assertTrue("Product successfully added to your shopping cart\n" +
                "\t\t\t\t", productPage.addCartConfirmation.isDisplayed());
    }
}


