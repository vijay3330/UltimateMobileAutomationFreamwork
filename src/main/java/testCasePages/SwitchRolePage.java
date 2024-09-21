package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AppiumUtils;

public class SwitchRolePage {

    private static final Logger log = LogManager.getLogger(SwitchRolePage.class);
    AndroidDriver driver;

    public SwitchRolePage(AndroidDriver d) {
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"passwordInput\"]")
    public WebElement passcodeInputTextBox;

    public void enterPasscode(String passcode) throws InterruptedException {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.EditText[@resource-id=\"passwordInput\"]"), 10);
        passcodeInputTextBox.clear();
        Thread.sleep(3000);
        passcodeInputTextBox.sendKeys(passcode);
        log.info("Passcode Enter : "+passcode);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Submit\"]")
    public WebElement passcodeSubmitBtn;

    public void clickOnPasscodeSubmitBtn()
    {
        AppiumUtils.waitForElementToBeClickable(driver,passcodeSubmitBtn,10);
        passcodeSubmitBtn.click();
        log.info("Click on submit button .....");
    }

}
