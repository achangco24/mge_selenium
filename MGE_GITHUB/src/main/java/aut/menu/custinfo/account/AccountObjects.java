/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Account Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-05-13	RExtra	CP_CC.019	Add components for Manually Adding Credit Points  
 * 2020-06-03	RExtra	CP_FIN.11	Add components for Canceling Auto Pay  
 * 2020-06-04	RExtra	CP_CI.004	Add components for Setting up Auto Pay
 * 2020-06-04	RExtra	CP_CI.032	Add components for Adding a Manual Alert
 * 2020-09-28	JMalayo CP.3.1.1.001	Add components to handle the Search Person 
 * 										Window
 * 2020-09-29	JMalayo CP.3.1.7.001	Add components for Landlord Navigation
 * 										using Account context menu button.
 * 2020-10-12	JMalayo CP.3.1.7.001	Add components to handle Add and Search Context
 * 										Menu
 *************************************************************************************
 */
package aut.menu.custinfo.account;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import aut.menu.MenuObjects;
import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;

public class AccountObjects {
	private WebDriver driver;
	private EntityFrameObjects frame;
	protected MenuObjects menuObj;
	
	public final ElementHandler cisDivision;
	public final ElementHandler accountid;
	public final ElementHandler mailingpremise;
	public final ElementHandler addressSource;
	public final ElementHandler postal;
	public final ElementHandler address1;
	public final ElementHandler city;
	
	
	/*
	 * CP_CC.019 - 2020-05-13 - Start Add
	 */
	//C&C Tab
	public final ElementHandler addCredRatingHistory;
	public final ElementHandler credRatHistStartDate;
	public final ElementHandler credRatHistEndDate;
	public final ElementHandler credRatingPoints;
	public final ElementHandler credAndCollComments;
	/*
	 * CP_CC.019 - 2020-05-13 - End Add
	 */
	
	
	//Auto Pay Tab
	/*
	 * CP_FIN.11 - 2020-06-02 - Start Add
	 */
	public final ElementHandler autoPayEndDate;
	public final ElementHandler accountInfo;
	/*
	 * CP_FIN.11 - 2020-06-02 - End Add
	 */
	
	/*
	 * CP_CI.004 - 2020-06-04 - Start Add
	 */
	public final ElementHandler autoPayStartDate;
	public final ElementHandler autoPaySourceCode;
	public final ElementHandler autoPayExternalAcctID;
	public final ElementHandler autoPayName;
	/*
	 * CP_CI.004 - 2020-06-04 - End Add
	 */
	
	
	/*
	 * CP_CI.032 - 2020-06-04 - Start Add
	 */
	//Alerts Tab
	//public final ElementHandler alertTypeTable;
	private final ElementHandler frameAlertGrid;
	/*
	 * CP_CI.032 - 2020-06-04 - End Add
	 */
	
	/*
	 * CP.3.1.1.001 - 2020-09-28- JMalayo - Start Add
	 */
	public final ElementHandler searchPersonIcon;
	public final ElementHandler sPersonName;
	public final ElementHandler personId;
	public final ElementHandler relationshipType;
	public final ElementHandler financiallyResponsible;
	public final ElementHandler receiveCopyBill;
	public final ElementHandler searchPersonNameBtn;
	public final ElementHandler searchPersonTableResult;
	/*
	 * CP.3.1.1.001 - 2020-09-28- JMalayo - Start Add
	 */
	
	/*
	 * CP.3.1.1.2.EN-065.001 - 2020-09-28- JMalayo - Start Add
	 */
	public final ElementHandler managementGroup;
	public final ElementHandler managementGroupSearchIcon;
	public final ElementHandler searchManagementGroupBtn;
	public final ElementHandler searchManagementGroup;
	/*
	 * CP.3.1.1.2.EN-065.001  - 2020-09-28- JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.7.001 - 2020-09-29- JMalayo - Start Add
	 */
	public final ElementHandler accountContextMenuBtn;
	public final ElementHandler landlordContextMenu;
	/*
	 * CP.3.1.7.001  - 2020-09-29- JMalayo - End Add
	 */
	//Budget Tab
	/*
	 * 2020-09-28 - Start Add -AChangco
	 */
	public final ElementHandler recomBudget;
	public final ElementHandler cancelBudget;
	public final ElementHandler budgetPlan;
	public final ElementHandler budgetDate;
	public final ElementHandler newBudget;
	/*
	 * 2020-09-28 - End Add -AChangco
	 */
	
