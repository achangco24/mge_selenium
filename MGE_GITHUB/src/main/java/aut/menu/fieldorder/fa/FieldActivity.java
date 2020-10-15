/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Field Activity
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-20	GSando	FS.001. 	Add components for adding a Field Activity.      
 * 2020-04-21	GSando	FS.003. 	Add components for canceling a Field Activity. 
 * 2020-06-04	RExtra	CP_FS.001.	Add components to Create a New FA Manually.
 * 2020-06-19	RExtra	CP_FS.002.	Add components to Update Existing FA Schedule
 * 									Date.
 * 2020-06-22	RExtra	CP_FS.009.	Add components to Create and Complete FA.
 * 
 *************************************************************************************
 */
package aut.menu.fieldorder.fa;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class FieldActivity extends Entity{
	private FieldActivityObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public FieldActivity(Ccb ccb) {
		this.pageTitle = "Field Activity";
		this.idHolder = "FA_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new FieldActivityObjects(ccb.getDriver(), ccb.getCcbFrames());
	}

	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.fieldOrder.fieldActivity.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed loading Field Activity page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setFAType(String type) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.faType.toWebElement()));
			repo.faType.toWebElement().sendKeys(type);
			//repo.faType.toWebElement().sendKeys(Keys.TAB);
			repo.comments.toWebElement().click();	//other option instead of Tab key.
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input FA Type: " + type);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterSchedDate(String schedDate) throws Exception {
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.schedDate.toWebElement()));
			
			/*
			 * CP_FS.001 - 2020-06-04 - Start Change
			 */
			
			
			/*
			 * FS.001 - 2020-04-20 - Start Add
			 */
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById(\"" + repo.schedDate.toWebElement().getAttribute("id") + "\").value = '" + schedDate + "'");
			repo.schedDate.toWebElement().sendKeys(Keys.TAB);
			
			repo.schedDate.toWebElement().click();
			/*
			 * FS.001 - 2020-04-20 - End Add
			 */
			//repo.schedDate.toWebElement().sendKeys(schedDate);
			//repo.schedDate.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.comments.toWebElement().click();	//other option instead of Tab key.
			/*
			 * CP_FS.001 - 2020-06-04 - End Change
			 */
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Schedule Date: " + schedDate);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterSchedTime(String schedTime) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.schedTime.toWebElement()));
			
			/*
			 * CP_FS.001 - 2020-06-04 - Start Add
			 */
			repo.schedTime.toWebElement().clear();
			repo.schedTime.toWebElement().click();
			/*
			 * CP_FS.001 - 2020-06-04 - End Add
			 */
			
			/*
			 * CP_FS.001 - 2020-06-04 - Start Change
			 */
			//repo.schedTime.toWebElement().sendKeys(schedTime);
			repo.schedTime.toWebElement().sendKeys(schedTime, Keys.TAB);
			/*
			 * CP_FS.001 - 2020-06-04 - End Change
			 */
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Schedule Time: " + schedTime);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterDispatchGrp(String group) throws Exception {
		try {
			String main = driver.getWindowHandle();
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.dispatchGrpSearchBtn.toWebElement()));
			
			repo.dispatchGrpSearchBtn.toWebElement().click();
			Thread.sleep(2000);
			screenWait.until(ExpectedConditions.numberOfWindowsToBe(2));
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
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
			repo.overridelink.toWebElement().click();
			Thread.sleep(2000);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.dispatchGrp.getLocator()));
			repo.popup_dispatchGrp.toWebElement().sendKeys(group);
			repo.popup_dispatchGrp_SearchBtn.toWebElement().click();
			
			driver.switchTo().window(main);
			
			//save();
			//System.out.println("Successfully Created Field Activity with ID: " + getId());
			
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Dispatch Group: " + group);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setFAPriority(String priority) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.faPriority.toWebElement()));
			repo.faPriority.selectTextAs(priority);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set FA Priority: " + priority);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterComments(String comments) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.comments.toWebElement()));
			repo.comments.toWebElement().sendKeys(comments);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input FA Comments: " + comments);
			logger.log(e);
			return false;
		}
	}
	
	public boolean saveFA() throws Exception {
		try {
			save();
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Field Activity");
			logger.log(e);
			return false;
		}
	}
	
	public boolean checkIDExist(String mode) throws Exception{
		try {
			boolean flag = checkid();
			if(flag == false) {
				screenshot.capture();
				driver.close();
				driver.quit();
				return false;
			}
			screenshot.capture();
			if(mode.equalsIgnoreCase("Add")){
				System.out.println("Succesfully Created a Field Activity with ID :" + getId());
				logger.log("Succesfully Created a Field Activity with ID :" +getId());
			}
			if(mode.equalsIgnoreCase("Update")){
				System.out.println("Succesfully Updated Field Activity with ID :" + getId());
				logger.log("Succesfully Updated Field Activity with ID :" +getId());
			}
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Field Activity ID Exist");
			logger.log(e);
			return false;
		}
	}
	
	public boolean findPendingFA() throws Exception {
		try {
//			boolean ssl = false;
//			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//			Set<String> id = driver.getWindowHandles();
//			Iterator<String> pages = id.iterator();
//			String main = pages.next();
//			String windows = "";
//			while(pages.hasNext()) {
//				windows = pages.next();
//			}
//			driver.switchTo().window(windows);
//			ssl = isElementPresent(repo.moreInfo.getLocator());
//			if (ssl == false) {
//				String temp = windows;
//				windows = main;
//				main = temp;
//				driver.switchTo().window(windows);
//			}
			String main = driver.getWindowHandle();
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> windowHandles = driver.getWindowHandles();
			String popWindow = "";
			int i = 0;
			for (String windowHandle : windowHandles) {
				i += 1;
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
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
			repo.moreInfo.toWebElement().click();
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
			repo.overridelink.toWebElement().click();
			popWait.until(ExpectedConditions.visibilityOf(repo.faInfoTable.toWebElement()));
			
			List <WebElement> tableRows = repo.faInfoTable.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
			int tableSize = tableRows.size();
			for(int a = 0; a<tableSize;a++) {
				WebElement row = driver.findElement(By.xpath("//*[@id='dataTableBody']/tr[" + (a+1) +"]/td[5]/span"));
				wait.until(ExpectedConditions.elementToBeClickable(row));
				if(row.getAttribute("innerHTML").equalsIgnoreCase("Pending")){
					row.click();
					break;
				}
			}
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to find Pending FA");
			logger.log(e);
			return false;
		}
	}

	public boolean completeFA() throws Exception{
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			wait.until(ExpectedConditions.elementToBeClickable(repo.secFaAction.toWebElement()));
			repo.secFaAction.toWebElement().click();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to complete FA");
			logger.log(e);
			return false;

		}
	}
	
	/*
	 * FS.001 - 2020-04-20 - Start Add
	 */
	public boolean enterInstructions(String faInstructions) throws Exception {
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.instructions.toWebElement()));
			repo.instructions.toWebElement().sendKeys(faInstructions);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input FA Instructions: " + faInstructions);
			logger.log(e);
			return false;
		}
	}
	/*
	 * FS.001 - 2020-04-20 - End Add
	 */
	
	/*
	 * FS.003 - 2020-04-21 - Start Add
	 */
	public boolean cancelFA() throws Exception{
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBtn.toWebElement()));
			repo.cancelBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to cancel FA");
			logger.log(e);
			return false;

		}
	}
	
	public boolean selectCancelReason(String reason) throws Exception {
		try {
			String main = driver.getWindowHandle();
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
			
			popWait.until(ExpectedConditions.visibilityOf(repo.cancelTable.toWebElement()));
			popWait.until(ExpectedConditions.elementToBeClickable(repo.cancelReason.toWebElement()));
			repo.cancelReason.selectTextAs(reason);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.cancelFA.toWebElement()));
			repo.cancelFA.toWebElement().click();
			driver.switchTo().window(main);
			
			System.out.println("Successfully Cancelled FA with ID: " + getId());
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Cancel Reason: " + reason);
			logger.log(e);
			return false;
		}
	}
	/*
	 * FS.003 - 2020-04-21 - End Add
	 */
	
	/*
	 * CP_FS.001 - 2020-06-04 - Start Add
	 */
	public boolean setServicePointID(String spID) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.spid.toWebElement()));
			String currentSP = repo.spid.toWebElement().getAttribute("value");
			if(spID.equals(currentSP)){
				return true;
			} else{
				repo.spid.toWebElement().clear();
				repo.spid.toWebElement().click();
				repo.spid.toWebElement().sendKeys(spID, Keys.TAB);
				return true;
			}			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Service Point with ID: " + spID);
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_FS.001 - 2020-06-04 - End Add
	 */
	
	/*
	 * CP_FS.002 - 2020-06-19 - Start Add
	 */
	public boolean search() throws Exception {
		try {
			try {
				driver.switchTo().defaultContent();
				commons.menu.fieldOrder.fieldActivity.search();
			}catch(Exception e) {
				driver.switchTo().parentFrame();
				commons.menu.fieldOrder.fieldActivity.search();
			}
			
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Field Activity");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean searchPopUpFAId(String faID) throws Exception {
		try {
			String main = driver.getWindowHandle();
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
			
			if(isElementPresent(repo.overridelink.getLocator())){
				wait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			wait.until(ExpectedConditions.elementToBeClickable(repo.popUp_faID.toWebElement()));
			repo.popUp_faID.toWebElement().click();
			repo.popUp_faID.toWebElement().clear();
			
			repo.popUp_faID.toWebElement().click();
			repo.popUp_faID.toWebElement().clear();
			repo.popUp_faID.toWebElement().sendKeys(faID);
			
			repo.popUp_spID.toWebElement().click();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.popUp_faIDSearchBtn.toWebElement()));
			repo.popUp_faIDSearchBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Search Successful: " + faID);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching FA ID in Pop up: " + faID);
			logger.log(e);
    		return false;
		}
	}
	/*
	 * CP_FS.002 - 2020-06-19 - End Add
	 */
	
	
	
	/*
	 * CP_FS.009 - 2020-06-22 - Start Add
	 */
	public boolean switchToStepsTab() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.steps.getWebElement()));
			tabs.steps.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "FA - Failed to Navigate to Steps Tab");
    		return false;
		}
	}
	
	public boolean navToLinkedSP() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.stepsTable.toWebElement()));
			
			List <WebElement> tableRows = repo.stepsTable.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
			int tableSize = tableRows.size();
			for(int x = 0; x < tableSize; x++) {
				WebElement refType = driver.findElement(By.xpath("//*[@id='dataTableBody']/tr[" + (x+1) +"]/td[4]/span"));
				if(refType.getText().equalsIgnoreCase("Service Point ID")){
					WebElement link = driver.findElement(By.id("IM_FA_STEP:" + x + "$GO_TO_BTN"));
					link.click();
					break;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "FA - Failed to Navigate to Linked SP");
    		return false;
		}
	}
	
	public boolean completeFieldActivity() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.completeBtn.toWebElement()));
			repo.completeBtn.toWebElement().click();
			
			
			System.out.println("Successfully Completed FA with ID: " + getId());
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "FA - Failed to Complete FA");
    		return false;
		}
	}
	/*
	 * CP_FS.009 - 2020-06-22 - End Add
	 */
}
