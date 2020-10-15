/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Service Point Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-23	GSando	CI.018. 	Add components for adding a Service Point Record
 * 									to a Premise.
 * 2020-06-22	RExtra	CP_FS.009.	Add components to Create and Complete FA.
 * 2020-09-28	JMalayo	CP.3.1.1.003 Service Cycle Updates Billing Cycle
 * 2020-10-01	JMalayo	CP.5.3.2.001 Generate Temporary Service on new Premise/SP   
 * 2020-10-02	JMalayo MU.4.1.12.004 Service Point syncs from MDM to ODM
 * 2020-10-08	JMalayo	CP.3.1.1.003	Service Cycle Updates Billing Cycle         
 * 
 *************************************************************************************
 */
package aut.menu.custinfo.sp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class ServicePointObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
	protected MenuObjects menuObj;
	private final ElementHandler serviceFrame;
	
	
	public final ElementHandler locationCode;
	public final ElementHandler locationInfo;
	public final ElementHandler premiseId;
	public final ElementHandler premiseInfo;
	public final ElementHandler spTypeCode;
	public final ElementHandler spTypeDescription;
	public final ElementHandler serviceCycle;
	public final ElementHandler serviceRoute;
	
	public final ElementHandler spContextMenu;
	public final ElementHandler spMtrReadMenu;
	public final ElementHandler add;
	public final ElementHandler search;
	
	public final ElementHandler editSPChar;
	
	//security link check from search pop-up window
	public final ElementHandler overridelink;
	public final ElementHandler	moreInfo;
	
	/*
	 * CP_FS.009 - 2020-06-22 - Start Add
	 */
	public final ElementHandler spSourceStatus;
	public final ElementHandler disconnectLoc;
	/*
	 * CP_FS.009 - 2020-06-22 - End Add
	 */
	
	/*
	 * CP.3.1.1.003 - 2020-09-28 - JMalayo - Start Add
	 */
	public final ElementHandler spEditBtn;
	public final ElementHandler spMeasurementCycle;
	public final ElementHandler spSaveBtn;
	/*
	 * CP.3.1.1.003 - 2020-09-28 - JMalayo - End Add
	 */
	
	
	//uiMap
	/*
	 * CP.5.3.2.001 - 2020-10-01 - JMalayo - Start Add
	 */
	public final ElementHandler timeZone;
	public final ElementHandler sourceStatus;
	public final ElementHandler uiMapPremiseId;
	public final ElementHandler saveServPointBtn;
	/*
	 * CP.5.3.2.001 - 2020-10-01 - JMalayo - End Add
	 */
	
	//uiMap Add Service Point
	/*
	 * MU.4.1.12.004 - 2020-10-02 - JMalayo - End Add
	 */
	public final ElementHandler servPointType;
	public final ElementHandler servPointOkBtn;
	
	//uiMap Service Point Characteristic
	public final ElementHandler spCharType;
	public final ElementHandler spCharValue;
	/*
	 * MU.4.1.12.004 - 2020-10-02 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.1.003 - 2020-10-08 - JMalayo - Start Add
	 */
	public final ElementHandler spQueryTblLink;
	/*
	 * CP.3.1.1.003 - 2020-10-08 - JMalayo - End Add
	 */
	
	public ServicePointObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut; 
		this.frame = frame;
		menuObj = new MenuObjects(aut, frame);
		
		locationCode = new ElementHandler(aut, By.id("MTR_LOC_CD"), frame.tabPage.toFrameMap());
		locationInfo = new ElementHandler(aut, By.id("LOCATION_INFO"), frame.tabPage.toFrameMap());
		premiseId = new ElementHandler(aut, By.id("PREM_ID"), frame.tabPage.toFrameMap());
		premiseInfo = new ElementHandler(aut, By.id("PREM_INFO"), frame.tabPage.toFrameMap());
		spTypeCode = new ElementHandler(aut, By.xpath("//*[@id='SP_TYPE_CD']"), frame.tabPage.toFrameMap());
		spTypeDescription = new ElementHandler(aut, By.id("SP_TYPE_DESC"), frame.tabPage.toFrameMap());
		/*
		 * CI.018 - 2020-04-23 - Start Add
		 */
		serviceCycle = new ElementHandler(aut, By.id("MR_CYC_CD"), frame.tabPage.toFrameMap());
		serviceRoute = new ElementHandler(aut, By.id("MR_RTE_CD"), frame.tabPage.toFrameMap());
		/*
		 * CI.018 - 2020-04-23 - End Add
		 */
		
		spContextMenu = new ElementHandler(aut, By.xpath("/html/body/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/img"), frame.spTree.toFrameMap());
		spMtrReadMenu = new ElementHandler(aut, By.id("CI_CONTEXTSERVICEPOINT_subMenuItem1x3"), frame.main.toFrameMap());
		
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("moreInfoContainer"));
		
		add = menuObj.add; 
		search = menuObj.search;
		
		/*
		 * CP_FS.009 - 2020-06-22 - Start Add
		 */
		spSourceStatus = new ElementHandler(aut, By.id("SP_SRC_STATUS_FLG"), frame.tabPage.toFrameMap());
		disconnectLoc = new ElementHandler(aut, By.id("DISCON_LOC_CD"), frame.tabPage.toFrameMap());
		/*
		 * CP_FS.009 - 2020-06-22 - End Add
		 */
		
		spEditBtn = new ElementHandler(aut, By.id("EDIT"), frame.tabPage.toFrameMap());
		spMeasurementCycle = new ElementHandler(aut, By.id("boGroup_measurementCycle"), frame.tabPage.toFrameMap());
		spSaveBtn = new ElementHandler(aut, By.id("SAVE_BTN_MP"), frame.tabPage.toFrameMap());
		
		
		//uiMap
		/*
		 * CP.5.3.2.001 - 2020-10-01 - JMalayo - Start Add
		 */
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("uiMap"));
		serviceFrame = new ElementHandler(driver, By.id("uiMap"), map);
		
		timeZone = new ElementHandler(aut, By.id("timeZone"), map);
		sourceStatus = new ElementHandler(aut, By.id("spSrcStatus"), map);
		uiMapPremiseId = new ElementHandler(aut, By.id("premiseId"), map);
		saveServPointBtn = new ElementHandler(aut, By.id("SAVE_BTN_MP"), map);
		/*
		 * CP.5.3.2.001 - 2020-10-01 - JMalayo - End Add
		 */
		
		//uiMap - Add Service Point
		/*
		 * MU.4.1.12.004 - 2020-10-02 - JMalayo - Start Add
		 */
		servPointType = new ElementHandler(aut, By.id("desc"), map);
		servPointOkBtn = new ElementHandler(aut, By.xpath("//*[@class='oraButton oraDefault'][@value='OK']"), map);
		
		//uiMap - SP Characteristic Maintenance
		spCharType = new ElementHandler(aut, By.id("characteristicType_0"), map);
		spCharValue = new ElementHandler(aut, By.xpath("//*[@class='oraButton oraDefault'][@value='OK']"), map);
		
		editSPChar = new ElementHandler(aut, By.xpath("//*[@id='zoneHeader2']/table/tbody/tr/td[2]a"), frame.tabPage.toFrameMap());
		/*
		 * MU.4.1.12.004 - 2020-10-02 - JMalayo - End Add
		 */
		
		/*
		 * CP.3.1.1.003 - 2020-10-08 - JMalayo - Start Add
		 */
		spQueryTblLink = new ElementHandler(aut, By.id(""), frame.tabPage.toFrameMap());
		/*
		 * CP.3.1.1.003 - 2020-10-08 - JMalayo - End Add
		 */
	}
	
	public ElementHandler getServicePointTypeElementAtIndex(int index) {
		String id = "SEARCH_RESULTS:" + String.valueOf(index) + "$DESCR_SPT";
		return new ElementHandler(driver, By.id(id), frame.data.toFrameMap());
	}
}
