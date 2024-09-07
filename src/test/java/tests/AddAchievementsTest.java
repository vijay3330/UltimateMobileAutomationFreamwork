package tests;

import baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import testCasePages.AchievementsPage;
import testCasePages.HomePage;
import testCasePages.LoginPage;
import testCasePages.ProfileSelectionPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddAchievementsTest extends BaseClass {
    private static final Logger log = LogManager.getLogger(AddAchievementsTest.class);
    LoginPage loginpage;
    ProfileSelectionPage profileSelectionPage;
    HomePage homePage;
    AchievementsPage achievementsPage;

    @Test
    public void testAddAchievement() throws InterruptedException {
        loginpage= new LoginPage(driver);
        Thread.sleep(5000);
        loginpage.enterUsername("satish.kshirsagar@gmail.com");
        Thread.sleep(5000);
        loginpage.enterPassword("1111");
        Thread.sleep(5000);
        loginpage.clickLogin();
        log.info("Login.....");
        Thread.sleep(5000);

        profileSelectionPage= new ProfileSelectionPage(driver);
        Thread.sleep(5000);
        profileSelectionPage.clickOnParentProfile();
        log.info("select profile..");
        Thread.sleep(5000);

        homePage=new HomePage(driver);
        Thread.sleep(5000);
        homePage.clickOnAchievement();
        log.info("Click On Achievement");
        Thread.sleep(5000);
        
        achievementsPage=new AchievementsPage(driver);
        Thread.sleep(5000);
        achievementsPage.clickOnAddAchievementsButton();
        log.info("Click On Add Achievement");
        Thread.sleep(5000);
        achievementsPage.clickOnSportsCategory();
        log.info("Click On Sports Category");
        Thread.sleep(5000);
        WebElement ac = achievementsPage.achievementDropDown;
        Select selectAc = new Select(ac);
        Thread.sleep(5000);
        selectAc.selectByVisibleText("Tennis");
        Thread.sleep(5000);
        log.info("Select Tennis");
        WebElement pl = achievementsPage.proficiencyLevelDropDown;
        Select selectPl = new Select(pl);
        Thread.sleep(5000);
        selectPl.selectByVisibleText("Level Completion");
        Thread.sleep(5000);
        log.info("Select Level Completion");
        achievementsPage.enterDescription("First Prize");
        Thread.sleep(5000);
        log.info("Enter Description");
        achievementsPage.enterDate("2024-08-31");
        Thread.sleep(5000);
        log.info("Enter date 2024-08-31 ");
        achievementsPage.addMemories1.click();
        Thread.sleep(5000);
        log.info("Click on addMemories1");
        achievementsPage.getPermission();
        Thread.sleep(5000);
        log.info("Click on permission");
//        achievementsPage.clickOnChooseFromGallery();
//        Thread.sleep(5000);
//        log.info("Click on choose from gallery");
//        achievementsPage.clickOnSelectMedia();
//        Thread.sleep(5000);
//        log.info("Click on Select Media");
        achievementsPage.uploadMemories1("C:\\Users\\Admin\\Desktop\\Pristine\\image\\success-quote-on-progress.png");
        Thread.sleep(5000);
        log.info("Click on addMemories1");

    }

}
