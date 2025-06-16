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

public class BookListPage {

    private static final Logger log = LogManager.getLogger(BookListPage.class);
    AndroidDriver driver;
    public BookListPage(AndroidDriver d)
    {
        driver = d;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Book List\"]")
    public WebElement bookListScreen;

    public String getbookListScreen()
    {
        AppiumUtils.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text=\"Book List\"]"),10);
        return bookListScreen.getText();
    }



}
