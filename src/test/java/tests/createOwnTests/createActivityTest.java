package tests.createOwnTests;

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
import utils.Date_Util;

public class createActivityTest extends BaseClass {
    private static final Logger log = LogManager.getLogger(createActivityTest.class);
    LoginPage loginpage;
    ProfileSelectionPage profileSelectionPage;
    HomePage homePage;
    CreateOwnPage createOwnPage;
    MyActivitiesPage myActivitiesPage;
    SwitchRolePage switchRolePage;

    @DataProvider(name = "activityData")
    public Object[][] getActivityData() {
        return Data_Provider.getTestData("CreateOwn Test Data");
    }

    @Test(dataProvider = "activityData")
    public void testCreateActivity(String username, String password, String activityTitle, String description, String materialRequired, String expectedActivityCreatedMsg, String activityType
    , String timeRequired, String date, String completeWithin, String endAfterDays, String expectedAssignedActivityMsg, String points, String statusOfActivity, String expectedToastMsg) throws InterruptedException {

        loginpage= new LoginPage(driver);
        loginpage.enterUsername(username);
        loginpage.clickOnContinue();
        Thread.sleep(3000);
        loginpage.enterPassword(password);


        profileSelectionPage = new ProfileSelectionPage(driver);
        profileSelectionPage.clickOnParentProfile();

        homePage = new HomePage(driver);
        homePage.clickOnCreateOwn();

        createOwnPage = new CreateOwnPage(driver);
        createOwnPage.clickOnCreateActivity();

        createOwnPage.enterActivityTitle(activityTitle);
        createOwnPage.enterDescription(description);
        createOwnPage.enterMaterialRequired(materialRequired);

        createOwnPage.clickOnPreview();
        createOwnPage.clickOnSubmit();

        String actualmsg = createOwnPage.getCreatedMessage();
        log.info("Actual Message : " + actualmsg);
        log.info("Expected Message : " + expectedActivityCreatedMsg);
        Assert.assertEquals(actualmsg, expectedActivityCreatedMsg);
        log.info("Assertion Pass.....");

        createOwnPage.clickOnClose();
        // Once
        String startFormatDate = null;
        String endFormatDate = null;

        if(activityType.equals("Once")) {
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='" + activityTitle + "']//android.view.ViewGroup[@resource-id='createOwn-assignButton']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.ViewGroup[2]//android.widget.ImageView)[1]")).click();
            Thread.sleep(5000);
            createOwnPage.clickOnOnceRadioBtn();
            createOwnPage.enterTimeRequired(timeRequired);
            createOwnPage.clickOnDatePicker();
            String start_date = date;  // we can change date as per need
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + start_date + "\"]")).click();
            log.info("Select Date : " + start_date);
            String startDate = createOwnPage.getActivityStartDate();
            log.info("Start Date : " + startDate);
            startFormatDate = Date_Util.getStartAndEndDate(startDate);
            driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"createOwn-activityCompleteIn-" + completeWithin + "\"]")).click();
            String endDate = createOwnPage.getOnceActivityEndDate();
            endFormatDate = Date_Util.extractEndDate(endDate);
            createOwnPage.clickOnAssignBtn();
            Thread.sleep(5000);
            String assignedSuccessMsg = createOwnPage.getActivityAssignedSuccessMsg();
            log.info("Actual Message : " + assignedSuccessMsg);
            log.info("Expected Message : " + expectedAssignedActivityMsg);
            Assert.assertEquals(assignedSuccessMsg, expectedAssignedActivityMsg);
            log.info("Assertion Pass.....");
            createOwnPage.clickOnClose();
        }
        if(activityType.equals("Every Day")){
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='" + activityTitle + "']//android.view.ViewGroup[@resource-id='createOwn-assignButton']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.ViewGroup[2]//android.widget.ImageView)[1]")).click();
            Thread.sleep(5000);
            createOwnPage.clickOnEveryDayRadioBtn();
            createOwnPage.enterTimeRequired(timeRequired);
            createOwnPage.clickOnDatePicker();
            String start_date = date;  // we can change date as per need
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + start_date + "\"]")).click();
            log.info("Select Date : " + start_date);
            String startDate = createOwnPage.getActivityStartDate();
            log.info("Start Date : " + startDate);
            startFormatDate = Date_Util.getStartAndEndDate(startDate);
            createOwnPage.enterEndAfterDay(endAfterDays);
            String endDate = createOwnPage.getEveryDayActivityEndDate();
            endFormatDate = Date_Util.extractEndDate(endDate);
            createOwnPage.clickOnAssignBtn();
            Thread.sleep(5000);
            String assignedSuccessMsg = createOwnPage.getActivityAssignedSuccessMsg();
            log.info("Actual Message : " + assignedSuccessMsg);
            log.info("Expected Message : " + expectedAssignedActivityMsg);
            Assert.assertEquals(assignedSuccessMsg, expectedAssignedActivityMsg);
            log.info("Assertion Pass.....");
            createOwnPage.clickOnClose();
        }
        if(activityType.equals("Every Week")){
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='" + activityTitle + "']//android.view.ViewGroup[@resource-id='createOwn-assignButton']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.ViewGroup[2]//android.widget.ImageView)[1]")).click();
            Thread.sleep(5000);
            createOwnPage.clickOnEveryWeekRadioBtn();
            createOwnPage.enterTimeRequired(timeRequired);
            createOwnPage.clickOnDatePicker();
            String start_date = date;  // we can change date as per need
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + start_date + "\"]")).click();
            log.info("Select Date : " + start_date);
            String startDate = createOwnPage.getEveryWeekActivityEndDate();
            log.info("Start Date : " + startDate);
            startFormatDate = Date_Util.getStartAndEndDate(startDate);
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='createOwn-activityCompleteWeekDay-\"" + completeWithin + "\"]")).click();
            Thread.sleep(5000);
            createOwnPage.enterEndAfterDay(endAfterDays);
            String endDate = createOwnPage.getOnceActivityEndDate();
            endFormatDate = Date_Util.extractEndDate(endDate);
            createOwnPage.clickOnAssignBtn();
            Thread.sleep(5000);
            String assignedSuccessMsg = createOwnPage.getActivityAssignedSuccessMsg();
            log.info("Actual Message : " + assignedSuccessMsg);
            log.info("Expected Message : " + expectedAssignedActivityMsg);
            Assert.assertEquals(assignedSuccessMsg, expectedAssignedActivityMsg);
            log.info("Assertion Pass.....");
            createOwnPage.clickOnClose();
        }
        if(activityType.equals("Every Month")){
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='" + activityTitle + "']//android.view.ViewGroup[@resource-id='createOwn-assignButton']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//android.widget.ScrollView//android.view.ViewGroup[2]//android.widget.ImageView)[1]")).click();
            Thread.sleep(5000);
            createOwnPage.clickOnEveryMonthRadioBtn();
            createOwnPage.enterTimeRequired(timeRequired);
            createOwnPage.clickOnDatePicker();
            String start_date = date;  // we can change date as per need
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + start_date + "\"]")).click();
            log.info("Select Date : " + start_date);
            String startDate = createOwnPage.getActivityStartDate();
            log.info("Start Date : " + startDate);
            startFormatDate = Date_Util.getStartAndEndDate(startDate);
            createOwnPage.enterActivityCompletedByTextbox(completeWithin);
            createOwnPage.enterEndAfterDay(endAfterDays);
            String endDate = createOwnPage.getEveryMonthActivityEndDate();
            endFormatDate = Date_Util.extractEndDate(endDate);
            createOwnPage.clickOnAssignBtn();
            Thread.sleep(5000);
            String assignedSuccessMsg = createOwnPage.getActivityAssignedSuccessMsg();
            log.info("Actual Message : " + assignedSuccessMsg);
            log.info("Expected Message : " + expectedAssignedActivityMsg);
            Assert.assertEquals(assignedSuccessMsg, expectedAssignedActivityMsg);
            log.info("Assertion Pass.....");
            createOwnPage.clickOnClose();
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"surface\"]/android.view.ViewGroup[3]/android.widget.ImageView")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='switchRole-Mihir']")).click();
        Thread.sleep(5000);
        homePage.clickOnMyActivities();
        Thread.sleep(5000);
        AppiumUtils.scrollToElement(activityTitle, driver);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\""+activityTitle+"\"]")).click();
        Thread.sleep(5000);

        myActivitiesPage = new MyActivitiesPage(driver);
        String activityStartEnd = myActivitiesPage.getActivityStartEndDate();
        String[] bothDates = Date_Util.extractActivityStartEndDates(activityStartEnd);

        if(startFormatDate.contains("Sep"))
        {
          String startdate = startFormatDate+"t";
            log.info("Actual Start Date : " + bothDates[0]);
            log.info("Expected Start Date : " + startdate);
            Assert.assertEquals(bothDates[0], startdate);
            log.info("Assertion Pass.....");
        }
        else
        {
            log.info("Actual Start Date : " + bothDates[0]);
            log.info("Expected Start Date : " + startFormatDate);
            Assert.assertEquals(bothDates[0], startFormatDate);
            log.info("Assertion Pass.....");
        }
       if (endFormatDate.contains("Sep"))
       {
           String enddate = endFormatDate + "t";
           log.info("Actual End Date : " + bothDates[1]);
           log.info("Expected End Date : " + enddate);
           Assert.assertEquals(bothDates[1], enddate);
           log.info("Assertion Pass.....");
       }
       else
       {
           log.info("Actual End Date : " + bothDates[1]);
           log.info("Expected End Date : " + endFormatDate);
           Assert.assertEquals(bothDates[1], endFormatDate);
           log.info("Assertion Pass.....");
       }

        String timeInMin = myActivitiesPage.getActivityTimeInMin();
        String extractTime = AppiumUtils.extractNumber(timeInMin);
        log.info("Actual Time : " + extractTime);
        log.info("Expected Time : " + timeRequired);
        Assert.assertEquals(extractTime, timeRequired);
        log.info("Assertion Pass.....");
        String activityPoints = myActivitiesPage.getActivityPoints();
        String extractPoints = AppiumUtils.extractNumber(activityPoints);
        log.info("Actual Points : " + extractPoints);
        log.info("Expected Points : " + points);
        Assert.assertEquals(extractPoints, points);
        String actualDescription = myActivitiesPage.getActivityDescription();
        log.info("Actual Description : " + actualDescription);
        log.info("Expected Description : " + points);
        Assert.assertEquals(actualDescription, description);
        myActivitiesPage.clickOnStartBtn();
        myActivitiesPage.clickOnMACBtn();
        Thread.sleep(4000);
        String actualStatus = driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc[contains(., '" + activityTitle + "')]]//following-sibling::android.view.ViewGroup)[2]")).getText();
        log.info("Actual Status : " + actualStatus);
        log.info("Expected Status : " + statusOfActivity);
        Assert.assertEquals(actualStatus, statusOfActivity);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"surface\"]/android.view.ViewGroup[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("switchRole-Satish")).click();
        Thread.sleep(5000);

        switchRolePage = new SwitchRolePage(driver);
        switchRolePage.enterPasscode(password);
        switchRolePage.clickOnPasscodeSubmitBtn();
        String actualActivityDeleteMsg = createOwnPage.toastMsg();
        log.info("Actual Activity Delete Msg : " + actualActivityDeleteMsg);
        log.info("Expected Activity Delete Msg  : " + statusOfActivity);
        Assert.assertEquals(actualActivityDeleteMsg, statusOfActivity);


        homePage.clickOnCreateOwn();
        createOwnPage.clickOnCreateActivity();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Cycling']/following-sibling::android.view.ViewGroup[1]")).click();
        log.info("Click on delete icon");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Yes\"]")).click();
        log.info("Click on yes button");
        createOwnPage.clickOnBack();
        homePage.clickOnMenuButton();
        homePage.clickOnLogoutIcon();
        homePage.clickOnLogoutButton();
    }
}