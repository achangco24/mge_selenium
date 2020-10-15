/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Customer Contact
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-16	GSando	Initial version.
 * 2020-06-19	RExtra	CP_CI.031	Add components for Adding a Customer Contact
 * 2020-10-12	JMalayo	CP.3.1.7.001	Establish Landlord Agreement to Account
 * 2020-10-12	JMalayo	CP.3.1.7.002	Add Premise to Existing Landlord Agreement
 * 2020-10-12	JMalayo	CP.3.1.7.005	Provide Written Notice of Intent to Transfer
 * 										Billing Responsibility
 * 2020-10-12	JMalayo	CP.3.1.7.009	Generate LOCK Letter for Off Order in Auto
 * 										Auto Agreement
 *************************************************************************************
 */
package aut.menu.custinfo.customercontact;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class CustomerContact extends Entity {
	private CustomerContactObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public CustomerContact(Ccb ccb) {
		this.pageTitle = "Customer Contact";
		this.idHolder = "CC_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new CustomerContactObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean search() throws Exception {
		try {
			try {
				driver.switchTo().defaultContent();
				commons.menu.customerInformation.customerContact.search();
			}catch(Exception e) {
				driver.switchTo().parentFrame();
				commons.menu.customerInformation.customerContact.search();
			}
			
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Customer Contact page");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean searchPerIdInPopUp(String personId) throws Exception {
		try {
			String main = driver.getWindowHandle();
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
			popWait.until(ExpectedConditions.elementToBeClickable(repo.perId.toWebElement()));
			repo.perId.toWebElement().click();
			repo.perId.toWebElement().sendKeys(personId);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.perIdSearchBtn.toWebElement()));
			repo.perIdSearchBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Search Successful: " + personId);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching Person ID in Pop up: " + personId);
			logger.log(e);
    		return false;
		}
	}
	
	public boolean searchCcIdInPopUp(String customerContactId) throws Exception {
		try {
			String main = driver.getWindowHandle();
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
			popWait.until(ExpectedConditions.elementToBeClickable(repo.ccId.toWebElement()));
			popWait.until(ExpectedConditions.elementToBeClickable(repo.ccId.toWebElement()));
			repo.ccId.toWebElement().click();
			repo.ccId.toWebElement().click();
			repo.ccId.toWebElement().sendKeys(customerContactId);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.ccIdSearchBtn.toWebElement()));
			repo.ccIdSearchBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Search Successful: " + customerContactId);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching Customer Contact ID in Pop up: " + customerContactId);
			logger.log(e);
    		return false;
		}
	}
	
	public boolean switchToLogTab() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.ccLog.getWebElement()));
			tabs.ccLog.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "Customer Contact - Failed to open Log page");
    		return false;
		}
	}
	
	public boolean addLogEntry(String comment) throws Exception{
		try {
			wait.until(ExpectedConditions.visibilityOf(repo.logId.toWebElement()));
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String idHolder = repo.logContent.toWebElement().getAttribute("id");
			
			if(!repo.logId.toWebElement().getText().equals("")){
				wait.until(ExpectedConditions.elementToBeClickable(repo.addLogEntry.toWebElement()));
				repo.addLogEntry.toWebElement().click();
				
				wait.until(ExpectedConditions.elementToBeClickable(repo.logContent.toWebElement()));
		       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + comment + "'");
		       	repo.logContent.toWebElement().click();
		       	
		       	return true;
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(repo.logContent.toWebElement()));
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + comment + "'");
	       	repo.logContent.toWebElement().click();
	       	
	       	return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "Customer Contact - Failed to input Log Entry: " + comment);
    		return false;
		}
	}
	
	public boolean saveCustomerContact() throws Exception {
		try {
			save();
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Customer Contact");
			logger.log(e);
			return false;
		}
	}
	
	public boolean checkIDExist() throws Exception{
		try {
			boolean flag = checkid();
			if(flag == false) {
				screenshot.capture();
				driver.close();
				driver.quit();
				return false;
			}
			screenshot.capture();
			logger.log("Customer Contact was successfully saved:" +getId());
			System.out.println("Customer Contact was successfully saved:" +getId());
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Customer Contact ID Exist");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CI.001 - 2020-06-15 - Start Add
	 */
	public boolean add() throws Exception{
		try {
			Thread.sleep(2000);
			try {
				driver.switchTo().defaultContent();
				commons.menu.customerInformation.customerContact.add();
			}catch(Exception e) {
				driver.switchTo().parentFrame();
				commons.menu.customerInformation.customerContact.add();
			}
			
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Customer Contact page");
			logger.log(e);
    		return false;
    	}
	}
	/*
	 * CP_CI.001 - 2020-06-15 - End Add
	 */
	
	/*
	 * CP_CI.031 - 2020-06-19 - Start Add
	 */
	public boolean selectContactClass(String contactClass) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.contactClass.toWebElement()));
			repo.contactClass.selectTextAs(contactClass);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "Customer Contact - Failed to Select Contact Class as '" + contactClass + "'");
    		return false;
		}
	}
	
	public boolean enterContactType(String contactType) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.contactType.toWebElement()));
			repo.contactType.toWebElement().sendKeys(contactType);
			
			repo.userID.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "Customer Contact - Failed to Select Contact Type as '" + contactType + "'");
    		return false;
		}
	}
	/*
	 * CP_CI.031 - 2020-06-19 - End Add
	 */
	
	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean selectPreContactMethod() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.prefContactMethod.toWebElement()));
			repo.prefContactMethod.selectTextAs("Person Contact");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "Customer Contact - Failed to Select Preferred Contact Method: Person Contact");
    		return false;
		}
	}
	
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.7.002 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean switchToCharacteristicTab() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.characteristics.getWebElement()));
			tabs.characteristics.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "Customer Contact - Failed to open Characteristic page");
    		return false;
		}
	}
	/*
	 * CP.3.1.7.002 - 2020-10-12 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.7.003 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean searchAcctIdInPopUp(String accountId, String searchType) throws Exception {
		try {
			String main = driver.getWindowHandle();
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
			popWait.until(ExpectedConditions.elementToBeClickable(repo.searchType.toWebElement()));
			repo.searchType.toWebElement().click();
			repo.searchType.selectTextAs(searchType);
			
			popWait.until(ExpectedConditions.elementToBeClickable(repo.perIdSearchBtn.toWebElement()));
			repo.perIdSearchBtn.toWebElement().click();
			
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Search Successful: " + accountId);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching Account ID in Pop up: " + accountId);
			logger.log(e);
    		return false;
		}
	}
	/*
	 * CP.3.1.7.003 - 2020-10-12 - JMalayo - End Add
	 */
	
	
	
	/*
	 * CP.3.1.7.005 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean setPersonId(String personId) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.personId.toWebElement()));
			repo.personId.toWebElement().sendKeys(personId);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "Customer Contact - Failed to Select Person ID :" + personId);
    		return false;
		}
	}
	
	public boolean setAccountId(String accountId) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.acctId.toWebElement()));
			repo.acctId.toWebElement().sendKeys(accountId);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "Customer Contact - Failed to Select Account ID :" + accountId);
    		return false;
		}
	}
	
	public boolean setPremId(String premId) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.premId.toWebElement()));
			repo.premId.toWebElement().sendKeys(premId);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "Customer Contact - Failed to Select Premise ID :" + premId);
    		return false;
		}
	}
	/*
	 * CP.3.1.7.005 - 2020-10-12 - JMalayo - End Add
	 */
	
	
	/*
	 * CP.3.1.7.009 - 2020-10-12 - JMalayo - End Add
	 */
	public boolean setCharacteristicValue(String charValue, int row) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getCharacteristicValueAtIndex(row).toWebElement()));
			repo.getCharacteristicValueAtIndex(row).toWebElement().sendKeys(charValue);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "Customer Contact - Failed to set Characteristic Type - Effective Date :" + charValue);
    		return false;
		}
	}
	/*
	 * CP.3.1.7.009 - 2020-10-12 - JMalayo - End Add
	 */
}
