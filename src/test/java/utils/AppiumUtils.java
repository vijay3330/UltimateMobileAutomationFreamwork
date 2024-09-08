package utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;

public class AppiumUtils {

//    public static void captureScreenShot(AndroidDriver driver, int TCID) throws IOException {
//        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        File dest = new File("F:\\Vijay Velocity\\Automaton Workspace\\myproject\\screenshot"+TCID+".jpg");
//        FileHandler.copy(src, dest);
//    }
static AndroidDriver driver;
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
            FileInputStream file = new FileInputStream("C:\\Users\\Admin\\UltimateMobileAutomationFreamwork\\src\\test\\resources\\TestData\\TestData.xlsx");
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

    public static void writeResultToExcel(String sheetName, int rowNum, int colNum, String result) {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\Admin\\UltimateMobileAutomationFreamwork\\src\\test\\resources\\TestData\\TestData.xlsx");
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.createCell(colNum);
            cell.setCellValue(result);

            FileOutputStream outFile = new FileOutputStream("C:\\Users\\Admin\\UltimateMobileAutomationFreamwork\\src\\test\\resources\\TestData\\TestData.xlsx");
            workbook.write(outFile);
            outFile.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void horizontalScroll() {
        // Get the screen dimensions
        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        // Set the start and end points for the scroll (on the x-axis)
        int startX = (int) (screenWidth * 0.9); // Start at 90% of screen width
        int endX = (int) (screenWidth * 0.1);   // End at 10% of screen width
        int yAxis = (screenHeight / 2);   // Middle of the screen height (constant y-axis)

        // Define the pointer input for touch interaction
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);

        // Perform horizontal scroll: press -> move -> release
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, yAxis));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, yAxis));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the action
        driver.perform(Arrays.asList(scroll));
    }
}
