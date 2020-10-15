/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Steps Definitions
 * 
 * This will execute java methods that are link to one or more steps.
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * 2020-04-07	GSando	CI.016.		Add components for creating a Premise.
 * 2020-04-16	GSando	CI.022.		Add components for adding a Log Entry to a 
 * 									Customer Contact.   
 * 2020-04-17	GSando	MT.003.		Add components for add a meter read.
 * 2020-04-20	GSando	FS.001.		Add components for adding a Field Activity.
 * 2020-04-21	GSando	FS.002.		Add components for updating Existing FA 
 * 									Scheduled Date.
 * 2020-04-21	GSando	FS.003. 	Add components for canceling a Field Activity.  
 * 2020-04-22	GSando	PY.005. 	Add components for searching for a Payment.
 * 2020-04-23	GSando	CI.018. 	Add components for adding a Service Point Record
 * 									to a Premise.  
 * 2020-04-24	GSando	PY.010.		Add components for canceling a Payment.
 * 2020-04-30	GSando	TD.001.		Add components for completing a To Do.
 * 
 * 2020-05-05	RExtra	CP_CC.003.	Add components for adding a Collection Process.
 * 2020-05-05	RExtra	CP_CC.005.	Add components for adding a Severance Process.
 * 2020-05-12	RExtra	CP_CC.007.	Add components for adding a Write Off Process.
 * 2020-05-12	RExtra	CP_CC.010.	Add components for canceling a Write Off Process.
 * 2020-05-12	RExtra	CP_CC.013.	Add components for canceling a Write Off Process.
 * 2020-05-13	RExtra	CP_CC.015.	Add components for canceling a Write Off Process.
 * 2020-05-13	RExtra	CP_CC.019.	Add components for manually adding Credit Points.
 * 2020-05-14	RExtra	CP_CC.020.	Add components for modifying a Collection Event 
 * 									Trigger Date.
 * 2020-05-14	RExtra	CP_CC.021.	Add components for modifying a Severance Event
 * 									Trigger Date.
 * 2020-05-14	RExtra	CP_CC.022.	Add components for modifying a Write Off Event
 * 									Trigger Date.
 * 
 * 2020-06-01	RExtra	CP_FIN.01.	Add components for Adding an Adjustment
 * 2020-06-01	RExtra	CP_FIN.02.	Add components for Canceling an Adjustment
 * 2020-06-02	RExtra	CP_FIN.08.	Add components for Adding a Payment Event
 * 2020-06-02	RExtra	CP_FIN.09.	Add components for Adding a Payment to Multiple
 * 									Accounts
 * 2020-06-02	RExtra	CP_FIN.10.	Add components for Canceling a Payment Event
 * 2020-06-02	RExtra	CP_FIN.11.	Add components for Canceling Auto Pay
 * 2020-06-03	RExtra	CP_FIN.12.	Add components for Adding & Manually
 * 									Distributing a Payment
 * 2020-06-03	RExtra	CP_BI.014.	Add components for Setting a Maximum Bill
 * 									Threshold
 * 2020-06-04	RExtra	CP_CI.004.	Add components for Setting up Auto Pay
 * 2020-06-04	RExtra	CP_CI.032	Add components for Adding a Manual Alert
 * 2020-06-04	RExtra	CP_FS.001.	Add components for Create a New FA Manually.
 * 2020-06-15	RExtra	CP_CI.001.	Add components for Adding a Person Record.
 * 2020-06-16	RExtra	CP_FIN.03.	Add components for Adding a Deposit and Tender
 * 									Control
 * 2020-06-17	RExtra	CP_CI.022.	Add components for Creating a Deposit SA
 * 2020-06-19	RExtra	CP_CI.031.	Add components for Adding a Customer Contact
 * 2020-06-04	RExtra	CP_FS.001.	Add components to Create a New FA Manually.
 * 2020-06-19	RExtra	CP_FS.002.	Add components to Update Existing FA Schedule
 * 									Date.
 * 2020-06-22	RExtra	CP_FS.009.	Add components to Create and Complete FA
 * 2020-06-30	RExtra	CP_CC.002	Add components to Add Collection Agency Referral
 * 2020-07-01	RExtra	CP_CC.028	Add components to Add Pay Plan
 * 2020-07-02	RExtra	CP_CI.031	Add components to Cancel Pay Plan
 * 2020-07-02	RExtra	CP_CI.047	Add components to Complete a To Do
 * 2020-07-06	RExtra	CP_CI.038	Add components to Assign To Do Entries to
 * 									Supervisor
 * 2020-07-07	RExtra	CP_BI.001	Add components to Manually Generate a Bill
 * 2020-07-07	RExtra	CP_BI.006	Add components to Cancel a Bill Segment
 * 2020-07-09	RExtra	CP_FIN.26	Add components for Transferring of Balance
 * 2020-07-13	RExtra	CP_CI.030	Add components for Adding a Payment Arrangement
 * 									Request
 * 2020-07-14	RExtra	CP_CI.068	Add components for Starting Service Using an
 * 									Order/Campaign RES
 * 2020-07-14	RExtra	CP_CI.069	Add components for Starting Service Using an
 * 									Order/Campaign COM
 * 2020-07-29	RExtra	SEC.001		Add components for Checking Premise Data for User
 * 									CIS Division
 * 
 * 
 *************************************************************************************
 */
package dpu_stepdefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Commons.CustomConditions;
import Commons.SetupEnvironment;
import aut.Ccb;
import aut.autopayarrangement.AutoPaymentArrangement;
import aut.breakpayarrangement.BreakPaymentArrangement;
import aut.controlcentral.ControlCentral;
import aut.dashboard.Dashboard;
import aut.menu.creditcoll.collection.Collection;
import aut.menu.creditcoll.collectionagencyreferral.CollectionAgencyReferral;
import aut.menu.creditcoll.payplan.PayPlan;
import aut.menu.creditcoll.severance.Severance;
import aut.menu.creditcoll.writeoff.WriteOff;
import aut.menu.custinfo.account.Account;
import aut.menu.custinfo.customercontact.CustomerContact;
import aut.menu.custinfo.person.Person;
import aut.menu.custinfo.premise.Premise;
import aut.menu.custinfo.sa.ServiceAgreement;
import aut.menu.custinfo.sp.ServicePoint;
import aut.menu.custinfo.startstop.StartStop;
import aut.menu.fieldorder.fa.FieldActivity;
import aut.menu.financial.adjustment.Adjustment;
import aut.menu.financial.bill.Bill;
import aut.menu.financial.bill.billsegment.BillSegment;
import aut.menu.financial.deposit.DepositControl;
import aut.menu.financial.payment.Payment;
import aut.menu.financial.payment.paymentarrangementrequest.PaymentArrangementRequest;
import aut.menu.financial.paymentevent.PaymentEvent;
import aut.menu.financial.tender.TenderControl;
import aut.menu.financialquery.paymenttendersearch.PaymentTenderSearch;
import aut.menu.financialquery.safinancialhistory.SAFinancialHistory;
import aut.menu.meter.meteritemsearch.MeterItemSearch;
import aut.menu.meterread.read.MeterRead;
import aut.menu.salesmarketing.order.Order;
import aut.menu.todo.supervisortodoassignment.SupervisorToDoAssignment;
import aut.menu.todoentry.ToDoEntry;
import aut.menu.todolist.ToDoList;
import aut.menu.todosummary.ToDoSummary;
import aut.menu.tool.batchjob.BatchJob;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ey.manila.qa.automation.CalendarUtil;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import features.TestConfig;

public class DPU_StepDefinitions {
	private WebDriver driver;
	private WebDriverWait wait;
	private Ccb ccb;
	private ScreenShot screenshot;
	private ErrorHandle errorHandle;
	private LogFile logger;
	private ControlCentral control;
	private Person person;
	private int personRow = 0;	//initialize index for Person record.
	private StartStop startStop;
	private Premise premise;
	private ServicePoint sp;
	private DepositControl deposit;
	private MeterRead mr;
	private FieldActivity fa;
	private Adjustment adj;
	private AutoPaymentArrangement pa;
	private BreakPaymentArrangement breakPayArr;
	private ServiceAgreement sa;
	private Order order;
	private BatchJob batch;
	private Dashboard dashboard;
	private Bill bill;
	private Collection collection;
	private Severance sev;
	private PaymentEvent pay;
	private Payment payment;
	private CustomerContact cc;
	private PaymentTenderSearch paymentTenderSearch;
	private ToDoSummary toDoSummary;
	private ToDoList toDoList;
	private ToDoEntry toDoEntry;
	
	/*
	 * CP_CC.007 - 2020-05-12 - Start Add
	 */
	private WriteOff writeOff;
	/*
	 * CP_CC.007 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.019 - 2020-05-13 - Start Add
	 */
	private Account account;
	/*
	 * CP_CC.019 - 2020-05-13 - End Add
	 */
	
	/*
	 * CP_FIN.02 - 2020-06-01 - Start Add
	 */
	private SAFinancialHistory saFinHist;
	/*
	 * CP_FIN.02 - 2020-06-01 - End Add
	 */
	
	/*
	 * CP_FIN.03 - 2020-06-16 - Start Add
	 */
	private TenderControl tender;
	/*
	 * CP_FIN.02 - 2020-06-16 - End Add
	 */
	
	/*
	 * CP_CC.002 - 2020-06-30 - Start Add
	 */
	private CollectionAgencyReferral collAgencyRef;
	/*
	 * CP_CC.002 - 2020-06-30 - End Add
	 */
	
	/*
	 * CP_CC.028 - 2020-07-01 - Start Add
	 */
	private PayPlan payPlan;
	/*
	 * CP_CC.028 - 2020-07-01 - End Add
	 */
	
	/*
	 * CP_CI.038 - 2020-07-06 - Start Add
	 */
	private SupervisorToDoAssignment supToDoAssignment;
	/*
	 * CP_CI.038 - 2020-07-06 - End Add
	 */
	
	/*
	 * CP_BI.006 - 2020-07-07 - Start Add
	 */
	private BillSegment billSegment;
	/*
	 * CP_BI.006 - 2020-07-07 - End Add
	 */
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	private MeterItemSearch meterItemSearch;
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	/*
	 * CP_CI.030 - 2020-07-13 - Start Add
	 */
	private PaymentArrangementRequest pmtArrReq;
	/*
	 * CP_CI.030 - 2020-07-13 - End Add
	 */
	
	
	public void hasError(Boolean flag) throws Throwable {
		if (flag == false){
			driver.quit();
			System.out.println("Web Driver Session terminated.");
		}
	}
	
	@Before
	public void initialize() {
		SetupEnvironment env = new SetupEnvironment(this.getClass().getName());
		driver = env.getDriver();		
		screenshot = env.getScreenShot();
		wait = env.getWait();
		errorHandle =env.getErrorHandler();
		logger = env.getLogger();
		logger.log(this.getClass().getName() + ": Test Start");
		System.out.println("Finish Initialization");
	}

	@After
	public void cleanup() {
		logger.log(this.getClass().getName() + ": Test End");
		screenshot = null;
		driver = null;
		wait = null;
		errorHandle = null;
		logger = null;
		person = null;
	}
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -CREDENTIAL- section				//////
	//////////////////////////////////////////////////////////////////
	
	@Given("^User is on CC&B$")
	public void user_is_on_ccb() throws Throwable {
		ccb = new Ccb(driver, wait, TestConfig.implicitWait, errorHandle, logger, screenshot);
		boolean flag = ccb.open(TestConfig.dpu27Tst2);//dpu27Pkg.dpu27Dev.dpu27Tst2.seiCCBDev.seiTST2.ccbTRN.seiPROD.ccbGOLD
		
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Exception Error loading CC&B...");
	}
	
	
	
	@When("^User login into CC&B with (.+) and (.+)$")
	public void user_login_into_ccb_with_and(String username, String password) throws Throwable {
		boolean flag = ccb.login(username, password);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Exception Error loading CC&B...");
		driver.navigate().refresh();
	}
	
	@And("^User logout CC&B$")
	public void logout() throws Throwable {
		Thread.sleep(3000);
		boolean flag = ccb.logout();
		Assert.assertTrue(flag, "DPU - Failed to Logout CC&B...");
		driver.close();
		driver.quit();
		
	}
	
	//////////////////////////////////////////////////////////////////
	//////			End of -CREDENTIAL- section					//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -CONTROL CENTRAL- section			//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Navigate to Control Central page$")
	public void navigate_to_control_central_page() throws Throwable {
		control = new ControlCentral(ccb);
		wait.until(CustomConditions.checkWindowReadyState());
		boolean flag = control.open();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Control Central page...");
	}
	
	@And("^Select Search By as (.+)$")
	public void search_by(String search) throws Throwable {
		boolean flag = control.setSearchByAs(search);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Search By value: " + search);
	}
	
	@And("^Enter lastname first with a comma no space then first name in Name field as (.+)$")
	public void enter_name(String personName) throws Throwable {
		boolean flag = control.setName(personName);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering person name: " + personName);
	}
	
	@And("^Click Add Person icon$")
	public void click_add_person() throws Throwable {
		boolean flag = control.addPersonBtn();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed adding Person in Control Central page...");
	}
	
	@And("^Search Account ID as (.+)$")
	public void search_by_account(String account) throws Throwable {
		boolean flag = control.setAccount(account);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed searching Account ID: " + account);
	}
	
	@And("^Search Name as (.+)$")
	public void search_by_name(String name) throws Throwable {
		boolean flag = control.searchByName(name);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed searching Name: " + name);
	}
	
	@And("^From Premise Context Menu go to Service Point search$")
	public void premise_context_go_to_service_point_search() throws Throwable {
		boolean flag = control.searchServicePoint();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed going to Service Point search page...");
	}
	
	@And("^From Premise Context Menu go to Field Activity add$")
	public void premise_context_go_to_field_activity_add() throws Throwable {
		boolean flag = control.addFieldActivity();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed going to Field Activity add page...");
	}
	
	@And("^From Control Premise Context Menu go to Order add$")
	public void control_premise_context_go_to_order_add() throws Throwable {
		boolean flag = control.addOrder();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed going to Meter Read search page...");
	}
	
	@And("^From Account Context Menu go to Adjustment add$")
	public void account_context_go_to_adjustment_add() throws Throwable {
		boolean flag = control.addAdjustment();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed going to Adjustment add page...");
	}
	
	@And("^From Account Context Menu go to Automated Payment Arrangement$")
	public void account_context_go_to_auto_payment_arrangement() throws Throwable {
		boolean flag = control.autoPaymentArrangement();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed going to Adjustment add page...");
	}
	
	@And("^Collapse Premise Node Tree$")
	public void prem_node_tree() throws Throwable {
		control = new ControlCentral(ccb);
		boolean flag = control.expandPremiseTree();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed expanding Premise Tree Node...");
	}
	
