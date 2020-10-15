/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Entity Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:	  
 * 2020-05-13	RExtra	CP_CC.020	Add components for Modifying Collection Event
 * 									Trigger Date   
 * 2020-09-30	JMalayo				Add component to handle the Search bar on Menu and
 * 									Account Information button beside Control Central
 * 2020-10-12	JMalayo	CP.3.1.9.A	Manage Customer Inquiries/Complaints - High Bill
 * 									Complaint
 *************************************************************************************
 */
package aut.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.admin.Admin;
import aut.menu.Menu;
import aut.tabs.TabObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class EntityObjects extends WebElementRepository {
	public final EntityFrameObjects frame;
	public final TabObjects tabs;
	public final Menu menu;
	public final Admin admin;
	public final ElementHandler searchBar;
	public final ElementHandler accountInfoBtn;
	
	//Generic entity actions
	public final ElementHandler save;
	public final ElementHandler refresh;
	public final ElementHandler back;
	
	//Generic entity objects
	public final ElementHandler title;
	public final ElementHandler controlCentral;
	
	//public final ElementHandler id;
	public final ElementHandler userMenuButton;
	public final ElementHandler logout;
	public final ElementHandler barMenu;
	
	/*
	 * CP_CC.020 - 2020-05-14 - Start Add
	 */
	public final ElementHandler eventTriggerDateBtn;
	/*
	 * CP_CC.020 - 2020-05-14 - End Add
	 */
	
	/*
	 * CP.3.1.9.A - 2020-10-12 - Start Add
	 */
	public final ElementHandler searchListBox;
	/*
	 * CP.3.1.9.A  - 2020-10-12 - End Add
	 */
	
	
	public EntityObjects(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		this.frame = frame;
		tabs = new TabObjects(aut, this.frame);
		menu = new Menu(aut, this.frame, wait);
		admin = new Admin(aut, this.frame, wait);
		
		/*
		 * CP_CC.020 - 2020-09-30 - Start Add
		 */
		searchBar = new ElementHandler(aut, By.id("oj-inputsearch-input-menuSearchElem"), frame.main.toFrameMap());
		accountInfoBtn = new ElementHandler(aut, By.id("IM_accountInfoButton"), frame.main.toFrameMap());
		/*
		 * CP_CC.020 - 2020-09-30 - End Add
		 */
		
		//Generic entity actions
		save = new ElementHandler(aut, By.id("IM_SAVE"), frame.main.toFrameMap());
		refresh = new ElementHandler(aut, By.id("IM_REFRESH"), frame.main.toFrameMap());
		back = new ElementHandler(aut, By.id("IM_GOBACK"), frame.main.toFrameMap());
		
		//Generic entity objects
		title =  new ElementHandler(aut, By.id("ptitle"), frame.main.toFrameMap());
	 	controlCentral = new ElementHandler(aut, By.id("IM_controlCentralButton"), frame.main.toFrameMap());
	 	barMenu = new ElementHandler(aut, By.id("IM_menuButton"), frame.main.toFrameMap());
		
		//id = new ElementHandler(aut, By.id("id"), frame.tabPage.toFrameMap());
		userMenuButton = new ElementHandler(aut, By.id("youAreLoggedInAsSpan"), frame.main.toFrameMap());
		logout = new ElementHandler(aut, By.id("Logout"), frame.main.toFrameMap());
		
		/*
		 * CP_CC.020 - 2020-05-14 - Start Add
		 */
		eventTriggerDateBtn = new ElementHandler(aut, By.id("IM_EVT$TRIGGER_DT"), frame.tabPage.toFrameMap());
		/*
		 * CP_CC.020 - 2020-05-14 - End Add
		 */
		
		/*
		 * CP.3.1.9.A - 2020-10-12 - Start Add
		 */
		searchListBox = new ElementHandler(aut, By.id("oj-listbox-drop"), frame.main.toFrameMap());
		/*
		 * CP.3.1.9.A  - 2020-10-12 - End Add
		 */
	}
}
