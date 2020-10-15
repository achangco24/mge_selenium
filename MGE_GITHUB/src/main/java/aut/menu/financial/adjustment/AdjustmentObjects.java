/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Adjustment Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN					Reason text.
 * 2020-06-01	RExtra	CP_FIN.02	Update Steps to accommodate change due to SQL
 * 									Integration
 * 
 *************************************************************************************
 */
package aut.menu.financial.adjustment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class AdjustmentObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
	
	//Main
	public final ElementHandler said;
	public final ElementHandler accountInfo; 
	public final ElementHandler adjustmentType;
	public final ElementHandler adjustmentTypeInfo;
	public final ElementHandler amount;
	public final ElementHandler mainComments;
	
	/*
	 * CP_FIN.02 - 2020-07-27 - Start Add
	 */
	public final ElementHandler cancelBtn;
	/*
	 * CP_FIN.02 - 2020-07-27 - End Add
	 */
	
	
	//Transfer Adjustment
	public final ElementHandler said2;
	public final ElementHandler transferComments;
	public final ElementHandler transAdjInfo;
	public final ElementHandler searchIconSA;
	
	public final ElementHandler delete;
	public final ElementHandler generateBtn;
	public final ElementHandler calculateBtn;
	public final ElementHandler freezeBtn, freezeBtn2;
	
	//security link check from search pop-up window
	public final ElementHandler overridelink;
	public final ElementHandler	moreInfo;
	
	//Search pop-up window
	public final ElementHandler	searchSaID;
	public final ElementHandler	searchBtn;
	
	/*
	 * CP_FIN.02 - 2020-07-27 - Start Add
	 */
	public final ElementHandler	searchAdjID;
	public final ElementHandler	searchAdjButton;
	public final ElementHandler cancelReason;
	public final ElementHandler cancelAdj;
	/*
	 * CP_FIN.02 - 2020-07-27 - End Add
	 */
	//2020-10-01 -Adrian Changco
	public final ElementHandler	adjustmntTbl;
	public final ElementHandler	accId;
	public final ElementHandler	accSearch;
	
	public AdjustmentObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		
		//Main
		said = new ElementHandler(driver, By.id("SA_ID"), this.frame.tabPage.toFrameMap());
		accountInfo = new ElementHandler(aut, By.id("ACCT_INFO"), this.frame.tabPage.toFrameMap());
		adjustmentType = new ElementHandler(driver, By.id("ADJ_TYPE_CD"), this.frame.tabPage.toFrameMap());
		adjustmentTypeInfo = new ElementHandler(driver, By.id("ADJ_TYPE_INFO"), this.frame.tabPage.toFrameMap());
		amount = new ElementHandler(driver, By.name("BASE_AMT_WRK"), this.frame.tabPage.toFrameMap());
		mainComments = new ElementHandler(aut, By.id("COMMENTS"), this.frame.tabPage.toFrameMap());
		
		/*
		 * CP_FIN.02 - 2020-07-27 - Start Add
		 */
		cancelBtn = new ElementHandler(aut, By.id("CANCEL_SW"), this.frame.tabPage.toFrameMap());;
		/*
		 * CP_FIN.02 - 2020-07-27 - End Add
		 */
		
		//Transfer Adjustment
		said2 = new ElementHandler(driver, By.id("SA_ID2"), this.frame.tabPage.toFrameMap());
		transAdjInfo = new ElementHandler(driver, By.id("XADJ_SA_INFO"), this.frame.tabPage.toFrameMap());
		transferComments = new ElementHandler(aut, By.id("COMMENTS2"), this.frame.tabPage.toFrameMap());
		searchIconSA = new ElementHandler(aut, By.id("IM_SA_ID2"), this.frame.tabPage.toFrameMap());
		
		delete = new ElementHandler(driver, By.id("DELETE_SW"), this.frame.tabPage.toFrameMap());
		generateBtn = new ElementHandler(aut, By.id("GENERATE_SW"), this.frame.tabPage.toFrameMap());
		calculateBtn = new ElementHandler(aut, By.id("GENERATE_SW"));
		freezeBtn = new ElementHandler(aut, By.id("FREEZE_SW"), this.frame.tabPage.toFrameMap());
		freezeBtn2 = new ElementHandler(aut, By.id("FREEZE_SW"));
		
		//security link check from search pop-up window
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		
		//Elements under search pop-up window
		searchSaID = new ElementHandler(aut, By.id("SA_ID"));
		searchBtn = new ElementHandler(aut, By.id("BU_Main_search"));
		
		/*
		 * CP_FIN.02 - 2020-07-27 - Start Add
		 */
		searchAdjID = new ElementHandler(aut, By.id("ADJ_ID"));
		searchAdjButton = new ElementHandler(aut, By.id("BU_Main_mainSrch"));
		cancelReason = new ElementHandler(aut, By.id("CAN_RSN_CD"));
		cancelAdj = new ElementHandler(aut, By.id("CANCEL_SW"));
		/*
		 * CP_FIN.02 - 2020-07-27 - End Add
		 */
		
		// 2020-10-01 - Start Add - AChangco
		adjustmntTbl = new ElementHandler(aut, By.id("dataTableBody"));
		accId = new ElementHandler(aut, By.id("ACCT_ID"));
		accSearch = new ElementHandler(aut, By.id("BU_Alternate_altSrch"));
		/// 2020-10-01 -End Add -AChangco
	}
}
