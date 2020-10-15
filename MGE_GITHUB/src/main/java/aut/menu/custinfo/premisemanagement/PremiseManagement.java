/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Premise Management
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-10-12	JMalayo	Initial Version
 *************************************************************************************
 */
package aut.menu.custinfo.premisemanagement;

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
import aut.menu.custinfo.premisemanagement.PremiseManagementObjects;
import ey.manila.qa.automation.CalendarUtil;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;


public class PremiseManagement extends Entity{
	private PremiseManagementObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public PremiseManagement(Ccb ccb) {
		this.pageTitle = "Premise Management";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new PremiseManagementObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.customerInformation.premManagement.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Account Page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setLandlordFilter(String landlordFilter) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.landLordFilter.toWebElement()));
			repo.landLordFilter.selectTextAs(landlordFilter);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Landlord Filter: " + landlordFilter);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setLandlordAgreementId(String landlordId) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.landLordId.toWebElement()));
			repo.landLordId.toWebElement().click();
			repo.landLordId.toWebElement().sendKeys(landlordId);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Search for Landlord Id: " + landlordId);
			logger.log(e);
			return false;
		}
	}
	
	public boolean searchLandlordAgreement() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.landLordSearchBtn.toWebElement()));
			repo.landLordSearchBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Click for Search Button");
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectPremiseAtIndex(int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getLandLordPremiseFlgElementAtIndex(row).toWebElement()));
			repo.getLandLordPremiseFlgElementAtIndex(row).toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select a Premise");
			logger.log(e);
			return false;
		}
	}
	
	public boolean clickAssignLandlordBtn(int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.assignWindowAssignBtn.toWebElement()));
			repo.assignWindowAssignBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Click Assign Landlord Button");
			logger.log(e);
			return false;
		}
	}
	
	public boolean assignLandlordIdPremManagement(String landlordId, boolean incChildPrem) throws Exception {
		try {
			String main = driver.getWindowHandle();
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.assignWindowLandLordId.toWebElement()));
			
			
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
			repo.assignLandlordBtn.toWebElement().click();
			repo.assignWindowLandLordId.toWebElement().sendKeys(landlordId);
			repo.includePremChildFlg.tickAs(incChildPrem);
			repo.assignWindowLandLordId.toWebElement().click();
			
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on set Landlord Id: " + landlordId);
			logger.log(e);
    		return false;
		}
	}
}
