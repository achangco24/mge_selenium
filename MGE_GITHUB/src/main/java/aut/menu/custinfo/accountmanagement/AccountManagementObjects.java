/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Account Management Objects
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:		Reason: 
 * 2020-10-05	JMalayo	Initial Version
 * 2020-10-05	JMalayo	CP.3.1.2.EN-065.001	Create a class objects to handle elements
 * 											within the Account Management Page.
 * 
 * 
 *************************************************************************************
 */

package aut.menu.custinfo.accountmanagement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;


public class AccountManagementObjects extends WebElementRepository{
	private WebDriver driver;
	public final ElementHandler searchBy;
	public final ElementHandler personId;
	public final ElementHandler incHierarchy;
	public final ElementHandler customerClass;
	public final ElementHandler accountManagement;
	public final ElementHandler searchBtn;
	public final ElementHandler billCycle;
	
	public AccountManagementObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		searchBy = new ElementHandler(aut, By.id("multiQueryZoneFilters1"), frame.tabPage.toFrameMap());
		personId = new ElementHandler(aut, By.id("personId"), frame.tabPage.toFrameMap());
		incHierarchy = new ElementHandler(aut, By.id("includePersonHierarchyCB"), frame.tabPage.toFrameMap());
		customerClass = new ElementHandler(aut, By.id("customerClass"), frame.tabPage.toFrameMap());
		accountManagement = new ElementHandler(aut, By.id("accountManagementGroup"), frame.tabPage.toFrameMap());
		billCycle = new ElementHandler(aut, By.id("billCycle"), frame.tabPage.toFrameMap());
		searchBtn = new ElementHandler(aut, By.id("anTLZ1Refresh"), frame.tabPage.toFrameMap());
	}
}
