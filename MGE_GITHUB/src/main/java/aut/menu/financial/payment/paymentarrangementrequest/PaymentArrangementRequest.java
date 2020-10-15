/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Payment Arrangement Request
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-07-13	RExtra	CP_CI.030	Add components for Adding a Payment Arrangement
 * 									Request
 * 
 * 
 *************************************************************************************
 */
package aut.menu.financial.payment.paymentarrangementrequest;

import java.awt.Event;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import aut.Ccb;
import aut.entity.Entity;

public class PaymentArrangementRequest extends Entity{
	private PaymentArrangementRequestObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	/*
	 * CP_CI.030 - 2020-07-13 - Start Add
	 */
	private final String ELIGIBLE_TEXT = "Customer is eligible for a payment arrangement";
	/*
	 * CP_CI.030 - 2020-07-13 - End Add
	 */
	
	public PaymentArrangementRequest(Ccb ccb){
		this.pageTitle = "Process Flow: Payment Arrangement Request";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		
		initialize(ccb);	
		this.ccb = ccb;	
		repo = new PaymentArrangementRequestObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	/*
	 * CP_CI.030 - 2020-07-13 - Start Add
	 */
	public boolean checkEligibility() throws Exception {
		try {
			Thread.sleep(20000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.eligible.toWebElement()));
			if(repo.eligible.toWebElement().getText().equals(ELIGIBLE_TEXT)){
				wait.until(ExpectedConditions.elementToBeClickable(repo.nextBtn.toWebElement()));
				repo.nextBtn.toWebElement().click();
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Customer is NOT Eligible for a Payment Arrangement");
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterNumOfInstallments(String numOfInstallments) throws Exception {
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.numOfInstallments.toWebElement()));
	       	repo.numOfInstallments.toWebElement().clear();
	       	repo.numOfInstallments.toWebElement().click();
	       	System.out.println("AAA");
	       	idHolder = repo.numOfInstallments.toWebElement().getAttribute("id");
	       	JavascriptExecutor js = (JavascriptExecutor)driver;
	       	System.out.println("BBB");
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" +numOfInstallments + "'");
	       	System.out.println("CCC");
	       	Thread.sleep(10000);
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").dispatchEvent(new Event('change'));");
	       	System.out.println("DDD");
	       	wait.until(ExpectedConditions.elementToBeClickable(repo.nextBtn.toWebElement()));
			repo.nextBtn.toWebElement().click();
	       	
	       	return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Entering Number of Installments as '" + numOfInstallments + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean finishPayArrReq() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.finishBtn.toWebElement()));
			repo.finishBtn.toWebElement().click();
			refresh();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Finish Adding a Paymet Arrangement Request");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.030 - 2020-07-13 - End Add
	 */
	
	
	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
