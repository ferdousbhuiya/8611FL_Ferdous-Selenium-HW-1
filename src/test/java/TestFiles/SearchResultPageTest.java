package TestFiles;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.IndexPage;
import page_library.SearchResultPage;

public class SearchResultPageTest extends Base {
    private IndexPage index;
    private SearchResultPage searchResultPage;



    @Test(groups = "Smoke")
    public void productAvailabilityTest(String productName) throws Throwable {
        //Log.startTestCase("productAvailabilityTest");
        index= new IndexPage();
        searchResultPage=index.searchProduct(productName);
        boolean result=searchResultPage.isProductAvailable();
        Assert.assertTrue(result);
        //Log.endTestCase("productAvailabilityTest");
    }



}
