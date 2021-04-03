package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class GenericMethods {

	
	public static String[][] getData(String fileName,String sheetName) throws IOException{
			File file = new File(fileName);
			FileInputStream ips = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(ips);
			Sheet sh = wb.getSheet(sheetName);
			int rowNumber = sh.getLastRowNum()+1;
			int colNumber = sh.getRow(0).getLastCellNum();
			String[][] data = new String[rowNumber][colNumber];

			for(int i = 0;i<rowNumber;i++) {
				Row row = sh.getRow(i);
				for(int j=0;j<colNumber;j++) {
					Cell cell = row.getCell(j);
					String value = new DataFormatter().formatCellValue(cell);
					data[i][j] = value;

				}
			}
			wb.close();
			return data;
		}
	
	public static String getClassName(String className) {
		String[] getClassName = className.split("\\.");

		System.out.println(getClassName[getClassName.length-1]);
		int lengthOfClass = getClassName[getClassName.length-1].length();
		String shortClassName;
		if(lengthOfClass >32)
			shortClassName = getClassName[getClassName.length-1].substring(0, 31);
		else
			shortClassName = getClassName[getClassName.length-1];
		return shortClassName;
	}
	
	public static void takeScreenshot(String path, WebDriver driver, String scriptName) throws IOException {
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File(path+"\\"+scriptName+"_Screenshot"+(new Random().nextInt())+".jpg"));
	}
}
