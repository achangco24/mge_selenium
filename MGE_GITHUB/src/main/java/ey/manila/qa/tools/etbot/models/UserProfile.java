/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * User Profile
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
package ey.manila.qa.tools.etbot.models;

import java.sql.Timestamp;
import java.util.HashMap;

import org.openqa.selenium.WebElement;

public class UserProfile {
	private String lastName = "";
	public String getLastName() {
		return this.lastName;
	}
	
	private String firstName = "";
	public String getFirstName() {
		return this.firstName;
	}
	
	private String gpnNumber = "";
	public String getGpnNumber() {
		return this.gpnNumber;
	}
	
	private WebElement webElement;
	public WebElement getWebElement() {
		return this.webElement;
	}
	
	public UserProfile(WebElement webElement, String lastName, String firstName, String gpnNumber) {
		this.webElement = webElement;
		this.lastName = lastName;
		this.firstName = firstName;
		this.gpnNumber = gpnNumber;
		this.timeEntries = new HashMap<Timestamp, TimeEntry>();
	}
	
	private HashMap<Timestamp, TimeEntry> timeEntries;
	public HashMap<Timestamp, TimeEntry> getTimeEntries() {
		return this.timeEntries;
	}
	public void addTimeEntry(Timestamp entryDate) {
		this.timeEntries.put(entryDate, new TimeEntry(entryDate));
	}
}
