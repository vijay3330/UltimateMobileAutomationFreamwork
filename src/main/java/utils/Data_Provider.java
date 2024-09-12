package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.Iterator;

public class Data_Provider {

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

}
