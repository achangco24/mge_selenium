/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Characteristics Grid
 * 
 *************************************************************************************
 *  
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * 2020-04-07	GSando	CI.016. Add components for creating a Premise.  
 * 
 *************************************************************************************
 */
package aut.tabs.characteristics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityObjects;
import aut.tabs.GridType;
import aut.tabs.ITabGrid;
import aut.tabs.TabGrid;
import ey.manila.qa.automation.element.ElementHandler;

public class CharacteristicGrid extends TabGrid implements ITabGrid {
	public CharacteristicGrid(WebDriver aut, WebDriverWait wait, EntityObjects entityRepo, By gridFrame, String header) {
		initialize(aut, wait, entityRepo, gridFrame, header);
	}
	
	public List<Characteristic> getAll() throws Exception {
		List<Characteristic> characteristics = new ArrayList<Characteristic>();
		grid.setToContext();
		
		List<WebElement> charRows = driver.findElements(gridByRef);
		for (WebElement charRow : charRows) {
			int row = Integer.parseInt(charRow.getAttribute("uirowindex"));
			String effDate = getEffDateElementAt(row).toWebElement().getAttribute("value");
			String charTypeCode = getCharTypeElementAt(row).toWebElement().getAttribute("value");
			String charVal = getCharValElementAt(row).toWebElement().getAttribute("value");
			
			characteristics.add(new Characteristic(charTypeCode, charVal, effDate, row));
		}
		
		return characteristics;
	}
	
	public void addRow() throws Exception {
		grid.setToContext();
		driver.findElement(By.id("IM_" + header + ":" + String.valueOf(count() - 1) + "$Grid_AddButton")).click();
	}
	
	public void deleteRow(int rowIndex) throws Exception {
		grid.setToContext();
		driver.findElement(By.id("IM_" + header + ":" + String.valueOf(rowIndex) + "$Grid_DelButton")).click();
	}
	
	public void setRowAs(int rowIndex, GridType characteristic) throws Exception {
		setEffDateAt(rowIndex, characteristic.getEffDate());
		setCharTypeAt(rowIndex, characteristic.getType());
		setCharValAt(rowIndex, characteristic.getValue());
	}
	
	public void setCharTypeAt(int rowIndex, String charType) throws Exception {
		setType(charType, getCharTypeElementAt(rowIndex));
	}
	
	public void setCharValAt(int rowIndex, String charVal) throws Exception {
		setValue(charVal, getCharValElementAt(rowIndex));
	}
	
	public void setEffDateAt(int rowIndex, String effDate) throws Exception {
		setEffDate(effDate, getEffDateElementAt(rowIndex));
	}
	
	private ElementHandler getEffDateElementAt(int rowIndex) {
		return new ElementHandler(driver, By.id(header + ":" + rowIndex + "$EFFDT"), gridMap);
	}
	
	private ElementHandler getCharTypeElementAt(int rowIndex) {
		return new ElementHandler(driver, By.id(header + ":" + rowIndex + "$CHAR_TYPE_CD"), gridMap);
	}
	
	private ElementHandler getCharValElementAt(int rowIndex) throws Exception {
		ElementHandler defaultCharVal = new ElementHandler(driver, By.id(header + ":" + rowIndex + "$CHAR_VAL"), gridMap);
		String display = defaultCharVal.toWebElement().getAttribute("style");
		if (display.equals("display: inline;")) {
			return defaultCharVal;
		}
		
		return new ElementHandler(driver, By.id(header + ":" + rowIndex + "$ADHOC_CHAR_VAL"), gridMap);
	}
	
	private ElementHandler getCharValDescElementAt(int rowIndex) {
		return new ElementHandler(driver, By.id(header + ":" + rowIndex + "$CHAR_VAL_DESCR"), gridMap);
	}
	
	/*
	 * CI.016 - 2020-04-07 - Start Add
	 */
	public void clickCharValBtnAt(int rowIndex) throws Exception {
		WebElement charBtn = driver.findElement(By.id("IM_" + header + ":" + rowIndex + "$CHAR_VAL"));
		wait.until(ExpectedConditions.elementToBeClickable(charBtn));
		charBtn.click();
	}
	/*
	 * CI.016 - 2020-04-07 - End Add
	 */
}
