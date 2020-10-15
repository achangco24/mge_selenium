/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Write Off Process Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-05-12	RExtra	CP_CC.007	Add components for Adding a Write Off Process
 * 2020-05-13	RExtra	CP_CC.015	Add components for Canceling a Write Off Process
 * 2020-05-143	RExtra	CP_CC.022	Add components for Modifying a Write Off Event
 * 									Trigger Date
 * 
 *************************************************************************************
 */
package aut.menu.creditcoll.writeoff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ey.manila.qa.automation.element.ElementHandler;
import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;

public class WriteOffObjects {
	private EntityFrameObjects frame;
	protected MenuObjects menuObj;
	
	public final ElementHandler add;
	public final ElementHandler search;
	
	/*
	 * CP_CC.007 - 2020-05-12 - Start Add
	 */
	public final ElementHandler writeOffCtrlTbl;
	
	public final ElementHandler img_writeOffCtrl;
	public final ElementHandler writeOffCtrlCd;
	public final ElementHandler writeOffTmpltCd;
	public final ElementHandler woProcInfo;
	public final ElementHandler comment;
	public final ElementHandler saID;
	public final ElementHandler sa_info;
	public final ElementHandler saWoStatFlg;
	/*
	 * CP_CC.007 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.015 - 2020-05-12 - Start Add
	 */
	public final ElementHandler reason;
	public final ElementHandler cancelBtn;
	 
	/*
	 * CP_CC.015 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.022 - 2020-05-14 - Start Add
	 */
	public final ElementHandler eventSequence;
	public final ElementHandler eventRecordCnt;
	public final ElementHandler eventRightArrow;
	public final ElementHandler eventTriggerDate;
	/*
	 * CP_CC.022 - 2020-05-14 - End Add
	 */
	
	public WriteOffObjects (WebDriver aut, EntityFrameObjects frame) {
		this.frame = frame;
		menuObj = new MenuObjects(aut, frame);
		add = menuObj.add; 
		search = menuObj.search;
		
		/*
		 * CP_CC.007 - 2020-05-12 - Start Add
		 */
		writeOffCtrlTbl = new ElementHandler(aut, By.id("dataTable"), frame.searchDataFrame.toFrameMap());
		
		img_writeOffCtrl = new ElementHandler(aut, By.id("IM_WO_CNTL_CD"), this.frame.tabPage.toFrameMap());
		writeOffCtrlCd =  new ElementHandler(aut, By.id("WO_CNTL_CD"), this.frame.tabPage.toFrameMap());
		writeOffTmpltCd =  new ElementHandler(aut, By.id("WO_PROC_TMPL_CD"), this.frame.tabPage.toFrameMap());
		
		woProcInfo = new ElementHandler(aut, By.id("WO_PROC_INFO"), this.frame.tabPage.toFrameMap());
		comment =  new ElementHandler(aut, By.id("COMMENTS"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_CC.007 - 2020-05-12 - End Add
		 */
		
		/*
		 * CP_CC.015 - 2020-05-12 - Start Add
		 */
		 reason =  new ElementHandler(aut, By.id("WO_STAT_RSN_FLG"), this.frame.tabPage.toFrameMap());
		 cancelBtn = new ElementHandler(aut, By.id("CANCEL_SW"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_CC.015 - 2020-05-12 - End Add
		 */
		
		//SA Tab
		saID =   new ElementHandler(aut, By.id("SA$SA_ID"), this.frame.tabPage.toFrameMap());
		sa_info =   new ElementHandler(aut, By.id("SA$SA_INFO"), this.frame.tabPage.toFrameMap());
		saWoStatFlg =   new ElementHandler(aut, By.id("SA$WO_SA_STAT_FLG"), this.frame.tabPage.toFrameMap());
		
		//Events Tab
		 /*
		  * CP_CC.022 - 2020-05-14 - Start Add
		  */
		 eventSequence = new ElementHandler(aut, By.id("EVT$EVT_SEQ"), this.frame.tabPage.toFrameMap());
		 eventRecordCnt = new ElementHandler(aut, By.id("EVT$recordCount"), this.frame.tabPage.toFrameMap());
		 eventRightArrow = new ElementHandler(aut, By.id("IM_EvtScroll_rigthArrow"), this.frame.tabPage.toFrameMap());
		 eventTriggerDate = new ElementHandler(aut, By.id("EVT$TRIGGER_DT"), this.frame.tabPage.toFrameMap());
		 /*
		  * CP_CC.022 - 2020-05-14 - End Add
		  */
	}
	
}
