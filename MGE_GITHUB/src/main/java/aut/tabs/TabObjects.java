/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Tab Objects
 * 
 *************************************************************************************
 *  
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * 2020-05-05	RExtra	CP_CC.003	Add components for Adding a Collection Process
 * 2020-05-13	RExtra	CP_CC.019	Add components for Manually Adding Credit Points
 * 2020-05-13	RExtra	CP_CC.020	Add components for Modifying Collection Event
 * 									Trigger Date
 * 2020-06-04	RExtra	CP_CI.032	Add components for Adding a Manual Alert
 * 2020-06-22	RExtra	CP_FS.009.	Add components to Create and Complete FA.
 * 2020-07-09	RExtra	CP_FIN.26	Add components for Transferring of Balance
 * 
 *************************************************************************************
 */
package aut.tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;

public class TabObjects {
	public final Tab personCorrespondenceInfo, personCharacteristics;
	public final Tab accountAutoPay, accountPersons, accountCharacteristics;
	public final Tab premiseMisc, premiseMain, premiseChar, premiseGeo;
	public final Tab transferAdj;
	public final Tab characteristics;
	public final Tab locationHistory;
	public final Tab main;
	public final Tab rateInfo;
	public final Tab saSp;
	public final Tab controlAccountInfo;
	public final Tab dashboard;
	public final Tab questionMisc;
	public final Tab ccLog;
	public final Tab algorithm;
	
	/*
	 * CP_CC.003 - 2020-05-05 - Start Add
	 */
	public final Tab sa;
	 
	/*
	 * CP_CC.003 - 2020-05-05 - End Add
	 */
	
	/*
	 * CP_CC.019 - 2020-05-13 - Start Add
	 */
	public final Tab credAndColl;
	/*
	 * CP_CC.019 - 2020-05-13 - End Add
	 */
	
	/*
	 * CP_CC.020 - 2020-05-14 - Start Add
	 */
	public final Tab events;
	/*
	 * CP_CC.020 - 2020-05-14 - End Add
	 */
	
	/*
	 * CP_FIN.10 - 2020-06-02 - Start Add
	 */
	public final Tab tenders;
	/*
	 * CP_FIN.10 - 2020-06-02 - End Add
	 */
	
	/*
	 * CP_CI.032 - 2020-06-04 - Start Add
	 */
	public final Tab accountAlerts;
	/*
	 * CP_CI.032 - 2020-06-04 - End Add
	 */
	
	/*
	 * CP_FS.009 - 2020-06-22 - Start Add
	 */
	public final Tab steps;
	/*
	 * CP_FS.009 - 2020-06-22 - End Add
	 */
	/*
	 *  2020-09-28 - Start Add - AChangco
	 */
	public final Tab budget;
	public final Tab cqrc;
	public final Tab billMessage;
	
	/*
	 *  2020-09-28 - End Add - AChangco
	 */
	
	/*
	 *  2020-09-29 - Start Add - AChangco
	 */
	public final Tab accountTree;
	
	/*
	 *  2020-09-29 - End Add - AChangco
	 */
	
	/*
	 *  2020-09-30 - Start Add - AChangco
	 */
	public final Tab billPaymentTree;

	/*
	 *  2020-09-30 - End Add - AChangco
	 */
	
	/*
	 *  2020-10-05 - Start Add - AChangco
	 */
	public final Tab pendingFieldActivity;
	public final Tab paHistory;
	
