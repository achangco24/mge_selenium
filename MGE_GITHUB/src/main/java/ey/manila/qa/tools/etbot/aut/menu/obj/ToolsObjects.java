/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Tool Objects
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
package ey.manila.qa.tools.etbot.aut.menu.obj;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class ToolsObjects extends WebElementRepository  {
	public final ElementHandler menu;
	public final ElementHandler switchUser;
	public final ElementHandler userProfile;
	
	public ToolsObjects(WebDriver driver) {
		List<By> frameMap = new ArrayList<By>();
		frameMap.add(By.id("frmMain"));
		
		this.menu = new ElementHandler(driver, By.xpath("//*[@id=\"ctl00_siteMenu_rptSiteMenu_ctl04_liTag\"]/a"), frameMap);
		this.switchUser = new ElementHandler(driver, By.id("ctl00_siteMenu_rptSiteMenu_ctl04_SiteMenuChild3_rptSiteMenu_ctl05_liTag"), frameMap);
		this.userProfile = new ElementHandler(driver, By.id("ctl00_siteMenu_rptSiteMenu_ctl04_SiteMenuChild3_rptSiteMenu_ctl06_liTag"), frameMap);
	}
}
