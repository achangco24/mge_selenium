package Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import features.TestConfig;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Commons.SetupEnvironment;
import aut.Ccb;
import aut.autopayarrangement.AutoPaymentArrangement;
import aut.breakpayarrangement.BreakPaymentArrangement;
import aut.controlcentral.ControlCentral;
import aut.menu.creditcoll.collection.Collection;
import aut.menu.creditcoll.severance.Severance;
import aut.menu.custinfo.person.Person;
import aut.menu.custinfo.premise.Premise;
import aut.menu.custinfo.sa.ServiceAgreement;
import aut.menu.custinfo.sp.ServicePoint;
import aut.menu.fieldorder.fa.FieldActivity;
import aut.menu.financial.adjustment.Adjustment;
import aut.menu.financial.bill.Bill;
import aut.menu.financial.deposit.DepositControl;
import aut.menu.financial.ft.FinancialTransaction;
import aut.menu.financial.paymentevent.PaymentEvent;
import aut.menu.meterread.read.MeterRead;
import aut.menu.salesmarketing.SalesMarketing;
import aut.menu.salesmarketing.order.Order;
import aut.menu.tool.batchjob.BatchJob;
import aut.tabs.characteristics.Characteristic;

@RunWith(Cucumber.class)
public class Test {

	private WebDriver driver;
	private WebDriverWait wait;
	private Ccb ccb;
	private ScreenShot screenshot;
	private ErrorHandle errorHandle;
	private LogFile logger;
	private Person person;
	private ControlCentral control;
	private Premise premise;
	private ServicePoint sp;
	private ServiceAgreement sa;
	private DepositControl deposit;
	private MeterRead mr;
	private FieldActivity fa;
	private Adjustment adjustment;
	private BreakPaymentArrangement breakPayArr;
	private AutoPaymentArrangement createPayArr;
	private Order order;
	private Collection collection;
	private Bill bill;
	private MeterRead meterRead;
	private Severance severance;
	private BatchJob batch;
	private PaymentEvent pay;
	private Severance severance2;
	
	@Before
	public void initialize() {
		SetupEnvironment env = new SetupEnvironment(this.getClass().getName());
		driver = env.getDriver();		
		screenshot = env.getScreenShot();
		wait = env.getWait();
		errorHandle =env.getErrorHandler();
		logger = env.getLogger();
		logger.log(this.getClass().getName() + ": Test Start");
	}

	@After
	public void cleanup() {
		logger.log(this.getClass().getName() + ": Test End");
		screenshot = null;
		driver = null;
		wait = null;
		errorHandle = null;
		logger = null;
//		adjustment = null;
	}
	
	@Given("^User is on CC&B$")
    public void user_is_on_ccb() throws Throwable {
    	ccb = new Ccb(driver, wait, TestConfig.implicitWait, errorHandle, logger, screenshot);
//		boolean flag = ccb.open(TestConfig.dpu27Pkg);
		boolean flag = ccb.open(TestConfig.dpu27Dev);
		person = new Person(ccb);
		Assert.assertTrue(flag, "DPU_C2J001 - Exception Error in Load CC&B");
	}

    
    @When("^User login into CC&B with (.+) and (.+)$")
    public void user_login_into_application_with_something_and_something(String username, String password) throws Throwable {
    	//try {
			ccb.login(username, password);
//    	} catch (Exception e) {
//    		logger.log("Exception on Logging in with: username: " + username + "password:" + password);
//    		logger.log(e);
//			Assert.fail("Exception Error in Logging in");
//		}
//    	String checkTitle = driver.getTitle();
//    	if(checkTitle.equals("Login")) {
//    		screenshot.capture();
//    		logger.log("WARNING", "Login Failure");
//    		driver.quit();
//    		Assert.fail("Failed Login");
//    	}
    }
    
