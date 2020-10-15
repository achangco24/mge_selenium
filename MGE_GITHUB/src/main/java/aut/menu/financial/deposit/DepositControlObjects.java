/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Deposit Control Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-06-16	RExtra	CP_FIN.03	Add components for Adding a Deposit and Tender
 * 									Control                
 * 
 *************************************************************************************
 */
package aut.menu.financial.deposit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class DepositControlObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
	 
	public final ElementHandler tenderSrcType;
	public final ElementHandler currCode;
	public final ElementHandler comments;
	
	/*
	 * CP_FIN.03 - 2020-06-16 - Start Add
	 */
	public final ElementHandler endingBalance;
	public final ElementHandler dcCntx;
	protected MenuObjects menuObj;
	public final ElementHandler add;
	public final ElementHandler tenderCtrlMenu;
	/*
	 * CP_FIN.02 - 2020-06-16 - End Add
	 */
	
	public DepositControlObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		
		tenderSrcType = new ElementHandler(driver, By.id("TNDR_SRCE_TYPE_FLG"), this.frame.tabPage.toFrameMap());
		currCode = new ElementHandler(driver, By.id("CURRENCY_CD"), this.frame.tabPage.toFrameMap());
		comments = new ElementHandler(driver, By.id("COMMENTS"), this.frame.tabPage.toFrameMap());
		
		/*
		 * CP_FIN.03 - 2020-06-16 - Start Add
		 */
		menuObj = new MenuObjects(aut, frame);
		add = menuObj.add;
		tenderCtrlMenu = new ElementHandler(driver, By.id("CI_CONTEXTDEPOSITCONTROL_subMenuItem1x2"), this.frame.main.toFrameMap());
		
		endingBalance = new ElementHandler(driver, By.id("END_BALANCE"), this.frame.tabPage.toFrameMap());
		dcCntx = new ElementHandler(driver, By.id("IM_Section1_dcCntxt"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_FIN.02 - 2020-06-16 - End Add
		 */
	}
}