	/*
	 * 2020-10-05 - End Add - AChangco
	 */
	public TabObjects(WebDriver aut, EntityFrameObjects frames) {
		
		//Tabs common to all
		main = new Tab(aut, By.xpath("//*[@id=\"MAIN_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		characteristics = new Tab(aut, By.xpath("//*[@id=\"CHARACTER_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
				
		//Tabs available in Person page
		personCorrespondenceInfo = new Tab(aut, By.xpath("//*[@id=\"CORINFO_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		personCharacteristics = new Tab(aut, By.xpath("//*[@id=\"PERCHAR_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());

		//Tabs available in Account page
		accountAutoPay = new Tab(aut, By.xpath("//*[@id=\"AUTOPAY_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		accountPersons = new Tab(aut, By.xpath("//*[@id=\"PERSONS_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		accountCharacteristics = new Tab(aut, By.xpath("//*[@id=\"ACCTCHAR_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		
		/*
		 * CP_CI.032 - 2020-06-04 - Start Add
		 */
		accountAlerts = new Tab(aut, By.xpath("//*[@id='ALERT_TLBL']/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		/*
		 * CP_CI.032 - 2020-06-04 - End Add
		 */
		
		//Tabs available in Premise page
		premiseMain = new Tab(aut, By.xpath("//*[@id=\"MAIN_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		premiseChar = new Tab(aut, By.xpath("//*[@id=\"CHAR_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		premiseMisc = new Tab(aut, By.xpath("//*[@id=\"MISC_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		premiseGeo = new Tab(aut, By.xpath("//*[@id=\"GEODATA_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		
		//Tabs available in Adjustment page
		transferAdj = new Tab(aut, By.xpath("//*[@id=\"TRANSFER_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		
		//Tabs available in Order page
		questionMisc = new Tab(aut, By.xpath("//*[@id=\"ENRL_MISC_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		
		locationHistory = new Tab(aut, By.xpath("//*[@id=\"LOC_HIST_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		rateInfo = new Tab(aut, By.xpath("//*[@id=\"RATE_INFO_LBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		saSp = new Tab(aut, By.xpath("//*[@id=\"SASP_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		
		controlAccountInfo = new Tab(aut, By.xpath("//*[@id=\"ACCOUNTINQ_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		dashboard = new Tab(aut, By.id("dashboard") , frames.main.toFrameMap());
		
		//Tabs available in Order page
		ccLog = new Tab(aut, By.xpath("//*[@id=\"LOG_LBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		
		/*
		 * CP_CC.003 - 2020-05-05 - Start Add
		 */
		sa = new Tab(aut, By.xpath("//*[@id='SAS_TLBL']/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		 
		/*
		 * CP_CC.003 - 2020-05-05 - End Add
		 */
		
		/*
		 * CP_CC.019 - 2020-05-13 - Start Add
		 */
		credAndColl = new Tab(aut, By.xpath("//*[@id='CRRATING_TLBL']/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		
		/*
		 * CP_CC.019 - 2020-05-13 - End Add
		 */
		
		
		/*
		 * CP_CC.020 - 2020-05-14 - Start Add
		 */
		events = new Tab(aut, By.xpath("//*[@id='EVENTS_TLBL']/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		/*
		 * CP_CC.020 - 2020-05-14 - End Add
		 */
		
		/*
		 * CP_FIN.10 - 2020-06-02 - Start Add
		 */
		tenders = new Tab(aut, By.xpath("//*[@id='TENDERS_TLBL']/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		/*
		 * CP_FIN.10 - 2020-06-02 - End Add
		 */
		
		
		/*
		 * CP_FS.009 - 2020-06-22 - Start Add
		 */
		steps = new Tab(aut, By.xpath("//*[@id='STEPS_TLBL']/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		/*
		 * CP_FS.009 - 2020-06-22 - End Add
		 */
		
		algorithm = new Tab(aut, By.xpath("//*[@id='ALGORITHM_TLBL']/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		
		/*
		 * - 2020-09-28 - Start Add - AChangco
		 */
		budget = new Tab(aut, By.xpath("//*[@id=\"BUDGET_TLBL\"]/table/tbody/tr[2]/td "), frames.tabMenu.toFrameMap());
		//Tabs in Service Agreement Chars,Qty % Rec. Charges
		cqrc = new Tab(aut, By.xpath("//*[@id=\"CHAR_QTY_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		billMessage = new Tab(aut, By.xpath("//*[@id=\"CHAR_QTY_TLBL\"]/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		
		/*
		 * - 2020-09-28 - End Add - AChangco
		 */
		
		/*
		 * 2020-09-29 - Start Add - AChangco
		 */
		
		//Tabs in Control Central
		accountTree = new Tab(aut, By.xpath("//*[@id=\'ACCTTREE_TLBL\']/table/tbody/tr[2]/td "), frames.tabMenu.toFrameMap());
		
		/*
		 * 2020-09-29 - End Add - AChangco
		 */
		/*
		 
		 *  2020-09-30 - Start Add - AChangco
		 */
		//Tabs in Control Central
		billPaymentTree = new Tab(aut, By.xpath("//*[@id=\'BPTREE_TLBL\']/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		/*
		 * 2020-09-30 - End Add - - AChangco
		 */
		
		/*
		 *  2020-10-05 - Start Add - AChangco
		 */
		//Tabs in Start Stop
		pendingFieldActivity = new Tab(aut, By.xpath("//*[@id=\'PENDING_FA_LBL\']/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		
		//Tabs in Payment Arrangement
		paHistory = new Tab(aut, By.xpath("//*[@id=\'HISTORY_TLBL\']/table/tbody/tr[2]/td"), frames.tabMenu.toFrameMap());
		/*
		 * 2020-10-05 - End Add - AChangco
		 */
	}
}