    @And("^Logout$")
    public void logout() throws Throwable {
    	/*
    	try {
			ccb.logout();
			driver.quit();
		} catch (Exception e) {
			errorHandle.ExceptionHandle(screenshot, driver);
			logger.log(e);
    		Assert.fail("Failed to Logout");
		}
		**/
    }

//Lui 9/24: Test C2J007 & C2J008 - Person Handler Scenario
/*
    @Then("^Test$")
    public void test() throws Throwable {
    //Person Creation
    	boolean flag = false;
    	wait.until(ExpectedConditions.titleIs("User"));
    	Person person = new Person(ccb);
    	int personRow = 0;
    	flag = person.open();
    	person.enterPersonNameAtRow("Manda, Joy Anne", personRow);
    	person.selectContactTypeAtRow("Home Phone", personRow);
    	person.enterContactNumberAtRow("(485) 932-4920", personRow);
    	person.setContactAsPrimaryAtRow(personRow, true);
    	person.selectPersonIdTypeAtRow("Drivers license", personRow);
    	person.enterPersonIdNumberAtRow("725S7193510", personRow);
    	person.setIdentifierAsPrimaryAtRow(personRow, true);
    	person.setAddAccount(false);
    	person.savePerson();
    //Person Update (missing field validation)	
    	person.switchToCorrInfo();
    	person.setAddress1("Masagana Avenue");
    	person.setCity("Cleavland");
    	person.clearAddress1();
    	person.save();
    	person.clearCity();
    //
    }
*/
//Lui 10/01: Test CI.001AddPerAcct
/*
    @Then("^Test$")
    public void test() throws Throwable {
    	//driver.switchTo().frame("main");
		//driver.findElement(By.id("IM_controlCentralButton")).click();
    	boolean flag = false;
    	wait.until(ExpectedConditions.titleIs("User"));
		control = new ControlCentral(ccb);
		flag = control.open();
//		control.setSearchByAs("Account ID");
//		control.setAccount("3842343109");
		control.setSearchByAs("Name and Address");
		control.setName("Jose,Marie I");
		control.addPerson();
		int personRow = 0;
		person.selectPersonBusiness("Business");
		person.selectPersonBusiness("Person");
		person.selectContactTypeAtRow("Home Phone", personRow);
    	person.enterContactNumberAtRow("(485) 931-4920", personRow);
    	person.setContactAsPrimaryAtRow(personRow, true);
    	person.selectPersonIdTypeAtRow("Drivers license", personRow);
    	person.enterPersonIdNumberAtRow("725S7193511", personRow);
    	person.setIdentifierAsPrimaryAtRow(personRow, true);
    	person.setAddAccount(true);
    	person.savePerson();
		
//		control.searchAccount("3842343109");
//		control.addAccountBilling();
//		control.searchAccountBilling();
//		control.accountStartStop();
    }
*/
//Lui 10/01: Test CI.016 Create New Premise
/*
    @Then("^Test$")
    public void test() throws Throwable {
    	//driver.switchTo().frame("main");
		//driver.findElement(By.id("IM_controlCentralButton")).click();
    	boolean flag = false;
    	wait.until(ExpectedConditions.titleIs("User"));
    	Premise premise = new Premise(ccb);
    	flag = premise.open();
    	premise.selectPremiseTypeAs("Single family home");
    	premise.enterPostal("44111-5275");
    	premise.enterAddressAtLine(1, "3303 E 191TH ST (Test)");
    	premise.enterCity("CLEVELAND");
//    	premise.setCounty("Cuyahoga");
//    	premise.setState("OH");
    	premise.switchToTabChar();
    	premise.characteristics().setEffDateAt(0, "10-01-2019");
    	premise.characteristics().setCharTypeAt(0, "Abandoned Property");
    	premise.characteristics().setCharValAt(0, "NO");
    	premise.characteristics().addRow();
    	premise.characteristics().setEffDateAt(1, "10-01-2019");
    	premise.characteristics().setCharTypeAt(1, "City Code");
    	premise.characteristics().setCharValAt(1, "001000");
    	premise.characteristics().addRow();
    	premise.characteristics().setEffDateAt(2, "10-01-2019");
    	premise.characteristics().setCharTypeAt(2, "Solid Waste Dwelling Code");
    	premise.characteristics().setCharValAt(2, "00");
    	premise.characteristics().addRow();
    	premise.characteristics().setEffDateAt(3, "10-01-2019");
    	premise.characteristics().setCharTypeAt(3, "Household size");
    	premise.characteristics().setCharValAt(3, "6");
    	premise.characteristics().addRow();
    	premise.characteristics().setEffDateAt(4, "10-01-2019");
    	premise.characteristics().setCharTypeAt(4, "Property Status");
    	premise.characteristics().setCharValAt(4, "OCCU-AUTO");
    	premise.characteristics().addRow();
    	premise.characteristics().setEffDateAt(5, "10-01-2019");
    	premise.characteristics().setCharTypeAt(5, "Property Condition");
    	premise.characteristics().setCharValAt(5, "B1");
    	premise.characteristics().addRow();
    	premise.characteristics().setEffDateAt(6, "10-01-2019");
    	premise.characteristics().setCharTypeAt(6, "Type of Residence");
    	premise.characteristics().setCharValAt(6, "S");
    	premise.characteristics().addRow();
    	premise.characteristics().setEffDateAt(7, "10-01-2019");
    	premise.characteristics().setCharTypeAt(7, "Level");
    	premise.characteristics().setCharValAt(7, "C0");
    	premise.switchToTabGeo();
    	premise.geographicData().setGeoTypeAt(0, "Street Number");
    	premise.geographicData().setGeoValAt(0, "001");
//    	premise.geographicData().addRow();
    	premise.switchToTabMain();
//    	premise.setCity("CLEVELAND");
//    	premise.savePremise();
//    	FinancialTransaction ft = new FinancialTransaction(ccb);
//    	flag = ft.open();

//    	Set<String> id = driver.getWindowHandles();
//		Iterator<String> pages = id.iterator();
//		String main = pages.next();
//		String windows = pages.next();
//		driver.switchTo().window(windows);
//		
//		driver.findElement(By.id("overridelink")).click();

    	//driver.switchTo().window(driver.getWindowHandle());
//		ft.searchPopUpFinancialTransactionId("166337079888");
		
//    	driver.findElement(By.id("FT_ID")).sendKeys("166337079888");	//FT ID from pop-up
//    	driver.findElement(By.id("BU_Main_ftMainSrch")).click();		//Search btn from pop-up
    	
//    	driver.switchTo().window(main);
		
//    	ft.tabs().dashboard.switchTo();
//    	ft.clickDashBoardPremise();
//    	Premise premise = new Premise(ccb);
//    	premise.tabs().premiseChar.switchTo();
//    	System.out.println(premise.characteristics().count());
//    	List<Characteristic> data = premise.characteristics().getAll();
//    	for (int i = 0; i < data.size(); i++) {
//			System.out.println(data.get(i).getRowIndex());
//			System.out.println(data.get(i).getEffDate());
//			System.out.println(data.get(i).getType());
//			System.out.println(data.get(i).getValue());
//		}
//		premise = null;
//		ft = null;
    	
		//		Assert.assertTrue(flag, "Failed to open add FT page.");
	}
*/
//Lui 10/03: Test PY.001 Deposit Control
/*
    @Then("^Test$")
    public void test() throws Throwable {
    	boolean flag = false;
    	wait.until(ExpectedConditions.titleIs("User"));
		deposit = new DepositControl(ccb);
		flag = deposit.open();

		deposit.selectTenderSource("Online Cashiering");
		deposit.selectCurrencyCode("United States Dollars");
		deposit.enterComments("This is a Selenium Automation Test");
		deposit.save();	
    }
*/
//Lui 10/15: Test MT.003 - Meter Read
/*
    @Then("^Test$")
    public void test() throws Throwable {
    	wait.until(ExpectedConditions.titleIs("User"));
		control = new ControlCentral(ccb);
		control.open();
		control.setSearchByAs("Account ID");
		control.setAccount("8696333739");
		control.searchServicePoint();
		
		sp = new ServicePoint(ccb);
//		sp.enterSpType("TEST");
		sp.addMeterRead();
		
		mr = new MeterRead(ccb);
		mr.enterReadDate("10-13-2019");
		mr.registerRead().setReadTypeAt(0, "Regular");
		mr.registerRead().enterReadValueAt(0, "1");
		mr.saveMeterRead();
		
//		sp.searchPopUpSPId("spid");
//		control.accountStartStop();
    } */ 

//Lui 10/17: Test FS.001 - Field Activity
/*
    @Then("^Test$")
    public void test() throws Throwable {
    	wait.until(ExpectedConditions.titleIs("User"));
    	control = new ControlCentral(ccb);
    	control.open();
    	control.setSearchByAs("Account ID");
    	control.setAccount("8696333739");
    	control.addFieldActivity();
    	
		fa = new FieldActivity(ccb);
		fa.setFAType("INV-AMR");
		fa.setFAPriority("Priority 20");
		fa.enterSchedDate("10-17-2019");
		fa.enterDispatchGrp("201-SS");
		fa.enterComments("This is auto-generated made by Selenium Automation Tool");
		fa.saveFA();
    }
*/
//Lui 10/23: Test PY.020 - REF-W Adjustment
/*
    @Then("^Test$")
    public void test() throws Throwable {
    	wait.until(ExpectedConditions.titleIs("User"));
    	control = new ControlCentral(ccb);
    	control.open();
    	control.setSearchByAs("Account ID");
    	control.setAccount("0016010000");
    	control.addAdjustment();
    	
    	adjustment = new Adjustment(ccb);
    	adjustment.searchPopUpAdjustmentId("0016010636");
       	driver.switchTo().defaultContent();
       	driver.switchTo().frame("main");
       	driver.switchTo().frame("tabPage");
        //Javascript to handle Selenium Sendkeys that is not working after closing pop-up window.
       	adjustment.setAdjustmentType("REF-W");
       	adjustment.setAmount("5.55");
       	adjustment.enterComments("This is created by Selenium Automated Tool.");
       	adjustment.generateAdjustment();
       	adjustment.freezeAdjustment();
    }
*/    
//Lui 10/23: Test PY.022 - XFER Adjustment
/*
    @Then("^Test$")
    public void test() throws Throwable {
    	wait.until(ExpectedConditions.titleIs("User"));
    	control = new ControlCentral(ccb);
    	control.open();
    	control.setSearchByAs("Account ID");
    	control.setAccount("0016010000");
    	control.addAdjustment();
    	
    	adjustment = new Adjustment(ccb);
    	adjustment.searchPopUpAdjustmentId("0016010636");
       	driver.switchTo().defaultContent();
       	driver.switchTo().frame("main");
       	driver.switchTo().frame("tabPage");
        //Javascript to handle Selenium Sendkeys that is not working after closing pop-up window.
       	adjustment.setAdjustmentType("XFER");
       	adjustment.setAmount("5.55");
       	adjustment.enterComments("This is created by Selenium Automated Tool.");
       	adjustment.switchToTransAdj();
       	adjustment.setSAID2("7028049738");
       	adjustment.enterComments2("This is created by Selenium Automated Tool.");
       	adjustment.generateAdjustment();
       	adjustment.freezeAdjustment();
    }
*/    
//Lui 10/24: Test BreakPA
/*
    @Then("^Test$")
    public void test() throws Throwable {
    	wait.until(ExpectedConditions.titleIs("User"));
    	sa = new ServiceAgreement(ccb);
    	sa.search();
    	sa.searchPopUpSAId("5171873726");
    	sa.paymentArrangementBreak();
    	
    	breakPayArr = new BreakPaymentArrangement(ccb);
    	breakPayArr.breakPaymentArrangement();
    	//****************************************************
    	//* Incomplete step:
    	//* 	1. Need to know how to getText in table form
    	//*  2. Validate that Payment Arrangement SA has 0.00 balance
    	//****************************************************  	
    }
*/
//Lui 10/28: Test CC.018
/*
    @Then("^Test$")
    public void test() throws Throwable {
    	wait.until(ExpectedConditions.titleIs("User"));
    	control = new ControlCentral(ccb);
    	control.open();
    	control.setSearchByAs("Account ID");
    	control.setAccount("8924900000");
    	control.autoPaymentArrangement();
    	
    	createPayArr = new AutoPaymentArrangement(ccb);
    	createPayArr.enterInstallments("6");
    	createPayArr.createPaymentArrangement();

    	//****************************************************
    	//* Incomplete step:
    	//* 	1. Need to know how to getText in table form
    	//*  	2. Validate that Payment Arrangement SA has created
    	//****************************************************  	
    }
*/
//Lui 10/28: Test SS.007
/*
    @Then("^Test$")
    public void test() throws Throwable {
    	wait.until(ExpectedConditions.titleIs("User"));
//    	control = new ControlCentral(ccb);
//    	control.open();
//    	control.setSearchByAs("Account ID");
//    	control.setAccount("8924900000");
//    	control.autoPaymentArrangement();
    	
    	premise = new Premise(ccb);
    	premise.search();
    	premise.searchPopUpPremId("7533718358");
    	premise.switchToTabChar();
    	premise.addOrder();

    	order = new Order(ccb);
//    	order.open();
//    	order.switchToQuestionMisc();
//    	order.switchToMain();
    	order.enterName("Yaeger, Yehyeh II");
    	order.save();
    	order.switchToQuestionMisc();
    	order.showEligibility();
//    	order.switchToMain();

//    	order = new Order(ccb);
//    	order.search();
//    	order.searchPopUpOrderId("034197281886");
//    	order.switchToQuestionMisc();
//    	order.showEligibility();
    	order.showOrderPackage();
    	order.completeOrderPackage();
 */   	
    	//****************************************************
    	//* Incomplete step:
    	//* 	1. Need to know how to getText in table form
    	//*  	2. Validate that Payment Arrangement SA has created
    	//*  	3. Problem in completion
    	//*  	4. Batch missing
    	//****************************************************  	
/*    }
*/    


//Lui 11/01: Test SS.007
//Sonny 11/07
/*    @Then("^Test$")
    public void test() throws Throwable {
    	wait.until(ExpectedConditions.titleIs("User"));
    	collection = new Collection(ccb);
    	collection.search();
    	collection.searchPopUpCollId("9584212355");
    	List <String> col = collection.collectionTable();
    	int listSize = col.size();
    	System.out.println(col.size());
    	
    	
    	for (int i = 0; i < listSize;i++) {
    	BatchJob batch = new BatchJob(ccb);
    	batch.open();
    	batch.enterBatchCode("CET");
    	batch.enterBatchDate(col.get(i));
    	batch.checkStatus();
    	}
    	List <String> checker = collection.collectionTable();
    	if(checker.size() == 0) {
    		System.out.println("There are no more Pending events remaining.");
    	}
    	else {
    		System.out.println("Completion of events failed.");
    	}
    	//*[@id="tStart"]/tbody/tr[2]
    }
 */
//Sonny 11/07: Test BL.001
//    @Then("^Test$")
//    public void test() throws Throwable {
//    	wait.until(ExpectedConditions.titleIs("User"));
//    	control = new ControlCentral(ccb);
//    	control.open();
//    	control.setSearchByAs("Account ID");
//    	control.setAccount("3072140000");
//    	control.addAccountBilling();
//    	
//    	bill = new Bill(ccb);
//    	bill.generateBill();
//    	bill.generatePopup("02-28-2019");
//    	bill.freezeBill();
//    	bill.calcLines();
//    	
//    }
//Sonny 11/11: Test BL.008    
    @Then("^Test$")
    public void test() throws Throwable {
    	wait.until(ExpectedConditions.titleIs("User"));
    	control = new ControlCentral(ccb);
    	control.open();
    	control.setSearchByAs("Account ID");
    	control.setAccount("7884310000");
    	control.lastMeterRead();
    	
    	meterRead = new MeterRead(ccb);
    	meterRead.addMeterReading("29");
    	
    	bill = new Bill(ccb);
    	bill.cancelRebillFreeze();
    }
 
//Sonny 11/13: Test BL.008      
//    @Then("^Test$")
//    public void test() throws Throwable {
//    	wait.until(ExpectedConditions.titleIs("User"));
//    	severance = new Severance(ccb);
//    	severance.search();
//    	severance.severancePopSearchID("5966794645");
//    	severance.selectAwaitingFieldActivity();
//
//    	fa = new FieldActivity(ccb);
//    	fa.findPendingFA();
//    	fa.completeFA();
//    	
//    	batch = new BatchJob(ccb);
//    	batch.open();
//    	batch.enterBatchCode("SEC"); 
//    	batch.enterBatchDate("01-25-2019"); 
//    	batch.clickDQ(); 
//    	batch.checkBatchStatus("Ended");
//    	
//    	batch.enterBatchCode("SED"); 
//    	batch.clickDQ(); 
//    	batch.checkBatchStatus("Ended");
//    	
//    	batch.enterBatchCode("SET"); 
//    	batch.clickDQ(); 
//    	batch.checkBatchStatus("Ended");
//    	
//    	severance2 = new Severance(ccb);
//    	severance2.search2();
//    	severance2.severancePopSearchID("5966794645");
//    	
//    }
//    @Then("^Test$")
//    public void test() throws Throwable {
//    	wait.until(ExpectedConditions.titleIs("User"));
//    	severance = new Severance(ccb);
//    	severance.search();
//    	severance.severancePopSearchID("8512738854");
//    	severance.goToControlCentral();
//    	severance.goToServiceAgreement();
//    	
//    	sa = new ServiceAgreement(ccb);
//    	sa.selectSA();
//    	sa.addPayment();
//    	
//    	pay = new PaymentEvent(ccb);
//    	pay.addPaymentEvent("500");
//    	severance.selectLast();
//    }
}