	@And("^Navigate to Add Account Billing$")
	public void navigate_to_add_account_billing() throws Throwable {
		control = new ControlCentral(ccb);
		boolean flag = control.addAccountBilling();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Add Account Billing");
	}
	
	@And("^Click Last Meter Read$")
	public void click_last_meter_read() throws Throwable {
		control = new ControlCentral(ccb);
		boolean flag = control.lastMeterRead();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to click Last Meter Read");
	}
	
	/*
	 * MT.003 - 2020-04-17 - Start Add
	 */
	@And("^Select SP Type as (.+) and Service Point Status as (.+)$")
	public void select_sp_type_and_sp_status(String spType, String spStatus) throws Throwable {
		boolean flag = control.selectSpTypeAndStatus(spType, spStatus);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed going to Service Point search page...");
	}
	/*
	 * MT.003 - 2020-04-17 - End Add
	 */
	
	/*
	 * FS.002 - 2020-04-21 - Start Add
	 */
	@And("^From Premise Context Menu go to Field Activity search$")
	public void premise_context_go_to_field_activity_search() throws Throwable {
		boolean flag = control.searchFieldActivity();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed going to Field Activity search page...");
	}
	
	@And("^Select Field Activity Status as (.+)$")
	public void select_field_activity(String faStatus) throws Throwable {
		boolean flag = control.selectFaStatus(faStatus);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed seraching for Field Activity Status: " + faStatus);
	}
	/*
	 * FS.002 - 2020-04-21 - End Add
	 */
	
	/*
	 * CI.018 - 2020-04-23 - Start Add
	 */
	@And("^Select Service Point as (.+)$")
	public void select_service_point(String spId) throws Throwable {
		boolean flag = control.selectSp(spId);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed seraching for Service Point: " + sp);
	}
	/*
	 * CI.018 - 2020-04-23 - End Add
	 */
	
	/*
	 * PY.010 - 2020-04-24 - Start Add
	 */
	@And("^From Account Context Menu go to Payment search$")
	public void account_context_go_to_payment_search() throws Throwable {
		boolean flag = control.searchPayment();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed going to Payment search page...");
	}
	
	@And("^Select PaymentStatus as (.+)$")
	public void select_payment_status(String paymentStatus) throws Throwable {
		boolean flag = control.selectPaymentStatus(paymentStatus);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Payment...");
	}
	/*
	 * PY.010 - 2020-04-24 - End Add
	 */
	
	/*
	 * CP_CC.003 - 2020-05-05 - Start Add
	 */
	@And("^Navigate to Add Collection Process$")
	public void navigate_to_add_collection_process() throws Throwable {
		control = new ControlCentral(ccb);
		boolean flag = control.addCollectionProcess();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Add Collection Processs");
	}
	
	/*
	 * CP_CC.003 - 2020-05-05 - End Add
	 */
	
	/*
	 * CP_CC.005 - 2020-05-05 - Start Add
	 */
	@And("^Navigate to Add Severance Process$")
	public void navigate_to_add_severance_process() throws Throwable {
		Thread.sleep(3000);
		control = new ControlCentral(ccb);
		boolean flag = control.addSeveranceThruSAContextMenu();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Add Severance Processs");
	}
	/*
	 * CP_CC.005 - 2020-05-05 - End Add
	 */
	
	/*
	 * CP_CC.007 - 2020-05-12 - Start Add
	 */
	@And("^Navigate to Add Write Off Process$")
	public void navigate_to_add_write_off_process() throws Throwable {
		control = new ControlCentral(ccb);
		boolean flag = control.addWriteOffProcess();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Add Write Off Processs");
	}
	 
	/*
	 * CP_CC.007 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.010 - 2020-05-12 - Start Add
	 */
	@And("^Navigate to Collection Process via Dashboard Alert$")
	public void nav_to_coll_proc_via_dash_alert() throws Throwable {
		boolean flag = control.navToCollProcViaDashAlert();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Navigate to Collection Process via Dashboard Alert");
	}
	/*
	 * CP_CC.010 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.013 - 2020-05-12 - Start Add
	 */
	@And("^Navigate to Severance Process via Dashboard Alert$")
	public void nav_to_sev_proc_via_dash_alert() throws Throwable {
		boolean flag = control.navToSevProcViaDashAlert();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Navigate to Severance Process via Dashboard Alert");
	}
	 
	/*
	 * CP_CC.013 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.015 - 2020-05-13 - Start Add
	 */
	@And("^Navigate to Write Off Process via Dashboard Alert$")
	public void nav_to_wo_proc_via_dash_alert() throws Throwable {
		boolean flag = control.navToWOProcViaDashAlert();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Navigate to Write Off Process via Dashboard Alert");
	}
	/*
	 * CP_CC.015 - 2020-05-13 - End Add
	 */
	
	/*
	 * CP_CC.019 - 2020-05-13 - Start Add
	 */
	@And("^Navigate to Account thru Context Menu$")
	public void navToAccountThruContextMenu() throws Throwable {
		boolean flag = control.navToAccountThruContextMenu();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Navigate to Account thru Context Menu");
	}
	
	/*
	 * CP_CC.019 - 2020-05-13 - End Add
	 */
	
	/*
	 * CP_FIN.01 - 2020-06-01 - Start Add
	 */
	@And("^Navigate to Add Adjustment$")
	public void navigate_to_add_adjustment() throws Throwable {
		Thread.sleep(3000);
		control = new ControlCentral(ccb);
		boolean flag = control.addAdjustmentThruSAContextMenu();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Add Adjustment");
	}
	

	/*
	 * CP_FIN.01 - 2020-06-01 - End Add
	 */
	
	/*
	 * CP_FIN.02 - 2020-06-01 - Start Add
	 */
	@And("^Navigate to SA Financial History$")
	public void navigate_to_sa_fin_hist() throws Throwable {
		Thread.sleep(3000);
		control = new ControlCentral(ccb);
		boolean flag = control.navToSAFinHistThruSAContextMenu();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to SA Financial History");
	}
	/*
	 * CP_FIN.02 - 2020-06-01 - End Add
	 */
	
	/*
	 * CP_FIN.08 - 2020-06-02 - Start Add
	 */
	
	@And("^SA Financial History Navigate to Add Payment Event$")
	public void add_payment_evt() throws Throwable {
		Thread.sleep(3000);
		control = new ControlCentral(ccb);
		boolean flag = control.addPaymentEventThruAcctContextMenu();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Adding Payment Event");
	}
	/*
	 * CP_FIN.10 - 2020-06-02 - End Add
	 */
	
	@And("^Search Payment Event$")
	public void search_payment_evt() throws Throwable {
		Thread.sleep(3000);
		control = new ControlCentral(ccb);
		boolean flag = control.searchPaymentEentThruAcctContextMenu();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Searching Payment Event");
	}
	/*
	 * CP_FIN.10 - 2020-06-02 - End Add
	 */
	
	/*
	 * CP_BI.014 - 2020-06-03 - Start Add
	 */
	@And("^Navigate to SA via SA Context Menu$")
	public void navigate_to_sa_via_sa_cntxt() throws Throwable {
		Thread.sleep(3000);
		control = new ControlCentral(ccb);
		boolean flag = control.navToSAThruSAContextMenu();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to Service Agreement");
	}
	/*
	 * CP_BI.014 - 2020-06-03 - End Add
	 */
	
	/*
	 * CP_CI.022 - 2020-06-17 - Start Add
	 */
	@And("^Navigate to Add SA thru Account Context$")
	public void navigate_to_add_sa_thru_acct_cntxt() throws Throwable {
		control = new ControlCentral(ccb);
		boolean flag = control.navToAddSAThruAcctContextMenu();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to Add Service Agreement");
	}
	/*
	 * CP_CI.022 - 2020-06-17 - End Add
	 */
	
	/*
	 * CP_CI.031 - 2020-06-19 - Start Add
	 */
	@And("^Navigate to Add Customer Contact thru Person Context Menu$")
	public void navigate_to_add_cust_con_thru_per_cntxt() throws Throwable {
		control = new ControlCentral(ccb);
		boolean flag = control.navToAddCustConThruPerContextMenu();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to Add Customer Contact");
	}
	/*
	 * CP_CI.031 - 2020-06-19 - End Add
	 */
	
	/*
	 * CP_CC.002 - 2020-06-30 - Start Add
	 */
	@And("^Navigate to Add Collection Agency Referral$")
	public void navigate_to_add_coll_agency_referral() throws Throwable {
		control = new ControlCentral(ccb);
		boolean flag = control.navToAddCollAgencyReferral();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to Add Collection Agency Referral");
	}
	/*
	 * CP_CC.002 - 2020-06-30 - End Add
	 */
	
	/*
	 * CP_CC.028 - 2020-07-01 - Start Add
	 */
	@And("^Navigate to Add Pay Plan$")
	public void navigate_to_add_pay_plan() throws Throwable {
		control = new ControlCentral(ccb);
		boolean flag = control.navToAddPayPlan();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to Add Pay Plan");
	}
	/*
	 * CP_CC.028 - 2020-07-01 - End Add
	 */
	
	/*
	 * CP_CI.031 - 2020-07-02 - Start Add
	 */
	@And("^Navigate to Pay Plan via Dashboard Alert$")
	public void nav_to_pay_plan_via_dash_alert() throws Throwable {
		boolean flag = control.navToPayPlanViaDashAlert();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Navigate to Pay Plan via Dashboard Alert");
	}
	/*
	 * CP_CI.031 - 2020-07-02 - End Add
	 */
	
	/*
	 * CP_BI.001 - 2020-07-07 - Start Add
	 */
	@And("^Navigate to Add Meter Read$")
	public void nav_to_meter_config() throws Throwable {
		boolean flag = control.navToMeterConfig();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Navigate to Add Meter Read");
	}
	/*
	 * CP_BI.001 - 2020-07-07 - End Add
	 */
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	@And("^Navigate to Meter/Item Search Page$")
	public void nav_to_meter_item_search_page() throws Throwable {
		boolean flag = control.navToMeterItemSearch();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Navigate to Meter/Item Search Page");
	}
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	/*
	 * CP_FIN.26 - 2020-07-09 - Start Add
	 */
	@And("^Navigate to Search SA thru Account Context Menu$")
	public void nav_to_search_sa_thru_acct_context_menu() throws Throwable {
		boolean flag = control.navToSearchSAThruAcctContextMenu();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Navigate to Search Service Agreement thru Account Context Menu");
	}
	/*
	 * CP_FIN.26 - 2020-07-09 - End Add
	 */
	
	/*
	 * CP_CI.030 - 2020-07-13 - Start Add
	 */
	@And("^Navigate to Add Payment Arrangement Request$")
	public void nav_to_add_payment_arrangement_request_thru_acct_context_menu() throws Throwable {
		boolean flag = control.navToAddPaymentArrangementRequest();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Navigate to Add Payment Arrangment Request thru Account Context Menu");
	}
	
	@And("^Select Payment Arrangement Request Type as (.+)$")
	public void select_payment_arrangement_request_type(String payArrReqType) throws Throwable {
		boolean flag = control.selectPmtArrReqType(payArrReqType);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Select Payment Arrangment Request Type as '" + payArrReqType + "'");
	}
	/*
	 * CP_CI.030 - 2020-07-13 - End Add
	 */
	
	/*
	 * SEC.001 - 2020-07-29 - Start Add
	 */
	@And("^Enter Control Central Address as (.+)$")
	public void control_central_enter_address(String address) throws Throwable {
		boolean flag = control.enterAddress(address);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Enter Address as '" + address + "'");
	}
	
	@And("^Verify Address Result with (.+)$")
	public void control_central_verify_address(String address) throws Throwable {
		boolean flag = control.verifyAddress(address);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Verify Address");
	}
	/*
	 * SEC.001 - 2020-07-29 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -CONTROL CENTRAL- section			//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -PERSON- section					//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Select Person/Business as (.+)$")
	public void select_person_business(String perBus) throws Throwable {
		person = new Person(ccb);
		boolean flag = person.selectPersonBusiness(perBus);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Person/Business: " + perBus);
	}
	
	@And("^Select Person Contact Type as (.+)$")
	public void select_person_contact_type(String type) throws Throwable {
		boolean flag = person.selectContactTypeAtRow(type, personRow);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Person Contact Type: " + type);
	}
	
	@And("^Enter Person Contact Information as (.+)$")
	public void enter_person_contact_info(String contact) throws Throwable {
		boolean flag = person.enterContactNumberAtRow(contact, personRow);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Person Contact Information: " + contact);
	}
	
	@And("^Set Person Primary Contact as \"([^\"]*)\"$")
	public void set_person_contact_as(boolean status) throws Throwable {
		boolean flag = person.setContactAsPrimaryAtRow(personRow, status);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting Person Primary Contact...");
	}
	
	@And("^Select Person ID Type as (.+)$")
	public void select_person_id_type(String type) throws Throwable {
		boolean flag = person.selectPersonIdTypeAtRow(type, personRow);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Person ID Type: " + type);
	}
	
	@And("^Enter Person ID number as (.+)$")
	public void enter_person_id_info(String id) throws Throwable {
		boolean flag = person.enterPersonIdNumberAtRow(id, personRow);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Person ID Information: " + id);
	}
	
	@And("^Set Person Primary ID as \"([^\"]*)\"$")
	public void set_person_id_as(boolean status) throws Throwable {
		boolean flag = person.setIdentifierAsPrimaryAtRow(personRow, status);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting Person Primary ID...");
	}
	
	@And("^Set Add Account/Start Service as \"([^\"]*)\"$")
	public void set_add_account_as(boolean status) throws Throwable {
		boolean flag = person.setAddAccount(status);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting Person Add Account and Start Service...");
	}
	
	@Then("^Person record is saved with Start Service as \"([^\"]*)\"$")
	public void save_person(boolean startService) throws Throwable {
		boolean personflag = person.savePerson();
		//hasError(personflag);
		Assert.assertTrue(personflag, "DPU - Failed to Save Person");
		
		if(startService){
			startStop = new StartStop(ccb);
			boolean accountFlag = startStop.confirmPageLoad();
			//hasError(accountFlag);
			Assert.assertTrue(accountFlag, "DPU - Failed loading Start/Stop page...");
			startStop.clickDashBoardCustomer();
		}

		boolean idFlag = person.checkIDExist();
		//hasError(idFlag);
		Assert.assertTrue(idFlag, "DPU - Failed creating Person record...");
	}
	
	/*
	 * CP_CI.001 - 2020-06-15 - Start Add
	 */
	@And("^Navigate to Add Person$")
	public void add_person() throws Throwable {
	person = new Person(ccb);	
	boolean flag = person.open();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed Navigating to Add Person");
	}
	
	@And("^Enter Person Name (.+)$")
	public void enter_person_name(String name) throws Throwable {
	person = new Person(ccb);	
	boolean flag = person.enterPersonNameAtRow(name, personRow);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed Navigating to Add Person");
	}
	
