package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.Month;

import static baseClass.BaseClass.driver;

public class Handle_Calendar
{
    private static final Logger log = LogManager.getLogger(Handle_Calendar.class);

    public static void selectCalendarDate(String month, int year, String date) throws InterruptedException
    {
        while (true)
        {
            String mothyear = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"undefined.calendarList.staticHeader.title\"]")).getText();
            String arr[] = mothyear.split(" ");
            String mon = arr[0];
            String yr = arr[1];

            LocalDate currentDate = LocalDate.now();
            int currentYear = currentDate.getYear();
            Month currentMonth = currentDate.getMonth();

            // Parse the provided month name to a Month enum
            Month providedMonthEnum = Month.valueOf(month.toUpperCase());


            // Compare years
            if (year < currentYear)
            {
                if (mon.equalsIgnoreCase(month) && yr.equals(Integer.toString(year)))
                {
                    Thread.sleep(3000);
                    driver.findElement(By.xpath(" //android.widget.TextView[@text="+date+"]")).click();
                    break;
                } else {
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"undefined.leftArrow\"])[2]")).click();
                }
            }
            else if (year > currentYear)
            {
                if (mon.equalsIgnoreCase(month) && yr.equals(Integer.toString(year)))
                {
                    Thread.sleep(3000);
                    driver.findElement(By.xpath(" //android.widget.TextView[@text="+date+"]")).click();
                    break;
                } else {
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"undefined.rightArrow\"])[2]")).click();
                }
            }
            else
            { // providedYear == currentYear
                if (providedMonthEnum.getValue() < currentMonth.getValue())
                {
                    if (mon.equalsIgnoreCase(month) && yr.equals(Integer.toString(year)))
                    {
                        Thread.sleep(3000);
                        driver.findElement(By.xpath(" //android.widget.TextView[@text="+date+"]")).click();
                        break;
                    } else {
                        Thread.sleep(3000);
                        driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"undefined.leftArrow\"])[2]")).click();
                    }
                }
                else if (providedMonthEnum.getValue() > currentMonth.getValue())
                {
                    if (mon.equalsIgnoreCase(month) && yr.equals(Integer.toString(year)))
                    {
                        Thread.sleep(3000);
                        driver.findElement(By.xpath(" //android.widget.TextView[@text="+date+"]")).click();
                        break;
                    } else {
                        Thread.sleep(3000);
                        driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"undefined.rightArrow\"])[2]")).click();
                    }
                }
                else
                {
                    Thread.sleep(3000);
                    driver.findElement(By.xpath(" //android.widget.TextView[@text="+date+"]")).click();
                    break;
                }
            }

            }
        }

    }