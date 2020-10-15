/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Payment Event Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:   	 	Reason: 
 * 2020-06-02	RExtra  	CP_FIN.08		Add components for Adding a Payment Event
 * 2020-06-03	RExtra	    CP_FIN.09		Add components for Adding a Payment to
 * 											Multiple Accounts 
 * 2020-06-02	RExtra		CP_FIN.10		Add components for Canceling a Payment
 * 											Event
 * 
 *************************************************************************************
 */
package aut.menu.financial.paymentevent;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class PaymentEventObjects extends WebElementRepository{
	public final ElementHandler amountTendered;
	public final ElementHandler paymentAmount;
	public final ElementHandler okBtn;
	public final ElementHandler overridelink;
	public final ElementHandler moreInfo;
	public final ElementHandler dashboardAcctContext;
	public final ElementHandler sevProcessMenu;
	public final ElementHandler sevSearch;
	
	/*
	 * CP_FIN.08 - 2020-06-02 - Start Add
	 */
	public final ElementHandler paymentDate;
	public final ElementHandler tenderType;
	public final ElementHandler distributeAction;
	
	/*
	 * CP_FIN.08 - 2020-06-02 - End Add
	 */
	
	/*
	 * CP_FIN.09 - 2020-06-03 - Start Add
	 */
	public final ElementHandler framePayGrid;
	public final ElementHandler	otherAcctID;
	public final ElementHandler	otherAmount;
	public final ElementHandler distributeBtn;
	public final ElementHandler freezeBtn;
	
	public final ElementHandler addTenderBtn;
	public final ElementHandler payAcctID;
	public final ElementHandler acctSearchBtn;
	public final ElementHandler acctID;
	public final ElementHandler acctSearch;
	public final ElementHandler tenderAmount;
	public final ElementHandler tndrType;
	public final ElementHandler tndrCtrlID;
	public final ElementHandler payDate;
	
	private WebDriver driver;
	/*
	 * CP_FIN.09 - 2020-06-03 - End Add
	 */
	
	/*
	 * CP_FIN.10 - 2020-06-02 - Start Add
	 */
	public final ElementHandler cancelBtn;
	public final ElementHandler cancelOKBtn;
	public final ElementHandler cancelReason;
	public final ElementHandler includeInTndrCtrlBal;
	/*
	 * CP_FIN.10 - 2020-06-02 - End Add
	 */
	/*
	 * 2020-10-02 - Start Add -AChangco
	 */
	public final ElementHandler paymentAmountCtx;
	/*
	 *  - 2020-10-02 - End Add -AChangco
	 */
	public PaymentEventObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		
		amountTendered = new ElementHandler(aut, By.id("TNDR_TYPE:0$TENDERED_AMT"), frame.tendersGrid.toFrameMap());
		paymentAmount = new ElementHandler(aut, By.id("PAYMENT_AMT"));
		okBtn = new ElementHandler(aut, By.id("OK_LBL_LBL"));
		
		dashboardAcctContext = new ElementHandler(aut, By.xpath("//*[@id='oraTableContextContainer']/tbody/tr[2]/td[3]/img"), frame.dashboard.toFrameMap());
		sevProcessMenu = new ElementHandler(aut, By.id("CI_CONTEXTACCOUNT_subMenuItem1x48"), frame.main.toFrameMap());
		sevSearch = new ElementHandler(aut, By.xpath("//*[@id='menuDiv_1']/ul/li[1]/span[1]"), frame.main.toFrameMap());
		
		/*
		 * CP_FIN.08 - 2020-06-02 - Start Add
		 */
		tenderType = new ElementHandler(aut, By.id("TNDR_TYPE:0$TENDER_TYPE_CD"), frame.tendersGrid.toFrameMap());
		paymentDate = new ElementHandler(aut, By.id("PAYMENT_DT"));
		distributeAction = new ElementHandler(aut, By.id("PEVT_SPCL_ACTN_FLG"));
		/*
		 * CP_FIN.08 - 2020-06-02 - End Add
		 */
		
		/*
		 * CP_FIN.09 - 2020-06-03 - Start Add
		 */
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("payGridpaymentGri"));
		framePayGrid = new ElementHandler(aut, By.id("payGridpaymentGri"), map);
		otherAcctID = new ElementHandler(aut, By.xpath("//*[@id='PAY:1$ACCT_ID']"), framePayGrid.toFrameMap());
		otherAmount = new ElementHandler(aut, By.xpath("//*[@id='PAY:1$PAY_AMT']"), framePayGrid.toFrameMap());
		
		distributeBtn = new ElementHandler(aut, By.xpath("//*[@id='ALL_PAY_DIST_SW']"), frame.tabPage.toFrameMap());
		freezeBtn = new ElementHandler(aut, By.xpath("//*[@id='ALL_PAY_FREEZE_SW']"), frame.tabPage.toFrameMap());
		
		
		addTenderBtn = new ElementHandler(aut, By.id("IM_TndrScrol_add"), frame.tabPage.toFrameMap());
		payAcctID = new ElementHandler(aut, By.id("PAY_TNDR$PAYOR_ACCT_ID"), frame.tabPage.toFrameMap());
		acctSearchBtn = new ElementHandler(aut, By.id("IM_PAY_TNDR$PAYOR_ACCT_ID"), frame.tabPage.toFrameMap());
		acctID = new ElementHandler(aut, By.id("ACCT_ID"));
		acctSearch = new ElementHandler(aut, By.id("BU_Main_search"));
		
		
		
		tenderAmount = new ElementHandler(aut, By.id("PAY_TNDR$TENDER_AMT"), frame.tabPage.toFrameMap());
		tndrType = new ElementHandler(aut, By.id("PAY_TNDR$TNDR_TYPE_NON_CREDIT"), frame.tabPage.toFrameMap());
		tndrCtrlID = new ElementHandler(aut, By.id("PAY_TNDR$TNDR_CTL_ID"), frame.tabPage.toFrameMap());
		payDate = new ElementHandler(aut, By.id("PAY_DT"), frame.tabPage.toFrameMap());
		/*
		 * CP_FIN.09 - 2020-06-03 - End Add
		 */
		
		//Tenders Tab
		/*
		 * CP_FIN.10 - 2020-06-02 - Start Add
		 */
		cancelBtn = new ElementHandler(aut, By.id("PAY_TNDR$TNDR_CANCEL_SW"), frame.tabPage.toFrameMap());
		cancelOKBtn =  new ElementHandler(aut, By.id("PAY_TNDR$TNDR_CANCEL_SW"));
		cancelReason = new ElementHandler(aut, By.id("PAY_TNDR$CAN_RSN_CD2"));
		includeInTndrCtrlBal = new ElementHandler(aut, By.id("PAY_TNDR$IN_TNDR_CTL_BAL_SW"), frame.tabPage.toFrameMap());
		/*
		 * CP_FIN.10 - 2020-06-02 - End Add
		 */
		/*
		 *   2020-10-02 - Start Add -AChangco
		 */
		paymentAmountCtx = new ElementHandler(aut, By.id("IM_PAY:0$payList_ctxPay"), frame.tabPage.toFrameMap());
		/*
		 *  - 2020-10-02 - End Add  -AChangco
		 */
	}
	
	/*
	 * CP_FIN.09 - 2020-06-03 - Start Add
	 */
	public ElementHandler addPaymentEventElementAtIndex(int index) {
		String id = "IM_PAY:" + String.valueOf(index) + "$ADD_BTN";
		return new ElementHandler(driver, By.id(id), framePayGrid.toFrameMap());
	}
	/*
	 * CP_FIN.09 - 2020-06-03 - End Add
	 */
}
