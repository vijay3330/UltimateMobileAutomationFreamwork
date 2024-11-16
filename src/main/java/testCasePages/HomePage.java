package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import utils.AppiumUtils;

public class HomePage {
    private static final Logger log = LogManager.getLogger(HomePage.class);
    AndroidDriver driver;
    public HomePage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Activities\"]")
    public WebElement myActivities;

    public void clickOnMyActivities(){
        AppiumUtils.waitForElementToBeClickable(driver,myActivities,10);
        myActivities.click();
        log.info("Click on My Activities");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Virtue Week\"]")
    public WebElement virtueWeek;

    public void clickOnVirtueWeek(){
        AppiumUtils.waitForElementToBeClickable(driver,virtueWeek,10);
        virtueWeek.click();
        log.info("Click On virtueWeek");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Stories\"]")
    public WebElement myStories;

    public void clickOnMyStories(){
        AppiumUtils.waitForElementToBeClickable(driver,myStories,10);
        myStories.click();
        log.info("Click On myStories");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Approval\"]")
    public WebElement myApproval;

    public void clickOnMyApproval(){
        AppiumUtils.waitForElementToBeClickable(driver,myApproval,10);
        myApproval.click();
        log.info("Click On myApproval");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Achievement\"]")
    public WebElement achievement;

    public void clickOnAchievement(){
        AppiumUtils.waitForElementToBeClickable(driver,achievement,10);
        achievement.click();
        log.info("Click On Achievement");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Reading\"]")
    public WebElement reading;

    public void clickOnReading(){
        AppiumUtils.waitForElementToBeClickable(driver,reading,10);
        reading.click();
        log.info("Click On Reading");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Create Task\"]")
    public WebElement createTask;

    public void clickOnCreateTask(){
        AppiumUtils.waitForElementToBeClickable(driver,createTask,10);
        createTask.click();
        log.info("Click on createTask");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Rewards\"]")
    public WebElement rewards;

    public void clickOnRewards(){
        AppiumUtils.waitForElementToBeClickable(driver,rewards,10);
        rewards.click();
        log.info("Click on Rewards");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Book List\"]")
    public WebElement bookList;

    public void clickOnBookList(){
        AppiumUtils.waitForElementToBeClickable(driver,bookList,10);
        bookList.click();
        log.info("Click on Book List");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Calendar\"]")
    public WebElement calendar;

    public void clickOnCalendar(){
        AppiumUtils.waitForElementToBeClickable(driver,calendar,10);
        calendar.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Assesment\"]")
    public WebElement assesment;

    public void clickOnAssesment(){
        AppiumUtils.waitForElementToBeClickable(driver,assesment,10);
        assesment.click();
    }

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"surface\"])[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView")
    public WebElement menuButton;

    public void clickOnMenuButton(){
        AppiumUtils.waitForElementToBeClickable(driver,menuButton,10);
        menuButton.click();
        log.info("Click on Menu button from home.....");
    }

    @FindBy(xpath = "(//android.widget.TextView[@index='0'])[14]")
    public WebElement logoutIcon;

    public void clickOnLogoutIcon(){
        AppiumUtils.waitForElementToBeClickable(driver,logoutIcon,10);
        logoutIcon.click();
        log.info("Click on logout icon from home.....");
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Logout\"]")
    public WebElement logoutButton;

    public void clickOnLogoutButton(){
        AppiumUtils.waitForElementToBeClickable(driver,logoutButton,10);
        logoutButton.click();
        log.info("Click on logout button from home.....");
    }


    @FindBy(xpath = "(//android.widget.TextView[@text=\"Home\"])[1]")
    public WebElement homeScreen;

    public String getHomeScreenText()
    {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("(//android.widget.TextView[@text=\"Home\"])[1]"),10);
        return homeScreen.getText();
    }

}
