package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AppiumUtils;

public class CreateOwnPage {
    private static final Logger log = LogManager.getLogger(CreateOwnPage.class);
    AndroidDriver driver;

    public CreateOwnPage(AndroidDriver d) {
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='createOwn-openCreateOwnFormButton']")
    public WebElement createActivity;

    public void clickOnCreateActivity() {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.view.ViewGroup[@resource-id='createOwn-openCreateOwnFormButton']"),10);
        createActivity.click();
        log.info("Click on CreateActivity");
    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id='createOwn-activityTitleInput']")
    public WebElement activityTitleTextbox;

    public void enterActivityTitle(String title)
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.EditText[@resource-id='createOwn-activityTitleInput']"),10);
        activityTitleTextbox.sendKeys(title);
        log.info("Title entered : "+title);

    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id='createOwn-activityDescriptionInput']")
    public WebElement descriptionTextbox;

    public void enterDescription(String desc)
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.EditText[@resource-id='createOwn-activityDescriptionInput']"),10);
        descriptionTextbox.sendKeys(desc);
        log.info("Description entered : "+desc);
    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id='createOwn-MaterialRequiredInput']")
    public WebElement materialTextbox;

    public void enterMaterialRequired(String desc)
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.EditText[@resource-id='createOwn-MaterialRequiredInput']"),10);
        materialTextbox.sendKeys(desc);
        log.info("materialRequired : "+desc);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='createOwn-activityFormPreviewButton']")
    public WebElement previewButton;

    public void clickOnPreview()
    {
        AppiumUtils.waitForElementToBeClickable(driver,previewButton,10);
        previewButton.click();
        log.info("Click On Preview");
    }


    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='createOwn-activityFormEditButton']")
    public WebElement editButton;

    public void clickOnEdit()
    {
        AppiumUtils.waitForElementToBeClickable(driver,editButton,10);
        editButton.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='createOwn-activityFormSubmitButton']")
    public WebElement submitButton;

    public void clickOnSubmit()
    {
        AppiumUtils.waitForElementToBeClickable(driver,submitButton,10);
        submitButton.click();
        log.info("Click On Submit");
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"ACTIVITY CREATED SUCCESSFULLY\"]")
    public WebElement createdMessage;

    public String getCreatedMessage()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.TextView[@text=\"ACTIVITY CREATED SUCCESSFULLY\"]"),10);
        return createdMessage.getText();
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Close\"]")
    public WebElement closeButton;

    public void clickOnClose()
    {
        AppiumUtils.waitForElementToBeClickable(driver,closeButton,10);
        closeButton.click();
        log.info("Click on Close.....");
    }

    @FindBy(xpath = "(//android.widget.TextView[@index='0'])[1]")
    public WebElement backButton;

    public void clickOnBack()
    {
        AppiumUtils.waitForElementToBeClickable(driver,backButton,10);
        backButton.click();
        log.info("Click on Back from Create Own Page.....");
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Enter Activity Title\"]")
    public WebElement activityTitleErrorMsg;

    public String getActivityTitleErrorMsg()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.TextView[@text=\"Enter Activity Title\"]"),10);
        return activityTitleErrorMsg.getText();
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Enter Activity Description\"]")
    public WebElement activityDescriptionErrorMsg;

    public String getActivityDescriptionErrorMsg()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.TextView[@text=\"Enter Activity Description\"]"),10);
        return activityDescriptionErrorMsg.getText();
    }

    @FindBy(id = "toastText1")
    public WebElement activityAlreadyCreatedErrorMsg;

    public String getActivityAlreadyCreatedErrorMsg()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.id("toastText1"),10);
        return activityAlreadyCreatedErrorMsg.getText();
    }

}