/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Collection Agency Referral
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-06-30	RExtra	CP_CC.002	Add components to Add Collection Agency Referral        
 * 
 *************************************************************************************
 */
package aut.menu.creditcoll.collectionagencyreferral;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import aut.Ccb;
import aut.entity.Entity;
import aut.menu.creditcoll.severance.SeveranceObjects;

public class CollectionAgencyReferral extends Entity{
	
	private CollectionAgencyReferralObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public CollectionAgencyReferral(Ccb ccb) throws Exception {
		this.pageTitle = "Collection Agency Referral";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new CollectionAgencyReferralObjects(ccb.getDriver(), ccb.getCcbFrames());
		
	}
	
	/*
	 * CP_CC.002 - 2020-06-30 - Start Add
	 */
	public boolean enter_coll_agency(String collAgency) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.collectionAgency.toWebElement()));
			
			idHolder = repo.collectionAgency.toWebElement().getAttribute("id");
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + collAgency + "'");
	       	
			//repo.collectionAgency.toWebElement().clear();
			//repo.collectionAgency.toWebElement().click();
			//repo.collectionAgency.toWebElement().sendKeys(collAgency, Keys.TAB);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on Entering Collection Agency");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean setStartDate() throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.startDate.toWebElement()));
			
			LocalDate currentDate = LocalDate.now();
			String strDate = currentDate.format(DateTimeFormatter.ISO_DATE.ofPattern("MM-dd-yyyy"));
			
			repo.startDate.toWebElement().clear();
			repo.startDate.toWebElement().click();
			
			repo.startDate.toWebElement().sendKeys(strDate, Keys.TAB);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on setting Start Date as Current Date");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean enterComments(String comments) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.comments.toWebElement()));
			repo.comments.toWebElement().click();
			repo.comments.toWebElement().clear();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + repo.comments.toWebElement().getAttribute("id") + "\").value = '" + comments + "'");
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on entering Comments");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean setCreationDate(String creationDate) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.getCreationDateElementAtIndex(0).toWebElement()));
			repo.getCreationDateElementAtIndex(0).toWebElement().clear();
			repo.getCreationDateElementAtIndex(0).toWebElement().click();
			
			repo.getCreationDateElementAtIndex(0).toWebElement().sendKeys(creationDate, Keys.TAB);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on setting Creation Date as '" + creationDate + "'");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean setReferralAmt(String referralAmt) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.getReferralAmtElementAtIndex(0).toWebElement()));
			repo.getReferralAmtElementAtIndex(0).toWebElement().clear();
			repo.getReferralAmtElementAtIndex(0).toWebElement().click();

			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + repo.getReferralAmtElementAtIndex(0).toWebElement().getAttribute("id") + "\").value = '" + referralAmt + "'");
	       	
	       	repo.getCreationDateElementAtIndex(0).toWebElement().click();
	       	repo.getReferralAmtElementAtIndex(0).toWebElement().click();
	       	
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on setting Referral Amount as '" + referralAmt + "'");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean setReferralHistRsn(String referralHistRsn) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.getReasonElementAtIndex(0).toWebElement()));
			repo.getReasonElementAtIndex(0).selectTextAs(referralHistRsn);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on setting Referral History Reason as '" + referralHistRsn + "'");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean setReferralStatus(String status) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.referralStatus.toWebElement()));
			repo.referralStatus.selectTextAs(status);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on setting Referral Status as '" + status + "'");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean saveCollAgencyRef() throws Exception {
		try {
			save();
			
			System.out.println("Successfully Added a Collection Agency Referral for Account ID: " + repo.acctID.toWebElement().getAttribute("value"));
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on saving Collection Agency Referral");
			logger.log(e);
    		return false;
		}
	}
	/*
	 * CP_CC.002 - 2020-06-30 - End Add
	 */
	
	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
