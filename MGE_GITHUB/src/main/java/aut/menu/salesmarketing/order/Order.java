/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Order
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-07-14	RExtra	CP_CI.068	Add components for Starting Service Using an
 * 									Order/Campaign RES
 * 2020-07-16	RExtra	CP_CI.069	Add components for Starting Service Using an
 * 									Order/Campaign COM
 * 
 *************************************************************************************
 */
package aut.menu.salesmarketing.order;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.entity.Entity;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class Order extends Entity{
	private OrderObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public Order(Ccb ccb) {
		this.pageTitle = "Order";
		this.idHolder = "ENRL_ID";
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new OrderObjects(ccb.getDriver(), ccb.getCcbFrames());
	}

	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.salesMarketing.order.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed loading Order page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean search() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.salesMarketing.order.search();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed loading Order page");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean searchPopUpOrderId(String orderId) throws Exception {
		try {
//			boolean ssl = false;
//			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//			Set<String> id = driver.getWindowHandles();
//			Iterator<String> pages = id.iterator();
//			String main = pages.next();
//			String windows = "";
//			while(pages.hasNext()) {
//				windows = pages.next();
//			}
//			driver.switchTo().window(windows);
//			ssl = isElementPresent(repo.moreInfo.getLocator());
//			if (ssl == false) {
//				String temp = windows;
//				windows = main;
//				main = temp;
//				driver.switchTo().window(windows);
//			}
			String main = driver.getWindowHandle();
			System.out.println(main + " = This is main window!");
			System.out.println(String.valueOf(driver.getWindowHandles().size()) + " number of windows");
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> windowHandles = driver.getWindowHandles();
			System.out.println("WindowHandles="+String.valueOf(driver.getWindowHandles()));
			
			String popWindow = "";
			int i = 0;
			for (String windowHandle : windowHandles) {
				i += 1;
				System.out.println(windowHandle + " = " + String.valueOf(i) + " window");
				if (!main.equalsIgnoreCase(windowHandle)) {
					popWindow = windowHandle;
				}
			}
			
			if (popWindow != null) {
				driver.switchTo().window(popWindow);
			}else {
				System.out.println("null popWindow");
				return false;
			}
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
			repo.moreInfo.toWebElement().click();
			popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
			repo.overridelink.toWebElement().click();
			popWait.until(ExpectedConditions.elementToBeClickable(repo.ordId.toWebElement()));
			repo.ordId.toWebElement().click();
			repo.ordId.toWebElement().clear();
			repo.ordId.toWebElement().sendKeys(orderId);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.ordIdSearchBtn.toWebElement()));
			repo.ordIdSearchBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Search Successful: " + orderId);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching Order ID in Pop up: " + orderId);
			logger.log(e);
    		return false;
		}
	}
	
	public boolean enterName(String personName) throws Exception {
		String idHolder = repo.name.toWebElement().getAttribute("id");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.name.toWebElement()));
//			repo.name.toWebElement().sendKeys(personName);
			//Replace the .sendKeys as it is not working after pop-up window 
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + personName + "'");
			repo.name.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Enrollment Name: " + personName);
			logger.log(e);
			return false;
		}
	}
	
	//This method can be enhanced (This is specific to Questions Misc Fields where all responses can be patterned like ENRL_FLD:0$CHAR_VAL)
	public boolean enterResponse(String response) throws Exception {
		String idHolder = repo.qResponse0.toWebElement().getAttribute("id");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.qResponse0.toWebElement()));
			repo.qResponse0.toWebElement().clear();
