/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * AdminB
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
package aut.admin.d;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.admin.AdminHandler;
import aut.admin.IAdmin;
import aut.admin.d.depositclass.DepositClassMenu;
import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;

public class AdminD extends AdminHandler {
	public AdminD(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		initialize(aut, frame, wait);
		adminMap.add(new ElementHandler(aut, By.id("IM_adminButton"), frame.main.toFrameMap()));
		adminMap.add(new ElementHandler(aut, By.id("CI_ADMINMENU_topMenuItem0x3"), frame.main.toFrameMap()));
		
		depositclass = new DepositClassMenu(aut, frame, wait, adminMap);
	}
	
	public final IAdmin depositclass;
}
