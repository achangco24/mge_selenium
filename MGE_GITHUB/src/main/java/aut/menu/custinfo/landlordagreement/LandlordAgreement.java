/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Landlord Agreement
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo			
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-10-12	JMalayo	CP.3.1.7.001	Initial Version
 * 2020-10-12	JMalayo	CP.3.1.7.001	Establish Landlord Agreement to Account
 
 *************************************************************************************
 */

package aut.menu.custinfo.landlordagreement;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.menu.custinfo.landlordagreement.LandLordObjects;
import aut.dashboard.Dashboard;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;



public class LandlordAgreement extends Entity{
	private LandLordObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	
	public LandlordAgreement(Ccb ccb){
		this.pageTitle = "Landlord Agreement";
		this.idHolder = "LL_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();

		
		initialize(ccb);	
		this.ccb = ccb;	
		repo = new LandLordObjects(ccb.getDriver(), ccb.getCcbFrames());
	}

	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.customerInformation.landlordAgreement.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Landlord Agreement Page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setDescription(String desc) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.description.toWebElement()));
			repo.description.toWebElement().click();
			repo.description.toWebElement().sendKeys(desc);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Description: " + desc);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setServiceTypeAtRow(String servType, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getServiceTypeElementAtIndex(row).toWebElement()));
			repo.getServiceTypeElementAtIndex(row).selectTextAs(servType);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Service Type: " + servType);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setSeasonalAtRow(int row, boolean isSeasonal) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getSeasonalElementAtIndex(row).toWebElement()));
			repo.getSeasonalElementAtIndex(row).tickAs(isSeasonal);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Service Type to Seasonal");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setStartMonthDayAtRow(String startMonthDay, int row) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getStartMonthDayElementAtIndex(row).toWebElement()));
			repo.getStartMonthDayElementAtIndex(row).toWebElement().click();
			repo.getStartMonthDayElementAtIndex(row).toWebElement().sendKeys(startMonthDay);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Start Month/Day: " + startMonthDay);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setEndMonthDayAtRow(String endMonthDay, int row) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getEndMonthDayElementAtIndex(row).toWebElement()));
			repo.getEndMonthDayElementAtIndex(row).toWebElement().click();
			repo.getEndMonthDayElementAtIndex(row).toWebElement().sendKeys(endMonthDay);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input End Month/Day: " + endMonthDay);
			logger.log(e);
			return false;
		}
	}
	
	public boolean saveLandlordAgreement() throws Exception {
		try {
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Landlord Agreement");
			logger.log(e);
			return false;
		}
	}
}
