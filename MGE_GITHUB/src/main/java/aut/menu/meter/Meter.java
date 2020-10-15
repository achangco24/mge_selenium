/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Meter
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
package aut.menu.meter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.IMenu;
import aut.menu.MenuHandler;
import aut.menu.meter.config.MeterConfigMenu;
import aut.menu.meter.install.MeterInstallMenu;
import aut.menu.meter.meter.MeterMenu;
import ey.manila.qa.automation.element.ElementHandler;

public class Meter extends MenuHandler {
	public Meter(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		initialize(aut, frame, wait);
		menuMap.add(new ElementHandler(aut, By.id("IM_menuButton"), frame.main.toFrameMap()));
		menuMap.add(new ElementHandler(aut, By.id("CI_MAINMENU_topMenuItem0x7"), frame.main.toFrameMap()));
		
		meter = new MeterMenu(aut, frame, wait, menuMap);
		meterConfig = new MeterConfigMenu(aut, frame, wait, menuMap);
		meterInstall = new MeterInstallMenu(aut, frame, wait, menuMap);
	}
	
	public final IMenu meter;
	public final IMenu meterConfig;
	public final IMenu meterInstall;
}
