/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Meter
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
package aut.menu.meter.meter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import aut.Ccb;
import aut.entity.Entity;
import aut.tabs.locationhistory.LocationHistoryGrid;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class Meter extends Entity {
	private MeterObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private LocationHistoryGrid locationHistory;
	private Ccb ccb;
	
	public LocationHistoryGrid locationHistory() {
		return this.locationHistory;
	}
	
	public Meter(Ccb ccb) {
		this.pageTitle = "Meter";
		this.idHolder = "MTR_ID";
		this.charGridFrame = By.id("dataframe");
		this.charHeader = "MTC";
		initialize(ccb);
		
		repo = new MeterObjects(ccb.getDriver(), ccb.getCcbFrames());
		this.locationHistory = new LocationHistoryGrid(ccb.getDriver(), wait, ccb.getCcbObjects(), By.id("LOC_HIST_GD"), "STK_LOC_HIST");
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.meter.meter.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Meter Page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterBadgeNumber(String badgeNumber) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.badgeNumber.toWebElement()));
			repo.badgeNumber.toWebElement().sendKeys(badgeNumber);
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Badge Number: " + badgeNumber);
			logger.log(e);
			return false;
			}

	}
	
	public boolean enterMeterType(String meterType) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.meterType.toWebElement()));
			repo.meterType.selectTextAs(meterType);
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Meter Type: " + meterType);
			logger.log(e);
			return false;
		}

	}
	
	public boolean enterManufacturer(String manufacturer) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.manufacturer.toWebElement()));
			repo.manufacturer.selectTextAs(manufacturer);
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Manufacturer: " + manufacturer);
			logger.log(e);
			return false;
		}
		
		
	}
	
	public boolean enterModel(String model) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.model.toWebElement()));
			repo.model.toWebElement().sendKeys(model);
			repo.model.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.modelDescription.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Model: " + model);
			logger.log(e);
			return false;
		}
		
	}
	
	public boolean enterSerialNumber(String serialNumber) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.serialNumber.toWebElement()));
			repo.serialNumber.toWebElement().sendKeys(serialNumber);
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Serial Number: " + serialNumber);
			logger.log(e);
			return false;
		}

	}
}
