package tests;

import baseClass.BaseClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testCasePages.*;
import utils.AppiumUtils;
import utils.ReportManager;

public class createActivityTest extends BaseClass {

    private static final Logger log = LoggerFactory.getLogger(createActivityTest.class);
    LoginPage loginpage;
    ProfileSelectionPage profileSelectionPage;
    HomePage homePage;
    MySpacePage mySpacePage;
    CreateOwnPage createOwnPage;

    @DataProvider(name = "activityData")
    public Object[][] getActivityData() {
        return AppiumUtils.getTestData("CreateOwn Test Data");
    }

    @Test(dataProvider = "activityData")
    public void testCreateActivity(String username, String password, String activityTitle, String description, String materialRequired, String expectedMsg) throws InterruptedException {
        ReportManager.startTest("createActivityTest testCreateActivity");
        int currentRow = 0; // Index to keep track of the current row in the Excel sheet
        try {
        loginpage = new LoginPage(driver);
        loginpage.enterUsername(username);
        loginpage.enterPassword(password);
        loginpage.clickLogin();
        log.info("Login.....");

        profileSelectionPage = new ProfileSelectionPage(driver);
        profileSelectionPage.clickOnParentProfile();
        log.info("Select profile..");

        homePage = new HomePage(driver);
        homePage.clickOnAssignment();
        log.info("Click on assignment");

        mySpacePage = new MySpacePage(driver);
        mySpacePage.clickOnCreateOwn();
        log.info("Click on CreateOwn");

        createOwnPage = new CreateOwnPage(driver);
        createOwnPage.clickOnCreateActivity();
        log.info("Click on CreateActivity");
        createOwnPage.enterActivityTitle(activityTitle);
        log.info("Title entered : "+activityTitle);
        createOwnPage.enterDescription(description);
        log.info("Description entered : "+description);
        createOwnPage.enterMaterialRequired(materialRequired);
        log.info("materialRequired : "+materialRequired);
        createOwnPage.clickOnPreview();
        log.info("Click On Preview");
        createOwnPage.clickOnSubmit();
        log.info("Click On Submit");

        String actualmsg = createOwnPage.getCreatedMessage();

        log.info("Actual Message : " + actualmsg);
        log.info("Expected Message : " + expectedMsg);
        Assert.assertEquals(actualmsg, expectedMsg);
        log.info("Testcase Pass.....");

        createOwnPage.clickOnClose();
        log.info("Click on Close.....");
        createOwnPage.clickOnBack();
        log.info("Click on Back from Create Own Page.....");
        mySpacePage.clickOnBack();
        log.info("Click on Back from Myspace.....");

        homePage.clickOnMenuButton();
        log.info("Click on Menu button from home.....");
        homePage.clickOnLogoutIcon();
        log.info("Click on logout icon from home.....");
        homePage.clickOnLogoutButton();
        log.info("Click on logout button from home.....");

        AppiumUtils.writeResultToExcel("CreateOwn Test Data", currentRow + 1, 6, "PASS");

        } catch (Exception e) {
        // Capture screenshot on failure
        String screenshotName = "FailedTest_testCreateActivity" + System.currentTimeMillis();
        AppiumUtils.captureScreenshot(driver, screenshotName);

        // Write FAIL to Excel
        AppiumUtils.writeResultToExcel("CreateOwn Test Data", currentRow + 1, 6, "FAIL");

        e.printStackTrace(); // Print the exception
        Assert.fail("Test failed due to an exception");
    }finally {
            currentRow++; // Move to the next row for the next test iteration
            ReportManager.flushReport();
        }
    }
}