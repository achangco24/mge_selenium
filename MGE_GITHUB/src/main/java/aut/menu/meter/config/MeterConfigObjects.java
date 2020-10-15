/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Meter Configuration Objects
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
package aut.menu.meter.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class MeterConfigObjects extends WebElementRepository {
	public MeterConfigObjects(WebDriver aut, EntityFrameObjects frame) {
		effectiveDate = new ElementHandler(aut, By.id("EFF_DTTM_FWDTTM_P1"), frame.tabPage.toFrameMap());
		effectiveTime = new ElementHandler(aut, By.id("EFF_DTTM_FWDTTM_P2"), frame.tabPage.toFrameMap());
		meterConfigDescription = new ElementHandler(aut, By.id("DESCR"), frame.tabPage.toFrameMap());
		meterConfigType = new ElementHandler(aut, By.id("MTR_CONFIG_TY_CD"), frame.tabPage.toFrameMap());
		meterId = new ElementHandler(aut, By.id("MTR_ID"), frame.tabPage.toFrameMap());
		meterInfo = new ElementHandler(aut, By.id("MTR_INFO"), frame.tabPage.toFrameMap());
//		expandAll = new ElementHandler(aut, By.id("expandAllLink"), frame.tabPage.toFrameMap());
	}
	
	public final ElementHandler effectiveDate;
	public final ElementHandler effectiveTime;
	public final ElementHandler meterConfigDescription;
	public final ElementHandler meterConfigType;
	public final ElementHandler meterId;
	public final ElementHandler meterInfo;
//	public final ElementHandler expandAll;
}
