/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Account Menu
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
package aut.menu.custinfo.account;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuHandler;
import ey.manila.qa.automation.element.ElementHandler;

public class AccountMenu extends MenuHandler{
	public AccountMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu) {
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("CI_CUSTOMERINFORMATION_subMenuItem1x0"), frame.main.toFrameMap()));
	}
	
}
