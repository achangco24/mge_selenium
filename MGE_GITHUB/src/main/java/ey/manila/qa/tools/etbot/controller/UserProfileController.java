/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * User Profile Controller
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
package ey.manila.qa.tools.etbot.controller;

import ey.manila.qa.tools.etbot.models.UserProfile;

public class UserProfileController {
	private UserProfile userProfile;
	
	public UserProfileController(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	public void switchToUserProfile() {
		userProfile.getWebElement().click();
	}
}
