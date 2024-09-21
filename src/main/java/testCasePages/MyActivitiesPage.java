package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AppiumUtils;

public class MyActivitiesPage {

    private static final Logger log = LogManager.getLogger(MyActivitiesPage.class);
    AndroidDriver driver;

    public MyActivitiesPage(AndroidDriver d) {
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//android.widget.TextView[@text='Cycling']/following-sibling::android.widget.TextView)[1]")
    public WebElement activityStartEndDate;

    public String getActivityStartEndDate()
    {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("(//android.widget.TextView[@text='Cycling']/following-sibling::android.widget.TextView)[1]"),10);
        return activityStartEndDate.getText();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@index='2']//android.widget.TextView[contains(@text, 'mins')]")
    public WebElement activityTimeInMin;

    public String getActivityTimeInMin()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.view.ViewGroup[@index='2']//android.widget.TextView[contains(@text, 'mins')]"),10);
        return activityTimeInMin.getText();
    }

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'points')]")
    public WebElement activityPoints;

    public String getActivityPoints()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.TextView[contains(@text,'points')]"),10);
        return activityPoints.getText();
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Description']/following-sibling::android.widget.ScrollView//android.widget.TextView")
    public WebElement activityDescription;

    public String getActivityDescription()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.TextView[@text='Description']/following-sibling::android.widget.ScrollView//android.widget.TextView"),10);
        return activityDescription.getText();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Start\"]")
    public WebElement startBtn;

    public void clickOnStartBtn()
    {
        AppiumUtils.waitForElementToBeClickable(driver,startBtn,10);
        startBtn.click();
        log.info("Click on start button .....");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Mark as Complete\"]")
    public WebElement macBtn;

    public void clickOnMACBtn()
    {
        AppiumUtils.waitForElementToBeClickable(driver,macBtn,10);
        macBtn.click();
        log.info("Click on MAC button .....");
    }

}
