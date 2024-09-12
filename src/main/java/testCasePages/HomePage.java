package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"My Activities\"]/android.view.ViewGroup")
    public WebElement myActivities;

    public void clickOnMyActivities(){
        AppiumUtils.waitForElementToBeClickable(driver,myActivities,10);
        myActivities.click();
        log.info("Click on My Activities");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Virtue Week\"]/android.view.ViewGroup")
    public WebElement virtueWeek;

    public void clickOnVirtueWeek(){
        AppiumUtils.waitForElementToBeClickable(driver,virtueWeek,10);
        virtueWeek.click();
        log.info("Click On virtueWeek");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"My Stories\"]/android.view.ViewGroup")
    public WebElement myStories;

    public void clickOnMyStories(){
        AppiumUtils.waitForElementToBeClickable(driver,myStories,10);
        myStories.click();
        log.info("Click On myStories");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"My Approval\"]/android.view.ViewGroup")
    public WebElement myApproval;

    public void clickOnMyApproval(){
        AppiumUtils.waitForElementToBeClickable(driver,myApproval,10);
        myApproval.click();
        log.info("Click On myApproval");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Achievement\"]/android.view.ViewGroup")
    public WebElement achievement;

    public void clickOnAchievement(){
        AppiumUtils.waitForElementToBeClickable(driver,achievement,10);
        achievement.click();
        log.info("Click On Achievement");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Reading\"]/android.view.ViewGroup")
    public WebElement reading;

    public void clickOnReading(){
        AppiumUtils.waitForElementToBeClickable(driver,reading,10);
        reading.click();
        log.info("Click On Reading");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Create Own\"]/android.view.ViewGroup")
    public WebElement createOwn;

    public void clickOnCreateOwn(){
        AppiumUtils.waitForElementToBeClickable(driver,createOwn,10);
        createOwn.click();
        log.info("Click on CreateOwn");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Ultimate Rewards\"]/android.view.ViewGroup")
    public WebElement ulimateRewards;

    public void clickOnUlimateRewards(){
        AppiumUtils.waitForElementToBeClickable(driver,ulimateRewards,10);
        ulimateRewards.click();
        log.info("Click on Ulimate Rewards");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Book List\"]/android.view.ViewGroup")
    public WebElement bookList;

    public void clickOnBookList(){
        AppiumUtils.waitForElementToBeClickable(driver,bookList,10);
        bookList.click();
        log.info("Click on Book List");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Calendar\"]/android.view.ViewGroup\n")
    public WebElement calendar;

    public void clickOnCalendar(){
        AppiumUtils.waitForElementToBeClickable(driver,calendar,10);
        calendar.click();
    }

    @FindBy(xpath = "(//android.widget.TextView[@index='0'])[1]")
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

}
