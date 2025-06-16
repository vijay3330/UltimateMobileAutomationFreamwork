package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AppiumUtils;

public class UltimateRewardsPage {

    private static final Logger log = LogManager.getLogger(UltimateRewardsPage.class);
    AndroidDriver driver;

    public UltimateRewardsPage(AndroidDriver d) {
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Ultimate Rewards\"]")
    public WebElement ultimateRewardsScreen;

    public String clickOnUltimateRewardsScreen() {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text=\"Ultimate Rewards\"]"),10);
        return ultimateRewardsScreen.getText();

    }

    @FindBy(xpath = "(//android.widget.TextView[@index='0'])[1]")
    public WebElement backBtn;

    public void clickOnBackBtn()
    {
        AppiumUtils.waitForElementToBeClickable(driver,backBtn,10);
        backBtn.click();
        log.info("Click on back button....");
    }




}
