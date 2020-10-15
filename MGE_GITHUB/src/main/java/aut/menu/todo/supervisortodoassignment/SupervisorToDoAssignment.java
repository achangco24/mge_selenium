/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Supervisor To Do Assignment
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * 2020-07-06	RExtra	CP_CI.038	Add components to Assign To Do Entries to
 * 									Supervisor
 * 
 *************************************************************************************
 */
package aut.menu.todo.supervisortodoassignment;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import aut.Ccb;
import aut.entity.Entity;
import aut.menu.financialquery.paymenttendersearch.PaymentTenderSearchObjects;

public class SupervisorToDoAssignment  extends Entity{
	private SupervisorToDoAssignmentObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	
	public SupervisorToDoAssignment(Ccb ccb) {
		this.pageTitle = "Supervisor To Do Assignment";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new SupervisorToDoAssignmentObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	
	/*
	 * CP_CI.038 - 2020-07-06 - Start Add
	 */
	public boolean searchForToDoType(String toDoType) throws Exception {
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
			
			popWait.until(ExpectedConditions.elementToBeClickable(repo.toDoTypeCd.toWebElement()));
			repo.toDoTypeCd.toWebElement().click();
			repo.toDoTypeCd.toWebElement().clear();
			repo.toDoTypeCd.toWebElement().sendKeys(toDoType);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.toDoTypeSearch.toWebElement()));
			repo.toDoTypeSearch.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Searching for To Do Type '" + toDoType + "'");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean filterAssignmentBy(String filterBy){
		try {
			System.out.println("Filter");
			wait.until(ExpectedConditions.visibilityOf(repo.filterBy.toWebElement()));
			repo.filterBy.selectTextAs(filterBy);		
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Selecting Filter By '" + filterBy + "'");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean selectToDoForAssignment(){
		try {
			wait.until(ExpectedConditions.visibilityOf(repo.toDoList.toWebElement()));
			List <WebElement> tableRows = repo.toDoList.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
			int tableSize = tableRows.size();
			if(tableSize > 0){
				wait.until(ExpectedConditions.elementToBeClickable(repo.tickBox.toWebElement()));
				repo.tickBox.tickAs(true);
			}			
				
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Selecting a To Do for Assignment");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean selectAssignee(String user){
		try {
			System.out.println("Select Assignee");
			wait.until(ExpectedConditions.visibilityOf(repo.assignTo.toWebElement()));
			repo.assignTo.toWebElement().clear();
			repo.assignTo.toWebElement().click();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + repo.assignTo.toWebElement().getAttribute("id") + "\").value = '" + user + "'");
			
	       	repo.typeDesc.toWebElement().click();
	       	
	       	WebElement todo = driver.findElement(By.xpath("//*[@id='TD_ASS_ENTRY|0|9']"));
	       	
	       	
			wait.until(ExpectedConditions.visibilityOf(repo.assignBtn.toWebElement()));
			repo.assignBtn.toWebElement().click();
			System.out.println("Successfully Reassigned To Do: " + todo.getText() + " to User: " + user);
			
			Thread.sleep(1000);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Selecting Supervisor as '" + user + "'");
			logger.log(e);
    		return false;
    	}
	}
	
	/*
	 * CP_CI.038 - 2020-07-06 - End Add
	 */
	
	
	@Override
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.toDo.supervisorToDoAssignment.launch();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Supervisor To Do Assignment Page");
			logger.log(e);
    		return false;
    	}
	}

}
