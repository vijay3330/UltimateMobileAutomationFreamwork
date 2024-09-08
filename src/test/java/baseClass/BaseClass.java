package baseClass;

import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ReportManager;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {

   public AndroidDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException, MalformedURLException {
//        DesiredCapabilities dc= new DesiredCapabilities();
//        dc.setCapability("deviceName", "Android Emulator");
//        dc.setCapability("platformName", "Android");
//        dc.setCapability("automationName", "UiAutomator2");
//        dc.setCapability("appPackage", "com.ultimate");
//        dc.setCapability("appActivity", "com.ultimate.MainActivity");
        ReportManager.setupReport();
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
        System.out.println("App open");
    }


    @AfterTest
    public void tearDown(ITestResult result)
    {   if (result.getStatus() == ITestResult.FAILURE) {
        ReportManager.test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
    } else if (result.getStatus() == ITestResult.SUCCESS) {
        ReportManager.test.log(Status.PASS, "Test Passed");
    } else if (result.getStatus() == ITestResult.SKIP) {
        ReportManager.test.log(Status.SKIP, "Test Skipped");
    }
        driver.quit();
    }

}
