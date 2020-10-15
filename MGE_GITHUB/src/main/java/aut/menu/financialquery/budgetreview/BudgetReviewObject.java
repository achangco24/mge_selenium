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
 * 2020-10-06	AChangco	Initial version.            
 * 
 *************************************************************************************
 */
package aut.menu.financialquery.budgetreview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;

public class BudgetReviewObject {
	private EntityFrameObjects frame;
	

	public final ElementHandler budgerReviewTbl;
	
	public BudgetReviewObject(WebDriver aut, EntityFrameObjects frame) {
		this.frame = frame;
		
		budgerReviewTbl = new ElementHandler(aut, By.id("dataDivision"), this.frame.tabPage.toFrameMap());
	
	}
}
