/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * 360 Search - Search by Device Objects
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

package aut.menu.threesixtysearch.searchbydevice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;


public class SearchByDeviceObjects extends WebElementRepository {
	private WebDriver driver;
	public final ElementHandler deviceIdType;
	public final ElementHandler deviceIdValue;
	public final ElementHandler deviceSearchBtn;
	public final ElementHandler deviceTable;
	public final ElementHandler	deviceFirstRow;
	
	
	public SearchByDeviceObjects(WebDriver aut, EntityFrameObjects frame) {
		this.driver= aut;
		deviceIdType = new ElementHandler(aut, By.id("deviceIdType"), frame.tabPage.toFrameMap());
		deviceIdValue = new ElementHandler(aut, By.id("deviceIdValue"), frame.tabPage.toFrameMap());
		deviceSearchBtn = new ElementHandler(aut, By.id("anTLZ1Refresh"), frame.tabPage.toFrameMap());
		deviceTable = new ElementHandler(aut, By.id("dataExplorerTableBody1"), frame.tabPage.toFrameMap());
		deviceFirstRow = new ElementHandler(aut, By.xpath("//*[@id='dataExplorerTableBody1']/tr/td[2]/a"), frame.tabPage.toFrameMap());
		
		
	}
}
