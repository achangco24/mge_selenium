/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Meter Read
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN					Reason text.
 * 2020-07-08	RExtra	CP_BI.002	Add components to CancelRebilling a Bill Segment          
 * 
 *************************************************************************************
 */
package aut.menu.meterread.read;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.entity.Entity;
import aut.entity.IEntity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class MeterRead extends Entity implements IEntity {	
	private MeterReadObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private RegisterRead registerRead;
	private Ccb ccb;
	
	public RegisterRead registerRead() {
		return this.registerRead;
	}
	
	public MeterRead(Ccb ccb) {	
		this.pageTitle = "Meter Read";
		this.idHolder = "MR_ID";
		this.charGridFrame = By.id("MR_CHAR");
		this.charHeader = "MR_CHAR";
		
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);
		this.ccb = ccb;
		
		repo = new MeterReadObjects(ccb.getDriver(), ccb.getCcbFrames());
		registerRead = new RegisterRead(ccb.getDriver(), ccb.getWait(), ccb.getCcbObjects());
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
		commons.menu.meterRead.meterRead.add();
		return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Meter Read Page");
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean hasMeterConfigLoaded() throws Exception {
		String meterInfo = repo.meterConfigInfo.toWebElement().getAttribute("innerHTML");
		if (meterInfo.equals(emptySpan)) {
			return false;
		}
		
		return true;
	}
	
	
	public boolean enterMeterConfigId(String meterConfigId) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.meterConfigId.toWebElement()));
			repo.meterConfigId.toWebElement().sendKeys(meterConfigId);
			repo.meterConfigId.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.meterConfigInfo.waitWhileAttributeValue("innerHTML", emptySpan);
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Meter Config: " + meterConfigId);
			logger.log(e);
			return false;
			}
		
	}
	
	
	public boolean enterReadDate(String readDate) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.readDate.toWebElement()));
			repo.readDate.toWebElement().sendKeys(readDate);
			repo.readDate.toWebElement().sendKeys(Keys.chord(Keys.TAB));
			repo.readDate.waitWhileAttributeValue("value", "");
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Read Date: " + readDate);
			logger.log(e);
			return false;
		}

	}
	
	
	public boolean enterReadTime(String readTime) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.readTime.toWebElement()));
			repo.readTime.toWebElement().sendKeys(readTime);
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Read Time: " + readTime);
			logger.log(e);
			return false;
		}
		
	}
	
	
	public boolean saveMeterRead() throws Exception {
		try {
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Meter Read");
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
			System.out.println("Succesfully Created a Meter Read with ID :" + getId());
			logger.log("Succesfully Created a Meter Read with ID :" +getId());
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Meter Read ID Exist");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addMeterReading(String regReading) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.useOnBill.toWebElement()));
			repo.useOnBill.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(commons.save.toWebElement()));
			save();
			String prevDate = repo.readDate.toWebElement().getAttribute("value");
			String prevTime = repo.readTime.toWebElement().getAttribute("value");
			repo.meterConfigMenu.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(repo.meterReadOption.toWebElement()));
			repo.meterReadOption.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(repo.addMeterConfig.toWebElement()));
			repo.addMeterConfig.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(repo.readDate.toWebElement()));
			repo.readDate.toWebElement().sendKeys(prevDate);
			wait.until(ExpectedConditions.attributeToBeNotEmpty(repo.readDate.toWebElement(), "value"));
			repo.readTime.toWebElement().click();
			repo.readTime.toWebElement().sendKeys(prevTime);
			wait.until(ExpectedConditions.elementToBeClickable(repo.readType.toWebElement()));
			repo.readType.toWebElement().click();
			repo.officeEst.toWebElement().click();
			repo.regReading.toWebElement().click();
			repo.regReading.toWebElement().sendKeys(regReading);
			repo.readTime.toWebElement().click();
			save();
			pause(5000);
			repo.lastBilled.toWebElement().click();
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to add Meter Reading");
			logger.log(e);
			return false;
		}
	}
	
	public void pause(Integer milliseconds){
	    try {
	        TimeUnit.MILLISECONDS.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	public boolean searchForMeterReadID(String meterReadID) throws Exception {
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
			popWait.until(ExpectedConditions.elementToBeClickable(repo.popMeterReadID.toWebElement()));
			repo.popMeterReadID.toWebElement().click();
			repo.popMeterReadID.toWebElement().clear();
			repo.popMeterReadID.toWebElement().click();
			repo.popMeterReadID.toWebElement().clear();
			repo.popMeterReadID.toWebElement().sendKeys(meterReadID);
			
			popWait.until(ExpectedConditions.elementToBeClickable(repo.popMeterReadIDSearchBtn.toWebElement()));
			repo.popMeterReadIDSearchBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Search Successful: " + meterReadID);
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Search Meter Read with ID: " + meterReadID);
			logger.log(e);
			return false;
		}
	}
	
	
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	
}

