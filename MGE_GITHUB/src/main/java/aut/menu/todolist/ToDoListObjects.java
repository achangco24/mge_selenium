/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * To Do List Objects
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ey.manila.qa.automation.element.ElementHandler;
import aut.entity.EntityFrameObjects;

public class ToDoListObjects {

	private WebDriver driver;
	private EntityFrameObjects frame;
	
	public final ElementHandler	toDoList;
	
	public ToDoListObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		
		toDoList = new ElementHandler(driver, By.xpath("//*[@id='dataTable']"), this.frame.data.toFrameMap());
	}

}
