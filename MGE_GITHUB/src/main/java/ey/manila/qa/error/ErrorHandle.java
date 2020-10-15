/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Error Handle
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
package ey.manila.qa.error;

import org.openqa.selenium.WebDriver;

import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.logger.LogFile;

public class ErrorHandle {
	LogFile logger;
	
	public ErrorHandle() {
		
	}
	
	public ErrorHandle(LogFile logger) {
		this.logger = logger;
	}
	
	public void ExceptionHandle(ScreenShot screenshot, WebDriver driver) {
		try{
			screenshot.capture();
			//driver.close();
			driver.quit();
		} catch (Exception e) {
			System.out.print(e.getLocalizedMessage());
		}
	}
	
	public void ExceptionHandle(ScreenShot screenshot, WebDriver driver, String message) {
		try{
			screenshot.capture();
			System.out.println(screenshot.capture());
			//driver.close();
			driver.quit();
			logger.log("error", message);
		} catch (Exception e) {
			System.out.print(e.getLocalizedMessage());
		}
	}
}
