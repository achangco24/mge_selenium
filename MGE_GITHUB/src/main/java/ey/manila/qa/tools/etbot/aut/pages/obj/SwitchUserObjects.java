/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Switch Users Objects
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
package ey.manila.qa.tools.etbot.aut.pages.obj;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ey.manila.qa.automation.element.ElementHandler;

public class SwitchUserObjects {
	public final ElementHandler title;
	
	public SwitchUserObjects(WebDriver driver) {
		List<By> frameMap = new ArrayList<By>();
		frameMap.add(By.id("frmMain"));
		
		title = new ElementHandler(driver, By.id("divToptoolbar"), frameMap);
	}
}
