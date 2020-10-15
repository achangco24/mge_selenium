/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Tab Grid
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
package aut.tabs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityObjects;
import ey.manila.qa.automation.element.ElementHandler;

public abstract class TabGrid {
	protected String header;
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected EntityObjects repo;
	protected List<By> gridMap;
	protected By gridByRef = By.xpath("//*[@id=\"dataTableBody\"]/tr");
	protected ElementHandler grid;
	
	public int count() throws Exception {
		grid.setToContext();
		List<WebElement> charRows = driver.findElements(gridByRef);
		return charRows.size();
	}
	
	protected void initialize(WebDriver aut, WebDriverWait wait, EntityObjects entityRepo, By gridFrame, String header) {
		this.driver = aut;
		this.wait = wait;
		this.repo = entityRepo;
		this.header = header;
		
		this.gridMap = new ArrayList<By>();
		this.gridMap.addAll(repo.frame.tabPage.toFrameMap());
		this.gridMap.add(gridFrame);
		
		grid = new ElementHandler(driver, gridByRef, gridMap);
	}
	
	protected void setEffDate(String effDate, ElementHandler elementHandler) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(elementHandler.toWebElement()));
		elementHandler.toWebElement().clear();	//Luigi 10/01: Clearing fields before setting new date value
		elementHandler.toWebElement().sendKeys(effDate);
		elementHandler.toWebElement().sendKeys(Keys.chord(Keys.TAB));
	}
	
	protected void setEffTime(String effTime, ElementHandler elementHandler) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(elementHandler.toWebElement()));
		elementHandler.toWebElement().sendKeys(effTime);
		elementHandler.toWebElement().sendKeys(Keys.chord(Keys.TAB));
	}
	
	protected void setType(String type, ElementHandler elementHandler) throws Exception {
		//elementHandler.toWebElement().sendKeys(type);
		//elementHandler.toWebElement().sendKeys(Keys.chord(Keys.TAB));
		wait.until(ExpectedConditions.elementToBeClickable(elementHandler.toWebElement()));
		elementHandler.selectTextAs(type);	//Luigi 10/01: Char Type is dropdown. Hence, modify the script to accomodate dropdown element.
	}
	
	protected void setValue(String value, ElementHandler elementHandler) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(elementHandler.toWebElement()));	//Lui 10/2/19: wait to load element
		/*
		 * CI.016 - 2020-04-07 - Start Change
		 */
		//elementHandler.toWebElement().sendKeys(value);
		//elementHandler.toWebElement().sendKeys(Keys.chord(Keys.TAB));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String idHolder = elementHandler.toWebElement().getAttribute("id");
		
       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + value + "'");
		elementHandler.toWebElement().sendKeys(Keys.ENTER);
		/*
		 * CI.016 - 2020-04-07 - End Change
		 */
	}
}
