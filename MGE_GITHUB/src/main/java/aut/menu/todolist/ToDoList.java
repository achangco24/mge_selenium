/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * To Do List
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * 2020-04-30	GSando	Initial version.
 * 
 *************************************************************************************
 */
package aut.menu.todolist;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class ToDoList extends Entity {
	private ToDoListObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public ToDoList(Ccb ccb) {
		this.pageTitle = "To Do List";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new ToDoListObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean selectToDo(String toDoId){
		try {
			wait.until(ExpectedConditions.visibilityOf(repo.toDoList.toWebElement()));
			List <WebElement> tableRows = repo.toDoList.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
			int tableSize = tableRows.size();
			for(int x = 0; x < tableSize; x++) {
				WebElement todo = driver.findElement(By.xpath("//*[@id='dataTableBody']/tr[" + (x+1) +"]/td[10]/span"));
				WebElement createDateTime = driver.findElement(By.xpath("//*[@id='TD_ENTRY_LIST:" + (x) +"$CRE_DTTM']"));
				wait.until(ExpectedConditions.elementToBeClickable(createDateTime));
				
				if(todo.getText().equalsIgnoreCase(toDoId)){
					createDateTime.click();
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in selecting To Do ID: " + toDoId);
			logger.log(e);
    		return false;
    	}
	}
	
	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
