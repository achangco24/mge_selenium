/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Premise
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-04-07	GSando	CI.016.		Add components for creating a Premise.
 * 2020-04-23	GSando	CI.018.		Add components for adding a Service Point Record
 * 									to a Premise.
 * 2020-07-14	RExtra	CP_CI.068	Add components for Starting Service Using an
 * 									Order/Campaign RES
 * 2020-10-08	JMalayo	CP.3.1.1.003	Service Cycle Update Billing CYcle
 * 
 *************************************************************************************
 */
package aut.menu.custinfo.premise;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.entity.Entity;
import aut.tabs.characteristics.Characteristic;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class Premise extends Entity  {
	private PremiseObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	
	public Premise(Ccb ccb) {
		this.pageTitle = "Premise";
		this.idHolder = "PREM_ID";
		this.charGridFrame = By.id("premGrid_preChrGrid");
		this.charHeader = "PREM_CHAR";
		this.geoGridFrame = By.id("premGeoGrd_GeoGrid");
		this.geoHeader = "PREM_GEO";
		
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);
		this.ccb = ccb;
		repo = new PremiseObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	public boolean open() throws Exception {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ccb.getCcbFrames().main.getLocator()));
			boolean menuFlag = isElementPresent(ccb.getCcbObjects().barMenu.getLocator());
			if (!menuFlag) {
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.elementToBeClickable(ccb.getCcbObjects().barMenu.toWebElement()));
			}
			commons.menu.customerInformation.premise.add();
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Premise Page");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean search() throws Exception {
		try {
			try {
				driver.switchTo().defaultContent();
				commons.menu.customerInformation.premise.search();
			}catch(Exception e) {
				driver.switchTo().parentFrame();
				commons.menu.customerInformation.premise.search();
			}
			return isPageLoaded();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Navigating to Premise Page");
			logger.log(e);
    		return false;
    	}
	}
	
	public boolean searchPopUpPremId(String premiseId) throws Exception {
		try {
			String main = driver.getWindowHandle();
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> windowHandles = driver.getWindowHandles();
			String popWindow = "";
			int i = 0;
			for (String windowHandle : windowHandles) {
				i += 1;
				if (!main.equalsIgnoreCase(windowHandle)) {
					popWindow = windowHandle;
				}
			}
			
			if (popWindow != null) {
				driver.switchTo().window(popWindow);
			}else {
				return false;
			}
			
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			/*
			 * CI.018 - 2020-04-23 - Start Add
			 */
			if(isElementPresent(repo.moreInfo.getLocator())){
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.moreInfo.getLocator()));
				repo.moreInfo.toWebElement().click();
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			/*
			 * CI.018 - 2020-04-23 - End Add
			 */
			popWait.until(ExpectedConditions.elementToBeClickable(repo.premId.toWebElement()));
			repo.premId.toWebElement().click();
			repo.premId.toWebElement().clear();
			/*
			 * CI.018 - 2020-04-23 - Start Add
			 */
			popWait.until(ExpectedConditions.elementToBeClickable(repo.premId.toWebElement()));
			/*
			 * CI.018 - 2020-04-23 - End Add
			 */
			repo.premId.toWebElement().click();
			repo.premId.toWebElement().clear();
			repo.premId.toWebElement().sendKeys(premiseId);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.premIdSearchBtn.toWebElement()));
			repo.premIdSearchBtn.toWebElement().click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			driver.switchTo().window(main);
			logger.log("Search Successful: " + premiseId);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching Premise ID in Pop up: " + premiseId);
			logger.log(e);
    		return false;
		}
	}
	
	/*
	 * SEC.001 - 2020-07-29 - Start Add
	 */
	public boolean searchPopUpPremAddress(String address, String IDs) throws Exception {
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
				return false;
			}
			
			WebDriverWait popWait = new WebDriverWait(driver, 10);
			if(isElementPresent(repo.overridelink.getLocator())){
				popWait.until(ExpectedConditions.presenceOfElementLocated(repo.overridelink.getLocator()));
				repo.overridelink.toWebElement().click();
			}
			
			popWait.until(ExpectedConditions.elementToBeClickable(repo.popAddress.toWebElement()));
			
			idHolder = repo.popAddress.toWebElement().getAttribute("id");
			JavascriptExecutor js = (JavascriptExecutor)driver;
	       	js.executeScript("document.getElementById(\"" + idHolder + "\").value = '" + address + "'");
			
	       	Thread.sleep(3000);
			popWait.until(ExpectedConditions.elementToBeClickable(repo.popSearchAddressBtn.toWebElement()));
			repo.popSearchAddressBtn.toWebElement().click();
			
			
			List <WebElement> tableRows = repo.popPremResultTbl.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
			int tableSize = tableRows.size();
			System.out.println("Row Count: " + tableSize);
			List<String> premIDList = Arrays.asList(IDs.split("~"));
			
			System.out.print(premIDList);
			
			for(int i = 0; i<tableSize;i++) {
				String currentPremID = driver.findElement(By.xpath("//*[@id='SEARCH_RESULTS:" + i + "$PREM_ID']")).getText();
				System.out.println("Prem ID: " + currentPremID);
				
				if(!premIDList.contains(currentPremID)){
					System.out.println("Premise ID '" + currentPremID + "' is an Unexpected Data");
					return false;
				} else {
					System.out.println("Matched: " + currentPremID);
				}
			}
			
			//wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			//driver.switchTo().window(main);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed in Searching Premise Address in Pop up: " + address);
			logger.log(e);
    		return false;
		}
	}
	/*
	 * SEC.001 - 2020-07-29 - End Add
	 */
	
	public boolean selectPremiseTypeAs(String premiseType) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.premiseType.toWebElement()));
			repo.premiseType.selectTextAs(premiseType);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Premise Type: " + premiseType);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterPostal(String postalCode) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.postalCode.toWebElement()));
			repo.postalCode.toWebElement().click();
			repo.postalCode.toWebElement().sendKeys(postalCode);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Postal Code: " + postalCode);
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectCIS(String cisDiv) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.cisCode.toWebElement()));
			repo.cisCode.selectTextAs(cisDiv);
			repo.cisCode.selectTextAs(cisDiv);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed selecting CIS Division: " + cisDiv);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setTimezone(String timeZone) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.timeZone.toWebElement()));
			repo.timeZone.selectTextAs(timeZone);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input Time Zone: " + timeZone);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterCity(String city) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.city.toWebElement()));
			repo.city.toWebElement().sendKeys(city);
			/*
			 * CI.016 - 2020-04-07 - Start Change
			 */
			//Boolean a = wait.until(ExpectedConditions.textToBePresentInElementValue(repo.city.toWebElement(), city));
			//if(a==true) {
				//System.out.println("CITY ENTERED!");
			//}
			repo.getAddressLineElementAtIndex(1).toWebElement().click();
			
			/*
			 * CI.016 - 2020-04-07 - End Change
			 */
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input City: " + city);
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterCounty(String county) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.county.toWebElement()));
			repo.county.toWebElement().sendKeys(county);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to input County: " + county);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setState(String state) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.state.toWebElement()));
			repo.state.toWebElement().sendKeys(state);
			/*
			 * CI.016 - 2020-04-07 - Start Add
			 */
			repo.state.toWebElement().sendKeys(Keys.ENTER);
			/*
			 * CI.016 - 2020-04-07 - End Add
			 */
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed setting State: " + state);
			logger.log(e);
			return false;
		}
	}
	
	public boolean selectTrendArea(String trendArea) throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.trendArea.toWebElement()));
			repo.trendArea.selectTextAs(trendArea);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Trend Area: " + trendArea);
			logger.log(e);
			return false;
		}
	}
	
	public boolean switchToTabMain() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.premiseMain.getWebElement()));
			tabs.premiseMain.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "Premise - Failed to open Premise Main page");
    		return false;
		}
	}
	
	public boolean switchToTabChar() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.premiseChar.getWebElement()));
			tabs.premiseChar.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "Premise - Failed to switch Premise - Characteristics Tab");
    		return false;
		}
	}
	
	public boolean switchToTabMisc() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.premiseMisc.getWebElement()));
			tabs().premiseMisc.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to switch to Premise - Misc Tab");
			logger.log(e);
			return false;
		}
	}

	public boolean switchToTabGeo() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(tabs.premiseGeo.getWebElement()));
			tabs().premiseGeo.switchTo();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to switch to Premise - Geographic Data Tab");
			logger.log(e);
			return false;
		}
	}
	
	public boolean enterAddressAtLine(int line, String address) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.getAddressLineElementAtIndex(line).toWebElement()));
			repo.getAddressLineElementAtIndex(line).toWebElement().click();
			repo.getAddressLineElementAtIndex(line).toWebElement().sendKeys(address);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Set Address" + line + ": " + address);
			logger.log(e);
			return false;
		}
	}
	
	public boolean savePremise() throws Exception {
		try {
			save();
			if (isAlertPresents(driver)) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();	
			} 
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Save Premise");
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
			System.out.println("Succesfully Created a Premise with ID :" + getId());
			logger.log("Succesfully Created a Premise with ID :" +getId());
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "No Premise ID Exist");
			logger.log(e);
			return false;
		}
	}
	
	public boolean checkCharMatch(String charType, String charValue) throws Exception {
		try {
    		Boolean flag = false;	
    		String codetype = convertToCode(charType);
	     	List<Characteristic> data = characteristics().getAll();
	    	for (int i = 0; i < data.size(); i++) {
	    		if(data.get(i).getType().equals(codetype)) {
	    			if(data.get(i).getValue().equals(charValue)){
	    				flag = true;
	    				System.out.println("CharType: " + data.get(i).getType());
	    				System.out.println("CharValue: " + data.get(i).getValue());
	    				logger.log("MATCH FOUND for Given chartype:" + charType + " and Given charvalue:" + charValue);
	    				screenshot.capture();
	    				return true;
	    			}
	    		}
			}
	    	if(!flag) {
	    		screenshot.capture();
	    		driver.close();
	    		driver.quit();
	    		logger.log("warning", "NO MATCH FOUND for Given chartype:" + charType + " and Given charvalue:" + charValue);
    			return false;
	    	}
	    	return false;
	    } catch (Exception e) {
	    	System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screenshot, driver, "DPU - Failed in Comparing Premise Characteristics...");
    		return false;
    	}
	}
	
	public String convertToCode(String code) {
		if (code.equalsIgnoreCase("Taxing City")){
			return "CI_TCITY";
		} else if (code.equalsIgnoreCase("Taxing State")){
			return "CI_TAXST";
		} else if (code.equalsIgnoreCase("City Code")) {
			return "CITYCODE";
		}
		else
			return null;
	}
	
	public boolean openPremiseContextMenu() throws Exception{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.premiseContextMenu.toWebElement()));
			repo.premiseContextMenu.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Premise context menu.");
			logger.log(e);
			return false;
		}
	}
	
	public boolean addOrder()throws Exception{
		try {
			openPremiseContextMenu();
			repo.orderMenu.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		}  catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click Premise context menu.");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CI.018 - 2020-04-23 - Start Add
	 */
	public boolean addServicePoint() throws Exception {
		try {
			openPremiseContextMenu();
			repo.spMenu.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		}  catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click SP context menu.");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CI.018 - 2020-04-23 - End Add
	 */
	
	/*
	 * CP_CI.068 - 2020-07-14 - Start Add
	 */
	public boolean navToAddOrderThruPremCntxtMenu() throws Exception {
		try {
			openPremiseContextMenu();
			repo.spMenu.toWebElement().click();
			repo.add.toWebElement().click();
			return true;
		}  catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click SP context menu.");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP_CI.068 - 2020-07-14 - End Add
	 */
	
	/*
	 * CP.3.1.1.003 - 2020-10-08 - JMalayo - Start Add
	 */
	public boolean selectSP() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.spLink.toWebElement()));
			repo.spLink.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to select Service Point");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.1.003 - 2020-10-08 - JMalayo - End Add
	 */

}
