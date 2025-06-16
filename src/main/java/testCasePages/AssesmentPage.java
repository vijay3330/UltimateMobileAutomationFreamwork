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

public class AssesmentPage {

    private static final Logger log = LogManager.getLogger(AssesmentPage.class);
    AndroidDriver driver;
    public AssesmentPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.view.View[@text=\"Child Assessment\"]")
    public WebElement childAssesmentScreen;

    public String getchildAssesmentScreen()
    {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.view.View[@text=\"Child Assessment\"]"),10);
        return childAssesmentScreen.getText();
    }

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public WebElement childAssessmnetBackButton;

    public void clickOnChildAssessmnetBackButton(){
        AppiumUtils.waitForElementToBeClickable(driver,childAssessmnetBackButton,10);
        childAssessmnetBackButton.click();
        log.info("Click On Expand Button");
    }

}
