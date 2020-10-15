/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Menu Item
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
package ey.manila.qa.tools.etbot.aut.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ey.manila.qa.automation.element.ElementActions;
import ey.manila.qa.automation.element.WebElementRepository;

public abstract class MenuItem {
	protected WebElement self;
	protected WebDriver aut;
	protected WebElementRepository objRepository;
	
	public void open() throws Exception {
		ElementActions.hover(aut, self);
	}
}