	@And("^Select Customer Class as (.+)$")
	public void select_cust_class(String custClass) throws Throwable {
	person = new Person(ccb);	
	boolean flag = person.selectCustClassCd(custClass);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed Selecting Customer Class as '" + custClass + "'");
	}
	/*
	 * CP_CI.001 - 2020-06-15 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -PERSON- section						//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -ACCOUNT- section					//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * CP_CC.019 - 2020-05-13 - Start Add
	 */
	@And("^Switch to C&C Tab$")
	public void switch_to_credAndColl_tab() throws Throwable {
		account = new Account(ccb);
		boolean flag = account.switchToCredAndCollTab();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed switching to C&C Tab...");
	}
	
	@And("^Add Credit Rating History$")
	public void acct_add_credit_rating_history() throws Throwable {
		boolean flag = account.addCredRatingHistory();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Add Credit Rating History");
	}
	
	@And("^Enter Credit Rating History Start Date$")
	public void acct_enter_cred_rat_hist_start_date() throws Throwable {
		boolean flag = account.enterCredRatHistStartDate();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Add Credit Rating History Start Date");
	}
	
	@And("^Add (.+) to Credit Rating History End Date$")
	public void acct_enter_cred_rat_hist_end_date(String rollOffDays) throws Throwable {
		boolean flag = account.enterCredRatHistEndDate(rollOffDays);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Add Credit Rating History End Date");
	}
	
	
	@And("^Enter (.+) Credit Rating$")
	public void acct_enter_cred_rating(String credit) throws Throwable {
		boolean flag = account.enterCredRating(credit);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Add Credit Rating");
	}
	
	@And("^Add C&C Comments (.+)$")
	public void acct_cred_and_coll_comments(String comments) throws Throwable {
		boolean flag = account.addCredAndCollComments(comments);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Add C&C Comments");
	}
	
	@And("^Save Credit Rating History$")
	public void acct_save_cred_rating_history() throws Throwable {
		boolean flag = account.saveCredRatingHist();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Save Credit Rating History");	
	}
	
	/*
	 * CP_CC.019 - 2020-05-13 - End Add
	 */
	
	/*
	 * CP_FIN.11 - 2020-06-02 - Start Add
	 */
	@And("^Switch to Auto Pay Tab$")
	public void switch_to_auto_pay_tab() throws Throwable {
		account = new Account(ccb);
		boolean flag = account.switchToAutoPayTab();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Switching to Auto Pay Tab...");
	}
	
	@And("^Enter Auto Pay End Date (.+)$")
	public void ap_enter_end_date(String endDate) throws Throwable {
		account = new Account(ccb);
		boolean flag = account.enterEndDate(endDate);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Auto Pay End Date: " + endDate);
	}
	/*
	 * CP_FIN.11 - 2020-06-02 - End Add
	 */
	
	/*
	 * CP_CI.004 - 2020-06-04 - Start Add
	 */
	@And("^Enter Auto Pay Start Date (.+)$")
	public void ap_enter_start_date(String startDate) throws Throwable {
		account = new Account(ccb);
		boolean flag = account.enterStartDate(startDate);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Auto Pay Start Date: " + startDate);
	}
	
	@And("^Enter Auto Pay Source Code (.+)$")
	public void ap_enter_source_code(String srcCode) throws Throwable {
		account = new Account(ccb);
		boolean flag = account.enterSourceCode(srcCode);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Auto Pay Source Code: " + srcCode);
	}
	
	@And("^Enter Auto Pay External Account ID (.+)$")
	public void ap_enter_external_acctID(String externalAcctID) throws Throwable {
		account = new Account(ccb);
		boolean flag = account.enterExternalAcctID(externalAcctID);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Auto Pay External Account ID: " + externalAcctID);
	}
	
	@And("^Enter Auto Pay Name (.+)$")
	public void ap_enter_name(String name) throws Throwable {
		account = new Account(ccb);
		boolean flag = account.enterName(name);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Auto Pay Name: " + name);
	}
	/*
	 * CP_CI.004 - 2020-06-04 - End Add
	 */
	
	/*
	 * CP_CI.032 - 2020-06-04 - Start Add
	 */
	@And("^Switch to Alerts Tab$")
	public void switch_to_alerts_tab() throws Throwable {
		account = new Account(ccb);
		boolean flag = account.switchToAlertsTab();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed on Switching to Alerts Tab");
	}
	
	@And("^Set Alert Type (.+)$")
	public void set_alert_type(String alertType) throws Throwable {
		account = new Account(ccb);
		boolean flag = account.setAlertType(alertType);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed on Setting Alert Type '" + alertType + "'");
	}
	
	
	/*
	 * CP_CI.032 - 2020-06-04 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -ACCOUNT- section					//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -PREMISE- section					//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Navigate to Premise page$")
	public void navigate_to_premise_page() throws Throwable {
		premise = new Premise(ccb);
		boolean flag = premise.open();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Premise page...");
	}
	
	@And("^Navigate to Premise search page$")
	public void navigate_to_premise_search() throws Throwable {
		premise = new Premise(ccb);
		boolean flag = premise.search();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Premise search page...");
	}
	
	@And("^Search Premise ID in search pop-up window as (.+)$")
	public void search_prem_id_in_popup_window(String id) throws Throwable {
		boolean flag = premise.searchPopUpPremId(id);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed searching Premise Id in search pop-up window: " + id);
	}
	
	/*
	 * SEC.001 - 2020-07-29 - Start Add
	 */
	@And("^Search Premise Address in search pop-up window as (.+), verify IDs with (.+)$")
	public void search_prem_address_in_popup_window(String address, String IDs) throws Throwable {
		boolean flag = premise.searchPopUpPremAddress(address, IDs);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed searching Premise Address in search pop-up window: " + address);
	}
	/*
	 * SEC.001 - 2020-07-29 - End Add
	 */
	
	@And("^Select Premise Type as (.+)$")
	public void select_premise_type(String premiseType) throws Throwable {
		boolean flag = premise.selectPremiseTypeAs(premiseType);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Premise Type: " + premiseType);
	}
	
	@And("^Enter Premise Postal as (.+)$")
	public void enter_postal(String id) throws Throwable {
		boolean flag = premise.enterPostal(id);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Postal: " + id);
	}
	
	@And("^Enter Premise Timezone as (.+)$")
	public void enter_timezone(String tz) throws Throwable {
		boolean flag = premise.setTimezone(tz);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Timezone: " + tz);
	}
	
	@And("^Enter Premise Address as (.+)$")
	public void enter_address(String addr) throws Throwable {
		boolean flag = premise.enterAddressAtLine(1, addr);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Address: " + addr);
	}
	
	@And("^Enter Premise City as (.+)$")
	public void enter_city(String city) throws Throwable {
		boolean flag = premise.enterCity(city);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering City: " + city);
	}
	
	@And("^Enter Premise County as (.+)$")
	public void enter_county(String county) throws Throwable {
		boolean flag = premise.enterCounty(county);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering County: " + county);
	}
	
	@And("^Switch to Premise Characteristics Tab$")
	public void switch_to_char_tab() throws Throwable {
		boolean flag = premise.switchToTabChar();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed switching to Characteristics Tab...");
	}
	
	@And("^Switch to Premise Main Tab$")
	public void switch_to_main_tab() throws Throwable {
		boolean flag = premise.switchToTabMain();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed switching to Main Tab...");
	}
	
	@And("^Switch to Premise Misc Tab$")
	public void switch_to_misc_tab() throws Throwable {
		boolean flag = premise.switchToTabMisc();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed switching to Misc Tab...");
	}
	
	@And("^Switch to Premise Geo Tab$")
	public void switch_to_geo_tab() throws Throwable {
		boolean flag = premise.switchToTabGeo();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed switching to Geo Tab...");
	}
	
	
	@And("^Select Trend Area as (.+)$")
	public void select_trend_area(String area) throws Throwable {
		boolean flag = premise.selectTrendArea(area);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Trend Area: " + area);
	}
	
	@And("^Enter Effective Date as (.+) at index \"([^\"]*)\"$")
	public void enter_eff_date(String date, int i) throws Throwable {
		/*boolean flag = */premise.characteristics().setEffDateAt(i, date);
		/*Assert.assertTrue(flag, "DPU - Failed entering Postal: " + id);*/
	}
	
	@And("^Enter Premise Geographic Type as (.+) at index \"([^\"]*)\"$")
	public void enter_geo_type(String geoType, int i) throws Throwable {
		/*boolean flag = */premise.geographicData().setGeoTypeAt(i, geoType);
		/*Assert.assertTrue(flag, "DPU - Failed entering Postal: " + id);*/
	}
	
	@And("^Enter Premise Geographic Value as (.+) at index \"([^\"]*)\"$")
	public void enter_geo_val(String geoVal, int i) throws Throwable {
		/*boolean flag = */premise.geographicData().setGeoValAt(i, geoVal);
		/*Assert.assertTrue(flag, "DPU - Failed entering Postal: " + id);*/
	}
	
	@And("^Enter Premise Characteristics Type as (.+) at index \"([^\"]*)\"$")
	public void enter_char_type(String charType, int i) throws Throwable {
		/*boolean flag = */premise.characteristics().setCharTypeAt(i, charType);
		/*Assert.assertTrue(flag, "DPU - Failed entering Postal: " + id);*/
	}
	
	@And("^Enter Premise Characteristics Value as (.+) at index \"([^\"]*)\"$")
	public void enter_char_val(String charVal, int i) throws Throwable {
		/*boolean flag = */premise.characteristics().setCharValAt(i, charVal);
		/*Assert.assertTrue(flag, "DPU - Failed entering Postal: " + id);*/
	}
	
	@And("^Click Add Premise Characteristics icon$")
	public void add_premise_char() throws Throwable {
		/*boolean flag = */premise.characteristics().addRow();
		/*Assert.assertTrue(flag, "DPU - Failed entering Postal: " + id);*/
	}
	
	@Then("^Premise record is saved$")
	public void save_premise() throws Throwable {
		boolean flag = premise.savePremise();
		//hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Save Premise record...");

		boolean idFlag = premise.checkIDExist();
		//hasError(idFlag);
		Assert.assertTrue(idFlag, "DPU - Failed creating Premise record...");
	}
	
	@And("^From SP Context Menu go to Meter Read add$")
	public void sp_context_go_to_meter_read_add() throws Throwable {
		sp = new ServicePoint(ccb);
		boolean flag = sp.addMeterRead();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed going to Meter Read add page...");
	}
	
	@And("^Verify Premise Characteristics Type as (.+) has Premise Characteristics Value as (.+)$")
	public void verify_char_id_in_char_val(String type, String value) throws Throwable {
		boolean flag = premise.checkCharMatch(type, value);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed verifying characteristics value and characteristics type: [Type: " + type + "; Value: " + value + "]");
	}
	
	@And("^From Premise Context Menu go to Order add$")
	public void premise_context_go_to_order_add() throws Throwable {
		boolean flag = premise.addOrder();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed going to Meter Read search page...");
	}
	
	/*
	 * CI.016 - 2020-04-07 - Start Add
	 */
	@And("^Select Cis Division as (.+)$")
	public void select_cis_divisioin(String cisDivisioin) throws Throwable {
		boolean flag = premise.selectCIS(cisDivisioin);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Cis Division: " + cisDivisioin);
	}
	
	@And("^Enter State as (.+)$")
	public void enter_state(String state) throws Throwable {
		boolean flag = premise.setState(state);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting State: " + state);
	}
	/*
	 * CI.016 - 2020-04-07 - End Add
	 */
	
