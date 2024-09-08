package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AppiumUtils;

public class LoginPage
{
    AndroidDriver driver;
    public LoginPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(driver,this);
    }

    //android.widget.EditText[@text='Enter Email Address or Number']
    @FindBy(xpath = "(//android.widget.EditText[@index='0'])[1]")
    public WebElement username;

    public void enterUsername(String uname) throws InterruptedException {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("(//android.widget.EditText[@index='0'])[1]"),10);
        username.clear();
        Thread.sleep(2000);
        username.sendKeys(uname);
    }

    //android.widget.EditText[@text='Passcode']
    @FindBy(xpath = "(//android.widget.EditText[@index='0'])[2]")
    private WebElement passcode;

    public void enterPassword(String pass) throws InterruptedException {
        AppiumUtils.waitForElementToBeVisible(driver,By.xpath("(//android.widget.EditText[@index='0'])[2]"),10);
        passcode.clear();
        Thread.sleep(2000);
        passcode.sendKeys(pass);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Login']")
    private WebElement loginBtn;

    public void clickLogin(){
        AppiumUtils.waitForElementToBeClickable(driver,loginBtn,10);
        loginBtn.click();
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Forgot Passcode?']")
    private WebElement forgotPasscode;

    public void clickForgotPasscode() {
        AppiumUtils.waitForElementToBeClickable(driver,forgotPasscode,10);
        forgotPasscode.click();
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Don't have an account? Sign Up']")
    private WebElement signUp;

    public void clickOnSignUp()
    {
        AppiumUtils.waitForElementToBeClickable(driver,signUp,10);
        signUp.click();
    }

}