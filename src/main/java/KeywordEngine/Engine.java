package KeywordEngine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class Engine {
	
	public WebDriver driver;
	public Properties prop;
	
	public static Workbook book;
	public static Sheet sheet;
	
	public final String SCENARIO_SHEET_PATH = "C:\\Users\\dell\\eclipse-workspace\\SeleniumSessionsClasses\\src\\main\\java\\KeywordScenarios\\KeywordDriven.xlsx";

	public void StartExecution(String sheetname) {
		
		FileInputStream file = null;
		
		try {
			file = new FileInputStream("SCENARIO_SHEET_PATH");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		int k = 0;
		for(int i = 0; i<sheet.getLastRowNum(); i++) {
			
		String	locatorcolvalue = sheet.getRow(i+1).getCell(k+1).toString().trim();
		if(!locatorcolvalue.equalsIgnoreCase("NA")) {
			String locatorname = locatorcolvalue.split("=")[0].trim();
			String locatorvalue = locatorcolvalue.split("=")[1].trim();
			
		}
		
		String action = sheet.getRow(i+1).getCell(k+2).toString().trim();
		String value = sheet.getRow(i+1).getCell(k+3).toString().trim();
		}
		
		
	}
}
