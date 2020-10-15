/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Financial Transaction Objects
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
package aut.menu.financial.ft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class FinancialTransactionObjects extends WebElementRepository {
	private EntityFrameObjects frame;
	
	public final ElementHandler ftid;		//FT Id field from search pop-up window
	public final ElementHandler searchBtn;	//Search button from search pop-up window
	public final ElementHandler overridelink; 	//security link check from search pop-up window
	public final ElementHandler dashboardPremise;
	public final ElementHandler	moreInfo;

	public FinancialTransactionObjects(WebDriver aut, EntityFrameObjects frame) {
		this.frame = frame;
		dashboardPremise = new ElementHandler(aut, By.xpath("//*[@id=\"data_202\"]/table/tbody/tr[3]/td/img"), this.frame.dashboard.toFrameMap());
		
		//Elements under search pop-up window
		ftid = new ElementHandler(aut, By.id("FT_ID"));
		searchBtn = new ElementHandler(aut, By.id("BU_Main_ftMainSrch"));
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		//moreInfo = new ElementHandler(driver, By.id("moreInfoContainer"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
	}	
}
