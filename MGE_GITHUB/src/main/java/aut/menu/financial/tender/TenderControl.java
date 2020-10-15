/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Tender Control
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
package aut.menu.financial.tender;

import org.openqa.selenium.support.ui.ExpectedConditions;

import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import aut.Ccb;
import aut.entity.Entity;

public class TenderControl extends Entity{
	private TenderControlObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public TenderControl(Ccb ccb) {
		this.pageTitle = "Tender Control";
		this.idHolder = "TNDR_CTL_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);
		this.ccb = ccb;
		repo = new TenderControlObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	/*
	 * CP_FIN.03 - 2020-06-16 - Start Add
	 */
	public boolean selectTenderSource(String tndrSrc) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.tndrSrc.toWebElement()));
			repo.tndrSrc.toWebElement().sendKeys(tndrSrc);
			repo.creDttm.toWebElement().click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Tender Source '" + tndrSrc + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean saveTenderControl() throws Exception {
		try {
			save();
			
			System.out.println("Successfully Created Tender Control with ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Tender Control");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_FIN.02 - 2020-06-16 - End Add
	 */
	
	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
