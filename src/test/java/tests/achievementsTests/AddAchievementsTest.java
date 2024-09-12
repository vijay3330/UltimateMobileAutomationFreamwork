package tests.achievementsTests;

import baseClass.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testCasePages.AchievementsPage;
import testCasePages.HomePage;
import testCasePages.LoginPage;
import testCasePages.ProfileSelectionPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.AppiumUtils;
import utils.Data_Provider;

public class AddAchievementsTest extends BaseClass {
    private static final Logger log = LogManager.getLogger(AddAchievementsTest.class);
    LoginPage loginpage;
    ProfileSelectionPage profileSelectionPage;
    HomePage homePage;
    AchievementsPage achievementsPage;

    @DataProvider(name = "addAchievementData")
    public Object[][] getActivityData() {
        return Data_Provider.getTestData("AddAchievement Test Data");
    }

    @Test(dataProvider = "addAchievementData")
    public void testAddAchievement(String username, String password, String AchievementDropDownValue, String ProficiencyLevelDropDown, String Description, String DateOfMonth, String Point, String expectedMsg) throws InterruptedException {
        loginpage= new LoginPage(driver);
        loginpage.enterUsername(username);
        loginpage.clickOnContinue();
        Thread.sleep(3000);
        loginpage.enterPassword(password);

        profileSelectionPage= new ProfileSelectionPage(driver);
        profileSelectionPage.clickOnParentProfile();

        homePage=new HomePage(driver);
        homePage.clickOnAchievement();

        achievementsPage=new AchievementsPage(driver);
        achievementsPage.clickOnAddAchievementsButton();
        achievementsPage.clickOnSportsCategory();
        achievementsPage.clickOnAchievementDropDown();
        Thread.sleep(3000);
        AppiumUtils.selectValueFromDropdown(AchievementDropDownValue,driver);
        Thread.sleep(3000);
        achievementsPage.clickOnProficiencyLevelDropDown();
        Thread.sleep(3000);
        AppiumUtils.selectValueFromDropdown(ProficiencyLevelDropDown,driver);

        achievementsPage.enterDescription(Description);
        achievementsPage.clickOnDatepicker();
        String date=DateOfMonth;  // we can change date as per need
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + date + "\"]")).click();
        log.info("Select Date : "+date);

        Thread.sleep(3000);
        String points = achievementsPage.getPoints();
        log.info("Actual Points : "+points);
        log.info("Expected Points : "+Point);
        Thread.sleep(3000);
        Assert.assertEquals(points,Point);
        log.info("Test Case Pass");

        Thread.sleep(5000);
        AppiumUtils.scrollToElement("Submit", driver);
        achievementsPage.uploadMemories1();
     //   achievementsPage.getPermission();
        achievementsPage.clickOnChooseFromGallery();
        achievementsPage.clickOnSelectMedia();

        Thread.sleep(5000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]")).click();
        log.info("Select Media from gallary");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Crop\"]")).click();
        log.info("click on select");
        Thread.sleep(5000);

        achievementsPage.clickOnSubmitButton();

        Thread.sleep(5000);
        String actualMsg = driver.findElement(By.xpath("//android.widget.TextView[@text=\"ACHIEVEMENT ADDED & APPROVED!\"]")).getText();
        String exptMsg= expectedMsg;
        log.info("Actual Msg : "+actualMsg);
        log.info("Expected Msg : "+exptMsg);
        Thread.sleep(3000);
        Assert.assertEquals(actualMsg,exptMsg);

        achievementsPage.clickOnCloseButton();

        log.info("Test Case Pass");

//        Thread.sleep(6000);
//        String text = driver.findElement(By.xpath("(//android.widget.TextView[@index='2'])[1]")).getText();
//        log.info(text);
    }

    }
