/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Account Management Page - Menu Handler
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * YYYY-MM-DD	IN			Reason text.   
 * 2020-10-05	JMalayo 	Initial Version             
 * 2020-10-05	JMalayo		Created a package to handle the navigation from Menu to
 * 							Customer Information to Account Management
 *************************************************************************************
 */

package aut.menu.custinfo.accountmanagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuHandler;
import ey.manila.qa.automation.element.ElementHandler;


public class AccountManagementMenu extends MenuHandler {

	public AccountManagementMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu) {
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("CI_CUSTOMERINFORMATION_subMenuItem0x1"), frame.main.toFrameMap()));
	}
	
}
