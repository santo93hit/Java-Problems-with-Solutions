package com.fragma;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    public static final String SAMPLE_XLSX_FILE_PATH = "E://OxegenWorkSpace/IPL_Data_set/matches.csv";

    public static List<Match> getExcelSheetAndPrepareObject() throws IOException{
    	List<Match> matches=new LinkedList<Match>();
    	 try {
    	        FileInputStream file = new FileInputStream(new File("SAMPLE_XLSX_FILE_PATH"));
//    	        FileInputStream file = new FileInputStream(new File(E:/OxegenWorkSpace/IPL_Data_set/matches.csv"));
    	        XSSFWorkbook workbook = new XSSFWorkbook(file);
    	        XSSFSheet sheet = workbook.getSheetAt(0);
    	        for(Row row : sheet) {
    	        	for(Cell cell : row) {
    	        		switch (cell.getCellType()){
    	                    case Cell.CELL_TYPE_NUMERIC:
    	                        System.out.print(cell.getNumericCellValue() + "\t");
    	                        break;
    	                    case Cell.CELL_TYPE_STRING:
    	                        System.out.print(cell.getStringCellValue() + "\t");
    	                        break;
    	                }
    	        	}
    	        }
    	        file.close();
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	 return matches;
    }
}