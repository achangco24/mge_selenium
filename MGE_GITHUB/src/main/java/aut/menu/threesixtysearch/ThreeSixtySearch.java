/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * 360 Search
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * YYYY-MM-DD	IN			Reason text.                
 * 2020-10-6	JMalayo 	Initial Version
 *************************************************************************************
 */

package aut.menu.threesixtysearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.IMenu;
import aut.menu.MenuHandler;
import aut.menu.threesixtysearch.searchbyname.SearchByNameMenu;
import aut.menu.threesixtysearch.searchbydevice.SearchByDeviceMenu;
import aut.menu.threesixtysearch.searchbyaddress.SearchByAddressMenu;
import ey.manila.qa.automation.element.ElementHandler;

public class ThreeSixtySearch extends MenuHandler{

	public final IMenu searchByName;
	public final IMenu searchByDevice;
	public final IMenu searchByAddress;
	
	public ThreeSixtySearch(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		initialize(aut, frame, wait);
		menuMap.add(new ElementHandler(aut, By.id("IM_menuButton"), frame.main.toFrameMap()));
		menuMap.add(new ElementHandler(aut, By.id("CI_MAINMENU_topMenuItem0x0"), frame.main.toFrameMap()));
		
		searchByName = new SearchByNameMenu(aut, frame, wait, menuMap);
		searchByDevice = new SearchByDeviceMenu(aut, frame, wait, menuMap);
		searchByAddress = new SearchByAddressMenu(aut, frame, wait, menuMap);
	}

}




