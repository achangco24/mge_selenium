/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Premise Management Menu
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * YYYY-MM-DD	IN			Reason text. 
 * 2020-10-06	JMalayo		Initial Version             
 * 
 *************************************************************************************
 */

package aut.menu.custinfo.premisemanagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import aut.menu.MenuHandler;

public class PremiseManagementMenu extends MenuHandler{
	public PremiseManagementMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu) {
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("CI_CUSTOMERINFORMATION_subMenuItem0x16"), frame.main.toFrameMap()));
	}
}
