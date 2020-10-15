/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Install Event Objects
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason:
 * 2010-10-02	JMalayo		Initial Version 
 * 2020-10-02	JMalayo		MU.4.1.12 Sync Master Data from CIS             
 * 
 *************************************************************************************
 */

package aut.menu.deviceinstallation.installevent;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;


public class InstallEventObjects extends WebElementRepository {
	private WebDriver driver;
	
	/*
	 * MU.4.1.12.005 - 2020-06-15 - JMalayo - Start Add
	 */
	public final ElementHandler frameSPDeviceConfig;
	public final ElementHandler deviceConfig;
	public final ElementHandler servPointId;
	public final ElementHandler okBtn;
	public final ElementHandler cancelBtn;
	
	//Device Identifier Window
	public final ElementHandler idType; 
	public final ElementHandler idTypeValue; 
	public final ElementHandler searchBtn; 
	
	//Search for Address Window
	public final ElementHandler addressSearch;
	public final ElementHandler citySearch;
	public final ElementHandler postalSearch;
	
	//Manual Meter Install Event uiMap
	public final ElementHandler installationDDate; 
	public final ElementHandler installationDTime;
	public final ElementHandler saveBtn;
	
	/*
	 * MU.4.1.12.005 - 2020-06-15 - JMalayo - End Add
	 */
	
	public InstallEventObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		
		/*
		 * MU.4.1.12.005 - 2020-06-15 - JMalayo - Start Add
		 */
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("uiMap"));
		frameSPDeviceConfig = new ElementHandler(driver, By.id("uiMap"), map);
		
		deviceConfig = new ElementHandler(driver, By.id("deviceConfigurationId"), map);
		servPointId = new ElementHandler(driver, By.id("spId"), map);
		okBtn = new ElementHandler(driver, By.xpath("//*[@class='oraButton oraDefault'][@value='OK']"), map);
		cancelBtn = new ElementHandler(driver, By.xpath("//*[@class='oraButton oraDefault'][@value='Cancel']"), map);
		saveBtn = new ElementHandler(driver, By.xpath("//*[@class='oraButton oraDefault'][@value='Save']"), map);
		
		
		//Device Identifier Window
		idType = new ElementHandler(driver, By.id("IdentifierTypeValue_type"));
		idTypeValue = new ElementHandler(driver, By.id("IdentifierTypeValue_value"));
		searchBtn = new ElementHandler(driver, By.id("anTLZ1Refresh"));
		
		//Search for Address Window
		addressSearch = new ElementHandler(driver, By.id("filter1.F1"));
		citySearch = new ElementHandler(driver, By.id("filter1.F2"));
		postalSearch = new ElementHandler(driver, By.id("filter1.F3"));
		
		
		//Manual Meter Install Event uiMap
		installationDDate = new ElementHandler(driver, By.id("boGroup_installDateTime_date"), map);
		installationDTime = new ElementHandler(driver, By.id("boGroup_installDateTime_time"), map);
		/*
		 * MU.4.1.12.005 - 2020-06-15 - JMalayo - End Add
		 */
	}
}
