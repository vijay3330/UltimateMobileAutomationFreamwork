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

public class AchievementsPage {
    private static final Logger log = LogManager.getLogger(AchievementsPage.class);

    AndroidDriver driver;
    public AchievementsPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "(//android.widget.TextView[@index='0'])[6]")
    public WebElement addAchievementsButton;

    public void clickOnAddAchievementsButton(){
        AppiumUtils.waitForElementToBeClickable(driver,addAchievementsButton,10);
        addAchievementsButton.click();
        log.info("Click On Add Achievement");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Sports\"]")
    public WebElement sportsCategory;

    public void clickOnSportsCategory(){
        AppiumUtils.waitForElementToBeClickable(driver,sportsCategory,10);
        sportsCategory.click();
        log.info("Click On Sports Category");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Dance-Drama\"]")
    public WebElement dramaCategory;

    public void clickOnDramaCategory(){
        AppiumUtils.waitForElementToBeClickable(driver,dramaCategory,10);
        dramaCategory.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Art-Music\"]")
    public WebElement artMusicCategory;

    public void clickOnArtMusicCategory(){
        AppiumUtils.waitForElementToBeClickable(driver,artMusicCategory,10);
        artMusicCategory.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Technology\"]")
    public WebElement technologyCategory;

    public void clickOnTechnologyCategory(){
        AppiumUtils.waitForElementToBeClickable(driver,technologyCategory,10);
        technologyCategory.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Academics\"]")
    public WebElement academicsCategory;

    public void clickOnAcademicsCategory(){
        AppiumUtils.waitForElementToBeClickable(driver,academicsCategory,10);
        academicsCategory.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Others\"]")
    public WebElement othersCategory;

    public void clickOnOthersCategory(){
        AppiumUtils.waitForElementToBeClickable(driver,othersCategory,10);
        othersCategory.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Achievement\"]")
    public WebElement achievementDropDown;

    public void clickOnAchievementDropDown(){
        AppiumUtils.waitForElementToBeClickable(driver,achievementDropDown,10);
        achievementDropDown.click();
        log.info("Click On Achievement Dropdown");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Proficiency Level\"]")
    public WebElement proficiencyLevelDropDown;

    public void clickOnProficiencyLevelDropDown(){
        AppiumUtils.waitForElementToBeClickable(driver,proficiencyLevelDropDown,10);
        proficiencyLevelDropDown.click();
        log.info("Click On Proficiency Level Dropdown");
    }

    @FindBy(xpath = "//android.widget.EditText[@text=\"E.g. First prize \"]")
    public WebElement descriptionTextBox;

    public void enterDescription(String des){
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.EditText[@text=\"E.g. First prize \"]"),10);
        descriptionTextBox.sendKeys(des);
        log.info("Enter Description : "+des);
    }

    @FindBy(xpath = "(//android.widget.TextView)[17]")
    public WebElement datePicker;

    public void clickOnDatepicker(){
        AppiumUtils.waitForElementToBeClickable(driver,datePicker,10);
        datePicker.click();
        log.info("Click on datepicker");
    }

    @FindBy(xpath = "(//android.widget.TextView[@text='Points']/following-sibling::android.view.ViewGroup/android.widget.TextView)[1]")
    public WebElement points;

    public String getPoints(){
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("(//android.widget.TextView[@text='Points']/following-sibling::android.view.ViewGroup/android.widget.TextView)[1]"),10);
        return points.getText();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@index='19']")
    public WebElement addMemories1;

    public void uploadMemories1(){
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.view.ViewGroup[@index='21']"),10);
        addMemories1.click();
        log.info("Click on addMemories1");
    }

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_all_button\"]")
    public WebElement permission;//android.widget.Button[@resource-id="com.android.permissioncontroller:id/permission_allow_foreground_only_button"]
    //android.widget.Button[@resource-id="com.android.permissioncontroller:id/permission_allow_all_button"]
    public void getPermission(){
        AppiumUtils.waitForElementToBeClickable(driver,permission,10);
        permission.click();
        log.info("Click on permission");
    }

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
    public WebElement chooseFromGallery;

    public void clickOnChooseFromGallery(){
        AppiumUtils.waitForElementToBeClickable(driver,chooseFromGallery,10);
        chooseFromGallery.click();
        log.info("Click on Choose From Gallery");
    }

    @FindBy(xpath = "//android.widget.Button[@text='SELECT MEDIA']")
    public WebElement selectMedia;

    public void clickOnSelectMedia(){
        AppiumUtils.waitForElementToBeClickable(driver,selectMedia,10);
        selectMedia.click();
        log.info("Click on Select Media");
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")
    public WebElement submitButton;

    public void clickOnSubmitButton(){
        AppiumUtils.waitForElementToBeClickable(driver,submitButton,10);
        submitButton.click();
        log.info("Click on submit ");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Reset\"]")
    public WebElement resetButton;

    public void clickOnResetButton(){
        AppiumUtils.waitForElementToBeClickable(driver,resetButton,10);
        resetButton.click();
        log.info("Click on Reset");
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Close\"]s")
    public WebElement closeButton;

    public void clickOnCloseButton(){
        AppiumUtils.waitForElementToBeClickable(driver,closeButton,10);
        closeButton.click();
        log.info("Click on close Button");
    }


}
