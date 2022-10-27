package page_library;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends Base {



    @FindBy(xpath = "//h1[text()='Create an account']")
    private WebElement formTitle;

    @FindBy(id = "uniform-id_gender1")
    private WebElement mr;

    @FindBy(id = "id_gender2")
    private WebElement mrs;

    @FindBy(name = "customer_firstname")
    private WebElement firstName;

    @FindBy(name = "customer_lastname")
    private WebElement lastName;

    @FindBy(name = "passwd")
    private WebElement passWord;

    @FindBy(name = "days")
    private WebElement days;

    @FindBy(name = "months")
    private WebElement months;

    @FindBy(name = "years")
    private WebElement years;

    @FindBy(name = "firstname")
    private WebElement customerNirstName;

    @FindBy(name = "lastname")
    private WebElement customerLastName;

    @FindBy(name = "company")
    private WebElement companyName;

    @FindBy(name = "address1")
    private WebElement address;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "id_state")
    private WebElement state;

    @FindBy(name = "postcode")
    private WebElement postCode;

    @FindBy(name = "id_country")
    private WebElement country;

    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(name = "phone_mobile")
    private WebElement mobile;

    @FindBy(name = "alias")
    private WebElement ref;

    @FindBy(name = "submitAccount")
    private WebElement registerBtn;
Base base = new Base();
    public AccountCreationPage() {
        PageFactory.initElements(driver, this);
    }

    public void createAccount(String gender,String fName,
                              String lName,
                              String pswd,
                              String day,
                              String month,
                              String year,
                              String comPany,
                              String addr,
                              String cityString,
                              String stateName,
                              String zip,
                              String countryName,
                              String mobilePhone) throws Throwable {

        if(gender.equalsIgnoreCase("Mr")) {
            base.sendKeysToElements(mr,"mr");
        } else {
            base.sendKeysToElements(mrs, "mrs");
        }

        base.sendKeysToElements(firstName, fName);
        base.sendKeysToElements(lastName, lName);
        base.sendKeysToElements(passWord, pswd);
        base.sendKeysToElements(days, day);
        base.sendKeysToElements(months, month);
        base.sendKeysToElements(years, year);
        base.sendKeysToElements(companyName, comPany);
        base.sendKeysToElements(address, addr);
        base.sendKeysToElements(city, cityString);
        base.sendKeysToElements(state, stateName);
        base.sendKeysToElements(postCode, zip);
        base.sendKeysToElements(country, countryName);
        base.sendKeysToElements(mobile, mobilePhone);
    }

    public HomePage validateRegistration() throws Throwable {
        registerBtn.click();
        return new HomePage();
    }

    public boolean validateAcountCreatePage() throws Throwable {
        return formTitle.isDisplayed();
    }

}
