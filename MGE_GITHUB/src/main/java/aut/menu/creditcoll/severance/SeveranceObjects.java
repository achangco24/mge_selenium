/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Severance Process Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-05-05	RExtra	CP_CC.005	Add components for Adding a Severance Process
 * 2020-05-12	RExtra	CP_CC.013	Add components for Canceling a Severance Process
 * 2020-05-14	RExtra	CP_CC.021	Add components for Modifying a Severance Event
 * 									Trigger Date             
 * 
 *************************************************************************************
 */
package aut.menu.creditcoll.severance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class SeveranceObjects extends WebElementRepository{
	public final ElementHandler overridelink;
	public final ElementHandler moreInfo;
	public final ElementHandler severanceProcID;
	public final ElementHandler searchBtn;
	public final ElementHandler tableRow;
	public final ElementHandler eventType;
	public final ElementHandler completedOption;
	public final ElementHandler triggerDate;
	public final ElementHandler fieldActivity;
	public final ElementHandler accountContext;
	public final ElementHandler conCentralBtn;
	public final ElementHandler saBtn;
	public final ElementHandler saSearch;
	public final ElementHandler sevTable;
	
	/*
	 * CP_CC.005 - 2020-05-05 - Start Add
	 */
	public final ElementHandler sevProcTemplate;
	public final ElementHandler createDate;
	public final ElementHandler sevAmtBaseDate;
	
	public final ElementHandler daysInArrears;
	public final ElementHandler comment;
	
	private EntityFrameObjects frame;
	public final ElementHandler saField;
	public final ElementHandler saInfo;
	/*
	 * CP_CC.005 - 2020-05-05 - End Add
	 */
	
	/*
	 * CP_CC.013 - 2020-05-12 - Start Add
	 */
	public final ElementHandler reason;
	public final ElementHandler cancelBtn;
	 
	/*
	 * CP_CC.013 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.021 - 2020-05-14 - Start Add
	 */
	public final ElementHandler eventSequence;
	public final ElementHandler eventRecordCnt;
	public final ElementHandler eventRightArrow;
	public final ElementHandler eventTriggerDate;
	/*
	 * CP_CC.021 - 2020-05-14 - End Add
	 */
	
	
	public SeveranceObjects(WebDriver aut, EntityFrameObjects frame) {
		
		//Severance Search Pop-up
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		severanceProcID = new ElementHandler(aut, By.id("SEV_PROC_ID"));
		searchBtn = new ElementHandler(aut, By.id("BU_Main_search"));
		sevTable = new ElementHandler(aut, By.id("dataTableBody"), frame.searchDataFrame.toFrameMap());
		
		//Severance Main Tab
		tableRow = new ElementHandler(aut, By.xpath("//*[@id=\'tStart\']/tbody/tr[2]/td[2]/div/table/tbody"), frame.graphCollTree.toFrameMap());
		
		/*
		 * CP_CC.005 - 2020-05-05 - Start Add
		 */
		this.frame = frame;
		saField = new ElementHandler(aut, By.id("SA_ID"), this.frame.tabPage.toFrameMap());
		saInfo = new ElementHandler(aut, By.id("SA_INFO"), this.frame.tabPage.toFrameMap());
		
		sevProcTemplate = new ElementHandler(aut, By.id("SEV_PROC_TMPL_CD"), this.frame.tabPage.toFrameMap());
		createDate = new ElementHandler(aut, By.id("CRE_DTTM_FWDTTM_P1"), this.frame.tabPage.toFrameMap());
		sevAmtBaseDate = new ElementHandler(aut, By.id("SEV_ARS_DT"), this.frame.tabPage.toFrameMap());
		
		daysInArrears = new ElementHandler(aut, By.id("NBR_OF_DAYS_FROM"), this.frame.tabPage.toFrameMap());
		
		comment = new ElementHandler(aut, By.id("COMMENTS"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_CC.005 - 2020-05-05 - End Add
		 */
		
		/*
		 * CP_CC.013 - 2020-05-12 - Start Add
		 */
		 reason =  new ElementHandler(aut, By.id("SEV_STAT_RSN_FLG"), this.frame.tabPage.toFrameMap());
		 cancelBtn = new ElementHandler(aut, By.id("CANCEL_SW"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_CC.013 - 2020-05-12 - End Add
		 */
		
		//Severance Events Tab
		eventType = new ElementHandler(aut, By.id("EVT$SEV_EVT_STAT_FLG"), frame.tabPage.toFrameMap());
		completedOption = new ElementHandler(aut, By.xpath("//*[@id='EVT$SEV_EVT_STAT_FLG']/option[4]"), frame.tabPage.toFrameMap());
		triggerDate = new ElementHandler(aut, By.id("EVT$TRIGGER_DT"), frame.tabPage.toFrameMap());
		
		fieldActivity = new ElementHandler(aut, By.xpath("//*[@id='data_201']/table/tbody/tr[3]/td/a"), frame.dashboard.toFrameMap());
		
		//Dashboard
		accountContext = new ElementHandler(aut, By.xpath("//*[@id='oraTableContextContainer']/tbody/tr[2]/td[3]/img"), frame.dashboard.toFrameMap());
		conCentralBtn = new ElementHandler(aut, By.xpath("//*[@id='CI_CONTEXTACCOUNT_subMenuItem0x20']/span[1]"), frame.main.toFrameMap());
		saBtn = new ElementHandler(aut, By.xpath("//*[@id='CI_CONTEXTACCOUNT_subMenuItem1x46']/span[1]"), frame.main.toFrameMap());
		saSearch = new ElementHandler(aut, By.xpath("//*[@id='menuDiv_1']/ul/li[1]/span[1]"), frame.main.toFrameMap());
		
		//Events Tab
		 /*
		  * CP_CC.020 - 2020-05-14 - Start Add
		  */
		 eventSequence = new ElementHandler(aut, By.id("EVT$EVT_SEQ"), this.frame.tabPage.toFrameMap());
		 eventRecordCnt = new ElementHandler(aut, By.id("EVT$recordCount"), this.frame.tabPage.toFrameMap());
		 eventRightArrow = new ElementHandler(aut, By.id("IM_EvtScroll_rigthArrow"), this.frame.tabPage.toFrameMap());
		 eventTriggerDate = new ElementHandler(aut, By.id("EVT$TRIGGER_DT"), this.frame.tabPage.toFrameMap());
		 /*
		  * CP_CC.020 - 2020-05-14 - End Add
		  */
	}
}
