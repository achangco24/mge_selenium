/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Batch Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-09-30	AChangco	Initial version.                  
 * 
 *************************************************************************************
 */
package aut.admin.p.paymentmethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;


public class PaymentMethodObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
		
//	public final ElementHandler tndrSrc;
//	public final ElementHandler creDttm;
	
	public final ElementHandler paymentMethodTbl;

	public PaymentMethodObjects(WebDriver aut, EntityFrameObjects frame) {
		
		driver = aut;
		this.frame = frame;
		
		
		//Table
		paymentMethodTbl = new ElementHandler(driver, By.id("dataDivision"), frame.tabPage.toFrameMap());
	
	}
	
	
	
	
}
