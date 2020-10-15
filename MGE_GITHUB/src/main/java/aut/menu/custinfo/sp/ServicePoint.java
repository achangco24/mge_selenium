/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Service Point
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-23	GSando	CI.018. Add components for adding a Service Point Record
 * 								to a Premise.                 
 * 2020-10-08	JMalayo	CP.3.1.1.003 Service Cycle Updates BIlling Cycle
 *************************************************************************************
 */
package aut.menu.custinfo.sp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class ServicePoint extends Entity {
	private ServicePointObjects repo;
	
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public ServicePoint(Ccb ccb) {
		this.pageTitle = "Service Point";
		this.idHolder = "SP_ID";
		this.charGridFrame = By.id("spGrid_spChrGrid");
		this.charHeader = "SP_CHAR";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);
		this.ccb = ccb;
		repo = new ServicePointObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.customerInformation.servicePoint.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Service Point Page");
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean hasPremiseLoaded() throws Exception {
		String premiseInfo = repo.premiseInfo.toWebElement().getAttribute("innerHTML");
		if (premiseInfo.equals(emptySpan)) {
			return false;
		}
		
		return true;
	}
	
	
	public boolean enterPremiseId(String premiseId) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.premiseId.toWebElement()));
			repo.premiseId.toWebElement().sendKeys(premiseId);
			repo.premiseId.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.premiseInfo.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Premise ID: " + premiseId);
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean enterSpType(String spType) throws Exception {
		try {
			//wait.until(ExpectedConditions.elementToBeClickable(repo.spTypeCode.toWebElement()));
			/*
			 * CI.018 - 2020-04-23 - Start Change
			 */
			//repo.spTypeCode.toWebElement().sendKeys(spType);
			//repo.spTypeCode.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			//repo.spTypeDescription.waitWhileAttributeValue("innerHTML", emptySpan);
			//System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			//System.out.println(driver.getPageSource());
			//System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.spTypeCode.toWebElement()));
			String idHolder = repo.spTypeCode.toWebElement().getAttribute("id");
			repo.spTypeCode.toWebElement().click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + spType + "'");
	       	repo.spTypeCode.toWebElement().sendKeys(Keys.ENTER);
	       	/*
			 * CI.018 - 2020-04-23 - End Change
			 */
	       	return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter SP Type: " + spType);
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean enterLocation(String location) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.locationCode.toWebElement()));
			/*
			 * CI.018 - 2020-04-23 - Start Change
			 */
			//repo.locationCode.toWebElement().sendKeys(location);
			//repo.locationCode.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			//repo.locationInfo.waitWhileAttributeValue("innerHTML", emptySpan);
			String idHolder = repo.locationCode.toWebElement().getAttribute("id");
			repo.locationCode.toWebElement().click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + location + "'");
	       	repo.locationCode.toWebElement().sendKeys(Keys.ENTER);
	       	/*
	    	 * CI.018 - 2020-04-23 - End Change
	    	 */
	       	return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Location: " + location);
			logger.log(e);
			return false;
		}
	}
	
	public boolean openSPContextMenu() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.spContextMenu.toWebElement()));
			repo.spContextMenu.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click SP context menu.");
			logger.log(e);
			return false;
		}
	}

	public boolean addMeterRead()throws Exception{
		try {
			openSPContextMenu();
			wait.until(ExpectedConditions.elementToBeClickable(repo.spMtrReadMenu.toWebElement()));
			repo.spMtrReadMenu.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to add Meter Read.");
			logger.log(e);
			return false;
		}
	}
	
	/* Lui 10/15: Incomplete method but this will handle pop-up window for SP search if more than SP under Premise
	public boolean searchPopUpSPId(String spid) throws Exception {
		try {
			boolean ssl = false;
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> id = driver.getWindowHandles();
			Iterator<String> pages = id.iterator();
			String main = pages.next();
			String windows = "";
			while(pages.hasNext()) {
				windows = pages.next();
			}
			driver.switchTo().window(windows);
			ssl = isElementPresent(repo.moreInfo.getLocator());
			if (ssl == false) {
				String temp = windows;
				windows = main;
				main = temp;
				driver.switchTo().window(windows);
			}
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			//popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
			repo.moreInfo.toWebElement().click();
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
			repo.overridelink.toWebElement().click();
//			popWait.until(ExpectedConditions.elementToBeClickable(repo.ftid.toWebElement()));
//			repo.ftid.toWebElement().click();
//			repo.ftid.toWebElement().sendKeys(spid);
			
//			SEARCH_RESULTS:0$DESCR_SPT
			
			for(int ctr=0; ctr<3; ctr++) {
				String text = repo.
//				if ()
			}
			
//			popWait.until(ExpectedConditions.elementToBeClickable(repo.searchBtn.toWebElement()));
//			repo.searchBtn.toWebElement().click();
//			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
//			driver.switchTo().window(main);
//			logger.log("Search Successful: " + ftid);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
//			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching ID in Pop up");
//			logger.log(e);
    		return false;
		}
	}
	*/
	
	/*
	 * CI.018 - 2020-04-23 - Start Add
	 */	
	public boolean enerServiceCycle(String serviceCycle) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.serviceCycle.toWebElement()));
			repo.serviceCycle.toWebElement().click();
			String idHolder = repo.serviceCycle.toWebElement().getAttribute("id");
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + serviceCycle + "'");
	       	repo.serviceCycle.toWebElement().sendKeys(Keys.ENTER);
	       	return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Service Cycle: " + serviceCycle);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enerServiceRoute(String serviceRoute) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.serviceRoute.toWebElement()));
			repo.serviceRoute.toWebElement().click();
			String idHolder = repo.serviceRoute.toWebElement().getAttribute("id");
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + serviceRoute + "'");
	       	repo.serviceRoute.toWebElement().sendKeys(Keys.ENTER);
	       	return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Service Route: " + serviceRoute);
			logger.log(e);
			return false;
		}
	}
	
	public boolean saveSP() throws Exception {
		try {
			save();
			save();
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Service Point");
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
				System.out.println("Succesfully Created a Service Point with ID: " + getId());
				logger.log("Succesfully Created a Service Point with ID: " +getId());
			}
			if(mode.equalsIgnoreCase("Update")){
				System.out.println("Succesfully Updated a Service Point with ID: " + getId());
				logger.log("Succesfully Updated a Service Point with ID: " +getId());
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Service Point ID Exist");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CI.018 - 2020-04-23 - End Add
	 */
	
	/*
	 * CP_FS.009 - 2020-06-22 - Start Add
	 */
	public boolean setSPSourceStatus(String status) throws Exception {
		try {
			WebDriverWait popWait = new WebDriverWait(driver, 30);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.spSourceStatus.toWebElement()));
			repo.spSourceStatus.selectTextAs(status);
	       	return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set SP Source Status to '" + status + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setDisconnectLoc(String loc) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.disconnectLoc.toWebElement()));
			repo.disconnectLoc.selectTextAs(loc);
	       	return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Disconnect Location to '" + loc + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean clickBackButton() throws Exception {
		try {
			Thread.sleep(1000);
			back();
	       	return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on clicking Back button on SP Page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean switchToTabMain() throws Exception{
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(tabs.main.getWebElement()));
			tabs().main.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to SP - Main");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_FS.009 - 2020-06-22 - End Add
	 */
	
	
	/*
	 * CP.3.1.1.003 - 2020-10-08 - JMalayo - Start Add
	 */
	public boolean clickRecordActionsEditButton() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.spEditBtn.toWebElement()));
			repo.spEditBtn.toWebElement().click();
	       	return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Record Action's Edit Button.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean seletMeasurementCycle(String measurementCycle) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.spMeasurementCycle.toWebElement()));
			repo.spMeasurementCycle.selectTextAs(measurementCycle);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Measurement Cycle: " + measurementCycle);
			logger.log(e);
			return false;
		}
	}
	
	public boolean clickRecordActionEditSaveBtn() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.spSaveBtn.toWebElement()));
			repo.spSaveBtn.toWebElement().click();
	       	return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Save Button on Service Point.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean clickSPQuerySPLink() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.spQueryTblLink.toWebElement()));
			repo.spQueryTblLink.toWebElement().click();
	       	return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Service Point.");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.1.003 - 2020-10-08 - JMalayo - End Add
	 */
}