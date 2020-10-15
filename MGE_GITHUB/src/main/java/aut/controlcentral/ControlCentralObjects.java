/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Control Central Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-17	GSando	MT.003. 	Add components for add a meter read
 * 2020-04-24	GSando	PY.010. 	Add components for canceling a Payment
 * 2020-05-05	RExtra	CP_CC.003	Add components for Adding a Collection Process
 * 2020-05-05	RExtra	CP_CC.005	Add components for Adding a Severance Process
 * 2020-05-12	RExtra	CP_CC.007	Add components for Adding a Write Off Process
 * 2020-05-13	RExtra	CP_CC.019	Add components for Manually Adding Credit Points  
 * 2020-06-01	RExtra	CP_FIN.01	Add components for Adding an Adjustment
 * 2020-06-01	RExtra	CP_FIN.02	Add components for Canceling an Adjustment
 * 2020-06-02	RExtra	CP_FIN.08	Add components for Adding a Payment Event
 * 2020-06-03	RExtra	CP_BI.014	Add components for Setting a Maximum Bill
 * 									Threshold
 * 2020-06-17	RExtra	CP_CI.022	Add components for Creating a Deposit SA
 * 2020-06-19	RExtra	CP_CI.031	Add components for Adding a Customer Contact
 * 2020-06-30	RExtra	CP_CC.002	Add components to Add Collection Agency Referral
 * 2020-07-01	RExtra	CP_CC.028	Add components to Add Pay Plan
 * 2020-07-07	RExtra	CP_BI.001	Add components to Manually Generate a Bill
 * 2020-07-08	RExtra	CP_BI.002	Add components to CancelRebilling a Bill Segment
 * 2020-07-13	RExtra	CP_CI.030	Add components for Adding a Payment Arrangement
 * 									Request
 * 2020-07-29	RExtra	SEC.001		Add components for Checking Premise Data for User
 * 									CIS Division
 * 2020-09-28	JMalayo				Add components to handle the Go to Person Context Menu button.
 * 2020-10-09	JMalayo	CP.3.1.1.1.005	Search for Person via Last Four of SSN
 * 2020-10-12	JMalayo CP.3.1.9.B Manage Customer Inquiries/Complaints - PSCW 
 * 									Complaints
 *************************************************************************************
 */
