/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Payment Tender Search Menu
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

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ey.manila.qa.automation.element.ElementHandler;
import aut.entity.EntityFrameObjects;
import aut.menu.MenuHandler;

public class BudgetReviewMenu extends MenuHandler {
	
	public BudgetReviewMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu){
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("CI_FINANCIALQUERY_subMenuItem0x9"), frame.main.toFrameMap()));
	}
}

