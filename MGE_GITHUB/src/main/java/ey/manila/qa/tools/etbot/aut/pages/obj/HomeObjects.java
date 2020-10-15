/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Home Objects
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
package ey.manila.qa.tools.etbot.aut.pages.obj;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class HomeObjects extends WebElementRepository {
	public final ElementHandler menu;
	public final ElementHandler welcomeLabel;
	public final ElementHandler currentUser;
	
	public HomeObjects(WebDriver driver) {
		List<By> frameMap = new ArrayList<By>();
		frameMap.add(By.id("frmMain"));
		
		this.menu = new ElementHandler(driver, By.id("ctl00_siteMenu_rptSiteMenu_ctl01_liTag"), frameMap);
		this.currentUser = new ElementHandler(driver, By.id("ctl00_lblUserName"), frameMap);
		this.welcomeLabel = new ElementHandler(driver, By.id("ctl00_contentPH_lblWelcome"), frameMap);
	}
}
