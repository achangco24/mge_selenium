/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Time Entry
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

public class TimeEntry {
	private Timestamp date;
	/**
	 * <p>Gets the date that is associated with the current instance.</p>
	 * @return String representation of the TimeEntry date
	 */
	public Timestamp getDate() {
		return this.date;
	}
	
	/*
	 * Contains the actual mapping for task and effort.
	 * HashMap entries is a key-value pair in the format:
	 * 	key
	 * 		Data Type: String
	 * 		Description: Task description associated for the time entry
	 * 	value
	 * 		Data Type: String
	 * 		Description: Actual effort spent for the task 
	 */
	private HashMap<String, String> entries = new HashMap<String, String>();
	/**
	 * <p>Adds a new time entry for the date that is associated for the current instance.</p>
	 * @param task String description of the task for the time entry to be added
	 * @param actualEffort String value of the actual effort for the time entry to be added
	 */
	public void AddEntry(String task, String actualEffort) {
		this.entries.put(task, actualEffort);
	}
	/**
	 * <p>Gets all the available time entries for the current instance.</p>
	 * @return HashMap value of the time entries. The mapping of
	 * time entries is in the key-value format:
	 * 	<ul>
	 * 		<li><b>key:</b> String description of the task</li>
	 * 		<li><b>value:</b> String value of the actual effort</li>
	 * 	</ul>
	 */
	public HashMap<String, String> getAllEntries() {
		return this.entries;
	}
	/**
	 * <p>Gets the String representation of the actual effort spent for the specified task</p>
	 * @param task String description of the task whose actual effort will be retrieved
	 * @return String value of the actual effort spent for the specified task 
	 */
	public String getActualEffortFor(String task) {
		return this.entries.get(task);
	}
	
	/**
	 * <p>Creates a new TimeEntry instance and associates the specified String date
	 * as the date of the time entry to be created.</p>
	 * @param date String representation of the date of the time entry to be created
	 */
	public TimeEntry(Timestamp date) {
		this.date = date;
	}
}
