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

public class AddChildPage {

    private static final Logger log = LogManager.getLogger(AddChildPage.class);
    AndroidDriver driver;
    public AddChildPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Boy\"]")
    public WebElement boyTab;

    public void clickOnBoyTab(){
        AppiumUtils.waitForElementToBeClickable(driver,boyTab,10);
        boyTab.click();
        log.info("Click On Boy Tab");
    }


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Girl\"]")
    public WebElement girlTab;

    public void clickOnGirlTab(){
        AppiumUtils.waitForElementToBeClickable(driver,girlTab,10);
        girlTab.click();
        log.info("Click On Girl Tab");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"AvatarSelection-5\"]/android.widget.ImageView")
    public WebElement boyAvtar;

    public void clickOnBoyAvtar(){
        AppiumUtils.waitForElementToBeClickable(driver,boyAvtar,10);
        boyAvtar.click();
        log.info("Click On Boy Avtar");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"AvatarSelection-6\"]/android.widget.ImageView")
    public WebElement girlAvtar;

    public void clickOnGirlAvtar(){
        AppiumUtils.waitForElementToBeClickable(driver,girlAvtar,10);
        girlAvtar.click();
        log.info("Click On Girl Avtar");
    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"ChildDetails-childFirstNameInput\"]")
    public WebElement childName;

    public void enterChildName(String email) throws InterruptedException {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.EditText[@resource-id=\"ChildDetails-childFirstNameInput\"]"),10);
        childName.clear();
        Thread.sleep(2000);
        childName.sendKeys(email);
        log.info("Enter child name : "+childName);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"ChildDetails-standard\"]")
    public WebElement standardDropdown;

    public void clickOnStandardDropdown(){
        AppiumUtils.waitForElementToBeClickable(driver,standardDropdown,10);
        standardDropdown.click();
        log.info("Click On Standard Dropdown");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Submit\"]")
    public WebElement submitBtn;

    public void clickOnSubmitBtn(){
        AppiumUtils.waitForElementToBeClickable(driver,submitBtn,10);
        submitBtn.click();
        log.info("Click On Submit Button");
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Want to add another child?\"]")
    public WebElement addChildPopupText;

    public String getAchievementsScreen()
    {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text=\"Want to add another child?\"]"),10);
        return addChildPopupText.getText();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Yes\"]")
    public WebElement addChildYesBtn;

    public void clickOnAddChildYesBtn(){
        AppiumUtils.waitForElementToBeClickable(driver,addChildYesBtn,10);
        addChildYesBtn.click();
        log.info("Click On Yes Button");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"No\"]")
    public WebElement addChildNoBtn;

    public void clickOnAddChildNoBtn(){
        AppiumUtils.waitForElementToBeClickable(driver,addChildNoBtn,10);
        addChildNoBtn.click();
        log.info("Click On No Button");
    }




}
