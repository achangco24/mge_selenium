/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Geographic Data
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
package aut.tabs.geodata;

import aut.tabs.GridType;

public class GeographicData extends GridType {
	public GeographicData(String geoType, String geoValue) {
		this.type = geoType;
		this.value = geoValue;
	}
}
