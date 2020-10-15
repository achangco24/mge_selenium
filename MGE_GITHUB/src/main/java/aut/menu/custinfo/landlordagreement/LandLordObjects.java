/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Landlord Agreement Objects
 * 
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:			Reason: 
 * 2020-10-06	JMalayo		Initial Version
 *************************************************************************************
 */

package aut.menu.custinfo.landlordagreement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

import aut.entity.EntityFrameObjects;

public class LandLordObjects extends WebElementRepository{
	private WebDriver driver;
	
	public final ElementHandler landLordId;
	public final ElementHandler landLordSearchIcon;
	public final ElementHandler description;
	public final ElementHandler accountId;
	public final ElementHandler accountSearchIcon;
	public final ElementHandler serviceTypeFrame;
	public final ElementHandler managePremLinked;
	
	public LandLordObjects(WebDriver aut, EntityFrameObjects frame) {
		this.driver = aut;
		
		landLordId = new ElementHandler(aut, By.id("LL_ID"), frame.tabPage.toFrameMap());
		landLordSearchIcon = new ElementHandler(aut, By.id("IM_LL_ID"), frame.tabPage.toFrameMap());
		description = new ElementHandler(aut, By.id("DESCR"), frame.tabPage.toFrameMap());
		accountId = new ElementHandler(aut, By.id("ACCT_ID"), frame.tabPage.toFrameMap());
		accountSearchIcon = new ElementHandler(aut, By.id("IM_ACCT_ID"), frame.tabPage.toFrameMap());
		managePremLinked = new ElementHandler(aut, By.id("LANDLORD_PREM_INFO"), frame.tabPage.toFrameMap());
		
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("LL_DETAIL"));
		serviceTypeFrame = new ElementHandler(driver, By.id("LL_DETAIL"), map);
		
	}
	
	/**
	 * <p>Creates dynamic elements for service type.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getServiceTypeElementAtIndex(int index) {
		String id = "LL_DETAIL:" + String.valueOf(index) + "$SVC_TYPE_CD";
		return new ElementHandler(driver, By.id(id), serviceTypeFrame.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for seasonal check box.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getSeasonalElementAtIndex(int index) {
		String id = "LL_DETAIL:" + String.valueOf(index) + "$SEASONAL_SW";
		return new ElementHandler(driver, By.id(id), serviceTypeFrame.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for Start Month/Day element.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getStartMonthDayElementAtIndex(int index) {
		String id = "LL_DETAIL:" + String.valueOf(index) + "$FORMATTED_START_MMDD";
		return new ElementHandler(driver, By.id(id), serviceTypeFrame.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for End Month/Day element.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getEndMonthDayElementAtIndex(int index) {
		String id = "LL_DETAIL:" + String.valueOf(index) + "$FORMATTED_END_MMDD";
		return new ElementHandler(driver, By.id(id), serviceTypeFrame.toFrameMap());
	}
	
	

}