	/*
	 * CI.018 - 2020-04-23 - Start Add
	 */
	@And("^Add Service Point From Premise Context Menu$")
	public void add_sp_from_premise_context_menu() throws Throwable {
		premise = new Premise(ccb);
		boolean flag = premise.addServicePoint();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to add a Service Point...");
	}
	/*
	 * CI.018 - 2020-04-23 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -PREMISE- section					//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -DASHBOARD- section				//////
	//////////////////////////////////////////////////////////////////
	
	@And("^From Alerts Dashboard click \"([^\"]*)\" link$")
	public void click_alert_link_as(String alertText) throws Throwable {
		dashboard = new Dashboard(ccb);
		boolean flag = dashboard.clickAlertLinkWithText(alertText);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed clicking Alert Link: " + alertText);
	}
	
	@And("^Navigate to Add Bill thru Current Account Context Menu$")
	public void navigate_to_add_bill_thru_account_context() throws Throwable {
		dashboard = new Dashboard(ccb);
		boolean flag = dashboard.navToAddBillThruAcctContextMenu();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to Add Bill thru Current Account Context Menu");
	}
	
	@And("^Navigate to Search Bill thru Current Account Context Menu$")
	public void navigate_to_search_bill_thru_account_context() throws Throwable {
		dashboard = new Dashboard(ccb);
		boolean flag = dashboard.navToSearchBillThruAcctContextMenu();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to Search Bill thru Current Account Context Menu");
	}
	
	//////////////////////////////////////////////////////////////////
	//////			End of -DASHBOARD- section					//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -METER READ- section				//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Enter Meter Read Date as (.+) (.+)$")
	public void enter_meter_read_date(String readDate, int days) throws Throwable {
		mr = new MeterRead(ccb);
		CalendarUtil calendarUtil = new CalendarUtil(driver);
		String newDate = calendarUtil.addDays(readDate, days);
		boolean flag = mr.enterReadDate(newDate);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Read Date: " + newDate);
	}
	
	@And("^Select Register Read Type as (.+)$")
	public void select_register_read_type(String regReadType) throws Throwable {
		//mr = new MeterRead(ccb);
		/*boolean flag = */mr.registerRead().setReadTypeAt(0, regReadType);
		/*Assert.assertTrue(flag, "DPU - Failed entering Register Read Value: " + regReadType);*/
	}
	
	@And("^Enter Register Reading as (.+) (.+)$")
	public void enter_register_read(String regRead, double addMeterRead) throws Throwable {
		mr = new MeterRead(ccb);
		try{
			double newRead = Double.parseDouble(regRead);
			newRead = newRead + addMeterRead;
			mr.registerRead().enterReadValueAt(0, String.valueOf(newRead));
		} catch(NumberFormatException nfe){
			nfe.printStackTrace();
		}
		/*boolean flag = */
		/*Assert.assertTrue(flag, "DPU - Failed entering Register Read Value: " + regReadType);*/
	}
	
	@Then("^Meter Read record is saved$")
	public void save_meter_read() throws Throwable {
		boolean flag = mr.saveMeterRead();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Save Meter Read record...");

		//		Thread.sleep(10000);
		boolean idFlag = mr.checkIDExist();
		hasError(idFlag);
		Assert.assertTrue(idFlag, "DPU - Failed creating Meter Read record...");
	}
	
	@And("^Add Meter Reading as (.+)$")
	public void add_meter_reading(String regReading) throws Throwable {
		mr = new MeterRead(ccb);
		boolean flag = mr.addMeterReading(regReading);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to add Meter Reading: " + regReading);
	}
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	@And("^Search Meter Read with ID (.+)$")
	public void search_meter_read_with_id(String meterReadID) throws Throwable {
		mr = new MeterRead(ccb);
		boolean flag = mr.searchForMeterReadID(meterReadID);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Search Meter Read with ID: " + meterReadID);
	}
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -METER READ- section					//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////		Start of -METER/Item Search- section			//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	@And("^Navigate to Search Meter Read via MeterItem Info Context Menu$")
	public void navigate_to_mtr_srch_via_mtritem_info_cntx_menu() throws Throwable {
		meterItemSearch = new MeterItemSearch(ccb);
		boolean flag = meterItemSearch.navToSearchMeterRead();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Navigate to Meter Read Search via Meter/Item Search Info Context Menu...");
	}
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////		End of -METER/ITEM SEARCH- section				//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -DEPOSIT CONTROL- section			//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Navigate to Deposit Control page$")
	public void navigate_to_deposit_control_page() throws Throwable {
		deposit = new DepositControl(ccb);
		boolean flag = deposit.open();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Deposit Control page...");
	}
	
	@And("^Select Deposit Control Tender Source Type as (.+)$")
	public void select_tender_source_type(String source) throws Throwable {
		boolean flag = deposit.selectTenderSource(source);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Tender Source value: " + source);
	}
	
	@And("^Select Deposit Control Currency Code Type as (.+)$")
	public void select_currency_code(String curr) throws Throwable {
		boolean flag = deposit.selectCurrencyCode(curr);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Currency Code value: " + curr);
	}
	
	@And("^Enter Deposit Control Comment as (.+)$")
	public void enter_deposit_control_comment(String comment) throws Throwable {
		boolean flag = deposit.enterComments(comment);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Comments: " + comment);
	}
	
	@Then("^Deposit Control record is saved$")
	public void save_deposit_control() throws Throwable {
		boolean flag = deposit.saveDepositControl();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Save Deposit Control record...");

		boolean idFlag = deposit.checkIDExist();
		hasError(idFlag);
		Assert.assertTrue(idFlag, "DPU - Failed creating Deposit Control record...");
	}
	
	@And("^Navigate to Add Tender Control thru Context Menu$")
	public void navigate_to_add_tender_ctrl() throws Throwable {
		boolean flag = deposit.navToAddTenderCtrl();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Add Tender Control thru Context Menu");
	}
	
	/*
	 * CP_FIN.03 - 2020-06-16 - Start Add
	 */
	@And("^Enter Ending Balance as (.+)$")
	public void enter_deposit_control_ending_balance(String endingBalance) throws Throwable {
		boolean flag = deposit.enterEndingBalance(endingBalance);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Ending Balance: " + endingBalance);
	}
	/*
	 * CP_FIN.02 - 2020-06-16 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -DEPOSIT CONTROL- section			//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -TENDER CONTROL- section			//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * CP_FIN.03 - 2020-06-16 - Start Add
	 */
	@And("^Select Tender Source as (.+)$")
	public void select_tender_control_tender_source(String tndrSrc) throws Throwable {
		tender = new TenderControl(ccb);
		boolean flag = tender.selectTenderSource(tndrSrc);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Selecting Tender Source '" + tndrSrc + "'");
	}
	
	@And("^Save Tender Control$")
	public void save_tender_control() throws Throwable {
		tender = new TenderControl(ccb);
		boolean flag = tender.saveTenderControl();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Saving Tender Control");
	}
	
	/*
	 * CP_FIN.02 - 2020-06-16 - End Add
	 */
	//////////////////////////////////////////////////////////////////
	//////			End of -TENDER CONTROL- section				//////
	//////////////////////////////////////////////////////////////////
	
	
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -FIELD ACTIVITY- section			//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Set Field Activity Type as (.+)$")
	public void set_field_activity_type(String type) throws Throwable {
		fa = new FieldActivity(ccb);
		boolean flag = fa.setFAType(type);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting Field Activity Type: " + type);
	}

	@And("^Enter Field Activity Schedule Date as (.+)$")
	public void enter_field_activity_schedule_date(String schedDate) throws Throwable {
		/*
		 * FS.002 - 2020-04-21 - Start Add
		 */
		fa = new FieldActivity(ccb);
		/*
		 * FS.002 - 2020-04-21 - End Add
		 */
		boolean flag = fa.enterSchedDate(schedDate);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Field Activity Schedule Date: " + schedDate);
	}
	
	/*
	 * CP_FS.001 - 2020-06-04 - Start Add
	 */
	@And("^Enter Field Activity Schedule Time as (.+)$")
	public void enter_field_activity_schedule_time(String schedTime) throws Throwable {
		fa = new FieldActivity(ccb);
		boolean flag = fa.enterSchedTime(schedTime);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Field Activity Schedule Time: " + schedTime);
	}
	
	@And("^Enter Field Dispatch Group as (.+)$")
	public void enter_field_activity_dispatch_group(String dispatchGroup) throws Throwable {
		boolean flag = fa.enterDispatchGrp(dispatchGroup);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Dispatch Group: " + dispatchGroup);
	}
	/*
	 * CP_FS.001 - 2020-06-04 - End Add
	 */
	
	@And("^Enter Field Activity Comments as (.+)$")
	public void enter_field_activity_comment(String comment) throws Throwable {
		boolean flag = fa.enterComments(comment);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Field Activity Comments: " + comment);
	}
	
	@Then("^Field Activity record is saved (.+)$")
	public void save_field_activity(String mode) throws Throwable {
		boolean flag = fa.saveFA();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Save Field Activity record...");

		boolean idFlag = fa.checkIDExist(mode);
		hasError(idFlag);
		Assert.assertTrue(idFlag, "DPU - Failed creating Field Activity record...");
	}
	
	@And("^Search Pending Field Activity in search pop-up window$")
	public void search_pending_field_activity_in_popup_window() throws Throwable {
		fa = new FieldActivity(ccb);
		boolean flag = fa.findPendingFA();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed searching for Pending Field Activity");
	}
	
	@And("^Click Complete button for Field Activity$")
	public void click_completed_fa() throws Throwable {
    	boolean flag = fa.completeFA();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Completing Field Activity...");
		
		boolean idFlag = fa.checkIDExist("Add");
		hasError(idFlag);
		Assert.assertTrue(idFlag, "DPU - Failed creating Field Activity record...");
	}
	
	/*
	 * FS.001 - 2020-04-20 - Start Add
	 */
	@And("^Enter Field Activity Instructions as (.+)$")
	public void enter_field_activity_instructions(String instructions) throws Throwable {
		boolean flag = fa.enterInstructions(instructions);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Field Activity Instructions: " + instructions);
	}
	/*
	 * FS.001 - 2020-04-20 - End Add
	 */
	
	/*
	 * FS.003 - 2020-04-21 - Start Add
	 */
	@And("^Click Cancel Button for Field Activity$")
	public void click_cancel_fa() throws Throwable {
		fa = new FieldActivity(ccb);
    	boolean flag = fa.cancelFA();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Canceling the FA...");
	}
	
	@And("^Select Cancel Reason as for Field Activity (.+)$")
	public void select_fa_cancel_reason(String reason) throws Throwable {
		fa = new FieldActivity(ccb);
    	boolean flag = fa.selectCancelReason(reason);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Selecting Cancel Reason...");
	}
	/*
	 * FS.003 - 2020-04-21 - Start Add
	 */
	
	/*
	 * CP_FS.001 - 2020-06-04 - Start Add
	 */
	@And("^Select SP with ID (.+)$")
	public void select_sp(String spID) throws Throwable {
		fa = new FieldActivity(ccb);
    	boolean flag = fa.setServicePointID(spID);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Selecting Service Point with ID: " + spID);
	}
	/*
	 * CP_FS.001 - 2020-06-04 - End Add
	 */
	
	/*
	 * CP_FS.002 - 2020-06-19 - Start Add
	 */
	@And("^Navigate to FA Search$")
	public void navigae_to_fa_search() throws Throwable {
		fa = new FieldActivity(ccb);
    	boolean flag = fa.search();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed to Navigate to FA Search");
	}
	
	@And("^Search FA with ID (.+) in Pop-up Window$")
	public void search_fa_id_in_popup_window(String id) throws Throwable {
		fa = new FieldActivity(ccb);
		boolean flag = fa.searchPopUpFAId(id);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Searching for FA with ID: " + id);
	}
	
	/*
	 * CP_FS.002 - 2020-06-19 - End Add
	 */
	
	
	/*
	 * CP_FS.009 - 2020-06-22 - Start Add
	 */
	@And("^Switch to Steps Tab$")
	public void switch_to_steps_tab() throws Throwable {
		fa = new FieldActivity(ccb);
		boolean flag = fa.switchToStepsTab();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed switching to Steps Tab...");
	}
	
	@And("^Navigate to Linked Service Point$")
	public void navigate_to_linked_sp() throws Throwable {
		fa = new FieldActivity(ccb);
		boolean flag = fa.navToLinkedSP();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Navigate to linked SP...");
	}
	
	@And("^Complete Field Activity$")
	public void completeFieldActivity() throws Throwable {
		fa = new FieldActivity(ccb);
		boolean flag = fa.completeFieldActivity();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Complete FA");
	}
	/*
	 * CP_FS.009 - 2020-06-22 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -FIELD ACTIVITY- section				//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -ADJUSTMENT- section				//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Set Adjustment Type as (.+)$")
	public void set_adjustment_type(String type) throws Throwable {
		adj = new Adjustment(ccb);
		boolean flag = adj.setAdjustmentType(type);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting Adjustment Type: " + type);
	}
	
	@And("^Enter Adjustment Amount as (.+)$")
	public void enter_adjustment_amount(String amt) throws Throwable {
		boolean flag = adj.enterAmount(amt);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Adjustment Amount: " + amt);
	}
	
	@And("^Enter Adjustment Comments as (.+)$")
	public void enter_adjustment_comment(String comment) throws Throwable {
		boolean flag = adj.enterMainComments(comment);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Adjustment Main Comments: " + comment);
	}
	
	@And("^Enter Adjustment Transfer Service Agreement ID as (.+)$")
	public void enter_adjustment_transfer_sa_id(String said) throws Throwable {
		boolean flag = adj.enterTransferSaId(said);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Adjustment Transfer Service Agreement ID: " + said);
	}
	
	@And("^Enter Adjustment Transfer Comments as (.+)$")
	public void enter_adjustment_transfer_comment(String comment) throws Throwable {
		boolean flag = adj.enterTransferComments(comment);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Adjustment Transfer Comments: " + comment);
	}
	
	@And("^Click Adjustment Generate button$")
	public void click_adjustment_generate_button() throws Throwable {
		boolean flag = adj.generateAdjustment();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Adjustment Generation...");
	}
	
	@And("^Click Adjustment Freeze button$")
	public void click_adjustment_freeze_button() throws Throwable {
		boolean flag = adj.freezeAdjustment();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Freezing Adjustment...");

		boolean idFlag = adj.checkIDExist();
		hasError(idFlag);
		Assert.assertTrue(idFlag, "DPU - Failed creating Adjustment record...");
	}
	
	@And("^Switch to Transfer Adjustment Tab$")
	public void switch_to_transfer_adjustment_tab() throws Throwable {
		boolean flag = adj.switchToTransAdj();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed switching to Transfer Adjustment Tab...");
	}
	
	/*
	 * CP_FIN.02 - 2020-06-16 - Start Add
	 */
	@And("^Save Cancelled Adjustment$")
	public void save_cancelled_adjustment() throws Throwable {
		adj = new Adjustment(ccb);
		boolean flag = adj.save_cancel();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Saving Cancelled Adjustment...");
	}
	/*
	 * CP_FIN.02 - 2020-06-16 - End Add
	 */
	
	/*
	 * CP_FIN.02 - 2020-07-27 - Start Add
	 */
	@And("^Navigate to Adjustment Search$")
	public void nav_to_adj_search() throws Throwable {
		adj = new Adjustment(ccb);
		boolean flag = adj.search();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to Adjustment Search");
	}
	
	@And("^Search Adjustment ID (.+) thru popup$")
	public void search_adj_id_thru_popup(String adjID) throws Throwable {
		adj = new Adjustment(ccb);
		boolean flag = adj.searchPopUpAdjustmentId(adjID);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Searching for Adjustment ID" + adjID);
	}
	
	@And("^Click Cancel Button for Adjustment$")
	public void cancel_adjustment() throws Throwable {
		adj = new Adjustment(ccb);
    	boolean flag = adj.cancelAdjusment();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Selecting Cancel Reason...");
	}
	
	@And("^Select Cancel Reason for Adjustment as (.+)$")
	public void select_adj_cancel_reason(String reason) throws Throwable {
		adj = new Adjustment(ccb);
    	boolean flag = adj.selectCancelReason(reason);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Selecting Cancel Reason...");
	}
	/*
	 * CP_FIN.02 - 2020-07-27 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -ADJUSTMENT- section					//////
	//////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////////////
	//////		Start of -SA FINANCIAL HISTORY- section			//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * CP_FIN.02 - 2020-06-01 - Start Add
	 */
	@And("^Navigate to Adjustment Notebook$")
	public void saFinHist_nav_to_adj_notebook() throws Throwable {
		saFinHist = new SAFinancialHistory(ccb);
		boolean flag = saFinHist.navToAdjustmentNotebook();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to Adjustment Notebook");
	}
	
	@And("^Select Adjustment from Adjustment Notebook as (.+)$")
	public void select_adjusmtent_from_adj_notebook(String adjType) throws Throwable {
		saFinHist = new SAFinancialHistory(ccb);
		boolean flag = saFinHist.selectAdjustmentFromAdjNotebook(adjType);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Adjustment Type: "+adjType);
	}
	
	/*
	 * CP_FIN.02 - 2020-07-27 - Start Remove
	 */
