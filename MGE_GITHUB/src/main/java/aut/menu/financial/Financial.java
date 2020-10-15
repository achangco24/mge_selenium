/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Financial
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-24	GSando	PY.010. Add components for canceling a Payment.          
 * 
 *************************************************************************************
 */
package aut.menu.financial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.IMenu;
import aut.menu.MenuHandler;
import aut.menu.financial.adjustment.AdjustmentMenu;
import aut.menu.financial.bill.BillMenu;
import aut.menu.financial.deposit.DepositControlMenu;
import aut.menu.financial.ft.FinancialTransactionMenu;
import aut.menu.financial.paymentevent.PaymentEventMenu;
import ey.manila.qa.automation.element.ElementHandler;

public class Financial extends MenuHandler{
	public final IMenu financialTransaction;
	public final IMenu adjustment;
	public final IMenu bill;
	public final IMenu depositControl;
	public final IMenu paymentEvent;
	public final IMenu payment;
	
	public Financial(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		initialize(aut, frame, wait);
		menuMap.add(new ElementHandler(aut, By.id("IM_menuButton"), frame.main.toFrameMap()));
		menuMap.add(new ElementHandler(aut, By.id("CI_MAINMENU_topMenuItem0x4"), frame.main.toFrameMap()));
		
		financialTransaction = new FinancialTransactionMenu(aut, frame, wait, menuMap);
		adjustment = new AdjustmentMenu(aut, frame, wait, menuMap);
		bill = new BillMenu(aut, frame, wait, menuMap);
		depositControl = new DepositControlMenu(aut, frame, wait, menuMap);
		paymentEvent = new PaymentEventMenu(aut, frame, wait, menuMap);
		/*
		 * PY.010 - 2020-04-24 - Start Add
		 */
		payment = new PaymentEventMenu(aut, frame, wait, menuMap);
		/*
		 * PY.010 - 2020-04-24 - End Add
		 */
	}
}
