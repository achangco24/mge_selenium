/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Supervisor To Do Assignment Menu
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuHandler;
import ey.manila.qa.automation.element.ElementHandler;

public class SupervisorToDoAssignmentMenu extends MenuHandler{
	public SupervisorToDoAssignmentMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu){
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("CI_TODO_subMenuItem0x0"), frame.main.toFrameMap()));
	}
}