//	@And("^Click Cancel Button for Adjustment$")
//	public void cancel_adjustment() throws Throwable {
//		saFinHist = new SAFinancialHistory(ccb);
//    	boolean flag = saFinHist.cancelAdjusment();
//		hasError(flag);
//    	Assert.assertTrue(flag, "DPU - Failed Selecting Cancel Reason...");
//	}
//	
//	@And("^Select Cancel Reason for Adjustment as (.+)$")
//	public void select_adj_cancel_reason(String reason) throws Throwable {
//		saFinHist = new SAFinancialHistory(ccb);
//    	boolean flag = saFinHist.selectCancelReason(reason);
//		hasError(flag);
//    	Assert.assertTrue(flag, "DPU - Failed Selecting Cancel Reason...");
//	}
	/*
	 * CP_FIN.02 - 2020-07-27 - End Remove
	 */
	
	
	/*
	 * CP_FIN.02 - 2020-06-01 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////		End of -SA FINANCIAL HISTORY- section			//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////		Start of -PAYMENT ARRANGEMENT- section			//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Enter Payment Arrangement Installments as (.+)$")
	public void enter_payment_arrangement_installment(String installment) throws Throwable {
		pa = new AutoPaymentArrangement(ccb);
		boolean flag = pa.enterInstallments(installment);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Payment Arrangement Installment: " + installment);
	}
	
	@And("^Click Break Pay Arrangement button$")
	public void click_break_pay_arrangement_button() throws Throwable {
		breakPayArr = new BreakPaymentArrangement(ccb);
    	boolean flag = breakPayArr.breakPaymentArrangement();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Breaking Pay Arrangement...");
		
		control = new ControlCentral(ccb);	//re-initialize ControlCentral
		boolean idFlag = control.captureSaPremiseListDashboard();
		hasError(idFlag);
		Assert.assertTrue(idFlag, "DPU - Failed capturing SA Premise List under Account Information...");
	}
	
	@And("^Click Create Pay Arrangement button$")
	public void click_create_pay_arrangement_button() throws Throwable {
    	boolean flag = pa.createPaymentArrangement();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Creating Pay Arrangement...");

		boolean idFlag = control.captureSaPremiseListDashboard();
		hasError(idFlag);
		Assert.assertTrue(idFlag, "DPU - Failed capturing SA Premise List under Account Information...");
	}
	
	//////////////////////////////////////////////////////////////////
	//////		End of -PAYMENT ARRANGEMENT- section			//////
	//////////////////////////////////////////////////////////////////
	
	//TODO
	
	
	//////////////////////////////////////////////////////////////////
	//////	Start of -PAYMENT ARRANGEMENT REQUEST- section		//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * CP_CI.030 - 2020-07-13 - Start Add
	 */
	//Process Flow: Payment Arrangement Request
	@And("^Check Payment Arrangment Request Elegibility$")
	public void check_payment_arrangement_request_eligibility() throws Throwable {
		pmtArrReq = new PaymentArrangementRequest(ccb);
		boolean flag = pmtArrReq.checkEligibility();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Customer is NOT Eligible for a Payment Arrangement...");
	}
	
	@And("^Enter Number of Installments as (.+)$")
	public void enter_num_of_installments(String numOfInstallments) throws Throwable {
		pmtArrReq = new PaymentArrangementRequest(ccb);
		boolean flag = pmtArrReq.enterNumOfInstallments(numOfInstallments);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Number of Installments...");
	}
	
	@And("^Finish Adding Payment Arrangement Request$")
	public void finish_payment_arrangement_request() throws Throwable {
		pmtArrReq = new PaymentArrangementRequest(ccb);
		boolean flag = pmtArrReq.finishPayArrReq();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Finish Adding a Paymet Arrangement Request...");
	}
	
	/*
	 * CP_CI.030 - 2020-07-13 - End Add
	 */
	
	
	//////////////////////////////////////////////////////////////////
	//////	End of -PAYMENT ARRANGEMENT REQUEST- section		//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////		Start of -SERVICE AGREEMENT- section			//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Navigate to Service Agreement search page$")
	public void navigate_to_service_agreement_search() throws Throwable {
		sa = new ServiceAgreement(ccb);
		boolean flag = sa.search();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Service Agreement search page...");
	}
	
	@And("^Search Service Agreement ID in search pop-up window as (.+)$")
	public void search_sa_id_in_popup_window(String id) throws Throwable {
		boolean flag = sa.searchPopUpSAId(id);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed searching Service Agreement Id in search pop-up window: " + id);
	}
	
	@And("^From Account Context Menu go to Payment Arrangement Break$")
	public void account_context_go_to_payment_arrangement_break() throws Throwable {
		boolean flag = sa.paymentArrangementBreak();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed going to Payment Arrangement Break page...");
	}
	
	@And("^Select Service Agreement$")
	public void select_sa() throws Throwable {
		sa = new ServiceAgreement(ccb);
		boolean flag = sa.selectSA();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to select Service Agreement");
	}
	
	@And("^Navigate to Add Payment Event$")
	public void navigate_add_payment() throws Throwable {
		boolean flag = sa.addPayment();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to navigate to add payment event");
	}
	
	/*
	 * CP_BI.014 - 2020-06-03 - Start Add
	 */
	@And("^Set Max Bill Threshold (.+)$")
	public void set_max_bill_threshold(String maxBillThreshold) throws Throwable {
		sa = new ServiceAgreement(ccb);
		boolean flag = sa.setMaxBillThreshold(maxBillThreshold);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Set Max Bill Threshold");
	}
	/*
	 * CP_BI.014 - 2020-06-03 - End Add
	 */
	
	/*
	 * CP_CI.022 - 2020-06-17 - Start Add
	 */
	@And("^Set SA Type as (.+)$")
	public void set_sa_type(String saType) throws Throwable {
		sa = new ServiceAgreement(ccb);
		boolean flag = sa.enterSaType(saType);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Set SA Type as '" + saType + "'");
	}
	
	@And("^Set Char Premise ID as (.+)$")
	public void set_char_prem_type(String premID) throws Throwable {
		sa = new ServiceAgreement(ccb);
		boolean flag = sa.enterPremiseId(premID);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Set Char Prem ID as '" + premID + "'");
	}
	
	@And("^Set Requested Deposit Amount as (.+)$")
	public void set_req_deposit_amt(String depositAmt) throws Throwable {
		sa = new ServiceAgreement(ccb);
		boolean flag = sa.setReqDepositAmt(depositAmt);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Set Requested Deposit Amount as '" + depositAmt + "'");
	}
	
	@And("^Activate SA$")
	public void activate_sa() throws Throwable {
		sa = new ServiceAgreement(ccb);
		boolean flag = sa.activate();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Activate SA");
	}
	/*
	 * CP_CI.022 - 2020-06-17 - End Add
	 */
	
	/*
	 * CP_CI.030 - 2020-07-13 - Start Add
	 */
	@And("^Navigate to Payment Arrangement Request thru Alert Link$")
	public void navigate_to_payment_arrangement_request_thru_alert_link() throws Throwable {
		sa = new ServiceAgreement(ccb);
		boolean flag = sa.verifyCreationOfPaymentArragement();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to Payment Arrangement Request thru Alert Link");
	}
	/*
	 * CP_CI.030 - 2020-07-13 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////		End of -SERVICE AGREEMENT- section				//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -ORDER- section					//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Enter Order Names as (.+)$")
	public void enter_order_name(String name) throws Throwable {
		order = new Order(ccb);
		boolean flag = order.enterName(name);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Order Name: " + name);
	}
	
	@And("^Change the answer of “Is this request for a Tenant” to \"([^\"]*)\"$")
	public void change_response_to(String response) throws Throwable {
		boolean flag = order.enterResponse(response);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed changing response to: " + response);
	}
	
	@Then("^Order record is saved$")
	public void save_order() throws Throwable {
		boolean flag = order.saveOrder();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Save Order record...");

		boolean idFlag = order.checkIDExist();
		hasError(idFlag);
		Assert.assertTrue(idFlag, "DPU - Failed creating Order record...");
	}
	
	@And("^Switch to Questions and Misc Fields Tab$")
	public void switch_to_question_misc_tab() throws Throwable {
		boolean flag = order.switchToQuestionMisc();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed switching to Questions & Misc Fields...");
	}
	
	@And("^Click Show Eligibility button$")
	public void click_show_eligibility_button() throws Throwable {
    	boolean flag = order.showEligibility();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Showing Eligibity...");
	}
	
	@And("^Click the package created$")
	public void click_package() throws Throwable {
    	boolean flag = order.showOrderPackage();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Showing Order Package...");
	}
	
	@And("^Click Complete button$")
	public void click_completed_order() throws Throwable {
    	boolean flag = order.completeOrderPackage();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Completed Order Package...");
	}
	
	/*
	 * CP_CI.068 - 2020-07-14 - Start Add
	 */
	@And("^Enter Campaign as (.+)$")
	public void enter_campaign(String campaign) throws Throwable {
		order = new Order(ccb);
    	boolean flag = order.enterCampaign(campaign);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Entering Campaign as '" + campaign + "'");
	}
	
	@And("^Enter Start Date as Sytem Date$")
	public void enter_order_start_date() throws Throwable {
		order = new Order(ccb);
    	boolean flag = order.enterStartDate();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Entering Start Date as Sytem Date...");
	}
	
	
	//-------------------------------PERSON INFORMATION SECTION--------------------------------------------------------------
	@And("^Select Person Information as (.+)$")
	public void select_person_info(String perInfoFlg) throws Throwable {
		order = new Order(ccb);
    	boolean flag = order.selectPersonInfoFlag(perInfoFlg);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Selecting Person Information as '" + perInfoFlg + "'");
	}
	
	@And("^Select Person Name Type as (.+)$")
	public void select_order_person_name_type(String perNameType) throws Throwable {
		order = new Order(ccb);
    	boolean flag = order.selectPersonNameTypeAtRow(perNameType, personRow);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed to Select Person Name Type as '" + perNameType + "'");
	}
	
	@And("^Enter Order Person Name as (.+)$")
	public void enter_order_person_name(String perName) throws Throwable {
		order = new Order(ccb);
    	boolean flag = order.enterPersonNameAtRow(perName, personRow);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed to Select Person Name as '" + perName + "'");
	}
	
	@And("^Select Order Person Contact Type as (.+)$")
	public void select_order_person_contact_type(String perContactType) throws Throwable {
		order = new Order(ccb);
    	boolean flag = order.selectPersonContactTypeAtRow(perContactType, personRow);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed to Select Person Contact Type as '" + perContactType + "'");
	}
	
	@And("^Enter Order Person Contact Info as (.+)$")
	public void enter_order_person_contact_info(String perContactInfo) throws Throwable {
		order = new Order(ccb);
    	boolean flag = order.enterPersonContactInfoAtRow(perContactInfo, personRow);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed to Select Person Contact Information as '" + perContactInfo + "'");
	}
	
	@And("^Tick as Order Primary Person Contact$")
	public void tick_as_order_primary_person_contact() throws Throwable {
		order = new Order(ccb);
    	boolean flag = order.tickPersonContactPrimaryAtRow(personRow);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed to Set as Person Primary Contact");
	}
	
	//-------------------------------ACCOUNT INFORMATION SECTION--------------------------------------------------------------
	@And("^Select Account Information as (.+)$")
	public void select_account_info(String acctInfoFlg) throws Throwable {
		order = new Order(ccb);
    	boolean flag = order.selectAcctInfoFlag(acctInfoFlg);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Selecting Account Information as '" + acctInfoFlg + "'");
	}
	
	@And("^Select Order Customer Class as (.+)$")
	public void select_order_customer_class(String custClass) throws Throwable {
		order = new Order(ccb);
    	boolean flag = order.selectCustomerClass(custClass);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Selecting Customer Class as '" + custClass + "'");
	}
	
	//-------------------------------QUESTIONS SECTION--------------------------------------------------------------
		@And("^Answer RES Order Questions Mode (.+) - Answers (.+),(.+),(.+),(.+),(.+),(.+),(.+),(.+)$")
		public void answer_res_order_questions(String mode, String q0, String q1, String q2, String q3, String q4, String q5, String q6, String q7) throws Throwable {
			order = new Order(ccb);
	    	boolean flag = order.answerResCPPQuestions(mode, q0, q1, q2, q3, q4, q5, q6, q7);
			hasError(flag);
	    	Assert.assertTrue(flag, "DPU - Failed Answering Order Questions using Mode: " + mode);
		}
	
	/*
	 * CP_CI.068 - 2020-07-14 - End Add
	 */
		
		/*
		 * CP_CI.069 - 2020-07-16 - Start Add
		 */
		@And("^Select Order Person/Business as (.+)$")
		public void select_ordr_person_business_flg(String perOrBusFlg) throws Throwable {
			order = new Order(ccb);
	    	boolean flag = order.selectPerOrBusFlag(perOrBusFlg);
			hasError(flag);
	    	Assert.assertTrue(flag, "DPU - Failed Selecting Person/Business Flag as '" + perOrBusFlg + "'");
		}
		
		@And("^Answer COM Order Questions Mode (.+) - Answers (.+),(.+),(.+),(.+),(.+),(.+),(.+),(.+),(.+),(.+),(.+),(.+)$")
		public void answer_com_order_questions(String mode, String q0, String q1, String q2, String q3, String q4, String q5, String q6, String q7, String q8, String q9, String q10, String q11) throws Throwable {
			order = new Order(ccb);
	    	boolean flag = order.answerComCPPQuestions(mode, q0, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11);
			hasError(flag);
	    	Assert.assertTrue(flag, "DPU - Failed Answering Order Questions using Mode: " + mode);
		}
		/*
		 * CP_CI.069 - 2020-07-16 - End Add
		 */
		
	//////////////////////////////////////////////////////////////////
	//////			End of -ORDER- section						//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -BATCH JOB- section				//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Navigate to Batch Job Submission page$")
	public void navigate_to_batch_job_submission() throws Throwable {
		batch = new BatchJob(ccb);
		boolean flag = batch.open();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Batch Job Submission page...");
	}
	
	@And("^Enter Batch Code as (.+)$")
	public void enter_batch_code(String batchCd) throws Throwable {
		boolean flag = batch.enterBatchCode(batchCd);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering batch job code: " + batchCd);
	}
	
	@And("^Enter Batch Business Date as (.+)$")
	public void enter_batch_date(String batchDate) throws Throwable {
		boolean flag = batch.enterBatchDate(batchDate);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Batch Business Date: " + batchDate);
	}
	
	@And("^Click Duplicate and Queue button$")
	public void click_batch_duplicate_queue_button() throws Throwable {
    	boolean flag = batch.clickDQ();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Starting Batch Job Run...");
	}
	
	@And("^Verify Batch Job Status is \"([^\"]*)\"$")
	public void verify_batch_status(String batchStatus) throws Throwable {
		boolean flag = batch.checkBatchStatus(batchStatus);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed verifying Batch Job Status: " + batchStatus);
	}
	
	//////////////////////////////////////////////////////////////////
	//////			End of -BATCH JOB- section					//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -BILL- section						//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Navigate to Bill page$")
	public void navigate_to_bill_page() throws Throwable {
	bill = new Bill(ccb);
	boolean flag = bill.open();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed navigating to Bill page...");
	}
	
	@And("^Generate Bill$")
	public void generate_bill() throws Throwable {
		bill = new Bill(ccb);
		boolean flag = bill.generateBill();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Generate Bill...");
	}
	
	@And("^Enter Cutoff Date in Generate Bill Popup as (.+)$")
	public void enter_bill_cutoff_date(String cutoff) throws Throwable {
	boolean flag = bill.generatePopup(cutoff);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to enter cutoff date: " + cutoff);
	}
	
	@And("^Freeze Bill$")
	public void freeze_bill() throws Throwable {
	boolean flag = bill.freezeBill();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Freeze Bill");
	}
	
	@And("^Navigate to CalcLines$")
	public void calcLines() throws Throwable {
	boolean flag = bill.calcLines();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed navigating to CalcLines");
	}
	
	@And("^Cancel/Rebill/Freeze$")
	public void cancelRebillFreeze() throws Throwable {
	bill = new Bill(ccb);
	boolean flag = bill.cancelRebillFreeze();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Cancel/Rebill/Freeze");
	}
	
	/*
	 * CP_BI.001 - 2020-07-07 - Start Add
	 */
	
	/*
	 * CP_BI.001 - 2020-07-07 - End Add
	 */
	@And("^Complete Bill$")
	public void complete_bill() throws Throwable {
		bill = new Bill(ccb);
		boolean flag = bill.completeBill();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Complete Bill");
	}
	/*
	 * CP_BI.006 - 2020-07-07 - Start Add
	 */
	@And("^Search for Bill ID (.+)$")
	public void search_for_bill_id(String billID) throws Throwable {
		bill = new Bill(ccb);
		boolean flag = bill.searchForBillID(billID);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Searching for Bill ID: " + billID);
	}
	
	@And("^Select a Bill Segment$")
	public void select_bill_segment() throws Throwable {
		bill = new Bill(ccb);
		boolean flag = bill.selectBillSegment();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Selecting a Bill Segment");
	}
	/*
	 * CP_BI.006 - 2020-07-07 - End Add
	 */
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	@And("^Verify Old Bill Segment Status$")
	public void verify_old_bill_segment_status() throws Throwable {
		bill = new Bill(ccb);
		boolean flag = bill.verifyOldBillSegmentStatus();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Verifying Old Bill Segment Status");
	}
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			  End of -BILL- section				        //////
	//////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -BILL SEGMENT- section		        //////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * CP_BI.006 - 2020-07-07 - Start Add
	 */
	@And("^Initate Bill Segment Cancellation due to (.+)$")
	public void initiate_bill_segment_cancellation(String reason) throws Throwable {
		billSegment = new BillSegment(ccb);
		boolean flag = billSegment.initiateBillSegmentCancellation(reason);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Initiate Bill Segment Cancellation");
	}
	
	@And("^Cancel Bill Segment$")
	public void cancel_bill_segment() throws Throwable {
		billSegment = new BillSegment(ccb);
		boolean flag = billSegment.cancelBillSegment();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Cancel Bill Segment");
	}
	/*
	 * CP_BI.006 - 2020-07-07 - End Add
	 */
	
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	@And("^Rebill Bill Segment due to (.+)$")
	public void rebill_bill_segment_due_to(String reason) throws Throwable {
		billSegment = new BillSegment(ccb);
		boolean flag = billSegment.rebillBillSegmentDueTo(reason);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Rebill Bill Segment due to '" + reason + "'");
	}
	
	@And("^Navigate to Bill from Bill Segment$")
	public void navigate_to_bill_from_bill_segment() throws Throwable {
		billSegment = new BillSegment(ccb);
		boolean flag = billSegment.navToBillFromBillSegment();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Navigate to Bill from Bill Segment");
	}
	
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -BILL SEGMENT- section			    //////
	//////////////////////////////////////////////////////////////////

	
	//////////////////////////////////////////////////////////////////
	//////			Start of -COLLECTION- section				//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Navigate to Collection Search$")
	public void collection_search() throws Throwable {
	collection = new Collection(ccb);
	boolean flag = collection.search();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to navigate to Collection Search.");
	}
	
	@And("^Search Collection from popup as (.+)$")
	public void collection_search_popup(String collectionId) throws Throwable {
	boolean flag = collection.searchPopUpCollId(collectionId);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to search Collection: " + collectionId);
	}
	
	/*
	 * CP_CC.003 - 2020-05-05 - Start Add
	 */
	@And("^Enter Collection Class Control code (.+) and Search$")
	public void enter_collection_class_ctrl_code_and_search(String collClassCtrlCode) throws Throwable {
		collection = new Collection(ccb);
		boolean flag = collection.searchCollClassCtrl(collClassCtrlCode);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Enter Collection Class Control Code");
	}
	
	@And("^Select (.+) Collection Process Template$")
	public void select_collection_process_template(String collProcTmplt) throws Throwable {
		//collection = new Collection(ccb);
		boolean flag = collection.select_coll_process_template(collProcTmplt);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Selecting a Collection Process Template");
	}
	
	@And("^Enter Collection Amount Base Date$")
	public void enter_collection_amount_base_date() throws Throwable {
		collection = new Collection(ccb);
		boolean flag = collection.enter_coll_amt_base_date();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Collection Amount Base Date");
	}
	
	@And("^Set Collection (.+) Days in Arrears$")
	public void coll_set_days_in_arrears(String days) throws Throwable {
		collection = new Collection(ccb);
		boolean flag = collection.set_coll_days_in_arrears(days);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Collection Process Days in Arrears");
	}
	
	@And("^Add Collection Process Comment (.+)$")
	public void add_coll_comment(String comment) throws Throwable {
		boolean flag = collection.add_comment(comment);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Comment");
	}
	
	@And("^Switch to SA Tab$")
	public void switch_to_sa_tab() throws Throwable {
		boolean flag = collection.switchToSATab();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed switching to SA Tab...");
	}
	
	@And("^Link SA (.+)$")
	public void link_sa(String saID) throws Throwable {
		Thread.sleep(3000);
		boolean flag = collection.linkSA(saID);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Link SA to Collection Process");
	}
	
	@And("^Select SA Status$")
	public void select_sa_status() throws Throwable {
		Thread.sleep(3000);
		boolean flag = collection.selectSAStatus();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Select SA Status");
	}
	
	@And("^Save Collection Process (.+)$")
	public void save_coll_proc(String mode) throws Throwable {
		boolean flag = collection.saveCollProc(mode);		
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Save Collection Process");
	}
	/*
	 * CP_CC.003 - 2020-05-05 - End Add
	 */
	
	/*
	 * CP_CC.010 - 2020-05-12 - Start Add
	 */
	@And("^Set Collection Process Cancellation Reason$")
	public void set_coll_proc_cancel_reason() throws Throwable {
		collection = new Collection(ccb);
		Thread.sleep(2000);
		boolean flag = collection.setCollProcCancelReason();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Set Collection Process Cancellation Reason");
	}
	
	@And("^Set Collection Process Cancellation Comment (.+)$")
	public void set_coll_proc_cancel_comments(String comments) throws Throwable {
		boolean flag = collection.setCollProcCancelComments(comments);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Set Collection Process Cancellation Comments");
	}
	
	@And("^Cancel Collection Process$")
	public void cancel_collection_process() throws Throwable {
		boolean flag = collection.cancel_coll_proc();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Cancel Collection Process");
	}
	
	@And("^Confirm Cancel Collection Process$")
	public void confirm_cancel_collection_process() throws Throwable {
		boolean flag = collection.confirm_cancel_coll_proc();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Confirm Cancel Collection Process");
		
		System.out.println("Collection Process with ID: " + collection.getId() + " has been cancelled successfully");
	}
	 
	/*
	 * CP_CC.010 - 2020-05-12 - End Add
	 */
	
	
	/*
	 * CP_CC.020 - 2020-05-14 - Start Add
	 */
	
	@And("^Add Collection Process Modification Comments (.+)$")
	public void coll_modify_comment(String comment) throws Throwable {
		collection = new Collection(ccb);
		boolean flag = collection.add_modify_comment(comment);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Modification Comment");
	}
	
	@And("^Switch to Collection Process Events Tab$")
	public void coll_switch_to_events_tab() throws Throwable {
		Thread.sleep(2000);
		collection = new Collection(ccb);
		boolean flag = collection.switchToEventsTab();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Switch to Events Tab");
	}
	
	@And("^Find Collection Process Event Sequence (.+)$")
	public void coll_find_event_sequence(String sequence) throws Throwable {
		collection = new Collection(ccb);
		boolean flag = collection.findEventSequence(sequence);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Finding Event with Sequence: " + sequence);
	}
	
	@And("^Enter New Collection Process Event Trigger Date (.+)$")
	public void coll_enter_new_trigger_date(String newTriggerDate) throws Throwable {
		collection = new Collection(ccb);
		boolean flag = collection.enterNewTriggerDate(newTriggerDate);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed on Entering New Event Trigger Date: " + newTriggerDate);
	}
	
	/*
	 * CP_CC.020 - 2020-05-14 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			  End of -COLLECTION- section				//////
	//////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////
	//////	Start of -COLLECTION AGENCY REFERRAL- section		//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * CP_CC.002 - 2020-06-30 - Start Add
	 */
	@And("^Enter Collection Agency as (.+)$")
	public void enter_coll_agency(String collAgency) throws Throwable {
		collAgencyRef = new CollectionAgencyReferral(ccb);
		boolean flag = collAgencyRef.enter_coll_agency(collAgency);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Collection Agency as '" + collAgency + "'");
	}
	
	@And("^Set Start Date as Current Date$")
	public void set_start_date() throws Throwable {
		collAgencyRef = new CollectionAgencyReferral(ccb);
		boolean flag = collAgencyRef.setStartDate();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting Start Date as Current Date");
	}
	
	@And("^Set Referral Status as (.+)$")
	public void set_referral_status(String status) throws Throwable {
		collAgencyRef = new CollectionAgencyReferral(ccb);
		boolean flag = collAgencyRef.setReferralStatus(status);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting Referral Status...");
	}
	
	@And("^Enter Collection Agency Referral Comments as (.+)$")
	public void enter_coll_agency_ref_comments(String comments) throws Throwable {
		collAgencyRef = new CollectionAgencyReferral(ccb);
		boolean flag = collAgencyRef.enterComments(comments);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Comments...");
	}
	
	@And("^Set Creation Date as (.+)$")
	public void set_creation_date(String creationDate) throws Throwable {
		collAgencyRef = new CollectionAgencyReferral(ccb);
		boolean flag = collAgencyRef.setCreationDate(creationDate);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting Creation Date...");
	}
	
	@And("^Set Referral Amount as (.+)$")
	public void set_coll_agency_referral_amt(String referralAmt) throws Throwable {
		collAgencyRef = new CollectionAgencyReferral(ccb);
		boolean flag = collAgencyRef.setReferralAmt(referralAmt);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting Referral Amount...");
	}
	
	@And("^Set	Referral History Reason as (.+)$")
	public void set_referral_hist_reason(String referralHistRsn) throws Throwable {
		collAgencyRef = new CollectionAgencyReferral(ccb);
		boolean flag = collAgencyRef.setReferralHistRsn(referralHistRsn);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting Referral History Reason...");
	}
	
	@Then("^Collection Agency Referral is saved$")
	public void save_coll_agency_referral() throws Throwable {
		collAgencyRef = new CollectionAgencyReferral(ccb);
		boolean flag = collAgencyRef.saveCollAgencyRef();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Save Colection Agency Referral...");
	}
	/*
	 * CP_CC.002 - 2020-06-30 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////	End of -COLLECTION AGENCY REFERRAL- section			//////
	//////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -SEVERANCE- section				//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Navigate to Severance page$")
	public void navigate_to_severance_page() throws Throwable {
	sev = new Severance(ccb);
	boolean flag = sev.open();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed navigating to Severance page...");
	}
	
	@And("^Navigate to Severance Search Page$")
	public void severance_search() throws Throwable {
	sev = new Severance(ccb);
	boolean flag = sev.search();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed Navigating to Severance Search page");
	}
	
	@And("^Navigate from another page to Severance Search Page$")
	public void severance_search2() throws Throwable {
	boolean flag = sev.search2();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed Navigating to Severance Search page");
	}
	
	@And("^Search Severance in Popup as (.+)$")
	public void popup_search_severance(String procID) throws Throwable {
	boolean flag = sev.severancePopSearchID(procID);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to search severance process ID: " + procID);
	}
	
	@And("^Select Awaiting Field Activity$")
	public void select_awaiting_field_activity() throws Throwable {
	boolean flag = sev.selectAwaitingFieldActivity();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to select Awaiting Field Activity");
	}
	
	@And("^Navigate from Account Context Menu to Control Central$")
	public void nav_to_control_central() throws Throwable {
	boolean flag = sev.goToControlCentral();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed Navigating to Control Central");
	}
	
	@And("^Navigate from Account Context Menu to Service Agreement$")
	public void nav_to_sa() throws Throwable {
	boolean flag = sev.goToServiceAgreement();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed Navigating to Service Agreement");
	}
	
	@And("^Select last Severance$")
	public void select_last_sev() throws Throwable {
	boolean flag = sev.selectLast();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to select the last severance process");
	}
	
	/*
	 * CP_CC.005 - 2020-05-05 - Start Add
	 */
	@And("^Select Severance Process SA (.+)$")
	public void sev_select_sa(String saID) throws Throwable {
		sev = new Severance(ccb);
		Thread.sleep(5000);
		boolean flag = sev.selectSA(saID);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Select SA for Severance Process");
	}
	
	@And("^Select (.+) Severance Process Template$")
	public void select_sev_proc_template(String template) throws Throwable {
		sev = new Severance(ccb);
		boolean flag = sev.selectSevProcTemplate(template);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Select Severance Process Template");
	}
	
	@And("^Enter Severance Amount Base Date$")
	public void enter_severance_amount_base_date() throws Throwable {
		boolean flag = sev.enter_sev_amt_base_date();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Severance Amount Base Date");
	}
	
	@And("^Set Severance (.+) Days in Arrears$")
	public void sev_set_days_in_arrears(String days) throws Throwable {
		boolean flag = sev.set_sev_days_in_arrears(days);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Severance Days in Arrears");
	}
	
	@And("^Add Severance Process Comment (.+)$")
	public void add_sev_comment(String comment) throws Throwable {
		boolean flag = sev.add_comment(comment);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Severance Process Comment");
	}
	
	@And("^Save Severance Process (.+)$")
	public void save_sev_proc(String mode) throws Throwable {
		boolean flag = sev.saveSevProc(mode);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Save Severance Process");
	}
	 
	/*
	 * CP_CC.005 - 2020-05-05 - End Add
	 */
	
	/*
	 * CP_CC.013 - 2020-05-12 - Start Add
	 */
	@And("^Set Severance Process Cancellation Reason$")
	public void set_sev_proc_cancel_reason() throws Throwable {
		Thread.sleep(2000);
		sev = new Severance(ccb);
		boolean flag = sev.setSevProcCancelReason();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Set Severance Process Cancellation Reason");
	}
	
	@And("^Set Severance Process Cancellation Comment (.+)$")
	public void set_sev_proc_cancel_comments(String comments) throws Throwable {
		boolean flag = sev.setSevProcCancelComments(comments);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Set Severance Process Cancellation Comments");
	}
	
	@And("^Cancel Severance Process$")
	public void cancel_severance_process() throws Throwable {
		boolean flag = sev.cancel_sev_proc();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Cancel Severance Process");
	}
	
	@And("^Confirm Cancel Severance Process$")
	public void confirm_cancel_severance_process() throws Throwable {
		boolean flag = sev.confirm_cancel_sev_proc();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Confirm Cancel Severance Process");
		
		System.out.println("Severance Process with ID: " + sev.getId() + " has been cancelled successfully");
	}
	 
	/*
	 * CP_CC.013 - 2020-05-12 - End Add
	 */
	
	
	/*
	 * CP_CC.021 - 2020-05-14 - Start Add
	 */
	
	@And("^Add Severance Process Modification Comments (.+)$")
	public void sev_modify_comment(String comment) throws Throwable {
		sev = new Severance(ccb);
		boolean flag = sev.add_modify_comment(comment);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Adding Severance Process Modification Comment");
	}
	
	@And("^Switch to Severance Process Events Tab$")
	public void sev_switch_to_events_tab() throws Throwable {
		sev = new Severance(ccb);
		boolean flag = sev.switchToEventsTab();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Switch to Severance Process Events Tab");
	}
	
	@And("^Find Severance Process Event Sequence (.+)$")
	public void sev_find_event_sequence(String sequence) throws Throwable {
		sev = new Severance(ccb);
		boolean flag = sev.findEventSequence(sequence);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Finding Severance Process Event with Sequence: " + sequence);
	}
	
	@And("^Enter New Severance Process Event Trigger Date (.+)$")
	public void sev_enter_new_trigger_date(String newTriggerDate) throws Throwable {
		sev = new Severance(ccb);
		boolean flag = sev.enterNewTriggerDate(newTriggerDate);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed on Entering New Severance Process Event Trigger Date: " + newTriggerDate);
	}
	
	/*
	 * CP_CC.021 - 2020-05-14 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			  End of -SEVERANCE- section				//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -WRITE OFF- section				//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * CP_CC.007 - 2020-05-12 - Start Add
	 */
	@And("^Select (.+) Write Off Control$")
	public void select_write_off_ctrl(String writeOffCtrl) throws Throwable {
		writeOff = new WriteOff(ccb);
		boolean flag = writeOff.select_write_off_ctrl(writeOffCtrl);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Selecting Write Off Control");
	}
	
	@And("^Select (.+) Write Off Process Template$")
	public void select_write_off_process_template(String writeOffProcTmplt) throws Throwable {
		boolean flag = writeOff.select_write_off_process_template(writeOffProcTmplt);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Selecting a Write Off Process Template");
	}
	
	@And("^Add Write Off Process Comments (.+)$")
	public void add_write_off_comments(String comments) throws Throwable {
		boolean flag = writeOff.addComments(comments);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Adding Write Off Comments");
	}
	
	@And("^Switch to Write Off SA Tab$")
	public void wo_switch_to_sa_tab() throws Throwable {
		boolean flag = writeOff.switchToSATab();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Switch to SA Tab");
	}
	
	@And("^Link (.+) as Write Off SA$")
	public void link_wo_sa(String saID) throws Throwable {
		Thread.sleep(3000);
		boolean flag = writeOff.linkSA(saID);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Link SA to Collection Process");
	}
	
	@And("^Verify Write Off Status$")
	public void verify_write_off_status() throws Throwable {
		Thread.sleep(3000);
		boolean flag = writeOff.verifyWriteOffStatus();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Verify Write Off Status");
	}
	
	@And("^Save Write Off Process (.+)$")
	public void save_wo_proc(String mode) throws Throwable {
		boolean flag = writeOff.saveWoProc(mode);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Save Write Off Process");
	}
	 
	/*
	 * CP_CC.007 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.015 - 2020-05-13 - Start Add
	 */
	@And("^Set Write Off Process Cancellation Reason$")
	public void set_wo_proc_cancel_reason() throws Throwable {
		writeOff = new WriteOff(ccb);
		boolean flag = writeOff.setWOProcCancelReason();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Set Write Off Process Cancellation Reason");
	}
	
	@And("^Set Write Off Process Cancellation Comment (.+)$")
	public void set_wo_proc_cancel_comments(String comments) throws Throwable {
		boolean flag = writeOff.setWOProcCancelComments(comments);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Set Write Off Process Cancellation Comments");
	}
	
	@And("^Cancel Write Off Process$")
	public void cancel_wo_process() throws Throwable {
		boolean flag = writeOff.cancel_wo_proc();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Cancel Write Off Process");
	}
	
	@And("^Confirm Cancel Write Off Process$")
	public void confirm_cancel_wo_process() throws Throwable {
		boolean flag = writeOff.confirm_cancel_wo_proc();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Confirm Cancel Write Off Process");
		
		System.out.println("Write Off Process with ID: " + writeOff.getId() + " has been cancelled successfully");
	}
	/*
	 * CP_CC.015 - 2020-05-13 - End Add
	 */
	
	/*
	 * CP_CC.022 - 2020-05-14 - Start Add
	 */
	
	@And("^Add Write Off Process Modification Comments (.+)$")
	public void wo_modify_comment(String comment) throws Throwable {
		Thread.sleep(2000);
		writeOff = new WriteOff(ccb);
		boolean flag = writeOff.add_modify_comment(comment);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Entering Modification Comment");
	}
	
	@And("^Switch to Write Off Process Events Tab$")
	public void wo_switch_to_events_tab() throws Throwable {
		writeOff = new WriteOff(ccb);
		boolean flag = writeOff.switchToEventsTab();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Switch to Events Tab");
	}
	
	@And("^Find Write Off Process Event Sequence (.+)$")
	public void wo_find_event_sequence(String sequence) throws Throwable {
		writeOff = new WriteOff(ccb);
		boolean flag = writeOff.findEventSequence(sequence);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Finding Event with Sequence: " + sequence);
	}
	
	@And("^Enter New Write Off Process Event Trigger Date (.+)$")
	public void wo_enter_new_trigger_date(String newTriggerDate) throws Throwable {
		writeOff = new WriteOff(ccb);
		boolean flag = writeOff.enterNewTriggerDate(newTriggerDate);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed on Entering New Event Trigger Date: " + newTriggerDate);
	}
	
	/*
	 * CP_CC.022 - 2020-05-14 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			  End of -WRITE OFF- section				//////
	//////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////
	//////			Start of -PAYMENT EVENT- section	        //////
	//////////////////////////////////////////////////////////////////
	
	@And("^Navigate to Payment Event page$")
	public void navigate_to_paymentevent_page() throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.open();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed navigating to Payment Event page...");
	}
	
	
	@And("^Set amount for Add Payment Event as (.+)$")
	public void add_payment_event(String amount) throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.addPaymentEvent(amount);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Add Payment Event with the amount of " + amount);
	}
	
	/*
	 * CP_FIN.08 - 2020-06-02 - Start Add
	 */
	@And("^Add Payment with Payment Date (.+) and Distribution Code (.+)$")
	public void add_payment_with_date_event(String date, String distributeAction) throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.finHist_addPaymentEvent(date, distributeAction);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Add Payment Event with date: " + date);
	}
	/*
	 * CP_FIN.08 - 2020-06-02 - End Add
	 */
	
	/*
	 * CP_FIN.09 - 2020-06-03 - Start Add
	 */
	@And("^Add Another Payment Event Entry$")
	public void add_another_payment_event_entry() throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.addAnotherPmtEvtEntry();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Add Another Payment Event Entry");
	}
	
	@And("^Enter Other Account ID (.+)$")
	public void add_another_payment_event_acctID(String otherAcctID) throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.addAnotherPmtEvtAcctID(otherAcctID);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Add Another Payment Event Account ID: " + otherAcctID);
	}
	
	
	@And("^Enter Other Amount (.+)$")
	public void add_another_payment_event_amount(String otherAmt) throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.addAnotherPmtEvtAmt(otherAmt);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Add Another Payment Event Amont: " + otherAmt);
	}
	
	@And("^Distribute Payment Event$")
	public void distribute_payment_event() throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.distribute_pmt_evt();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Distribute Payment Event");
	}
	
	@And("^Freeze Payment Event$")
	public void freeze_payment_event() throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.freeze_pmt_evt();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Freeze Payment Event");
	}
	
	
	@And("^Add New Tender$")
	public void add_new_tender() throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.addNewTender();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Add New Tender");
	}
	
	@And("^Enter Payment Date as (.+)$")
	public void new_tndr_enter_pmt_dt(String pmtDate) throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.newTndrPmtDt(pmtDate);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - New Tender - Failed to Enter Payment Date '" + pmtDate + "'");
	}
	
	@And("^Enter Payor Acct ID as (.+)$")
	public void new_tndr_enter_payor_acct_id(String acctID) throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.newTndrEnterAcctID(acctID);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - New Tender - Failed to Enter Payor Account ID: " + acctID);
	}
	
	@And("^Enter Tender Amount as (.+)$")
	public void new_tndr_enter_tndr_amt(String tndrAmt) throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.newTndrTndrAmt(tndrAmt);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - New Tender - Failed to Enter Tender Amount '" + tndrAmt + "'");
	}
	
	@And("^Select Tender Type as (.+)$")
	public void new_tndr_select_tndr_type(String tndrType) throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.newTndrTndrType(tndrType);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - New Tender - Failed to Select Tender Type '" + tndrType + "'");
	}
	
	
	@And("^Enter Tender Control ID as (.+)$")
	public void new_tndr_enter_tndr_ctrl_id(String tndrCtrlID) throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.newTndrTndrCtrlID(tndrCtrlID);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - New Tender - Failed to Enter Tender Control ID: " + tndrCtrlID + "");
	}
	
	@And("^Save Payment Event$")
	public void save_payment_event() throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.savePaymentEvent();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Save Payment Event");
	}
	
	@And("^Switch to Payment Event Main Tab$")
	public void switch_to_pay_evt_main_tab() throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.switchToMainTab();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Switch to Main Tab");
	}
	
	/*
	 * CP_FIN.09 - 2020-06-03 - End Add
	 */
	
	/*
	 * CP_FIN.10 - 2020-06-02 - Start Add
	 */
	@And("^Switch to Tenders Tab$")
	public void switch_to_tenders_tab() throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.switchToTendersTab();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Switch to Tenders Tab");
	}

	@And("^Tick Include in Tender Control Balance as \"([^\"]*)\"$")
	public void include_in_tender_control_balance(boolean status) throws Throwable {
		pay = new PaymentEvent(ccb);
		boolean flag = pay.includeInTndrCtrlBal(status);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to include in Tender Control Balance");
	}
	
	@And("^Cancel Payment Tender (.+)$")
	public void cancel_payment_tender(String reason) throws Throwable {
	pay = new PaymentEvent(ccb);
	boolean flag = pay.cancelPaymentTender(reason);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Cancel Payment Tender");
	}
	
	
	/*
	 * CP_FIN.10 - 2020-06-02 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			  End of -PAYMENT EVENT- section			//////
	//////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -CUSTOMER CONTACT- section			//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * CI.022 - 2020-04-16 - Start Add
	 */
	@And("^Navigate to Customer Contact search page$")
	public void navigate_to_customer_contact_search() throws Throwable {
	cc = new CustomerContact(ccb);
	boolean flag = cc.search();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed navigating to CustomerContact search page...");
	}
	
	@And("^Search Person ID in pop-up window as (.+)$")
	public void search_per_id_in_popup_window(String perId) throws Throwable {
	boolean flag = cc.searchPerIdInPopUp(perId);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed searching Person Id in search pop-up window: " + perId);
	}
	
	@And("^Search Customer Contact ID in pop-up window as (.+)$")
	public void search_cc_id_in_popup_window(String ccId) throws Throwable {
	boolean flag = cc.searchCcIdInPopUp(ccId);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed searching Customer Contact Id in search pop-up window: " + ccId);
	}
	
	@And("^Switch to Log Tab$")
	public void switch_to_log_tab() throws Throwable {
	boolean flag = cc.switchToLogTab();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed switching to Log Tab");
	}
	
	@And("^Add Log Entry as (.+)$")
	public void add_log_entry(String comment) throws Throwable {
	boolean flag = cc.addLogEntry(comment);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed adding Log Entry: "+comment);
	}
	
	@Then("^Customer Contact record is saved$")
	public void save_customer_contact() throws Throwable {
	boolean flag = cc.saveCustomerContact();
	Assert.assertTrue(flag, "DPU - Failed to Save Customer Contact record...");
	
	boolean idFlag = cc.checkIDExist();
	Assert.assertTrue(idFlag, "DPU - Failed creating Customer Contact record...");
	}
	/*
	 * CI.022 - 2020-04-16 - End Add
	 */
	
	
	/*
	 * CP_CI.031 - 2020-06-19 - Start Add
	 */
	@And("^Select Contact Class as (.+)$")
	public void select_contact_class(String contactClass) throws Throwable {
		cc = new CustomerContact(ccb);
		boolean flag = cc.selectContactClass(contactClass);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Selecting '" + contactClass + "' as Contact Class");
	}
	
	@And("^Enter Contact Type as (.+)$")
	public void enter_contact_type(String contactType) throws Throwable {
		cc = new CustomerContact(ccb);
		boolean flag = cc.enterContactType(contactType);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Selecting '" + contactType + "' as Contact Type");
	}
	/*
	 * CP_CI.031 - 2020-06-19 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -CUSTOMER CONTACT- section			//////
	//////////////////////////////////////////////////////////////////
	/*
	 * CI.022 - 2020-04-16 - End Add
	 */
	
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -PAYMENT/TENDER SEARCH- section	//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * PY.005 - 2020-04-22 - Start Add
	 */
	
	@And("^Navigate to Payment/Tender Search page$")
	public void navigate_to_payment_tender_search() throws Throwable {
		paymentTenderSearch = new PaymentTenderSearch(ccb);
		boolean flag = paymentTenderSearch.open();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to Payment/Tender Search page...");
	}
	
	@And("^Select Search For as (.+)$")
	public void select_search_for(String searchFor) throws Throwable {
		paymentTenderSearch = new PaymentTenderSearch(ccb);
		boolean flag = paymentTenderSearch.selectSearchFor(searchFor);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Search For: " + searchFor);
	}
	
	@And("^Select Payment Account as (.+)$")
	public void select_payment_account(String paymentAccount) throws Throwable {
		paymentTenderSearch = new PaymentTenderSearch(ccb);
		boolean flag = paymentTenderSearch.selectPaymentAccount(paymentAccount);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting Payment Account: " + paymentAccount);
	}
	
	@And("^Enter Account ID as (.+)$")
	public void enter_account_id(String accountId) throws Throwable {
		paymentTenderSearch = new PaymentTenderSearch(ccb);
		boolean flag = paymentTenderSearch.enterAccountId(accountId);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Account ID: " + accountId);
	}
	
	@And("^Click Search Button of Payment/Tender Search$")
	public void search_button() throws Throwable {
		paymentTenderSearch = new PaymentTenderSearch(ccb);
		boolean flag = paymentTenderSearch.searchBtn();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed clicking search button");
	}
	/*
	 * PY.005 - 2020-04-22 - End Add
	 */
	
	
	//////////////////////////////////////////////////////////////////
	//////			End of -PAYMENT/TENDER SEARCH- section		//////
	//////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -SERVICE POINT- section			//////
	//////////////////////////////////////////////////////////////////
	/*
	 * CI.018 - 2020-04-23 - Start Add
	 */
	
	@Then("^Service Point record is saved (.+)$")
	public void save_service_point(String mode) throws Throwable {
		sp = new ServicePoint(ccb);
		boolean flag = sp.saveSP();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Saving Service Point record...");

		boolean idFlag = sp.checkIDExist(mode);
		hasError(idFlag);
		Assert.assertTrue(idFlag, "DPU - Failed Saving Service Point record...");
	}
	
	@And("^Enter SP Type as (.+)$")
	public void select_sp_type(String spType) throws Throwable {
		sp = new ServicePoint(ccb);
		boolean flag = sp.enterSpType(spType);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed selecting SP Type");
	}
	
	@And("^Enter Meter Location as (.+)$")
	public void enter_mtr_location(String location) throws Throwable {
		sp = new ServicePoint(ccb);
		boolean flag = sp.enterLocation(location);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Location");
	}
	
	@And("^Enter Service Cycle as (.+)$")
	public void enter_service_cycle(String serviceCycle) throws Throwable {
		sp = new ServicePoint(ccb);
		boolean flag = sp.enerServiceCycle(serviceCycle);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Service Cycle");
	}
	
	@And("^Enter Service Route as (.+)$")
	public void enter_service_route(String serviceRoute) throws Throwable {
		sp = new ServicePoint(ccb);
		boolean flag = sp.enerServiceRoute(serviceRoute);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Service Route");
	}
	/*
	 * CI.018 - 2020-04-23 - End Add
	 */
	
	/*
	 * CP_FS.009 - 2020-06-22 - Start Add
	 */
	@And("^Set SP Source Status to (.+)$")
	public void set_sp_source_status(String status) throws Throwable {
		sp = new ServicePoint(ccb);
		boolean flag = sp.setSPSourceStatus(status);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting SP Source Status as '" + status + "'");
	}
	
	@And("^Set Disconnect Location to (.+)$")
	public void set_disconnection_loc(String loc) throws Throwable {
		sp = new ServicePoint(ccb);
		boolean flag = sp.setDisconnectLoc(loc);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting Disconnect Location as '" + loc + "'");
	}
	
	@And("^Click Back Button in SP Page$")
	public void sp_clickBackButton() throws Throwable {
		sp = new ServicePoint(ccb);
		boolean flag = sp.clickBackButton();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed on clicking Back button on SP Page...");
	}
	
	@And("^SP Switch to Main Tab$")
	public void sp_switch_to_main_tab() throws Throwable {
		sp = new ServicePoint(ccb);
		boolean flag = sp.switchToTabMain();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed to Switch to SP - Main");
	}
	/*
	 * CP_FS.009 - 2020-06-22 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -SERVICE POINT- section				//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -START/STOP- section				//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * CP_CI.068 - 2020-07-14 - Start Add
	 */
	@And("^Verify RES CPP Order Completion$")
	public void verify_res_cpp_order_completion() throws Throwable {
		startStop = new StartStop(ccb);
    	boolean flag = startStop.verifyResCPPOrderCompletion();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Verifying RES CPP Order Completion...");
	}
	/*
	 * CP_CI.068 - 2020-07-14 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -START/STOP- section					//////
	//////////////////////////////////////////////////////////////////
	
	
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -PAYMENT- section					//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * PY.010 - 2020-04-24 - Start Add
	 */
	@And("^Click Cancel Button for Payment$")
	public void click_cancel_payment() throws Throwable {
		payment = new Payment(ccb);
    	boolean flag = payment.cancelPayment();
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Canceling the Payment...");
	}
	
	@And("^Select Cancel Reason for Payment as (.+)$")
	public void select_payment_cancel_reason(String reason) throws Throwable {
		payment = new Payment(ccb);
    	boolean flag = payment.selectCancelReason(reason);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Selecting Cancel Reason...");
	}
	
	/*
	 * CP_FIN.12 - 2020-06-03 - Start Add
	 */
	@And("^Distribute Amount (.+) to SAs$")
	public void distribute_amount_to_sa(String amount) throws Throwable {
		payment = new Payment(ccb);
    	boolean flag = payment.distributeAmountToSAs(amount);
		hasError(flag);
    	Assert.assertTrue(flag, "DPU - Failed Set Distribution Amount to SAs");
	}
	
	@And("^Distribute Payment$")
	public void distribute_payment() throws Throwable {
	payment = new Payment(ccb);
	boolean flag = payment.distribute_pmt();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Distribute Payment");
	}
	
	@And("^Freeze Payment$")
	public void freeze_paymentt() throws Throwable {
	payment = new Payment(ccb);
	boolean flag = payment.freeze_pmt();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed to Freeze Payment");
	}
	/*
	 * CP_FIN.12 - 2020-06-03 - End Add
	 */
	//////////////////////////////////////////////////////////////////
	//////			End of -PAYMENT- section					//////
	//////////////////////////////////////////////////////////////////
	/*
	 * PY.010 - 2020-04-24 - End Add
	 */

	//////////////////////////////////////////////////////////////////
	//////				Start of -PAY PLAN- section				//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * CP_CC.028 - 2020-07-01 - Start Add
	 */
	
	@And("^Enter (.+) as Pay Plan Type$")
	public void enter_payment_plan(String ppType) throws Throwable {
		payPlan = new PayPlan(ccb);
		boolean flag = payPlan.enterPPType(ppType);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Pay Plan Type...");
	}
	
	@And("^Set Pay Method as (.+)$")
	public void set_pay_method(String payMethod) throws Throwable {
		payPlan = new PayPlan(ccb);
		boolean flag = payPlan.setPayMethod(payMethod);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed setting Pay Method as '" + payMethod + "'");
	}
	
	@And("^Enter Scheduled Date as (.+)$")
	public void enter_sched_date(String schedDate) throws Throwable {
		payPlan = new PayPlan(ccb);
		boolean flag = payPlan.enterSchedDate(schedDate);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Scheduled Date: " + schedDate);
	}
	
	@And("^Enter Scheduled Amount as (.+)$")
	public void enter_sched_amt(String schedAmt) throws Throwable {
		payPlan = new PayPlan(ccb);
		boolean flag = payPlan.enterSchedAmt(schedAmt);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Scheduled Amount: " + schedAmt);
	}
	
	
	@And("^Enter Pay Plan Comments (.+)$")
	public void enter_pay_plan_comments(String comments) throws Throwable {
		payPlan = new PayPlan(ccb);
		boolean flag = payPlan.enterComment(comments);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed entering Pay Plan Comment '" + comments + "'");
	}
	
	@And("^Save Pay Plan$")
	public void save_pay_plan() throws Throwable {
		payPlan = new PayPlan(ccb);
		boolean flag = payPlan.savePayPlan();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Saving Pay Plan");
		
		boolean idFlag = payPlan.checkIDExist();
		hasError(idFlag);
		Assert.assertTrue(idFlag, "DPU - Failed Saving Pay Plan");
	}
	
	@And("^Navigate to Add Customer Contact from Pay Plan Account Context Menu$")
	public void nav_add_cc_from_pp_acct_cntx() throws Throwable {
		payPlan = new PayPlan(ccb);
		boolean flag = payPlan.navToAddCustomerContact();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to Add Customer Contact");
	}
	/*
	 * CP_CC.028 - 2020-07-01 - End Add
	 */
	
	/*
	 * CP_CI.031 - 2020-07-02 - Start Add
	 */
	@And("^Click on Cancel Pay Plan$")
	public void clickOnCancelPayPlan() throws Throwable {
		payPlan = new PayPlan(ccb);
		boolean flag = payPlan.cancelPayPlan();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Clicking Cancel Pay Plan");
	}
	/*
	 * CP_CI.031 - 2020-07-02 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////				End of -PAY PLAN- section				//////
	//////////////////////////////////////////////////////////////////	
	
	//////////////////////////////////////////////////////////////////
	//////	Start of -Supervisor To Do Assignment- section		//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * CP_CI.038 - 2020-07-06 - Start Add
	 */
	@And("^Navigate to Supervisor To Do Assignment Page$")
	public void navigate_to_supervisor_to_do_assignment() throws Throwable {
		supToDoAssignment = new SupervisorToDoAssignment(ccb);
		boolean flag = supToDoAssignment.open();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to Supervisor To Do Assignment Page...");
	}
	
	@And("^Search for To Do Type (.+)$")
	public void search_for_to_do_type(String toDoType) throws Throwable {
		supToDoAssignment = new SupervisorToDoAssignment(ccb);
		boolean flag = supToDoAssignment.searchForToDoType(toDoType);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Searching for To Do Type '" + toDoType + "'");
	}
	
	@And("^Filter Supervisor To Do Assignment By (.+)$")
	public void filter_supervisor_to_do_assignment_by(String filterBy) throws Throwable {
		supToDoAssignment = new SupervisorToDoAssignment(ccb);
		boolean flag = supToDoAssignment.filterAssignmentBy(filterBy);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Selecting Filter By '" + filterBy + "'");
	}
	
	@And("^Select To Do for Assignment$")
	public void select_to_do_for_assignment() throws Throwable {
		supToDoAssignment = new SupervisorToDoAssignment(ccb);
		boolean flag = supToDoAssignment.selectToDoForAssignment();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Selecting a To Do for Assignment");
	}
	
	@And("^Assign to Supervisor (.+)$")
	public void assign_to_supervisor(String user) throws Throwable {
		supToDoAssignment = new SupervisorToDoAssignment(ccb);
		boolean flag = supToDoAssignment.selectAssignee(user);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Selecting Supervisor as '" + user + "'");
	}
	
	/*
	 * CP_CI.038 - 2020-07-06 - End Add
	 */
	
	
	//////////////////////////////////////////////////////////////////
	//////	End of -Supervisor To Do Assignment- section		//////
	//////////////////////////////////////////////////////////////////
	
	/*
	 * TD.001 - 2020-04-30 - Start Add
	 */
	//////////////////////////////////////////////////////////////////
	//////			Start of -TO DO SUMMARY- section			//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Navigate to To Do Summary page$")
	public void navigate_to_to_do_summary() throws Throwable {
	toDoSummary = new ToDoSummary(ccb);
	boolean flag = toDoSummary.open();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed navigating to To Do Summary page...");
	}
	
	@And("^Select an Open To Do$")
	public void select_open_to_do() throws Throwable {
	toDoSummary = new ToDoSummary(ccb);
	boolean flag = toDoSummary.selectOpenToDo();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed selecting an open To Do...");
	}
	
	/*
	 * CP_CI.047 - 2020-07-02 - Start Add
	 */
	@And("^Navigate to To Do Summary page thru Dashboard link$")
	public void navigate_to_to_do_summary_via_dashboard_link() throws Throwable {
		toDoSummary = new ToDoSummary(ccb);
		boolean flag = toDoSummary.navToSummaryPageViaDashboard();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed navigating to To Do Summary page...");
	}
	/*
	 * CP_CI.047 - 2020-07-02 - End Add
	 */
	
	//////////////////////////////////////////////////////////////////
	//////			End of -TO DO SUMMARY- section				//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -TO DO LIST- section				//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Select To Do as (.+)$")
	public void select_to_do(String toDoId) throws Throwable {
	toDoList = new ToDoList(ccb);
	boolean flag = toDoList.selectToDo(toDoId);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed selecting To Do: "+toDoId);
	}
	
	//////////////////////////////////////////////////////////////////
	//////			End of -TO DO LIST- section					//////
	//////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////
	//////			Start of -TO DO ENTRY- section				//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Enter To Do Entry Comment as (.+)$")
	public void enter_comment(String comment) throws Throwable {
	toDoEntry = new ToDoEntry(ccb);
	boolean flag = toDoEntry.enterComment(comment);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed entering Comment: "+comment);
	}
	
	@And("^Click Complete Button for To Do Entry$")
	public void complete_to_do_entry() throws Throwable {
	toDoEntry = new ToDoEntry(ccb);
	boolean flag = toDoEntry.completeToDoEntry();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed completing To Do Entry");
	}
	
	
	@And("^Navigate to To Do Entry Add Page$")
	public void nav_to_to_do_entry_add() throws Throwable {
	toDoEntry = new ToDoEntry(ccb);
	boolean flag = toDoEntry.open();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed Navigating to To Do Entry Add Page...");
	}
	
	
	@And("^Create To Do with fields (.+), (.+), (.+), (.+), (.+) and (.+) with Account ID (.+)$")
	public void create_manual_to_do(String toDoType, String overridePrioty, String subject, String comment, String sendTo, String role, String acctID) throws Throwable {
	toDoEntry = new ToDoEntry(ccb);
	boolean flag = toDoEntry.createManualToDo(toDoType, overridePrioty, subject, comment, sendTo, role, acctID);
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed Creating a Manual To Do...");
	}
	/*
	 * TD.001 - 2020-04-30 - End Add
	 */
	
	/*
	 * TD.001 - 2020-07-27 - Start Add
	 */
	@And("^Navigate to To Do Entry Search$")
	public void nav_to_to_do_entry_search() throws Throwable {
		toDoEntry = new ToDoEntry(ccb);
		boolean flag = toDoEntry.search();
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Navigating to To Do Entry Search...");
	}
	
	@And("^Search To Do with ID (.+)$")
	public void search_to_do_with_id(String toDoID) throws Throwable {
		toDoEntry = new ToDoEntry(ccb);
		boolean flag = toDoEntry.searchWithID(toDoID);
		hasError(flag);
		Assert.assertTrue(flag, "DPU - Failed Searching for To Do with ID: " + toDoID);
	}
	/*
	 * TD.001 - 2020-07-27 - End Add
	 */
	
	
	//////////////////////////////////////////////////////////////////
	//////			End of -TO DO ENTRY- section				//////
	//////////////////////////////////////////////////////////////////
	
		
	//////////////////////////////////////////////////////////////////
	//////			Start of -TEMPORARY- section				//////
	//////////////////////////////////////////////////////////////////
	
	@And("^Select CPP for CIS Division$")
	public void select_cpp_for_cis_division() throws Throwable {
	boolean flag = control.setCPPCISDivision();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed selecting CPP as CIS Division");
	}
	
	@And("^Select CWD for CIS Division$")
	public void select_cwd_for_cis_division() throws Throwable {
	boolean flag = control.setCWDCISDivision();
	hasError(flag);
	Assert.assertTrue(flag, "DPU - Failed selecting CWD as CIS Division");
	}
	
	@And("^Log Test Name as (.+)$")
	public void log_test_name(String testName) throws Throwable {
		System.out.println("Starting Test Case: " + testName);
	}
	//////////////////////////////////////////////////////////////////
	//////			End of -TEMPORARY- section					//////
	//////////////////////////////////////////////////////////////////

}
