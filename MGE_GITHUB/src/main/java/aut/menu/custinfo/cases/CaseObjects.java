/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Case Objects
 * 
 *************************************************************************************
 * 
 * Author: Jefferson Malayo
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:		Reason: 
 * 2020-9-29	JMalayo	Initial Version
 * 2020-9-29	JMalayo	CP.3.1.10.001 Approving an Urgent LSE Case
 * 2020-9-30	JMalayo CP3.1.9.A.001 Create High Bill Complaint
 * 2020-9-30	JMalayo CP3.1.9.A.004 Transitioning case from Investigation 
 * 						Started to Field Investigation Pending Status
 * 2020-9-30	JMalayo CP3.1.9.A.006 Transitioning High Bill complaint case from 
 * 						Field Investigation Pending - ReBill requested to close
 * 2020-9-30	JMalayo CP3.1.9.B.002 Create PSCW case(Exit case and PSC in Inbox) 
 * 						- Customer NOT in Collections
 * 2020-9-30	JMalayo CP3.1.9.B.005 Transitioning PSCW case from Lodged - Awaiting 
 * 						to Closed
 * 2020-9-30	JMalayo CP.3.1.7.013 Closing a Landlord Case in Initial Status
 * 2020-9-30	JMalayo CP.3.1.12.014 Transition Case CoS: Joint Metering status from 
 * 						Processing to Contact
 * 2020-10-1 	JMalayo CP.3.1.12.009 Auto Transition Case - CoS: Diversion of Service 
 * 						status from Field Processing to Resolved
 * 
 *************************************************************************************
 */

package aut.menu.custinfo.cases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;

import ey.manila.qa.automation.element.ElementHandler;
import aut.entity.EntityFrameObjects;
import aut.menu.MenuObjects;

public class CaseObjects {
	private WebDriver driver;
	private EntityFrameObjects frame;

	
	public final ElementHandler caseId;
	public final ElementHandler caseType;
	public final ElementHandler caseTypeSearchIcon;
	public final ElementHandler caseSearchIcon;
	public final ElementHandler accountId;
	public final ElementHandler verifyDocumentBtn;
	public final ElementHandler caseApproveBtn;
	public final ElementHandler fieldRelativeActContextMenu;
	public final ElementHandler activityField;
	public final ElementHandler activityFieldFrame;
	public final ElementHandler popUpCaseType;
	public final ElementHandler popUpCaseTypeSearchBtn;
	public final ElementHandler popUpDescription;
	public final ElementHandler popUpDescriptionSearchBtn;
	public final ElementHandler popUpPremId;
	public final ElementHandler popUpPremIdSearchBtn;
	public final ElementHandler popUpPersonId;
	public final ElementHandler popUpPersonIdSearchBtn;
	public final ElementHandler acctSearchBtn;
	public final ElementHandler servicePoint;
	public final ElementHandler saveBtnFieldActivity;
	
	//Buttons
	public final ElementHandler activityFieldOkBtn;
	public final ElementHandler activityFieldCancelBtn;
	public final ElementHandler sendLSECertBtn;
	public final ElementHandler cancelApplicationBtn;
	public final ElementHandler verifyCertDocBtn;
	public final ElementHandler approveCertBtn;
	public final ElementHandler denyCertBtn;
	public final ElementHandler contactMethod;
	
	
	//Characteristic Table
	/*
	 * CP3.1.9.A.001 - 2020-09-30 - JMalayo - Start Add
	 */
	public final ElementHandler characteristicFrame;	
	/*
	 * CP3.1.9.A.001 - 2020-09-30 - JMalayo - End Add
	 */
	
	//uiMap
	public final ElementHandler startDateDay;
	public final ElementHandler startDateTime;
	public final ElementHandler fieldTaskType;
	public final ElementHandler fieldPrio;
	public final ElementHandler instructions;
	public final ElementHandler saveBtn;
	
	/*
	 * CP3.1.9.A.004 - 2020-09-30 - JMalayo - Start Add
	 */
	public final ElementHandler activityTypeFiled;
	public final ElementHandler investigateHighBillBtn;
	public final ElementHandler fieldInvestigationBtn;
	/*
	 * CP3.1.9.A.004 - 2020-09-30 - JMalayo - End Add
	 */
	
	/*
	 * CP3.1.9.A.006- 2020-09-30 - JMalayo - Start Add
	 */
	public final ElementHandler closeResolveHighBillComplaintBtn;
	/*
	 * CP3.1.9.A.006 - 2020-09-30 - JMalayo - End Add
	 */
	
	/*
	 * CP3.1.9.B.002- 2020-09-30 - JMalayo - Start Add
	 */
	public final ElementHandler reviewPSCWBtn;
	public final ElementHandler closeResolvePSCWBtn;
	/*
	 * CP3.1.9.B.002 - 2020-09-30 - JMalayo - End Add
	 */
	
