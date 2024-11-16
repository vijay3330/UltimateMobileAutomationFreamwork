package tests.smokeTests;

import baseClass.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
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

    @DataProvider(name = "loginByParentSmokeTestData")
    public Object[][] getActivityData() {
        return Data_Provider.getTestData("Login By Parent Smoke Test Data");
    }

    @Test(dataProvider = "loginByParentSmokeTestData")
    public void testAddAchievement(String username, String password, String expectedUser, String expectedScreen) throws InterruptedException {
        loginpage= new LoginPage(driver);
        loginpage.enterUsername(username);
        loginpage.clickOnContinue();
        Thread.sleep(3000);
        loginpage.enterPassword(password);

        profileSelectionPage= new ProfileSelectionPage(driver);
        profileSelectionPage.clickOnParentProfile();

        String[] screenNames = expectedScreen.split(",");

        for (String screen : screenNames) {
            log.info("Current Screen Name: "+screen);

            if(screen.equals("Home")) {
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
            if(screen.equals("My Activities"))
            {
                homePage.clickOnMyActivities();
                String actualScreen = myActivitiesPage.getMyActivitiesScreen();
                log.info("Actual Screen Name : "+actualScreen);
                log.info("Expected Screen Name : "+ screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                myActivitiesPage.clickOnBackBtn();
            }
            if(screen.equals("My Stories"))
            {
                homePage.clickOnMyStories();
                stories = new Stories(driver);
                String actualScreen = stories.getMyStoriesScreen();
                log.info("Actual Screen Name : "+actualScreen);
                log.info("Expected Screen Name : "+ screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                stories.clickOnBackBtn();
            }
            if(screen.equals("Virtue Week"))
            {
                homePage.clickOnVirtueWeek();
                virtueWeekPage = new VirtueWeekPage(driver);
                String actualScreen = virtueWeekPage.getVirtueWeekScreen();
                log.info("Actual Screen Name : "+actualScreen);
                log.info("Expected Screen Name : "+ screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                virtueWeekPage.clickOnBackBtn();
            }
            if(screen.equals("Achievements"))
            {
                homePage.clickOnAchievement();
                achievementsPag  = new AchievementsPage(driver);
                String actualScreen = achievementsPag.getAchievementsScreen();
                log.info("Actual Screen Name : "+actualScreen);
                log.info("Expected Screen Name : "+ screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                achievementsPag.clickOnBackBtn();
            }
            if(screen.equals("Enter Reading Minutes"))
            {
                homePage.clickOnReading();
                readingPage = new ReadingPage(driver);
                String actualScreen = readingPage.getReadingScreen();
                log.info("Actual Screen Name : "+actualScreen);
                log.info("Expected Screen Name : "+ screen);
                Thread.sleep(3000);
                Assert.assertEquals(actualScreen, screen);
                Thread.sleep(3000);
                driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")).click();
            }
        }
    }
}
