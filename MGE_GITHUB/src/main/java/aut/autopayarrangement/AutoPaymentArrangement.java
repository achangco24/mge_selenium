/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Auto Payment Arrangement
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
package aut.autopayarrangement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class AutoPaymentArrangement extends Entity {
	private AutoPaymentArrangementObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public AutoPaymentArrangement(Ccb ccb) {
		this.pageTitle = "Automated Payment Arrangement";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;	
		repo = new AutoPaymentArrangementObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean enterInstallments(String installment) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.installments.toWebElement()));
			repo.installments.toWebElement().sendKeys(installment);
			repo.acctId.toWebElement().click();		//Click account id field to take effect the input to Installment field.
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter installments: " + installment);
			logger.log(e);
			return false;
		}
	}
	
	public boolean createPaymentArrangement() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.createPayArrBtn.toWebElement()));
			repo.createPayArrBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Create Payment Arrangement");
			logger.log(e);
			return false;
		}
	}

}
