/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Customer Contact Objects
 * 
 *************************************************************************************
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-16	GSando	Initial version.     
 * 2020-06-19	RExtra	CP_CI.031	Add components for Adding a Customer Contact
 * 2020-9-29	JMalayo CP.3.1.7.002 Add components on Related Record Table
 * 2020-10-12	JMalayo	CP.3.1.7.001	Establish Landlord Agreement to Account
 * 2020-10-12	JMalayo	CP.3.1.7.002	Add Premise to Existing Landlord Agreement
 * 2010-10-12	JMalayo	CP.3.1.7.005	Provide Written Notice of Intent to Transfer
 * 										Billing Responsibility
 *************************************************************************************
 */
package aut.menu.custinfo.customercontact;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ey.manila.qa.automation.element.ElementHandler;
import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;

public class CustomerContactObjects {
	private WebDriver driver;
	private EntityFrameObjects frame;
	protected MenuObjects menuObj;
	
	public final ElementHandler moreInfo;
	public final ElementHandler overridelink;
	
	//CustomerContact Search Pop-up
	public final ElementHandler perId;
	public final ElementHandler perIdSearchBtn;
	public final ElementHandler ccId;
	public final ElementHandler ccIdSearchBtn;
	
	//Main Tab
	/*
	 * CP_CI.031 - 2020-06-19 - Start Add
	 */
	public final ElementHandler contactClass;
	public final ElementHandler contactType;
	public final ElementHandler userID;
	/*
	 * CP_CI.031 - 2020-06-19 - End Add
	 */
		
	//Log Tab
	public final ElementHandler logContent;
	public final ElementHandler logId;
	public final ElementHandler addLogEntry;
	
	/*
	 * CP.3.1.7.002 - 2020-9-29 - JMalayo - Start Add
	 */
	public final ElementHandler relRecordFrame;
	/*
	 * CP.3.1.7.002 - 2020-9-29 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - Start Add
	 */
	public final ElementHandler prefContactMethod;
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.7.002 - 2020-10-12 - JMalayo - Start Add
	 */
	public final ElementHandler charFrame;
	/*
	 * CP.3.1.7.002 - 2020-10-12 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.7.005 - 2020-10-12 - JMalayo - Start Add
	 */
	public final ElementHandler accountId;
	public final ElementHandler searchType; 
	public final ElementHandler personId;
	public final ElementHandler acctId;
	public final ElementHandler premId;
	
	/*
	 * CP.3.1.7.005 - 2020-10-12 - JMalayo - End Add
	 */
	
	public CustomerContactObjects(WebDriver aut, EntityFrameObjects frame){
		driver = aut;
		this.frame = frame;
		menuObj = new MenuObjects(aut, frame);
		
		//For Pop-up Window
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		
		//CustomerContact Search Pop-up
		perId = new ElementHandler(aut, By.id("PER_ID"));
		perIdSearchBtn = new ElementHandler(aut, By.id("BU_PERID_perMnSrch"));
		ccId = new ElementHandler(aut, By.id("CC_ID"));
		ccIdSearchBtn = new ElementHandler(aut, By.id("BU_Main_mainSearch"));
		
		//Main Tab
		/*
		 * CP_CI.031 - 2020-06-19 - Start Add
		 */
		contactClass = new ElementHandler(aut, By.id("CC_CL_CD"), frame.tabPage.toFrameMap());
		contactType = new ElementHandler(aut, By.id("CC_TYPE_CD"), frame.tabPage.toFrameMap());
		userID = new ElementHandler(aut, By.id("USER_ID"), frame.tabPage.toFrameMap());
		/*
		 * CP_CI.031 - 2020-06-19 - End Add
		 */
		
		//Log Tab
		logId = new ElementHandler(driver, By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[1]/td[4]/div/span"),  this.frame.tabPage.toFrameMap());
		logContent = new ElementHandler(driver, By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/span/textarea"),  this.frame.tabPage.toFrameMap());
		addLogEntry = new ElementHandler(driver, By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/img[3]"), this.frame.tabPage.toFrameMap());
	
		/*
		 * CP.3.1.7.002 - 2020-9-29 - JMalayo - End Add
		 */
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("CC_LOG_GRID"));
		relRecordFrame = new ElementHandler(driver, By.id("CC_LOG_GRID"), map);
		
		map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("CC_LOG_GRID"));
		charFrame = new ElementHandler(driver, By.id("CC_LOG_GRID"), this.frame.tabPage.toFrameMap());
		/*
		 * CP.3.1.7.002 - 2020-9-29 - End Add
		 */
		
		/*
		 * CP.3.1.7.001 - 2020-10-12 - JMalayo - Start Add
		 */
		 prefContactMethod = new ElementHandler(aut, By.id("CONTACT_METH_FLG"), frame.tabPage.toFrameMap());
		/*
		 * CP.3.1.7.001 - 2020-10-12 - JMalayo - End Add
		 */
		 
		/*
		 * CP.3.1.7.005 - 2020-10-12 - JMalayo - Start Add
		 */
		accountId = new ElementHandler(aut, By.id("ACCT_ID"));
		searchType = new ElementHandler(aut, By.id("CC_SRCH_SUBCRIT_FLG"));
		personId = new ElementHandler(aut, By.id("PER_ID"), frame.tabPage.toFrameMap());
		acctId = new ElementHandler(aut, By.id("ACCT_ID"), frame.tabPage.toFrameMap());
		premId = new ElementHandler(aut, By.id("PREM_ID"), frame.tabPage.toFrameMap());
		/*
		 * CP.3.1.7.005 - 2020-10-12 - JMalayo - End Add
		 */
	}
	
	/*
	 * CP.3.1.7.002 - 2020-9-29 - JMalayo - Start Add
	 */
	/**
	 * <p>Creates dynamic elements for log entry.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getLogEntryAtIndex(int index) {
		String id = "CC_LOG:" + String.valueOf(index) + "$CC_LOG_CONTENT";
		return new ElementHandler(driver, By.id(id), relRecordFrame.toFrameMap());
	}
	/*
	 * CP.3.1.7.002 - 2020-9-29 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - Start Add
	 */
	/**
	 * <p>Creates dynamic elements for log entry.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getAddLogEntryAtIndex(int index) {
		String id = "IM_CC_LOG:" + String.valueOf(index) + "$Grid_addLog";
		return new ElementHandler(driver, By.id(id), relRecordFrame.toFrameMap());
	}
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - End Add
	 */
	
	
	/*
	 * CP.3.1.7.002 - 2020-10-12 - JMalayo - Start Add
	 */
	/**
	 * <p>Creates dynamic elements for log entry.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getCharacteristicValueAtIndex(int index) {
		String id = "CC_CHAR:" + String.valueOf(index) + "$ADHOC_CHAR_VAL";
		return new ElementHandler(driver, By.id(id), charFrame.toFrameMap());
	}
	/*
	 * CP.3.1.7.002 - 2020-10-12 - JMalayo - End Add
	 */
	
}
