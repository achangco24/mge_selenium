/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Excel File
 * 
 *************************************************************************************
 *  
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * YYYY-MM-DD	IN		Reason text.    
 * 
 *************************************************************************************
 */
package ey.manila.qa.spreadsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {
	private String excelFilePath;
	private FileInputStream inputStream;
	private FileOutputStream outputStream;
	private Workbook workbook;
	
	private Sheet sheet;
	/**
	 * Sets the current sheet based on sheet name
	 * @param value - sheet name
	 */
	public void setSheet(String value) {
		sheet = workbook.getSheet(value);
	}
	/**
	 * Sets the current sheet based on index
	 * @param value - sheet index
	 */
	public void setSheet(int value) {
		sheet = workbook.getSheetAt(value);
	}
	/**
	 * Gets the index of the current sheet
	 * @return Zero-based index of the current sheet
	 */
	public int getSheetIndex() {
		return workbook.getActiveSheetIndex();
	}
	
	private int currentRow = 0;
	/**
	 * Sets the current row at the current sheet
	 * @param value - row index
	 */
	public void setCurrentRow(int value) {
		currentRow = value;
	}
	
	private String multilineSeparator;
	/**
	 * <p>Sets the character used as a separator for cells with multiline values.</p>
	 * 
	 * @param value
	 */
	public void setMultilineSeparator(String value) {
		this.multilineSeparator = value;
	}
	
	/**
	 * <p>Creates an Excel file object representation of the specified path</p>
	 * 
	 * @param filePath - full path of the file
	 */
	public ExcelFile(String filePath) {
		try {
			excelFilePath = filePath;
	        inputStream = new FileInputStream(new File(excelFilePath));
	        getWorkbook();
		}
		catch (Exception e) {
			System.out.println("Error occured in initializing Excel file");
			System.out.println("File: " + filePath);
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>Retrieves a hash map of sheet names and indices that are available
	 * in the current Excel file.</p>
	 * 
	 * @return Mapping of names and indices of the available
	 * sheets, with name as its key. Returns empty hash map if no sheets were found.
	 */
	public HashMap<String, Integer> getAllSheets() {
		HashMap<String, Integer> allSheets = new HashMap<String, Integer>();
		int sheetCount = workbook.getNumberOfSheets();
		for (int ctr = 0; ctr < sheetCount; ctr++) {
			allSheets.put(workbook.getSheetName(ctr), ctr);
		}
		
		return allSheets;
	}
	
	/**
	 * <p>Gets the cell data at the current row and in column identified by its name.</p>
	 * 
	 * @param columnName - Name of the column whose data will be retrieved at the current row
	 * @return Cell data contained at the current row and column name.
	 */
	public String getCellDataAtColumn(String columnName) {
		return getCellData(getColumnIndex(columnName));
	}
	
	/**
	 * <p>Gets the cell data at the current row and in column identified by its index.</p>
	 * 
	 * @param col - Column index whose data at current row will be retrieved
	 * @return Cell data contained at the current row and column index
	 */
	public String getCellDataAtColumn(int col) {
		return getCellData(col);
	}
	
	/**
	 * <p>Gets the cell data at the column identified by its name.</p>
	 * 
	 * <p><b>Note</b><br>This method has not been fully tested yet for cells
	 * with multiline values.</p>
	 * 
	 * @param columnName - Name of the column whose column data will be retrieved
	 * @return List of strings containing the column data
	 */
	public List<String> getCellDataAsCollectionAtColumn(String columnName) {
		return getCellDataAsCollectionAt(getColumnIndex(columnName));
	}
	
	/**
	 * <p>Gets the cell data as an ArrayList at the column identified by its column index.</p>
	 * 
	 * <p><b>Note</b><br>This method has not been fully tested yet for cells
	 * with multiline values.</p>
	 * 
	 * @param col - Index of the column whose column data will be retrieved
	 * @return List of strings containing the column data
	 */
	public List<String> getCellDataAsCollectionAtColumn(int col) {
		return getCellDataAsCollectionAt(col);
	}
	
	/**
	 * <p>Gets the index of the first row from the Excel file
	 * that has input data.</p>
	 * 
	 * <p><b>Note</b><br>White spaces and cell formatting are considered
	 * to be input data and will be included in getting the row index.</p>
	 * 
	 * @return Zero-based index number of the first row
	 */
	public int getFirstRowNum() {
		return (sheet.getFirstRowNum());
	}
	
	/**
	 * <p>Gets the index of the last row from the Excel file
	 * that has input data.</p>
	 * 
	 * <p><b>Note</b><br>White spaces and cell formatting are considered
	 * to be input data and will be included in getting the row index.</p>
	 * 
	 * @return Zero-based index number of the last row
	 */
	public int getLastRowNum() {
		return (sheet.getLastRowNum());
	}
	
	/**
	 * <p>Sets the text at current row and given column name
	 * with the specified text.</p>
	 *  
	 * @param columnName - Column name of the current row whose text will be set
	 * @param text - input text to be placed at the current row and column name
	 */
	public void setTextAt(String columnName, String text) {
		setText(getColumnIndex(columnName), text);
	}
	
	/**
	 * <p>Sets text at the current row and column index
	 * with the specified text.</p>
	 * 
	 * @param col - Column index of the current row whose text will be set
	 * @param text - input text to be placed at the current row and column name
	 */
	public void setTextAt(int col, String text) {
		setText(col, text);
	}
	
	/**
	 * <p>Gets the appropriate Excel object depending
	 * if file is XLS or XLSX</p>
	 * 
	 * @throws IOException
	 */
	private void getWorkbook() throws IOException {
	    if (excelFilePath.endsWith("xlsx")) {
	        workbook = new XSSFWorkbook(inputStream);
	    }
	    else if (excelFilePath.endsWith("xls")) {
	        workbook = new HSSFWorkbook(inputStream);
	    }
	    else {
	        throw new IllegalArgumentException("The specified file is not Excel file");
	    }
	}
	
	/**
	 * <p>Gets the column index of the given text</p>
	 * 
	 * @param value - The text to be searched
	 * @return Zero-based column index of the input text. Returns -1 if not found.
	 */
	private int getColumnIndex(String value) {
		Iterator<Cell> iterator = sheet.getRow(0).iterator();
        
        while (iterator.hasNext()) {
        	Cell cell = iterator.next();
        	if (cell.getStringCellValue().trim().toLowerCase().equals(value.trim().toLowerCase())) {
        		return cell.getColumnIndex();
        	}
        }
        
        return -1;
	}
	
	/**
	 * <p>Gets cell data at the current row and specified column index</p>
	 * 
	 * @param col - Zero-based index of the column where cell data will be retrieved
	 * @return Cell data at the current row and column index
	 */
	private String getCellData(int col) {
		if (col < 0) {
			return "";
		}
		
		try {
			return (sheet.getRow(currentRow).getCell(col).getStringCellValue());
		} catch (Exception e) {
			return String.valueOf((sheet.getRow(currentRow).getCell(col).getNumericCellValue()));
		}
	}
	
	private void setText(int col, String text) {
		try {
			outputStream = new FileOutputStream(excelFilePath);
			sheet.getRow(currentRow).getCell(col).setCellValue(text);
			workbook.write(outputStream);
			outputStream.close();
			outputStream.flush();
		} catch (Exception e) {
			System.out.println("Error occured in setting cell value.");
			e.printStackTrace();
		}
	}
	
	private List<String> getCellDataAsCollectionAt(int col) {
		if (col < 0) {
			return new ArrayList<String>();
		}
		
		try {
			return Arrays.asList((sheet.getRow(currentRow).getCell(col)).getStringCellValue().split(multilineSeparator));
		} catch (Exception e) {
			String temp = String.valueOf(sheet.getRow(currentRow).getCell(col).getNumericCellValue());
			return (Arrays.asList(temp.split(multilineSeparator)));
		}
	}
}
