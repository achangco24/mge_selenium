/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * This program holds the ID for the To Do Menu of Main Menu.
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * 2020-04-30	GSando				Initial version.
 * 2020-07-01	RExtra	CP_CI.014	Add components to Add a Manual To Do
 * 2020-07-06	RExtra	CP_CI.038	Add components to Assign To Do Entries to
 * 									Supervisor
 * 
 * 
 *************************************************************************************
 */
package aut.menu.todo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.IMenu;
import aut.menu.MenuHandler;
import aut.menu.todo.supervisortodoassignment.SupervisorToDoAssignmentMenu;
import aut.menu.todoentry.ToDoEntryMenu;
import aut.menu.todosummary.ToDoSummaryMenu;
import ey.manila.qa.automation.element.ElementHandler;

public class ToDo extends MenuHandler{
	public final IMenu toDoSummary;
	
	/*
	 * CP_CI.014 - 2020-07-01 - Start Add
	 */
	public final IMenu toDoEntry;
	/*
	 * CP_CI.014 - 2020-07-01 - End Add
	 */
	
	/*
	 * CP_CI.038 - 2020-07-06 - Start Add
	 */
	public final IMenu supervisorToDoAssignment;
	/*
	 * CP_CI.038 - 2020-07-06 - End Add
	 */
	
	public ToDo(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		initialize(aut, frame, wait);
		menuMap.add(new ElementHandler(aut, By.id("IM_menuButton"), frame.main.toFrameMap()));
		menuMap.add(new ElementHandler(aut, By.id("CI_MAINMENU_topMenuItem0x18"), frame.main.toFrameMap()));
		
		toDoSummary = new ToDoSummaryMenu(aut, frame, wait, menuMap);
		
		/*
		 * CP_CI.014 - 2020-07-01 - Start Add
		 */
		toDoEntry = new ToDoEntryMenu(aut, frame, wait, menuMap);
		/*
		 * CP_CI.014 - 2020-07-01 - End Add
		 */
		
		/*
		 * CP_CI.038 - 2020-07-06 - Start Add
		 */
		supervisorToDoAssignment = new SupervisorToDoAssignmentMenu(aut, frame, wait, menuMap);
		/*
		 * CP_CI.038 - 2020-07-06 - End Add
		 */
	}

}
