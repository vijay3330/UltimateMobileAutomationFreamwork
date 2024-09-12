package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static baseClass.BaseClass.driver;

public class MyListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(MyListener.class);
    @Override
    public void onFinish(ITestContext contextFinish) {
        log.info("Finishing Test Execution");
    }

    @Override
    public void onStart(ITestContext contextStart) {
        log.info("Starting Test Execution");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test failed"+ result.getName());
        String screenshotName = "FailedTest "+result.getName() + System.currentTimeMillis();
        AppiumUtils.captureScreenshot(driver, screenshotName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("Test skipped"+ result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test started"+ result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test passed"+ result.getName());
    }
}
