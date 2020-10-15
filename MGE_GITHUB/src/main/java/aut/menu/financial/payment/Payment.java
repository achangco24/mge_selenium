/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Payment
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-24	GSando	Initial version.  
 * 2020-06-03	RExtra	CP_FIN.12	Adding components for Adding & Manually
 * 									Distributing a Payment                
 * 
 *************************************************************************************
 */
package aut.menu.financial.payment;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import aut.Ccb;
import aut.entity.Entity;

public class Payment extends Entity{
	
	private PaymentObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public Payment(Ccb ccb) {
		this.pageTitle = "Payment";
		this.idHolder = "PAY_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new PaymentObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean cancelPayment() throws Exception{
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBtn.toWebElement()));
			repo.cancelBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to cancel Payment");
			logger.log(e);
			return false;

		}
	}
	
	public boolean selectCancelReason(String reason) throws Exception {
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
			if(isElementPresent(repo.moreInfo.getLocator())){
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
				repo.moreInfo.toWebElement().click();
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			popWait.until(ExpectedConditions.visibilityOf(repo.cancelTable.toWebElement()));
			popWait.until(ExpectedConditions.elementToBeClickable(repo.cancelReason.toWebElement()));
			repo.cancelReason.selectTextAs(reason);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.cancelPayment.toWebElement()));
			repo.cancelPayment.toWebElement().click();
			repo.cancelPayment.toWebElement().click();
			popWait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			driver.switchTo().window(main);
			
			System.out.println("Successfully Cancelled Payment with ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Cancel Reason: " + reason);
			logger.log(e);
			return false;
		}
	}
	
	
	/*
	 * CP_FIN.12 - 2020-06-03 - Start Add
	 */
	public boolean distributeAmountToSAs(String amount) throws Exception {
		try {
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + repo.distributedAmount1.toWebElement().getAttribute("id") + "\").value = '" + amount + "'");
	       	js.executeScript("document.getElementById(\"" + repo.distributedAmount2.toWebElement().getAttribute("id") + "\").value = '" + amount + "'");
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Set Distribution Amount to SAs");
			logger.log(e);
			return false;
		}
	}
	
	public boolean distribute_pmt() throws Exception{
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.distributeBtn.toWebElement()));
			repo.distributeBtn.toWebElement().click();
			
			System.out.println("Distributed Payment with ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Distribute Payment with ID: " + getId());
			logger.log(e);
			return false;
		}
	}
	
	public boolean freeze_pmt() throws Exception{
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.freezeBtn.toWebElement()));
			repo.freezeBtn.toWebElement().click();
			
			System.out.println("Frozen Payment with ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Freeze Payment with ID: " + getId());
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_FIN.12 - 2020-06-03 - End Add
	 */
	
	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
