package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import utils.AppiumUtils;

public class HomePage {

    AndroidDriver driver;
    public HomePage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Assignment']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    public WebElement assignment;

    public void clickOnAssignment(){
        AppiumUtils.waitForElementToBeClickable(driver,assignment,10);
        assignment.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Virtue Week']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    public WebElement virtueWeek;

    public void clickOnVirtueWeek(){
        AppiumUtils.waitForElementToBeClickable(driver,virtueWeek,10);
        virtueWeek.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Achievement']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    public WebElement achievement;

    public void clickOnAchievement(){
        achievement.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Book List']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    public WebElement bookList;

    public void clickOnBookList(){
        AppiumUtils.waitForElementToBeClickable(driver,bookList,10);
        bookList.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='My Stories']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    public WebElement myStories;

    public void clickOnMyStories(){
        AppiumUtils.waitForElementToBeClickable(driver,myStories,10);
        myStories.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Gratitude Journal']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    public WebElement gratitudeJournal;

    public void clickOnGratitudeJournal(){
        AppiumUtils.waitForElementToBeClickable(driver,gratitudeJournal,10);
        gratitudeJournal.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Riddle']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    public WebElement riddle;

    public void clickOnRiddle(){
        AppiumUtils.waitForElementToBeClickable(driver,riddle,10);
        riddle.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Calendar']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
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
    }

    @FindBy(xpath = "(//android.widget.TextView[@index='0'])[14]")
    public WebElement logoutIcon;

    public void clickOnLogoutIcon(){
        AppiumUtils.waitForElementToBeClickable(driver,logoutIcon,10);
        logoutIcon.click();
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Logout\"]")
    public WebElement logoutButton;

    public void clickOnLogoutButton(){
        AppiumUtils.waitForElementToBeClickable(driver,logoutButton,10);
        logoutButton.click();
    }

}
