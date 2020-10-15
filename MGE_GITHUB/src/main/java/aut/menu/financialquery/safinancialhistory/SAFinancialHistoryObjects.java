/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * SA Financial History Objects
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-06-01	RExtra	Initial version.            
 * 
 *************************************************************************************
 */
package aut.menu.financialquery.safinancialhistory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ey.manila.qa.automation.element.ElementHandler;
import aut.entity.EntityFrameObjects;

public class SAFinancialHistoryObjects {
	private EntityFrameObjects frame;
//	public final ElementHandler saFinHistTbl;
	public final ElementHandler adjusment;
	public final ElementHandler dataTable;
	
	public final ElementHandler overridelink;
	public final ElementHandler moreInfo;
	
	//Cancel FA
	public final ElementHandler cancelBtn;
	public final ElementHandler cancelTable;
	public final ElementHandler cancelReason;
	public final ElementHandler cancelAdj;
	
	//2020-10-01 Adrian Changco
		public final ElementHandler saFinancialTbl;
		
	public SAFinancialHistoryObjects(WebDriver aut, EntityFrameObjects frame) {
		this.frame = frame;
//		 saFinHistTbl = new ElementHandler (aut, By.id("title_heading_1"), frame.tabPage.toFrameMap());
		adjusment = new ElementHandler(aut,By.xpath("//*[@id='dataExplorerTableBody1']/tr/td[3]/a/span"), this.frame.tabPage.toFrameMap());
		
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		
		//Search Adjustment from Adjustment Nottebook
		dataTable = new ElementHandler(aut, By.id("dataTable"), frame.searchDataFrame.toFrameMap());
		
		//Cancel FA
		cancelBtn = new ElementHandler(aut, By.id("CANCEL_SW"), frame.tabPage.toFrameMap());
		cancelTable = new ElementHandler(aut, By.id("tabPageTable"));
		cancelReason = new ElementHandler(aut, By.id("CAN_RSN_CD"));
		cancelAdj = new ElementHandler(aut, By.id("CANCEL_SW"));
		
		//2020-10-01 -Adrian Changco
		
				saFinancialTbl = new ElementHandler(aut, By.id("dataExplorerTable1"));
	}

}
