/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Collection Process Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-05-05	RExtra	CP_CC.003	Add components for Adding a Collection Process
 * 2020-05-12	RExtra	CP_CC.010	Add components for Canceling a Collection Process
 * 2020-05-13	RExtra	CP_CC.020	Add components for Modifying Collection Event
 * 									Trigger Date       
 * 2020-10-06	AChangco 4.9.2.EN	Added element objects
 *************************************************************************************
 */
package aut.menu.creditcoll.paymentarrangement;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class PaymentArrangementObjects extends WebElementRepository{
//	private WebDriver driver;

	private EntityFrameObjects frame;
	/*
	 * 4.9.2.EN - 2020-10-06 - Start Add
	 */
		public final ElementHandler brkPayArngtBtn;
		public final ElementHandler histotryTbl;
		public final ElementHandler amount;
		
		
;
	/*
	 * CP_CC.003 - 2020-10-06 - End 
	 */
	
	public PaymentArrangementObjects(WebDriver aut, EntityFrameObjects frame) {
//		driver = aut;
	
		
		/*
		 * 4.9.2.EN - 2020-10-06 - Start Add
		 */
		this.frame = frame;
		brkPayArngtBtn = new ElementHandler(aut, By.id("BREAK_SW"), this.frame.tabPage.toFrameMap());
		histotryTbl = new ElementHandler(aut, By.id("dataDivision"), this.frame.tabPage.toFrameMap());
		amount = new ElementHandler(aut, By.id("CURR_RCR_CHG_AMT"), this.frame.tabPage.toFrameMap());

		 
		
	}
}
