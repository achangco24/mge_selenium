/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Register
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
package aut.menu.meter.config;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityObjects;
import ey.manila.qa.automation.element.ElementHandler;

public class Register {
	private WebDriver driver;
	private WebDriverWait wait;
	private By dataTableByRef = By.xpath("//*[@id=\"accordionDataTableBody\"]/tr");
	private ElementHandler dataTable;
	private List<By> dataTableFrameMap;
	
	public Register (WebDriver aut, WebDriverWait wait, EntityObjects entityRepo) {
		this.driver = aut;
		this.wait = wait;
		
		dataTableFrameMap = new ArrayList<By>();
		dataTableFrameMap.addAll(entityRepo.frame.tabPage.toFrameMap());
		dataTableFrameMap.add(By.id("registerAccordion"));
		
		dataTable = new ElementHandler(driver, dataTableByRef, dataTableFrameMap);
	}
	
	public int count() throws Exception {
		dataTable.setToContext();
		return driver.findElements(dataTableByRef).size();
	}
	
	public void enterSequenceAt(int regIndex, String regSequence) throws Exception {
		setRegisterField(getSequenceElementAt(regIndex), regSequence);
	}
	
	public void enterRegisterConstantAt(int regIndex, String regConstant) throws Exception {
		setRegisterField(getRegisterConstantElementAt(regIndex),regConstant);
	}
	
	public void enterFullDigitsLeftAt(int regIndex, String fullDigits) throws Exception {
		setRegisterField(getFullDigitsLeftElementAt(regIndex), fullDigits);
	}
	
	public void enterFullDigitsRightAt(int regIndex, String fullDigits) throws Exception {
		setRegisterField(getFullDigitsRightElementAt(regIndex), fullDigits);
	}
	
	public void enterFullScaleAt(int regIndex, String fullScale) throws Exception {
		setRegisterField(getFullScaleElementAt(regIndex), fullScale);
	}
	
	public void enterToleranceAt(int regIndex, String tolerance) throws Exception {
		setRegisterField(getToleranceElementAt(regIndex), tolerance);
	}
	
	public void clickExpandAll() throws Exception {
		getExpandAll().toWebElement().click();
	}
	
	private void setRegisterField(ElementHandler registerField, String value) throws Exception {
		registerField.toWebElement().clear();
		registerField.toWebElement().sendKeys(value);
	}
	
	private ElementHandler getSequenceElementAt(int index) {
		By byRef = By.id("REG:" + String.valueOf(index) + "$READ_SEQ");
		return new ElementHandler(driver, byRef, dataTableFrameMap);
	}
	
	private ElementHandler getRegisterConstantElementAt(int index) {
		By byRef = By.id("REG:" + String.valueOf(index) + "$REG_CONST");
		return new ElementHandler(driver, byRef, dataTableFrameMap);
	}
	
	private ElementHandler getFullDigitsLeftElementAt(int index) {
		By byRef = By.id("REG:" + String.valueOf(index) + "$NBR_OF_DGTS_LFT");
		return new ElementHandler(driver, byRef, dataTableFrameMap);
	}
	
	private ElementHandler getFullDigitsRightElementAt(int index) {
		By byRef = By.id("REG:" + String.valueOf(index) + "$NBR_OF_DGTS_RGT");
		return new ElementHandler(driver, byRef, dataTableFrameMap);
	}
	
	private ElementHandler getFullScaleElementAt(int index) {
		By byRef = By.id("REG:" + String.valueOf(index) + "$FULL_SCALE");
		return new ElementHandler(driver, byRef, dataTableFrameMap);
	}
	
	private ElementHandler getToleranceElementAt(int index) {
		By byRef = By.id("REG:" + String.valueOf(index) + "$TOLERANCE");
		return new ElementHandler(driver, byRef, dataTableFrameMap);
	}
	
	private ElementHandler getExpandAll() {
		By byRef = By.id("expandAllLink");
		return new ElementHandler(driver, byRef, dataTableFrameMap);
	}
}