//			repo.name.toWebElement().sendKeys(personName);
			//Replace the .sendKeys as it is not working after pop-up window 
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + response + "'");
			repo.qResponse0.toWebElement().click();
			repo.qResponse1.toWebElement().click();
			repo.qResponse0.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to enter Enrollment Response: " + response);
			logger.log(e);
			return false;
		}
	}
	
	public boolean switchToQuestionMisc() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.questionMisc.getWebElement()));
			tabs().questionMisc.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Order - Questions and Misc Fields");
			logger.log(e);
			return false;
		}
	}
	
	public boolean switchToMain() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.main.getWebElement()));
			tabs().main.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Switch to Order - Main page");
			logger.log(e);
			return false;
		}
	}
	
	public boolean showEligibility() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.eligibilityBtn.toWebElement()));
			repo.eligibilityBtn.toWebElement().click();
			
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Show Eligibility");
			logger.log(e);
			return false;
		}
	}
	
	public boolean showOrderPackage() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.orderPackage.toWebElement()));
			repo.orderPackage.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Show Order Package");
			logger.log(e);
			return false;
		}
	}
	
	public boolean saveOrder() throws Exception {
		try {
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Order");
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
			System.out.println("Succesfully Created a Order with ID :" + getId());
			logger.log("Succesfully Created a Order with ID :" +getId());
			logger.log("Order is Saved");
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Order ID Exist");
			logger.log(e);
			return false;
		}
	}
	
	public boolean completeOrderPackage() throws Exception {
		try {
			String main = driver.getWindowHandle();
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> windowHandles = driver.getWindowHandles();
			
			String popWindow = "";
			for (String windowHandle : windowHandles) {
				if (!main.equalsIgnoreCase(windowHandle)) {
					popWindow = windowHandle;
				}
			}
			
			if (popWindow != null) {
				driver.switchTo().window(popWindow);
			}else {
				System.out.println("null popWindow");
				return false;
			}
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			
			if(isElementPresent(repo.overridelink.getLocator())){
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			repo.pkgInfo.waitWhileAttributeValue("innerHTML", emptySpan);
			wait.until(ExpectedConditions.elementToBeClickable(repo.completeBtn.toWebElement()));
			repo.completeBtn.toWebElement().click();
			
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			
			driver.switchTo().window(main);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Complete Order Package");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_CI.068 - 2020-07-14 - Start Add
	 */
	public boolean enterCampaign(String campaign) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.campaign.toWebElement()));
			idHolder = repo.campaign.toWebElement().getAttribute("id");
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + campaign + "'");
			repo.campaign.toWebElement().sendKeys(Keys.ENTER);
	       	
			repo.campaignInfo.toWebElement().click();
			
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Enter Campaign as '" + campaign + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterStartDate() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.startDate.toWebElement()));
			LocalDate currDate = LocalDate.now();
			
			idHolder = repo.startDate.toWebElement().getAttribute("id");
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + currDate.format(DateTimeFormatter.ISO_DATE.ofPattern("MM-dd-yyyy")) + "'");
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Entering Start Date as Sytem Date");
			logger.log(e);
			return false;
		}
	}
	
	
	//-------------------------------PERSON INFORMATION SECTION--------------------------------------------------------------
	public boolean selectPersonInfoFlag(String perInfoFlg) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.personInfoFlg.toWebElement()));
			repo.personInfoFlg.selectTextAs(perInfoFlg);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Selecting Person Information as '" + perInfoFlg + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectPersonNameTypeAtRow(String perNameType, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getPersonNameTypeElementAtIndex(row).toWebElement()));
			repo.getPersonNameTypeElementAtIndex(row).selectTextAs(perNameType);;
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Person Name Type as '" + perNameType + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterPersonNameAtRow(String perName, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getPersonNameElementAtIndex(row).toWebElement()));
			idHolder = repo.getPersonNameElementAtIndex(row).toWebElement().getAttribute("id");
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + perName + "'");
	       	repo.getPersonNameElementAtIndex(row).toWebElement().sendKeys(Keys.ENTER);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Person Name as '" + perName + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectPersonContactTypeAtRow(String perContactType, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getPersonContactTypeElementAtIndex(row).toWebElement()));
			repo.getPersonContactTypeElementAtIndex(row).selectTextAs(perContactType);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Person Contact Type as '" + perContactType + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterPersonContactInfoAtRow(String perContactInfo, int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getPersonContactInfoElementAtIndex(row).toWebElement()));
			idHolder = repo.getPersonContactInfoElementAtIndex(row).toWebElement().getAttribute("id");
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + perContactInfo + "'");
	       	repo.getPersonContactInfoElementAtIndex(row).toWebElement().sendKeys(Keys.ENTER);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Person Contact Information as '" + perContactInfo + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean tickPersonContactPrimaryAtRow(int row) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getPersonContactPrimaryElementAtIndex(row).toWebElement()));
			repo.getPersonContactPrimaryElementAtIndex(row).tickAs(true);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select as Primary Person Contact");
			logger.log(e);
			return false;
		}
	}
	
	
	//-------------------------------ACCOUNT INFORMATION SECTION--------------------------------------------------------------
	public boolean selectAcctInfoFlag(String acctInfoFlg) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.acctInfoFlg.toWebElement()));
			repo.acctInfoFlg.selectTextAs(acctInfoFlg);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Selecting Account Information as '" + acctInfoFlg + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectCustomerClass(String custClass) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.customerClass.toWebElement()));
			repo.customerClass.selectTextAs(custClass);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Selecting Customer Class as '" + custClass + "'");
			logger.log(e);
			return false;
		}
	}
	
	public boolean answerResCPPQuestions(String mode, String q0, String q1, String q2, String q3, String q4, String q5, String q6, String q7) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.qResponse0.toWebElement()));
			if(mode.equals("DEFAULT")){
				defaultResCPPAnswers();
			}
			
			if(mode.equals("MANUAL")){
				if(q0.equals("~"))
					q0 = "";
				if(q1.equals("~"))
					q1 = "";
				if(q2.equals("~"))
					q2 = "";
				if(q3.equals("~"))
					q3 = "";
				if(q4.equals("~"))
					q4 = "";
				if(q5.equals("~"))
					q5 = "";
				if(q6.equals("~"))
					q6 = "";
				if(q7.equals("~"))
					q7 = "";
				manualResCPPAnswers(q0, q1, q2, q3, q4, q5, q6, q7);
			}
			System.out.println("Successfully Answered the Questions using Mode: " + mode);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Answering Order Questions using Mode: " + mode);
			logger.log(e);
			return false;
		}
	}
	
	
	/*
	 * This method assumes that the sequence of questions and answers is as follows:
	 * [0] CSR has completed Customer and Premise analysis (Y/N)  - Y
	 * [1] Completed Check for Protective Light at Premise? (Y/N) - Y
	 * [2] Customer Deposit Required? If Yes, Select deposit amount – N/A
	 * [3] Proceed with Order? If additional information or action is required please select and place the order on Hold. – Y
	 * [4] CSR Determines: Additional Person ID to add to Account? - Blank
	 * [5] CSR Determines: Account/Person Relationship Type? - Blank
	 * [6] CSR Determines: Person Name (If Person ID does not exist) - Blank
	 * [7] CPP Account Type ***SYSTEM GENERATED - DO NOT MODIFY ***  - CPP
	 * 
	 */
	public void defaultResCPPAnswers() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.qResponse0.toWebElement()));
			answerQuestionAtIndex(0, "Y");
			answerQuestionAtIndex(1, "Y");
			answerQuestionAtIndex(2, "N/A");
			answerQuestionAtIndex(3, "Y");
			answerQuestionAtIndex(4, "");
			answerQuestionAtIndex(5, "");
			answerQuestionAtIndex(6, "");
			answerQuestionAtIndex(7, "CPP");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Setting Default Answers for RES CPP Campaign'");
			logger.log(e);
		}
	}
	
	/*
	 * This method assumes that the sequence of questions is as follows:
	 * [0] CSR has completed Customer and Premise analysis (Y/N)
	 * [1] Completed Check for Protective Light at Premise? (Y/N)
	 * [2] Customer Deposit Required? If Yes, Select deposit amount
	 * [3] Proceed with Order? If additional information or action is required please select and place the order on Hold.
	 * [4] CSR Determines: Additional Person ID to add to Account?
	 * [5] CSR Determines: Account/Person Relationship Type?
	 * [6] CSR Determines: Person Name (If Person ID does not exist)
	 * [7] CPP Account Type ***SYSTEM GENERATED - DO NOT MODIFY ***
	 * 
	 */
	public void manualResCPPAnswers(String q0, String q1, String q2, String q3, String q4, String q5, String q6, String q7) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.qResponse0.toWebElement()));
			answerQuestionAtIndex(0, q0);
			answerQuestionAtIndex(1, q1);
			answerQuestionAtIndex(2, q2);
			answerQuestionAtIndex(3, q3);
			answerQuestionAtIndex(4, q4);
			answerQuestionAtIndex(5, q5);
			answerQuestionAtIndex(6, q6);
			answerQuestionAtIndex(7, q7);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Setting Manual Answers for RES CPP Campaign'");
			logger.log(e);
		}
	}
	
	/*
	 * CP_CI.068 - 2020-07-14 - End Add
	 */
	
	/*
	 * CP_CI.069 - 2020-07-16 - Start Add
	 */
	public boolean selectPerOrBusFlag(String perOrBusFlg) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.perOrBusFlg.toWebElement()));
			repo.perOrBusFlg.selectTextAs(perOrBusFlg);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Selecting Person/Business Flag as '" + perOrBusFlg + "'");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * This method assumes that the sequence of questions and answers is as follows:
	 * [0]	CSR has completed Customer and Premise analysis (Y/N)  - Y
	 * [1]	Completed Check for Protective Light at Premise? (Y/N) - Y
	 * [2]	Customer Type = E-COM
	 * [3]	Customer Deposit Required? If Yes, Select deposit amount = N/A
	 * [4]	System Retrieves Primary Discount. – Blank
	 * [5]	System Retrieves Voltage Discount  - Blank
	 * [6]	System Retrieves Sub Station Owner Discount  - Blank
	 * [7]	Is Customer eligible for Solar? = N
	 * [8]	Does Customer quality for Tax Exemption?  = N
	 * [9]	If Customer Type is Cap Enhancement, set Minimum KWD.   = 0
	 * [10]	Proceed with Order? If additional information or action is required please select and place the order on Hold. = Y
	 * [11]	CPP Account Type ***SYSTEM GENERATED - DO NOT MODIFY ***  - CPP
	 * 
	 */
	public void defaultComCPPAnswers() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.qResponse0.toWebElement()));
			answerQuestionAtIndex(0, "Y");
			answerQuestionAtIndex(1, "Y");
			answerQuestionAtIndex(2, "E-COM");
			answerQuestionAtIndex(3, "N/A");
			answerQuestionAtIndex(4, "");
			answerQuestionAtIndex(5, "");
			answerQuestionAtIndex(6, "");
			answerQuestionAtIndex(7, "N");
			answerQuestionAtIndex(8, "N");
			answerQuestionAtIndex(9, "0");
			answerQuestionAtIndex(10, "Y");
			answerQuestionAtIndex(11, "CPP");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Setting Default Answers for COM CPP Campaign'");
			logger.log(e);
		}
	}
	
	/*
	 * This method assumes that the sequence of questions as follows:
	 * [0]	CSR has completed Customer and Premise analysis (Y/N)
	 * [1]	Completed Check for Protective Light at Premise? (Y/N)
	 * [2]	Customer Type
	 * [3]	Customer Deposit Required? If Yes, Select deposit amount
	 * [4]	System Retrieves Primary Discount.
	 * [5]	System Retrieves Voltage Discount
	 * [6]	System Retrieves Sub Station Owner Discount
	 * [7]	Is Customer eligible for Solar?
	 * [8]	Does Customer quality for Tax Exemption?
	 * [9]	If Customer Type is Cap Enhancement, set Minimum KWD. 
	 * [10]	Proceed with Order? If additional information or action is required please select and place the order on Hold.
	 * [11]	CPP Account Type ***SYSTEM GENERATED - DO NOT MODIFY ***
	 * 
	 */
	public void manualComCPPAnswers(String q0, String q1, String q2, String q3, String q4, String q5, String q6, String q7, String q8, String q9, String q10, String q11) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.qResponse0.toWebElement()));
	       	
			answerQuestionAtIndex(0, q0);
			answerQuestionAtIndex(1, q1);
			answerQuestionAtIndex(2, q2);
			answerQuestionAtIndex(3, q3);
			answerQuestionAtIndex(4, q4);
			answerQuestionAtIndex(5, q5);
			answerQuestionAtIndex(6, q6);
			answerQuestionAtIndex(7, q7);
			answerQuestionAtIndex(8, q8);
			answerQuestionAtIndex(9, q9);
			answerQuestionAtIndex(10, q10);
			answerQuestionAtIndex(11, q11);
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Setting Default Answers for COM CPP Campaign'");
			logger.log(e);
		}
	}
	
	public boolean answerComCPPQuestions(String mode, String q0, String q1, String q2, String q3, String q4, String q5, String q6, String q7, String q8, String q9, String q10, String q11) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.qResponse0.toWebElement()));
			if(mode.equals("DEFAULT")){
				defaultComCPPAnswers();
			}
			
			if(mode.equals("MANUAL")){
				if(q0.equals("~"))
					q0 = "";
				if(q1.equals("~"))
					q1 = "";
				if(q2.equals("~"))
					q2 = "";
				if(q3.equals("~"))
					q3 = "";
				if(q4.equals("~"))
					q4 = "";
				if(q5.equals("~"))
					q5 = "";
				if(q6.equals("~"))
					q6 = "";
				if(q7.equals("~"))
					q7 = "";
				if(q8.equals("~"))
					q8 = "";
				if(q9.equals("~"))
					q9 = "";
				if(q10.equals("~"))
					q10 = "";
				if(q11.equals("~"))
					q11 = "";
				manualComCPPAnswers(q0, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11);
			}
			System.out.println("Successfully Answered the Questions using Mode: " + mode);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed Answering Order Questions using Mode: " + mode);
			logger.log(e);
			return false;
		}
	}
	
	public void answerQuestionAtIndex(int index, String answer) throws Exception{
		if(!answer.isEmpty()){
			wait.until(ExpectedConditions.elementToBeClickable(repo.getQuestionResponseElementAtIndex(index).toWebElement()));
			idHolder = repo.getQuestionResponseElementAtIndex(index).toWebElement().getAttribute("id");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + answer + "'");
			repo.getQuestionResponseElementAtIndex(index).toWebElement().sendKeys(Keys.ENTER);
		}
	}
	/*
	 * CP_CI.069 - 2020-07-16 - End Add
	 */
	
}
