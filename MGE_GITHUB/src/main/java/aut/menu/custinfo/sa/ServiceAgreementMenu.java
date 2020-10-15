/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Service Agreement Menu
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * YYYY-MM-DD	IN			Reason text.    
 * 2020-10-06	JMalayo		Change ID from 1x19 to 1x20          
 * 
 *************************************************************************************
 */
package aut.menu.custinfo.sa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuHandler;
import ey.manila.qa.automation.element.ElementHandler;

public class ServiceAgreementMenu extends MenuHandler {
	public ServiceAgreementMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu) {
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("CI_CUSTOMERINFORMATION_subMenuItem1x20"), frame.main.toFrameMap()));
	}
}
