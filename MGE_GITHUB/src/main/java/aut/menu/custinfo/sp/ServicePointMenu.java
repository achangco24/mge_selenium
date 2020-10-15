/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Service Point Menu
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * YYYY-MM-DD	IN			Reason text.                
 * 2020-10-6	JMalayo 	Change the Id from 1x25 to 1x23
 *************************************************************************************
 */
package aut.menu.custinfo.sp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuHandler;
import ey.manila.qa.automation.element.ElementHandler;

public class ServicePointMenu extends MenuHandler {
	public ServicePointMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu) {
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("CI_CUSTOMERINFORMATION_subMenuItem1x23"), frame.main.toFrameMap()));
	}
}
