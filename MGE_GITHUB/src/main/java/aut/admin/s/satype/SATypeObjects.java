/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * SA Type Objects
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN		Reason text.                
 * 2020-09-28			Add SATypeObject class to handle elements on SA Type Page.
 *************************************************************************************
 */

package aut.admin.s.satype;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class SATypeObjects extends WebElementRepository{
	private WebDriver driver;
	public final ElementHandler serviceType;
	//9-30-2020 // -Adrian Changco
	public final ElementHandler latrPayCharge;
	
	public SATypeObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		serviceType = new ElementHandler(aut, By.id("SVC_TYPE_CD"), frame.tabPage.toFrameMap());
		
		
		//9-30-2020 // -Adrian Changco
		latrPayCharge = new ElementHandler(driver, By.id("LATE_PAY_CHARGE_SW"), frame.tabPage.toFrameMap());
	}
}
