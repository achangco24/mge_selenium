/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Asset Management Menu Handler
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * YYYY-MM-DD	IN			Reason text. 
 * 2020-10-02	JMalayo		Initial Version               
 * 2020-10-02	JMalayo		Create a package and class to handles the navigation from 
 * 							Menu to Asset Management.
 *************************************************************************************
 */

package aut.menu.assetmanagement.asset;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;


public class AssetObjects {
	private WebDriver driver;
	private EntityFrameObjects frame;
	
	
	//uiMap Asset
	public final ElementHandler assetFrame;
	public final ElementHandler assetType;
	public final ElementHandler okBtn;
	public final ElementHandler cancelBtn;
	public final ElementHandler effectiveDateDT;
	public final ElementHandler effectiveDateTime;
	public final ElementHandler outOfServiceLoc;
	
	
	//uiMap Analog Meter
	public final ElementHandler specs;
	public final ElementHandler badgeNumber;
	public final ElementHandler serialNumber;
	public final ElementHandler saveItemBtn;
	public final ElementHandler cancelItemBtn;
	public final ElementHandler inMeasureConfig;
	
	
	public AssetObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		
		
		//uiMap Frame for Add Assets Window
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("uiMap"));
		assetFrame = new ElementHandler(driver, By.id("uiMap"), map);
		
		assetType = new ElementHandler(driver, By.id("boGroup_assetType"), map);
		okBtn = new ElementHandler(driver, By.xpath("//*[@class='oraButton oraDefault'][@value='OK']"), map);
		cancelBtn = new ElementHandler(driver, By.xpath("//*[@class='oraButton oraDefault'][@value='Cancel']"), map);
		effectiveDateDT = new ElementHandler(driver, By.id("newAssetDisposition/effectiveDateTime_date"), map);
		effectiveDateTime = new ElementHandler(driver, By.id("newAssetDisposition/effectiveDateTime_time"), map);
		outOfServiceLoc = new ElementHandler(driver, By.id("newAssetDisposition_storageLocationId"), map);
		
		//uiMap Analog Meter
		specs = new ElementHandler(driver, By.id("boGroup_specification"), map);
		badgeNumber = new ElementHandler(driver, By.id("boGroup_badgeNo"), map);
		serialNumber = new ElementHandler(driver, By.id("boGroup_serialNo"), map);
		saveItemBtn = new ElementHandler(driver, By.id("SAVE_BTN_MP"), map);
		cancelItemBtn = new ElementHandler(driver, By.id("CANCEL_BTN_MP"), map);
		inMeasureConfig = new ElementHandler(driver, By.id("boGroup_configuration"), map);
	}
	

}
