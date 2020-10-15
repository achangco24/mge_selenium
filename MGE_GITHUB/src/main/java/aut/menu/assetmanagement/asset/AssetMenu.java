/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Asset Menu Page Handler
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * YYYY-MM-DD	IN			Reason text.  
 * 2020-10-05	JMalayo		Initial Version              
 * 2020-10-05	JMalayo		Create a package and class to handles the navigation from 
 * 							Menu to Asset Management to Asset Page.
 *************************************************************************************
 */

package aut.menu.assetmanagement.asset;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuHandler;
import ey.manila.qa.automation.element.ElementHandler;


public class AssetMenu extends MenuHandler{
	public AssetMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu) {
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("W1_ASSET_subMenuItem1x0"), frame.main.toFrameMap()));
	}
	
}
