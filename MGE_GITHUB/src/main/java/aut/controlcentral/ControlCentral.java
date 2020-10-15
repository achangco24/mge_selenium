/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Control Central
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-17	GSando	MT.003. Add components for add a meter read.  
 * 2020-04-21	GSando	FS.002. Add components for updating Existing FA 
 * 								Scheduled Date
 * 2020-04-23	GSando	CI.018. Add components for adding a Service Point Record
 * 								to a Premise
 * 2020-04-24	GSando	PY.010. Add components for canceling a Payment
 * 
 * 2020-05-05	RExtra	CP_CC.003	Add components for Adding a Collection Process
 * 2020-05-05	RExtra	CP_CC.005	Add components for Adding a Severance Process
 * 2020-05-12	RExtra	CP_CC.007	Add components for Adding a Write Off Process
 * 2020-05-12	RExtra	CP_CC.010	Add components for Canceling a Collection Process
 * 2020-05-12	RExtra	CP_CC.013	Add components for Canceling a Severance Process
 * 2020-05-13	RExtra	CP_CC.015	Add components for Canceling a Write Off Process
 * 2020-05-13	RExtra	CP_CC.019	Add components for Manually Adding Credit Points
 * 2020-06-01	RExtra	CP_FIN.01	Add components for Adding an Adjustment
 * 2020-06-03	RExtra	CP_BI.014	Add components for Setting a Maximum Bill 
 * 									Threshold
 * 2020-06-17	RExtra	CP_CI.022	Add components for Creating a Deposit SA
 * 2020-06-19	RExtra	CP_CI.031	Add components for Adding a Customer Contact
 * 2020-06-30	RExtra	CP_CC.002	Add components to Add Collection Agency Referral
 * 2020-07-01	RExtra	CP_CC.028	Add components to Add Pay Plan
 * 2020-07-02	RExtra	CP_CI.031	Add components to Cancel Pay Plan
 * 2020-07-07	RExtra	CP_BI.001	Add components to Manually Generate a Bill
 * 2020-07-08	RExtra	CP_BI.002	Add components to CancelRebilling a Bill
 * 									Segment
 * 2020-07-09	RExtra	CP_FIN.26	Add components for Transferring of Balance
 * 2020-07-13	RExtra	CP_CI.030	Add components for Adding a Payment Arrangement
 * 									Request
 * 2020-10-12	JMalayo	CP.3.1.9.B	Manage Customer Inquiries/Complaint - PSCW
 * 									Complaints
 *************************************************************************************
 */
package aut.controlcentral;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.dashboard.Dashboard;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;


public class ControlCentral extends Entity{
	private ControlCentralObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	
	public ControlCentral(Ccb ccb){
		this.pageTitle = "Control Central";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();

		
		initialize(ccb);	
		this.ccb = ccb;	
		repo = new ControlCentralObjects(ccb.getDriver(), ccb.getCcbFrames());
	}

