/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Batch Job
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
package aut.menu.tool.batchjob;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class BatchJob extends Entity {
	private BatchJobObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public BatchJob(Ccb ccb) {
		this.pageTitle = "Batch Job Submission";
		this.idHolder = "BATCH_JOB_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new BatchJobObjects(ccb.getDriver(), ccb.getCcbFrames());
	}

	public boolean open() throws Exception {
		try {
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.tool.batchjob.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed loading Batch Job page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterBatchCode(String batchCode) throws Exception {
		String idHolder = repo.batchCode.toWebElement().getAttribute("id");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.batchCode.toWebElement()));
			repo.batchCode.toWebElement().click();
			//repo.batchCode.toWebElement().sendKeys(batchCode);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + batchCode + "'");
			repo.batchID.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Batch Code: " + batchCode);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterBatchDate(String batchDate) throws Exception {
		String idHolder = repo.batchDate.toWebElement().getAttribute("id");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.batchDate.toWebElement()));
			repo.batchDate.toWebElement().click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + batchDate + "'");
			save();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Batch Date: " + batchDate);
			logger.log(e);
			return false;
		}
	}
	
	public boolean checkStatus() throws Exception {
		try {
			for(int i = 0; i < 5; i++) {
				String status = repo.batchStatus.toWebElement().getAttribute("innerHTML");
				System.out.println("status: " + status );
				driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
				if (status.contains("ended"))
					break;
				else {
					repo.buttonRefresh.toWebElement().click();
				}
				
			}
			back();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to change status of batch job");
			return false;
		}
	}
	
	
	public boolean enterParamAtRow(String paramValue, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getParamAtIndex(row).toWebElement()));
			repo.getParamAtIndex(row).toWebElement().click();
			repo.getParamAtIndex(row).toWebElement().sendKeys(paramValue);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Batch Param : " + row);
			logger.log(e);
			return false;
		}
	}
	
	public boolean clickDQ() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.buttonDQ.toWebElement()));
			repo.buttonDQ.toWebElement().click(); 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Start bBatch");
			logger.log(e);
			return false;
		}
	}
	
	public boolean checkBatchStatus(String batchStatus) throws Exception {
		try {
			String status = repo.status.toWebElement().getText();
			while (true) {
				if (status.equalsIgnoreCase(batchStatus))
					return true;
				status = repo.status.toWebElement().getText();
				pause(5000);
				clickRefresh();
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to End Batch");
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean getBatchResult() throws Exception {
		try	{
			if(repo.batchResult.toWebElement().getText().equalsIgnoreCase("Complete"))
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Refresh Batch Job");
			logger.log(e);
			return false;
		}
	}
	
	public boolean clickRefresh() throws Exception {
		try {
			repo.buttonRefresh.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Refresh Batch Job");
			logger.log(e);
			return false;
		}
	}
	
	public boolean getBatchStatus() throws Exception {
		try {
			System.out.println(repo.status.toWebElement().getText()); 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Person");
			logger.log(e);
			return false;
		}
	}
	
	
	public void pause(Integer milliseconds){
	    try {
	        TimeUnit.MILLISECONDS.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}
