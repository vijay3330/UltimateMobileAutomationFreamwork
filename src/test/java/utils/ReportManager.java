package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setupReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void flushReport() {
        extent.flush();
    }
}
