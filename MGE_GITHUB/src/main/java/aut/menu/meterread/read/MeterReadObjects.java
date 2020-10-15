/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Meter Read Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN					Reason text.
 * 2020-07-08	RExtra	CP_BI.002	Add components to CancelRebilling a Bill Segment
 * 
 *************************************************************************************
 */
package aut.menu.meterread.read;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class MeterReadObjects extends WebElementRepository {
	public final ElementHandler meterConfigId;
	public final ElementHandler meterConfigInfo;
	public final ElementHandler readDate;
	public final ElementHandler readTime;
	public final ElementHandler useOnBill;
	public final ElementHandler meterConfigMenu;
	public final ElementHandler meterReadOption;
	public final ElementHandler addMeterConfig;
	public final ElementHandler readType;
	public final ElementHandler officeEst;
	public final ElementHandler regReading;
	public final ElementHandler lastBilled;
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	public final ElementHandler overridelink;
	public final ElementHandler popMeterReadID;
	public final ElementHandler popMeterReadIDSearchBtn;
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	public MeterReadObjects(WebDriver aut, EntityFrameObjects frame) {
		
		meterConfigId = new ElementHandler(aut, By.id("MTR_CONFIG_ID"), frame.tabPage.toFrameMap());
		meterConfigInfo = new ElementHandler(aut, By.id("MTR_CONFIG_INFO"), frame.tabPage.toFrameMap());
		meterConfigMenu = new ElementHandler(aut, By.id("IM_Data_mcIdBtn"), frame.tabPage.toFrameMap());
		readDate = new ElementHandler(aut, By.id("READ_DTTM_FWDTTM_P1"), frame.tabPage.toFrameMap());
		readTime = new ElementHandler(aut, By.id("READ_DTTM_FWDTTM_P2"), frame.tabPage.toFrameMap());
		useOnBill = new ElementHandler (aut, By.id("USE_ON_BILL_SW"), frame.tabPage.toFrameMap());
		meterReadOption = new ElementHandler (aut, By.id("CI_CONTEXTMETERCONFIGURATION_subMenuItem1x1"), frame.main.toFrameMap());
		addMeterConfig = new ElementHandler (aut, By.xpath("//*[@id='CI0000000179']/span[1]"), frame.main.toFrameMap());
		readType = new ElementHandler (aut, By.id("REG_READ:0$READ_TYPE_FLG"), frame.data.toFrameMap());
		officeEst = new ElementHandler (aut, By.xpath("//*[@id='REG_READ:0$READ_TYPE_FLG']/option[5]"), frame.data.toFrameMap());
		regReading = new ElementHandler (aut, By.id("REG_READ:0$REG_READING"), frame.data.toFrameMap());
		lastBilled = new ElementHandler (aut, By.xpath("//*[@id='dataTable']/tbody/tr[3]/td/a"), frame.dashboard.toFrameMap());
		
		/*
		 * CP_BI.002 - 2020-07-08 - Start Add
		 */
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		popMeterReadID = new ElementHandler(aut, By.id("MR_ID"));
		popMeterReadIDSearchBtn = new ElementHandler(aut, By.id("BU_Main_search"));
		
		/*
		 * CP_BI.002 - 2020-07-08 - End Add
		 */
				
	}
}
