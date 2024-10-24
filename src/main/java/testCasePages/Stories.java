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

public class Stories {

    private static final Logger log = LogManager.getLogger(Stories.class);
    AndroidDriver driver;
    public Stories(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"My Stories\"]")
    public WebElement myStoriesScreen;

    public String getMyStoriesScreen()
    {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text=\"My Stories\"]"),10);
        return myStoriesScreen.getText();
    }

    @FindBy(xpath = "(//android.view.ViewGroup[@index='0'])[7]")
    public WebElement backBtn;

    public void clickOnBackBtn()
    {
        AppiumUtils.waitForElementToBeClickable(driver,backBtn,10);
        backBtn.click();
        log.info("Click on Back button .....");
    }
}
