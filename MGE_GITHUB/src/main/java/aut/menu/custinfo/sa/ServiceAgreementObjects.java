/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Service Agreement Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-06-03	RExtra	CP_BI.014	Add components for Setting a Maximum Bill
 * 									Threshold                
 * 
 *************************************************************************************
 */
package aut.menu.custinfo.sa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class ServiceAgreementObjects extends WebElementRepository {
	//Main
	public final ElementHandler activate;
	public final ElementHandler accountId;
	public final ElementHandler accountInfo;
	public final ElementHandler cisDivision;
	public final ElementHandler premiseId;
	public final ElementHandler premiseInfo;
	public final ElementHandler saTypeCode;
	public final ElementHandler saTypeInfo;
	public final ElementHandler statusFlag;
	public final ElementHandler stopSABtn;
	/*
	 * CP_BI.014 - 2020-06-03 - Start Add
	 */
	public final ElementHandler maxBillThreshold;
	/*
	 * CP_BI.014 - 2020-06-03 - End Add
	 */
	
	/*
	 * CP_CI.022 - 2020-06-17 - Start Add
	 */
	public final ElementHandler reqDepositAmt;
	/*
	 * CP_CI.022 - 2020-06-17 - End Add
	 */
	
	
	//Rate info
	public final ElementHandler billFactor;
	public final ElementHandler billFactorDescription;
	public final ElementHandler taxExemptType;
	
	//SA and SP
	public final ElementHandler meterItemInfo;
	public final ElementHandler spId;
	public final ElementHandler spInfo;
	public final ElementHandler startMeterReadId;
	public final ElementHandler startMeterReadInfo;
	
	//SA Search Pop-up
	public final ElementHandler saId;
	public final ElementHandler saIdSearchBtn;
	public final ElementHandler overridelink;
	public final ElementHandler moreInfo;
	
	//Context Menus
	public final ElementHandler accountContextMenu;
	public final ElementHandler dashboardAcctContext;
	
	//Sub-menus under Account Context
	public final ElementHandler payArrangementBreak;
	public final ElementHandler payment;
	public final ElementHandler paymentAdd;
	
	
	//PopUp Table
	public final ElementHandler saTable;
	
	public ServiceAgreementObjects(WebDriver aut, EntityFrameObjects frame) {
		//Main
		activate = new ElementHandler(aut, By.id("ACTIVATE_SW"), frame.tabPage.toFrameMap());
		accountId = new ElementHandler(aut, By.id("ACCT_ID"), frame.tabPage.toFrameMap());
		accountInfo = new ElementHandler(aut, By.id("ACCT_NAME_INFO"), frame.tabPage.toFrameMap());
		cisDivision = new ElementHandler(aut, By.id("CIS_DIVISION"), frame.tabPage.toFrameMap());
		premiseId = new ElementHandler(aut, By.id("CHAR_PREM_ID"), frame.tabPage.toFrameMap());
		premiseInfo = new ElementHandler(aut, By.id("PREMISE_INFO"), frame.tabPage.toFrameMap());
		saTypeCode = new ElementHandler(aut, By.id("SA_TYPE_CD"), frame.tabPage.toFrameMap());
		saTypeInfo = new ElementHandler(aut, By.id("SA_TYPE_INFO"), frame.tabPage.toFrameMap());
		statusFlag = new ElementHandler(aut, By.id("SA_STATUS_FLG"), frame.tabPage.toFrameMap());
		/*
		 * CP_BI.014 - 2020-06-03 - Start Add
		 */
		maxBillThreshold = new ElementHandler(aut, By.id("HIGH_BILL_AMT"), frame.tabPage.toFrameMap());
		/*
		 * CP_BI.014 - 2020-06-03 - End Add
		 */
		
		/*
		 * CP_CI.022 - 2020-06-17 - Start Add
		 */
		reqDepositAmt = new ElementHandler(aut, By.id("TOT_TO_BILL_AMT"), frame.tabPage.toFrameMap());
		/*
		 * CP_CI.022 - 2020-06-17 - End Add
		 */
		
		
		//Rate info
		billFactor = new ElementHandler(aut, By.id("SA_TAX_EXEMPTION$BF_CD"), frame.tabPage.toFrameMap());
		billFactorDescription = new ElementHandler(aut, By.id("SA_TAX_EXEMPTION$BF_CD_DESCR"), frame.tabPage.toFrameMap());
		taxExemptType = new ElementHandler(aut, By.id("SA_TAX_EXEMPTION$TAX_EX_TYPE_CD"), frame.tabPage.toFrameMap());
		
		//SA and SP
		meterItemInfo = new ElementHandler(aut, By.id("SA_SP$MTR_ITEM_INFO"), frame.tabPage.toFrameMap());
		spId = new ElementHandler(aut, By.id("SA_SP$SP_ID"), frame.tabPage.toFrameMap());
		spInfo = new ElementHandler(aut, By.id("SA_SP$SP_INFO"), frame.tabPage.toFrameMap());
		startMeterReadId = new ElementHandler(aut, By.id("SA_SP$START_MR_ID"), frame.tabPage.toFrameMap());
		startMeterReadInfo = new ElementHandler(aut, By.id("SA_SP$START_MR_INFO"), frame.tabPage.toFrameMap());
		
		//SA Search Pop-up
		saId = new ElementHandler(aut, By.id("SA_ID"));
		saIdSearchBtn = new ElementHandler(aut, By.id("BU_Main_search"));
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		
		//Context Menus
		accountContextMenu = new ElementHandler(aut, By.id("IM_SaData_acctCnxt"), frame.tabPage.toFrameMap());
		dashboardAcctContext = new ElementHandler(aut, By.xpath("//*[@id='oraTableContextContainer']/tbody/tr[2]/td[3]/img"), frame.dashboard.toFrameMap());
		
		//Sub-menus under Account Context
		payArrangementBreak = new ElementHandler(aut, By.id("CI_CONTEXTACCOUNT_subMenuItem0x2"), frame.main.toFrameMap());
		payment = new ElementHandler(aut, By.id("CI_CONTEXTACCOUNT_subMenuItem1x39"), frame.main.toFrameMap());
		paymentAdd = new ElementHandler(aut, By.xpath("//*[@id='menuDiv_1']/ul/li[2]/span[1]"), frame.main.toFrameMap());
		
		//Pop up table
		saTable = new ElementHandler(aut, By.id("dataTableBody"), frame.searchDataFrame.toFrameMap());
		
		stopSABtn = new ElementHandler(aut, By.id("STOP_SW"), frame.tabPage.toFrameMap());
		
	}
}
