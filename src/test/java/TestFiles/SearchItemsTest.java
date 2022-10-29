package TestFiles;

import base.Base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_library.IndexPage;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class SearchItemsTest extends Base {

    @Test(groups = "smoke")
    public void searchItemsTest() {
        IndexPage indexPage = new IndexPage();
        String item = prop.getProperty("item_to_search");
        indexPage.searchItems(item);
        assertEquals(indexPage.searchedItem.getText().toLowerCase().replace("\"",""),item.toLowerCase());
    }
}
