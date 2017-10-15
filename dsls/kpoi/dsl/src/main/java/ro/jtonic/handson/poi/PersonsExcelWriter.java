package ro.jtonic.handson.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PersonsExcelWriter {

  private static final String FILE_NAME = "./PersonsJava.xlsx";

  public static void main(String[] args) {

    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Persons");
    Object[][] data = {
        {"No", "Name", "Age"},
        {"1", "Antonel", 47},
        {"2", "Irina", "27"}
    };

    int rowNum = 0;
    System.out.println("Creating excel");

    for (Object[] datatype : data) {
      Row row = sheet.createRow(rowNum++);
      int colNum = 0;
      for (Object field : datatype) {
        Cell cell = row.createCell(colNum++);
        if (field instanceof String) {
          cell.setCellValue((String) field);
        } else if (field instanceof Integer) {
          cell.setCellValue((Integer) field);
        }
      }
    }

    try (FileOutputStream outputStream = new FileOutputStream(FILE_NAME)) {
      workbook.write(outputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Done");
  }

}
