/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * To Do Entry Menu
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-07-01	RExtra	CP_CI.014	Add components to Add a Manual To Do            
 * 
 *************************************************************************************
 */
package aut.menu.todoentry;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuHandler;
import ey.manila.qa.automation.element.ElementHandler;

public class ToDoEntryMenu extends MenuHandler{
	public ToDoEntryMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu){
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("CI_TODO_subMenuItem1x3"), frame.main.toFrameMap()));
	}
}
