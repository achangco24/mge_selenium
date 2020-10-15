/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * AdminB
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 Date:       	by:    	Reason: 
 * 2020-09-30	AChangco	Initial version.   
 * 
 *************************************************************************************
 */
package aut.admin.a;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.admin.AdminHandler;
import aut.admin.IAdmin;
import aut.admin.a.algorithm.AlgorithmMenu;
import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;

public class AdminA extends AdminHandler {
	public AdminA(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		initialize(aut, frame, wait);
		adminMap.add(new ElementHandler(aut, By.id("IM_adminButton"), frame.main.toFrameMap()));
		adminMap.add(new ElementHandler(aut, By.id("CI_ADMINMENU_topMenuItem0x0"), frame.main.toFrameMap()));
		
		algorithm = new AlgorithmMenu(aut, frame, wait, adminMap);
	}
	
	public final IAdmin algorithm;
}
