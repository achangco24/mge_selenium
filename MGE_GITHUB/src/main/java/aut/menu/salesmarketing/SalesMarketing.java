/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Sales Marketing
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
package aut.menu.salesmarketing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.IMenu;
import aut.menu.MenuHandler;
import aut.menu.salesmarketing.order.OrderMenu;
import ey.manila.qa.automation.element.ElementHandler;

public class SalesMarketing extends MenuHandler{
	public final IMenu order;
	//public final IMenu campaign;
	//public final IMenu quote;
	
	public SalesMarketing(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		initialize(aut, frame, wait);
		menuMap.add(new ElementHandler(aut, By.id("IM_menuButton"), frame.main.toFrameMap()));
		menuMap.add(new ElementHandler(aut, By.id("CI_MAINMENU_topMenuItem0x10"), frame.main.toFrameMap()));
		
		order = new OrderMenu(aut, frame, wait, menuMap);
	}
}
