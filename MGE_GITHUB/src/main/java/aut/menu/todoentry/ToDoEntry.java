/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * To Do Entry
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * 2020-04-30	GSando				Initial version.
 * 2020-07-01	RExtra	CP_CI.014	Add components for Adding a Manual To Do
 * 2020-07-27	RExtra	TD.001		Add components to accommodate SQL Integration
 * 
 *************************************************************************************
 */
package aut.menu.todoentry;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class ToDoEntry extends Entity {
	private ToDoEntryObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public ToDoEntry(Ccb ccb) {
		this.pageTitle = "To Do Entry";
		this.idHolder = "TD_ENTRY_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new ToDoEntryObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean enterComment(String comment){
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.toDoEntryComment.toWebElement()));
			repo.toDoEntryComment.toWebElement().click();
			String presentComment = repo.toDoEntryComment.toWebElement().getText();
			
			if(!presentComment.isEmpty()){
				repo.toDoEntryComment.toWebElement().clear();
				//repo.toDoEntryComment.toWebElement().sendKeys(presentComment + ". " + comment);
				idHolder = repo.toDoEntryComment.toWebElement().getAttribute("id");
				JavascriptExecutor js = (JavascriptExecutor)driver;
		       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + comment + "'");
				
				return true;
			}
			
			repo.toDoEntryComment.toWebElement().sendKeys(comment);
			idHolder = repo.toDoEntryComment.toWebElement().getAttribute("id");
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + comment + "'");
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed entering comment: " + comment);
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean completeToDoEntry(){
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.completeBtn.toWebElement()));
			repo.completeBtn.toWebElement().click();
			
			System.out.println("Completed To Do with ID: " + getId());
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed completing To Do Entry");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean open() throws Exception {
		/*
		 * CP_CI.014 - 2020-07-01 - Start Add
		 */
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.toDo.toDoEntry.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to To Do Entry Page");
			logger.log(e);
    		return false;
    	}
		/*
		 * CP_CI.014 - 2020-07-01 - End Add
		 */
	}
	
	/*
	 * CP_CI.014 - 2020-07-01 - Start Add
	 */
	public boolean createManualToDo(String toDoType, String overridePrioty, String subject, String comment, String sendTo, String role, String acctID){
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
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			Thread.sleep(500);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.toDoType.toWebElement()));
			repo.toDoType.selectTextAs(toDoType);
			
			Thread.sleep(500);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.role.toWebElement()));
			repo.role.toWebElement().clear();
			repo.role.toWebElement().click();
			js.executeScript("document.getElementById(\"" + repo.role.toWebElement().getAttribute("id") + "\").value = '" + role + "'");
			repo.role.toWebElement().sendKeys(Keys.TAB);
			repo.subject.toWebElement().click();
			
			Thread.sleep(500);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.overridePriority.toWebElement()));
			repo.overridePriority.selectTextAs(overridePrioty);
			
			Thread.sleep(500);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.subject.toWebElement()));
			
			repo.subject.toWebElement().clear();
			repo.subject.toWebElement().click();
	       	js.executeScript("document.getElementById(\"" + repo.subject.toWebElement().getAttribute("id") + "\").value = '" + subject + "'");
			
	       	Thread.sleep(500);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.comment.toWebElement()));
			repo.comment.toWebElement().clear();
			repo.comment.toWebElement().click();
	       	js.executeScript("document.getElementById(\"" + repo.comment.toWebElement().getAttribute("id") + "\").value = '" + comment + "'");
			
	       	Thread.sleep(500);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.sendTo.toWebElement()));
			repo.sendTo.selectTextAs(sendTo);
			
			Thread.sleep(500);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.getCharValueElementAtIndex(0).toWebElement()));
			repo.getCharValueElementAtIndex(0).toWebElement().clear();
			repo.getCharValueElementAtIndex(0).toWebElement().click();
			repo.getCharValueElementAtIndex(0).toWebElement().sendKeys(acctID, Keys.TAB);
			Thread.sleep(500);
			repo.subject.toWebElement().click();
			
			
			Thread.sleep(1000);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.okBtn.toWebElement()));
			repo.okBtn.toWebElement().click();
			
			
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			
			System.out.println("Successfully created To Do Entry ID: " + getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Creating a Manual To Do");
			logger.log(e);
    		return false;
    	}
	}
	/*
	 * CP_CI.014 - 2020-07-01 - End Add
	 */
	
	/*
	 * TD.001 - 2020-07-27 - Start Add
	 */
	public boolean search() throws Exception {
		try {
			try {
				driver.switchTo().defaultContent();
				commons.menu.toDo.toDoEntry.search();
			}catch(Exception e) {
				driver.switchTo().parentFrame();
				commons.menu.toDo.toDoEntry.search();
			}
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to To Do Entry Page");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean searchWithID(String toDoID) throws Exception {
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
			
			popWait.until(ExpectedConditions.elementToBeClickable(repo.popToDoID.toWebElement()));
			repo.popToDoID.toWebElement().click();
			repo.popToDoID.toWebElement().clear();

			repo.popToDoID.toWebElement().sendKeys(toDoID);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.popSearchID.toWebElement()));
			repo.popSearchID.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching To Do ID in Pop up: " + toDoID);
			logger.log(e);
    		return false;
		}
	}
	/*
	 * TD.001 - 2020-07-27 - End Add
	 */
}