	//Deposit Tab
			/*
			 *  2020-09-29 - Start Add -AChangco
			 */
			public final ElementHandler depStartDate;
			public final ElementHandler depEndDate;
			public final ElementHandler depNCDT;
			public final ElementHandler depClass;
			public final ElementHandler depAmount;
			/*
			 * 2020-09-29 - End Add -AChangco
			 */
			
	/*
	 * CP.3.1.7.001  - 2020-10-12- JMalayo - Start Add
	 */		
	public final ElementHandler add;
	public final ElementHandler search;		
	/*
	 * CP.3.1.7.001  - 2020-10-12- JMalayo - End Add
	 */
	
	public AccountObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		
		cisDivision = new ElementHandler(driver, By.id("CIS_DIVISION"), this.frame.tabPage.toFrameMap());
		accountid = new ElementHandler(driver, By.id("ACCT_ID"), this.frame.tabPage.toFrameMap());
		mailingpremise = new ElementHandler(driver, By.id("MAILING_PREM_ID"), this.frame.tabPage.toFrameMap());
		addressSource = new ElementHandler(driver, By.id("ACCT_PER$BILL_ADDR_SRCE_FLG"), this.frame.tabPage.toFrameMap());
		postal = new ElementHandler(driver, By.id("ACCT_PER$POSTAL"), this.frame.tabPage.toFrameMap());
		address1 = new ElementHandler(driver, By.id("ACCT_PER$ADDRESS1"), this.frame.tabPage.toFrameMap());
		city = new ElementHandler(driver, By.id("ACCT_PER$CITY"), this.frame.tabPage.toFrameMap());
		
