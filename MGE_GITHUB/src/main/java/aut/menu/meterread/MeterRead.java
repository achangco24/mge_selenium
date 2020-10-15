/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Meter Read
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
package aut.menu.meterread;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.IMenu;
import aut.menu.MenuHandler;
import aut.menu.meterread.read.MeterReadMenu;
import ey.manila.qa.automation.element.ElementHandler;

public class MeterRead extends MenuHandler {
	public MeterRead(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		initialize(aut, frame, wait);
		menuMap.add(new ElementHandler(aut, By.id("IM_menuButton"), frame.main.toFrameMap()));
		menuMap.add(new ElementHandler(aut, By.id("CI_MAINMENU_topMenuItem0x8"), frame.main.toFrameMap()));
		
		meterRead = new MeterReadMenu(aut, frame, wait, menuMap);
	}
	
	public final IMenu meterRead;
}
