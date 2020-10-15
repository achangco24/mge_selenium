/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Start Stop Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-07-16	RExtra	CP_CI.069		Add components for Starting Service Using an
 * 										Order/Campaign COM
 * 2020-09-28	JMalayo CP.3.1.11.004	Add components for Stop Service
 * 2020-09-28	JMalayo CP.3.1.11.002	Add components for Start Service
 *************************************************************************************
 */
package aut.menu.custinfo.startstop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;
import aut.menu.MenuObjects;

public class StartStopObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
	public ElementHandler title;
	
	public final ElementHandler dashboardCustomer;
	
	/*
	 * CP_CI.069 - 2020-07-16 - Start Add
	 */
	public final ElementHandler acctInfo;
	/*
	 * CP_CI.069 - 2020-07-16 - End Add
	 */
	
	/*
	 * CP.3.1.11.004 - 2020-09-28 - JMalayo - Start Add
	 */
	public final ElementHandler searchAcctIcon;
	public final ElementHandler stopEndDT;
	public final ElementHandler stopPremId;
	public final ElementHandler stopReqBy;
	public final ElementHandler stopMethod;
	public final ElementHandler stopBtn;
	/*
	 * CP.3.1.11.004 - 2020-09-28 - JMalayo - End Add
	 */
	
	
	/*
	 * CP.3.1.2.NU.002 - 2020-09-30 - JMalayo - Start Add
	 */
	public final ElementHandler startDT;
	public final ElementHandler startMethod;
	public final ElementHandler cisDivision;
	public final ElementHandler saType;
	public final ElementHandler startBtn;
	public final ElementHandler accountContextMenu;
	public final ElementHandler acctServiceAgreMenu;
	protected MenuObjects menuObj;
	public final ElementHandler add;
	public final ElementHandler search;
	/*
	 * CP.3.1.2.NU.002 - 2020-09-30 - JMalayo - End Add
	 */
	
	public StartStopObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		
		dashboardCustomer = new ElementHandler(driver, By.xpath("//*[@id=\"data_202\"]/table/tbody/tr[1]/td[2]/a"), this.frame.dashboard.toFrameMap());
		
		/*
		 * CP_CI.069 - 2020-07-16 - Start Add
		 */
		acctInfo = new ElementHandler(driver, By.id("ACCT_INFO"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_CI.069 - 2020-07-16 - End Add
		 */
		
		/*
		 * CP.3.1.11.004 - 2020-09-28 - JMalayo - Start Add
		 */
		searchAcctIcon = new ElementHandler(driver, By.id("IM_ACCT_ID"), this.frame.tabPage.toFrameMap());
		stopReqBy = new ElementHandler(driver, By.id("STOP_REQED_BY"), this.frame.tabPage.toFrameMap());
		stopPremId = new ElementHandler(driver, By.id("STOP_PREM_ID"), this.frame.tabPage.toFrameMap());
		stopEndDT = new ElementHandler(driver, By.id("STOP_END_DT"), this.frame.tabPage.toFrameMap());
		stopMethod = new ElementHandler(driver, By.id("STOP_TYPE_FLG"), this.frame.tabPage.toFrameMap());
		stopBtn = new ElementHandler(driver, By.id("ACTION_STOP_SW"), this.frame.tabPage.toFrameMap());
		/*
		 * CP.3.1.11.004 - 2020-09-28 - JMalayo - End Add
		 */
		
		
		/*
		 *CP.3.1.2.NU.002 - 2020-09-30 - JMalayo - Start Add
		 */
		startDT = new ElementHandler(driver, By.id("STRT_START_DT"), this.frame.tabPage.toFrameMap());
		cisDivision = new ElementHandler(driver, By.id("STRT_CIS_DIVISION"), this.frame.tabPage.toFrameMap());
		startMethod = new ElementHandler(driver, By.id("STRT_TYPE_FLG"), this.frame.tabPage.toFrameMap());
		saType = new ElementHandler(driver, By.id("STRT_SA_TYPE_CD"), this.frame.tabPage.toFrameMap());
		startBtn = new ElementHandler(driver, By.id("ACTION_START_SW"), this.frame.tabPage.toFrameMap());
		accountContextMenu = new ElementHandler(driver, By.id("IM_ACCT_ID_CTX_MENU"), this.frame.tabPage.toFrameMap());
		acctServiceAgreMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x43"), this.frame.main.toFrameMap());
		add = menuObj.add; 
		search = menuObj.search;
		/*
		 * CP.3.1.2.NU.002 - 2020-09-30 - JMalayo - End Add
		 */
	}
	
}
