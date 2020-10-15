/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * IPage Object
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
package ey.manila.qa.automation.page;

/**
 * <p>Provides a generic object type to the page object representations of the
 * different pages of the target application.</p>
 * 
 * <p><b>Note:</b><br>It is recommended to store WebElements to be accessed by the page object
 * in a repository. This provides maintainability and convenience in accessing and
 * managing the WebElements.</p>
 * 
 * <p>The default WebElementRepository object type can be used to
 * contain the WebElements, but other techniques and object type can be used
 * to achieve the purpose.</p>
 * 
 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
 * @version 1.00
 * @since 2018-06-01
 * @see ey.manila.qa.automation.element.WebElementRepository
 */
public interface IPageObject {
	/**
	 * <p>Processes the concrete class implementation of the IPageObject interface
	 * and load its equivalent physical page in the web browser.</p>
	 * @throws Exception 
	 */
	public void load() throws Exception;
	
	/**
	 * <p>Checks if the physical page represented by the IPageObject
	 * has been loaded successfully in the web browser.</p>
	 * @return TRUE if the page has been loaded successfully. Otherwise, returns FALSE
	 * @throws Exception 
	 */
	public boolean isLoaded() throws Exception;
}
