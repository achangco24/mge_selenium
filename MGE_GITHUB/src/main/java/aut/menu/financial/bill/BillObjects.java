/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Bill Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN					Reason text.
 * 2020-07-07	RExtra	CP_BI.001	Add components to Manually Generate a Bill
 * 2020-07-07	RExtra	CP_BI.006	Add components to Cancel a Bill Segment
 * 2020-07-08	RExtra	CP_BI.002	Add components to CancelRebilling a Bill Segment
 * 
 *************************************************************************************
 */
package aut.menu.financial.bill;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class BillObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
	
	public final ElementHandler accountid;
	public final ElementHandler generateBtn;
	public final ElementHandler cutoffDate;
	public final ElementHandler moreInfo;
	public final ElementHandler overridelink;
	public final ElementHandler calculateBtn;
	public final ElementHandler cancelBtn;
	public final ElementHandler allowEstimates;
	public final ElementHandler freezeBtn;
	public final ElementHandler popFreezeBtn;
	public final ElementHandler billSegment;
	public final ElementHandler calcLinesBtn;
	public final ElementHandler selectAllBtn;
	public final ElementHandler cancelRebillFreeze;
	public final ElementHandler billSegmentBtn;
	public final ElementHandler popCancelReason;
	public final ElementHandler popOption1;
	public final ElementHandler popCalculate;
	
	/*
	 * CP_BI.001 - 2020-07-07 - Start Add
	 */
	public final ElementHandler billCompleteBtn;
	public final ElementHandler popBillCompleteBtn;
	/*
	 * CP_BI.001 - 2020-07-07 - End Add
	 */
	
	/*
	 * CP_BI.006 - 2020-07-07 - Start Add
	 */
	public final ElementHandler popBillID;
	public final ElementHandler popBillIDSearchBtn;	
	/*
	 * CP_BI.006 - 2020-07-07 - End Add
	 */
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	public final ElementHandler acctID;
	public final ElementHandler popBillSearchTbl;
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	/*
	 * 2020-09-28 - Start Add - AChangco
	 */
	public final ElementHandler billMessage;
	
	/*
	 *  - 2020-09-28 - End Add  - AChangco
	 */
	
	/*
	 *  2020-10-01 - Start Add  - AChangco
	 */
	public final ElementHandler popAccIDSearchBtn;
	public final ElementHandler lpcDate;
	public final ElementHandler billSegmentTbl;
	public final ElementHandler billDueDate;
	
	/*
	 *  2020-10-01 - End Add  - AChangco
	 */
	
	
	public BillObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;

		accountid = new ElementHandler(driver, By.id("ACCT_ID"), this.frame.tabPage.toFrameMap());
		generateBtn = new ElementHandler(driver, By.id("ACTION_GENERATE_SW"), frame.tabPage.toFrameMap());
		cutoffDate = new ElementHandler(driver, By.id ("CUTOFF_DT"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		calculateBtn = new ElementHandler(aut, By.id("ACTION_GENERATE_SW"));
		cancelBtn = new ElementHandler(aut, By.id("ACTION_CAN_FRZN_SW"), frame.tabPage.toFrameMap());
		allowEstimates = new ElementHandler(aut, By.xpath("//*[@id=\'ALLOW_EST_SW\']"));
		freezeBtn = new ElementHandler(aut, By.id("ACTION_FREEZE_SW"), frame.tabPage.toFrameMap());
		popFreezeBtn = new ElementHandler(aut, By.id("ACTION_FREEZE_SW"));
		billSegment = new ElementHandler (aut, By.xpath("//*[@id=\'dataTableBody\']"), frame.billSegment.toFrameMap());
		calcLinesBtn = new ElementHandler (aut, By.xpath("//*[@id='CALC_LINES_TLBL']/table/tbody/tr[2]/td"), frame.tabMenu.toFrameMap());
		selectAllBtn = new ElementHandler (aut, By.id("SELECT_ALL"), frame.tabPage.toFrameMap());
		cancelRebillFreeze = new ElementHandler (aut, By.id("ACTION_BS_RBLF_SW"), frame.tabPage.toFrameMap());
		billSegmentBtn = new ElementHandler (aut, By.xpath("//*[@id='SEGMENTS_TLBL']/table/tbody/tr[2]/td"), frame.tabMenu.toFrameMap());
		
		
		/*
		 * CP_BI.001 - 2020-07-07 - Start Add
		 */
		billCompleteBtn = new ElementHandler (aut, By.id("ACTION_COMPLETE_SW"), frame.tabPage.toFrameMap());
		popBillCompleteBtn = new ElementHandler (aut, By.id("ACTION_COMPLETE_SW"));
		/*
		 * CP_BI.001 - 2020-07-07 - End Add
		 */
		
		//popup
		popCancelReason = new ElementHandler(aut, By.id("CAN_RSN_CD"));
		popOption1 = new ElementHandler(aut,By.xpath("//*[@id=\'CAN_RSN_CD\']/option[2]"));
		popCalculate = new ElementHandler(aut, By.id("ACTION_BS_RBLF_SW"));
		
		/*
		 * CP_BI.006 - 2020-07-07 - Start Add
		 */
		popBillID = new ElementHandler(aut, By.id("BILL_ID"));
		popBillIDSearchBtn = new ElementHandler(aut, By.id("BU_Main_bsBiSrBtn"));
		/*
		 * CP_BI.006 - 2020-07-07 - End Add
		 */
		
		/*
		 * CP_BI.002 - 2020-07-08 - Start Add
		 */
		acctID = new ElementHandler(aut, By.id("ACCT_ID"));
		popBillSearchTbl = new ElementHandler(aut, By.id("dataTable"), frame.searchDataFrame.toFrameMap());
		/*
		 * CP_BI.002 - 2020-07-08 - End Add
		 */
		/*
		 * 2020-09-28 - Start Add - AChangco
		 */
		billMessage = new ElementHandler(aut, By.id("BILL_MSG:0$BILL_MSG_CD"));
	
		/*
		 *  2020-09-28 - End Add - AChangco
		 */
		
		/*
		 * 2020-10-01 - Start Add - AChangco
		 */
		popAccIDSearchBtn = new ElementHandler(aut, By.id("BU_Alternate_bsAltSrch"));
		lpcDate = new ElementHandler(aut, By.id("LATE_PAY_CHARGE_DT"));
		billSegmentTbl = new ElementHandler(aut, By.id("BILL_SEG:0$BSEG_INFO"));
		billDueDate = new ElementHandler(aut, By.id("BILL_DT"));
		
	
		/* 2020-10-01 - End Add - AChangco
		 */
	}
}
