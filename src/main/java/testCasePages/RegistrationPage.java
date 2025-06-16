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

public class RegistrationPage {

    private static final Logger log = LogManager.getLogger(RegistrationPage.class);
    AndroidDriver driver;
    public RegistrationPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"ParentRegister-firstNameInput\"]")
    public WebElement firstName;

    public void enterFirstName(String fname) throws InterruptedException {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.EditText[@resource-id=\"login-emailContactInput\"]"),10);
        firstName.clear();
        Thread.sleep(2000);
        firstName.sendKeys(fname);
        log.info("Enter First Name : "+fname);
    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"ParentRegister-lastNameInput\"]")
    public WebElement lasttName;

    public void enterLastName(String Lname) throws InterruptedException {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.EditText[@resource-id=\"ParentRegister-lastNameInput\"]"),10);
        lasttName.clear();
        Thread.sleep(2000);
        lasttName.sendKeys(Lname);
        log.info("Enter Last Name : "+Lname);
    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"ParentRegister-emailInput\"]")
    public WebElement emailAddress;

    public void enteremailAddress(String email) throws InterruptedException {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.EditText[@resource-id=\"ParentRegister-emailInput\"]"),10);
        emailAddress.clear();
        Thread.sleep(2000);
        emailAddress.sendKeys(email);
        log.info("Enter Email : "+email);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"+91\"]")
    public WebElement contactNumberDropDown;

    public void clickOnContactNumberDropDown(){
        AppiumUtils.waitForElementToBeClickable(driver,contactNumberDropDown,10);
        contactNumberDropDown.click();
        log.info("Click On Contact  Dropdown");
    }

    @FindBy(xpath = "//android.widget.EditText[@text=\"Contact Number\"]")
    public WebElement contactNumber;

    public void entereContactNumber(String cnumber) throws InterruptedException {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.EditText[@text=\"Contact Number\"]"),10);
        contactNumber.clear();
        Thread.sleep(2000);
        contactNumber.sendKeys(cnumber);
        log.info("Enter Contact Number : "+cnumber);
    }

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"RNE__Checkbox__Icon\"])[1]")
    public WebElement checkBox1;

    public void clickOnCheckBox1(){
        AppiumUtils.waitForElementToBeClickable(driver,checkBox1,10);
        checkBox1.click();
        log.info("Click On Check Box 1");
    }

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"RNE__Checkbox__Icon\"])[2]")
    public WebElement checkBox2;

    public void clickOnCheckBox2(){
        AppiumUtils.waitForElementToBeClickable(driver,checkBox2,10);
        checkBox1.click();
        log.info("Click On Check Box 2");
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Continue\"]")
    public WebElement ContinueBtn;

    public void clickOnContinueBtn(){
        AppiumUtils.waitForElementToBeClickable(driver,ContinueBtn,10);
        ContinueBtn.click();
        log.info("Click On Continue");
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"ParentRegister-LoginLink\"]")
    public WebElement loginBtn;

    public void clickOnLoginBtn(){
        AppiumUtils.waitForElementToBeClickable(driver,loginBtn,10);
        loginBtn.click();
        log.info("Click On Login Btn");
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Help\"]")
    public WebElement help;

    public void clickOnHelp(){
        AppiumUtils.waitForElementToBeClickable(driver,help,10);
        help.click();
        log.info("Click On help");
    }

}
