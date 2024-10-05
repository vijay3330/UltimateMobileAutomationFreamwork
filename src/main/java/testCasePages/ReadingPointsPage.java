package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import utils.AppiumUtils;

public class ReadingPointsPage
{
    private static final Logger log = LogManager.getLogger(ReadingPointsPage.class);

    AndroidDriver driver;
    public ReadingPointsPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.widget.EditText[@text=\"00\"]")
    public WebElement minsTextBox;

    public void enterMins(String mins){
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.EditText[@text=\"00\"]"),10);
        minsTextBox.sendKeys(mins);
        log.info("Enter mins : "+mins);
    }

    @FindBy(xpath = "//android.widget.EditText[@text=\"What do you read today?\"]")
    public WebElement readTodayTextBox;

    public void enterReadToday(String read){
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.EditText[@text=\"What do you read today?\"]"),10);
        minsTextBox.sendKeys(read);
        log.info("Enter What do you read today? : "+read);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Language\"]")
    public WebElement languaeDropdown;

    public void clickOnLanguaeDropdown(){
        AppiumUtils.waitForElementToBeClickable(driver,languaeDropdown,10);
        languaeDropdown.click();
        log.info("Click On Languae Dropdown");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Submit\"]")
    public WebElement submitButton;

    public void clickOnSubmitButton(){
        AppiumUtils.waitForElementToBeClickable(driver,submitButton,10);
        submitButton.click();
        log.info("Click On Submit Button");
    }

    @FindBy(xpath = "//android.widget.EditText[@index='1']")
    public WebElement enterReading;

    public String getEnterReading()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.EditText[@index='1']"),10);
        return enterReading.getText();
    }


    @FindBy(xpath = "//android.widget.TextView[@text=\"Congratulations! Points added to your bucket. Keep up the great work!\"]")
    public WebElement successMessage;

    public String getSuccessMessage()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.TextView[@text=\"Congratulations! Points added to your bucket. Keep up the great work!\"]"),10);
        return enterReading.getText();
    }

}