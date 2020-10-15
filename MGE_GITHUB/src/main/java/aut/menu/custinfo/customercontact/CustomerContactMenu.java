/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Customer Contact Menu
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-16	GSando	Initial version.              
 * 
 *************************************************************************************
 */
package aut.menu.custinfo.customercontact;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ey.manila.qa.automation.element.ElementHandler;
import aut.entity.EntityFrameObjects;
import aut.menu.MenuHandler;

public class CustomerContactMenu extends MenuHandler{
	public CustomerContactMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu){
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("CI_CUSTOMERINFORMATION_subMenuItem1x8"), frame.main.toFrameMap()));
	}
}
