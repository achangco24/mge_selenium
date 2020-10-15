/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Gte
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
package ey.manila.qa.tools.etbot.aut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ey.manila.qa.tools.etbot.aut.constants.DynamicObjectsId;
import ey.manila.qa.tools.etbot.aut.menu.Timesheets;
import ey.manila.qa.tools.etbot.aut.menu.Tools;
import ey.manila.qa.tools.etbot.aut.pages.Home;

public class Gte {
	public final Home home;
	public final Timesheets timesheets;
	public final Tools tools;
	
	private WebDriver aut;
	public WebDriver getAut() {
		return this.aut;
	}
	
	public Gte(WebDriver driver, String url) throws Exception {
		this.aut = driver;
		this.aut.get(url);
		
		//Initialize menu
		this.home = new Home(aut);
		this.timesheets = new Timesheets(aut);
		this.tools = new Tools(aut);
	}
	
	public void revertToOriginalUser() {
		//Click the revert to original user WebElement if existing
		if (aut.findElements(By.id(DynamicObjectsId.Home.ORIGINALUSER)).size() != 0) {
			aut.findElement(By.id(DynamicObjectsId.Home.ORIGINALUSER)).click();
		}
	}
}
