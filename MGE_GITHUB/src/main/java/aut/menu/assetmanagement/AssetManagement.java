/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Asset Management Menu Handler
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * YYYY-MM-DD	IN			Reason text.
 * 2020-10-02	JMalayo 	Initial Version                
 * 2020-10-02	JMalayo		Create a package and class to handles the navigation from 
 * 							Menu to Asset Management.
 *************************************************************************************
 */

package aut.menu.assetmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.IMenu;
import aut.menu.MenuHandler;
import aut.menu.assetmanagement.asset.AssetMenu;

import ey.manila.qa.automation.element.ElementHandler;

public class AssetManagement extends MenuHandler {
	public final IMenu asset;

	public AssetManagement(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {

		initialize(aut, frame, wait);
		menuMap.add(new ElementHandler(aut, By.id("IM_menuButton"), frame.main.toFrameMap()));
		menuMap.add(new ElementHandler(aut, By.id("CI_MAINMENU_topMenuItem0x1"), frame.main.toFrameMap()));

		asset = new AssetMenu(aut, frame, wait, menuMap);
	}

}
