/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Auto Payment Arrangement Objects
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
package aut.autopayarrangement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class AutoPaymentArrangementObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
	protected MenuObjects menuObj;
	
	public final ElementHandler acctId;
	public final ElementHandler installments;
	public final ElementHandler createPayArrBtn;
	
	public AutoPaymentArrangementObjects(WebDriver aut, EntityFrameObjects frame) {
			driver = aut;
			this.frame = frame;
			menuObj = new MenuObjects(aut, frame);
			
			acctId = new ElementHandler(driver, By.id("createPaymentArr_input_accountId"), this.frame.zoneMapFrame1.toFrameMap());
			installments = new ElementHandler(driver, By.id("createPaymentArr_input_installments"), this.frame.zoneMapFrame1.toFrameMap());
			createPayArrBtn = new ElementHandler(driver, By.id("createPaymentArrangement"), this.frame.zoneMapFrame1.toFrameMap());
	}
}
