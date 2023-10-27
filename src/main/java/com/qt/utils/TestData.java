package com.qt.utils;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class TestData {

    static Map<Integer,String> keys=new HashMap<>();
        static Map<Integer,String>values=new HashMap<>();
        static Map<String,String>datacomb=new HashMap<>();
        static FileInputStream file;

        public static void readTestData(String testCaseID){
                try {
                        file = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//TestData//ExcelTestData.xlsx");
                        Workbook wb= WorkbookFactory.create(file);
                        Sheet sh=wb.getSheet("Sheet1");
                        for(Row row:sh){
                                Cell cellvalue=row.getCell(0);
                                String cellStringValue=cellvalue.getStringCellValue();
                                if(cellStringValue.equals("TestCaseID")){
                                        for(Cell cell:row){
                                                keys.put(cell.getColumnIndex(),cell.getStringCellValue());
                                        }
                                }else if(cellStringValue.equals(testCaseID)){
                                        for(Cell cell:row){
                                                values.put(cell.getColumnIndex(),cell.getStringCellValue());
                                        }
                                }
                        }
                        for(Integer index:values.keySet()){
                                datacomb.put(keys.get(index),values.get(index));
                        }
                }catch (Exception ignored){
                        System.out.println("Unable to read test data "+ignored.getMessage());
                }
        }

        public static String getData(String key){
                return datacomb.get(key);
        }
}
