/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Break Payment Arrangement Objects
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
package aut.breakpayarrangement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class BreakPaymentArrangementObjects extends WebElementRepository{
	private WebDriver driver;
	private EntityFrameObjects frame;
	protected MenuObjects menuObj;
	
	public final ElementHandler breakPayArrBtn;
	
	public BreakPaymentArrangementObjects(WebDriver aut, EntityFrameObjects frame) {
			this.driver = aut;
			this.frame = frame;
			menuObj = new MenuObjects(aut, frame);
			
			breakPayArrBtn = new ElementHandler(driver, By.id("breakPaymentArrBtn"), this.frame.zoneMapFrame1.toFrameMap());
	}
}
