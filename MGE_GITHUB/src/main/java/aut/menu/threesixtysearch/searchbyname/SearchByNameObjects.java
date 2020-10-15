/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * 360 Search - Search by Name Objects
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * YYYY-MM-DD	IN			Reason text.                
 * 2020-10-6	JMalayo 	Initial Version
 *************************************************************************************
 */

package aut.menu.threesixtysearch.searchbyname;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class SearchByNameObjects extends WebElementRepository {
	private WebDriver driver;
	public final ElementHandler name;
	public final ElementHandler address;
	public final ElementHandler city;
	public final ElementHandler postal;
	
	public final ElementHandler contactIdentifier;
	public final ElementHandler contactIdentifierVal;
	public final ElementHandler usageSubIdentifier;
	public final ElementHandler usageSubIdentifierVal;
	
	public final ElementHandler searchBtn;
	
	public SearchByNameObjects(WebDriver aut, EntityFrameObjects frame) {
		this.driver= aut;
		name = new ElementHandler(aut, By.id("name"), frame.tabPage.toFrameMap());
		address = new ElementHandler(aut, By.id("Addr1fld"), frame.tabPage.toFrameMap());
		city = new ElementHandler(aut, By.id("city"), frame.tabPage.toFrameMap());
		postal = new ElementHandler(aut, By.id("postal"), frame.tabPage.toFrameMap());
		
		contactIdentifier = new ElementHandler(aut, By.id("contactIdType"), frame.tabPage.toFrameMap());
		contactIdentifierVal = new ElementHandler(aut, By.id("contactIdValue"), frame.tabPage.toFrameMap());
		usageSubIdentifier = new ElementHandler(aut, By.id("usIdType"), frame.tabPage.toFrameMap());
		usageSubIdentifierVal = new ElementHandler(aut, By.id("usIdValue"), frame.tabPage.toFrameMap());
		
		searchBtn = new ElementHandler(aut, By.id("anTLZ1Refresh"), frame.tabPage.toFrameMap());
	}
	
}
