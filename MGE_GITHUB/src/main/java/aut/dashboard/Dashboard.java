/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Dashboard
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN						Initial
 * 2020-07-02	RExtra	CP_CI.047		Add components to Complete a To Do   
 * 2020-07-07	RExtra	CP_BI.001		Add components to Manually Generate a Bill
 * 2020-07-07	RExtra	CP_BI.006		Add components to Cancel a Bill Segment
 * 2020-07-14	RExtra	CP_CI.068		Add components for Starting Service Using an
 * 										Order/Campaign RES
 * 2020-10-08	JMalayo CP.3.1.1.003	Service Cycle Updates Billing Cycle
 * 2020-10-12	JMalayo CP.3.1.7.001	Establish Landlord Agreement to Account
 * 2020-10-12	JMalayo CP.3.1.9.A.001	Create High Bill Compliant
 *************************************************************************************
 */
package aut.dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class Dashboard extends Entity{
	private DashboardObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public Dashboard(Ccb ccb){
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;	
		repo = new DashboardObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean clickAlertLinkWithText(String alertLinkText) throws Exception {
		try {
//			Thread.sleep(7000);
//			tabs().dashboard.switchTo(); 
			wait.until(ExpectedConditions.elementToBeClickable(repo.alertTbl.toWebElement()));
			List <WebElement> tableRows = repo.alertTbl.toWebElement().findElements(By.xpath("//*[@id=\"data_201\"]/table/tbody/tr"));
			int tableSize = tableRows.size();
			for(int i = 0; i<tableSize;i++) {
				WebElement row = driver.findElement(By.xpath("//*[@id=\"data_201\"]/table/tbody/tr[" + (i+1) +"]/td/a"));
				wait.until(ExpectedConditions.elementToBeClickable(row));
				if(row.getAttribute("innerHTML").equalsIgnoreCase(alertLinkText)){
					row.click();
					//System.out.println(row.getAttribute("innerHTML") + " alert link is clicked successfully.");
					break;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Alert link: " + alertLinkText);
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CI.047 - 2020-07-02 - Start Add
	 */
	public boolean clickToDoLinkWithText(String alertLinkText) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.toDoSummaryTbl.toWebElement()));
			List <WebElement> tableRows = repo.toDoSummaryTbl.toWebElement().findElements(By.xpath("//*[@id=\"data_210\"]/div/table/tbody/tr"));
			int tableSize = tableRows.size();
			System.out.println("BB>>" + tableSize);
			for(int i = 1; i<tableSize;i++) {
				WebElement row = driver.findElement(By.xpath("//*[@id=\"data_210\"]/div/table/tbody/tr[" + (i+1) +"]/td[1]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(row));
				if(row.getAttribute("innerHTML").equalsIgnoreCase(alertLinkText)){
					row.click();
					return true;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Alert link: " + alertLinkText);
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.047 - 2020-07-02 - End Add
	 */
	
	/*
	 * CP_BI.001 - 2020-07-07 - Start Add
	 */
	public boolean openCurrentAccountContextMenu() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.accountContextMenu.toWebElement()));
			repo.accountContextMenu.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Opening Account Context Menu");
			logger.log(e);
			return false;
		}
	}
	
	public boolean navToAddBillThruAcctContextMenu() throws Exception {
		try {
			openCurrentAccountContextMenu();
			repo.billMenu.toWebElement().click();
			repo.add.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Navigating to Add Bill thru Current Account Context Menu");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_BI.001 - 2020-07-07 - End Add
	 */
	
	/*
	 * CP_BI.006 - 2020-07-07 - Start Add
	 */
	public boolean navToSearchBillThruAcctContextMenu() throws Exception {
		try {
			openCurrentAccountContextMenu();
			repo.billMenu.toWebElement().click();
			repo.search.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Navigating to Search Bill thru Current Account Context Menu");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_BI.006 - 2020-07-07 - End Add
	 */
	
	/*
	 * CP_CI.068 - 2020-07-14 - Start Add
	 */
	public boolean linkIsPresentInAlerts(String alertLinkText) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.alertTbl.toWebElement()));
			List <WebElement> tableRows = repo.alertTbl.toWebElement().findElements(By.xpath("//*[@id=\"data_201\"]/table/tbody/tr"));
			int tableSize = tableRows.size();
			for(int i = 0; i<tableSize;i++) {
				WebElement row = driver.findElement(By.xpath("//*[@id=\"data_201\"]/table/tbody/tr[" + (i+1) +"]/td/a"));
				wait.until(ExpectedConditions.elementToBeClickable(row));
				if(row.getAttribute("innerHTML").equalsIgnoreCase(alertLinkText)){
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Searching for Link '" + alertLinkText + "' in Dashboard Alerts");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.068 - 2020-07-14 - End Add
	 */
	
	
	/*
	 * CP.3.1.1.003 - 2020-10-08 - Start Add
	 */
	public boolean openCurrentAccountPremiseContextMenu() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.premiseContextMenu.toWebElement()));
			repo.premiseContextMenu.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Opening Premise Context Menu");
			logger.log(e);
			return false;
		}
	}
	
	
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean navToAddCustContactThruAcctContextMenu() throws Exception {
		try {
			openCurrentAccountContextMenu();
			repo.customerContact.toWebElement().click();
			repo.add.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Navigating to Add Customer Contact thru Current Account Context Menu");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - End Add
	 */
	
	
	
	/*
	 * CP.3.1.9.A.001 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean navToAddCasesThruAcctContextMenu() throws Exception {
		try {
			openCurrentAccountContextMenu();
			repo.accountContextCasesMenu.toWebElement().click();
			repo.add.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Navigating to Add Customer Contact thru Current Account Context Menu");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.9.A.001 - 2020-10-12 - JMalayo - End Add
	 */
}
