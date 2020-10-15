/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Service Agreement
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
 * 2020-07-13	RExtra	CP_CI.030	Add components for Adding a Payment Arrangement
 * 									Request             
 * 
 *************************************************************************************
 */
package aut.menu.custinfo.sa;

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
import aut.entity.IEntity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class ServiceAgreement extends Entity implements IEntity {
	private ServiceAgreementObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public ServiceAgreement(Ccb ccb) {
		this.pageTitle = "Service Agreement";
		this.idHolder = "SA_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);
		this.ccb = ccb;
	
		repo = new ServiceAgreementObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.customerInformation.serviceAgreement.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Service Agreement page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean search() throws Exception {
		try {
			try {
				driver.switchTo().defaultContent();
				commons.menu.customerInformation.serviceAgreement.search();
			}catch(Exception e) {
				driver.switchTo().parentFrame();
				commons.menu.customerInformation.serviceAgreement.search();
			}
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
//			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
//			if(!menuFlag) {
//				driver.switchTo().defaultContent();
//				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
//			}
//			commons.menu.customerInformation.serviceAgreement.search();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigation to Service Agreement page");
			logger.log(e);
			return false;
		}		
	}
	
	public boolean enterAccountId(String accountId) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.accountId.toWebElement()));
			repo.accountId.toWebElement().sendKeys(accountId);
			repo.accountId.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.accountInfo.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigation to Service Agreement page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setCisDivisionAs(String cisDivision) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.cisDivision.toWebElement()));
			repo.cisDivision.selectTextAs(cisDivision);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set CIS Division: " + cisDivision);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterSaType(String saType) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.saTypeCode.toWebElement()));
			repo.saTypeCode.toWebElement().sendKeys(saType);
			
			repo.accountInfo.toWebElement().click();
			//repo.saTypeCode.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			//repo.saTypeInfo.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Service Agreement Type: " + saType);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterPremiseId(String premiseId) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.premiseId.toWebElement()));
			
			repo.premiseId.toWebElement().click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + repo.premiseId.toWebElement().getAttribute("id") + "\").value = '" + premiseId + "'");
			
			repo.accountInfo.toWebElement().click();
			//repo.premiseId.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			//repo.premiseInfo.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Premise ID: " + premiseId);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterBillFactor(String billFactor) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.billFactor.toWebElement()));
			repo.billFactor.toWebElement().sendKeys(billFactor);
			repo.billFactor.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.billFactorDescription.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Bill Factor: " + billFactor);
			logger.log(e);
			return false;
		}	
	}
	
	public boolean setTaxExemptTypeAs(String taxExemptType) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.taxExemptType.toWebElement()));
			repo.taxExemptType.selectTextAs(taxExemptType);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Tax Exempt Type: " + taxExemptType);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterSpId(String spId) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.spId.toWebElement()));
			repo.spId.toWebElement().sendKeys(spId);
			repo.spId.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.spInfo.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter SP ID: " + spId);
			logger.log(e);
			return false;
		}
	}
	
	public boolean hasMeterInstallation() throws Exception {
		String meterInfo = repo.meterItemInfo.toWebElement().getAttribute("innerHTML");
		if(meterInfo.equals(emptySpan)) {
			return false;
		}		
		return true;
	}
	
	public boolean enterStartMeterReadId(String startMeterReadId) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.startMeterReadId.toWebElement()));
			repo.startMeterReadId.toWebElement().sendKeys(startMeterReadId);
			repo.startMeterReadId.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.startMeterReadInfo.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Start Meter Read Id: " + startMeterReadId);
			logger.log(e);
			return false;
		}
	}
	
	public boolean activate() throws Exception {
		try{
			if (!repo.statusFlag.toWebElement().getAttribute("value").equals("Active")) {
				repo.activate.toWebElement().click();
				//repo.statusFlag.waitWhileAttributeValue("value", "Active");
				
				System.out.println("Activated SA with ID: " + getId());
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Activate SA");
			logger.log(e);
			return false;
		}
		
	}
	
	public boolean searchPopUpSAId(String saId) throws Exception {
		try {
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
				System.out.println("null popWindow");
				return false;
			}
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
			repo.moreInfo.toWebElement().click();
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
			repo.overridelink.toWebElement().click();
			popWait.until(ExpectedConditions.elementToBeClickable(repo.saId.toWebElement()));
			repo.saId.toWebElement().click();
			repo.saId.toWebElement().sendKeys(saId);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.saIdSearchBtn.toWebElement()));
			repo.saIdSearchBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Search Successful: " + saId);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching SA ID in Pop up");
			logger.log(e);
    		return false;
		}
	}
	
	private boolean openAccountContextMenu() throws Exception{
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
	
	public boolean paymentArrangementBreak() throws Exception {
		openAccountContextMenu();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.payArrangementBreak.toWebElement()));
			repo.payArrangementBreak.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate Payment Arrangement Break page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectSA() throws Exception{
		try {
//			boolean ssl = false;
//			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//			Set<String> id = driver.getWindowHandles();
//			Iterator<String> pages = id.iterator();
//			String main = pages.next();
//			String windows = "";
//			while(pages.hasNext()) {
//				windows = pages.next();
//			}
//			driver.switchTo().window(windows);
//			ssl = isElementPresent(repo.moreInfo.getLocator());
//			if (ssl == false) {
//				String temp = windows;
//				windows = main;
//				main = temp;
//				driver.switchTo().window(windows);
//			}
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
				System.out.println("null popWindow");
				return false;
			}
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
			repo.moreInfo.toWebElement().click();
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
			repo.overridelink.toWebElement().click();
			wait.until(ExpectedConditions.visibilityOf(repo.saTable.toWebElement()));
			List <WebElement> row = driver.findElements(By.xpath("//*[@id='dataTableBody']/tr"));
			for(int a = 1; a <= row.size(); a++) {
				WebElement type = driver.findElement(By.xpath("//*[@id='dataTableBody']/tr[" + a + "]/td[4]/span"));
				String checker = type.getAttribute("innerHTML");
				if(checker.contains("Water - Residential")) {
					type.click();
					break;
				}
			}
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate Payment Arrangement Break page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addPayment() throws Exception{
		try {
		wait.until(ExpectedConditions.visibilityOf(repo.dashboardAcctContext.toWebElement()));
		repo.dashboardAcctContext.toWebElement().click();
		wait.until(ExpectedConditions.visibilityOf(repo.payment.toWebElement()));
		repo.payment.toWebElement().click();
		wait.until(ExpectedConditions.elementToBeClickable(repo.paymentAdd.toWebElement()));
		repo.paymentAdd.toWebElement().click();
		return true;
		} catch (Exception e) {
		return false;
		}
	}
	
	/*
	 * CP_BI.014 - 2020-06-03 - Start Add
	 */
	public boolean setMaxBillThreshold(String maxBillThreshold) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.maxBillThreshold.toWebElement()));
			repo.maxBillThreshold.toWebElement().clear();
			repo.maxBillThreshold.toWebElement().click();
			repo.maxBillThreshold.toWebElement().sendKeys(maxBillThreshold);
			
			save();
			
			System.out.println("Successfully Added Max Bill Threshold of '" + maxBillThreshold + "' to SA with ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Set Max Bill Threshold");
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
	public boolean setReqDepositAmt(String depositAmt) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.reqDepositAmt.toWebElement()));
			repo.reqDepositAmt.toWebElement().clear();
			repo.reqDepositAmt.toWebElement().click();
			repo.reqDepositAmt.toWebElement().sendKeys(depositAmt);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Set Requested Deposit Amount");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.022 - 2020-06-17 - End Add
	 */
	
	/*
	 * CP_CI.030 - 2020-07-13 - Start Add
	 */
	public boolean verifyCreationOfPaymentArragement() throws Throwable {
		try{
			Dashboard dashboard = new Dashboard(ccb);
			boolean flag = dashboard.clickAlertLinkWithText("Payment Arrangement SA - Electric");
			if(flag){
				System.out.println("Successfully Created Payment Arrangement Request for SA ID: " + getId());
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Verify Creation of Payment Arrangement");
			logger.log(e);
			return false;
		}
		
	}
	/*
	 * CP_CI.030 - 2020-07-13 - End Add
	 */
}