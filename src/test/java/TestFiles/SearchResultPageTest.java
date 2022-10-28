package TestFiles;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.IndexPage;
import page_library.ProductPage;
import page_library.SearchResultPage;

public class SearchResultPageTest extends Base {
    private IndexPage index;
    private ProductPage productPage;
    public SearchResultPage searchResultPage;



    @Test(groups = {"Sanity"})
    public void SearchResultPageTesting() throws Throwable {
    IndexPage indexPage = new IndexPage();
    ProductPage productPage = new ProductPage();
    String item = prop.getProperty("item_to_search");
    String tit= searchResultPage.ProductAvailable();
         //productPage.addingItemsToCart();

    Assert.assertEquals(tit, "Dress");
    }



}
