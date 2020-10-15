/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Payment Arrangement Request Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-07-13	RExtra	CP_CI.030	Add components for Adding a Payment Arrangement
 * 									Request
 * 
 *************************************************************************************
 */
package aut.menu.financial.payment.paymentarrangementrequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class PaymentArrangementRequestObjects extends WebElementRepository{
	
	/*
	 * CP_CI.030 - 2020-07-13 - Start Add
	 */
	public final ElementHandler eligible;
	public final ElementHandler nextBtn;
	public final ElementHandler numOfInstallments;
	public final ElementHandler finishBtn;
	/*
	 * CP_CI.030 - 2020-07-13 - End Add
	 */
	/*
	 *  - 2020-10-06 - Start Add - AChangco
	 */
	public final ElementHandler cancelBtn;
	public final ElementHandler paReason;
	
	/*
	 *  2020-10-06 - End Add - AChangco
	 */
	public PaymentArrangementRequestObjects(WebDriver aut, EntityFrameObjects frame) {
		/*
		 * CP_CI.030 - 2020-07-13 - Start Add
		 */
		eligible = new ElementHandler(aut, By.id("eligiblePAMessage"), frame.zoneMapFrame1.toFrameMap());
		nextBtn = new ElementHandler(aut, By.id("NextStep"), frame.zoneMapFrame1.toFrameMap());
		numOfInstallments = new ElementHandler(aut, By.id("numberOfInstallments"), frame.zoneMapFrame1.toFrameMap());
		finishBtn = new ElementHandler(aut, By.id("Finish"), frame.zoneMapFrame1.toFrameMap());
		/*
		 * CP_CI.030 - 2020-07-13 - End Add
		 */
		/*
		 *  - 2020-10-06 - Start Add - AChangco
		 */
		cancelBtn = new ElementHandler(aut, By.id("ui-id-2"), frame.zoneMapFrame1.toFrameMap());
		paReason = new ElementHandler(aut, By.id("paReason"), frame.zoneMapFrame1.toFrameMap());
		/*
		 *  2020-10-06 - End Add - AChangco
		 */
	}

}
