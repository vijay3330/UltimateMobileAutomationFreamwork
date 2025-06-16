package baseClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
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
      //  dc.setCapability("deviceName", "OnePlus CPH2401");
        dc.setCapability("deviceName", "FQ99IJ7HK7R4KNBU");
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("disableWindowAnimation",true);
        dc.setCapability("noReset",true);
        dc.setCapability("ignoreHiddenApiPolicyError",true);
        dc.setCapability("appPackage", "com.ultimate_bond");
        dc.setCapability("appActivity", "com.ultimate_bond.MainActivity");

     //   driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), dc);
          driver = new AndroidDriver(appiumService.getUrl(), dc);
//        driver = new AndroidDriver(new URL(appiumService.getUrl().toString() + "wd/hub"), dc);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Thread.sleep(5000);
        log.info("App open");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Skip\"]")).click();
        log.info("Click On Overview Screen Skip button");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.ImageView")).click();
        log.info("Click On Dummy Home Page");
        Thread.sleep(5000);
    }

//    public void startAppiumServer() {
//        // Build Appium service
//        appiumService = new AppiumServiceBuilder()
//                .withAppiumJS(new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"))
//                .usingPort(4723) // Can specify a fixed port using usingPort(4723) if needed
//                .build();
//
//        // Start the server
//        appiumService.start();
//        log.info("Appium server started at: " + appiumService.getUrl());
//
//    }

    public void startAppiumServer() {
        // Build Appium service
        appiumService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .usingPort(4723) // Fixed port
                .build();

        try {
            // Start the server
            appiumService.start();

            // Wait until the server responds or timeout
            long startTime = System.currentTimeMillis();
            long timeout = 60000; // 60 seconds
            while (!appiumService.isRunning()) {
                if (System.currentTimeMillis() - startTime > timeout) {
                    throw new RuntimeException("Timed out waiting for Appium server to start");
                }
                Thread.sleep(10000); // Polling interval
            }

            log.info("Appium server started at: " + appiumService.getUrl());
        } catch (Exception e) {
            log.error("Error starting Appium server: ", e);
            throw new RuntimeException(e);
        }
    }


//    @AfterTest
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            log.info("Driver closed.");
//        }
//
//        // Stop Appium server
//        if (appiumService != null && appiumService.isRunning()) {
//            appiumService.stop();
//            log.info("Appium server stopped.");
//        }
//    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Driver closed.");
        } else {
            log.warn("Driver was null during teardown.");
        }

        if (appiumService != null && appiumService.isRunning()) {
            appiumService.stop();
            log.info("Appium server stopped.");
        } else {
            log.warn("Appium server was not running during teardown.");
        }
    }

}
