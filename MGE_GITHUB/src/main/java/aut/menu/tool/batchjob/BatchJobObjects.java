/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Batch Job Objects
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
package aut.menu.tool.batchjob;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class BatchJobObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
	
	public final ElementHandler batchCode;
	public final ElementHandler batchID;
	public final ElementHandler frameParam;
	public final ElementHandler buttonDQ;
	public final ElementHandler buttonRefresh;
	public final ElementHandler status;
	public final ElementHandler batchResult;
	public final ElementHandler batchDate;
	public final ElementHandler batchStatus;
	
	public BatchJobObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("BJP"));
		frameParam = new ElementHandler(driver, By.id("BJP"), map);
		
		
		batchCode = new ElementHandler(aut, By.id("BATCH_CD"), frame.tabPage.toFrameMap());
		batchID = new ElementHandler(aut, By.id("BATCH_JOB_ID"), frame.tabPage.toFrameMap());
		buttonDQ = new ElementHandler(aut, By.id("ACTION_Q_SW"), frame.tabPage.toFrameMap());
		status = new ElementHandler(aut, By.id("BATCH_JOB_STAT_FLG"), frame.tabPage.toFrameMap());
		batchDate = new ElementHandler(aut, By.id("PROCESS_DT"), frame.tabPage.toFrameMap());
		buttonRefresh = new ElementHandler(aut, By.id("IM_REFRESH"), frame.main.toFrameMap());
		batchResult = new ElementHandler(aut, By.xpath("//*[@id=\"dataExplorerTableBody101\"]/tr/td[3]/span"), this.frame.dashboard.toFrameMap());
		batchStatus = new ElementHandler(aut, By.id("BATCH_JOB_STAT_FLG"), frame.tabPage.toFrameMap());
		
	}
	
	public ElementHandler getParamAtIndex(int index) {
		String id = "BJP:" + String.valueOf(index) + "$BATCH_PARM_VAL";
		return new ElementHandler(driver, By.id(id), frameParam.toFrameMap());
	}
}
