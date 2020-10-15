/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Payment Tender Search Objects
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-22	GSando	Initial version.            
 * 
 *************************************************************************************
 */
package aut.menu.financialquery.paymenttendersearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;

public class PaymentTenderSearchObjects {
	private EntityFrameObjects frame;
	
	public final ElementHandler	searchFor;
	public final ElementHandler	paymentAccount;
	public final ElementHandler accountId;
	public final ElementHandler searchBtn;
	public final ElementHandler paymentResult;
	
	public PaymentTenderSearchObjects(WebDriver aut, EntityFrameObjects frame) {
		this.frame = frame;
		
		searchFor = new ElementHandler(aut, By.id("PAY_SEARCH_FLG"), this.frame.tabPage.toFrameMap());
		paymentAccount = new ElementHandler(aut, By.id("PAY_ACCT_FLTR_FLG"), this.frame.tabPage.toFrameMap());
		accountId = new ElementHandler(aut, By.id("ACCT_ID"), this.frame.tabPage.toFrameMap());
		searchBtn = new ElementHandler(aut, By.id("BU_SRCH"), this.frame.tabPage.toFrameMap());
		
		paymentResult = new ElementHandler(aut, By.id("PAY_SRCH#RSCNT_INFO"), frame.tabPage.toFrameMap());
	}
}
