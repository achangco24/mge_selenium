/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Register Read
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
package aut.menu.meterread.read;

import java.util.ArrayList;
import java.util.List;

import javax.swing.KeyStroke;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityObjects;
import ey.manila.qa.automation.element.ElementHandler;

public class RegisterRead {
	private WebDriver driver;
	private WebDriverWait wait;
	private By dataTableByRef = By.xpath("//*[@id=\"dataTableBody\"]/tr");
	private ElementHandler dataTable;
	private List<By> dataTableFrameMap;
	
	public RegisterRead (WebDriver aut, WebDriverWait wait, EntityObjects entityRepo) {
		this.driver = aut;
		this.wait = wait;
		
		dataTableFrameMap = new ArrayList<By>();
		dataTableFrameMap.addAll(entityRepo.frame.tabPage.toFrameMap());
		dataTableFrameMap.add(By.id("dataframe"));
		
		dataTable = new ElementHandler(driver, dataTableByRef, dataTableFrameMap);
	}
	
	public int count() throws Exception {
		dataTable.setToContext();
		return driver.findElements(dataTableByRef).size();
	}
	
	public void setReadTypeAt(int index, String readType) throws Exception {
		getReadTypeElementAt(index).selectTextAs(readType);
	}
	
	public void enterReadValueAt(int index, String readValue) throws Exception {
		setRegisterField(getReadValueElementAt(index), readValue);
	}
	
	private void setRegisterField(ElementHandler registerField, String value) throws Exception {
		
		/*
		 * CP_BI.002 - 2020-07-08 - Start Change
		 */
		registerField.toWebElement().clear();
		//registerField.toWebElement().sendKeys(value);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
       	js.executeScript("document.getElementById(\"" + registerField.toWebElement().getAttribute("id") + "\").value = '" + value + "'");
       	
       	registerField.toWebElement().sendKeys(Keys.chord(Keys.TAB));
		/*
		 * CP_BI.002 - 2020-07-08 - End Change
		 */
	}
	
	private ElementHandler getReadTypeElementAt(int index) {
		return new ElementHandler(driver, By.id("REG_READ:" + String.valueOf(index) + "$READ_TYPE_FLG"), dataTableFrameMap);
	}
	
	private ElementHandler getReadValueElementAt(int index) {
		return new ElementHandler(driver, By.id("REG_READ:" + String.valueOf(index) + "$REG_READING"), dataTableFrameMap);
	}
}
