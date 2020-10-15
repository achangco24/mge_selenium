/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * To Do Summary
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * 2020-04-30	GSando	Initial version.
 * 2020-07-02	RExtra	CP_CI.047	Add components to Complete a To Do
 * 
 *************************************************************************************
 */
package aut.menu.todosummary;

import org.openqa.selenium.support.ui.ExpectedConditions;

import aut.Ccb;
import aut.dashboard.Dashboard;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class ToDoSummary extends Entity {
	private ToDoSummaryObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public ToDoSummary(Ccb ccb) {
		this.pageTitle = "To Do Summary";
		//this.idHolder = "CC_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new ToDoSummaryObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean selectOpenToDo(){
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.toDoSummaryOpen.toWebElement()));
			repo.toDoSummaryOpen.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in selecting an open To Do.");
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
			commons.menu.toDo.toDoSummary.launch();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to To Do Summary page");
			logger.log(e);
    		return false;
    	}
	}
	
	/*
	 * CP_CI.047 - 2020-07-02 - Start Add
	 */
	public boolean navToSummaryPageViaDashboard() throws Exception {
		try {
			Thread.sleep(3000);
			Dashboard dashboard = new Dashboard(ccb);
			boolean flag = dashboard.clickToDoLinkWithText("AMR Ops To Dos");
			
			if(!flag){
				return false;
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to To Do Summary via Dashboard Alert");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.047 - 2020-07-02 - End Add
	 */

}
