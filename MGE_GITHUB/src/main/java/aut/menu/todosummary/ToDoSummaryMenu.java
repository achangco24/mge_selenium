/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * To Do Summary Menu
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

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuHandler;
import ey.manila.qa.automation.element.ElementHandler;

public class ToDoSummaryMenu extends MenuHandler {
	
	public ToDoSummaryMenu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait, List<ElementHandler> parentMenu){
		initialize(aut, frame, wait);
		menuMap.addAll(parentMenu);
		menuMap.add(new ElementHandler(aut, By.id("CI_TODO_subMenuItem0x7"), frame.main.toFrameMap()));
	}

}
