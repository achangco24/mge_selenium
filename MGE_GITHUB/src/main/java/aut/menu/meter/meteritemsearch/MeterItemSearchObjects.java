/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Meter/Item Search Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-07-08	RExtra	CP_BI.002	Add components to CancelRebilling a Bill Segment       
 * 
 *************************************************************************************
 */
package aut.menu.meter.meteritemsearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class MeterItemSearchObjects extends WebElementRepository{
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	public final ElementHandler meterItemTbl;
	public final ElementHandler meterReadMenu;
	public final ElementHandler search;
	protected MenuObjects menuObj;
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	public MeterItemSearchObjects(WebDriver aut, EntityFrameObjects frame) {
		
		/*
		 * CP_BI.002 - 2020-07-08 - Start Add
		 */
		meterItemTbl = new ElementHandler(aut, By.xpath("//*[@id='dataTable']"), frame.data.toFrameMap());
		meterReadMenu = new ElementHandler(aut, By.id("CI_CONTEXTMETER_subMenuItem1x2"), frame.main.toFrameMap());
		menuObj = new MenuObjects(aut, frame);
		
		search = menuObj.search;
		/*
		 * CP_BI.002 - 2020-07-08 - End Add
		 */
	}

}
