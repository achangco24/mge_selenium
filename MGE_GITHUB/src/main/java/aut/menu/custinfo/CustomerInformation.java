/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Customer Information
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-16	GSando	CI.022. Add components for adding a Log Entry to a 
 * 								Customer Contact.       
 * 2020-10-12	JMalayo	CP.3.1.7.013 Closing a Landlord Case in Initial Status       
 * 2020-10-12	JMalayo	CP.3.1.7.001 Establish Landlord Agreement to Account
 * 2020-10-12	JMalayo	CP.3.1.7.002 Add Premise to Existing Landlord Agreement
 *************************************************************************************
 */
package aut.menu.custinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.IMenu;
import aut.menu.MenuHandler;
import aut.menu.custinfo.person.PersonMenu;
import aut.menu.custinfo.account.AccountMenu;
import aut.menu.custinfo.customercontact.CustomerContactMenu;
import aut.menu.custinfo.landlordagreement.LandLordMenu;
import aut.menu.custinfo.premisemanagement.PremiseManagementMenu;
import aut.menu.custinfo.cases.CaseMenu;
import aut.menu.custinfo.premise.PremiseMenu;
import aut.menu.custinfo.sa.ServiceAgreementMenu;
import aut.menu.custinfo.sp.ServicePointMenu;
import aut.menu.custinfo.startstop.StartStopMenu;
import ey.manila.qa.automation.element.ElementHandler;

public class CustomerInformation extends MenuHandler {
	public final IMenu person;
	public final IMenu account;
	public final IMenu premise;
	public final IMenu servicePoint;
	public final IMenu serviceAgreement;
	public final IMenu startStop;
	public final IMenu customerContact;
	
	/*
	 * CP.3.1.7.013 - 2020-10-12 - JMalayo - Start Add
	 */
	public final IMenu cases;
	/*
	 * CP.3.1.7.013 - 2020-10-12 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - Start Add
	 */
	public final IMenu landlordAgreement;
	/*
	 * CP.3.1.7.001 - 2020-10-12 - JMalayo - End Add
	 */
	
	/*
	 * CP.3.1.7.002 - 2020-10-12 - JMalayo - Start Add
	 */
	public final IMenu premManagement;
	/*
	 * CP.3.1.7.002 - 2020-10-12 - JMalayo - End Add
	 */
	
	public CustomerInformation(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		initialize(aut, frame, wait);
		menuMap.add(new ElementHandler(aut, By.id("IM_menuButton"), frame.main.toFrameMap()));
		menuMap.add(new ElementHandler(aut, By.id("CI_MAINMENU_topMenuItem0x7"), frame.main.toFrameMap()));
		
		person = new PersonMenu(aut, frame, wait, menuMap);
		premise = new PremiseMenu(aut, frame, wait, menuMap);
		account = new AccountMenu(aut, frame, wait, menuMap);
		servicePoint = new ServicePointMenu(aut, frame, wait, menuMap);
		serviceAgreement = new ServiceAgreementMenu(aut, frame, wait, menuMap);
		startStop = new StartStopMenu(aut, frame, wait, menuMap);
		/*
		 * CI.022 - 2020-04-16 - Start Add
		 */
		customerContact = new CustomerContactMenu(aut, frame, wait, menuMap);
		/*
		 * CI.022 - 2020-04-16 - End Add
		 */
		
		
		/*
		 * CP.3.1.7.013 - 2020-10-12 - JMalayo - Start Add
		 */
		cases = new CaseMenu(aut, frame, wait, menuMap);
		/*
		 * CP.3.1.7.013 - 2020-10-12 - JMalayo - End Add
		 */
		
		/*
		 * CP.3.1.7.001 - 2020-10-12 - JMalayo - Start Add
		 */
		landlordAgreement = new LandLordMenu(aut, frame, wait, menuMap);
		/*
		 * CP.3.1.7.001 - 2020-10-12 - JMalayo - End Add
		 */
		
		/*
		 * CP.3.1.7.002 - 2020-10-12 - JMalayo - Start Add
		 */
		premManagement = new PremiseManagementMenu(aut, frame, wait, menuMap);
		/*
		 * CP.3.1.7.002 - 2020-10-12 - JMalayo - End Add
		 */
		
		
	}
}
