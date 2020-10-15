/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Severance Process
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-05-05	RExtra	CP_CC.005	Add components for Adding a Severance Process
 * 2020-05-12	RExtra	CP_CC.013	Add components for Canceling a Severance Process
 * 2020-05-14	RExtra	CP_CC.021	Add components for Modifying a Severance Event
 * 									Trigger Date             
 * 
 *************************************************************************************
 */
package aut.menu.creditcoll.severance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.dashboard.Dashboard;
import aut.entity.Entity;
import ey.manila.qa.automation.CalendarUtil;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class Severance extends Entity{
	private SeveranceObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public Severance(Ccb ccb) throws Exception {
		this.pageTitle = "Severance Process";
		this.idHolder = "SEV_PROC_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new SeveranceObjects(ccb.getDriver(), ccb.getCcbFrames());
		
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.creditCollection.severance.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Severance Process page");
			logger.log(e);
			return false;
		}
	
	}
	
	public boolean search() throws Exception {
		try {
			try {
				driver.switchTo().defaultContent();
				commons.menu.creditCollection.severance.search();
			}catch(Exception e) {
				driver.switchTo().parentFrame();
				commons.menu.creditCollection.severance.search();
			}
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
//			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
//			if (!menuFlag) {
//				driver.switchTo().defaultContent();
//				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
//			}
//			commons.menu.creditCollection.severance.search();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Severance Process page");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean search2() throws Exception {
		try {
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.creditCollection.severance.search();
			screenshot.capture();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Severance Process page");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean severancePopSearchID(String procID) throws Exception {
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
			
			if(isElementPresent(repo.moreInfo.getLocator())){
				wait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
				repo.moreInfo.toWebElement().click();
				wait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(repo.severanceProcID.getLocator()));
			repo.severanceProcID.toWebElement().sendKeys(procID);
			repo.searchBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to search Severance Process ID: " + procID);
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectAwaitingFieldActivity() throws Exception{
		wait.until(ExpectedConditions.elementToBeClickable(repo.tableRow.toWebElement()));
		List <WebElement> rows = repo.tableRow.toWebElement().findElements(By.xpath("//*[@id=\'tStart\']/tbody/tr[2]/td[2]/div/table/tbody/tr"));
		for(int i = 1;i<=rows.size();i++) {			
			WebElement rowName = repo.tableRow.toWebElement().findElement(By.xpath("//*[@id=\'tStart\']/tbody/tr[2]/td[2]/div/table/tbody/tr[" + i + "]/td[2]/table/tbody/tr/td[2]/span"));
			String eventName = rowName.getAttribute("innerHTML");
			if(eventName.toLowerCase().contains("awaiting field activity")) {
				rowName.click();
				break;
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(repo.eventType.toWebElement()));
		Dashboard dashboard = new Dashboard(ccb);
    	dashboard.clickAlertLinkWithText("Field Activity Pending"); 
		return true;
	}
	
	public boolean goToControlCentral() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.accountContext.toWebElement()));
			repo.accountContext.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(repo.conCentralBtn.toWebElement()));
			repo.conCentralBtn.toWebElement().click();
			screenshot.capture();
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate to Control Central");
			logger.log(e);
			return false;
		}
	}
	
	public boolean goToServiceAgreement() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.accountContext.toWebElement()));
			repo.accountContext.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(repo.saBtn.toWebElement()));
			repo.saBtn.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(repo.saSearch.toWebElement()));
			repo.saSearch.toWebElement().click();
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate to Service Agreement");
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectLast() throws Exception{
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
			
			if(isElementPresent(repo.moreInfo.getLocator())){
				wait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
				repo.moreInfo.toWebElement().click();
				wait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			
			wait.until(ExpectedConditions.visibilityOf(repo.sevTable.toWebElement()));
			List <WebElement> row = repo.sevTable.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
			System.out.println(row.size());
			WebElement last = driver.findElement(By.xpath("//*[@id='dataTableBody']/tr[" + row.size() + "]/td[4]/span"));
			last.click();
			driver.switchTo().window(main);
			return true;
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to navigate to select the last severance process.");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CC.005 - 2020-05-05 - Start Add
	 */
	
	public boolean selectSA(String saID) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.saField.toWebElement()));
			repo.saField.toWebElement().click();
			repo.saField.toWebElement().clear();
			repo.saField.toWebElement().click();
			Thread.sleep(3000);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("document.getElementById(\"" + repo.saField.toWebElement().getAttribute("id") + "\").value = '" + saID + "'");
			Thread.sleep(1000);
			repo.saInfo.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select SA for Severance Process.");
			logger.log(e);
			return false;
		}
		
	}
	
	public boolean selectSevProcTemplate(String template) throws Exception{
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(repo.sevProcTemplate.toWebElement()));
			repo.sevProcTemplate.selectTextAs(template);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Severance Process Template.");
			logger.log(e);
			return false;
		}
		
	}
	
	public boolean enter_sev_amt_base_date() throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.createDate.toWebElement()));
			LocalDate currentDate = LocalDate.now();
			String strDate = currentDate.minusDays(40).format(DateTimeFormatter.ISO_DATE.ofPattern("MM-dd-yyyy"));
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.sevAmtBaseDate.toWebElement()));
			repo.sevAmtBaseDate.toWebElement().sendKeys(strDate);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Entering Severance Amount Base Date");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean set_sev_days_in_arrears(String days) throws Exception {
		try {
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(repo.daysInArrears.toWebElement()));
			repo.daysInArrears.toWebElement().clear();
			repo.daysInArrears.toWebElement().click();
			repo.daysInArrears.toWebElement().sendKeys(days);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Entering Severance Days in Arrears");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean add_comment(String comment) throws Exception {
		try {
			Thread.sleep(2000);
			WebDriverWait screenWait = new WebDriverWait(driver, 10);
			screenWait.until(ExpectedConditions.presenceOfElementLocated(repo.comment.getLocator()));
			repo.comment.toWebElement().click();
			screenWait.until(ExpectedConditions.presenceOfElementLocated(repo.comment.getLocator()));
			repo.comment.toWebElement().sendKeys(comment);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Entering Severance Process Comment");
			logger.log(e);
    		return false;
		}
	}
	
	public boolean saveSevProc(String mode) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(commons.save.toWebElement()));
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			checkIDExist(mode);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Severance Process");
			logger.log(e);
			return false;
		}
	}
	 
	/*
	 * CP_CC.005 - 2020-05-05 - End Add
	 */
	
	
	/*
	 * CP_CC.013 - 2020-05-12 - Start Add
	 */
	public boolean setSevProcCancelReason() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.reason.toWebElement()));
			repo.reason.toWebElement().sendKeys("Events Pending");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Set Severance Process Cancellation Reason");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setSevProcCancelComments(String comments) throws Exception{
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
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Set Severance Process Cancellation Reason");
			logger.log(e);
			return false;
		}
	}
	
	public boolean cancel_sev_proc() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.cancelBtn.toWebElement()));
			repo.cancelBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Initiate Severance Process Cancellation");
			logger.log(e);
			return false;
		}
	}
	
	public boolean confirm_cancel_sev_proc() throws Exception{
		try {
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	

				Thread.sleep(2000);
				System.out.println("Successfully cancelled Severance Process with ID: " + getId());
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Confirm Severance Process Cancellation");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CC.013 - 2020-05-12 - End Add
	 */
	
	
	/*
	 * CP_CC.021 - 2020-05-14 - Start Add
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
			Thread.sleep(2000);
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
				System.out.println("Found Event Sequence '" + targetSequence + "' for Severance Process " + getId());
				return true;
			}
			else{
				System.out.println("Unable to find Event Sequence '" + targetSequence + "' for Severance Process " + getId());
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
			
			//TODO
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
			
			Thread.sleep(1000);
			save();
			
			//TODO
			checkIDExist("Update");
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed on Entering New Event Trigger Date");
			logger.log(e);
    		return false;
		}
	}
	/*
	 * CP_CC.021 - 2020-05-14 - End Add
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
				System.out.println("Succesfully Created a Severance Process with ID :" + getId());
				logger.log("Succesfully Created a Severance Process with ID :" +getId());
			}
			
			if(mode.equals("Update")){
				System.out.println("Succesfully Updated Severance Process with ID :" + getId());
				logger.log("Succesfully Updated Severance Process with ID :" +getId());
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Severance Process ID Exist");
			logger.log(e);
			return false;
		}
	}
	/*
	 * Utility Block - End
	 */
}
