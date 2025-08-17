package org.example.excelFileOperation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadFromExcelFile {
    public static void main(String[] args) {
        try {
            // Load the excel file
            File file = new File("/Users/abhishekgayen/Zorbra_Softed/1018_Batch/Java_1018_Batch_class_notes/FileInputOutputOperations/src/main/resources/students.xlsx");

            //File Object needs to be converted to byte array
            FileInputStream fileInputStream = new FileInputStream(file);

            //Read the excel file using apache poi
            // It takes byte array (FileInputStream) mas input and convert into java Object
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

            // Get number of Sheet of the excel file
            int noOfSheet = xssfWorkbook.getNumberOfSheets();
            System.out.println("Number of sheet :: "+noOfSheet);

            // iterate over the sheets and get teh content
            for (int i = 0; i < noOfSheet; i++) {
                //Read the particular sheet
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(i);
                System.out.println("No OF Rows :: "+xssfSheet.getPhysicalNumberOfRows());

                //Iterate over each row and get the data
                Iterator<Row> rowIterator = xssfSheet.rowIterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    System.out.println("Row Num: "+row.getRowNum());

                    // Read all the cell / column of a particular row
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        System.out.println("Cell type: "+cell.getCellType());
                        String cellType = cell.getCellType().name();
                        switch (cellType) {
                            case "STRING":
                                System.out.println("Column Index: "+cell.getColumnIndex()
                                        + ": The Value of the cell :" +cell.getStringCellValue());
                                break;
                            case "NUMERIC":
                                System.out.println("Column Index: "+cell.getColumnIndex()
                                        + ": The Value of the cell :" +cell.getNumericCellValue());
                                break;
                            case "BOOLEAN":
                                System.out.println("Column Index: "+cell.getColumnIndex()
                                        + ": The Value of the cell :" +cell.getBooleanCellValue());
                                break;
                            default:
                                System.out.println("Column Index: "+cell.getColumnIndex()
                                        + ": The Value of the cell :" +cell.getCellType());
                                break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
