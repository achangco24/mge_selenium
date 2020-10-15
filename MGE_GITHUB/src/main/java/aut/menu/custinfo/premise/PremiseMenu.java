/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Premise Menu
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN		Reason text. 
 * 2020-10-06	JMalayo		Change the ID of the Premise Menu from
 * 							CI_CUSTOMERINFORMATION_subMenuItem1x14 to 1x15.               
 * 
 *************************************************************************************
 */
package aut.menu.custinfo.premise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuHandler;
import ey.manila.qa.automation.element.ElementHandler;

public class PremiseMenu extends MenuHandler {
	public PremiseMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu) {
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("CI_CUSTOMERINFORMATION_subMenuItem1x15"), frame.main.toFrameMap()));
	}
}
