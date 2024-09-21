package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date_Util {

    private static final Logger log = LogManager.getLogger(Date_Util.class);

    public static String getStartAndEndDate(String dateStr) {

        // Create a SimpleDateFormat object for parsing the original date format
        SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Create a SimpleDateFormat object for the desired date format
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd MMM");

        // Parse the original date string into a Date object
        Date dateObj;
        String formattedDate= null;
        try {
            dateObj = originalFormat.parse(dateStr);
            // Format the Date object into the desired format
             formattedDate = targetFormat.format(dateObj);
            System.out.println(formattedDate);  // Output: 15 Sep
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        log.info("Formated date : "+formattedDate);
        return formattedDate;

    }


        public static String extractEndDate(String input) {
            Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                return matcher.group();
            } else {
                return null; // Or throw an exception if you prefer
            }
        }

    public static String[] extractActivityStartEndDates(String dateString) {
        String[] dates = dateString.split("-");
        return dates;
    }


}
