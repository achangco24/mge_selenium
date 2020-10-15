/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Pay Plan
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-07-01	RExtra	CP_CC.028	Add components to Add Pay Plan        
 * 
 *************************************************************************************
 */
package aut.menu.creditcoll.payplan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import aut.Ccb;
import aut.entity.Entity;
import aut.menu.creditcoll.collectionagencyreferral.CollectionAgencyReferralObjects;

public class PayPlan extends Entity{
	private PayPlanObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public PayPlan(Ccb ccb) throws Exception {
		this.pageTitle = "Pay Plan";
		this.idHolder = "PP_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new PayPlanObjects(ccb.getDriver(), ccb.getCcbFrames());
		
	}
	
	/*
	 * CP_CC.028 - 2020-07-01 - Start Add
	 */
	public boolean enterPPType(String ppType) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.ppType.toWebElement()));
			repo.ppType.toWebElement().clear();
			repo.ppType.toWebElement().click();
			repo.ppType.toWebElement().sendKeys(ppType, Keys.TAB);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on Entering Pay Plan Type");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean setPayMethod(String payMethod) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.payMethod.toWebElement()));
			repo.payMethod.selectTextAs(payMethod);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on Setting Pay Method as '" + payMethod + "'");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean enterSchedDate(String schedDate) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.getSchedDateElementAtIndex(0).toWebElement()));
			repo.getSchedDateElementAtIndex(0).toWebElement().clear();
			repo.getSchedDateElementAtIndex(0).toWebElement().click();
			repo.getSchedDateElementAtIndex(0).toWebElement().sendKeys(schedDate);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on Entering Scheduled Date: " + schedDate);
			logger.log(e);
    		return false;
		}
	}
	
	public boolean enterSchedAmt(String schedAmt) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.getSchedAmountElementAtIndex(0).toWebElement()));
			repo.getSchedAmountElementAtIndex(0).toWebElement().clear();
			repo.getSchedAmountElementAtIndex(0).toWebElement().click();
			repo.getSchedAmountElementAtIndex(0).toWebElement().sendKeys(schedAmt);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on Entering Scheduled Amount: " + schedAmt);
			logger.log(e);
    		return false;
		}
	}
	
	public boolean enterComment(String comment) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.comments.toWebElement()));
			repo.comments.toWebElement().clear();
			repo.comments.toWebElement().click();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + repo.comments.toWebElement().getAttribute("id") + "\").value = '" + comment + "'");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on Entering Pay Plan Comment '" + comment + "'");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean savePayPlan() throws Exception {
		try {
			save();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on Saving Pay Plan");
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
			System.out.println("Succesfully Created a Pay Plan with ID :" + getId());
			logger.log("Succesfully Created a Pay Plan with ID :" +getId());
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Pay Plan ID Exist");
			logger.log(e);
			return false;
		}
	}
	
	public boolean navToAddCustomerContact() throws Exception{
		try {
			openAccountContextMenu();
			repo.customerContactMenu.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Account context menu.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean openAccountContextMenu() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.accountContextMenu.toWebElement()));
			repo.accountContextMenu.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Account context menu.");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CC.028 - 2020-07-01 - End Add
	 */
	
	
	/*
	 * CP_CI.031 - 2020-07-02 - Start Add
	 */
	public boolean cancelPayPlan() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBtn.toWebElement()));
			repo.cancelBtn.toWebElement().click();
			
			System.out.println("Successfully Cancelled Pay Plan with ID: " + getId());
			Thread.sleep(500);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Account context menu.");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.031 - 2020-07-02 - End Add
	 */

	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
