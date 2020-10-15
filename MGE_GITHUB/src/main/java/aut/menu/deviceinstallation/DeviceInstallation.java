/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Device Installation
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * 2020-10-02	JMalayo		MU.4.1.12 Sync Master Data from CIS             
 * 
 *************************************************************************************
 */

package aut.menu.deviceinstallation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.IMenu;
import aut.menu.MenuHandler;
import aut.menu.deviceinstallation.installevent.InstallEventMenu;
import ey.manila.qa.automation.element.ElementHandler;


public class DeviceInstallation extends MenuHandler{
	public final IMenu installationEvent;

	
	public DeviceInstallation(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		initialize(aut, frame, wait);
		menuMap.add(new ElementHandler(aut, By.id("IM_menuButton"), frame.main.toFrameMap()));
		menuMap.add(new ElementHandler(aut, By.id("CI_MAINMENU_topMenuItem0x11"), frame.main.toFrameMap()));
		
		installationEvent = new InstallEventMenu(aut, frame, wait, menuMap);
	}
}