	public boolean open() throws Exception {
		try {
			Thread.sleep(3000);
			try {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(commons.controlCentral.toWebElement()));
				commons.controlCentral.toWebElement().click();
			}catch(Exception e) {
				driver.switchTo().parentFrame();
				wait.until(ExpectedConditions.elementToBeClickable(commons.controlCentral.toWebElement()));
				commons.controlCentral.toWebElement().click();
			}

			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Control Central Page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setSearchByAs(String search) throws Exception {
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.searchBy.toWebElement()));
			repo.searchBy.selectTextAs(search);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Search By value: " + search);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setAccount(String account) throws Exception {
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.account.toWebElement()));
			repo.account.toWebElement().sendKeys(account);
			search();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to search Account Id: " + account);
			logger.log(e);
			return false;
		}
	}
	
	public boolean searchByName(String name) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.name.toWebElement()));
			repo.name.toWebElement().sendKeys(name + "%");
			search();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to search Name: " + name);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setName(String name) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.name.toWebElement()));
			repo.name.toWebElement().sendKeys(name);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Name: " + name);
			logger.log(e);
			return false;
		}
	}
	
	public boolean addPersonBtn() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.addPersonBtn.toWebElement()));
			repo.addPersonBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Add Person via Control Central");
			logger.log(e);
			return false;
		}
	}
	
	public boolean search() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.searchBtn.toWebElement()));
			repo.searchBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to search in Control Central");
			logger.log(e);
			return false;
		}
	}
	
	public boolean openPersonContextMenu() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.personContextMenu.toWebElement()));
			repo.personContextMenu.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Person context menu.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean openAccountContextMenu() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.accountContextMenu.toWebElement()));
			repo.accountContextMenu.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Account context menu.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean openPremiseContextMenu() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.premiseContextMenu.toWebElement()));
			repo.premiseContextMenu.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Premise context menu.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addAccountBilling()throws Exception{
		try {
			openAccountContextMenu();
			repo.billMenu.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate to Add Account Billing");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CC.003 - 2020-05-05 - Start Add
	 */
	public boolean addCollectionProcess()throws Exception{
		try {
			openAccountContextMenu();
			repo.collectionProcess.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate to Add Collection Process");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CC.003 - 2020-05-05 - End Add
	 */
	
	public void searchAccountBilling()throws Exception{
		openAccountContextMenu();
		repo.billMenu.toWebElement().click();
		repo.search.toWebElement().click();
	}

	public void accountStartStop() throws Exception {
		openAccountContextMenu();
		repo.startStopMenu.toWebElement().click();
	}
	
	public boolean searchServicePoint() throws Exception {
		try {
			openPremiseContextMenu();
			repo.spMenu.toWebElement().click();
			repo.search.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Premise context menu > Service Point > Search...");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addFieldActivity() throws Exception {
		try {
			openPremiseContextMenu();
			repo.faMenu.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Premise context menu > Field Activity > Add...");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addOrder() throws Exception {
		try {
			openPremiseContextMenu();
			repo.orderMenu.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Premise context menu > Go To Order > Add...");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addAdjustment() throws Exception {
		try {
			openAccountContextMenu();
			repo.adjMenu.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Account context menu > Adjsutment > Add...");
			logger.log(e);
			return false;
		}
	}
	
	public boolean autoPaymentArrangement() throws Exception {
		try {
			openAccountContextMenu();
			repo.autoPayArrMenu.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Account context menu > Automated Payment Arrangement...");
			logger.log(e);
			return false;
		}
	}
	
	public boolean captureSaPremiseListDashboard() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.SaPremiseListTbl.toWebElement()));
			repo.SaPremiseListTbl.toWebElement().click();
			screenshot.capture();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to capture SA Premise List table under Account Information...");
			logger.log(e);
			return false;
		}
	}

	public boolean lastMeterRead() throws Exception {
		List <WebElement> tableRows = repo.premiseInfoTable.toWebElement().findElements(By.xpath("//*[@id='data_2']/table/tbody/tr"));
		int tableSize = tableRows.size();
		try {
			for(int i = 0; i<tableSize;i++) {
				WebElement row = driver.findElement(By.xpath("//*[@id='data_2']/table/tbody/tr[" + (i+1) +"]/td[2]"));
				if(row.getAttribute("innerHTML").equalsIgnoreCase("Last Meter Read")){
					WebElement lastMeterRead = driver.findElement(By.xpath("//*[@id='data_2']/table/tbody/tr[" + (i+1) +"]/td[1]/img"));
					wait.until(ExpectedConditions.elementToBeClickable(lastMeterRead));
					lastMeterRead.click();
					break;
				}
			}

			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Last Meter Read");
			logger.log(e);
			return false;
		}
	}

	public boolean expandPremiseTree() throws Exception {
		List <WebElement> tableRows = repo.premTreeTbl.toWebElement().findElements(By.xpath("/html/body/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/div/table"));
		int tableSize = tableRows.size();
		try {
			for(int i = 0; i<tableSize;i++) {
				WebElement row = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/div/table[" + (i+1) +"]/tbody/tr[1]/td[1]/img"));
				row.click();
				WebElement row2 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/div/table[" + (i+1) +"]/tbody/tr[2]/td[2]/div/table/tbody/tr[1]/td[1]/img"));
				row2.click();
			}
			screenshot.capture();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to expand Premise Tree record...");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * MT.003 - 2020-04-17 - Start Add
	 */
	public boolean selectSpTypeAndStatus(String spType, String spStatus) throws Exception{
		try {
			Thread.sleep(5000);
			String main = driver.getWindowHandle();
			int windows = driver.getWindowHandles().size();

			if(windows == 2){
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				Set<String> windowHandles = driver.getWindowHandles();
				String popWindow = "";
				int i = 0;
				for (String windowHandle : windowHandles) {
					i += 1;
					if (!main.equalsIgnoreCase(windowHandle)) {
						popWindow = windowHandle;
					}
				}
				
				if (popWindow != null) {
					driver.switchTo().window(popWindow);
				}else {
					return false;
				}
				
				WebDriverWait popWait = new WebDriverWait(driver, 10);
				if(isElementPresent(repo.moreInfo.getLocator())){
					popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
					repo.moreInfo.toWebElement().click();
					popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
					repo.overridelink.toWebElement().click();
				}
				
				popWait.until(ExpectedConditions.visibilityOf(repo.stateTable.toWebElement()));
				List <WebElement> tableRows = repo.stateTable.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
				int tableSize = tableRows.size();
				for(int x = 0; x < tableSize; x++) {
					WebElement type = driver.findElement(By.xpath("//*[@id='dataTableBody']/tr[" + (x+1) +"]/td[2]/span"));
					WebElement status = driver.findElement(By.xpath("//*[@id='dataTableBody']/tr[" + (x+1) +"]/td[4]/span"));
					wait.until(ExpectedConditions.elementToBeClickable(type));
					
					if(type.getText().equalsIgnoreCase(spType) && status.getText().equalsIgnoreCase(spStatus)){
						type.click();
						Thread.sleep(5000);
						break;
					}
				}
				driver.switchTo().window(main);
				return true;
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to search SP with SP Type: " + spType + " and SP Status: "+ spStatus);
			logger.log(e);
			return false;
		}
	}
	/*
	 * MT.003 - 2020-04-17 - End Add
	 */
	
	/*
	 * FS.002 - 2020-04-21 - Start Add
	 */
	public boolean searchFieldActivity() throws Exception {
		try {
			openPremiseContextMenu();
			repo.faMenu.toWebElement().click();
			repo.search.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Premise context menu > Field Activity > Search...");
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectFaStatus(String faStatus) throws Exception {
		try {
			String main = driver.getWindowHandle();
			int windows = driver.getWindowHandles().size();

			if(windows == 2){
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				Set<String> windowHandles = driver.getWindowHandles();
				String popWindow = "";
				for (String windowHandle : windowHandles) {
					if (!main.equalsIgnoreCase(windowHandle)) {
						popWindow = windowHandle;
					}
				}
				
				if (popWindow != null) {
					driver.switchTo().window(popWindow);
				}else {
					return false;
				}
				
				WebDriverWait popWait = new WebDriverWait(driver, 10);
				if(isElementPresent(repo.overridelink.getLocator())){
					popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
					repo.overridelink.toWebElement().click();
				}
				
				popWait.until(ExpectedConditions.visibilityOf(repo.stateTable.toWebElement()));
				List <WebElement> tableRows = repo.stateTable.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
				int tableSize = tableRows.size();
				for(int x = 0; x < tableSize; x++) {
					WebElement  status = driver.findElement(By.xpath("//*[@id='dataTableBody']/tr[" + (x+1) +"]/td[5]/span"));
					wait.until(ExpectedConditions.elementToBeClickable(status));
					if(status.getText().equalsIgnoreCase(faStatus)){
						status.click();
						break;
					}
				}
				driver.switchTo().window(main);
				return true;
			}
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to search FA Status: " + faStatus);
			logger.log(e);
			return false;
		}
	}
	/*
	 * FS.002 - 2020-04-21 - End Add
	 */
	
	/*
	 * CI.018 - 2020-04-23 - Start Add
	 */
	public boolean selectSp(String spId) throws Exception {
		try {
			String main = driver.getWindowHandle();
			int windows = driver.getWindowHandles().size();

			Thread.sleep(3000);
			if(windows == 2){
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				Set<String> windowHandles = driver.getWindowHandles();
				String popWindow = "";
				for (String windowHandle : windowHandles) {
					if (!main.equalsIgnoreCase(windowHandle)) {
						popWindow = windowHandle;
					}
				}
				
				if (popWindow != null) {
					driver.switchTo().window(popWindow);
				}else {
					return false;
				}
				System.out.println("A");
				
				WebDriverWait popWait = new WebDriverWait(driver, 10);
				if(isElementPresent(repo.overridelink.getLocator())){
					System.out.println("B");
					popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
					repo.overridelink.toWebElement().click();
					System.out.println("C");
				}
				System.out.println("D");
				
				popWait.until(ExpectedConditions.visibilityOf(repo.stateTable.toWebElement()));
				List <WebElement> tableRows = repo.stateTable.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
				int tableSize = tableRows.size();
				for(int x = 0; x < tableSize; x++) {
					WebElement servicePointId = driver.findElement(By.xpath("//*[@id='dataTableBody']/tr[" + (x+1) +"]/td[5]/span"));
					wait.until(ExpectedConditions.elementToBeClickable(servicePointId));
					if(servicePointId.getText().equalsIgnoreCase(spId)){
						servicePointId.click();
						break;
					}
				}
				driver.switchTo().window(main);
				return true;
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to search SP: " + spId);
			logger.log(e);
			return false;
		}
	}
	/*
	 * CI.018 - 2020-04-23 - End Add
	 */
	
	/*
	 * PY.010 - 2020-04-24 - Start Add
	 */
	public boolean searchPayment() throws Exception {
		try {
			openAccountContextMenu();
			repo.paymentMenu.toWebElement().click();
			repo.search.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Account context menu > Payment > Search...");
			logger.log(e);
			return false;
		}
	}

	public boolean selectPaymentStatus(String paymentStatus) throws Exception{
		try {
			Thread.sleep(5000);
			String main = driver.getWindowHandle();
			int windows = driver.getWindowHandles().size();
			
			if(windows == 2){
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				Set<String> windowHandles = driver.getWindowHandles();
				String popWindow = "";
				int i = 0;
				for (String windowHandle : windowHandles) {
					i += 1;
					if (!main.equalsIgnoreCase(windowHandle)) {
						popWindow = windowHandle;
					}
				}
				
				if (popWindow != null) {
					driver.switchTo().window(popWindow);
				}else {
					return false;
				}
				
				WebDriverWait popWait = new WebDriverWait(driver, 10);
				if(isElementPresent(repo.moreInfo.getLocator())){
					popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
					repo.moreInfo.toWebElement().click();
					popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
					repo.overridelink.toWebElement().click();
				}
				
				popWait.until(ExpectedConditions.visibilityOf(repo.stateTable.toWebElement()));
				List <WebElement> tableRows = repo.stateTable.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
				int tableSize = tableRows.size();
				for(int x = 0; x < tableSize; x++) {
					WebElement status = driver.findElement(By.xpath("//*[@id='dataTableBody']/tr[" + (x+1) +"]/td[4]/span"));
					wait.until(ExpectedConditions.elementToBeClickable(status));
					if(status.getText().equalsIgnoreCase(paymentStatus)){
						status.click();
						break;
					}
				}
				driver.switchTo().window(main);
				return true;
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to search Payment with Payment Status: " + paymentStatus);
			logger.log(e);
			return false;
		}
	}
	/*
	 * PY.010 - 2020-04-24 - End Add
	 */
	
	/*
	 * CP_CC.005 - 2020-05-05 - Start Add
	 */
	public boolean openSAInfoContextMenu() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.saInfoContextMenu.toWebElement()));
			repo.saInfoContextMenu.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click SA Info Context Menu.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addSeveranceThruSAContextMenu() throws Exception {
		try {
			openSAInfoContextMenu();
			repo.severanceProcessMenu.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate to Add Severance Process");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CC.005 - 2020-05-05 - End Add
	 */
	
	/*
	 * CP_CC.007 - 2020-05-12 - Start Add
	 */
	public boolean addWriteOffProcess()throws Exception{
		try {
			openAccountContextMenu();
			repo.writeOffProcess.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate to Add Write Off Process");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CC.007 - 2020-05-12 - End Add
	 */
	
	
	/*
	 * CP_CC.010 - 2020-05-12 - Start Add
	 */
	public boolean navToCollProcViaDashAlert() throws Exception {
		try {
			Thread.sleep(3000);
			Dashboard dashboard = new Dashboard(ccb);
	    	dashboard.clickAlertLinkWithText("Collection Process Active"); 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Collection Process via Dashboard Alert");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CC.010 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.013 - 2020-05-12 - Start Add
	 */
	public boolean navToSevProcViaDashAlert() throws Exception {
		try {
			Dashboard dashboard = new Dashboard(ccb);
	    	dashboard.clickAlertLinkWithText("Severance Process Active"); 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Severance Process via Dashboard Alert");
			logger.log(e);
			return false;
		}
	}
	 
	/*
	 * CP_CC.013 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.015 - 2020-05-13 - Start Add
	 */
	public boolean navToWOProcViaDashAlert() throws Exception {
		try {
			Dashboard dashboard = new Dashboard(ccb);
	    	dashboard.clickAlertLinkWithText("Active Write Off Process"); 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Write Off Process via Dashboard Alert");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CC.015 - 2020-05-13 - End Add
	 */
	
	
	/*
	 * CP_CC.019 - 2020-05-13 - Start Add
	 */
	public boolean navToAccountThruContextMenu() throws Exception {
		try {
			openAccountContextMenu();
			repo.autoPayArrMenu.toWebElement().sendKeys(Keys.UP, Keys.ENTER);;
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Account thru Context Menu");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CC.019 - 2020-05-13 - End Add
	 */
	
	/*
	 * CP_FIN.01 - 2020-06-01 - Start Add
	 */
	public boolean addAdjustmentThruSAContextMenu() throws Exception {
		try {
			openSAInfoContextMenu();
			
			
			
			repo.adjustmentMenu.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate to Add an Adjustment");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_FIN.01 - 2020-06-01 - End Add
	 */
	
	/*
	 * CP_FIN.02 - 2020-06-01 - Start Add
	 */
	public boolean navToSAFinHistThruSAContextMenu() throws Exception {
		try {
			openSAInfoContextMenu();
			repo.saFinancialHistory.toWebElement().click();;
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate to SA Financial History");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_FIN.02 - 2020-06-01 - End Add
	 */
	
	/*
	 * CP_FIN.08 - 2020-06-02 - Start Add
	 */
	
	public boolean addPaymentEventThruAcctContextMenu() throws Exception {
		try {
			openAccountContextMenu();
			repo.paymentEventMenu.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate to Add Payment Event");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_FIN.08 - 2020-06-02 - End Add
	 */
	
	/*
	 * CP_FIN.10 - 2020-06-02 - Start Add
	 */
	
	public boolean searchPaymentEentThruAcctContextMenu() throws Exception {
		try {
			openAccountContextMenu();
			repo.paymentEventMenu.toWebElement().click();
			repo.search.toWebElement().click();
			
			String main = driver.getWindowHandle();
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> windowHandles = driver.getWindowHandles();
			String popWindow = "";
			for (String windowHandle : windowHandles) {
				if (!main.equalsIgnoreCase(windowHandle)) {
					popWindow = windowHandle;
				}
			}
			
			if (popWindow != null) {
				driver.switchTo().window(popWindow);
			}else {
				return false;
			}
			
			if(isElementPresent(repo.overridelink.getLocator())){
				wait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			
			
			wait.until(ExpectedConditions.visibilityOf(repo.paymentEvtTable.toWebElement()));
			List <WebElement> tableRows = repo.paymentEvtTable.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
			int tableSize = tableRows.size();
			for(int x = 0; x < tableSize; x++) {
				WebElement row = driver.findElement(By.xpath("//*[@id='SEARCH_RESULTS:" + x + "$PAY_STATUS_DESCR']"));
				if(row.getText().equals("Frozen")){
					wait.until(ExpectedConditions.elementToBeClickable(row));
					row.click();
					break;
				}
					
			}
			
			
			driver.switchTo().window(main);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate to Add Payment Event");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_FIN.10 - 2020-06-02 - End Add
	 */
	
	
	/*
	 * CP_BI.014 - 2020-06-03 - Start Add
	 */
	public boolean navToSAThruSAContextMenu() throws Exception {
		try {
			openSAInfoContextMenu();
			repo.saMenu.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Service Agreement");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_BI.014 - 2020-06-03 - End Add
	 */
	
	
	/*
	 * CP_CI.022 - 2020-06-17 - Start Add
	 */
	public boolean navToAddSAThruAcctContextMenu() throws Exception {
		try {
			openAccountContextMenu();
			repo.acct_saMenu.toWebElement().click();
			repo.add.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Add Service Agreement");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.022 - 2020-06-17 - End Add
	 */
	
	/*
	 * CP_FIN.26 - 2020-07-09 - Start Add
	 */
	public boolean navToSearchSAThruAcctContextMenu() throws Exception {
		try {
			openAccountContextMenu();
			repo.acct_saMenu.toWebElement().click();
			repo.search.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Search Service Agreement thru Account Context Menu");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_FIN.26 - 2020-07-09 - End Add
	 */
	
	
	/*
	 * CP_CI.031 - 2020-06-19 - Start Add
	 */
	public boolean navToAddCustConThruPerContextMenu() throws Exception {
		try {
			openPersonContextMenu();
			repo.per_CustConMenu.toWebElement().click();
			repo.add.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Add Customer Contact");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.031 - 2020-06-19 - End Add
	 */
	
	/*
	 * CP_CC.002 - 2020-06-30 - Start Add
	 */
	public boolean navToAddCollAgencyReferral() throws Exception {
		try {
			openAccountContextMenu();
			repo.collAgencyReferralMenu.toWebElement().click();
			repo.add.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Add Collection Agency Referral");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CC.002 - 2020-06-30 - End Add
	 */
	
	/*
	 * CP_CC.028 - 2020-07-01 - Start Add
	 */
	public boolean navToAddPayPlan() throws Exception {
		try {
			openAccountContextMenu();
			repo.payPlanMenu.toWebElement().click();
			repo.add.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Add Pay Plan");
			logger.log(e);
			return false;
		}
	}
	/*
	/*
	 * CP_CC.028 - 2020-07-01 - End Add
	 */
	
	/*
	 * CP_CI.031 - 2020-07-02 - Start Add
	 */
	public boolean navToPayPlanViaDashAlert() throws Exception {
		try {
			Thread.sleep(3000);
			Dashboard dashboard = new Dashboard(ccb);
	    	dashboard.clickAlertLinkWithText("1 Active pay plans in the last 12 months"); 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Pay Plan via Dashboard Alert");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CI.031 - 2020-07-02 - End Add
	 */
	
	/*
	 * CP_BI.001 - 2020-07-07 - Start Add
	 */
	public boolean navToMeterConfig() throws Exception {
		try {
			List <WebElement> tableRows = repo.premiseInfoTable.toWebElement().findElements(By.xpath("//*[@id='data_2']/table/tbody/tr"));
			int tableSize = tableRows.size();
			
			for(int i = 1; i<tableSize;i++) {
				WebElement item = driver.findElement(By.xpath("//*[@id='CILCPIZP." + i + ".1']"));
				if(item.getAttribute("innerHTML").equalsIgnoreCase("Meter Configuration")){
					WebElement meterConfig = driver.findElement(By.xpath("//*[@id='data_2']/table/tbody/tr[" + i + "]/td[1]/img"));
					wait.until(ExpectedConditions.elementToBeClickable(meterConfig));
					meterConfig.click();
					
					repo.meterReadMenu.toWebElement().click();
					repo.add.toWebElement().click();
					break;
				}
			}
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Add Meter Read");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_BI.001 - 2020-07-07 - End Add
	 */
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	public boolean navToMeterItemSearch() throws Exception {
		try {
			openPremiseContextMenu();
			wait.until(ExpectedConditions.elementToBeClickable(repo.meterItemSearchMenu.toWebElement()));
			repo.meterItemSearchMenu.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Add Meter Read");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	/*
	 * CP_CI.030 - 2020-07-13 - Start Add
	 */
	public boolean navToAddPaymentArrangementRequest() throws Exception {
		try {
			String main = driver.getWindowHandle();
			openAccountContextMenu();
			wait.until(ExpectedConditions.elementToBeClickable(repo.pmtArrReqMenu.toWebElement()));
			repo.pmtArrReqMenu.toWebElement().click();
			repo.add.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Add Payment Arrangment Request thru Account Context Menu");
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectPmtArrReqType(String payArrReqType) throws Exception {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(repo.pmtArrReqType.toWebElement()));
			repo.pmtArrReqType.selectTextAs(payArrReqType);
			wait.until(ExpectedConditions.elementToBeClickable(repo.uiMapOkBtn.toWebElement()));
			repo.uiMapOkBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Payment Arrangment Request Type as '" + payArrReqType + "'");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.030 - 2020-07-13 - End Add
	 */
	
	/*
	 * SEC.001 - 2020-07-29 - Start Add
	 */
	public boolean enterAddress(String address) throws Exception {
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.address.toWebElement()));
			repo.address.toWebElement().sendKeys(address);
			search();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Search Address '" + address + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean verifyAddress(String IDs) throws Exception {
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.resultTable.toWebElement()));
			List <WebElement> tableRows = repo.resultTable.toWebElement().findElements(By.xpath("//*[@id='dataExplorerTableBody1']/tr"));
			int tableSize = tableRows.size();
			List<String> premIDList = Arrays.asList(IDs.split("~"));
						
			for(int i = 1; i<=tableSize;i++) {
				String currentPremID = driver.findElement(By.xpath("//*[@id='dataExplorerTableBody1']/tr[" + i + "]/td[5]")).getText();
				
				if(!premIDList.contains(currentPremID)){
					System.out.println("Premise ID '" + currentPremID + "' is an Unexpected Data");
					return false;
				}
			}
			
			System.out.println("Successfully Verified Address Search by CWD - CIS Division");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Verify Address");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * SEC.001 - 2020-07-29 - End Add
	 */
	
	/*
	 * Start of Temporary Block
	 */	
	public boolean setCPPCISDivision() throws Exception {
		try {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.cisDivision.toWebElement()));
			repo.cisDivision.selectTextAs("Cleveland Public Power");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select CPP as CIS Division");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setCWDCISDivision() throws Exception {
		try {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.cisDivision.toWebElement()));
			repo.cisDivision.selectTextAs("Cleveland");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select CWD as CIS Division");
			logger.log(e);
			return false;
		}
	}
	/*
	 * End of Temporary Block
	 */
	
	/*
	 * CP.3.1.1.1.005 - 2020-10-09 - JMalayo - Start Add
	 */
	public boolean setPersonIdType() throws Exception {
		try {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.personIdType.toWebElement()));
			repo.personIdType.selectTextAs("Person ID Type/Value");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Person Id Type/Value as filter.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setPersonIdValue(String personIdValue) throws Exception {
		try {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.personIdValue.toWebElement()));
			repo.personIdValue.selectTextAs(personIdValue);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Person Id Value: " + personIdValue);
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.1.1.005 - 2020-10-09 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.9.B.002 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean navToCaseThruChainIconBtn() throws Exception {
		init();
		try {
			
			WebDriverWait popWait = new WebDriverWait(driver, 10);			
			popWait.until(ExpectedConditions.visibilityOf(repo.acctActivityHistoryTbl.toWebElement()));
			List <WebElement> tableRows = repo.acctActivityHistoryTbl.toWebElement().findElements(By.xpath("//*[@id='data_1']/table/tbody/tr"));
			int tableSize = tableRows.size();
			for(int x = 0; x < tableSize; x++) {
				WebElement  status = driver.findElement(By.xpath("//*[@id='data_1']/table/tbody/tr[" + x + "]/td[4]"));
				wait.until(ExpectedConditions.elementToBeClickable(status));
				if(status.getText().contains("PSCW Complaint")){
					status.click();
					break;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Item on Search Bar");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.9.B.002 - 2020-10-12 - JMalayo - End Add
	 */
}
