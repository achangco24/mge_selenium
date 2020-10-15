/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Financial Transaction
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN		Reason text.                
 * 
 *************************************************************************************
 */
package aut.menu.financial.ft;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class FinancialTransaction extends Entity{
	private FinancialTransactionObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public FinancialTransaction(Ccb ccb) {
		this.pageTitle = "Financial Transaction";
		this.idHolder = "FT_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);
		this.ccb = ccb;
		repo = new FinancialTransactionObjects(ccb.getDriver(), ccb.getCcbFrames());
	}

	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.financial.financialTransaction.launch();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Financial Transaction Page");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean searchPopUpFinancialTransactionId(String ftid) throws Exception {
		try {
			boolean ssl = false;
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> id = driver.getWindowHandles();
			Iterator<String> pages = id.iterator();
			String main = pages.next();
			String windows = "";
			while(pages.hasNext()) {
				windows = pages.next();
			}
			driver.switchTo().window(windows);
			ssl = isElementPresent(repo.moreInfo.getLocator());
			if (ssl == false) {
				String temp = windows;
				windows = main;
				main = temp;
				driver.switchTo().window(windows);
			}
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			//popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
			repo.moreInfo.toWebElement().click();
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
			repo.overridelink.toWebElement().click();
			popWait.until(ExpectedConditions.elementToBeClickable(repo.ftid.toWebElement()));
			repo.ftid.toWebElement().click();
			repo.ftid.toWebElement().sendKeys(ftid);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.searchBtn.toWebElement()));
			repo.searchBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Search Successful: " + ftid);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching ID in Pop up");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean clickDashBoardPremise() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.dashboardPremise.toWebElement()));
			repo.dashboardPremise.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Opening to Premise Page via dashboard");
			logger.log(e);
    		return false;
		}
	}
}