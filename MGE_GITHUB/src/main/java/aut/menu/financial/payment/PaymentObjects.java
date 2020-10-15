/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Payment Objects
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-24	GSando	Initial version. 
 * 2020-06-03	RExtra	CP_FIN.12	Adding components for Adding & Manually
 * 									Distributing a Payment               
 * 
 *************************************************************************************
 */
package aut.menu.financial.payment;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;
import ey.manila.qa.automation.element.ElementHandler;

public class PaymentObjects {
	private WebDriver driver;
	private EntityFrameObjects frame;
	protected MenuObjects menuObj;
	
	public final ElementHandler overridelink;
	public final ElementHandler moreInfo;
	
	public final ElementHandler cancelBtn;
	public final ElementHandler cancelTable;
	public final ElementHandler cancelReason;
	public final ElementHandler cancelPayment;
	
	/*
	 * CP_FIN.12 - 2020-06-03 - Start Add
	 */
	public final ElementHandler saGridFrame;
	public final ElementHandler distributedAmount1;
	public final ElementHandler distributedAmount2;
	
	public final ElementHandler distributeBtn;
	public final ElementHandler freezeBtn;
	/*
	 * CP_FIN.12 - 2020-06-03 - End Add
	 */
	/*
	 *  2020-10-02 - Start Add - AChangco
	 */
	public final ElementHandler transferBtn;
	public final ElementHandler freezeChck;
	
	/*
	 * - 2020-10-02 - End Add - AChangco
	 */
	public PaymentObjects(WebDriver aut, EntityFrameObjects frame){
		driver = aut;
		this.frame = frame;
		menuObj = new MenuObjects(aut, frame);
		
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		
		cancelBtn = new ElementHandler(driver, By.xpath("/html/body/table/tbody/tr[7]/td/table/tbody/tr/td[5]/input"), this.frame.tabPage.toFrameMap());
		cancelTable = new ElementHandler(aut, By.id("tabPageTable"));
		cancelReason = new ElementHandler(aut, By.id("CAN_RSN_CD"));
		cancelPayment = new ElementHandler(aut, By.id("PAY_CANCEL_SW"));
		
		
		/*
		 * CP_FIN.12 - 2020-06-03 - Start Add
		 */
		
		//Manual Distribution Tab
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("SA"));
		saGridFrame = new ElementHandler(aut, By.id("SA"), map);
		distributedAmount1 = new ElementHandler(driver, By.xpath("//*[@id='SA:0$PAY_SEG_AMT']"), saGridFrame.toFrameMap());
		distributedAmount2 = new ElementHandler(driver, By.xpath("//*[@id='SA:1$PAY_SEG_AMT']"), saGridFrame.toFrameMap());
		
		distributeBtn = new ElementHandler(driver, By.id("PAY_DISTRIBUTE_SW"), this.frame.tabPage.toFrameMap());
		freezeBtn = new ElementHandler(driver, By.id("PAY_FREEZE_SW"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_FIN.12 - 2020-06-03 - End Add
		 */
		/*
		 *  2020-10-02 - Start Add - AChangco
		 */
		
		transferBtn = new ElementHandler(aut, By.id("TRANS_POPUP_SW"));
		freezeChck = new ElementHandler(aut, By.id("FREEZE_PAY_SW"));
		
		/*
		 * 2020-10-02 - End Add AChangco
		 */
	}
}