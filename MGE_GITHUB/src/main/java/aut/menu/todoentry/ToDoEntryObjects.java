/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * To Do Entry Objects
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * 2020-04-30	GSando	Initial version.
 * 2020-07-01	RExtra	CP_CI.014	Add components to Add a Manual To Do
 * 2020-07-27	RExtra	TD.001		Add components to accommodate SQL Integration
 * 
 *************************************************************************************
 */
package aut.menu.todoentry;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;

public class ToDoEntryObjects {
	private WebDriver driver;
	private EntityFrameObjects frame;
	
	public final ElementHandler	toDoEntryComment;
	public final ElementHandler	completeBtn;
	
	/*
	 * CP_CI.014 - 2020-07-01 - Start Add
	 */
	public final ElementHandler overridelink;
	
	public final ElementHandler toDoType;
	public final ElementHandler overridePriority;
	public final ElementHandler subject;
	public final ElementHandler comment;
	public final ElementHandler sendTo;
	public final ElementHandler role;
	
	private final ElementHandler frameTDCharGrid;
	
	public final ElementHandler okBtn;
	/*
	 * CP_CI.014 - 2020-07-01 - End Add
	 */
	
	/*
	 * TD.001 - 2020-07-27 - Start Add
	 */
	public final ElementHandler popToDoID;
	public final ElementHandler popSearchID;
	/*
	 * TD.001 - 2020-07-27 - End Add
	 */
	
	
	public ToDoEntryObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		
		toDoEntryComment = new ElementHandler(driver, By.id("COMMENTS"), this.frame.tabPage.toFrameMap());
		completeBtn = new ElementHandler(driver, By.id("COMPLETE_SW"), this.frame.tabPage.toFrameMap());
		
		/*
		 * CP_CI.014 - 2020-07-01 - Start Add
		 */
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		
		toDoType = new ElementHandler(aut, By.id("TD_TYPE_CD"));
		overridePriority = new ElementHandler(aut, By.id("TD_PRIORITY_FLG"));
		subject = new ElementHandler(aut, By.id("MESSAGE_PARM"));
		comment = new ElementHandler(aut, By.id("COMMENTS_ADD"));
		sendTo = new ElementHandler(aut, By.id("TD_SEND_TO_FLG"));
		role = new ElementHandler(aut, By.id("ROLE_ID"));
		
		okBtn = new ElementHandler(aut, By.id("OK_BTTN"));
		
		List<By> map = new ArrayList<By>();
		map.add(By.id("charGridcharGrid"));
		frameTDCharGrid = new ElementHandler(driver, By.id("charGridcharGrid"), map);
		/*
		 * CP_CI.014 - 2020-07-01 - End Add
		 */
		
		/*
		 * TD.001 - 2020-07-27 - Start Add
		 */
		popToDoID = new ElementHandler(aut, By.id("TD_ENTRY_ID"));
		popSearchID = new ElementHandler(aut, By.id("BU_criteria_toDoEntSrc"));
		
		/*
		 * TD.001 - 2020-07-27 - End Add
		 */
	}
	
	/*
	 * CP_CI.014 - 2020-07-01 - Start Add
	 */
	public ElementHandler getCharValueElementAtIndex(int index) {
		String id = "TDENTRY_CHAR:" + String.valueOf(index) + "$CHAR_VAL_FK1";
		return new ElementHandler(driver, By.id(id), frameTDCharGrid.toFrameMap());
	}
	/*
	 * CP_CI.014 - 2020-07-01 - End Add
	 */
}