	/*
	 * CP3.1.9.B.005 - 2020-09-30 - JMalayo - Start Add
	 */
	public final ElementHandler waitPSCWEmailBtn;
	/*
	 * CP3.1.9.B.005 - 2020-09-30 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.12.014 - 2020-09-01 - JMalayo - Start Add
	 */
	public final ElementHandler sendLettersToTenantandLandlordBtn;
	/*
	 * CP.3.1.12.014 - 2020-10-01 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.12.009 - 2020-09-01 - JMalayo - Start Add
	 */
	public final ElementHandler forwardToBillProcess;
	public final ElementHandler resolveConService;
	/*
	 * CP.3.1.12.009 - 2020-10-01 - JMalayo - End Add
	 */
	
	
	
	public CaseObjects(WebDriver aut, EntityFrameObjects frame){
		driver = aut;
		this.frame = frame;
		caseId = new ElementHandler(aut, By.id("CASE_ID"), frame.tabPage.toFrameMap());
		caseType = new ElementHandler(aut, By.id("CASE_TYPE_CD"), frame.tabPage.toFrameMap());
		caseTypeSearchIcon = new ElementHandler(aut, By.id("IM_CASE_TYPE_CD"), frame.tabPage.toFrameMap());
		caseSearchIcon = new ElementHandler(aut, By.id("IM_CASE_ID"), frame.tabPage.toFrameMap());
		verifyDocumentBtn = new ElementHandler(aut, By.xpath("//*[@value='Verify Documents for Urgent Applications']"), frame.tabPage.toFrameMap());
		caseApproveBtn = new ElementHandler(aut, By.xpath("//*[@value='Approve"), frame.tabPage.toFrameMap());
		fieldRelativeActContextMenu = new ElementHandler(aut, By.xpath("CI_CONTEXTSERVICEPOINT_subMenuItem0x1"), frame.main.toFrameMap());
		popUpCaseType = new ElementHandler(aut, By.id("CASE_TYPE_CD"));
		popUpCaseTypeSearchBtn = new ElementHandler(aut, By.id("BU_MAIN_SEARCH"));
		popUpDescription = new ElementHandler(aut, By.id("DESCR"));
		popUpDescriptionSearchBtn = new ElementHandler(aut, By.id("BU_ALTR_SEARCH"));
		popUpPremId = new ElementHandler(aut, By.id("PREM_ID"));
		popUpPremIdSearchBtn = new ElementHandler(aut, By.id("BU__premId_premSrch"));
		popUpPersonId = new ElementHandler(aut, By.id("PER_ID"));
		popUpPersonIdSearchBtn = new ElementHandler(aut, By.id("BU_Main_search"));
		accountId = new ElementHandler(aut, By.id("ACCT_ID"));
		acctSearchBtn = new ElementHandler(aut, By.id("BU_Alternate_bsAltSrch"));
		
		//Buttons
		sendLSECertBtn = new ElementHandler(aut, By.xpath("//*[@value='Send LSE Certification Letter"), frame.tabPage.toFrameMap());
		cancelApplicationBtn = new ElementHandler(aut, By.xpath("//*[@value='Cancel Application"), frame.tabPage.toFrameMap());
		verifyCertDocBtn = new ElementHandler(aut, By.xpath("//*[@value='Verify Certification Documents"), frame.tabPage.toFrameMap());
		approveCertBtn = new ElementHandler(aut, By.xpath("//*[@value='Approve"), frame.tabPage.toFrameMap());
		denyCertBtn = new ElementHandler(aut, By.xpath("//*[@value='Deny Certification"), frame.tabPage.toFrameMap());
		contactMethod = new ElementHandler(aut, By.id("CONTACT_METH_FLG"), frame.tabPage.toFrameMap());
		
		/*
		 * CP3.1.9.A.006- 2020-09-30 - JMalayo - Start Add
		 */
		closeResolveHighBillComplaintBtn = new ElementHandler(aut, By.xpath("//*[@value ='Close / Resolve High Bill Complaint']"), frame.tabPage.toFrameMap());
		/*
		 * CP3.1.9.A.006- 2020-09-30 - JMalayo - End Add
		 */
		
		/*
		 * CP3.1.9.B.002- 2020-09-30 - JMalayo - Start Add
		 */
		reviewPSCWBtn = new ElementHandler(aut, By.xpath("//*[@value ='Review PSC W Complaint']"), frame.tabPage.toFrameMap());
		closeResolvePSCWBtn = new ElementHandler(aut, By.xpath("//*[@value ='Close/Resolve']"), frame.tabPage.toFrameMap());
		/*
		 * CP3.1.9.B.002- 2020-09-30 - JMalayo - End Add
		 */
		
		/*
		 * CP3.1.9.B.005 - 2020-09-30 - JMalayo - Start Add
		 */
		waitPSCWEmailBtn = new ElementHandler(aut, By.xpath("//*[@value ='Wait for PSCW Email']"), frame.tabPage.toFrameMap());
		/*
		 * CP3.1.9.B.005 - 2020-09-30 - JMalayo - End Add
		 */
		
		/*
		 * CP.3.1.12.014 - 2020-09-01 - JMalayo - Start Add
		 */
		sendLettersToTenantandLandlordBtn = new ElementHandler(aut, By.xpath("//*[@value ='Send Letters to Tenant and Landlord']"), frame.tabPage.toFrameMap());
		/*
		 * CP.3.1.12.014 - 2020-09-01 - JMalayo - End Add
		 */
		
		/*
		 * CP.3.1.12.009 - 2020-09-01 - JMalayo - Start Add
		 */
		forwardToBillProcess = new ElementHandler(aut, By.xpath("//*[@value ='Forward to Billing for Processing']"), frame.tabPage.toFrameMap());
		resolveConService = new ElementHandler(aut, By.xpath("//*[@value ='Resolve Condition of Service']"), frame.tabPage.toFrameMap());
		/*
		 * CP.3.1.12.009 - 2020-09-01 - JMalayo - End Add
		 */
		
		
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("uiMap"));
		activityFieldFrame = new ElementHandler(driver, By.id("uiMap"), frame.main.toFrameMap());
		activityField = new ElementHandler(aut, By.xpath("//*[@value='Approve"), map);
		activityFieldOkBtn = new ElementHandler(aut, By.xpath("//*[@class ='oraButton oraDefault'][0]"), map);
		activityFieldCancelBtn = new ElementHandler(aut, By.xpath("//*[@class ='oraButton oraDefault'][1]"), map);
		startDateDay = new ElementHandler(driver, By.id("startDateTime_date"), map);
		startDateTime =new ElementHandler(driver, By.id("startDateTime_time"), map);
		fieldTaskType =new ElementHandler(driver, By.id("fieldTaskType"), map);
		fieldPrio =new ElementHandler(driver, By.id("cmPriority"), map);
		instructions =new ElementHandler(driver, By.id("boGroup_instructions"), map);
		saveBtnFieldActivity =new ElementHandler(driver, By.id("SAVE_BTN_MP"), map);
		saveBtn =new ElementHandler(driver, By.id("SAVE_BTN_LBL"), map);
		servicePoint = new ElementHandler(driver, By.id("boGroup_spId"), map);

