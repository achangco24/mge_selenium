/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Person
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-06-15	RExtra	CP_CI.001	Add components for Adding a Person Record
 * 2020-10-09	JMalayo	CP.3.1.1.1.010	Add Person and Demographics
 *************************************************************************************
 */
package aut.menu.custinfo.person;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class Person extends Entity {
	private PersonObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;

	public Person(Ccb ccb) {
		this.pageTitle = "Person";
		this.idHolder = "PER_ID";
		this.charGridFrame = By.id("Char2_charGrid");
		this.charHeader = "PER_CHAR";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new PersonObjects(ccb.getDriver(), ccb.getCcbFrames());
	}

	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.customerInformation.person.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Person Page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectPersonBusiness(String flag) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.perBusFlg.toWebElement()));
			repo.perBusFlg.selectTextAs(flag);
//			wait.until(ExpectedConditions.elementToBeClickable(repo.getContactTypeElementAtIndex(row).toWebElement()));
//			repo.getContactTypeElementAtIndex(row).selectTextAs(contactTypeCode);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Person/Business: " + flag);
			logger.log(e);
			return false;
		}
	}

	public boolean enterPersonNameAtRow(String personName, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getPersonNameElementAtIndex(row).toWebElement()));
			repo.getPersonNameElementAtIndex(row).toWebElement().click();
			repo.getPersonNameElementAtIndex(row).toWebElement().sendKeys(personName);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Person Name: " + personName);
			logger.log(e);
			return false;
		}
	}

	public boolean selectContactTypeAtRow(String contactTypeCode, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getContactTypeElementAtIndex(row).toWebElement()));
			repo.getContactTypeElementAtIndex(row).selectTextAs(contactTypeCode);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Contact Type: " + contactTypeCode);
			logger.log(e);
			return false;
		}
	}

	public boolean enterContactNumberAtRow(String phoneNumber, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getContactNumberElementAtIndex(row).toWebElement()));
			repo.getContactNumberElementAtIndex(row).toWebElement().click();
			repo.getContactNumberElementAtIndex(row).toWebElement().sendKeys(phoneNumber);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Conteact Number: " + phoneNumber);
			logger.log(e);
			return false;
		}

	}

	public boolean setContactAsPrimaryAtRow(int row, boolean isPrimary) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getContactPrimarySwitchElementAtIndex(row).toWebElement()));
			repo.getContactPrimarySwitchElementAtIndex(row).tickAs(isPrimary);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Primary Contact");
			logger.log(e);
			return false;
		}
	}

	public boolean selectPersonIdTypeAtRow(String idTypeCode, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getPersonIdTypeElementAtIndex(row).toWebElement()));
			repo.getPersonIdTypeElementAtIndex(row).selectTextAs(idTypeCode);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Person ID Type: " + idTypeCode);
			logger.log(e);
			return false;
		}
	}

	public boolean enterPersonIdNumberAtRow(String idNumber, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getPersonIdNumberElementAtIndex(row).toWebElement()));
			repo.getPersonIdNumberElementAtIndex(row).toWebElement().click();
			repo.getPersonIdNumberElementAtIndex(row).toWebElement().sendKeys(idNumber);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Enter Person ID: " + idNumber);
			logger.log(e);
			return false;
		}
	}

	public boolean setIdentifierAsPrimaryAtRow(int row, boolean isPrimary) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getPersonIdPrimarySwitchElementAtIndex(row).toWebElement()));
			repo.getPersonIdPrimarySwitchElementAtIndex(row).tickAs(isPrimary);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Primary Identifier");
			logger.log(e);
			return false;
		}
	}

	public boolean setAddAccount(boolean addAccountFlag) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.addAccountSwitch.toWebElement()));
			repo.addAccountSwitch.tickAs(addAccountFlag);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Account Create");
			logger.log(e);
			return false;
		}
	}

	public boolean savePerson() throws Exception {
		try {
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Person");
			logger.log(e);
			return false;
		}
	}

	public boolean setAddress1(String id) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.address1.toWebElement()));
			repo.address1.toWebElement().sendKeys(id);
			repo.address1.toWebElement().sendKeys(Keys.ENTER);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Address1: " + id);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setCity(String id) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.city.toWebElement()));
			repo.city.toWebElement().sendKeys(id);
			repo.city.toWebElement().sendKeys(Keys.ENTER);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input City: " + id);
			logger.log(e);
			return false;
		}
	}
	
	public boolean clearAddress1() throws Exception {
		String id = repo.address1.toWebElement().getText();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.address1.toWebElement()));
			
			repo.address1.toWebElement().clear();
			System.out.println(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input clear Address1: " + id);
			logger.log(e);
			return false;
		}
	}
	
	public boolean clearCity() throws Exception {
		String id = repo.city.toWebElement().getText();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.city.toWebElement()));
			repo.city.toWebElement().clear();
			System.out.println(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to clear City: " + id);
			logger.log(e);
			return false;
		}
	}
	
	public boolean checkIDExist() throws Exception{
		try {
			boolean flag = checkid();
			if(flag == false) {
				screenshot.capture();
				driver.close();
				driver.quit();
				return false;
			}
			screenshot.capture();
			System.out.println("Succesfully Created a Person with ID :" + getId());
			logger.log("Succesfully Created a Person with ID :" +getId());
			logger.log("Customer is Saved");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Person ID Exist");
			logger.log(e);
			return false;
		}
	}
	
	public boolean switchToCorrInfo() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.personCorrespondenceInfo.getWebElement()));
			tabs().personCorrespondenceInfo.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Swtich to Person - Correspondence Info");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CI.001 - 2020-06-15 - Start Add
	 */
	public boolean selectCustClassCd(String custClass) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.custClassCd.getLocator()));
			repo.custClassCd.selectTextAs(custClass);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Customer Class as '" + custClass + "'");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.001 - 2020-06-15 - End Add
	 */
	
	/*
	 * CP.3.1.1.1.010 - 2020-10-09 - JMalayo - Start Add
	 */
	public boolean switchToCharacteristicTab() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.characteristics.getWebElement()));
			tabs().characteristics.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Swtich to Person - Characteristic");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addCharacteristicRow(String idTypeCode, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getPlusCharRowBtnAtIndex(row).toWebElement()));
			repo.getPlusCharRowBtnAtIndex(row).toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to add new row on Characteristic Table.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectCharType(String charType, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getCharTypeAtIndex(row).toWebElement()));
			repo.getCharTypeAtIndex(row).selectTextAs(charType);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Characteristic Type: " + charType);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setCharValue(String charValue, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getCharValueAtIndex(row).toWebElement()));
			repo.getCharValueAtIndex(row).toWebElement().click();
			repo.getCharValueAtIndex(row).toWebElement().sendKeys(charValue);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Characteristic Value: " + charValue);
			logger.log(e);
			return false;
		}
	}
	public boolean setCharEffectiveDate(String effectiveDate, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getCharEffictiveDateAtIndex(row).toWebElement()));
			repo.getCharEffictiveDateAtIndex(row).toWebElement().click();
			repo.getCharEffictiveDateAtIndex(row).toWebElement().clear();
			repo.getCharEffictiveDateAtIndex(row).toWebElement().sendKeys(effectiveDate);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Effective Date: " + effectiveDate);
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP.3.1.1.1.010 - 2020-10-09 - JMalayo - End Add
	 */
}