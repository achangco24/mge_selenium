/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Landlord Agreement Menu
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:			Reason: 
 * 2020-9-29	JMalayo		Initial Version
 *************************************************************************************
 */

package aut.menu.custinfo.landlordagreement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import aut.menu.MenuHandler;

public class LandLordMenu extends MenuHandler{
	public LandLordMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu) {
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("CI_CUSTOMERINFORMATION_subMenuItem1x11"), frame.main.toFrameMap()));
	}
}
