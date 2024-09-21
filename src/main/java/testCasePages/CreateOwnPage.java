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

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Submit\"]")
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

    public String toastMsg()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.id("toastText1"),10);
        return activityAlreadyCreatedErrorMsg.getText();
    }


    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"createOwn-activityOccurance-ONCE\"]/android.widget.RadioButton/android.view.ViewGroup")
    public WebElement onceRadioBtn;

    public void clickOnOnceRadioBtn()
    {
        AppiumUtils.waitForElementToBeClickable(driver,onceRadioBtn,10);
        onceRadioBtn.click();
        log.info("Click on Once.....");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"createOwn-activityOccurance-EVERY_DAY\"]/android.widget.RadioButton/android.view.ViewGroup")
    public WebElement EveryDayRadioBtn;

    public void clickOnEveryDayRadioBtn()
    {
        AppiumUtils.waitForElementToBeClickable(driver,EveryDayRadioBtn,10);
        EveryDayRadioBtn.click();
        log.info("Click on Every Day.....");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"createOwn-activityOccurance-EVERY_WEEK\"]/android.widget.RadioButton/android.view.ViewGroup")
    public WebElement EveryWeekRadioBtn;

    public void clickOnEveryWeekRadioBtn()
    {
        AppiumUtils.waitForElementToBeClickable(driver,EveryWeekRadioBtn,10);
        EveryWeekRadioBtn.click();
        log.info("Click on Every Week.....");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"createOwn-activityOccurance-EVERY_MONTH\"]")
    public WebElement EveryMonthRadioBtn;

    public void clickOnEveryMonthRadioBtn()
    {
        AppiumUtils.waitForElementToBeClickable(driver,EveryMonthRadioBtn,10);
        EveryMonthRadioBtn.click();
        log.info("Click on Every Month.....");
    }


    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"createOwn-activityTimeRequired\"]")
    public WebElement timeRequiredTextbox;

    public void enterTimeRequired(String time)
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.EditText[@resource-id=\"createOwn-activityTimeRequired\"]"),10);
        timeRequiredTextbox.sendKeys(time);
        log.info("Entered Time Required : "+time);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Assign\"]")
    public WebElement assignBtn;

    public void clickOnAssignBtn()
    {
        AppiumUtils.waitForElementToBeClickable(driver,assignBtn,10);
        assignBtn.click();
        log.info("Click on assign button .....");
    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"createOwn-activityEndAfterDaysInput\"]")
    public WebElement endAfterDayTextbox;

    public void enterEndAfterDay(String day)
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.EditText[@resource-id=\"createOwn-activityEndAfterDaysInput\"]"),10);
        timeRequiredTextbox.sendKeys(day);
        log.info("Entered End After : "+day);
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"YAY! IT'S ASSIGNED\"]")
    public WebElement activityAssignedSuccessMsg;

    public String getActivityAssignedSuccessMsg()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.TextView[@text=\"YAY! IT'S ASSIGNED\"]"),10);
        return activityAssignedSuccessMsg.getText();
    }


    @FindBy(xpath = "(//android.widget.TextView[@text='Start Date']/following-sibling::android.view.ViewGroup/android.widget.TextView)[1]")
    public WebElement activityStartDate;

    public String getActivityStartDate()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("(//android.widget.TextView[@text='Start Date']/following-sibling::android.view.ViewGroup/android.widget.TextView)[1]"),10);
        return activityStartDate.getText();
    }


    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"createOwn-activityEndAfterDate\"]")
    public WebElement onceActivityEndDate;

    public String getOnceActivityEndDate()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.TextView[@resource-id=\"createOwn-activityEndAfterDate\"]"),10);
        return onceActivityEndDate.getText();
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"createOwn-activityEndAfterDaysDate\"]")
    public WebElement everyDayActivityEndDate;

    public String getEveryDayActivityEndDate()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.TextView[@resource-id=\"createOwn-activityEndAfterDaysDate\"]"),10);
        return everyDayActivityEndDate.getText();
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"createOwn-activityEndAfterWeeksDate\"]")
    public WebElement everyWeekActivityEndDate;

    public String getEveryWeekActivityEndDate()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.TextView[@resource-id=\"createOwn-activityEndAfterWeeksDate\"]"),10);
        return everyWeekActivityEndDate.getText();
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"createOwn-assignActivityEndDateAfterMonths\"]")
    public WebElement everyMonthActivityEndDate;

    public String getEveryMonthActivityEndDate()
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.TextView[@resource-id=\"createOwn-activityEndAfterWeeksDate\"]"),10);
        return everyMonthActivityEndDate.getText();
    }

    @FindBy(xpath = "(//android.view.ViewGroup)[15]")
    public WebElement datePicker;

    public void clickOnDatePicker()
    {
        AppiumUtils.waitForElementToBeClickable(driver,datePicker,10);
        datePicker.click();
        log.info("Click on date picker....");
    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"createOwn-activityCompleteByOfMonthInput\"]")
    public WebElement activityCompletedByTextbox;

    public void enterActivityCompletedByTextbox(String day)
    {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("//android.widget.EditText[@resource-id=\"createOwn-activityCompleteByOfMonthInput\"]"),10);
        activityCompletedByTextbox.sendKeys(day);
        log.info("Completed By Day : "+day);
    }

}