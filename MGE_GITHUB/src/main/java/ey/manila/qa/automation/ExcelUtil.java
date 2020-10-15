package ey.manila.qa.automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	//private final String PATH = "CPCC003.xlsx";
	
	public void getData(String src, String targetSheet) throws IOException {
		ArrayList<String> data = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheetCount = workbook.getNumberOfSheets();
		System.out.println("RENZO >> Excel Counter: " + sheetCount);
		for(int i=0; i<sheetCount; i++) {
			System.out.println("RENZO >> Sheet: " + workbook.getSheetName(i));
			if(workbook.getSheetName(i).equalsIgnoreCase(targetSheet)) {
				//XSSFSheet sheet = workbook.getSheetAt(i);
				System.out.println("RENZO >> MATCH FOUND!");
			}
		}
		data.add("Test");
		
	}
}
