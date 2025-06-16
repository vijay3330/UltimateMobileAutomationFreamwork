package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import utils.AppiumUtils;

public class TrialAndSubscriptionPage {

    private static final Logger log = LogManager.getLogger(TrialAndSubscriptionPage.class);
    AndroidDriver driver;
    public TrialAndSubscriptionPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Subscribe Now\"]")
    public WebElement subscribeNowBtn;

    public void clickOnSubscribeNowBtn(){
        AppiumUtils.waitForElementToBeClickable(driver,subscribeNowBtn,10);
        subscribeNowBtn.click();
        log.info("Click On Subscribe Now");
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Click here for a free trial!\"]")
    public WebElement subscribeNow;

    public void clickOnBoyTab(){
        AppiumUtils.waitForElementToBeClickable(driver,subscribeNow,10);
        subscribeNow.click();
        log.info("Click On Subscribe Now");
    }

}
