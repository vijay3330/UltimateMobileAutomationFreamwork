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

public class MyApprovalPage
{
    private static final Logger log = LogManager.getLogger(MyApprovalPage.class);
    AndroidDriver driver;
    public MyApprovalPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Approve Activity\"]/android.view.ViewGroup")
    public WebElement approveActivity;

    public void clickOnApproveActivity(){
        AppiumUtils.waitForElementToBeClickable(driver,approveActivity,10);
        approveActivity.click();
        log.info("Click On Approve Activity");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Approve Rewards\"]/android.view.ViewGroup")
    public WebElement approveRewards;

    public void clickOnApproveRewards(){
        AppiumUtils.waitForElementToBeClickable(driver,approveRewards,10);
        approveRewards.click();
        log.info("Click On Approve Rewards");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Approve Achievements\"]/android.view.ViewGroup")
    public WebElement approveAchievements;

    public void clickOnApproveAchievements(){
        AppiumUtils.waitForElementToBeClickable(driver,approveAchievements,10);
        approveAchievements.click();
        log.info("Click On Approve Achievements");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Approve Reading\"]/android.view.ViewGroup")
    public WebElement approveReading;

    public void clickOnApproveReading(){
        AppiumUtils.waitForElementToBeClickable(driver,approveReading,10);
        approveReading.click();
        log.info("Click On Approve Reading");
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"My Approval\"]")
    public WebElement myApprovalScreen;

    public String getMyApprovalScreen()
    {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text=\"My Approval\"]"),10);
        return myApprovalScreen.getText();
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
