package tests.ReadingPointsTests;

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

public class AddReadingPointsByChild extends BaseClass
{
    private static final Logger log = LogManager.getLogger(AddReadingPointsByChild.class);
    LoginPage loginpage;
    ProfileSelectionPage profileSelectionPage;
    HomePage homePage;
    ReadingPointsPage readingPointsPage;
    SwitchRolePage switchRolePage;
    MyApprovalPage myApprovalPage;
    ApproveReadingPage approveReadingPage;

    @DataProvider(name = "readingPointdata")
    public Object[][] getReadingPointdata() {
        return Data_Provider.getTestData("Reading Point Test Data");
    }

    @Test(dataProvider = "readingPointdata")
    public void testAddReadingPointsByParent(String userName, String password, String childName, String childId, String date, String minutes, String whatRead, String language, String expectedMsg) throws InterruptedException {
        loginpage= new LoginPage(driver);
        loginpage.enterUsername(userName);
        loginpage.clickOnContinue();
        Thread.sleep(3000);
        loginpage.enterPassword(password);

        profileSelectionPage = new ProfileSelectionPage(driver);
        profileSelectionPage.clickOnParentProfile();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"surface\"]/android.view.ViewGroup[4]/android.widget.ImageView")).click();
        log.info("Click On Switch Button");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='switchRole-"+childName+"']")).click();
        log.info("Select Child : "+childName);

        homePage = new HomePage(driver);
        homePage.clickOnReading();

        readingPointsPage = new ReadingPointsPage(driver);
        String getReading = readingPointsPage.getEnterReading();
        log.info("Enter reading : "+getReading);
        if (getReading.equalsIgnoreCase("What do you read today?"))
        {
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.view.ViewGroup[contains(@content-desc, '"+date+"')]/android.view.ViewGroup")).click();
            log.info("Select Date : "+date);
            readingPointsPage.enterMins(minutes);
            readingPointsPage.enterReadToday(whatRead);
            AppiumUtils.scrollToElement(language,driver);
            log.info("select language : "+language);
            readingPointsPage.clickOnSubmitButton();
            String sucessMessage = readingPointsPage.getSuccessMessage();
            log.info("Actual Message : "+sucessMessage);
            log.info("Expected Message : "+expectedMsg);
            Assert.assertEquals(sucessMessage,expectedMsg);
            log.info("Assertion Pass");
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"surface\"]/android.view.ViewGroup[3]/android.widget.ImageView")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Satish')]")).click();
            Thread.sleep(5000);

            switchRolePage = new SwitchRolePage(driver);
            switchRolePage.enterPasscode(password);
            switchRolePage.clickOnPasscodeSubmitBtn();

            homePage.clickOnMyApproval();

            myApprovalPage = new MyApprovalPage(driver);
            myApprovalPage.clickOnApproveReading();

            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup["+childId+"]/android.widget.ImageView")).click();

            approveReadingPage = new ApproveReadingPage(driver);
            String totalMinutesBefore = approveReadingPage.getTotalMinutes();
            log.info("Total Minuets Before Approve : "+totalMinutesBefore);
            String beforeMin = AppiumUtils.extractNumber(totalMinutesBefore);
            approveReadingPage.clickOnApproveButton();
            String totalMinutesAfter = approveReadingPage.getTotalMinutes();
            log.info("Total Minuets After Approve : "+totalMinutesAfter);
            String afterMin = AppiumUtils.extractNumber(totalMinutesAfter);
            int bmin = Integer.parseInt(beforeMin);
            int total = bmin + Integer.parseInt(minutes);
            String totalmin = Integer.toString(total);
            Assert.assertEquals(afterMin,totalmin);
            log.info("Assertion Pass");
        }
        else
        {
            log.info("Reading Points have already been added for the provided date.");
        }
    }
}
