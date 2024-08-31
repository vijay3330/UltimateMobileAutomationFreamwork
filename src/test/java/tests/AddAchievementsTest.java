package tests;

import baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import testCasePages.AchievementsPage;
import testCasePages.HomePage;
import testCasePages.LoginPage;
import testCasePages.ProfileSelectionPage;

public class AddAchievementsTest extends BaseClass {

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
        System.out.println("Login.....");
        Thread.sleep(5000);

        profileSelectionPage= new ProfileSelectionPage(driver);
        Thread.sleep(5000);
        profileSelectionPage.clickOnParentProfile();
        System.out.println("select profile..");
        Thread.sleep(5000);

        homePage=new HomePage(driver);
        Thread.sleep(5000);
        homePage.clickOnAchievement();
        System.out.println("Click On Achievement");
        Thread.sleep(5000);
        
        achievementsPage=new AchievementsPage(driver);
        Thread.sleep(5000);
        achievementsPage.clickOnAddAchievementsButton();
        System.out.println("Click On Add Achievement");
        Thread.sleep(5000);
        achievementsPage.clickOnSportsCategory();
        System.out.println("Click On Sports Category");
        Thread.sleep(5000);
        WebElement ac = achievementsPage.achievementDropDown;
        Select selectAc = new Select(ac);
        Thread.sleep(5000);
        selectAc.selectByVisibleText("Tennis");
        Thread.sleep(5000);
        System.out.println("Select Tennis");
        WebElement pl = achievementsPage.proficiencyLevelDropDown;
        Select selectPl = new Select(pl);
        Thread.sleep(5000);
        selectPl.selectByVisibleText("Level Completion");
        Thread.sleep(5000);
        System.out.println("Select Level Completion");
        achievementsPage.enterDescription("First Prize");
        Thread.sleep(5000);
        System.out.println("Enter Description");
        achievementsPage.enterDate("2024-08-31");
        Thread.sleep(5000);
        System.out.println("Enter date 2024-08-31 ");
        achievementsPage.addMemories1.click();
        Thread.sleep(5000);
        System.out.println("Click on addMemories1");
        achievementsPage.getPermission();
        Thread.sleep(5000);
        System.out.println("Click on permission");
//        achievementsPage.clickOnChooseFromGallery();
//        Thread.sleep(5000);
//        System.out.println("Click on choose from gallery");
//        achievementsPage.clickOnSelectMedia();
//        Thread.sleep(5000);
//        System.out.println("Click on Select Media");
        achievementsPage.uploadMemories1("C:\\Users\\Admin\\Desktop\\Pristine\\image\\success-quote-on-progress.png");
        Thread.sleep(5000);
        System.out.println("Click on addMemories1");

    }

}
