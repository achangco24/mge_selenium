/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Grid Type
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

public abstract class GridType {
	protected String effDate = "";
	public String getEffDate() {
		return this.effDate;
	}
	public void setEffDate(String value) {
		this.effDate = value;
	}
	
	protected String effTime = "";
	public String getEffTime() {
		return this.effTime;
	}
	public void setEffTime(String value) {
		this.effTime = value;
	}
	
	protected String type = "";
	public String getType() {
		return this.type;
	}
	public void setType(String value) {
		this.type = value;
	}
	
	protected String value = "";
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	protected int rowIndex = -1;
	public int getRowIndex() {
		return this.rowIndex;
	}
	public void setRowIndex(int value) {
		this.rowIndex = value;
	}
}
