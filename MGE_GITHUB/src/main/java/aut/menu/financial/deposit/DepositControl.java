/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Deposit Control
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-06-16	RExtra	CP_FIN.03	Add components for Adding a Deposit and Tender
 * 									Control                
 * 
 *************************************************************************************
 */
package aut.menu.financial.deposit;

import org.openqa.selenium.support.ui.ExpectedConditions;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class DepositControl extends Entity {
	private DepositControlObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public DepositControl(Ccb ccb) {
		this.pageTitle = "Deposit Control";
		this.idHolder = "DEP_CTL_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);
		this.ccb = ccb;
		repo = new DepositControlObjects(ccb.getDriver(), ccb.getCcbFrames());
	}

	public boolean open() throws Exception {
		try {
			try {
				driver.switchTo().defaultContent();
				commons.menu.financial.depositControl.add();
			}catch(Exception e) {
				driver.switchTo().parentFrame();
				commons.menu.financial.depositControl.add();
			}
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
//			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
//			if (!menuFlag) {
//				driver.switchTo().defaultContent();
//				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
//			}
//			commons.menu.financial.depositControl.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Deposit Control Page");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean selectTenderSource(String tenderSrcType) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.tenderSrcType.toWebElement()));
			repo.tenderSrcType.selectTextAs(tenderSrcType);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Tender Source Type: " + tenderSrcType);
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectCurrencyCode(String currCode) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.currCode.toWebElement()));
			repo.currCode.selectTextAs(currCode);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Currency Code: " + currCode);
			logger.log(e);
			return false;
		}
	}	
	
	public boolean enterComments(String comments) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.comments.toWebElement()));
			repo.comments.toWebElement().sendKeys(comments);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Comments: " + comments);
			logger.log(e);
			return false;
		}
	}
	
	public boolean checkIDExist() throws Exception{
		try {
			boolean flag = checkid();
			if(flag == false) {
				screenshot.capture();
				driver.close();
				driver.quit();
				return false;
			}
			screenshot.capture();
			System.out.println("Succesfully Created a Deposit Control with ID:" + getId());
			logger.log("Succesfully Created a Deposit Control with ID:" + getId());
			logger.log("Deposit Control is Saved");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Deposit Control ID Exist");
			logger.log(e);
			return false;
		}
	}
	
	public boolean saveDepositControl() throws Exception {
		try {
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Deposit Control");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_FIN.03 - 2020-06-16 - Start Add
	 */
	public boolean enterEndingBalance(String endingBalance) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.endingBalance.toWebElement()));
			repo.endingBalance.toWebElement().clear();
			repo.endingBalance.toWebElement().sendKeys(endingBalance);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Enter Ending Balance '" + endingBalance + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean openDCContext() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.dcCntx.toWebElement()));
			repo.dcCntx.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to open Deposit Control Context Menu");
			logger.log(e);
			return false;
		}
	}
	
	public boolean navToAddTenderCtrl() throws Exception {
		try {
			openDCContext();
			repo.tenderCtrlMenu.toWebElement().click();;
			repo.add.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed navigating to Add Tender Control thru Context Menu");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_FIN.02 - 2020-06-16 - End Add
	 */
}
