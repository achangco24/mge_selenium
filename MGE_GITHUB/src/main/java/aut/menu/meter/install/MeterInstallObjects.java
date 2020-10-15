/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Meter Install Objects
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
package aut.menu.meter.install;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class MeterInstallObjects extends WebElementRepository {
	public MeterInstallObjects(WebDriver aut, EntityFrameObjects frame) {
		installReadDateTime = new ElementHandler(aut, By.id("INSTALL_READ_DTTM"), frame.tabPage.toFrameMap());
		meterConfigId = new ElementHandler(aut, By.id("MTR_CONFIG_ID"), frame.tabPage.toFrameMap());
		meterConfigInfo = new ElementHandler(aut, By.id("MTR_CONFIG_INFO"), frame.tabPage.toFrameMap());
		meterReadId = new ElementHandler(aut, By.id("MR_ID"), frame.tabPage.toFrameMap());
		spId = new ElementHandler(aut, By.id("SP_ID"), frame.tabPage.toFrameMap());
		spInfo = new ElementHandler(aut, By.id("SP_INFO"), frame.tabPage.toFrameMap());
	}
	
	public final ElementHandler installReadDateTime;
	public final ElementHandler meterConfigId;
	public final ElementHandler meterConfigInfo;
	public final ElementHandler meterReadId;
	public final ElementHandler spId;
	public final ElementHandler spInfo;
}
