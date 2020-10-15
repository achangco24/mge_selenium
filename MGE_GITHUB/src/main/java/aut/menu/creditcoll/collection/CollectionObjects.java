/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Collection Process Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-05-05	RExtra	CP_CC.003	Add components for Adding a Collection Process
 * 2020-05-12	RExtra	CP_CC.010	Add components for Canceling a Collection Process
 * 2020-05-13	RExtra	CP_CC.020	Add components for Modifying Collection Event
 * 									Trigger Date       
 * 
 *************************************************************************************
 */
package aut.menu.creditcoll.collection;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class CollectionObjects extends WebElementRepository{
//	private WebDriver driver;

	//Elements under Collection Search Pop-up
	public final ElementHandler collProdId;
	public final ElementHandler collProdIdSearchBtn;
	public final ElementHandler overridelink;
	public final ElementHandler moreInfo;
	public final ElementHandler tableRow;
	
	/*
	 * CP_CC.003 - 2020-05-05 - Start Add
	 */
	public final ElementHandler collClassCtrlSearch;
	public final ElementHandler collClassCtrlCode;
	public final ElementHandler collProcTmplCd;
	public final ElementHandler createDate;
	public final ElementHandler collAmountBaseDate;
	public final ElementHandler daysInArrears;
	public final ElementHandler comment;
	
	//Elements on SA Tab
	public final ElementHandler sa;
	public final ElementHandler im_sa;
	public final ElementHandler sa_info;
	public final ElementHandler sa_status;
	
	private EntityFrameObjects frame;
	/*
	 * CP_CC.003 - 2020-05-05 - End Add
	 */
	
	/*
	 * CP_CC.010 - 2020-05-12 - Start Add
	 */
	public final ElementHandler reason;
	public final ElementHandler cancelBtn;
	 
	/*
	 * CP_CC.010 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.020 - 2020-05-14 - Start Add
	 */
	public final ElementHandler eventSequence;
	public final ElementHandler eventRecordCnt;
	public final ElementHandler eventRightArrow;
	public final ElementHandler eventTriggerDate;
	public final ElementHandler collProcInfo;
	/*
	 * CP_CC.020 - 2020-05-14 - End Add
	 */
	
	public CollectionObjects(WebDriver aut, EntityFrameObjects frame) {
//		driver = aut;
		
		//Collection Search Pop-up
		collProdId = new ElementHandler(aut, By.id("COLL_PROC_ID"));
		collProdIdSearchBtn = new ElementHandler(aut, By.id("BU_Main_search"));
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		
		//Collection Main Page
		tableRow = new ElementHandler(aut, By.xpath("//*[@id=\'tStart\']/tbody/tr[2]/td[2]/div/table/tbody"), frame.graphCollTree.toFrameMap());
		
		/*
		 * CP_CC.003 - 2020-05-05 - Start Add
		 */
		this.frame = frame;
		collClassCtrlCode = new ElementHandler(aut, By.id("COLL_CL_CNTL_CD"), this.frame.tabPage.toFrameMap());
		collClassCtrlSearch = new ElementHandler(aut, By.id("IM_COLL_CL_CNTL_CD"), this.frame.tabPage.toFrameMap());
		collProcTmplCd = new ElementHandler(aut, By.id("COLL_PROC_TMPL_CD"), this.frame.tabPage.toFrameMap());
		createDate = new ElementHandler(aut, By.id("CRE_DTTM_FWDTTM_P1"), this.frame.tabPage.toFrameMap());
		collAmountBaseDate = new ElementHandler(aut, By.id("COLL_ARS_DT"), this.frame.tabPage.toFrameMap());
		daysInArrears = new ElementHandler(aut, By.id("NBR_OF_DAYS_FROM"), this.frame.tabPage.toFrameMap());
		comment = new ElementHandler(aut, By.id("COMMENTS"), this.frame.tabPage.toFrameMap());
		
		
		sa = new ElementHandler(aut, By.id("SA$SA_ID"), this.frame.tabPage.toFrameMap());
		im_sa = new ElementHandler(aut, By.id("IM_SA$SA_ID"), this.frame.tabPage.toFrameMap());
		sa_info = new ElementHandler(aut, By.id("SA$SA_INFO"), this.frame.tabPage.toFrameMap());
		sa_status = new ElementHandler(aut, By.id("SA$COLL_SA_STAT_FLG"), this.frame.tabPage.toFrameMap());
		
		/*
		 * CP_CC.003 - 2020-05-05 - End Add
		 */
		
		/*
		 * CP_CC.010 - 2020-05-12 - Start Add
		 */
		 reason =  new ElementHandler(aut, By.id("COLL_STAT_RSN_FLG"), this.frame.tabPage.toFrameMap());
		 cancelBtn = new ElementHandler(aut, By.id("CANCEL_SW"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_CC.010 - 2020-05-12 - End Add
		 */
		 
		 
		 //Events Tab
		 /*
		  * CP_CC.020 - 2020-05-14 - Start Add
		  */
		 eventSequence = new ElementHandler(aut, By.id("EVT$EVT_SEQ"), this.frame.tabPage.toFrameMap());
		 eventRecordCnt = new ElementHandler(aut, By.id("EVT$recordCount"), this.frame.tabPage.toFrameMap());
		 eventRightArrow = new ElementHandler(aut, By.id("IM_EvtScroll_rigthArrow"), this.frame.tabPage.toFrameMap());
		 eventTriggerDate = new ElementHandler(aut, By.id("EVT$TRIGGER_DT"), this.frame.tabPage.toFrameMap());
		 collProcInfo = new ElementHandler(aut, By.id("COLL_PROC_INFO"), this.frame.tabPage.toFrameMap());
		 /*
		  * CP_CC.020 - 2020-05-14 - End Add
		  */
	}
}
