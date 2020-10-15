/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Collection Process
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-05-05	RExtra	CP_CC.003	Add components for Adding a Collection Process
 * 2020-05-12	RExtra	CP_CC.010	Add components for Canceling a Collection Process
 * 2020-05-13	RExtra	CP_CC.020	Add components for Modifying Collection Event
 * 									Trigger Date 
 * 
 *************************************************************************************
 */
package aut.menu.creditcoll.collection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;






import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.CalendarUtil;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class Collection extends Entity{
	private CollectionObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public Collection(Ccb ccb) throws Exception {
		this.pageTitle = "Collection Process";
		this.idHolder = "COLL_PROC_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new CollectionObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.creditCollection.collections.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Collection Process page");
			logger.log(e);
			return false;
		}
	}

	public boolean search() throws Exception {
		try {
			try {
				driver.switchTo().defaultContent();
				commons.menu.creditCollection.collections.search();
			}catch(Exception e) {
				driver.switchTo().parentFrame();
				commons.menu.creditCollection.collections.search();
			}
			
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
//			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
//			if (!menuFlag) {
//				driver.switchTo().defaultContent();
//				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
//			}
//			commons.menu.creditCollection.collections.search();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Collection Process page");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean searchPopUpCollId(String collectionId) throws Exception {
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
			
			if(isElementPresent(repo.moreInfo.getLocator())){
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
				repo.moreInfo.toWebElement().click();
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			
			popWait.until(ExpectedConditions.elementToBeClickable(repo.collProdId.toWebElement()));
			repo.collProdId.toWebElement().click();
			repo.collProdId.toWebElement().clear();
			repo.collProdId.toWebElement().click();
			repo.collProdId.toWebElement().clear();
			repo.collProdId.toWebElement().sendKeys(collectionId);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.collProdIdSearchBtn.toWebElement()));
			repo.collProdIdSearchBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			System.out.println(driver.getTitle());
			logger.log("Search Successful: " + collectionId);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching Collection Process ID in Pop up: " + collectionId);
			logger.log(e);
    		return false;
		}
	}

	public List<String> collectionTable() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(repo.tableRow.toWebElement()));
		List <WebElement> rows = repo.tableRow.toWebElement().findElements(By.xpath("//*[@id=\'tStart\']/tbody/tr[2]/td[2]/div/table/tbody/tr"));
		List <String> eventList = new ArrayList<String>();
		int j = 0;
		for(int i = 1;i<=rows.size();i++) {			
			WebElement rowName = repo.tableRow.toWebElement().findElement(By.xpath("//*[@id=\'tStart\']/tbody/tr[2]/td[2]/div/table/tbody/tr[" + i + "]"));
			String strName = rowName.getText();
			int length = strName.length() - 10;

			if(strName.toLowerCase().contains("pending")) {
				eventList.add(strName.substring(length));
				j++;
				
			}

		}
		
		return eventList;
	}
	
	/*
	 * CP_CC.003 - 2020-05-05 - Start Add
	 */
	public boolean searchCollClassCtrl(String collClassCtrlCode) throws Exception {
		try{
			Thread.sleep(2000);
			WebDriverWait screenWait = new WebDriverWait(driver, 2000);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.collClassCtrlCode.toWebElement()));
			repo.collClassCtrlCode.toWebElement().sendKeys(collClassCtrlCode);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.collClassCtrlSearch.toWebElement()));
			repo.collClassCtrlSearch.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Enter Collection Class Control Code");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean select_coll_process_template(String collProcTmplt) throws Exception {
		try{
			Thread.sleep(5000);
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.collProcTmplCd.toWebElement()));
			repo.collProcTmplCd.selectTextAs(collProcTmplt);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Selecting Collection Process Template");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean enter_coll_amt_base_date() throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.collAmountBaseDate.toWebElement()));
			LocalDate currentDate = LocalDate.now();
			String strDate = currentDate.minusDays(40).format(DateTimeFormatter.ISO_DATE.ofPattern("MM-dd-yyyy"));
			repo.collAmountBaseDate.toWebElement().sendKeys(strDate, Keys.TAB);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Entering Collection Amount Base Date");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean set_coll_days_in_arrears(String days) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.daysInArrears.toWebElement()));
			repo.daysInArrears.toWebElement().clear();
			repo.daysInArrears.toWebElement().click();
			repo.daysInArrears.toWebElement().sendKeys(days);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Entering Collection Process Days in Arrears");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean add_comment(String comment) throws Exception {
		try {
			Thread.sleep(2000);
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			//System.out.println("RENZO: COMMENT >> " + comment);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.comment.toWebElement()));
			repo.comment.toWebElement().clear();
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.comment.toWebElement()));
			repo.comment.toWebElement().click();
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.comment.toWebElement()));
			repo.comment.toWebElement().sendKeys(comment);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Entering Comment");
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
			wait.until(ExpectedConditions.elementToBeClickable(repo.sa.toWebElement()));
			repo.sa.toWebElement().sendKeys(saID);
			wait.until(ExpectedConditions.elementToBeClickable(repo.sa_info.toWebElement()));
			repo.sa_info.toWebElement().click();
			//System.out.println("RENZO >> Link Success!");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Link SA to Process Collection");
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectSAStatus() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.sa_status.toWebElement()));
			repo.sa_status.toWebElement().sendKeys("Active");
			//System.out.println("RENZO >> Set Status!");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Select SA Status");
			logger.log(e);
			return false;
		}
	}
	
	public boolean saveCollProc(String mode) throws Exception{
		try {
			Thread.sleep(1000);
			repo.collProcInfo.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(commons.save.toWebElement()));
			save();
			checkIDExist(mode);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Collection Process");
			logger.log(e);
			return false;
		}
	}
	 
	/*
	 * CP_CC.003 - 2020-05-05 - End Add
	 */
	
	/*
	 * CP_CC.010 - 2020-05-12 - Start Add
	 */
	public boolean setCollProcCancelReason() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.reason.toWebElement()));
			repo.reason.toWebElement().sendKeys("Events Pending");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Set Collection Process Cancellation Reason");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setCollProcCancelComments(String comments) throws Exception{
		try {
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
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Set Collection Process Cancellation Reason");
			logger.log(e);
			return false;
		}
	}
	
	public boolean cancel_coll_proc() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBtn.toWebElement()));
			repo.cancelBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Initiate Collection Process Cancellation");
			logger.log(e);
			return false;
		}
	}
	
	public boolean confirm_cancel_coll_proc() throws Exception{
		try {
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				System.out.println("Successfully cancelled Collection Process with ID: " + getId());
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Confirm Collection Process Cancellation");
			logger.log(e);
			return false;
		}
	}
	
	 
	/*
	 * CP_CC.010 - 2020-05-12 - End Add
	 */
	
	
	/*
	 * CP_CC.020 - 2020-05-14 - Start Add
	 */
	public boolean add_modify_comment(String comment) throws Exception {
		try {
			Thread.sleep(2000);
			WebDriverWait screenWait = new WebDriverWait(driver, 30);
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
			Thread.sleep(3000);
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.eventRecordCnt.toWebElement()));
			String recordCountStr = repo.eventRecordCnt.toWebElement().getText();
			boolean foundSequence = false;

			int lastIndex = Integer.parseInt(recordCountStr.split(" of ")[1]);
			
			for(int index=0; index < lastIndex; index++){
				Thread.sleep(2000);
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
				System.out.println("Found Event Sequence '" + targetSequence + "' for Collection Process " + getId());
				return true;
			}
			else{
				System.out.println("Unable to find Event Sequence '" + targetSequence + "' for Collection Process " + getId());
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
			
			Thread.sleep(2000);
			
			DateTimeFormatter dateFormat = DateTimeFormatter.ISO_DATE.ofPattern("MM-dd-yyyy");
			LocalDate targetDate = LocalDate.parse(newTriggerDate, dateFormat);
			String targetMonth = targetDate.getMonth().name();
			String targetYear = String.valueOf(targetDate.getYear());
			String targetDay = String.valueOf(targetDate.getDayOfMonth());
			
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			if(isElementPresent(repo.moreInfo.getLocator())){
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
				repo.moreInfo.toWebElement().click();
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			
			Thread.sleep(1000);
			CalendarUtil calUtil = new CalendarUtil(driver, newTriggerDate);
			calUtil.navigateToTargetMonth(targetMonth);
			calUtil.setYearValue(targetYear);
			calUtil.selectDay(targetDay);
			
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on Entering New Event Trigger Date");
			logger.log(e);
    		return false;
		}
	}
	/*
	 * CP_CC.020 - 2020-05-14 - End Add
	 */
	
	
	/*
	 * Utility Block - Start
	 */
	public boolean checkIDExist(String mode) throws Exception{
		try {
			Thread.sleep(2000);
			boolean flag = checkid();
			if(flag == false) {
				screenshot.capture();
				driver.close();
				driver.quit();
				return false;
			}
			screenshot.capture();
			if(mode.equals("Add")) {
				System.out.println("Succesfully Created Collection Process with ID :" + getId());
				logger.log("Succesfully Created Collection Process with ID :" +getId());
			}
			
			if(mode.equals("Update")) {
				System.out.println("Succesfully Updated Collection Process with ID :" + getId());
				logger.log("Succesfully Updated Collection Process with ID :" +getId());
			}
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Collection Process ID Exist");
			logger.log(e);
			return false;
		}
	}
	/*
	 * Utility Block - End
	 */

}
