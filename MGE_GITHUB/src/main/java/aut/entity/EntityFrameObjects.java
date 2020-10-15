/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Entity Frame Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-06-03	RExtra	CP_FIN.09	Add components for Adding a Payment to Multiple
 * 									Accounts 
 * 2020-06-03	RExtra	CP_FIN.12	Adding components for Adding & Manually
 * 									Distributing a Payment   
 * 2020-07-13	RExtra	CP_CI.030	Add components for Adding a Payment Arrangement
 *  								Request
 * 2020-07-16	RExtra	CP_CI.069	Add components for Starting Service Using an
 * 									Order/Campaign COM        
 * 
 *************************************************************************************
 */
package aut.entity;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class EntityFrameObjects extends WebElementRepository {
	public final ElementHandler main;
	public final ElementHandler tabPage;
	public final ElementHandler tabMenu;
	public final ElementHandler dashboard;
	public final ElementHandler controlAccountContext;
	public final ElementHandler data;
	public final ElementHandler spTree;
	public final ElementHandler zoneMapFrame1;
	public final ElementHandler enrollName, enrollField;
	public final ElementHandler pkgTree;
	public final ElementHandler graphCollTree;
	public final ElementHandler billSegment;
	public final ElementHandler searchDataFrame;
	public final ElementHandler actionPanel;
	public final ElementHandler premiseTree;
	public final ElementHandler tendersGrid;
	public final ElementHandler premiseSPFrame;
	
	/*
	 * CP_FIN.09 - 2020-06-03 - Start Add
	 */
	public final ElementHandler payGrid;
	/*
	 * CP_FIN.09 - 2020-06-03 - End Add
	 */
	
	/*
	 * CP_FIN.12 - 2020-06-03 - Start Add
	 */
	public final ElementHandler sa;
	/*
	 * CP_FIN.12 - 2020-06-03 - End Add
	 */

	/*
	 * CP_CI.032 - 2020-06-04 - Start Add
	 */
	public final ElementHandler alertGrid;
	/*
	 * CP_CI.032 - 2020-06-04 - End Add
	 */
	
	/*
	 * CP_CC.002 - 2020-06-30 - Start Add
	 */
	public final ElementHandler collRefHisGrid;
	/*
	 * CP_CC.002 - 2020-06-30 - End Add
	 */
	
	/*
	 * CP_CI.030 - 2020-07-13 - Start Add
	 */
	public final ElementHandler uiMapFrame;
	/*
	 * CP_CI.030 - 2020-07-13 - End Add
	 */
	
	/*
	 * CP_CI.069 - 2020-07-16 - Start Add
	 */
	public final ElementHandler startStopFrame;
	/*
	 * CP_CI.069 - 2020-07-16 - End Add
	 */
	
	
	public EntityFrameObjects(WebDriver aut) {
		List<By> mainFrame = Arrays.asList(By.name("main"));
		main = new ElementHandler(aut, By.name("main"), mainFrame);
		
		List<By> tabPageFrame = Arrays.asList(By.name("main"), By.id("tabPage"));
		tabPage = new ElementHandler(aut, By.id("tabPageFrame"), tabPageFrame);
		
		List<By> tabMenuFrame = Arrays.asList(By.name("main"), By.id("tabMenu"));
		tabMenu = new ElementHandler(aut, By.id("tabMenuFrame"), tabMenuFrame);
		
		List<By> dashboardFrame = Arrays.asList(By.name("main"), By.id("dashboard"));
		dashboard = new ElementHandler(aut, By.id("dashboardFrame"), dashboardFrame);
		
		List<By> AccountContext = Arrays.asList(By.name("main"), By.id("tabPage"), By.id("zoneMapFrame_2"));
		controlAccountContext = new ElementHandler(aut, By.id("AccountContext"), AccountContext);
		
		List<By> dataFrame = Arrays.asList(By.name("main"), By.id("tabPage"), By.id("dataframe"));
		data = new ElementHandler(aut, By.id("dataframe"), dataFrame);
		
		List<By> searchFrame = Arrays.asList(By.id("dataframe"));
		searchDataFrame = new ElementHandler(aut, By.id("dataframe"), searchFrame);
		
		List<By> spTreeFrame = Arrays.asList(By.name("main"), By.id("tabPage"), By.id("SP_TREE"));
		spTree = new ElementHandler(aut, By.id("spTreeFrame"), spTreeFrame);
		
		List<By> zoneFrame1 = Arrays.asList(By.name("main"), By.id("tabPage"), By.id("zoneMapFrame_1"));
		zoneMapFrame1 = new ElementHandler(aut, By.id("zoneFrame1"), zoneFrame1);
		
		List<By> enrollNameFrame = Arrays.asList(By.name("main"), By.id("tabPage"), By.id("ENRL_NM"));
		enrollName = new ElementHandler(aut, By.id("enrollNameFrame"), enrollNameFrame);
		
		List<By> enrollFieldFrame = Arrays.asList(By.name("main"), By.id("tabPage"), By.id("ENRL_FLD"));
		enrollField = new ElementHandler(aut, By.id("enrollFieldFrame"), enrollFieldFrame);
		
		List<By> pkgTreeFrame = Arrays.asList(By.name("main"), By.id("tabPage"), By.id("PKG_TREE"));
		pkgTree = new ElementHandler(aut, By.id("pkgTreeFrame"), pkgTreeFrame);
		
		List<By> graphCollTreeFrame = Arrays.asList(By.name("main"), By.id("tabPage"), By.id("Graph_collTree"));
		graphCollTree = new ElementHandler(aut, By.id("graphCollTreeFrame"), graphCollTreeFrame);
		
		List<By> billSegmentFrame = Arrays.asList(By.name("main"), By.id("tabPage"), By.id("FinlSumm_bsegGrid"));
		billSegment = new ElementHandler(aut, By.id("FinlSumm_bsegGrid"), billSegmentFrame);
		
		List<By> faActionFrame = Arrays.asList(By.name("main"), By.id("tabPage"),By.id("FA_ACTION_PANEL"));
		actionPanel = new ElementHandler(aut, By.id("FA_ACTION_PANEL"), faActionFrame);
		
		List<By> premiseTreeFrame = Arrays.asList(By.name("main"), By.id("tabPage"),By.id("premiseTreeIFrame"));
		premiseTree = new ElementHandler(aut, By.id("premiseTreeIFrame"), premiseTreeFrame);

		List<By> tendersGridFrame = Arrays.asList(By.id("tendersGrid"));
		tendersGrid = new ElementHandler(aut, By.id("tendersGrid"), tendersGridFrame);

		
		/*
		 * CP_FIN.09 - 2020-06-03 - Start Add
		 */
		List<By> payGridFrame = Arrays.asList(By.id("payGridpaymentGri"));
		payGrid = new ElementHandler(aut, By.id("payGridpaymentGri"), payGridFrame);
		/*
		 * CP_FIN.09 - 2020-06-03 - End Add
		 */
		
		/*
		 * CP_FIN.12 - 2020-06-03 - Start Add
		 */
		List<By> saFrame = Arrays.asList(By.id("SA"), By.id("tabPage"));
		sa = new ElementHandler(aut, By.id("SA"), saFrame);
		/*
		 * CP_FIN.12 - 2020-06-03 - End Add
		 */
		
		/*
		 * CP_CI.032 - 2020-06-04 - Start Add
		 */
		List<By> alertGridFrame = Arrays.asList(By.id("AlertGrid_alerts"));
		alertGrid = new ElementHandler(aut, By.id("payGridpaymentGri"), payGridFrame);
		/*
		 * CP_CI.032 - 2020-06-04 - End Add
		 */
		
		
		/*
		 * CP_CC.002 - 2020-06-30 - Start Add
		 */
		List<By> collRefHisGridFrame = Arrays.asList(By.id("collRefHis_datagrid"));
		collRefHisGrid = new ElementHandler(aut, By.id("collRefHis_datagrid"), collRefHisGridFrame);
		/*
		 * CP_CC.002 - 2020-06-30 - End Add
		 */
		
		/*
		 * CP_CI.030 - 2020-07-13 - Start Add
		 */
		List<By> uiMapList = Arrays.asList(By.name("main"), By.id("uiMap"));
		uiMapFrame = new ElementHandler(aut, By.id("uiMap"), uiMapList);
		/*
		 * CP_CI.030 - 2020-07-13 - End Add
		 */
		
		/*
		 * CP_CI.069 - 2020-07-16 - Start Add
		 */
		List<By> startStopList = Arrays.asList(By.name("main"), By.id("tabPage"),By.id("strtStpFrm"));
		startStopFrame = new ElementHandler(aut, By.id("strtStpFrm"), startStopList);
		/*
		 * CP_CI.069 - 2020-07-16 - End Add
		 */
		
		List<By> premiseSPFrameList = Arrays.asList(By.name("main"), By.id("PREM_TREE"));
		premiseSPFrame = new ElementHandler(aut, By.id("PREM_TREE"), premiseSPFrameList);

	}
}
