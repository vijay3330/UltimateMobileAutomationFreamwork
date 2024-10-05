package tests.ReadingPointsTests;

import baseClass.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testCasePages.HomePage;
import testCasePages.LoginPage;
import testCasePages.ProfileSelectionPage;
import testCasePages.ReadingPointsPage;
import utils.AppiumUtils;
import utils.Data_Provider;

public class AddReadingPointsByParent extends BaseClass
{
    private static final Logger log = LogManager.getLogger(AddReadingPointsByParent.class);
    LoginPage loginpage;
    ProfileSelectionPage profileSelectionPage;
    HomePage homePage;
    ReadingPointsPage readingPointsPage;

    @DataProvider(name = "readingPointdata")
    public Object[][] getReadingPointdata() {
        return Data_Provider.getTestData("ReadingPoint Test Data");
    }

    @Test(dataProvider = "readingPointdata")
    public void testAddReadingPointsByParent(String userName, String password, String ChildName, String ChildID, String Date, String Minutes, String WhatRead, String Language, String expectedMsg) throws InterruptedException {
//        loginpage= new LoginPage(driver);
//        loginpage.enterUsername(userName);
//        loginpage.clickOnContinue();
//        Thread.sleep(3000);
//        loginpage.enterPassword(password);
//
//
//        profileSelectionPage = new ProfileSelectionPage(driver);
//        profileSelectionPage.clickOnParentProfile();

        homePage = new HomePage(driver);
        homePage.clickOnReading();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Enter Reading Minutes')]/android.view.ViewGroup[1]/android.view.ViewGroup["+ChildID+"]/android.widget.ImageView")).click();

       readingPointsPage = new ReadingPointsPage(driver);
        String getReading = readingPointsPage.getEnterReading();
        log.info("Enter reading : "+getReading);
        if (getReading.equalsIgnoreCase("What do you read today?"))
        {
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.view.ViewGroup[contains(@content-desc, '"+Date+"')]/android.view.ViewGroup")).click();
            log.info("Select Date : "+Date);
            readingPointsPage.enterMins(Minutes);
            readingPointsPage.enterReadToday(WhatRead);
            AppiumUtils.scrollToElement(Language,driver);
            log.info("select language : "+Language);
            readingPointsPage.clickOnSubmitButton();
            String sucessMessage = readingPointsPage.getSuccessMessage();
            log.info("Actual Message : "+sucessMessage);
            log.info("Expected Message : "+expectedMsg);
            Assert.assertEquals(sucessMessage,expectedMsg);
            log.info("Assertion Pass");
        }
        else
        {
            log.info("Reading Points have already been added for the provided date. for "+ChildName);
        }

    }
}
