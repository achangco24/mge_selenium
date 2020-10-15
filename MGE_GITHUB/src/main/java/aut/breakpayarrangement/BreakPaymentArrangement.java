/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Break Payment Arrangement
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
package aut.breakpayarrangement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class BreakPaymentArrangement extends Entity {
	private BreakPaymentArrangementObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public BreakPaymentArrangement(Ccb ccb){
		this.pageTitle = "Break Payment Arrangement";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;	
		repo = new BreakPaymentArrangementObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean breakPaymentArrangement() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.breakPayArrBtn.toWebElement()));
			repo.breakPayArrBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Break Payment Arrangement");
			logger.log(e);
			return false;
		}
	}

}
