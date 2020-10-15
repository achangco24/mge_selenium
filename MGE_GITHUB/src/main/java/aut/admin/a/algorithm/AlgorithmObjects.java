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
 Date:       	by:    	Reason: 
 * 2020-09-30	AChangco	Initial version.                  
 * 
 *************************************************************************************
 */
package aut.admin.a.algorithm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;



public class AlgorithmObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
		
//	public final ElementHandler tndrSrc;
//	public final ElementHandler creDttm;
	
	
	/*
	 *  2020-10-06 - AChangco
	 */
	public final ElementHandler algoTbl;
	
	public AlgorithmObjects(WebDriver aut, EntityFrameObjects frame) {
		
		driver = aut;
		this.frame = frame;
		
		/*
		 * 4.9.2.EN - 2020-10-06 - AChangco
		 */
		algoTbl = new ElementHandler(driver, By.id("dataDivision"), frame.tabPage.toFrameMap());
	}
	
	
	
	
}
