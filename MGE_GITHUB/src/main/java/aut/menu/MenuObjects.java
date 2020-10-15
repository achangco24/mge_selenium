/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Menu Objects
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
package aut.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class MenuObjects extends WebElementRepository {
	//Menu actions
	public final ElementHandler add;
	public final ElementHandler search;
	
	public MenuObjects(WebDriver aut, EntityFrameObjects frame) {
		//Menu actions
		add = new ElementHandler(aut, By.xpath("/html/body/div/ul/li[2]"), frame.main.toFrameMap());
		search = new ElementHandler(aut, By.xpath("/html/body/div/ul/li[1]"), frame.main.toFrameMap());
	}
}
