/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Credit Collection
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
package aut.menu.creditcoll;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.IMenu;
import aut.menu.MenuHandler;
import aut.menu.creditcoll.collection.CollectionMenu;
import aut.menu.creditcoll.severance.SeveranceMenu;
import ey.manila.qa.automation.element.ElementHandler;

public class CreditCollection extends MenuHandler{
	public final IMenu collections;
	public final IMenu severance;
	
	public CreditCollection(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		initialize(aut, frame, wait);
		menuMap.add(new ElementHandler(aut, By.id("IM_menuButton"), frame.main.toFrameMap()));
		menuMap.add(new ElementHandler(aut, By.id("CI_MAINMENU_topMenuItem0x0"), frame.main.toFrameMap()));
		
		collections = new CollectionMenu(aut, frame, wait, menuMap);
		severance = new SeveranceMenu(aut, frame, wait, menuMap);
	}
}


