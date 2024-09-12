package tests.createOwnTests;

import baseClass.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testCasePages.*;
import utils.Data_Provider;

public class CreateActivityErrorMsg extends BaseClass {
    private static final Logger log = LogManager.getLogger(createActivityTest.class);
    LoginPage loginpage;
    ProfileSelectionPage profileSelectionPage;
    HomePage homePage;
    CreateOwnPage createOwnPage;

    @DataProvider(name = "CreateActivityErrorMsgData")
    public Object[][] getActivityData() {
        return Data_Provider.getTestData("Create Activity Error Msg Data");
    }

    @Test(dataProvider = "CreateActivityErrorMsgData")
    public void testCreateActivityErrorMsg(String username, String password, String activityTitle, String description, String materialRequired, String expectedMsg) throws InterruptedException {
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

        String actualmsg = createOwnPage.getActivityTitleErrorMsg();

        log.info("Actual Message : " + actualmsg);
        log.info("Expected Message : " + expectedMsg);
        Assert.assertEquals(actualmsg, expectedMsg);
        log.info("Assertion Pass.....");

        createOwnPage.clickOnBack();
        homePage.clickOnMenuButton();
        homePage.clickOnLogoutIcon();
        homePage.clickOnLogoutButton();
    }
}
