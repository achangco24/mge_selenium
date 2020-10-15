/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Account
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-05-13	RExtra	CP_CC.019	Add components for Manually Adding Credit Points
 * 2020-06-02	RExtra	CP_FIN.11	Add components for Canceling Auto Pay 
 * 2020-06-04	RExtra	CP_CI.004	Add components for Setting up Auto Pay           
 * 2020-10-12	JMalayo CP.3.1.7.001	Establish Landlord Agreement to Account
 * 2020-10-12	JMalayo CP.3.1.1.2.EN-065.001 Account Management Control Center Alert
 *************************************************************************************
 */
package aut.menu.custinfo.account;

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
import ey.manila.qa.automation.CalendarUtil;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class Account extends Entity {
	private AccountObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public Account(Ccb ccb) {
		this.pageTitle = "Account";
		this.idHolder = "ACCT_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new AccountObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.customerInformation.account.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Account Page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setAccountID(String id) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.accountid.toWebElement()));
			repo.accountid.toWebElement().sendKeys(id);
			repo.accountid.toWebElement().sendKeys(Keys.ENTER);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Account Id: " + id);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setMailingPremise(String id) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.mailingpremise.toWebElement()));
			repo.mailingpremise.toWebElement().sendKeys(id);
			repo.mailingpremise.toWebElement().sendKeys(Keys.ENTER);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Mailing Premise: " + id);
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectCISDivision(String CIS, WebDriverWait wait) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.cisDivision.toWebElement()));
			repo.cisDivision.selectTextAs(CIS);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select CIS Division: " + CIS);
			logger.log(e);
			return false;
		}
	}	
	
	public boolean setAddressSource(String addrSource) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.addressSource.toWebElement()));
			repo.addressSource.selectTextAs(addrSource);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Address Source: " + addrSource);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setPostal(String id) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.postal.toWebElement()));
			repo.postal.toWebElement().sendKeys(id);
			repo.postal.toWebElement().sendKeys(Keys.ENTER);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Postal: " + id);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setAddress1(String id) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.address1.toWebElement()));
			repo.address1.toWebElement().sendKeys(id);
			repo.address1.toWebElement().sendKeys(Keys.ENTER);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Address1: " + id);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setCity(String id) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.city.toWebElement()));
			repo.city.toWebElement().sendKeys(id);
			repo.city.toWebElement().sendKeys(Keys.ENTER);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input City: " + id);
			logger.log(e);
			return false;
		}
	}
	
	public boolean switchToPersons() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.accountPersons.getWebElement()));
			tabs().accountPersons.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Account - Persons Tab");
			logger.log(e);
			return false;
		}
	}
	
	public boolean switchToCharacteristics() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.accountCharacteristics.getWebElement()));
			tabs().accountCharacteristics.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Account - Characteristics Tab");
			logger.log(e);
			return false;
		}
	}
	
	public boolean saveAccount() throws Exception {
		try {
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Account");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CC.019 - 2020-05-13 - Start Add
	 */
	public boolean switchToCredAndCollTab() throws Exception{
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(tabs.credAndColl.getWebElement()));
			tabs().credAndColl.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to C&C Tab");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addCredRatingHistory() throws Exception{
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.addCredRatingHistory.toWebElement()));
			repo.addCredRatingHistory.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Add Credit Rating History");
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterCredRatHistStartDate() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.credRatHistStartDate.toWebElement()));
			String strDate = LocalDate.now().format(DateTimeFormatter.ISO_DATE.ofPattern("MM-dd-yyyy")); 
			repo.credRatHistStartDate.toWebElement().sendKeys(strDate);;
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Add Credit Rating History");
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterCredRatHistEndDate(String strRollOffDays) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.credRatHistEndDate.toWebElement()));
			
			try {
				int rollOffDays = Integer.parseInt(strRollOffDays);
				String strDate = LocalDate.now().plusDays(rollOffDays).format(DateTimeFormatter.ISO_DATE.ofPattern("MM-dd-yyyy")); 
				repo.credRatHistEndDate.toWebElement().sendKeys(strDate);
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Add Credit Rating History");
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterCredRating(String strCredits) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.credRatingPoints.toWebElement()));
			
			try {
				int credits = Integer.parseInt(strCredits); 
				repo.credRatingPoints.toWebElement().sendKeys("-" + strCredits);
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Add Credit Rating");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addCredAndCollComments(String comments) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.credAndCollComments.toWebElement()));
			repo.credAndCollComments.toWebElement().clear();
			repo.credAndCollComments.toWebElement().click();
			repo.credAndCollComments.toWebElement().sendKeys(comments);	
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Add C&C Comments");
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean saveCredRatingHist() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(commons.save.toWebElement()));
			save();
			
			Thread.sleep(2000);
			System.out.println("Successfully Added Credit Points to Account ID: " + getId());
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Credit Rating History");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CC.019 - 2020-05-13 - End Add
	 */
	
	/*
	 * CP_FIN.11 - 2020-06-02 - Start Add
	 */
	public boolean switchToAutoPayTab() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.accountAutoPay.getWebElement()));
			tabs().accountAutoPay.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Account - Persons Tab");
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterEndDate(String endDate) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.autoPayEndDate.toWebElement()));
			repo.autoPayEndDate.toWebElement().clear();
			repo.autoPayEndDate.toWebElement().sendKeys(endDate);
			
			repo.accountInfo.toWebElement().click();
			repo.accountInfo.toWebElement().click();
			save();
			System.out.println("Successfully Cancelled Auto Pay for Account ID: " + getId());

			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Enter Auto Pay End Date: " + endDate);
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_FIN.11 - 2020-06-02 - End Add
	 */
	
	/*
	 * CP_CI.004 - 2020-06-04 - Start Add
	 */
	public boolean enterStartDate(String startDate) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.autoPayStartDate.toWebElement()));
			repo.autoPayStartDate.toWebElement().sendKeys(startDate);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Enter Auto Pay Start Date: " + startDate);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterSourceCode(String sourceCode) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.autoPaySourceCode.toWebElement()));
			repo.autoPaySourceCode.toWebElement().sendKeys(sourceCode);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Enter Auto Pay Source Code: " + sourceCode);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterExternalAcctID(String externalAcctID) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.autoPayExternalAcctID.toWebElement()));
			
			repo.autoPayExternalAcctID.toWebElement().click();
			repo.autoPayExternalAcctID.toWebElement().clear();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById(\"" + repo.autoPayExternalAcctID.toWebElement().getAttribute("id") 
					+ "\").value = '" + externalAcctID + "'");
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Enter Auto Pay External Account ID: " + externalAcctID);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterName(String name) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.autoPayName.toWebElement()));
			repo.autoPayName.toWebElement().clear();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById(\"" + repo.autoPayName.toWebElement().getAttribute("id") 
					+ "\").value = '" + name + "'");
			
			save();
			System.out.println("Successfully Setup Auto Pay for Account ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Enter Auto Pay Name: " + name);
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.004 - 2020-06-04 - End Add
	 */
	
	/*
	 * CP_CI.032 - 2020-06-04 - Start Add
	 */
	public boolean switchToAlertsTab() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.accountAlerts.getWebElement()));
			tabs().accountAlerts.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Account - Alerts Tab");
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean setAlertType(String alertType) throws Exception {
		try {
			int row = 0;
			
			wait.until(ExpectedConditions.elementToBeClickable(repo.getContactTypeElementAtIndex(row).toWebElement()));
			repo.getContactTypeElementAtIndex(row).selectTextAs(alertType);
			
			save();
			
			System.out.println("Successfully Added an Alert '" + alertType + "' to Account ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Account - Alerts Tab");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CI.032 - 2020-06-04 - End Add
	 */
	
	/*
	 * CP.3.1.1.006 - 2020-10-08 - JMalayo - Start Add
	 */
	public boolean clickPersonTabPersonSearcIcon() throws Exception{
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.searchPersonIcon.toWebElement()));
			repo.searchPersonIcon.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Click Search Icon of Person Id on Person Tab.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean searchPopUpPersonId(String personName)
	{
		try {
			String main = driver.getWindowHandle();
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
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
			
			Thread.sleep(2000);
			repo.sPersonName.toWebElement().sendKeys(personName);
			repo.searchPersonNameBtn.toWebElement().click();
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Search Person Id.");
			logger.log(e);
    		return false;
		}
	}
	
	/*
	 * CP.3.1.1.006 - 2020-10-08 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - End Add
	 */
	public boolean openAccountContextMenu() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.accountContextMenuBtn.toWebElement()));
			repo.accountContextMenuBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Person context menu.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addLandLordAgreement() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.landlordContextMenu.toWebElement()));
			repo.landlordContextMenu.toWebElement().click();
			repo.add.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Person context menu.");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.1.2.EN-065.001 - 2020-10-12 - JMalayo - Start Add
	 */
	public boolean searchManagementGroup() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.managementGroupSearchIcon.toWebElement()));
			repo.managementGroupSearchIcon.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click on Management Group Search Icon.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean searchAccountManagementGroup(String managementGroup)
	{
		try {
			String main = driver.getWindowHandle();
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
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
			
			Thread.sleep(2000);
			repo.searchManagementGroup.toWebElement().click();
			repo.searchManagementGroup.toWebElement().sendKeys(managementGroup);
			repo.searchManagementGroupBtn.toWebElement().click();
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Search Management Group: " + managementGroup);
			logger.log(e);
    		return false;
		}
	}
	/*
	 * CP.3.1.1.2.EN-065.001 - 2020-10-12 - JMalayo - End Add
	 */
}
