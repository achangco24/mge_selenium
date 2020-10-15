/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Timesheets
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

import ey.manila.qa.tools.etbot.aut.menu.obj.TimesheetsObjects;

public class Timesheets extends MenuItem {
	public Timesheets(WebDriver driver) throws Exception {
		this.aut = driver;
		this.objRepository = new TimesheetsObjects(this.aut);
		this.self = ((TimesheetsObjects) this.objRepository).menu.toWebElement();
	}
}
