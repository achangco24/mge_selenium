/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Adjustment
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN					Reason text.
 * 2020-06-01	RExtra	CP_FIN.02	Update Steps to accommodate change due to SQL
 * 									Integration
 * 
 *************************************************************************************
 */
package aut.menu.financial.adjustment;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class Adjustment extends Entity {
	private AdjustmentObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public Adjustment(Ccb ccb) {
		this.pageTitle = "Adjustment";
		this.idHolder = "ADJ_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new AdjustmentObjects(ccb.getDriver(), ccb.getCcbFrames());
	}

	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.financial.adjustment.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed loading Adjustment page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setSAID(String id) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.said.toWebElement()));
			repo.said.toWebElement().sendKeys(id);
			repo.said.toWebElement().sendKeys(Keys.ENTER);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input SA ID: " + id);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterTransferSaId(String id) throws Exception {
		String idHolder = repo.said2.toWebElement().getAttribute("id");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.said2.toWebElement()));
//			repo.said2.toWebElement().sendKeys(id);
			//Replace the .sendKeys as it is not working after pop-up window 
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + id + "'");
			repo.said2.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input SA ID: " + id);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setAdjustmentType(String type) throws Exception {
		String idHolder = repo.adjustmentType.toWebElement().getAttribute("id");
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.adjustmentType.toWebElement()));
//			repo.adjustmentType.toWebElement().sendKeys(type);
			//Replace the .sendKeys as it is not working after pop-up window 
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + type + "'");
	       	repo.adjustmentType.toWebElement().sendKeys(Keys.TAB);
	       	
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Adjustment Type: " + type);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterAmount(String amt) throws Exception {
		String idHolder = repo.amount.toWebElement().getAttribute("id");
		String[] acctInformation = repo.accountInfo.toWebElement().getText().split(",");
		try {
//			wait.until(ExpectedConditions.elementToBeClickable(repo.amount.toWebElement()));
			repo.amount.toWebElement().click();
			repo.adjustmentType.toWebElement().click();
	       	repo.adjustmentTypeInfo.waitWhileAttributeValue("innerHTML", emptySpan);
			repo.amount.toWebElement().clear();
			//TimeUnit.MILLISECONDS.sleep(5000);
			//Replacement for .sendKeys
			JavascriptExecutor js = (JavascriptExecutor)driver;
			if (amt.equalsIgnoreCase("0")) {
				js.executeScript("document.getElementById(\"" + idHolder + "\").value= '" + acctInformation[3].trim() + "'");
			} else {
				js.executeScript("document.getElementById(\"" + idHolder + "\").value= '" + amt + "'");
			}
			repo.amount.toWebElement().sendKeys(Keys.TAB);
			repo.mainComments.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Adjustment Amount: " + amt);
			logger.log(e);
			return false;
		}
	}
	
	public boolean searchPopUpAdjustmentId(String adjID) throws Exception {
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
				System.out.println("null popWindow");
				return false;
			}
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			
			if(isElementPresent(repo.overridelink.getLocator())){
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			
			popWait.until(ExpectedConditions.elementToBeClickable(repo.searchAdjID.toWebElement()));
			repo.searchAdjID.toWebElement().click();
			repo.searchAdjID.toWebElement().sendKeys(adjID);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.searchAdjID.toWebElement()));
			repo.searchAdjButton.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching Adjustment ID in Pop up");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean clickIconTransferSA(String said) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.searchIconSA.toWebElement()));
			repo.searchIconSA.toWebElement().click();
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
				System.out.println("null popWindow");
				return false;
			}
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
			repo.moreInfo.toWebElement().click();
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
			repo.overridelink.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Search Icon SA");
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterMainComments(String comments) throws Exception {
		String idHolder = repo.mainComments.toWebElement().getAttribute("id");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.mainComments.toWebElement()));
