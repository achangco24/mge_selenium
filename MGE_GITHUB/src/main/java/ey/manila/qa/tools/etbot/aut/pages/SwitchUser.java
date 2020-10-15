/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Switch User
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

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ey.manila.qa.automation.element.ElementActions;
import ey.manila.qa.automation.element.WebElementRepository;
import ey.manila.qa.automation.page.IPageObject;
import ey.manila.qa.tools.etbot.aut.menu.obj.ToolsObjects;
import ey.manila.qa.tools.etbot.aut.pages.obj.SwitchUserObjects;
import ey.manila.qa.tools.etbot.models.UserProfile;

public class SwitchUser implements IPageObject {
	private SwitchUserObjects objRepository;
	private WebDriver aut;
	private ToolsObjects menuObjects;
	
	public SwitchUser(WebDriver driver, WebElementRepository menuObjects) {
		this.aut = driver;
		this.menuObjects = (ToolsObjects) menuObjects;
		this.objRepository = new SwitchUserObjects(this.aut);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void load() throws Exception {
		ElementActions.hover(aut,  menuObjects.menu);
		menuObjects.switchUser.toWebElement().click();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLoaded() throws Exception {
		if (menuObjects.menu.toWebElement().getAttribute("class").trim().toLowerCase().equals("selected") &&		//Menu is selected
			(objRepository.title.toWebElement().getText().equals("Switch Active User"))) {													//Welcome label contains page header text
				return true;
			}
		
		return false;
	}
	
	public List<UserProfile> getUserProfiles() {
		String xpath = "//*[@id=\"ctl00_contentPH_grdResult\"]/tbody/tr";
		
		List<UserProfile> userProfiles = new ArrayList<UserProfile>();
		List<WebElement> rows = aut.findElements(By.xpath(xpath));
		for (int ctr = 0; ctr < rows.size(); ctr++) {
			String className = rows.get(ctr).getAttribute("class");
			if (!className.equals("gridFixedHeaderRow") && !className.equals("") && className != null) {		//Row is a valid user profile
				/*
				 * Get user profile details. Details are mapped using the following indices:
				 * 	0		Last Name
				 * 	1		First Name
				 * 	2		GPN Number
				 * 
				 * The last name is actually a link to switch the user profile. So to get the equivalent WebElement
				 * of the profile, you can get the ID attribute of the last name as a reference.
				 */
				String detailsXpath = xpath + "[" + Integer.toString(ctr + 1) + "]/td";
				List<WebElement> rowDetails = aut.findElements(By.xpath(detailsXpath));
				
				WebElement profileElement = rowDetails.get(0);
				String lastName = rowDetails.get(0).getText().trim();
				String firstName = rowDetails.get(1).getText().trim();
				String gpnNumber = rowDetails.get(2).getText().trim();
				userProfiles.add(new UserProfile(profileElement, lastName, firstName, gpnNumber));
			}
		}
		
		return userProfiles;
	}
}
