/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Bill Segment Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN					Reason text.      
 * 2020-07-07	RExtra	CP_BI.006	Add components to Cancel a Bill Segment
 * 2020-07-08	RExtra	CP_BI.002	Add components to CancelRebilling a Bill Segment
 * 
 *************************************************************************************
 */
package aut.menu.financial.bill.billsegment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class BillSegmentObjects extends WebElementRepository{
	
	/*
	 * CP_BI.006 - 2020-07-07 - Start Add
	 */
	public final ElementHandler overridelink;
	public final ElementHandler popCancelReason;
	public final ElementHandler initCancel;
	public final ElementHandler popCancelCalcBtn;
	public final ElementHandler cancelBSegBtn;
	public final ElementHandler confirmCancelBSegBtn;
	/*
	 * CP_BI.006 - 2020-07-07 - End Add
	 */
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	public final ElementHandler rebillBtn;
	public final ElementHandler popRebillCalculate;
	public final ElementHandler billContextMenu;
	public final ElementHandler billMenu;
	
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */
	
	/*
	 * 2020-10-01 - Start Add - AChangco
	 */
	public final ElementHandler SAContextMenu;
	
	/*
	 *  - 2020-10-01 - End Add - AChangco
	 */
	public BillSegmentObjects(WebDriver aut, EntityFrameObjects frame) {
		/*
		 * CP_BI.006 - 2020-07-07 - Start Add
		 */
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		popCancelReason = new ElementHandler(aut, By.id("CAN_RSN_CD"));
		initCancel = new ElementHandler(aut, By.id("ACTION_INIT_SW"), frame.tabPage.toFrameMap()); 
		popCancelCalcBtn = new ElementHandler(aut, By.id("ACTION_INIT_SW"));
		cancelBSegBtn = new ElementHandler(aut, By.id("ACTION_CANCEL_SW"), frame.tabPage.toFrameMap());
		confirmCancelBSegBtn = new ElementHandler(aut, By.id("ACTION_CANCEL_SW"));

		/*
		 * CP_BI.006 - 2020-07-07 - End Add
		 */
		
		/*
		 * CP_BI.002 - 2020-07-08 - Start Add
		 */
		rebillBtn = new ElementHandler(aut, By.id("ACTION_REBILL_SW"), frame.tabPage.toFrameMap());
		popRebillCalculate = new ElementHandler(aut, By.id("ACTION_REBILL_SW"));
		billContextMenu = new ElementHandler(aut, By.id("IM_BILL_ID_CTX_MENU"), frame.tabPage.toFrameMap());
		billMenu = new ElementHandler(aut, By.id("CI_CONTEXTBILL_subMenuItem0x0"), frame.main.toFrameMap());
		/*
		 * CP_BI.002 - 2020-07-08 - End Add
		 */
		
		/*
		 * 2020-10-01 - Start Add - AChangco
		 */
		
		SAContextMenu = new ElementHandler(aut, By.id("IM_SA_ID_CTX_MENU"), frame.main.toFrameMap());
		/*
		 * 2020-10-01 - End Add - AChangco
		 */
	}

}
