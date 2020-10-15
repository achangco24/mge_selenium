/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Collection Process
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-05-05	RExtra	CP_CC.003	Add components for Adding a Collection Process
 * 2020-05-12	RExtra	CP_CC.010	Add components for Canceling a Collection Process
 * 2020-05-13	RExtra	CP_CC.020	Add components for Modifying Collection Event
 * 									Trigger Date 
 *  2020-10-06	AChangco 4.9.2.EN	Reuse the methods for Payment Arrangement
 * 
 *************************************************************************************
 */
package aut.menu.creditcoll.paymentarrangement;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;






import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.CalendarUtil;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class PaymentArrangement extends Entity{
	private PaymentArrangementObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public PaymentArrangement(Ccb ccb) throws Exception {
		this.pageTitle = "Collection Process";
		this.idHolder = "COLL_PROC_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new PaymentArrangementObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.creditCollection.collections.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Collection Process page");
			logger.log(e);
			return false;
		}
	}

	public boolean search() throws Exception {
		try {
			try {
				driver.switchTo().defaultContent();
				commons.menu.creditCollection.collections.search();
			}catch(Exception e) {
				driver.switchTo().parentFrame();
				commons.menu.creditCollection.collections.search();
			}
			
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
//			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
//			if (!menuFlag) {
//				driver.switchTo().defaultContent();
//				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
//			}
//			commons.menu.creditCollection.collections.search();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Collection Process page");
			logger.log(e);
    		return false;
    	}
	}
	
	

}
