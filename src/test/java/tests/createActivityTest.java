package tests;

import baseClass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testCasePages.*;
import utils.AppiumUtils;

public class createActivityTest extends BaseClass {

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
    try {
        loginpage = new LoginPage(driver);
        loginpage.enterUsername(username);
        loginpage.enterPassword(password);
        loginpage.clickLogin();
        System.out.println("Login.....");

        profileSelectionPage = new ProfileSelectionPage(driver);
        profileSelectionPage.clickOnParentProfile();
        System.out.println("Select profile..");

        homePage = new HomePage(driver);
        homePage.clickOnAssignment();
        System.out.println("Click on assignment");

        mySpacePage = new MySpacePage(driver);
        mySpacePage.clickOnCreateOwn();
        System.out.println("Click on CreateOwn");

        createOwnPage = new CreateOwnPage(driver);
        createOwnPage.clickOnCreateActivity();
        System.out.println("Click on CreateActivity");
        createOwnPage.enterActivityTitle(activityTitle);
        System.out.println("Title entered");
        createOwnPage.enterDescription(description);
        System.out.println("Description entered");
        createOwnPage.enterMaterialRequired(materialRequired);
        System.out.println("Material entered");
        createOwnPage.clickOnPreview();
        System.out.println("Click On Preview");
        createOwnPage.clickOnSubmit();
        System.out.println("Click On Submit");

        String actualmsg = createOwnPage.getCreatedMessage();
        System.out.println("Actual Message : " + actualmsg);
        System.out.println("Expected Message : " + expectedMsg);
        Assert.assertEquals(actualmsg, expectedMsg);
        System.out.println("Testcase Pass.....");

        createOwnPage.clickOnClose();
        System.out.println("Click on Close.....");
        createOwnPage.clickOnBack();
        System.out.println("Click on Back from Create Own Page.....");
        mySpacePage.clickOnBack();
        System.out.println("Click on Back from Myspace.....");

        homePage.clickOnMenuButton();
        System.out.println("Click on Menu button from home.....");
        homePage.clickOnLogoutIcon();
        System.out.println("Click on logout icon from home.....");
        homePage.clickOnLogoutButton();
        System.out.println("Click on logout button from home.....");

    } catch (Exception e) {
        // Capture screenshot on failure
        String screenshotName = "FailedTest_testCreateActivity" + System.currentTimeMillis();
        AppiumUtils.captureScreenshot(driver, screenshotName);
        e.printStackTrace(); // Print the exception
        Assert.fail("Test failed due to an exception");
    }
    }
}