package aut.controlcentral;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class ControlCentralObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
	protected MenuObjects menuObj;
	
	public final ElementHandler searchBy;
	public final ElementHandler account;
	public final ElementHandler name;
	public final ElementHandler addPersonBtn;
	public final ElementHandler searchBtn;
	public final ElementHandler personContextMenu;
	public final ElementHandler accountContextMenu;
	public final ElementHandler premiseContextMenu;
	public final ElementHandler billMenu;
	public final ElementHandler startStopMenu;
	public final ElementHandler adjMenu;
	public final ElementHandler autoPayArrMenu;
	public final ElementHandler spMenu;
	public final ElementHandler faMenu;
	public final ElementHandler orderMenu;
	public final ElementHandler add;
	public final ElementHandler search;
	public final ElementHandler meterReadBtn;
	public final ElementHandler SaPremiseListTbl;
	public final ElementHandler premiseInfoTable;
	public final ElementHandler premTreeTbl;
	public final ElementHandler premTreeNode;
	public final ElementHandler overridelink;
	public final ElementHandler moreInfo;
	public final ElementHandler paymentMenu;
	public final ElementHandler stateTable;
	
	
	/*
	 * CP_CC.003 - 2020-05-05 - Start Add
	 */
	public final ElementHandler collectionProcess;
	/*
	 * CP_CC.003 - 2020-05-05 - End Add
	 */
	
	/*
	 * CP_CC.005 - 2020-05-05 - Start Add
	 */
	public final ElementHandler saInfoContextMenu;
	public final ElementHandler severanceProcessMenu;
	/*
	 * CP_CC.005 - 2020-05-05 - End Add
	 */
	
	/*
	 * CP_CC.007 - 2020-05-12 - Start Add
	 */
	public final ElementHandler writeOffProcess;
	 
	/*
	 * CP_CC.007 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.019 - 2020-05-13 - Start Add
	 */
	public final ElementHandler accountMenu;
	/*
	 * CP_CC.019 - 2020-05-13 - End Add
	 */
	
	/*
	 * CP_FIN.01 - 2020-06-01 - Start Add
	 */
	public final ElementHandler adjustmentMenu;
	/*
	 * CP_FIN.01 - 2020-06-01 - End Add
	 */
	
	/*
	 * CP_FIN.02 - 2020-06-01 - Start Add
	 */
	public final ElementHandler saFinancialHistory;
	/*
	 * CP_FIN.02 - 2020-06-01 - End Add
	 */
	
	/*
	 * CP_FIN.08 - 2020-06-02 - Start Add
	 */
	public final ElementHandler paymentEventMenu;
	/*
	 * CP_FIN.08 - 2020-06-02 - End Add
	 */
	
	/*
	 * CP_FIN.10 - 2020-06-16 - Start Add
	 */
	public final ElementHandler paymentEvtTable;
	/*
	 * CP_FIN.10 - 2020-06-16 - End Add
	 */
	
	/*
	 * CP_BI.014 - 2020-06-03 - Start Add
	 */
	public final ElementHandler saMenu;
	/*
	 * CP_BI.014 - 2020-06-03 - End Add
	 */
	
	/*
	 * CP_CI.022 - 2020-06-17 - Start Add
	 */
	public final ElementHandler acct_saMenu;
	/*
	 * CP_CI.022 - 2020-06-17 - End Add
	 */
	
	/*
	 * CP_CI.031 - 2020-06-19 - Start Add
	 */
	public final ElementHandler per_CustConMenu;
	/*
	 * CP_CI.031 - 2020-06-19 - End Add
	 */
	
	/*
	 * CP_CC.002 - 2020-06-30 - Start Add
	 */
	public final ElementHandler collAgencyReferralMenu;
	/*
	 * CP_CC.002 - 2020-06-30 - End Add
	 */
	
	/*
	 * CP_CC.028 - 2020-07-01 - Start Add
	 */
	public final ElementHandler payPlanMenu;
	/*
	 * CP_CC.028 - 2020-07-01 - End Add
	 */
	
	/*
	 * CP_BI.001 - 2020-07-07 - Start Add
	 */
	//public final ElementHandler meterConfigContextMenu;
	public final ElementHandler meterReadMenu;
	/*
	 * CP_BI.001 - 2020-07-07 - End Add
	 */
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	public final ElementHandler meterItemSearchMenu;
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	/*
	 * CP_CI.030 - 2020-07-13 - Start Add
	 */
	public final ElementHandler pmtArrReqMenu;
	public final ElementHandler pmtArrReqType;
	public final ElementHandler uiMapOkBtn;
	/*
	 * CP_CI.030 - 2020-07-13 - End Add
	 */
	
	/*
	 * SEC.001 - 2020-07-29 - Start Add
	 */
	public final ElementHandler address;
	public final ElementHandler resultTable;
	/*
	 * SEC.001 - 2020-07-29 - End Add
	 */
	

	
	/*
	 * SEC.001 - 2020-09-30 - Start Add -AChangco
	 */
	public final ElementHandler startService;
	
	/*
	 * SEC.001 - 2020-09-30 - End Add -AChangco
	 */
	/*
	 *  2020-10-01 - Start Add - AChangco
	 */
	public final ElementHandler acc_saIdFinancialHisMenu;
	public final ElementHandler acc_cutomerContact;
	public final ElementHandler acc_paymentArrangement;	
	public final ElementHandler acc_payPlan;
	public final ElementHandler acc_paymentEvent;
	
	
	/*
	 *	  - 2020-10-01 - End Add -AChangco
	 */
	
	
	/*
	 * Start of Temporary Block
	 */
	public final ElementHandler cisDivision;
	/*
	 * End of Temporary Block
	 */
	
	
	/*
	 * CP.3.1.1.1.005 - 2020-10-09 - JMalayo - Start Add
	 */
	public final ElementHandler personIdType;
	public final ElementHandler personIdValue;
	/*
	 * CP.3.1.1.1.005 - 2020-10-09 - JMalayo - End Add
	 */
	
	
	/*
	 * CP.3.1.9.B.002 - 2020-10-12 - JMalayo - Start Add
	 */
	public final ElementHandler acctActivityHistoryTbl;
	/*
	 * CP.3.1.9.B.002 - 2020-10-12 - JMalayo - End Add
	 */
	
	public ControlCentralObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		menuObj = new MenuObjects(aut, frame);
		
		searchBy = new ElementHandler(driver, By.id("multiQueryZoneFilters1"), this.frame.tabPage.toFrameMap());
		account = new ElementHandler(driver, By.id("accountId1"), this.frame.tabPage.toFrameMap());	//visible when Search By = "Account ID"
		
		/*
		 * Start of Temporary Block
		 */
		cisDivision = new ElementHandler(driver, By.id("cisDivision1"), this.frame.tabPage.toFrameMap());
		/*
		 * End of Temporary Block
		 */
		
		//visible when Search By = "Name and Address"
		name = new ElementHandler(driver, By.id("entityName1"), this.frame.tabPage.toFrameMap());
		addPersonBtn = new ElementHandler(driver, By.xpath("//*[@id=\"zoneBody1\"]/div[3]/div[1]/span/img[@class=\"imgGotoZone\"]"), this.frame.tabPage.toFrameMap()); 
		
		searchBtn = new ElementHandler(driver, By.id("anTLZ1Refresh"), this.frame.tabPage.toFrameMap());
		
		
		/*
		 * CP.3.1.1.001 - 2020-09-28 - Farr - Start Add
		 * personContextMenu = new ElementHandler(driver, By.xpath("//*[@id=\"data_1\"]/table/tbody/tr[1]/td[2]/img"), this.frame.tabPage.toFrameMap());
		 */
		personContextMenu = new ElementHandler(driver, By.xpath("//*[@id=\"data_1\"]/table/tbody/tr[1]/td[2]/img"), this.frame.tabPage.toFrameMap());
		accountContextMenu = new ElementHandler(driver, By.xpath("//*[@id=\"context.2.2\"]/img"), this.frame.tabPage.toFrameMap());
		premiseContextMenu = new ElementHandler(driver, By.xpath("//*[@id=\"data_1\"]/table/tbody/tr[4]/td[2]/img"), this.frame.tabPage.toFrameMap());
		
		/*
		 * CP_CC.019 - 2020-05-13 - Start Add
		 */
		accountMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem0x0"), this.frame.main.toFrameMap());
		/*
		 * CP_CC.019 - 2020-05-13 - End Add
		 */
		
		/*
		 * CP_CC.003 - 2020-05-05 - Start Add
		 */
		collectionProcess = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x19"), this.frame.main.toFrameMap());
		/*
		 * CP_CC.003 - 2020-05-05 - End Add
		 */
		
		/*
		 * CP_CC.007 - 2020-05-12 - Start Add
		 */
		writeOffProcess = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x53"), this.frame.main.toFrameMap());
		/*
		 * CP_CC.007 - 2020-05-12 - End Add
		 */
		
		//Sub-menus under Account Context Menu
		billMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x12"), this.frame.main.toFrameMap());
		startStopMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem0x48"), this.frame.main.toFrameMap());
		adjMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x11"), this.frame.main.toFrameMap());
		autoPayArrMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem0x1"), this.frame.main.toFrameMap());
		/*
		 * PY.010 - 2020-04-24 - Start Add
		 */
		paymentMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x35"), this.frame.main.toFrameMap());
		/*
		 * PY.010 - 2020-04-24 - End Add
		 */
		
		/*
		 * CP_FIN.08 - 2020-06-02 - Start Add
		 */
		paymentEventMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x39"), this.frame.main.toFrameMap());
		/*
		 * CP_FIN.08 - 2020-06-02 - End Add
		 */
		
		
		//Sub-menus under Premise Context Menu
		spMenu = new ElementHandler(driver, By.id("CI_CONTEXTPREMISE_subMenuItem1x14"), this.frame.main.toFrameMap());
		faMenu = new ElementHandler(driver, By.id("CI_CONTEXTPREMISE_subMenuItem1x6"), this.frame.main.toFrameMap());
		orderMenu = new ElementHandler(driver, By.id("CI_CONTEXTPREMISE_subMenuItem1x10"), this.frame.main.toFrameMap());
		
		//*[@id='data_2']/table/tbody/tr[16]/td[1]/img
		//"//*[@id=\'data_2\']/table/tbody/tr[10]/td[1]/img"
		premiseInfoTable = new ElementHandler (aut, By.xpath("//*[@id='data_2']/table/tbody"), frame.tabPage.toFrameMap());
		meterReadBtn = new ElementHandler (aut, By.xpath("//*[@id='data_2']/table/tbody/tr[16]/td[1]/img"), frame.tabPage.toFrameMap());
		
		//Account Information elements
		SaPremiseListTbl = new ElementHandler(driver, By.xpath("//*[@id=\"data_15\"]/table"), frame.tabPage.toFrameMap());
		
		//Premise Tree elements
		premTreeTbl = new ElementHandler(driver, By.xpath("/html/body/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/div"), frame.premiseTree.toFrameMap());
		premTreeNode = new ElementHandler(driver, By.xpath("//*[@id=\"tStart\"]/tbody/tr[1]/td[1]/img"), frame.premiseTree.toFrameMap());
		
		add = menuObj.add; 
		search = menuObj.search;
		
		/*
		 * MT.003 - 2020-04-17 - Start Add
		 */
		//Premise Context Menu
		stateTable = new ElementHandler(aut, By.id("dataTable"), frame.searchDataFrame.toFrameMap());
		
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		/*
		 * MT.003 - 2020-04-17 - End Add
		 */
		
		/*
		 * CP_CC.005 - 2020-05-05 - Start Add
		 */
		saInfoContextMenu = new ElementHandler(driver, By.xpath("//*[@id='data_15']/table/tbody/tr[2]/td[4]/img"), this.frame.tabPage.toFrameMap());
		severanceProcessMenu = new ElementHandler(driver, By.id("CI_CONTEXTSERVICEAGREEMENT_subMenuItem1x21"), this.frame.main.toFrameMap());
		/*
		 * CP_CC.005 - 2020-05-05 - End Add
		 */
		
		
		/*
		 * CP_FIN.01 - 2020-06-01 - Start Add
		 */
		adjustmentMenu = new ElementHandler(driver, By.id("CI_CONTEXTSERVICEAGREEMENT_subMenuItem1x1"), this.frame.main.toFrameMap());
		/*
		 * CP_FIN.01 - 2020-06-01 - End Add
		 */
		
		/*
		 * CP_FIN.10 - 2020-06-01 - Start Add
		 */
		saFinancialHistory = new ElementHandler(driver, By.id("CI_CONTEXTSERVICEAGREEMENT_subMenuItem0x18"), this.frame.main.toFrameMap());
		paymentEvtTable = new ElementHandler(aut, By.id("dataTable"), frame.searchDataFrame.toFrameMap());
		/*
		 * CP_FIN.10 - 2020-06-01 - End Add
		 */
		
		/*
		 * CP_BI.014 - 2020-06-03 - Start Add
		 */
		saMenu = new ElementHandler(driver, By.id("CI_CONTEXTSERVICEAGREEMENT_subMenuItem0x0"), this.frame.main.toFrameMap());
		/*
		 * CP_BI.014 - 2020-06-03 - End Add
		 */
		
		/*
		 * CP_CI.022 - 2020-06-17 - Start Add
		 */
		acct_saMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x46"), this.frame.main.toFrameMap()); 
		/*
		 * CP_CI.022 - 2020-06-17 - End Add
		 */
		
		/*
		 * CP_CI.031 - 2020-06-19 - Start Add
		 */
		per_CustConMenu = new ElementHandler(driver, By.id("CI_CONTEXTPERSON_subMenuItem0x0"), this.frame.main.toFrameMap());
		/*
		 * CP_CI.031 - 2020-06-19 - End Add
		 */
		
		
		/*
		 * CP_CC.002 - 2020-06-30 - Start Add
		 */
		collAgencyReferralMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x18"), this.frame.main.toFrameMap());
		/*
		 * CP_CC.002 - 2020-06-30 - End Add
		 */
		
		/*
		 * CP_CC.028 - 2020-07-01 - Start Add
		 */
		payPlanMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x34"), this.frame.main.toFrameMap());
		/*
		 * CP_CC.028 - 2020-07-01 - End Add
		 */
		
		/*
		 * CP_BI.001 - 2020-07-07 - Start Add
		 */
		//meterConfigContextMenu = new ElementHandler(driver, By.xpath("//*[@id='data_2']/table/tbody/tr[4]/td[1]/img"), this.frame.tabPage.toFrameMap());
		meterReadMenu = new ElementHandler(driver, By.id("CI_CONTEXTMETERCONFIGURATION_subMenuItem1x1"), this.frame.main.toFrameMap());
		/*
		 * CP_BI.001 - 2020-07-07 - End Add
		 */
		
		/*
		 * CP_BI.002 - 2020-07-08 - Start Add
		 */
		meterItemSearchMenu = new ElementHandler(driver, By.id("CI_CONTEXTPREMISE_subMenuItem0x9"), this.frame.main.toFrameMap());
		/*
		 * CP_BI.002 - 2020-07-08 - End Add
		 */
		
		/*
		 * CP_CI.030 - 2020-07-13 - Start Add
		 */
		pmtArrReqMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x37"), this.frame.main.toFrameMap());
		pmtArrReqType = new ElementHandler(driver, By.id("paRequestType"), this.frame.uiMapFrame.toFrameMap());
		uiMapOkBtn = new ElementHandler(driver, By.id("OK_BTN_MP"), this.frame.uiMapFrame.toFrameMap());
		/*
		 * CP_CI.030 - 2020-07-13 - End Add
		 */
		
		/*
		 * SEC.001 - 2020-07-29 - Start Add
		 */
		address = new ElementHandler(driver, By.id("address11"), this.frame.tabPage.toFrameMap());
		resultTable = new ElementHandler(driver, By.id("dataExplorerTable1"), this.frame.tabPage.toFrameMap());
		/*
		 * SEC.001 - 2020-07-29 - End Add
		 */
		
		/*
		 * 2020-09-30 - Start Add - AChangco
		 */
		startService = new ElementHandler(driver, By.id("START_SERVICE_MP"), this.frame.main.toFrameMap());
		/*
		 * 2020-09-30 - 2020-06-02 - End Add - AChangco
		 */
		
		
	
		
		/*
		 *  2020-10-01 - Start Add -AChangco
		 */
		
		acc_saIdFinancialHisMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x43"), this.frame.tabPage.toFrameMap());
		acc_cutomerContact = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x18"), this.frame.tabPage.toFrameMap());
		acc_paymentArrangement = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x33"), this.frame.tabPage.toFrameMap());
		acc_payPlan = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x31"), this.frame.tabPage.toFrameMap()); 		
		 
		acc_paymentEvent = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x31"), this.frame.tabPage.toFrameMap());
		/*
		 * 2020-10-01 - End Add
		 */
		
		
		/*
		 * CP.3.1.1.1.005 - 2020-10-09 - JMalayo - Start Add
		 */
		personIdType = new ElementHandler(driver, By.id("personIDType1"), this.frame.tabPage.toFrameMap());
		personIdValue = new ElementHandler(driver, By.id("personIDValue1"), this.frame.tabPage.toFrameMap());
		/*
		 * CP.3.1.1.1.005 - 2020-10-09 - JMalayo - End Add
		 */
		
		
		/*
		 * CP.3.1.9.B.002 - 2020-10-12 - JMalayo - Start Add
		 */
		acctActivityHistoryTbl = new ElementHandler(driver, By.xpath("//*[@id='data_1']/table/tbody"), this.frame.tabPage.toFrameMap());
		/*
		 * CP.3.1.9.B.002 - 2020-10-12 - JMalayo - End Add
		 */
	}
}
