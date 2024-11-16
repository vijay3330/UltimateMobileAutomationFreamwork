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

public class VirtueWeekPage {

    private static final Logger log = LogManager.getLogger(VirtueWeekPage.class);
    AndroidDriver driver;
    public VirtueWeekPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Virtue Week\"]")
    public WebElement virtueWeekScreen;

    public String getVirtueWeekScreen()
    {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text=\"Virtue Week\"]"),10);
        return virtueWeekScreen.getText();
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
