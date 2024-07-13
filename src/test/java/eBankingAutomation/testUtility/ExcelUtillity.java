package eBankingAutomation.testUtility;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtillity {

	

	public static int getRowNum(String xFile, String xSheet) throws IOException {
		 FileInputStream fi = new FileInputStream(xFile);
		 XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xSheet);
		int rownum = ws.getLastRowNum();
		wb.close();
		fi.close();

		return rownum;
	}

	public static int getCellNum(String xFile, String xSheet, int rown) throws IOException {
		FileInputStream fi = new FileInputStream(xFile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xSheet);
		XSSFRow row=ws.getRow(rown);
		int cellnum=row.getLastCellNum();
		wb.close();
		fi.close();
		

		return cellnum;
	}

	public static String getCellData(String xFile, String xSheet, int rown, int celln) throws IOException {
		FileInputStream fi = new FileInputStream(xFile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xSheet);
		XSSFRow row = ws.getRow(rown);
		XSSFCell cell = row.getCell(celln);
		String data;
		try {
			data = cell.toString();
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;

	}

	public static void setCellData(String xFile, String xSheet, int rown, int celln, String value) throws IOException {
		FileInputStream fi = new FileInputStream(xFile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xSheet);
		XSSFRow row = ws.getRow(rown);
		XSSFCell cell = row.createCell(celln);
		cell.setCellValue(value);
		FileOutputStream fo = new FileOutputStream(xFile);
		wb.write(fo);
		wb.close();
		fi.close();

	}

}
