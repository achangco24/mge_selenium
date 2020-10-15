/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Write Off Process
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-05-12	RExtra	CP_CC.007	Add components for Adding a Write Off Process
 * 2020-05-13	RExtra	CP_CC.015	Add components for Canceling a Write Off Process
 * 2020-05-143	RExtra	CP_CC.022	Add components for Modifying a Write Off Event
 * 									Trigger Date
 * 
 *************************************************************************************
 */
package aut.menu.creditcoll.writeoff;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ey.manila.qa.automation.CalendarUtil;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import aut.Ccb;
import aut.entity.Entity;
import aut.menu.creditcoll.collection.CollectionObjects;

public class WriteOff extends Entity{
	private WriteOffObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public WriteOff(Ccb ccb) throws Exception {
		this.pageTitle = "Write Off Process";
		this.idHolder = "WO_PROC_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new WriteOffObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	/*
	 * CP_CC.007 - 2020-05-12 - Start Add
	 */
	
	public boolean select_write_off_ctrl(String writeOffCtrl) throws Exception {
		try{
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.img_writeOffCtrl.toWebElement()));
			repo.img_writeOffCtrl.toWebElement().click();
			
			Thread.sleep(3000);
			
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
			driver.findElement(By.id("overridelink")).click();
			Thread.sleep(1000);
			
			popWait.until(ExpectedConditions.visibilityOf(repo.writeOffCtrlTbl.toWebElement()));
			
			List <WebElement> tableRows = repo.writeOffCtrlTbl.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
			int tableSize = tableRows.size();
			for(int a = 0; a<tableSize;a++) {
				WebElement row = driver.findElement(By.xpath("//*[@id='dataTableBody']/tr[" + (a+1) +"]/td[1]/span"));
				wait.until(ExpectedConditions.elementToBeClickable(row));
				if(row.getAttribute("innerHTML").equalsIgnoreCase(writeOffCtrl)){
					row.click();
					break;
				}
			}
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Selecting Write Off Control");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean select_write_off_process_template(String writeOffCtrl) throws Exception {
		try{
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.writeOffTmpltCd.toWebElement()));
			repo.writeOffTmpltCd.selectTextAs(writeOffCtrl);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Selecting Write Off Process Template");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean addComments(String comments) throws Exception {
		try {
			Thread.sleep(2000);
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.comment.toWebElement()));
			repo.comment.toWebElement().clear();
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.comment.toWebElement()));
			repo.comment.toWebElement().click();
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.comment.toWebElement()));
			repo.comment.toWebElement().sendKeys(comments);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Adding Write Off Comments");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean switchToSATab() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.sa.getWebElement()));
			tabs().sa.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to SA Tab");
			logger.log(e);
			return false;
		}
	}
	
	public boolean linkSA(String saID) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.saID.toWebElement()));
			repo.saID.toWebElement().sendKeys(saID);
			wait.until(ExpectedConditions.elementToBeClickable(repo.sa_info.toWebElement()));
			repo.sa_info.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Link SA to Process Collection");
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean verifyWriteOffStatus() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.saWoStatFlg.toWebElement()));
			String status = repo.saWoStatFlg.toWebElement().getAttribute("value");
			if(status.equals("10")) {
				return true;
			} else{
				System.out.println("Write Off Status is not Active");
				return false;
			}
			//wait.until(ExpectedConditions.elementToBeClickable(repo.sa_info.toWebElement()));
			//return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Link SA to Process Collection");
			logger.log(e);
			return false;
		}
	}
	
	public boolean saveWoProc(String mode) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(commons.save.toWebElement()));
			save();
			checkIDExist(mode);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Write Off Process");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CC.007 - 2020-05-12 - End Add
	 */
	
	/*
	 * CP_CC.015 - 2020-05-13 - Start Add
	 */
	public boolean setWOProcCancelReason() throws Exception{
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.reason.toWebElement()));
			repo.reason.toWebElement().sendKeys("Events Pending");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Set Write Off Process Cancellation Reason");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setWOProcCancelComments(String comments) throws Exception{
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.comment.toWebElement()));
			repo.comment.toWebElement().clear();
			repo.comment.toWebElement().click();
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.comment.toWebElement()));
			repo.comment.toWebElement().sendKeys(comments);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Set Write Off Process Cancellation Reason");
			logger.log(e);
			return false;
		}
	}
	
	public boolean cancel_wo_proc() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBtn.toWebElement()));
			repo.cancelBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Initiate Write Off Process Cancellation");
			logger.log(e);
			return false;
		}
	}
	
	public boolean confirm_cancel_wo_proc() throws Exception{
		try {
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
				
				Thread.sleep(2000);
				System.out.println("Successfully cancelled Write Off Process with ID: " + getId());
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Confirm Write Off Process Cancellation");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CC.015 - 2020-05-13 - End Add
	 */
	
	/*
	 * CP_CC.022 - 2020-05-14 - Start Add
	 */
	public boolean add_modify_comment(String comment) throws Exception {
		try {
			Thread.sleep(2000);
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.comment.toWebElement()));
			repo.comment.toWebElement().clear();
			repo.comment.toWebElement().click();
			repo.comment.toWebElement().sendKeys(comment);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on Entering Modification Comment");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean switchToEventsTab() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.events.getWebElement()));
			tabs().events.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Events Tab");
			logger.log(e);
    		return false;
		}
	}
	
	
	public boolean findEventSequence(String targetSequence) throws Exception {
		try {
			Thread.sleep(2000);
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.eventRecordCnt.toWebElement()));
			String recordCountStr = repo.eventRecordCnt.toWebElement().getText();
			boolean foundSequence = false;

			int lastIndex = Integer.parseInt(recordCountStr.split(" of ")[1]);
			
			for(int index=0; index < lastIndex; index++){
				Thread.sleep(3000);
				screenWait.until(ExpectedConditions.elementToBeClickable(repo.eventSequence.toWebElement()));
				String currentSequence = repo.eventSequence.toWebElement().getAttribute("value");
				if(currentSequence.equals(targetSequence)){
					foundSequence = true;
					break;
				}else {
					screenWait.until(ExpectedConditions.elementToBeClickable(repo.eventRightArrow.toWebElement()));
					repo.eventRightArrow.toWebElement().click();
				}
			}
			
			if(foundSequence){
				System.out.println("Found Event Sequence '" + targetSequence + "' for Write Off Process " + getId());
				return true;
			}
			else{
				System.out.println("Unable to find Event Sequence '" + targetSequence + "' for Write Off Process " + getId());
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on Entering Modification Comment");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean enterNewTriggerDate(String newTriggerDate) throws Exception {
		try {
			String main = driver.getWindowHandle();
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.eventTriggerDate.toWebElement()));
			
			commons.eventTriggerDateBtn.toWebElement().click();
			Thread.sleep(2000);
			screenWait.until(ExpectedConditions.numberOfWindowsToBe(2));
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
			
			Thread.sleep(2000);
			
			DateTimeFormatter dateFormat = DateTimeFormatter.ISO_DATE.ofPattern("MM-dd-yyyy");
			LocalDate targetDate = LocalDate.parse(newTriggerDate, dateFormat);
			String targetMonth = targetDate.getMonth().name();
			String targetYear = String.valueOf(targetDate.getYear());
			String targetDay = String.valueOf(targetDate.getDayOfMonth());

			driver.findElement(By.id("overridelink")).click();
			Thread.sleep(1000);
			
			CalendarUtil calUtil = new CalendarUtil(driver, newTriggerDate);
			calUtil.navigateToTargetMonth(targetMonth);
			calUtil.setYearValue(targetYear);
			calUtil.selectDay(targetDay);

			driver.switchTo().window(main);
			
			repo.woProcInfo.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on Entering New Event Trigger Date");
			logger.log(e);
    		return false;
		}
	}
	/*
	 * CP_CC.022 - 2020-05-14 - End Add
	 */
	
	
	
	/*
	 * Utility Block - Start
	 */
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
			
			if(mode.equals("Add")) {
				System.out.println("Succesfully Created Write Off Process with ID :" + getId());
				logger.log("Succesfully Created Write Off Process with ID :" + getId());
			}
			
			if(mode.equals("Update")) {
				System.out.println("Succesfully Updated Write Off Process with ID :" + getId());
				logger.log("Succesfully Updated Write Off Process with ID :" + getId());
			}
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Write Off Process ID Exist");
			logger.log(e);
			return false;
		}
	}
	/*
	 * Utility Block - End
	 */
	
	

	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
