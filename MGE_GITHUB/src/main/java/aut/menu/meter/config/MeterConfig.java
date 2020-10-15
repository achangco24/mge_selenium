/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Meter Configuration
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
package aut.menu.meter.config;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import aut.Ccb;
import aut.entity.Entity;
import aut.entity.IEntity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class MeterConfig extends Entity implements IEntity {
	private MeterConfigObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	private Register register;
	public Register register() {
		return this.register;
	}
	
	
	public MeterConfig(Ccb ccb) {
		this.pageTitle = "Meter Configuration";
		this.idHolder = "MTR_CONFIG_ID";
		initialize(ccb);

		repo = new MeterConfigObjects(ccb.getDriver(), ccb.getCcbFrames());
		register = new Register(ccb.getDriver(), wait, ccb.getCcbObjects());
	}
	
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.meter.meterConfig.add();
			return isPageLoaded();
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Meter Config Page");
			logger.log(e);
			return false;
		}
	
}
	
	
	public boolean hasMeterLoaded() throws Exception {
		String meterInfo = repo.meterInfo.toWebElement().getAttribute("innerHTML");
		if (meterInfo.equals(emptySpan)) {
			return false;
		}
		
		return true;
	}
	
	
	public boolean enterMeterId(String meterId) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.meterId.toWebElement()));
			repo.meterId.toWebElement().sendKeys(meterId);
			repo.meterId.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.meterInfo.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Meter ID: " + meterId);
			logger.log(e);
			return false;	
		}
	}
	
	
	public boolean enterEffectiveDate(String effDate) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.effectiveDate.toWebElement()));
			repo.effectiveDate.toWebElement().sendKeys(effDate);
			repo.effectiveDate.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.effectiveTime.waitWhileAttributeValue("value", "");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Effective Date: " + effDate);
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean enterEffectiveTime(String effTime) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.effectiveTime.toWebElement()));
			repo.effectiveTime.toWebElement().sendKeys(effTime);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Effective Time: " + effTime);
			logger.log(e);
			return false;
		}
		
	}
	
	
	public boolean enterMeterConfigType(String meterConfigType) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.meterConfigType.toWebElement()));
			repo.meterConfigType.toWebElement().sendKeys(meterConfigType);
			repo.meterConfigType.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.meterConfigDescription.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Effective Time: " + meterConfigType);
			logger.log(e);
			return false;
		}
		
	}
}