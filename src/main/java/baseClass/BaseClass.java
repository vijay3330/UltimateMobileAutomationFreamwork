package baseClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
    public static final Logger log = LogManager.getLogger(BaseClass.class);
    public static AndroidDriver driver;
    public static AppiumDriverLocalService appiumService;


    @BeforeTest
    public void setup() throws InterruptedException, MalformedURLException {
         startAppiumServer();

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

     //   driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), dc);
        driver = new AndroidDriver(appiumService.getUrl(), dc);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Thread.sleep(5000);
        log.info("App open");
        Thread.sleep(5000);
    }

    public void startAppiumServer() {
        // Build Appium service
        appiumService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .usingAnyFreePort() // Can specify a fixed port using usingPort(4723) if needed
                .build();

        // Start the server
        appiumService.start();
        log.info("Appium server started at: " + appiumService.getUrl());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Driver closed.");
        }

        // Stop Appium server
        if (appiumService != null && appiumService.isRunning()) {
            appiumService.stop();
            log.info("Appium server stopped.");
        }
    }
}
