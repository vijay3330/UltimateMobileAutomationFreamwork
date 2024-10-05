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

public class ApproveReadingPage {

    private static final Logger log = LogManager.getLogger(ApproveReadingPage.class);

    AndroidDriver driver;
    public ApproveReadingPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Total Reading Minutes')]")
    public WebElement totalMin;

    public String getTotalMinutes()
    {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[contains(@text,'Total Reading Minutes')]"),10);
        return totalMin.getText();
    }

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'Approve')]")
    public WebElement approveButton;

    public void clickOnApproveButton()
    {
        AppiumUtils.waitForElementToBeClickable(driver,approveButton,10);
        approveButton.click();
        log.info("Click On Approve Button .....");
    }


}
