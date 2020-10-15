/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Start Stop
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-06-15	RExtra	CP_CI.001	Add components for Adding a Person Record
 * 2020-07-14	RExtra	CP_CI.068	Add components for Starting Service Using an
 * 									Order/Campaign RES
 * 2020-10-12	JMalayo	CP.3.1.2.NU.002	Start Service for SA Type:M-MISC-X
 *************************************************************************************
 */
package aut.menu.custinfo.startstop;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.dashboard.Dashboard;
import aut.entity.Entity;
import aut.entity.IEntity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class StartStop extends Entity implements IEntity {
	private StartStopObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public StartStop(Ccb ccb) {
		this.pageTitle = "Start/Stop";
		this.idHolder = "ACCT_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);
		this.ccb = ccb;
		repo = new StartStopObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Login")));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			commons.menu.customerInformation.startStop.launch();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Person Page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean clickDashBoardCustomer() {
		try {
			tabs().dashboard.switchTo();
			repo.dashboardCustomer.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Customer");
			logger.log(e);
			return false;
		}
	}
	
	public boolean confirmPageLoad() throws Exception {
		try{
			boolean accountFlag = isPageLoaded();
			if( accountFlag == false) {
				screenshot.capture();
				driver.quit();
				logger.log("warning","Failed to switch to account page");
				return false;
			}
			screenshot.capture();
			System.out.println("Succesfully Created a Account with ID:" + getId() + "\n");
			logger.log("Succesfully Created a Account with ID:" + getId() + "\n");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in loading Start/Stop Page");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CI.068 - 2020-07-14 - Start Add
	 */
	public boolean verifyResCPPOrderCompletion() {
		try {
			Thread.sleep(2000);
			//verifies that after completing the order, gets redirected to Start/Stop page
			if(pageTitle.equals("Start/Stop")){
				System.out.println("Successfully Redirected to " + pageTitle);
				System.out.println("Start/Stop for Account ID: " + getId());
			} else{
				System.out.println("Got Redirected to " + pageTitle);
			}
			
			//verifies that Order has been Completed -- no Pending Order Alert on Dashboard
			Dashboard dashboard = new Dashboard(ccb);
			if(!dashboard.linkIsPresentInAlerts("Pending Order Exists")){
				System.out.println("Successfully Completed Order");
			} else{
				System.out.println("Order is still Pending");
			}
			
			//verifies that Account and Person is Created
			System.out.println("Created: " + repo.acctInfo.toWebElement().getText());
			//System.out.println("Acct & Person2 >>" + repo.acctInfo.toWebElement().getAttribute("innerHTML"));
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Verifying RES CPP Order Completion");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.068 - 2020-07-14 - End Add
	 */

	
	/*
	 * CP.3.1.2.NU.002 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean setStartDate(String startDate) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.startDT.toWebElement()));
			repo.startDT.toWebElement().click();
			repo.startDT.toWebElement().sendKeys(startDate);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Start Date: " + startDate);
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectStartMethod(String startMethod) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.startMethod.toWebElement()));
			repo.startMethod.toWebElement().click();
			repo.startMethod.selectTextAs(startMethod);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Start Method: " + startMethod);
			logger.log(e);
			return false;
		}
	}	
	
	public boolean selectCISDivision(String cisDivision) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.cisDivision.toWebElement()));
			repo.cisDivision.toWebElement().click();
			repo.cisDivision.selectTextAs(cisDivision);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Start Method: " + cisDivision);
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectSAType(String saType) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.saType.toWebElement()));
			repo.saType.toWebElement().click();
			repo.saType.toWebElement().sendKeys(saType);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select SA Type: " + saType);
			logger.log(e);
			return false;
		}
	}	
	
	public boolean clickStartBtn(String saType) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.startBtn.toWebElement()));
			repo.startBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Start Button");
			logger.log(e);
			return false;
		}
	}	
	
	public boolean openAccountContextMenu() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.accountContextMenu.toWebElement()));
			repo.accountContextMenu.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to open account context menu.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean searchServiceAgreementMenu() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.acctServiceAgreMenu.toWebElement()));
			repo.acctServiceAgreMenu.toWebElement().click();
			repo.search.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to open Service Agreement Page.");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.2.NU.002 - 2020-10-12 - JMalayo - End Add
	 */
}

