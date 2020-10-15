/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Premise Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN					Reason text.
 * 2020-07-29	RExtra	SEC.001		Add components for Checking Premise Data for User
 * 									CIS Division
 * 
 *************************************************************************************
 */
package aut.menu.custinfo.premise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class PremiseObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
	protected MenuObjects menuObj;
	
	public final ElementHandler premiseType;
	public final ElementHandler postalCode;
	public final ElementHandler city;
	public final ElementHandler county;
	public final ElementHandler state;
	public final ElementHandler cisCode;
	public final ElementHandler stateDescription;
	public final ElementHandler trendArea;
	public final ElementHandler timeZone;
	
	//Elements under Premise Search Pop-up
	public final ElementHandler premId;
	public final ElementHandler premIdSearchBtn;
	public final ElementHandler overridelink;
	public final ElementHandler moreInfo;
	
	/*
	 * SEC.001 - 2020-07-29 - Start Add
	 */
	public final ElementHandler popAddress;
	public final ElementHandler popSearchAddressBtn;
	public final ElementHandler popPremResultTbl;
	/*
	 * SEC.001 - 2020-07-29 - End Add
	 */
	
	//Elements under State Search Pop-up
	public final ElementHandler searchStateBtn;
	public final ElementHandler searchState;
	public final ElementHandler stateTable;
	
	//Elements under State Search Pop-up
	public final ElementHandler searchCharVal;
	public final ElementHandler charValTable;
	
	//Context Menu
	public final ElementHandler premiseContextMenu;
	public final ElementHandler orderMenu;
	public final ElementHandler spMenu;
	
	public final ElementHandler add;
	public final ElementHandler search;
	
	public final ElementHandler spLink;
	
	public PremiseObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		menuObj = new MenuObjects(aut, frame);
		
		premiseType = new ElementHandler(driver, By.id("PREM_TYPE_CD"), this.frame.tabPage.toFrameMap());
		postalCode = new ElementHandler(driver, By.id("POSTAL"), this.frame.tabPage.toFrameMap());
		city = new ElementHandler(driver, By.id("CITY"), this.frame.tabPage.toFrameMap());
		county = new ElementHandler(driver, By.id("COUNTY"), this.frame.tabPage.toFrameMap());
		state = new ElementHandler(driver, By.id("STATE"), this.frame.tabPage.toFrameMap());
		cisCode = new ElementHandler(driver, By.id("CIS_DIVISION"), this.frame.tabPage.toFrameMap());
		stateDescription = new ElementHandler(driver, By.id("STATE_DESCR"), this.frame.tabPage.toFrameMap());
		trendArea= new ElementHandler(driver, By.id("TREND_AREA_CD"), this.frame.tabPage.toFrameMap());
		timeZone = new ElementHandler(driver, By.id("TIME_ZONE_CD"), this.frame.tabPage.toFrameMap());
		
		//Premise Search Pop-up
		premId = new ElementHandler(aut, By.id("PREM_ID"));
		premIdSearchBtn = new ElementHandler(aut, By.id("BU_premId_premSrch"));
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		
		/*
		 * SEC.001 - 2020-07-29 - Start Add
		 */
		popAddress = new ElementHandler(aut, By.id("ADDRESS1"));
		popSearchAddressBtn = new ElementHandler(aut, By.id("BU_Section1_altrSearch"));
		popPremResultTbl = new ElementHandler(aut, By.id("dataTable"), this.frame.searchDataFrame.toFrameMap());
		/*
		 * SEC.001 - 2020-07-29 - End Add
		 */
		
		//State Search Pop-up
		searchStateBtn = new ElementHandler(driver, By.id("IM_STATE"), this.frame.tabPage.toFrameMap());
		searchState = new ElementHandler(aut, By.id("BU_Main_stateSrch"));
		stateTable = new ElementHandler(aut, By.id("dataTable"), frame.searchDataFrame.toFrameMap());
		
		//Characteristic Value Search
		searchCharVal = new ElementHandler(aut, By.id("BU_Main_stateSrch"));
		charValTable = new ElementHandler(aut, By.id("dataTable"), frame.searchDataFrame.toFrameMap());
		
		//PremiseContext Menu
		premiseContextMenu = new ElementHandler(driver, By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[3]/span/img[1]"), this.frame.tabPage.toFrameMap());
		
		//Sub-menus under Premise Context Menu
		orderMenu = new ElementHandler(driver, By.id("CI_CONTEXTPREMISE_subMenuItem1x10"), this.frame.main.toFrameMap());
		spMenu = new ElementHandler(driver, By.id("CI_CONTEXTPREMISE_subMenuItem1x11"), this.frame.main.toFrameMap());
		
		add = menuObj.add; 
		search = menuObj.search;
		
		
		spLink = new ElementHandler(driver, By.xpath("//*[@id='tStart']/tr[2]/td[2]/div/table/tr[1]/td[2]/table/tr[1]/td[2]/span"), this.frame.main.toFrameMap());
	}
	
	public ElementHandler getAddressLineElementAtIndex(int index) {
		return new ElementHandler(driver, (By.id("ADDRESS" + String.valueOf(index))), frame.tabPage.toFrameMap());
	}
}
