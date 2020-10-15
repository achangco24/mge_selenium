/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Bill Segment
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-07-07	RExtra	CP_BI.006	Add components to Cancel a Bill Segment
 * 
 *************************************************************************************
 */
package aut.menu.financial.bill.billsegment;

import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import aut.Ccb;
import aut.entity.Entity;

public class BillSegment extends Entity{
	private BillSegmentObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public BillSegment(Ccb ccb) {
		this.pageTitle = "Bill Segment";
		this.idHolder = "BSEG_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new BillSegmentObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	/*
	 * CP_BI.006 - 2020-07-07 - Start Add
	 */
	public boolean initiateBillSegmentCancellation(String reason) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.initCancel.toWebElement()));
			repo.initCancel.toWebElement().click();
			
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
			popWait.until(ExpectedConditions.elementToBeClickable(repo.popCancelReason.toWebElement()));
			repo.popCancelReason.selectTextAs(reason);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.popCancelCalcBtn.toWebElement()));
			repo.popCancelCalcBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Initiate Bill Segment Cancellation");
			logger.log(e);
			return false;
		}
	}
	
	public boolean cancelBillSegment() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBSegBtn.toWebElement()));
			repo.cancelBSegBtn.toWebElement().click();
			
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
			popWait.until(ExpectedConditions.elementToBeClickable(repo.confirmCancelBSegBtn.toWebElement()));
			repo.confirmCancelBSegBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			
			System.out.println("Successfully Cancelled Bill Segment: " + getId());
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Cancel Bill Segment");
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
	public boolean rebillBillSegmentDueTo(String reason) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.rebillBtn.toWebElement()));
			repo.rebillBtn.toWebElement().click();
			
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
			popWait.until(ExpectedConditions.elementToBeClickable(repo.popCancelReason.toWebElement()));
			repo.popCancelReason.selectTextAs(reason);
			
			popWait.until(ExpectedConditions.elementToBeClickable(repo.popRebillCalculate.toWebElement()));
			repo.popRebillCalculate.toWebElement().click();
			
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Rebill Bill Segment");
			logger.log(e);
			return false;
		}
	}
	
	public boolean navToBillFromBillSegment() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.billContextMenu.toWebElement()));
			repo.billContextMenu.toWebElement().click();
			repo.billMenu.toWebElement().click();
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Bill from Bill Segment");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
