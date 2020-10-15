/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Meter Objects
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
package aut.menu.meter.meter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class MeterObjects extends WebElementRepository {
	public final ElementHandler badgeNumber;
	public final ElementHandler meterType;
	public final ElementHandler manufacturer;
	public final ElementHandler model;
	public final ElementHandler modelDescription;
	public final ElementHandler serialNumber;
	
	public MeterObjects(WebDriver aut, EntityFrameObjects frame) {
		badgeNumber = new ElementHandler(aut, By.id("BADGE_NBR"), frame.tabPage.toFrameMap());
		meterType = new ElementHandler(aut, By.id("MTR_TYPE_CD"), frame.tabPage.toFrameMap());
		manufacturer = new ElementHandler(aut, By.id("MFG_CD"), frame.tabPage.toFrameMap());
		model = new ElementHandler(aut, By.id("MODEL_CD"), frame.tabPage.toFrameMap());
		modelDescription = new ElementHandler(aut, By.id("MODEL_CD_DESCR"), frame.tabPage.toFrameMap());
		serialNumber = new ElementHandler(aut, By.id("SERIAL_NBR"), frame.tabPage.toFrameMap());
	}
}
