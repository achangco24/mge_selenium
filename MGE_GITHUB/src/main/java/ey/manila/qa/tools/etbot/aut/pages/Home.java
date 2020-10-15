/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Home
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
package ey.manila.qa.tools.etbot.aut.pages;

import org.openqa.selenium.WebDriver;

import ey.manila.qa.automation.page.IPageObject;
import ey.manila.qa.tools.etbot.aut.pages.obj.HomeObjects;

public class Home implements IPageObject {
	private final HomeObjects objRepository;
	private WebDriver aut;
	
	public Home(WebDriver driver) {
		this.aut = driver;
		this.objRepository = new HomeObjects(this.aut);
	}
	
	/**
	 * {@inheritDoc} 
	 */
	public void load() throws Exception {
		objRepository.menu.toWebElement().click();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLoaded() throws Exception {
		String welcomeBanner = "Welcome " + objRepository.currentUser.toWebElement().getText().trim() + "!";
		if (objRepository.menu.toWebElement().getAttribute("class").trim().toLowerCase().equals("selected") &&		//Menu is selected
			(objRepository.welcomeLabel.toWebElement().getText().equals(welcomeBanner))) {										//Welcome label contains name of current user
				return true;
			}
		
		return false;
	}

}
