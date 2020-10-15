/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Tools
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

import ey.manila.qa.tools.etbot.aut.menu.obj.ToolsObjects;
import ey.manila.qa.tools.etbot.aut.pages.SwitchUser;

public class Tools extends MenuItem {
	public final SwitchUser switchUser;
	
	public Tools(WebDriver driver) throws Exception {
		this.aut = driver;
		this.objRepository = new ToolsObjects(this.aut);
		this.self = ((ToolsObjects) this.objRepository).menu.toWebElement();
		
		//Initialize sub menu
		switchUser = new SwitchUser(aut, objRepository);
	}
}
