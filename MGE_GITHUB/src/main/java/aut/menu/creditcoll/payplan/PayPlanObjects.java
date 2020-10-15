/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Pay Plan Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-07-01	RExtra	CP_CC.028	Add components to Add Pay Plan
 * 2020-07-02	RExtra	CP_CI.031	Add components to Cancel Pay Plan          
 * 
 *************************************************************************************
 */
package aut.menu.creditcoll.payplan;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class PayPlanObjects extends WebElementRepository{
	private EntityFrameObjects frame;
	private WebDriver driver;
	
	/*
	 * CP_CC.028 - 2020-07-01 - Start Add
	 */
	public final ElementHandler ppType;
	public final ElementHandler payMethod;
	public final ElementHandler comments;
	
	private final ElementHandler frameSched;
	
	public final ElementHandler accountContextMenu;
	public final ElementHandler customerContactMenu;
	public final ElementHandler add;
	protected MenuObjects menuObj;
	/*
	 * CP_CC.028 - 2020-07-01 - End Add
	 */
	
	/*
	 * CP_CI.031 - 2020-07-02 - Start Add
	 */
	public final ElementHandler cancelBtn;
	/*
	 * CP_CI.031 - 2020-07-02 - End Add
	 */

	public PayPlanObjects(WebDriver aut, EntityFrameObjects frame) {
		this.frame = frame;
		driver = aut;
		menuObj = new MenuObjects(aut, frame);
		
		/*
		 * CP_CC.028 - 2020-07-01 - Start Add
		 */
		ppType = new ElementHandler(aut, By.id("PP_TYPE_CD"), this.frame.tabPage.toFrameMap());
		payMethod = new ElementHandler(aut, By.id("PAY_METH_CD"), this.frame.tabPage.toFrameMap());
		
		comments = new ElementHandler(aut, By.id("COMMENTS"), this.frame.tabPage.toFrameMap());
		
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("schedGrid"));
		frameSched = new ElementHandler(driver, By.id("schedGrid"), map);
		
		accountContextMenu = new ElementHandler(driver, By.xpath("//*[@id='IM_ppData_acctIdCxt']"), this.frame.tabPage.toFrameMap());
		customerContactMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x21"), this.frame.main.toFrameMap());
		
		add = menuObj.add;
		cancelBtn = new ElementHandler(driver, By.id("CANCEL_SW"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_CC.028 - 2020-07-01 - End Add
		 */
	}
	
	/*
	 * CP_CC.028 - 2020-07-01 - Start Add
	 */
	public ElementHandler getSchedDateElementAtIndex(int index) {
		String id = "PPS:" + String.valueOf(index) + "$PP_SCHED_DT";
		return new ElementHandler(driver, By.id(id), frameSched.toFrameMap());
	}
	
	public ElementHandler getSchedAmountElementAtIndex(int index) {
		String id = "PPS:" + String.valueOf(index) + "$PP_SCHED_AMT";
		return new ElementHandler(driver, By.id(id), frameSched.toFrameMap());
	}
	/*
	 * CP_CC.028 - 2020-07-01 - End Add
	 */
	
}
