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

public class CalendarPage {

    private static final Logger log = LogManager.getLogger(CalendarPage.class);

    AndroidDriver driver;
    public CalendarPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"undefined.knob\"]")
    public WebElement calendarExpandButton;

    public void clickOnCalendarExpandButton(){
        AppiumUtils.waitForElementToBeClickable(driver,calendarExpandButton,10);
        calendarExpandButton.click();
        log.info("Click On Expand Button");
    }

}