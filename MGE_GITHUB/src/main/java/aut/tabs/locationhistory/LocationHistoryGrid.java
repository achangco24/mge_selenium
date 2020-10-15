/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Location History Grid
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
package aut.tabs.locationhistory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityObjects;
import aut.tabs.GridType;
import aut.tabs.ITabGrid;
import aut.tabs.TabGrid;
import ey.manila.qa.automation.element.ElementHandler;

public class LocationHistoryGrid extends TabGrid implements ITabGrid {
	public LocationHistoryGrid(WebDriver aut, WebDriverWait wait, EntityObjects entityRepo, By gridFrame, String header) {
		initialize(aut, wait, entityRepo, gridFrame, header);
	}
	
	public List<LocationHistory> getAll() throws Exception {
		List<LocationHistory> locationHistory = new ArrayList<LocationHistory>();
		grid.setToContext();
		
		List<WebElement> charRows = driver.findElements(gridByRef);
		for (WebElement charRow : charRows) {
			int row = Integer.parseInt(charRow.getAttribute("uirowindex"));
			String location = getLocationElementAt(row).toWebElement().getText();
			if (location.equals("")) {
				continue;
			}
			
			String locationDate = getLocationDateElementAt(row).toWebElement().getText();
			String locationTime = getLocationTimeElementAt(row).toWebElement().getText();
			String locationType = getLocationTypeElementAt(row).toWebElement().getText();
			
			locationHistory.add(new LocationHistory(locationDate, locationTime, locationType, location, row));
		}
		
		return locationHistory;
	}
	
	public void addRow() throws Exception {
		grid.setToContext();
		driver.findElement(By.id("IM_" + header + ":" + String.valueOf(count() - 1) + "$ADD_LOC_HIST")).click();
	}
	
	public void deleteRow(int rowIndex) throws Exception {
		grid.setToContext();
		driver.findElement(By.id("IM_" + header + ":" + String.valueOf(rowIndex) + "$DEL_LOC_HIST")).click();
	}
	
	public void setRowAs(int rowIndex, GridType locationHistory) throws Exception {
		setLocationDateAt(rowIndex, locationHistory.getValue());
		setLocationTimeAt(rowIndex, locationHistory.getEffTime());
		setLocationAt(rowIndex, locationHistory.getValue());
	}
	
	public void setLocationDateAt(int rowIndex, String locationDate) throws Exception {
		setEffDate(locationDate, getLocationDateElementAt(rowIndex));
	}
	
	public void setLocationTimeAt(int rowIndex, String locationTime) throws Exception {
		setEffTime(locationTime, getLocationTimeElementAt(rowIndex));
	}
	
	public void setLocationAt(int rowIndex, String location) throws Exception {
		setValue(location, getLocationElementAt(rowIndex));
	}
	
	public void waitForLocationDescriptionAt(int rowIndex) throws Exception {
		grid.setToContext();
		ElementHandler locationDescription = getLocationDescriptionElementAt(rowIndex);
		locationDescription.waitWhileAttributeValue("innerHTML", "<span></span>");
	}
	
	private ElementHandler getLocationElementAt(int rowIndex) {
		return new ElementHandler(driver, By.id(header + ":" + rowIndex + "$STK_LOC_CD"), gridMap);
	}
	
	private ElementHandler getLocationDateElementAt(int rowIndex) {
		return new ElementHandler(driver, By.id(header + ":" + rowIndex + "$LOC_DTTM_FWDTTM_P1"), gridMap);
	}
	
	private ElementHandler getLocationTimeElementAt(int rowIndex) {
		return new ElementHandler(driver, By.id(header + ":" + rowIndex + "$LOC_DTTM_FWDTTM_P2"), gridMap);
	}
	
	private ElementHandler getLocationTypeElementAt(int rowIndex) {
		return new ElementHandler(driver, By.id(header + ":" + rowIndex + "$LOC_HIST_TYP_FLG"), gridMap);
	}
	
	private ElementHandler getLocationDescriptionElementAt(int rowIndex) {
		return new ElementHandler(driver, By.id(header + ":" + rowIndex + "$SLO_DESCR"), gridMap);
	}
}
