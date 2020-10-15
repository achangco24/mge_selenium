/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Properties
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
package ey.manila.qa.tools.etbot.aut.constants;

import ey.manila.qa.utilities.PropertyFile;

public class Properties {
	public final PropertyFile AUTCONFIG;
	
	public Properties() throws Exception {
		this.AUTCONFIG = new PropertyFile("config\\automation.properties");
	}
}
