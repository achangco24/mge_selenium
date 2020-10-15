/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Location History
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
package aut.tabs.locationhistory;

import aut.tabs.GridType;

public class LocationHistory extends GridType {
	public LocationHistory(String locationDate, String locationTime, String type) {
		this.effDate = locationDate;
		this.effTime = locationTime;
		this.type = type;
	}
	
	public LocationHistory(String locationDate, String locationTime, String type, String location) {
		this.effDate = locationDate;
		this.effTime = locationTime;
		this.type = type;
		this.value = location;
	}
	
	public LocationHistory(String locationDate, String locationTime, String type, String location, int index) {
		this.effDate = locationDate;
		this.effTime = locationTime;
		this.type = type;
		this.value = location;
		this.rowIndex = index;
	}
}
