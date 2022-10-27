package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddressesPage extends Base {
    @FindBy(xpath = "//div[@class='clearfix main-page-indent']/a")
    public WebElement addNewAddressButton;

    @FindBy(xpath = "//h1[@class='page-subheading']")
    public WebElement yourAddressesHeader;

    public MyAddressesPage(){
        PageFactory.initElements(driver,this);
    }

    public void clickAddNewAddressButton(){
        clickElement(addNewAddressButton);
    }
}
