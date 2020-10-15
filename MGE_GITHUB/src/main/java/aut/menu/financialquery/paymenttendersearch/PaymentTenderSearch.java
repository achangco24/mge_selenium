/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Payment Tender Search
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-22	GSando	Initial version.            
 * 
 *************************************************************************************
 */
package aut.menu.financialquery.paymenttendersearch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import aut.Ccb;
import aut.entity.Entity;

public class PaymentTenderSearch extends Entity {
	private PaymentTenderSearchObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public PaymentTenderSearch(Ccb ccb) {
		this.pageTitle = "Payment/Tender Search";
//		this.idHolder = "CC_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new PaymentTenderSearchObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean selectSearchFor(String searchFor){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(repo.searchFor.toWebElement()));
			repo.searchFor.selectTextAs(searchFor);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed selecting Search For: " + searchFor);
			logger.log(e);
    		return false;
		}
	}
	
	public boolean selectPaymentAccount(String paymentaccount){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(repo.paymentAccount.toWebElement()));
			repo.paymentAccount.selectTextAs(paymentaccount);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed selecting Payment Account: " + paymentaccount);
			logger.log(e);
    		return false;
		}
	}
	
	public boolean enterAccountId(String accountId){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(repo.accountId.toWebElement()));
			repo.accountId.toWebElement().sendKeys(accountId);
			repo.paymentAccount.toWebElement().click();;
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed entering Account ID: " + accountId);
			logger.log(e);
    		return false;
		}
	}
	
	public boolean searchBtn(){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(repo.searchBtn.toWebElement()));
			repo.searchBtn.toWebElement().click();
			repo.searchBtn.toWebElement().click();
			
			repo.paymentResult.waitWhileAttributeValue("innerHTML", emptySpan);
			if(!repo.paymentResult.toWebElement().getText().startsWith("0")){
				System.out.println("Payment/s Found for Account with ID: " + repo.accountId.toWebElement().getAttribute("value"));
				return true;
			} else{
				System.out.println("No Payment/s found for Account ID: " + repo.accountId.toWebElement().getAttribute("value"));
				return false;
			}
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed clicking search button: ");
			logger.log(e);
    		return false;
		}
	}
	
	@Override
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.financialQuery.paymentTenderSearch.launch();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Payment/Tender Search Page");
			logger.log(e);
    		return false;
    	}
	}
}
