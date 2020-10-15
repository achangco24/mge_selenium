/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * To Do Summary Objects
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
package aut.menu.todosummary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;

public class ToDoSummaryObjects {
	private WebDriver driver;
	private EntityFrameObjects frame;
	
	public final ElementHandler	toDoSummaryOpen;
	public final ElementHandler	toDoList;
	
	public ToDoSummaryObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		
		toDoSummaryOpen = new ElementHandler(driver, By.xpath("//*[@id='TODO_SUMM:0$OPEN_CNT']"), this.frame.data.toFrameMap());
		toDoList = new ElementHandler(driver, By.xpath("//*[@id='dataTable']"), this.frame.data.toFrameMap());
	}
}
