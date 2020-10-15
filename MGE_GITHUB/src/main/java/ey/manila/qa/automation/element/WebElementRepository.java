/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Web Element Repository
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
package ey.manila.qa.automation.element;

/**
 * <p>Empty abstract class.</p>
 * 
 * <p>The purpose of this abstract class is to provide a generic object type for
 * element repositories that contain the different WebElements of a page object.</p>
 * 
 * <p>Thus, each page objects is recommended to have a concrete class implementation
 * of this abstract class. Page objects are represented as concrete class implementations of the interface
 * {@link ey.manila.qa.automation.page.IPageObject}.</p>
 * <br>
 * <p><strong>How to Declare Element Object in a WebElementRepository</strong></p>
 * <ul>
 * 	<li>Declare a dedicated WebElement object for each element present in a page</li>
 * 	<li>
 * 		Declare a dedicated {@link ey.manila.qa.automation.element.ElementHandler}
 * 		for each element present in a page
 * 	</li>
 * </ul>
 * <b>Note:</b><br>
 * <ul>
 * 	<li>
 * 		It is recommended to declare each WebElement or ElementHandler as final
 * 		to avoid accidental modification at runtime.
 * 	</li>
 * 	<li>
 * 		ElementHandler might be more practical to use when the page
 * 		contains nested frame structure in its HTML.
 * 	</li>
 * </ul>
 * 
 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
 * @version 1.00
 * @since 2018-05-31
 * @see ey.manila.qa.automation.element.ElementHandler
 * @see ey.manila.qa.automation.page.IPageObject
 */
public abstract class WebElementRepository {
	/*
	 * See Javadoc
	 */
}
