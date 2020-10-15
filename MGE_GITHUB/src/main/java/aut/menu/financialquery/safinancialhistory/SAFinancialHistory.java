/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * SA Financial History
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-06-01	RExtra	Initial version.            
 * 
 *************************************************************************************
 */
package aut.menu.financialquery.safinancialhistory;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import aut.Ccb;
import aut.entity.Entity;

public class SAFinancialHistory extends Entity{
	private SAFinancialHistoryObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public SAFinancialHistory(Ccb ccb) {
		this.pageTitle = "SA Financial History";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new SAFinancialHistoryObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	/*
	 * CP_FIN.02 - 2020-06-01 - Start Add
	 */
	public boolean navToAdjustmentNotebook() throws Exception {
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.adjusment.toWebElement()));
			repo.adjusment.toWebElement().click();
			return true;
//			Thread.sleep(2000);
//			System.out.println("RENZO >> Start >> " + driver.getTitle());
//			WebDriverWait screenWait = new WebDriverWait(driver, 10);
//			screenWait.until(ExpectedConditions.elementToBeClickable(repo.saFinHistTbl.getLocator()));
//			
//			//List <WebElement> tableRows = repo.saFinHistTbl.toWebElement().findElements(By.xpath("//*[@id='dataExplorerTableBody1']/tr"));
//			//int tableSize = tableRows.size();
//			
//			System.out.println("RENZO >> value >> " + repo.saFinHistTbl.toWebElement().getAttribute("value"));
//			
//			
//			//repo.saFinHistTbl.toWebElement().click();
//			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate to Adjustment Notebook");
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectAdjustmentFromAdjNotebook(String adjType) throws Exception {
		try {
			Thread.sleep(2000);
			String main = driver.getWindowHandle();
			int windows = driver.getWindowHandles().size();
			System.out.println("windows: "+windows);
			if(windows == 2){
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				Set<String> windowHandles = driver.getWindowHandles();
				String popWindow = "";
				for (String windowHandle : windowHandles) {
					if (!main.equalsIgnoreCase(windowHandle)) {
						popWindow = windowHandle;
					}
				}
				
				if (popWindow != null) {
					driver.switchTo().window(popWindow);
				}else {
					return false;
				}	
				
				WebDriverWait popWait = new WebDriverWait(driver, 10);
				if(isElementPresent(repo.moreInfo.getLocator())){
					popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
					repo.moreInfo.toWebElement().click();
					popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
					repo.overridelink.toWebElement().click();
				}
				popWait.until(ExpectedConditions.visibilityOf(repo.dataTable.toWebElement()));
				List <WebElement> tableRows = repo.dataTable.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
				int tableSize = tableRows.size();
				System.out.println("adjType: "+adjType);
				for(int x = 0; x < tableSize; x++) {
					WebElement type = driver.findElement(By.xpath("//*[@id='SEARCH_RESULTS:"+ x +"$ADJ_TYPE_INFO']"));
					System.out.println("type: "+type);
					wait.until(ExpectedConditions.elementToBeClickable(type));
					if(type.getText().equalsIgnoreCase(adjType)){
						type.click();
						break;
					}
				}
				driver.switchTo().window(main);
				return true;
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to selecting Adjustment Type: "+adjType);
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_FIN.02 - 2020-07-27 - Start Remove
	 */
//	public boolean cancelAdjusment() throws Exception{
//		try {
//			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
//			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBtn.toWebElement()));
//			repo.cancelBtn.toWebElement().click();
//			return true;
//		} catch (Exception e) {
//			System.out.println(e.getLocalizedMessage());
//			errorHandle.ExceptionHandle(screenshot, driver, "Failed to cancel Adjustment");
//			logger.log(e);
//			return false;
//
//		}
//	}
//	
//	public boolean selectCancelReason(String reason) throws Exception {
//		try {
//			String main = driver.getWindowHandle();
//			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//			Set<String> windowHandles = driver.getWindowHandles();
//			String popWindow = "";
//			for (String windowHandle : windowHandles) {
//				if (!main.equalsIgnoreCase(windowHandle)) {
//					popWindow = windowHandle;
//				}
//			}
//			
//			if (popWindow != null) {
//				driver.switchTo().window(popWindow);
//			}else {
//				return false;
//			}	
//			
//			WebDriverWait popWait = new WebDriverWait(driver, 10);
//			if(isElementPresent(repo.moreInfo.getLocator())){
//				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
//				repo.moreInfo.toWebElement().click();
//				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
//				repo.overridelink.toWebElement().click();
//			}
//			
//			popWait.until(ExpectedConditions.visibilityOf(repo.cancelTable.toWebElement()));
//			popWait.until(ExpectedConditions.elementToBeClickable(repo.cancelReason.toWebElement()));
//			repo.cancelReason.selectTextAs(reason);
//			popWait.until(ExpectedConditions.elementToBeClickable(repo.cancelAdj.toWebElement()));
//			repo.cancelAdj.toWebElement().click();
//			driver.switchTo().window(main);
//			
//			return true;
//		} catch (Exception e) {
//			System.out.println(e.getLocalizedMessage());
//			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Cancel Reason: " + reason);
//			logger.log(e);
//			return false;
//		}
//	}
	/*
	 * CP_FIN.02 - 2020-07-27 - End Remove
	 */
	
	
	/*
	 * CP_FIN.02 - 2020-06-01 - End Add
	 */

	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