		/*
		 * CP3.1.9.A.004 - 2020-09-30 - JMalayo - Start Add
		 */
		activityTypeFiled =new ElementHandler(driver, By.id("desc"), map);
		investigateHighBillBtn = new ElementHandler(aut, By.xpath("//*[@value ='Investigate High Bill']"), frame.tabPage.toFrameMap());
		fieldInvestigationBtn = new ElementHandler(aut, By.xpath("//*[@value ='Field Investigation']"), frame.tabPage.toFrameMap());

		/*
		 * CP3.1.9.A.004 - 2020-09-30 - JMalayo - End Add
		 */
		
		/*
		 * CP3.1.9.A.001 - 2020-09-30 - JMalayo - End Add
		 */
		map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("CASE_CHAR"));
		characteristicFrame = new ElementHandler(driver, By.id("CASE_CHAR"), map);
		/*
		 * CP3.1.9.A.001 - 2020-09-30 - JMalayo - End Add
		 */
	}
	
	/*
	 * CP3.1.9.A.001 - 2020-09-30 - JMalayo - Start Add
	 */
	/**
	 * <p>Creates dynamic elements for case characteristic type.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getCaseCharTypeAtIndex(int index) {
		String id = "CASE_CHAR:" + String.valueOf(index) + "$CHAR_TYPE_CD";
		return new ElementHandler(driver, By.id(id), characteristicFrame.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for case characteristic value.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getCaseCharValueAtIndex(int index) {
		String id = "CASE_CHAR:" + String.valueOf(index) + "$CHAR_VAL_FK1";
		return new ElementHandler(driver, By.id(id), characteristicFrame.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for case page to add new row on characteristic table.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getAddCaseCharRowAtIndex(int index) {
		String id = "IM_CASE_CHAR:" + String.valueOf(index) + "$ADD_BTN";
		return new ElementHandler(driver, By.id(id), characteristicFrame.toFrameMap());
	}
	
	/*
	 * CP3.1.9.A.001 - 2020-09-30 - JMalayo - End Add
	 */
}
