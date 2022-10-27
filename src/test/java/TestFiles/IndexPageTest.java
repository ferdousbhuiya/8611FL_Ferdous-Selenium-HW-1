package TestFiles;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.IndexPage;

public class IndexPageTest extends Base {
    private IndexPage indexPage;

    @Test(groups = "Smoke")
    public void verifyLogo() throws Throwable {
        //Log.startTestCase("verifyLogo");
        indexPage= new IndexPage();
        boolean result=indexPage.validateLogo();
        Assert.assertTrue(result);
    }

    @Test(groups = "Smoke")
    public void verifyTitle() {
      indexPage = new IndexPage();
        String actTitle=indexPage.getMyStoreTitle();
        Assert.assertEquals(actTitle, "My Store");
    }

}