		//Auto Pay Tab
		/*
		 * CP_FIN.11 - 2020-06-02 - Start Add
		 */
		autoPayEndDate = new ElementHandler(driver, By.id("ACCT_APAY$END_DT"), this.frame.tabPage.toFrameMap());
		accountInfo = new ElementHandler(driver, By.id("ACCT_INFO"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_FIN.11 - 2020-06-02 - End Add
		 */
		
		/*
		 * CP_CI.004 - 2020-06-04 - Start Add
		 */
		autoPayStartDate = new ElementHandler(driver, By.id("ACCT_APAY$START_DT"), this.frame.tabPage.toFrameMap());
		autoPaySourceCode = new ElementHandler(driver, By.id("ACCT_APAY$APAY_SRC_CD"), this.frame.tabPage.toFrameMap());
		autoPayExternalAcctID = new ElementHandler(driver, By.id("ACCT_APAY$EXT_ACCT_ID"), this.frame.tabPage.toFrameMap());
		autoPayName = new ElementHandler(driver, By.id("ACCT_APAY$ENTITY_NAME"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_CI.004 - 2020-06-04 - End Add
		 */
		
		/*
		 * CP_CC.019 - 2020-05-13 - Start Add
		 */
		//C&C Tab
		addCredRatingHistory = new ElementHandler(driver, By.id("IM_Sect2_AddButton"), this.frame.tabPage.toFrameMap());
		credRatHistStartDate = new ElementHandler(driver, By.id("CR_RAT_HIST$START_DT"), this.frame.tabPage.toFrameMap());
		credRatHistEndDate = new ElementHandler(driver, By.id("CR_RAT_HIST$END_DT"), this.frame.tabPage.toFrameMap());
		credRatingPoints = new ElementHandler(driver, By.id("CR_RAT_HIST$CR_RATING_PTS"), this.frame.tabPage.toFrameMap());
		credAndCollComments = new ElementHandler(driver, By.id("CR_RAT_HIST$COMMENTS"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_CC.019 - 2020-05-13 - End Add
		 */
		
		/*
		 * CP_CI.032 - 2020-06-04 - Start Add
		 */
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("AlertGrid_alerts"));
		frameAlertGrid = new ElementHandler(driver, By.id("AlertGrid_alerts"), map);
		
		//alertTypeTable = new ElementHandler(driver, By.xpath("//*[@id='ACCT_ALERT:0$ALERT_TYPE_CD']"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_CI.032 - 2020-06-04 - End Add
		 */
		
		/*
		 * CP.3.1.1.2.EN-065.001  - 2020-09-28- JMalayo - Start Add
		 */
		searchPersonIcon = new ElementHandler(driver, By.id("IM_ACCT_PER$PER_ID"), this.frame.tabPage.toFrameMap());
		sPersonName = new ElementHandler(driver, By.id("ENTITY_NAME"));
		personId = new ElementHandler(driver, By.id("ACCT_PER$PER_ID"), this.frame.tabPage.toFrameMap());
		searchPersonNameBtn = new ElementHandler(driver, By.id("BU_Alternate_search"));
		relationshipType = new ElementHandler(driver, By.id("ACCT_PER$ACCT_REL_TYPE_CD"), this.frame.tabPage.toFrameMap());
		financiallyResponsible = new ElementHandler(driver, By.id("ACCT_PER$FIN_REP_SW"), this.frame.tabPage.toFrameMap());
		receiveCopyBill = new ElementHandler(driver, By.id("ACCT_PER$RECEIVE_COPY_SW"), this.frame.tabPage.toFrameMap());
		managementGroup = new ElementHandler(driver, By.id("ACCT_MGMT_GRP_CD"), this.frame.tabPage.toFrameMap());
		managementGroupSearchIcon = new ElementHandler(driver, By.id("IM_ACCT_MGMT_GRP_CD"), this.frame.tabPage.toFrameMap());
		searchPersonTableResult = new ElementHandler(driver, By.id("SEARCH_RESULTS|0|2"));
		
		searchManagementGroup = new ElementHandler(driver, By.id("ACCT_MGMT_GRP_CD"));
		searchManagementGroupBtn = new ElementHandler(driver, By.id("BU_Main_acctMngSch"));
		/*
		 * CP.3.1.1.2.EN-065.001  - 2020-09-28- JMalayo - End Add
		 */
		
		/*
		 * sPersonId = new ElementHandler(driver, By.id("PER_ID"), map); sIdType = new
		 * ElementHandler(driver, By.id("ID_TYPE_CD"), map); sIdNumber = new
		 * ElementHandler(driver, By.id("PER-ID_NBR"), map);
		 */
		
		/*
		 * CP.3.1.7.001 - 2020-09-29- JMalayo - Start Add
		 */
		accountContextMenuBtn = new ElementHandler(driver, By.id("IM_Main_acctCntxt"), this.frame.tabPage.toFrameMap());
		landlordContextMenu = new ElementHandler(driver, By.id("CI_CONTEXTACCOUNT_subMenuItem1x22"), frame.main.toFrameMap());
		/*
		 * CP.3.1.7.001  - 2020-09-29- JMalayo - End Add
		 */
		//Budget Tab
		/*
		 *  2020-09-25 - Start Add -AChangco
		 */
		recomBudget = new ElementHandler(driver, By.id("ACCT_APAY$END_DT"), this.frame.tabPage.toFrameMap());
		cancelBudget = new ElementHandler(driver, By.id("ACCT_INFO"), this.frame.tabPage.toFrameMap());
		budgetPlan = new ElementHandler(driver, By.id("ACCT_INFO"), this.frame.tabPage.toFrameMap());
		budgetDate = new ElementHandler(driver, By.id("NEW_BUD_DT"), this.frame.tabPage.toFrameMap());
		newBudget = new ElementHandler(driver, By.id("SA_BUDGET:0$NEW_BUD_AMT"), this.frame.tabPage.toFrameMap());
		
		/*
		 * 2020-09-25 - End Add -AChangco
		 */ 
		//Deposit Tab
		/*
		 * 2020-09-29 - Start Add -AChangco
		 */
		depStartDate = new ElementHandler(driver, By.id("ACCT_APAY$END_DT"), this.frame.tabPage.toFrameMap());
		depEndDate = new ElementHandler(driver, By.id("ACCT_NCD$NCD_TYPE_CD"), this.frame.tabPage.toFrameMap());
		depNCDT = new ElementHandler(driver, By.id("ACCT_NCD$DEP_CL_CD "), this.frame.tabPage.toFrameMap());
		depClass = new ElementHandler(driver, By.id("ACCT_NCD$DEP_CL_CD "), this.frame.tabPage.toFrameMap());
		depAmount = new ElementHandler(driver, By.id("ACCT_NCD$DEP_AMT"), this.frame.tabPage.toFrameMap());
		
		/*
		 *  2020-09-29 - End Add -AChangco
		 */
	
		/*
		 * CP.3.1.7.001  - 2020-10-12- JMalayo - Start Add
		 */
		add = menuObj.add; 
		search = menuObj.search;
		/*
		 * CP.3.1.7.001  - 2020-10-12- JMalayo - End Add
		 */
	}
	
	
	/*
	 * CP_CI.032 - 2020-06-04 - Start Add
	 */

	public ElementHandler getContactTypeElementAtIndex(int index) {
		String id = "ACCT_ALERT:" + String.valueOf(index) + "$ALERT_TYPE_CD";
		return new ElementHandler(driver, By.id(id), frameAlertGrid.toFrameMap());
	}
	
	/*
	 * CP_CI.032 - 2020-06-04 - End Add
	 */
	
	
	
	
}
