package base;

import com.aventstack.extentreports.ExtentReports;
import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop;
    public static Wait<WebDriver> fluentWait;
    public static Config config = new Config();

    public static WebDriverWait webDriverWait;

    public static ExtentReports extent;
    public static JavascriptExecutor jsDriver;


    public Base() {
        prop = Config.loadProperties();
    }

    @BeforeTest
    public void initDriver(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }

        //wait = new WebDriverWait(driver, Long.parseLong(prop.getProperty("driver_timeout")));
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public static void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeysToElements(WebElement element, String keys) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }

    public void moveToElements(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);

        fluentWait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
    }

    public String getTrimmedElementText(WebElement element) {
        String text = "";
        fluentWait.until(ExpectedConditions.visibilityOf(element));

        text = element.getText().trim();

        if (text.equals("")) {
            text = element.getAttribute("innerHTML").trim();
        }

        return text;
    }

    public void clearSendKeysToElement(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(keys);
    }

    public void selectFromDropdownByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void selectFromDropdownByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectFromDropdownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public boolean isElementVisible(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public void waitForInvisibilityOfElement(WebElement element) {
        fluentWait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void switchToParentFrame() {
        driver.switchTo().defaultContent();
    }

    public void switchToFrameByElement(WebElement frame) {
        driver.switchTo().frame(frame);
    }


}
