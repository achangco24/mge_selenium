/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Dashboard Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN		Reason text.
 * 2020-07-02	RExtra	CP_CI.047	Add components to Complete a To Do
 * 2020-07-07	RExtra	CP_BI.001	Add components to Manually Generate a Bill
 * 2020-10-12	JMalayo	CP.3.1.7.001	Establish Landlord Agreement to Account
 * 2020-10-12	JMalayo CP.3.1.9.A.001	Create High Bill Compliant
 *************************************************************************************
 */
package aut.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class DashboardObjects extends WebElementRepository{
	public final ElementHandler alertTbl;
	
	/*
	 * CP_CI.047 - 2020-07-02 - Start Add
	 */
	public final ElementHandler toDoSummaryTbl;
	/*
	 * CP_CI.047 - 2020-07-02 - End Add
	 */
	
	/*
	 * CP_BI.001 - 2020-07-07 - Start Add
	 */
	protected MenuObjects menuObj;
	public final ElementHandler accountContextMenu;
	public final ElementHandler billMenu;
	public final ElementHandler add;
	public final ElementHandler search;
	/*
	 * CP_BI.001 - 2020-07-07 - End Add
	 */
	
	/*
	 * CP.3.1.1.003 - 2020-09-28 - Start Add
	 */
	public final ElementHandler cardContextMenu;
	public final ElementHandler personContextMenu;
	public final ElementHandler premiseContextMenu;
	/*
	 * CP.3.1.1.003 - 2020-09-28 - End Add
	 */
	/*
	 * 3.3.1 - 2020-09-28- Start Add - AChangco
	 */
	public final ElementHandler accountLink;
	
	/*
	 * 3.3.1- 2020-09-28- End Add
	 */
	
	/*
	 * CP_BI.001 - 2020-10-01 - Start Add -AChangco
	 */
	public final ElementHandler personContextmenu;
	
	public final ElementHandler processDate;
	public final ElementHandler resetPin;
	public final ElementHandler pinInput;
	public final ElementHandler pinSave;
	public final ElementHandler pinVerify;
	
	/*
	 * CP_BI.001 - 2020-10-01 - End Add
	 */
	
	/*
	 *  3.3.1 2020-10-02- Start Add - AChangco
	 */
	public final ElementHandler SPContextMenu;
	
	/*
	 * 3.3.1 - 2020-10-02 - End Add
	 */
	
	/*
	 *  CP.3.1.7.001 2020-10-12 - JMalayo - Start Add
	 */
	public final ElementHandler customerContact;
	
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - End Add
	 */
	
	/*
	 *  CP.3.1.9.A.001 2020-10-12 - JMalayo - Start Add
	 */
	public final ElementHandler accountContextCasesMenu;
	
	/*
	 * CP.3.1.9.A.001 - 2020-10-12 - JMalayo - End Add
	 */
	public DashboardObjects(WebDriver aut, EntityFrameObjects frame) {
		alertTbl = new ElementHandler(aut, By.xpath("//*[@id=\"data_203\"]/table/tbody"), frame.dashboard.toFrameMap());
		
		/*
		 * CP_CI.047 - 2020-07-02 - Start Add
		 */
		toDoSummaryTbl = new ElementHandler(aut, By.xpath("//*[@id=\"data_210\"]/div/table/tbody"), frame.dashboard.toFrameMap());
		/*
		 * CP_CI.047 - 2020-07-02 - End Add
		 */
		
		/*
		 * CP_BI.001 - 2020-07-07 - Start Add
		 */
		menuObj = new MenuObjects(aut, frame);
		personContextMenu = new ElementHandler(aut, By.xpath("//*[@id='oraTableContextContainer']/tbody/tr[1]/td[2]/a"), frame.dashboard.toFrameMap());
		accountContextMenu = new ElementHandler(aut, By.xpath("//*[@id='oraTableContextContainer']/tbody/tr[2]/td[3]/img"), frame.dashboard.toFrameMap());
		cardContextMenu = new ElementHandler(aut, By.xpath("//*[@id='oraTableContextContainer']/tbody/tr[2]/td[2]/a"), frame.dashboard.toFrameMap());
		premiseContextMenu = new ElementHandler(aut, By.xpath("//*[@id='oraTableContextContainer']/tbody/tr[3]/td[2]/a"), frame.dashboard.toFrameMap());
		billMenu = new ElementHandler(aut, By.id("CI_CONTEXTACCOUNT_subMenuItem1x12"), frame.main.toFrameMap());
		add = menuObj.add; 
		search = menuObj.search;
		/*
		 * CP_BI.001 - 2020-07-07 - End Add
		 */
		
		/*
		 *  - 2020-10-01 - Start Add -AChangco
		 */
	
		processDate = new ElementHandler(aut, By.id("CI_CONTEXTACCOUNT_subMenuItem1x12"), frame.main.toFrameMap());
		personContextmenu = new ElementHandler(aut, By.xpath("//*[@id='oraTableContextContainer']/tbody/tr[1]/td[3]/img"), frame.dashboard.toFrameMap());
		
		resetPin = new ElementHandler(aut, By.id("CM_RESET_PIN_LBL"), frame.main.toFrameMap());
		pinInput = new ElementHandler(aut, By.id("inputPin"), frame.main.toFrameMap());
		pinSave = new ElementHandler(aut, By.id("/html/body/input[1]"), frame.main.toFrameMap());
		pinVerify = new ElementHandler(aut, By.id("C1_VERIFY_LBL"), frame.main.toFrameMap());
		
	
		/*                          
		 * 2020-10-01 - End Add - -AChangco
		 */
		
		/*
		 *  3.3.1 - 2020-09-28 - Start Add - AChangco
		 */
		
		accountLink = new ElementHandler(aut, By.xpath("//*[@id='oraTableContextContainer']/tbody/tr[3]/td[3]/img"), frame.dashboard.toFrameMap());
		/*
		 * 3.3.1 -  2020-09-28  - End Add  - AChangco
		 */
		
		/*
		 *  2020-10-02 - Start Add - AChangco
		 */
		
		SPContextMenu = new ElementHandler(aut, By.xpath("//*[@id='oraTableContextContainer']/tbody/tr[3]/td[3]/img"), frame.dashboard.toFrameMap());
		/*
		 * - 2020-10-02 - End Add
		 */
		
		/*
		 *  CP.3.1.7.001 2020-10-12 - JMalayo - Start Add
		 */
		customerContact = new ElementHandler(aut, By.id("CI_CONTEXTACCOUNT_subMenuItem1x18"), frame.main.toFrameMap());
		/*
		 * CP.3.1.7.001 - 2020-10-12 - JMalayo - End Add
		 */
		
		/*
		 *  CP.3.1.9.A.001 2020-10-12 - JMalayo - Start Add
		 */
		accountContextCasesMenu = new ElementHandler(aut, By.id("CI_CONTEXTACCOUNT_subMenuItem1x14"), frame.main.toFrameMap());
		/*
		 * CP.3.1.9.A.001 - 2020-10-12 - JMalayo - End Add
		 */
	}
}
