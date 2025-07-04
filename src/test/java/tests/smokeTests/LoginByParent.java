package tests.smokeTests;

import baseClass.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testCasePages.*;
import utils.AppiumUtils;
import utils.Data_Provider;

public class LoginByParent extends BaseClass {
    private static final Logger log = LogManager.getLogger(LoginByParent.class);
    LoginPage loginpage;
    ProfileSelectionPage profileSelectionPage;
    HomePage homePage;
    MyActivitiesPage myActivitiesPage;
    CreateOwnPage createOwnPage;
    SwitchRolePage switchRolePage;
    Stories stories;
    VirtueWeekPage virtueWeekPage;
    AchievementsPage achievementsPag;
    ReadingPage readingPage;
    UltimateRewardsPage ultimateRewardsPage;
    MyApprovalPage myApprovalPage;
    BookListPage bookListPage;
    AssesmentPage assesmentPage;
    RegistrationPage registrationPage;

    @DataProvider(name = "loginByParentSmokeTestData")
    public Object[][] getActivityData() {
        return Data_Provider.getTestData("Login By Parent Smoke Test Data");
    }

    @Test(dataProvider = "loginByParentSmokeTestData")
    public void testUserLogin(String username, String password, String expectedUser, String expectedScreen) throws InterruptedException {
        registrationPage  = new RegistrationPage(driver);
        registrationPage.clickOnLoginBtn();
        loginpage = new LoginPage(driver);
        loginpage.enterUsername(username);
        loginpage.clickLogin();
        Thread.sleep(3000);
        loginpage.enterPassword(password);

        profileSelectionPage = new ProfileSelectionPage(driver);
        profileSelectionPage.clickOnParentProfile();

        String[] screenNames = expectedScreen.split(",");

        for (String screen : screenNames) {
            log.info("Current Screen Name: " + screen);

            if (screen.equals("Home")) {
                homePage = new HomePage(driver);
                String actualScreen = homePage.getHomeScreenText();
                log.info("Actual Screen Name : " + actualScreen);
                log.info("Expected Screen Name : " + screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);

                homePage.clickOnMenuButton();
                Thread.sleep(5000);
                String actualUser = driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + expectedUser + "\"]")).getText();
                String exptUser = expectedUser;
                log.info("Actual User Name : " + actualUser);
                log.info("Expected User Name : " + exptUser);
                Thread.sleep(3000);
                Assert.assertEquals(actualUser, exptUser);
                homePage.clickOnVirtueWeek();
            }
            if (screen.equals("My Activities")) {
                homePage.clickOnMyActivities();
               myActivitiesPage = new MyActivitiesPage(driver);
                String actualScreen = myActivitiesPage.getMyActivitiesScreen();
                log.info("Actual Screen Name : " + actualScreen);
                log.info("Expected Screen Name : " + screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                myActivitiesPage.clickOnBackBtn();
            }
            if (screen.equals("My Stories")) {
                homePage.clickOnMyStories();
                stories = new Stories(driver);
                String actualScreen = stories.getMyStoriesScreen();
                log.info("Actual Screen Name : " + actualScreen);
                log.info("Expected Screen Name : " + screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                stories.clickOnBackBtn();
            }
            if (screen.equals("Parenting Virtue")) {
                homePage.clickOnVirtueWeek();
                virtueWeekPage = new VirtueWeekPage(driver);
                String actualScreen = virtueWeekPage.getVirtueWeekScreen();
                log.info("Actual Screen Name : " + actualScreen);
                log.info("Expected Screen Name : " + screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                virtueWeekPage.clickOnBackBtn();
            }
            if (screen.equals("Achievements")) {
                homePage.clickOnAchievement();
                achievementsPag = new AchievementsPage(driver);
                String actualScreen = achievementsPag.getAchievementsScreen();
                log.info("Actual Screen Name : " + actualScreen);
                log.info("Expected Screen Name : " + screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                achievementsPag.clickOnBackBtn();
            }
//            if (screen.equals("Enter Reading Minutes")) {
//                homePage.clickOnReading();
//                readingPage = new ReadingPage(driver);
//                String actualScreen = readingPage.getReadingScreen();
//                log.info("Actual Screen Name : " + actualScreen);
//                log.info("Expected Screen Name : " + screen);
//                Thread.sleep(3000);
//                Assert.assertEquals(actualScreen, screen);
//                Thread.sleep(3000);
//                driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")).click();
//            }
            if (screen.equals("Create Tasks")) {
                homePage.clickOnCreateTask();
                createOwnPage = new CreateOwnPage(driver);
                String actualScreen = createOwnPage.getCreateTasksScreen();
                log.info("Actual Screen Name : " + actualScreen);
                log.info("Expected Screen Name : " + screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                Thread.sleep(3000);
                createOwnPage.clickOnBackBtn();
            }
            if (screen.equals("Ultimate Rewards")) {
                Thread.sleep(3000);
                AppiumUtils.scrollToElement("Calendar",driver);
                homePage.clickOnRewards();
                ultimateRewardsPage = new UltimateRewardsPage(driver);
                String actualScreen = ultimateRewardsPage.clickOnUltimateRewardsScreen();
                log.info("Actual Screen Name : " + actualScreen);
                log.info("Expected Screen Name : " + screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                Thread.sleep(3000);
                ultimateRewardsPage.clickOnBackBtn();
            }
            if (screen.equals("My Approval")) {
                homePage.clickOnMyApproval();
                myApprovalPage = new MyApprovalPage(driver);
                String actualScreen = myApprovalPage.getMyApprovalScreen();
                log.info("Actual Screen Name : " + actualScreen);
                log.info("Expected Screen Name : " + screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                Thread.sleep(3000);
                myApprovalPage.clickOnBackBtn();
            }
            if (screen.equals("Book List")) {
                homePage.clickOnBookList();
                bookListPage  = new BookListPage(driver);
                String actualScreen = bookListPage.getbookListScreen();
                log.info("Actual Screen Name : " + actualScreen);
                log.info("Expected Screen Name : " + screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                Thread.sleep(3000);
                myApprovalPage.clickOnBackBtn();
            }
            if (screen.equals("Child Assessment")) {
                homePage.clickOnAssesment();
                assesmentPage= new AssesmentPage(driver);
                String actualScreen = assesmentPage.getchildAssesmentScreen();
                log.info("Actual Screen Name : " + actualScreen);
                log.info("Expected Screen Name : " + screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                Thread.sleep(3000);
                assesmentPage.clickOnChildAssessmnetBackButton();
            }
            if (screen.equals("Discovery Lab")) {
                Thread.sleep(3000);
                AppiumUtils.scrollToElement("Discovery Lab",driver);
                homePage.clickOnDiscoveryLabVideo();
                Thread.sleep(3000);
                boolean result = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]")).isDisplayed();
                log.info("Actual result : " + result);
                Thread.sleep(3000);
                Assert.assertTrue(result);
                Thread.sleep(3000);
                homePage.clickOnDiscoveryLabVideoCloseBtn();
            }
            if (screen.equals("Knowledge Center")) {
                Thread.sleep(3000);
//               AppiumUtils.scrollToElement("Knowledge Center",driver);
                AppiumUtils.scrollToElementInLoop(driver,"//android.widget.ScrollView/android.view.ViewGroup/android.widget.HorizontalScrollView[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView",2);
                Thread.sleep(3000);
                homePage.clickOnKnowledgeCenterBlog();
                Thread.sleep(3000);
                boolean result = driver.findElement(By.xpath("//android.widget.RelativeLayout")).isDisplayed();
                log.info("Actual result : " + result);
                Thread.sleep(3000);
                Assert.assertTrue(result);
                Thread.sleep(3000);
                homePage.clickOnKnowledgeCenterBackButton();
            }
        }

    }

//    @AfterMethod
//    public void captureScreenshotOnFailure(ITestResult result) {
//        if (ITestResult.FAILURE == result.getStatus()) {
//            String methodName = result.getMethod().getMethodName();
//            AppiumUtils.captureScreenshot(driver, "Failure_" + methodName);
//        }
//    }

//    @AfterMethod
//    public void captureScreenshotOnFailure(ITestResult result) {
//        if (ITestResult.FAILURE == result.getStatus()) {
//            String methodName = result.getMethod().getMethodName();
//            if (driver != null) {
//                AppiumUtils.captureScreenshot(driver, "Failure_" + methodName);
//            } else {
//                log.error("Driver is null. Unable to capture screenshot for: " + methodName);
//            }
//        }
//    }

    @AfterMethod(alwaysRun = true)
    public void captureScreenshotOnFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        if (driver != null) {
            AppiumUtils.captureScreenshot(driver, result.getStatus() + "_" + methodName);
            log.info("Screenshot captured for: " + methodName);
        } else {
            log.error("Driver is null. Cannot capture screenshot.");
        }
    }


}