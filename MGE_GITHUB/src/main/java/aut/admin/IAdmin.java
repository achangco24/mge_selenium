/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * IAdmin
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
package aut.admin;

import java.util.List;

import ey.manila.qa.automation.element.ElementHandler;

/**
 * <p>Provides a generic data type to CCB menu and submenu items.</p>
 * 
 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
 * @version 1.00
 * @since 2018-10-30
 *
 */
public interface IAdmin {
	public void launch() throws Exception;
	public void add() throws Exception;
	public void search() throws Exception;
	public List<ElementHandler> toMenuMap();
}
