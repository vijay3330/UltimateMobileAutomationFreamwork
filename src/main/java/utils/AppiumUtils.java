package utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

public class AppiumUtils {

//    public static void captureScreenShot(AndroidDriver driver, int TCID) throws IOException {
//        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        File dest = new File("F:\\Vijay Velocity\\Automaton Workspace\\myproject\\screenshot"+TCID+".jpg");
//        FileHandler.copy(src, dest);
//    }

    public static void captureScreenshot(AndroidDriver driver, String fileName) {
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/resources/Screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[][] getTestData(String sheetName) {
        String[][] data = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Ultimate_Testing\\UltimateMobileAutomationFreamwork\\src\\test\\resources\\TestData\\TestData.xlsx");
            Sheet sheet = WorkbookFactory.create(file).getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();

            data = new String[rowCount - 1][colCount];

            Iterator<Row> rowIterator = sheet.rowIterator();
            rowIterator.next();  // Skip header row

            int i = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                for (int j = 0; j < colCount; j++) {
                    data[i][j] = row.getCell(j).toString();
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // Method for waiting until an element is visible
    public static void waitForElementToBeVisible(AndroidDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Method for waiting until an element is clickable
    public static void waitForElementToBeClickable(AndroidDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



}
