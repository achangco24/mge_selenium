/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Batch Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-09-30	AChangco	Initial version.               
 * 
 *************************************************************************************
 */
package aut.admin.d.depositclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class DepositeClassObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
		
	
	public final ElementHandler depositSearch;
	public final ElementHandler depositSearchBtn;
	public final ElementHandler recomAlgo;
	public DepositeClassObjects(WebDriver aut, EntityFrameObjects frame) {
		
		driver = aut;
		this.frame = frame;
		
		
		//Pop Up
		depositSearch = new ElementHandler(driver, By.id("DEP_CL_CD"));
		depositSearchBtn = new ElementHandler(driver, By.id("BU_Main_depClsSch"));
		
		//Recommendation algo link
		recomAlgo = new ElementHandler(driver, By.id("DPRE_DESCR"), frame.tabPage.toFrameMap());
	}
	
	
	
	
}
