/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Timesheets Objects
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

public class TimesheetsObjects extends WebElementRepository {
	public final ElementHandler menu;
	public final ElementHandler timesheetListing;
	public final ElementHandler currentWeekTimesheet;
	
	public TimesheetsObjects(WebDriver driver) {
		List<By> frameMap = new ArrayList<By>();
		frameMap.add(By.id("frmMain"));
		
		this.menu =  new ElementHandler(driver, By.xpath("//*[@id=\"ctl00_siteMenu_rptSiteMenu_ctl02_liTag\"]/a"), frameMap);
		this.timesheetListing =  new ElementHandler(driver, By.xpath("//*[@id=\"ctl00_siteMenu_rptSiteMenu_ctl02_SiteMenuChild1_rptSiteMenu_ctl01_liTag\"]/a"), frameMap);
		this.currentWeekTimesheet =  new ElementHandler(driver, By.id("ctl00_siteMenu_rptSiteMenu_ctl02_SiteMenuChild1_rptSiteMenu_ctl02_liTag"), frameMap);
	}
}
