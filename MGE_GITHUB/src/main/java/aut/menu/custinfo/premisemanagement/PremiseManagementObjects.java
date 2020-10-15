/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Premise Management Menu
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * YYYY-MM-DD	IN			Reason text. 
 * 2020-09-29	JMalayo		Initial Version             
 * 
 *************************************************************************************
 */

package aut.menu.custinfo.premisemanagement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class PremiseManagementObjects extends WebElementRepository{
	private WebDriver driver;
	
	/*
	 * CP.3.1.7.002 - 2020-06-15 - JMalayo - End Add
	 */
	public final ElementHandler landLordFilter;
	public final ElementHandler landLordId;
	public final ElementHandler landLordSearchBtn;
	public final ElementHandler landLordPremiseFrame;
	public final ElementHandler removeLandlordBtn;
	public final ElementHandler includePremChildFlg;
	public final ElementHandler removeWindowRemoveBtn;
	public final ElementHandler assignWindowLandLordId;
	public final ElementHandler assignWindowAssignBtn;
	public final ElementHandler assignLandlordBtn;
	/*
	 * CP.3.1.7.002 - 2020-06-15 - JMalayo - End Add
	 */
	
	public PremiseManagementObjects(WebDriver aut, EntityFrameObjects frame) {
		this.driver = aut;
		
		/*
		 * CP.3.1.7.002 - 2020-06-15 - JMalayo - Start Add
		 */
		landLordFilter = new ElementHandler(aut, By.id("LANDLORD_FLTR_FLG"), frame.tabPage.toFrameMap());
		landLordId = new ElementHandler(aut, By.id("LL_ID"), frame.tabPage.toFrameMap());
		landLordSearchBtn = new ElementHandler(aut, By.id("BU_RUN_QUERY_IM"), frame.tabPage.toFrameMap());
		removeLandlordBtn = new ElementHandler(aut, By.id("LANDLORD_REMOVE_SW"), frame.tabPage.toFrameMap());
		includePremChildFlg = new ElementHandler(aut, By.id("INCLUDE_CHILD_SW"));
		removeWindowRemoveBtn = new ElementHandler(aut, By.id("LANDLORD_REMOVE_SW"));
		assignWindowLandLordId = new ElementHandler(aut, By.id("NEW_LL_ID"));
		assignWindowAssignBtn = new ElementHandler(aut, By.id("LANDLORD_ASSIGN_SW"));
		assignLandlordBtn = new ElementHandler(aut, By.id("LANDLORD_ASSIGN_SW"), frame.tabPage.toFrameMap());
		
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("LL_DETAIL"));
		landLordPremiseFrame = new ElementHandler(driver, By.id("dataGrid"), map);
		/*
		 * CP.3.1.7.002 - 2020-06-15 - JMalayo - End Add
		 */
	}
	
	/*
	 * CP.3.1.7.002 - 2020-06-15 - JMalayo - Start Add
	 */
	/**
	 * <p>Creates dynamic elements for service type.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getLandLordPremiseFlgElementAtIndex(int index) {
		String id = "PREM_MGMT:" + String.valueOf(index) + "$SELECT_SW";
		return new ElementHandler(driver, By.id(id), landLordPremiseFrame.toFrameMap());
	}
	/*
	 * CP.3.1.7.002 - 2020-06-15 - JMalayo - End Add
	 */
}