//			repo.comments.toWebElement().sendKeys(comments);
			//Replacement for .sendKeys
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("document.getElementById(\"" + idHolder + "\").value= '" + comments + "'");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Adjustment Main Comments: " + comments);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterTransferComments(String comments) throws Exception {
		String idHolder = repo.transferComments.toWebElement().getAttribute("id");
		try {
//			wait.until(ExpectedConditions.elementToBeClickable(repo.comments2.toWebElement()));
			repo.transferComments.toWebElement().click();
			repo.said2.toWebElement().click();
//	       	repo.transAdjInfo.waitWhileAttributeValue("innerHTML", emptySpan);
//			repo.comments.toWebElement().sendKeys(comments);
			//Replacement for .sendKeys
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("document.getElementById(\"" + idHolder + "\").value= '" + comments + "'");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Adjustment Transfer Comments: " + comments);
			logger.log(e);
			return false;
		}
	}
	
	public boolean switchToTabMain() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.main.getWebElement()));
			tabs().main.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Adjustment - Main");
			logger.log(e);
			return false;
		}
	}
	
	public boolean switchToTabChar() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.characteristics.getWebElement()));
			tabs().characteristics.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Adjustment - Characteristics");
			logger.log(e);
			return false;
		}
	}
	
	public boolean switchToTransAdj() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.transferAdj.getWebElement()));
			tabs().transferAdj.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Adjustment - Transfer Adjustment");
			logger.log(e);
			return false;
		}
	}
	
	public boolean generateAdjustment() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.generateBtn.toWebElement()));
			repo.generateBtn.toWebElement().click();
			calculateAdjustment();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to generate Adjustment");
			logger.log(e);
			return false;
		}
	}
	
	public boolean calculateAdjustment() throws Exception {
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
				System.out.println("null popWindow");
				return false;
			}
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			
			if(isElementPresent(repo.overridelink.getLocator())){
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			popWait.until(ExpectedConditions.elementToBeClickable(repo.calculateBtn.toWebElement()));
			repo.calculateBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Adjustment is in Freezable state");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in generating Adjustment");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean freezeAdjustment() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.freezeBtn.toWebElement()));
			repo.freezeBtn.toWebElement().click();
			freezeAdjustment2();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to freeze Adjustment");
			logger.log(e);
			return false;
		}
	}
	
	public boolean freezeAdjustment2() throws Exception {
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
				System.out.println("null popWindow");
				return false;
			}
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.freezeBtn2.toWebElement()));
			repo.freezeBtn2.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Adjustment is in Freezable state");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in generating Adjustment");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean saveAdjustment() throws Exception {
		try {
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to save Adjustment");
			logger.log(e);
			return false;
		}
	}
	
	public boolean checkIDExist() throws Exception{
		try {
			boolean flag = checkid();
			if(flag == false) {
				screenshot.capture();
				driver.close();
				driver.quit();
				return false;
			}
			screenshot.capture();
			System.out.println("Succesfully Created an Adjustment with ID :" + getId());
			logger.log("Succesfully Created an Adjustment with ID :" +getId());
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Adjustment ID Exist");
			logger.log(e);
			return false;
		}
	}
	
	public boolean deleteAdjustment() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.delete.toWebElement()));
			repo.delete.toWebElement().click();
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to delete Adjustment");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_FIN.02 - 2020-06-16 - Start Add
	 */
	public boolean save_cancel() throws Exception {
		try {
			save();
			System.out.println("Successfully Cancelled Adjustment with ID: " + getId());
			
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to delete Adjustment");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_FIN.02 - 2020-06-16 - End Add
	 */
	
	/*
	 * CP_FIN.02 - 2020-07-27 - Start Add
	 */
	public boolean search() throws Exception {
		try {
			try {
				driver.switchTo().defaultContent();
				commons.menu.financial.adjustment.search();
			}catch(Exception e) {
				driver.switchTo().parentFrame();
				commons.menu.financial.adjustment.search();
			}
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Adjustment Search");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean cancelAdjusment() throws Exception{
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBtn.toWebElement()));
			repo.cancelBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to cancel Adjustment");
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
			if(isElementPresent(repo.overridelink.getLocator())){
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			
			popWait.until(ExpectedConditions.elementToBeClickable(repo.cancelReason.toWebElement()));
			repo.cancelReason.selectTextAs(reason);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.cancelAdj.toWebElement()));
			repo.cancelAdj.toWebElement().click();
			driver.switchTo().window(main);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Cancel Reason: " + reason);
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_FIN.02 - 2020-07-27 - End Add
	 */
}
