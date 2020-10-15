/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Meter Install
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
package aut.menu.meter.install;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import aut.Ccb;
import aut.entity.Entity;
import aut.entity.IEntity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class MeterInstall extends Entity implements IEntity {
	private MeterInstallObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;

	
	public MeterInstall(Ccb ccb) {
		this.pageTitle = "SP/Meter Installation";
		this.idHolder = "SP_MTR_HIST_ID";
		initialize(ccb);	
		repo = new MeterInstallObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.meter.meterInstall.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Meter Install Page");
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
	
	
	public boolean enterMeterConfigId(String meterConfigId) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.meterConfigId.toWebElement()));
			repo.meterConfigId.toWebElement().sendKeys(meterConfigId);
			repo.meterConfigId.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.meterConfigInfo.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Meter Config ID: " + meterConfigId);
			logger.log(e);
			return false;
			
		}
		
	}
	
	
	public boolean enterMeterReadId(String meterReadId) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.meterReadId.toWebElement()));
			repo.meterReadId.toWebElement().sendKeys(meterReadId);
			repo.meterReadId.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.installReadDateTime.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Meter Reading: " + meterReadId);
			logger.log(e);
			return false;
		}
		
	}
}