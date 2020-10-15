/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Batch
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 Date:       	by:    	Reason: 
 * 2020-09-30	AChangco	Initial version.                
 * 
 *************************************************************************************
 */
package aut.admin.a.algorithm;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class Algorithm extends Entity {
	private AlgorithmObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;

	public Algorithm(Ccb ccb) {
		this.pageTitle = "Algorithm";
		this.idHolder = "";
		this.charGridFrame = By.id("");
		this.charHeader = "";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new AlgorithmObjects(ccb.getDriver(), ccb.getCcbFrames());
	}

	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(commons.barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.admin.a.algorithm.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Person Page");
			logger.log(e);
			return false;
		}
	}

}