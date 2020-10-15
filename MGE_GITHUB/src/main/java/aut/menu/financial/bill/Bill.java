/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Bill
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN					Reason text.
 * 2020-07-07	RExtra	CP_BI.001	Add components to Manually Generate a Bill               
 * 
 *************************************************************************************
 */
package aut.menu.financial.bill;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class Bill extends Entity {
	private BillObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public Bill(Ccb ccb) {
		this.pageTitle = "Bill";
		this.idHolder = "BILL_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new BillObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.financial.bill.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed loading Bill page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean generateBill() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.generateBtn.toWebElement()));
			repo.generateBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to generate Bill");
			logger.log(e);
			return false;
		}
	}
	
	public boolean generatePopup(String cutoffDate) throws Exception {
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
		wait.until(ExpectedConditions.visibilityOf(repo.cutoffDate.toWebElement()));
		wait.until(ExpectedConditions.elementToBeClickable(repo.calculateBtn.toWebElement()));
		repo.cutoffDate.toWebElement().sendKeys("");
		wait.until(ExpectedConditions.attributeContains(repo.cutoffDate.toWebElement(), "value", ""));
		repo.cutoffDate.toWebElement().sendKeys(cutoffDate);
		repo.allowEstimates.toWebElement().click();
		//System.out.println(repo.allowEstimates.toWebElement().getAttribute("value"));
		wait.until(ExpectedConditions.attributeToBe(repo.allowEstimates.toWebElement(), "value", "on"));
		repo.calculateBtn.toWebElement().click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		driver.switchTo().window(main);
		return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to complete generation of bill.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean freezeBill() throws Exception {
		try {
			String main = driver.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(repo.freezeBtn.toWebElement()));
			repo.freezeBtn.toWebElement().click();
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
				System.out.println("null popwindow");
				return false;
			}
			
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			if(isElementPresent(repo.moreInfo.getLocator())){
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
				repo.moreInfo.toWebElement().click();
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			
			popWait.until(ExpectedConditions.elementToBeClickable(repo.popFreezeBtn.toWebElement()));
			repo.popFreezeBtn.toWebElement().click();
			
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			
			System.out.println("Frozen Bill ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to freeze bill.");
			logger.log(e);
			return false;
		}
	}

	public boolean calcLines() throws Exception{
		try {
		wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBtn.toWebElement()));
		List <WebElement> tableRows = repo.billSegment.toWebElement().findElements(By.xpath("//*[@id=\'dataTableBody\']/tr"));
		int tableSize = tableRows.size();
		for(int i = 0;i < tableSize; i++) {
			WebElement segment = repo.billSegment.toWebElement().findElement(By.xpath("//*[@id='BILL_SEG|" + i + "|1|1']/a/span"));
			wait.until(ExpectedConditions.elementToBeClickable(repo.billSegment.toWebElement()));
			segment.click();
			wait.until(ExpectedConditions.elementToBeClickable(repo.calcLinesBtn.toWebElement()));
			repo.calcLinesBtn.toWebElement().click();
			screenshot.capture();
			back();
		}
		return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Calculate Lines.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean cancelRebillFreeze() throws Exception{
		try {
			String main = driver.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(repo.billSegmentBtn.toWebElement()));
			repo.billSegmentBtn.toWebElement().click();
			
			wait.until(ExpectedConditions.elementToBeClickable(repo.selectAllBtn.toWebElement()));
			repo.selectAllBtn.toWebElement().click();
			repo.cancelRebillFreeze.toWebElement().click();
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
				System.out.println("null popwindow");
				return false;
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(repo.moreInfo.toWebElement()));
			repo.moreInfo.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(repo.overridelink.toWebElement()));
			repo.overridelink.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(repo.popCancelReason.toWebElement()));
			repo.popCancelReason.toWebElement().click();
			repo.popOption1.toWebElement().click();
			wait.until(ExpectedConditions.attributeToBeNotEmpty(repo.popCancelReason.toWebElement(), "innerHTML"));
			repo.popCalculate.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));

			driver.switchTo().window(main);
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			
			Set<String> windowHandles2 =driver.getWindowHandles();	
			popWindow = "";

			for (String windowHandle2: windowHandles2) {
				if (!main.equalsIgnoreCase(windowHandle2)) {
					popWindow = windowHandle2;
				}
			}
			if (popWindow != null) {
				driver.switchTo().window(popWindow);
				driver.close();
			}else {
				System.out.println("null popwindow");
				return false;
			}
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Cancel/Rebill/Freeze segments.");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_BI.001 - 2020-07-07 - Start Add
	 */
	public boolean completeBill() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.billCompleteBtn.toWebElement()));
			repo.billCompleteBtn.toWebElement().click();
			
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
			
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			if(isElementPresent(repo.overridelink.getLocator())){
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			popWait.until(ExpectedConditions.elementToBeClickable(repo.popBillCompleteBtn.toWebElement()));
			repo.popBillCompleteBtn.toWebElement().click();
			
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			
			System.out.println("Successfully Completed Bill ID: " + getId());
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select a Bill Segment");
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
	public boolean searchForBillID(String billID) throws Exception {
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
				return false;
			}
			
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			if(isElementPresent(repo.overridelink.getLocator())){
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(repo.popBillSearchTbl.toWebElement()));
			List <WebElement> tableRows = repo.popBillSearchTbl.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
			int tableSize = tableRows.size();
			for(int i = 0;i < tableSize; i++) {
				WebElement billSearchID = repo.popBillSearchTbl.toWebElement().findElement(By.xpath("//*[@id='SEARCH_RESULTS:" + i + "$BILL_ID']"));
				if(billSearchID.getText().equalsIgnoreCase(billID)){
					wait.until(ExpectedConditions.elementToBeClickable(billSearchID));
					billSearchID.click();
					break;
				}
			}
			
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Search Successful: " + billID);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching Bill ID in Pop up: " + billID);
			logger.log(e);
    		return false;
		}
	}
	
	public boolean selectBillSegment() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBtn.toWebElement()));
			List <WebElement> tableRows = repo.billSegment.toWebElement().findElements(By.xpath("//*[@id=\'dataTableBody\']/tr"));
			int tableSize = tableRows.size();
			for(int i = 0;i < tableSize; i++) {
				WebElement segment = repo.billSegment.toWebElement().findElement(By.xpath("//*[@id='BILL_SEG|" + i + "|1|1']/a/span"));
				wait.until(ExpectedConditions.elementToBeClickable(repo.billSegment.toWebElement()));
				segment.click();
			}
			
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select a Bill Segment");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_BI.006 - 2020-07-07 - End Add
	 */
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	public boolean verifyOldBillSegmentStatus() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBtn.toWebElement()));
			List <WebElement> tableRows = repo.billSegment.toWebElement().findElements(By.xpath("//*[@id=\'dataTableBody\']/tr"));
			int tableSize = tableRows.size();
			int frozenCtr = 0;
			int cancelledCtr = 0;
			for(int i = 0;i < tableSize; i++) {
				WebElement status = repo.billSegment.toWebElement().findElement(By.xpath("//*[@id='BILL_SEG|" + i + "|3']/span"));
			
				if(status.getText().equals("Frozen")){
					frozenCtr++;
				}
				
				if(status.getText().equals("Canceled")){
					cancelledCtr++;
				}
			}
			
			if((frozenCtr == 1) && (cancelledCtr == 1)){
				System.out.println("CPBI002CancelRebillingABillSegment: Success");
				System.out.println("Frozen Bill Segment: " + frozenCtr);
				System.out.println("Cancelled Bill Segment: " + cancelledCtr);
				return true;
			}else{
				System.out.println("CPBI002CancelRebillingABillSegment: Fail");
				System.out.println("Frozen Bill Segment: " + frozenCtr);
				System.out.println("Cancelled Bill Segment: " + cancelledCtr);
				return false;
			}
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Verifying Old Bill Segment Status");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
}
