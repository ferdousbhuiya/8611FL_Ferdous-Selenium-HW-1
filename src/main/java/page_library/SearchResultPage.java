package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends Base {


    @FindBy(xpath="//span[contains(text(),'\"dress\"')]")
    public WebElement productResult;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    public String ProductAvailable() throws Throwable {
        String tite= productResult.getText();
        return tite;
    }

    public AddToCartPage clickOnProduct() throws Throwable {
        productResult.click();
        return new AddToCartPage();
    }


}
