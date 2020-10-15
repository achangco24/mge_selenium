/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Tender Control Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-06-16	RExtra	CP_FIN.03	Add components for Adding a Deposit and Tender
 * 									Control                
 * 
 *************************************************************************************
 */
package aut.menu.financial.tender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class TenderControlObjects extends WebElementRepository{
	
	private WebDriver driver;
	private EntityFrameObjects frame;
	
	public final ElementHandler tndrSrc;
	public final ElementHandler creDttm;
	
	
	public TenderControlObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		
		tndrSrc = new ElementHandler(driver, By.id("TNDR_SOURCE_CD"), frame.tabPage.toFrameMap());
		creDttm = new ElementHandler(driver, By.id("CRE_DTTM"), frame.tabPage.toFrameMap());
	}

}
