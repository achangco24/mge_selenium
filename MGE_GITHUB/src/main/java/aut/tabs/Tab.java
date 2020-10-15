/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Tab
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
package aut.tabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ey.manila.qa.automation.element.ElementHandler;

public class Tab {
	private ElementHandler tabElement;
	
	public Tab(WebDriver aut, By byLocator, List<By> frameMap) {
		tabElement = new ElementHandler(aut, byLocator, frameMap);
	}
	
	public boolean switchTo() throws Exception {
		tabElement.toWebElement().click();
		
		if (tabElement.toWebElement().getAttribute("class").equals("activeTab")) {
			return true;
		}
		return false;
	}
	
	public WebElement getWebElement() throws Exception{
		return tabElement.toWebElement();
	}
	
	

}
