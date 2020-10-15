/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Payment Event
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * 2020-06-02	RExtra	    CP_FIN.08	Add components for Adding a Payment Event
 * 2020-06-03	RExtra	    CP_FIN.09	Add components for Adding a Payment to
 * 										Multiple Accounts
 * 2020-06-02	RExtra	    CP_FIN.10	Add components for Canceling a Payment Event
 * 
 *************************************************************************************
 */
package aut.menu.financial.paymentevent;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class PaymentEvent extends Entity{
	private PaymentEventObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public PaymentEvent(Ccb ccb) throws Exception {
		this.pageTitle = "Payment Event";
		this.idHolder = "PAY_EVENT_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new PaymentEventObjects(ccb.getDriver(), ccb.getCcbFrames());
		
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.financial.paymentEvent.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Severance Process page");
			logger.log(e);
			return false;
		}
	
	}
	
	public boolean addPaymentEvent(String amount) throws Exception{
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
			System.out.println(main + " = This is main window!");
			
			System.out.println(String.valueOf(driver.getWindowHandles().size()) + " number of windows");
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> windowHandles = driver.getWindowHandles();
			System.out.println("WindowHandles="+String.valueOf(driver.getWindowHandles()));
			String popWindow = "";
			int i = 0;
			for (String windowHandle : windowHandles) {
				i += 1;
				System.out.println(windowHandle + " = " + String.valueOf(i) + " window");
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
			wait.until(ExpectedConditions.elementToBeClickable(repo.moreInfo.toWebElement()));
			repo.moreInfo.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(repo.overridelink.toWebElement()));
			repo.overridelink.toWebElement().click();
			pause(5000);
			
//			wait.until(ExpectedConditions.elementToBeClickable(repo.paymentAmount.toWebElement()));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(repo.amountTendered.getLocator()));
			repo.amountTendered.toWebElement().click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("document.getElementById('TNDR_TYPE:0$TENDERED_AMT').setAttribute('value', '" + amount + "')");
			repo.paymentAmount.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(repo.amountTendered.toWebElement()));
			repo.amountTendered.toWebElement().click();
			repo.okBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			save();
			wait.until(ExpectedConditions.elementToBeClickable(repo.dashboardAcctContext.toWebElement()));
			repo.dashboardAcctContext.toWebElement().click();
			repo.sevProcessMenu.toWebElement().click();
			repo.sevSearch.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to add payment.");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_FIN.08 - 2020-06-02 - Start Add
	 */
	
	
	public boolean finHist_addPaymentEvent(String date, String distributeAction) throws Exception{
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
			wait.until(ExpectedConditions.elementToBeClickable(repo.moreInfo.toWebElement()));
			repo.moreInfo.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(repo.overridelink.toWebElement()));
			repo.overridelink.toWebElement().click();
			pause(5000);

			String amt = repo.paymentAmount.toWebElement().getAttribute("value");
			
			//repo.amountTendered.toWebElement().click();
			//repo.amountTendered.toWebElement().sendKeys(amt);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + repo.amountTendered.toWebElement().getAttribute("id") + "\").value = '" + amt + "'");
			
	       	repo.amountTendered.toWebElement().click();
	       	repo.paymentAmount.toWebElement().click();
	       	repo.amountTendered.toWebElement().click();
			
			wait.until(ExpectedConditions.elementToBeClickable(repo.paymentDate.toWebElement()));

			repo.paymentDate.toWebElement().clear();
			repo.paymentDate.toWebElement().click();
			repo.paymentDate.toWebElement().sendKeys(date);
			
			repo.distributeAction.selectTextAs(distributeAction);
						
			repo.okBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			
			if(distributeAction.equals("Distribute and Freeze if OK")){
				System.out.println("Successfully created Payment Event with ID: " + getId());
			}
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to add payment.");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_FIN.08 - 2020-06-02 - End Add
	 */
	
	/*
	 * CP_FIN.09 - 2020-06-03 - Start Add
	 */
	public boolean addAnotherPmtEvtEntry() throws Exception{
		try {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.addPaymentEventElementAtIndex(0).toWebElement()));
			repo.addPaymentEventElementAtIndex(0).toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Add Another Payment Event Entry");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addAnotherPmtEvtAcctID(String otherAcctID) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.otherAcctID.toWebElement()));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById(\"" + repo.otherAcctID.toWebElement().getAttribute("id") + "\").value = '" + otherAcctID + "'");
			repo.otherAmount.toWebElement().click();
			repo.otherAcctID.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Add Another Payment Event Account ID: " + otherAcctID);
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean addAnotherPmtEvtAmt(String otherAmt) throws Exception{
		try {

			wait.until(ExpectedConditions.elementToBeClickable(repo.otherAmount.toWebElement()));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById(\"" + repo.otherAmount.toWebElement().getAttribute("id") + "\").value = '" + otherAmt + "'");
			Thread.sleep(1000);
			//save();
			//System.out.println("Successfully Created Payment Event with ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Add Another Payment Event Amount: " + otherAmt);
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean distribute_pmt_evt() throws Exception{
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.distributeBtn.toWebElement()));
			repo.distributeBtn.toWebElement().click();
			
			System.out.println("Distributed Payment Event ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Distribute Payment Event ID: " + getId());
			logger.log(e);
			return false;
		}
	}
	
	public boolean freeze_pmt_evt() throws Exception{
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.freezeBtn.toWebElement()));
			repo.freezeBtn.toWebElement().click();
			
			System.out.println("Frozen Payment Event ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Freeze Payment Event ID: " + getId());
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean addNewTender() throws Exception{
		try {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.addTenderBtn.toWebElement()));
			repo.addTenderBtn.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Freeze Payment Event ID: " + getId());
			logger.log(e);
			return false;
		}
	}
	
	public boolean newTndrPmtDt(String pmtDate) throws Exception{
		try {
			repo.payDate.toWebElement().clear();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + repo.payDate.toWebElement().getAttribute("id") + "\").value = '" + pmtDate + "'");
	       	repo.payDate.toWebElement().sendKeys(Keys.TAB);
	       	
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "New Tender - Failed to Enter Payment Date '" + pmtDate + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean newTndrEnterAcctID(String acctID) throws Exception{
		try {
			
			/*
			repo.payAcctID.toWebElement().click();
			repo.payAcctID.toWebElement().sendKeys(Keys.TAB);
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + repo.payAcctID.toWebElement().getAttribute("id") + "\").value = '" + acctID + "'");
	       	repo.payAcctID.toWebElement().sendKeys(Keys.TAB);
	       	//wait.until(ExpectedConditions.elementToBeClickable(repo.amtTndrd.toWebElement()));
	       	*/
			repo.acctSearchBtn.toWebElement().click();
			
			//--------------------------------
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
			
			if(isElementPresent(repo.overridelink.getLocator())){
				wait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(repo.acctID.toWebElement()));
			
			/*
			repo.acctID.toWebElement().click();
			repo.acctID.toWebElement().clear();
			repo.acctID.toWebElement().sendKeys(acctID);
			*/
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + repo.acctID.toWebElement().getAttribute("id") + "\").value = '" + acctID + "'");
	       	driver.findElement(By.id("PER_ID")).click();
	       	repo.acctID.toWebElement().click();
	       	
			wait.until(ExpectedConditions.elementToBeClickable(repo.acctSearch.toWebElement()));
			repo.acctSearch.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Search Successful: " + acctID);
			
			
			
			//--------------------------------
	       	
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "New Tender - Failed to Enter Payor Account ID: " + acctID);
			logger.log(e);
			return false;
		}
	}
	
	public boolean newTndrTndrAmt(String tndrAmt) throws Exception{
		try {
			repo.tenderAmount.toWebElement().clear();
			repo.tenderAmount.toWebElement().click();
			repo.tenderAmount.toWebElement().click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + repo.tenderAmount.toWebElement().getAttribute("id") + "\").value = '" + tndrAmt + "'");
	       	
			//repo.tenderAmount.toWebElement().sendKeys(tndrAmt);
	       	Thread.sleep(2000);
			driver.findElement(By.id("PAY_TNDR$TNDR_ACCT_INFO")).click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "New Tender - Failed to Enter Tender Amount '" + tndrAmt + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean newTndrTndrType(String tndrType) throws Exception{
		try {
			repo.tndrType.selectTextAs(tndrType);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "New Tender - Failed to Select Tender Type '" + tndrType + "'");
			logger.log(e);
			return false;
		}
	}

	
	public boolean newTndrTndrCtrlID(String tndrCtrlID) throws Exception{
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + repo.tndrCtrlID.toWebElement().getAttribute("id") + "\").value = '" + tndrCtrlID + "'");
	       	
	       	Thread.sleep(1000);
	       	repo.tndrCtrlID.toWebElement().sendKeys(Keys.TAB);
	       	
	       	
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "New Tender - Failed to Enter Tender Control ID: " + tndrCtrlID);
			logger.log(e);
			return false;
		}
	}
	
	public boolean savePaymentEvent() throws Exception{
		try {
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			System.out.println("Successfully Created Payment Event with ID: " + getId());
	       	
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "New Tender - Failed to Save Payment Event");
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean switchToMainTab() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.main.getWebElement()));
			tabs().main.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Main Tab");
			logger.log(e);
			return false;
		}
	}
	
	
	/*
	 * CP_FIN.09 - 2020-06-03 - End Add
	 */
	
	/*
	 * CP_FIN.10 - 2020-06-02 - Start Add
	 */
	public boolean switchToTendersTab() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.tenders.getWebElement()));
			tabs().tenders.switchTo();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Tenders Tab");
			logger.log(e);
			return false;
		}
	}
	
	public boolean includeInTndrCtrlBal(boolean status) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.includeInTndrCtrlBal.toWebElement()));
			repo.includeInTndrCtrlBal.tickAs(true);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Include in Tender Control Balance");
			logger.log(e);
			return false;
		}
	}
	
	public boolean cancelPaymentTender(String reason) throws Exception{
		try {		
			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBtn.toWebElement()));
			String main = driver.getWindowHandle();
			repo.cancelBtn.toWebElement().click();
			
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
			
			if(isElementPresent(repo.overridelink.getLocator())){
				wait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelReason.toWebElement()));
			repo.cancelReason.selectTextAs(reason);
				
			
			repo.cancelOKBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			
			
			
			System.out.println("Successfully Cancelled Payment Event with ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Tenders Tab");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_FIN.10 - 2020-06-02 - End Add
	 */
	
	
	
	public void pause(Integer milliseconds){
	    try {
	        TimeUnit.MILLISECONDS.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}
