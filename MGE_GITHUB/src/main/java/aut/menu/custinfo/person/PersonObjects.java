/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Person Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:		Reason: 
 * 2020-06-15	RExtra	CP_CI.001		Add components for Adding a Person Record
 * 2020-09-28 	JMalayo	CP.3.1.1.007	Add components
 * 
 *************************************************************************************
 */
package aut.menu.custinfo.person;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class PersonObjects extends WebElementRepository {
	private WebDriver driver;
	
	private final ElementHandler framePersonName;
	private final ElementHandler framePersonContactDetails;
	private final ElementHandler framePersonIdentifier;
	private final ElementHandler frameCharacteristic;
	
	public final ElementHandler perBusFlg;
	public final ElementHandler addAccountSwitch;
	public final ElementHandler address1;
	public final ElementHandler city;
	
	/*
	 * CP_CI.001 - 2020-06-15 - Start Add
	 */
	public final ElementHandler custClassCd;
	/*
	 * CP_CI.001 - 2020-06-15 - End Add
	 */
	
	/*
	 * CP.3.1.1.007 - 2020-09-28- JMalayo - Start Add
	 */
	public final ElementHandler lifeSuppSenLoad;
	public final ElementHandler lifeSuppSenLoadDescr;
	/*
	 * CP.3.1.1.007 - 2020-09-28- JMalayo - End Add
	 */
	
	
	public PersonObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("PER_NAME"));
		framePersonName = new ElementHandler(driver, By.id("PER_NAME"), map);
		
		map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("PER_CONT_DETL"));
		framePersonContactDetails = new ElementHandler(driver, By.id("PER_CONT_DETL"), map);
		
		map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("PER_IDENTIFIER"));
		framePersonIdentifier = new ElementHandler(driver, By.id("PER_IDENTIFIER"), map);
		
		map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("Char2_charGrid"));
		frameCharacteristic = new ElementHandler(driver, By.id("Char2_charGrid"), map);
		
		perBusFlg = new ElementHandler(aut, By.id("PER_OR_BUS_FLG"), frame.tabPage.toFrameMap());
		addAccountSwitch = new ElementHandler(aut, By.id("ADD_ACCT_SW"), frame.tabPage.toFrameMap());
		address1 = new ElementHandler(aut, By.id("ADDRESS1"), frame.tabPage.toFrameMap());
		city = new ElementHandler(aut, By.id("CITY"), frame.tabPage.toFrameMap());
		
		/*
		 * CP_CI.001 - 2020-06-15 - Start Add
		 */
		custClassCd = new ElementHandler(aut, By.id("CUST_CL_CD"), frame.tabPage.toFrameMap());
		/*
		 * CP_CI.001 - 2020-06-15 - End Add
		 */
		
		/*
		 * CP.3.1.1.007 - 2020-09-28- JMalayo - Start Add
		 */
		lifeSuppSenLoad = new ElementHandler(aut, By.id("LS_SL_FLG"), frame.tabPage.toFrameMap());
		lifeSuppSenLoadDescr = new ElementHandler(aut, By.id("LS_SL_DESCR"), frame.tabPage.toFrameMap());
		/*
		 * CP.3.1.1.007 - 2020-09-28- JMalayo - End Add
		 */
		
	}
	
	/**
	 * <p>Creates dynamic elements for person names.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getPersonNameElementAtIndex(int index) {
		String id = "PER_NAME:" + String.valueOf(index) + "$ENTITY_NAME";
		return new ElementHandler(driver, By.id(id), framePersonName.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for person contact type.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getContactTypeElementAtIndex(int index) {
		String id = "PER_CONT_DETL:" + String.valueOf(index) + "$COMM_RTE_TYPE_CD";
		return new ElementHandler(driver, By.id(id), framePersonContactDetails.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for person contact number.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getContactNumberElementAtIndex(int index) {
		String id = "PER_CONT_DETL:" + String.valueOf(index) + "$CONTACT_VALUE";
		return new ElementHandler(driver, By.id(id), framePersonContactDetails.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for the primary contact switch of the person contacts.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getContactPrimarySwitchElementAtIndex(int index) {
		String id = "PER_CONT_DETL:" + String.valueOf(index) + "$CND_PRIMARY_SW";
		return new ElementHandler(driver, By.id(id), framePersonContactDetails.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for person identifier type.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getPersonIdTypeElementAtIndex(int index) {
		String id = "PER_IDENTIFIER:" + String.valueOf(index) + "$ID_TYPE_CD";
		return new ElementHandler(driver, By.id(id), framePersonIdentifier.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for person identifier number.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getPersonIdNumberElementAtIndex(int index) {
		String id = "PER_IDENTIFIER:" + String.valueOf(index) + "$PER_ID_NBR";
		return new ElementHandler(driver, By.id(id), framePersonIdentifier.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for person identifier primary switch.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getPersonIdPrimarySwitchElementAtIndex(int index) {
		String id = "PER_IDENTIFIER:" + String.valueOf(index) + "$PRIM_SW";
		return new ElementHandler(driver, By.id(id), framePersonIdentifier.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for person contact add row.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getPlusContactRowBtnAtIndex(int index) {
		String id = "IM_PER_CONT_DETL:" + String.valueOf(index) + "$pContactDetail-Add_BUTTON";
		return new ElementHandler(driver, By.id(id), framePersonContactDetails.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for person identifier add row.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getPlusIDRowBtnAtIndex(int index) {
		String id = "IM_PER_IDENTIFIER:" + String.valueOf(index) + "$pIdents_Add";
		return new ElementHandler(driver, By.id(id), framePersonContactDetails.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for person characteristic add row.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getPlusCharRowBtnAtIndex(int index) {
		String id = "IM_PER_CHAR:" + String.valueOf(index) + "$Grid_btnAdd";
		return new ElementHandler(driver, By.id(id), frameCharacteristic.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for person characteristic type.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getCharTypeAtIndex(int index) {
		String id = "PER_CHAR:" + String.valueOf(index) + "$CHAR_TYPE_CD";
		return new ElementHandler(driver, By.id(id), frameCharacteristic.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for person characteristic value.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getCharValueAtIndex(int index) {
		String id = "PER_CHAR:" + String.valueOf(index) + "$ADHOC_CHAR_VAL";
		return new ElementHandler(driver, By.id(id), frameCharacteristic.toFrameMap());
	}
	
	/**
	 * <p>Creates dynamic elements for person characteristic value.</p>
	 * @param index Row number for the element to be created. CCB starts at index zero by default.
	 * @return {@link ey.manila.qa.automation.element.ElementHandler} of the dynamic element
	 */
	public ElementHandler getCharEffictiveDateAtIndex(int index) {
		String id = "PER_CHAR:" + String.valueOf(index) + "$EFFDT";
		return new ElementHandler(driver, By.id(id), frameCharacteristic.toFrameMap());
	}
}
