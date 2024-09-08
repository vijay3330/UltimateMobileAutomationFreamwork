package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AppiumUtils;

public class MySpacePage {

    AndroidDriver driver;

    public MySpacePage(AndroidDriver d)
    {
        driver=d;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Create Own\"]/android.view.ViewGroup/android.widget.ImageView")
    public WebElement createOwn;

    public void clickOnCreateOwn()
    {
        AppiumUtils.waitForElementToBeClickable(driver,createOwn,10);
        createOwn.click();
    }

    @FindBy(xpath = "(//android.widget.TextView[@index='0'])[1]")
    public WebElement backButton;

    public void clickOnBack()
    {
        AppiumUtils.waitForElementToBeClickable(driver,backButton,10);
        backButton.click();
    }

}
