package TestFiles;

import base.Base;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page_library.AddingToCartPage;
import page_library.IndexPage;
import page_library.ProductPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ChangingColorTest extends Base {

    @Test(groups = {"smoke", "Sanity"})
    public void changeColorTest() {
        IndexPage indexPage = new IndexPage();
        ProductPage productPage = new ProductPage();
        AddingToCartPage addingToCartPage = new AddingToCartPage();
        String item = prop.getProperty("item_to_search");
        indexPage.searchItems(item);
        productPage.clickItem();
        WebElement orangeColor = addingToCartPage.orangeColor;
        WebElement orangeDress = addingToCartPage.orangeDress;
        addingToCartPage.changeColor(orangeColor);
        assertTrue("the dress should be displayed in orange", orangeDress.isDisplayed());

    }
}
