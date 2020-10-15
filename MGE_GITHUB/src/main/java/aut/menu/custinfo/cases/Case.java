/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Case
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-10-12	JMalayo	CP.3.1.7.013 - Closing a Landlord Case in Initial Status         
 * 2020-10-12	JMalayo	CP.3.1.9.B - Manage Customer Inquiries/Complaints - High Bill
 * 									Complaint
 * 2020-10-12	JMalayo CP.3.1.9.B - Manage Customer Inquiries/Complaints - PSCW
 * 									Complaint
 *************************************************************************************
 */

package aut.menu.custinfo.cases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.entity.Entity;
import aut.menu.custinfo.account.AccountObjects;
import ey.manila.qa.automation.CalendarUtil;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;


public class Case extends Entity{
	private CaseObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public Case(Ccb ccb) {
		this.pageTitle = "CASE";
		this.idHolder = "CASE_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new CaseObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.customerInformation.cases.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Case Page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean searchCaseTypeClickSearchIcon() throws Exception{
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.caseTypeSearchIcon.toWebElement()));
			repo.caseTypeSearchIcon.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Click on the Case Type Search Button.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean searchCaseType(String caseType) throws Exception{
		try {
			String main = driver.getWindowHandle();
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.popUpCaseType.toWebElement()));
			
			Thread.sleep(2000);
			screenWait.until(ExpectedConditions.numberOfWindowsToBe(2));
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
			
			repo.popUpCaseType.toWebElement().click();
			repo.popUpCaseType.toWebElement().sendKeys(caseType);
			repo.popUpCaseTypeSearchBtn.toWebElement().click();
	
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Search for Case Type: MGELLTYPE");
			logger.log(e);
    		return false;
		}
	}
	
	
	public boolean searchPremId(String premId) throws Exception{
		try {
			String main = driver.getWindowHandle();
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.popUpPremId.toWebElement()));
			
			Thread.sleep(2000);
			screenWait.until(ExpectedConditions.numberOfWindowsToBe(2));
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
			
			repo.popUpPremId.toWebElement().click();
			repo.popUpPremId.toWebElement().sendKeys(premId);
			repo.popUpPremIdSearchBtn.toWebElement().click();
	
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Search for Premise Id: " + premId);
			logger.log(e);
    		return false;
		}
	}
	
	public boolean selectCaseCharType(String charType, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getCaseCharTypeAtIndex(row).toWebElement()));
			repo.getCaseCharTypeAtIndex(row).selectTextAs(charType);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Characteristic Type: " + charType);
			logger.log(e);
			return false;
		}
	}
	
	public boolean searchPersonCharValue(String personId) throws Exception{
		try {
			String main = driver.getWindowHandle();
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.popUpPersonId.toWebElement()));
			
			Thread.sleep(2000);
			screenWait.until(ExpectedConditions.numberOfWindowsToBe(2));
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
			
			repo.popUpPersonId.toWebElement().click();
			repo.popUpPersonId.toWebElement().sendKeys(personId);
			repo.popUpPersonIdSearchBtn.toWebElement().click();
			
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Search for Person Id: " + personId);
			logger.log(e);
    		return false;
		}
	}
	
	public boolean saveCases() throws Exception {
		try {
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Case Record");
			logger.log(e);
			return false;
		}
	}
	
	
	/*
	 * CP.3.1.9.A.001 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean selectPrefContactMethod(String contactMethod) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.contactMethod.toWebElement()));
			repo.contactMethod.selectTextAs(contactMethod);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Preferred Contact Method: " + contactMethod);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setCharacteristicTypeAtRow(int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getCaseCharTypeAtIndex(row).toWebElement()));
			repo.getCaseCharTypeAtIndex(row).selectTextAs("Bill");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Characteristic Type: Bill");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setCharacteristicValueAtRow(String charValue, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getCaseCharValueAtIndex(row).toWebElement()));
			repo.getCaseCharValueAtIndex(row).toWebElement().sendKeys(charValue);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Characteristic Value: " + charValue);
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.9.A.001 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean searchBillIdAccountId(String accountId) throws Exception{
		try {
			String main = driver.getWindowHandle();
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.accountId.toWebElement()));
			
			Thread.sleep(2000);
			screenWait.until(ExpectedConditions.numberOfWindowsToBe(2));
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
			
			repo.accountId.toWebElement().click();
			repo.accountId.toWebElement().sendKeys(accountId);
			repo.acctSearchBtn.toWebElement().click();
			
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Search for Account Id: " + accountId);
			logger.log(e);
    		return false;
		}
	}
	
	public boolean clickInvestigateHighBillBtn() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.investigateHighBillBtn.toWebElement()));
			repo.investigateHighBillBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Investigate High Bill Button");
			logger.log(e);
			return false;
		}
	}
	
	public boolean clickFieldInvestigationBtn() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.fieldInvestigationBtn.toWebElement()));
			repo.fieldInvestigationBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Field Investigation Button");
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean clickCloseResolveHighBillComplaintBtn() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.closeResolveHighBillComplaintBtn.toWebElement()));
			repo.closeResolveHighBillComplaintBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Close/ Resolve High Bill Complaint Button");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.9.A.006 - 2020-10-12 - JMalayo - End Add
	 */
	
	
	/*
	 * CP.3.1.9.B.002 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean clickReviewPSCWComplaintBtn() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.reviewPSCWBtn.toWebElement()));
			repo.reviewPSCWBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Review PSCW Complaint Button");
			logger.log(e);
			return false;
		}
	}
	
	public boolean clickCloseResolveCaseBtn() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.closeResolvePSCWBtn.toWebElement()));
			repo.closeResolvePSCWBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Close/Resolve Button");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.9.B.002 - 2020-10-12 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.9.B.006 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean clickWaitPSCWEmailBtn() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.waitPSCWEmailBtn.toWebElement()));
			repo.waitPSCWEmailBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Wait for PSCW Email Button");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.9.B.006 - 2020-10-12 - JMalayo - End Add
	 */
}
