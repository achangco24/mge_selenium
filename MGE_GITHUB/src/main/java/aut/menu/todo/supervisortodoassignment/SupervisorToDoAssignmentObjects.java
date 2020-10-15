/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Supervisor To Do Assignment Objects
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * 2020-07-06	RExtra	CP_CI.038	Add components to Assign To Do Entries to Supervisor
 * 
 *************************************************************************************
 */
package aut.menu.todo.supervisortodoassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ey.manila.qa.automation.element.ElementHandler;
import aut.entity.EntityFrameObjects;

public class SupervisorToDoAssignmentObjects {
	private WebDriver driver;
	private EntityFrameObjects frame;
	
	/*
	 * CP_CI.038 - 2020-07-06 - Start Add
	 */
	//security link check from search pop-up window
	public final ElementHandler overridelink;
	
	public final ElementHandler typeDesc;
	
	public final ElementHandler toDoTypeCd;
	public final ElementHandler toDoTypeSearch;
	public final ElementHandler toDoList;
	public final ElementHandler tickBox;
	
	public final ElementHandler filterBy;
	public final ElementHandler assignTo;
	public final ElementHandler assignBtn;
	/*
	 * CP_CI.038 - 2020-07-06 - End Add
	 */
	
	public SupervisorToDoAssignmentObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		
		
		/*
		 * CP_CI.038 - 2020-07-06 - Start Add
		 */
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		
		typeDesc = new ElementHandler(driver, By.id("TYPE_DESCR"), this.frame.tabPage.toFrameMap());
		
		toDoTypeCd = new ElementHandler(aut, By.id("TD_TYPE_CD"));
		toDoTypeSearch = new ElementHandler(aut, By.id("BU_criteria_typeSrch"));
		
		toDoList = new ElementHandler(driver, By.xpath("//*[@id='dataTable']"), this.frame.data.toFrameMap());
		tickBox = new ElementHandler(driver, By.xpath("//*[@id='TD_ASS_ENTRY:0$CHECKED_SW']"), this.frame.data.toFrameMap());
		
		filterBy = new ElementHandler(aut, By.id("SRCH_ENT_STAT_FLG"), frame.tabPage.toFrameMap());
		assignTo = new ElementHandler(aut, By.id("ASSIGNED_TO"), frame.tabPage.toFrameMap());
		assignBtn = new ElementHandler(aut, By.id("SUPERVISOR_ASSIGNMENT_SW"), frame.tabPage.toFrameMap());
		/*
		 * CP_CI.038 - 2020-07-06 - End Add
		 */
	}

}
