package testCasePages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AppiumUtils;

public class LoginPage
{
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    AndroidDriver driver;
    public LoginPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(driver,this);
    }

    //android.widget.EditText[@text='Enter Email Address or Number']
    @FindBy(xpath = "//android.widget.EditText[@text=\"Email or Number\"]")
    public WebElement username;

    public void enterUsername(String uname) throws InterruptedException {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.EditText[@text=\"Email or Number\"]"),10);
        username.clear();
        Thread.sleep(2000);
        username.sendKeys(uname);
        log.info("Enter Username : "+uname);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Continue\"]")
    public WebElement continueBtn;

    public void clickOnContinue()
    {
        AppiumUtils.waitForElementToBeClickable(driver,continueBtn,10);
        continueBtn.click();
        log.info("Click On Continue ");
    }
    //android.widget.EditText[@text='Passcode']
//    @FindBy(xpath = "(//android.widget.EditText[@index='0'])[2]")
//    private WebElement passcode;

    public void enterPassword(String passcode) throws InterruptedException {
//        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("(//android.widget.EditText[@index='0'])[2]"),10);
//        passcode.clear();
//        Thread.sleep(2000);
//        passcode.sendKeys(pass);
//        log.info("Enter Passcode : "+pass);
        for (char digit : passcode.toCharArray()) {
            // Find the ViewGroup that corresponds to the digit based on content-desc
            WebElement digitElement = driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiSelector().className(\"android.view.ViewGroup\").description(\"" + digit + "\")"
            ));
            digitElement.click();
        }
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Login']")
    private WebElement loginBtn;

    public void clickLogin(){
        AppiumUtils.waitForElementToBeClickable(driver,loginBtn,10);
        loginBtn.click();
        log.info("Click On Login ");
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Forgot Passcode?']")
    private WebElement forgotPasscode;

    public void clickForgotPasscode() {
        AppiumUtils.waitForElementToBeClickable(driver,forgotPasscode,10);
        forgotPasscode.click();
        log.info("Click On Forgot Passcode");

    }

    @FindBy(xpath = "//android.widget.TextView[@text='Don't have an account? Sign Up']")
    private WebElement signUp;

    public void clickOnSignUp()
    {
        AppiumUtils.waitForElementToBeClickable(driver,signUp,10);
        signUp.click();
        log.info("Click On SignUp");
    }

}