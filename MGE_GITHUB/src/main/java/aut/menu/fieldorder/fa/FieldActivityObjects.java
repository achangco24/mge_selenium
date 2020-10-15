/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Field Activity Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-20	GSando	FS.001. 	Add components for adding a Field Activity.      
 * 2020-04-21	GSando	FS.003. 	Add components for canceling a Field Activity.
 * 2020-06-04	RExtra	CP_FS.001.  Add components for Create a New FA Manually
 * 2020-06-19	RExtra	CP_FS.002.	Add components for Update Existing FA Scheduled
 * 									Date
 * 2020-06-22	RExtra	CP_FS.009.	Add components to Create and Complete FA
 * 
 *************************************************************************************
 */
package aut.menu.fieldorder.fa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class FieldActivityObjects extends WebElementRepository {
	public final ElementHandler faid;
	public final ElementHandler spid;
	public final ElementHandler faType;
	public final ElementHandler schedDate;
	public final ElementHandler schedTime;
	public final ElementHandler dispatchGrp;
	public final ElementHandler faPriority; 
	public final ElementHandler comments;
	public final ElementHandler faInfoTable; 
	public final ElementHandler completeBtn;
	public final ElementHandler instructions; 
	
	//public final ElementHandler tabPageTable;
	public final ElementHandler secFaAction;
	
	//Elements under Field Activity Search Pop-up
	public final ElementHandler overridelink;
	public final ElementHandler moreInfo;
	
	//Cancel FA
	public final ElementHandler cancelBtn;
	public final ElementHandler cancelTable;
	public final ElementHandler cancelReason;
	public final ElementHandler cancelFA;
	
	/*
	 * CP_FS.001 - 2020-06-04 - Start Add
	 */
	public final ElementHandler dispatchGrpSearchBtn;
	public final ElementHandler popup_dispatchGrp_SearchBtn;
	public final ElementHandler popup_dispatchGrp;
	/*
	 * CP_FS.001 - 2020-06-04 - End Add
	 */
	
	//PopUp Window
	/*
	 * CP_FS.002 - 2020-06-19 - Start Add
	 */
	public final ElementHandler popUp_faID;
	public final ElementHandler popUp_faIDSearchBtn;
	public final ElementHandler popUp_spID;
	/*
	 * CP_FS.002 - 2020-06-19 - End Add
	 */
	
	//Steps Tab
	/*
	 * CP_FS.009 - 2020-06-22 - Start Add
	 */
	public final ElementHandler stepsTable;
	/*
	 * CP_FS.009 - 2020-06-22 - End Add
	 */
		
	public FieldActivityObjects(WebDriver aut, EntityFrameObjects frame) {
		faid = new ElementHandler(aut, By.id("FA_ID"), frame.tabPage.toFrameMap());
		spid = new ElementHandler(aut, By.id("SP_ID"), frame.tabPage.toFrameMap());
		faType = new ElementHandler(aut, By.id("FA_TYPE_CD"), frame.tabPage.toFrameMap());
		schedDate = new ElementHandler(aut, By.id("SCHED_DTTM_FWDTTM_P1"), frame.tabPage.toFrameMap());
		schedTime = new ElementHandler(aut, By.id("SCHED_DTTM_FWDTTM_P2"), frame.tabPage.toFrameMap());
		dispatchGrp = new ElementHandler(aut, By.id("DISP_GRP_CD"), frame.tabPage.toFrameMap());
		faPriority = new ElementHandler(aut, By.id("FA_PRIORITY_FLG"), frame.tabPage.toFrameMap());
		comments = new ElementHandler(aut, By.id("DESCRLONG"), frame.tabPage.toFrameMap());
		faInfoTable = new ElementHandler(aut, By.id("dataTable"), frame.searchDataFrame.toFrameMap());
		completeBtn = new ElementHandler(aut, By.xpath("//*[@id='ACTION_COMPLETE_SW']"), frame.tabPage.toFrameMap());
		//tabPageTable = new ElementHandler(aut, By.xpath("//*[@id='tabPageTable']/tbody/tr[3]/td/table/tbody/tr"), frame.tabPage.toFrameMap());
		secFaAction = new ElementHandler(aut, By.xpath("//*[@id='sec_faAction']/table/tbody/tr/td[2]/input"), frame.actionPanel.toFrameMap());
		
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		
		/*
		 * FS.001 - 2020-04-20 - Start Add
		 */
		instructions = new ElementHandler(aut, By.id("INSTRUCTIONS"), frame.tabPage.toFrameMap());
		dispatchGrpSearchBtn = new ElementHandler(aut, By.id("IM_DISP_GRP_CD"), frame.tabPage.toFrameMap());
		popup_dispatchGrp = new ElementHandler(aut, By.id("DISP_GRP_CD"));
		popup_dispatchGrp_SearchBtn = new ElementHandler(aut, By.id("BU_Main_dispSearch"));
		/*
		 * FS.001 - 2020-04-20 - End Add
		 */
		
		/*
		 * FS.003 - 2020-04-21 - Start Add
		 */
		//Cancel FA
		cancelBtn = new ElementHandler(aut, By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[3]/input"), frame.actionPanel.toFrameMap());
		cancelTable = new ElementHandler(aut, By.id("tabPageTable"));
		cancelReason = new ElementHandler(aut, By.id("FA_CAN_RSN_CD"));
		cancelFA = new ElementHandler(aut, By.id("ACTION_CANCEL_SW"));
		/*
		 * FS.003 - 2020-04-21 - End Add
		 */
		
		
		//PopUp Window
		/*
		 * CP_FS.002 - 2020-06-19 - Start Add
		 */
		popUp_faID = new ElementHandler(aut, By.id("FA_ID"));
		popUp_faIDSearchBtn = new ElementHandler(aut, By.id("BU_Main_faSearch1"));
		popUp_spID = new ElementHandler(aut, By.id("SP_ID"));
		/*
		 * CP_FS.002 - 2020-06-19 - End Add
		 */
		
		
		//Steps Tab
		/*
		 * CP_FS.009 - 2020-06-22 - Start Add
		 */
		stepsTable = new ElementHandler(aut, By.id("dataTable"), frame.data.toFrameMap());
		/*
		 * CP_FS.009 - 2020-06-22 - End Add
		 */
	}
	
	
}