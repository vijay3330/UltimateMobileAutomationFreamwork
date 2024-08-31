package testCasePages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AppiumUtils;

import javax.xml.xpath.XPath;

public class ProfileSelectionPage
{
    AndroidDriver driver;
    public ProfileSelectionPage(AndroidDriver d)
    {
        driver=d;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Satish\"]/android.view.ViewGroup/android.widget.ImageView")
    public WebElement parentProfile;

    public void clickOnParentProfile(){
        AppiumUtils.waitForElementToBeClickable(driver,parentProfile,10);
        parentProfile.click();
    }

}
