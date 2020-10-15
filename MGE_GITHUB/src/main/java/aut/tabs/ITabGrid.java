/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * ITab Grid
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
package aut.tabs;

import java.util.List;

public interface ITabGrid {
	public void addRow() throws Exception;
	public void deleteRow(int index) throws Exception;
	public List<?> getAll() throws Exception;
	public void setRowAs(int rowIndex, GridType rowDetails) throws Exception;
}
