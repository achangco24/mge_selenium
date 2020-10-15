/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Geographic Data Grid
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
package aut.tabs.geodata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityObjects;
import aut.tabs.GridType;
import aut.tabs.ITabGrid;
import aut.tabs.TabGrid;
import ey.manila.qa.automation.element.ElementHandler;

public class GeographicDataGrid extends TabGrid implements ITabGrid {
	public GeographicDataGrid(WebDriver aut, WebDriverWait wait, EntityObjects entityRepo, By gridFrame, String header) {
		initialize(aut, wait, entityRepo, gridFrame, header);
	}
	
	public void addRow() throws Exception {
		grid.setToContext();
		driver.findElement(By.id("IM_" + header + ":" + String.valueOf(count() - 1) + "$Section1_AddButton")).click();
	}

	public void deleteRow(int rowIndex) throws Exception {
		grid.setToContext();
		driver.findElement(By.id("IM_" + header + ":" + String.valueOf(count() - 1) + "$Section1_DelButton")).click();
	}

	@Override
	public List<?> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRowAs(int rowIndex, GridType geographicData) throws Exception {
		setGeoTypeAt(rowIndex, geographicData.getType());
		setGeoValAt(rowIndex, geographicData.getValue());
	}
	
	public void setGeoTypeAt(int rowIndex, String geoType) throws Exception {
		setType(geoType, getGeoTypeElementAt(rowIndex));
	}
	
	public void setGeoValAt(int rowIndex, String geoVal) throws Exception {
		setValue(geoVal, getGeoValElementAt(rowIndex));
	}
	
	private ElementHandler getGeoTypeElementAt(int rowIndex) {
		return new ElementHandler(driver, By.id(header + ":" + rowIndex + "$GEO_TYPE_CD"), gridMap);
	}

	private ElementHandler getGeoValElementAt(int rowIndex) throws Exception {
		ElementHandler defaultGeoVal = new ElementHandler(driver, By.id(header + ":" + rowIndex + "$GEO_VAL"), gridMap);
		String display = defaultGeoVal.toWebElement().getAttribute("style");
		if (display.equals("display: inline;")) {
			return defaultGeoVal;
		}
		
		return new ElementHandler(driver, By.id(header + ":" + rowIndex + "$GEO_VAL"), gridMap);
	}
}
