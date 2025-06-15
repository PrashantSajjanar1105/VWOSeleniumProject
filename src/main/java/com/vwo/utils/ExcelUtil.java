package com.vwo.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {

    static Workbook workbook;
    static Sheet sheet;

    public static String SHEET_PATH = System.getProperty("user.dir") + "/src/main/resources/InValidLoginTestData.xlsx";



    public static Object[][] excelReader(String sheetName){
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(SHEET_PATH);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found in the Excel file.");
        } }catch (IOException e) {
            e.printStackTrace();
            System.out.println("Either File not found!! or workbook not created!! or Sheet not found!");
        }

        Object[][] object = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int i=0; i<sheet.getLastRowNum();i++){
            for(int j=0; j<sheet.getRow(0).getLastCellNum();j++){
                object[i][j]= sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return object;
    }

}
