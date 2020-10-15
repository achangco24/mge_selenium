/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * 360 Search - Search by Address Objects
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * YYYY-MM-DD	IN			Reason text.                
 * 2020-10-02	JMalayo 	Initial Version
 * 2010-10-02	JMalayo		MU4.1.12.001 Person properly syncs from C2M to MDM
 * 2010-10-02	JMalayo		MU4.1.12.002 Service Agreements syncs from C2M to MDM
 *************************************************************************************
 */

package aut.menu.threesixtysearch.searchbyaddress;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;


public class SearchByAddressObjects extends WebElementRepository{
	private WebDriver driver;
	public final ElementHandler address;
	public final ElementHandler city;
	public final ElementHandler postal;
	public final ElementHandler search;
	public final ElementHandler addressTable;
	public final ElementHandler	addressServicePointCol;
	
	public SearchByAddressObjects(WebDriver aut, EntityFrameObjects frame) {
		this.driver= aut;
		address = new ElementHandler(aut, By.id("Addr1fld"), frame.tabPage.toFrameMap());
		city = new ElementHandler(aut, By.id("city"), frame.tabPage.toFrameMap());
		postal = new ElementHandler(aut, By.id("postal"), frame.tabPage.toFrameMap());
		search = new ElementHandler(aut, By.id("anTLZ1Refresh"), frame.tabPage.toFrameMap());
		addressTable = new ElementHandler(aut, By.id("dataExplorerTableBody1"), frame.tabPage.toFrameMap());
		addressServicePointCol = new ElementHandler(aut, By.xpath("//*[@id='dataExplorerTableBody1']/tr/td[2]/a"), frame.tabPage.toFrameMap());
		
	}
}
