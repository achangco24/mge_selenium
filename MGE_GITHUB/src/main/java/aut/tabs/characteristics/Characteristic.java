/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Characteristics
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
package aut.tabs.characteristics;

import aut.tabs.GridType;

public class Characteristic extends GridType {
	public Characteristic(String type, String value, String effDate) {
		this.type = type;
		this.value = value;
		this.effDate = effDate;
	}
	
	public Characteristic(String type, String value, String effDate, int rowIndex) {
		this.type = type;
		this.value = value;
		this.effDate = effDate;
		this.rowIndex = rowIndex;
	}
	
	public Characteristic copy() {
		return new Characteristic(type, value, effDate, rowIndex);
	}
}
