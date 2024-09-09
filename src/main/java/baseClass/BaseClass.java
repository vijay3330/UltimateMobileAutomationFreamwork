package baseClass;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
    public static final Logger log = LogManager.getLogger(BaseClass.class);
   public static AndroidDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException, MalformedURLException {
//        DesiredCapabilities dc= new DesiredCapabilities();
//        dc.setCapability("deviceName", "Android Emulator");
//        dc.setCapability("platformName", "Android");
//        dc.setCapability("automationName", "UiAutomator2");
//        dc.setCapability("appPackage", "com.ultimate");
//        dc.setCapability("appActivity", "com.ultimate.MainActivity");

        DesiredCapabilities dc= new DesiredCapabilities();
        dc.setCapability("deviceName", "OnePlus CPH2401");
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("disableWindowAnimation",true);
        dc.setCapability("noReset",true);
        dc.setCapability("ignoreHiddenApiPolicyError",true);
        dc.setCapability("appPackage", "com.ultimate");
        dc.setCapability("appActivity", "com.ultimate.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), dc);
        Thread.sleep(5000);
        log.info("App open");
        Thread.sleep(5000);
    }


    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

}
