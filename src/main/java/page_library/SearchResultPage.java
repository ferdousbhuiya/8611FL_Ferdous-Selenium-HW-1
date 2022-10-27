package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends Base {


    @FindBy(xpath="//*[@id=\"center_column\"]//img")
    private WebElement productResult;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isProductAvailable() throws Throwable {
        return productResult.isDisplayed();
    }

    public AddToCartPage clickOnProduct() throws Throwable {
        productResult.click();
        return new AddToCartPage();
    }


}
