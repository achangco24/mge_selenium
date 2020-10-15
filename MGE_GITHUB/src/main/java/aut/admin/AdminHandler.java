/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Admin Handler
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN		Reason text.                
 * 
 *************************************************************************************
 */
package aut.admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;

/**
 * <p>Provides the shared methods for CCB menus and submenus with IMenu data type.</p>
 * <p><b>Usage</b><br>
 * <u>Notes when inheriting to a concrete class</u>
 * <ul>
 * 	<li>Concrete classes can also be referred with the IMenu data type</li>
 * 	<li>Make sure to perform the following upon instantiation
 * 		<ul>
 * 			<li>Call the <b>initialize</b> method.</li>
 * 			<li>Populate the <b>menuMap</b> - list of menus and submenus with ElementHandler type that will lead to the target destination.</li>
 * 		</ul>
 * 	</li>
 * </ul></p>
 * @see aut.menu.IMenu
 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
 * @version 1.00
 * @since 2018-10-30
 */
public abstract class AdminHandler implements IAdmin{
	protected List<ElementHandler> adminMap;
	protected AdminObjects adminObj;
	protected WebDriverWait wait;
	
	protected void initialize(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		adminMap = new ArrayList<ElementHandler>();
		adminObj = new AdminObjects(aut, frame);
		this.wait = wait;
	}
	
	/**
	 * <p>Launches the menu to display the submenu contents. In cases of menu with no further submenus to display,
	 * calling launch will immediately display the corresponding page of the menu.</p>
	 * @throws Exception
	 */
	public void launch() throws Exception {
		for (int ctr = 0; ctr < adminMap.size(); ctr++) {
			adminMap.get(ctr).setToContext();
			wait.until(ExpectedConditions.elementToBeClickable(adminMap.get(ctr).toWebElement()));
			adminMap.get(ctr).toWebElement().click();
		}
	}
	
	/**
	 * <p>Loads the corresponding add new page for the selected menu.</p>
	 * <p><b>Usage</b><br>
	 * <ul>
	 * 	<li>Use <b>launch()</b> method for menus with no corresponding add or search features.</li>
	 * 	<li>The <b>launch()</b> method is called implicitly by this method.</li>
	 * </ul></p>
	 * @throws Exception
	 */
	public void add() throws Exception {
		launch();
		
		wait.until(ExpectedConditions.elementToBeClickable(adminObj.add.toWebElement()));
		adminObj.add.toWebElement().click();
	}
	
	/**
	 * <p>Loads the corresponding search page of the selected menu.</p>
	 * <p><b>Usage</b><br>
	 * <ul>
	 * 	<li>Use <b>launch()</b> method for menus with no corresponding add or search features.</li>
	 * 	<li>The <b>launch()</b> method is called implicitly by this method.</li>
	 * </ul></p>
	 * @throws Exception
	 */
	public void search() throws Exception {
		launch();
		
		wait.until(ExpectedConditions.elementToBeClickable(adminObj.search.toWebElement()));
		adminObj.search.toWebElement().click();
	}
	
	public List<ElementHandler> toMenuMap() {
		return this.adminMap;
	}
}
