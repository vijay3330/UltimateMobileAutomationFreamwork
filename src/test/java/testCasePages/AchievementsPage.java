package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import utils.AppiumUtils;

public class AchievementsPage {

    AndroidDriver driver;
    public AchievementsPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "(//android.widget.TextView[@index='0'])[8]")
    public WebElement addAchievementsButton;

    public void clickOnAddAchievementsButton(){
        AppiumUtils.waitForElementToBeClickable(driver,addAchievementsButton,10);
        addAchievementsButton.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Sports\"]")
    public WebElement sportsCategory;

    public void clickOnSportsCategory(){
        AppiumUtils.waitForElementToBeClickable(driver,sportsCategory,10);
        sportsCategory.click();
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
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Proficiency Level\"]")
    public WebElement proficiencyLevelDropDown;

    public void clickOnProficiencyLevelDropDown(){
        AppiumUtils.waitForElementToBeClickable(driver,proficiencyLevelDropDown,10);
        proficiencyLevelDropDown.click();
    }

    @FindBy(xpath = "//android.widget.EditText[@text=\"E.g. First prize \"]")
    public WebElement descriptionTextBox;

    public void enterDescription(String des){
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.EditText[@text=\"E.g. First prize \"]"),10);
        descriptionTextBox.sendKeys(des);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@index='16']")
    public WebElement datePicker;

    public void enterDate(String date){
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.view.ViewGroup[@index='16']"),10);
        datePicker.sendKeys(date);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@index='17']")
    public WebElement points;

    public String getPoints(){
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.view.ViewGroup[@index='17']"),10);
        return points.getText();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@index='19']")
    public WebElement addMemories1;

    public void uploadMemories1(String up1){
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.view.ViewGroup[@index='19']"),10);
        addMemories1.sendKeys(up1);
    }

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
    public WebElement permission;

    public void getPermission(){
        AppiumUtils.waitForElementToBeClickable(driver,permission,10);
        permission.click();
    }

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
    public WebElement chooseFromGallery;

    public void clickOnChooseFromGallery(){
        AppiumUtils.waitForElementToBeClickable(driver,chooseFromGallery,10);
        chooseFromGallery.click();
    }

    @FindBy(xpath = "//android.widget.Button[@text='SELECT MEDIA']")
    public WebElement selectMedia;

    public void clickOnSelectMedia(){
        AppiumUtils.waitForElementToBeClickable(driver,selectMedia,10);
        selectMedia.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Submit\"]")
    public WebElement submitButton;

    public void clickOnSubmitButton(){
        AppiumUtils.waitForElementToBeClickable(driver,submitButton,10);
        submitButton.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Reset\"]")
    public WebElement resetButton;

    public void clickOnResetButton(){
        AppiumUtils.waitForElementToBeClickable(driver,resetButton,10);
        resetButton.click();
    }

}
