/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Financial Query
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
package aut.menu.financialquery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ey.manila.qa.automation.element.ElementHandler;
import aut.entity.EntityFrameObjects;
import aut.menu.IMenu;
import aut.menu.MenuHandler;
import aut.menu.financialquery.paymenttendersearch.PaymentTenderSearchMenu;

public class FinancialQuery extends MenuHandler{
	public final IMenu paymentTenderSearch;
	
	public FinancialQuery(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		initialize(aut, frame, wait);
		menuMap.add(new ElementHandler(aut, By.id("IM_menuButton"), frame.main.toFrameMap()));
		menuMap.add(new ElementHandler(aut, By.id("CI_MAINMENU_topMenuItem0x5"), frame.main.toFrameMap()));
		
		paymentTenderSearch = new PaymentTenderSearchMenu(aut, frame, wait, menuMap);
	}
}
