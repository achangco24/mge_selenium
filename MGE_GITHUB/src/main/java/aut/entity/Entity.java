/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Entity
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN		Reason text.                
 * 2020-10-12	JMalayo	CP.3.1.9.A Manage Customer Inquiries/Complaints - High Bill
 * 								   Complaints
 * 2020-10-12	JMalayo	CP.3.1.9.B Manage Customer Inquiries/Complaints - PSCW
 * 								   Complaints
 *************************************************************************************
 */
package aut.entity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.Ccb;
import aut.menu.Menu;
import aut.menu.custinfo.cases.CaseObjects;
import aut.tabs.TabObjects;
import aut.tabs.characteristics.CharacteristicGrid;
import aut.tabs.geodata.GeographicDataGrid;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import aut.entity.EntityObjects;

/**
 * <p>Provides a generic object type and shared functionalities to a CCB entity.</p>
 * <p><b>Usage</b><br>
 * <u>Notes when inheriting to a concrete class</u>
 * <ul>
 * 	<li>Make sure to set the following parameters:
 * 		<ul>
 * 			<li><b>pageTitle</b> - expected title of the page</li>
 * 			<li><b>idHolder</b> - ID value of the By locator for the corresponding WebElement of the entity ID text box</li>
 * 			<li><b>charGridFrame</b> - By locator for the characteristics grid</li>
 * 			<li><b>charHeader</b> - String header value that is used in naming convention within the characteristics grid</li>
 * 		</ul>
 * 	</li>
 * 	<li>Call the <b>initialize(Ccb)</b> method in  instantiation</li>
 * </ul></p>
 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
 * @version 1.00
 * @since 2018-10-29
 */
public abstract class Entity implements IEntity {
	protected EntityObjects commons;
	protected WebDriverWait wait;	
	protected WebDriver driver;
	protected String emptySpan = "<span></span>";
	protected String pageTitle = "";
	protected String idHolder = "";
	protected ElementHandler id;
	
	
	protected String charHeader;
	protected By charGridFrame;
	protected String geoHeader;
	protected By geoGridFrame;
	protected long timeout;
	
	/*
	 * CP.3.1.9.A.004 - 2020-10-12 - JMalayo - Start Add
	 */
	private EntityObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private Ccb ccb;
	private CaseObjects caseRepo;
	/*
	 * CP.3.1.9.A.004 - 2020-10-12 - JMalayo - End Add
	 */
	
	protected CharacteristicGrid charGrid;
	public CharacteristicGrid characteristics() {
		return charGrid;
	}
	//lui 10/2
	protected GeographicDataGrid geoGrid;
	public GeographicDataGrid geographicData() {
		return geoGrid;
	}
	
	protected TabObjects tabs;
	public TabObjects tabs() {
		return tabs;
	}
	
	protected Menu menu;
	public Menu getMenu() {
		return menu;
	}
	
	public String getId() throws Exception {
		String id = "";
		while (id.equals("")) {
			id = this.id.toWebElement().getAttribute("value");
		}
		
		return id;
	}
	
	public boolean checkid() throws Exception {
		String id = this.id.toWebElement().getAttribute("value");
		String id2 = "";
		if (id.equals(id2))
			return false;
		else
			return true;
	}
	
	public boolean isAlertPresents(WebDriver driver) {
    	try {
    		driver.switchTo().alert();
    		return true;
    	}// try
    	catch (Exception e) {
    		return false;
    		}// catch
    	}
	
	
	public void save() throws Exception {
		commons.save.toWebElement().click();
	}
	
	public void back() throws Exception {
		commons.back.toWebElement().click();
	}
	
	public void refresh() throws Exception {
		commons.refresh.toWebElement().click();
	}
	
	public boolean isPageLoaded() throws Exception {
		//Compare expected and actual titles
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(commons.title.toWebElement()));
		String title = commons.title.toWebElement().getText();
		if (pageTitle.equals(title)) {
			return true;
		}
		return false;
	}
    
	protected void initialize(Ccb ccb) {
		this.driver = ccb.getDriver();
		this.wait = ccb.getWait();
		this.commons = ccb.getCcbObjects();
		tabs = this.commons.tabs;
		menu = this.commons.menu;
		timeout = ccb.getDefaultImplicitTimer();
		charGrid = new CharacteristicGrid(ccb.getDriver(), wait, ccb.getCcbObjects(), charGridFrame, charHeader);
		geoGrid = new GeographicDataGrid(ccb.getDriver(), wait, ccb.getCcbObjects(), geoGridFrame, geoHeader);
		id = new ElementHandler(driver, By.id(idHolder), commons.frame.tabPage.toFrameMap());
	}
	
	public boolean isElementPresent(By locatorKey) {
	    try {
	    	driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	    	driver.findElement(locatorKey);
	        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	    	driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	        return false;
	    }
	}	
	
	public void moveToFrame(List<By> frameMap) throws Exception {
		driver.switchTo().defaultContent();
		for (By byLocator : frameMap) {
			driver.switchTo().frame(driver.findElement(byLocator));
		}
	}
	
	public String getCurrentFrame() throws Exception{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String currentFrame = (String) js.executeScript("return self.name");
		return currentFrame;
	}
	
	
	/*
	 * CP.3.1.9.A.004 - 2020-10-12 - JMalayo - Start Add
	 */
	
	public void init() throws Exception{
		timeout = ccb.getDefaultImplicitTimer();
		logger = ccb.getLogger();
		errorHandle = ccb.getErrorHandle();
		screenshot = ccb.getScreen();
		initialize(ccb);	
		this.ccb = ccb;
		repo = new EntityObjects(ccb.getDriver(), ccb.getCcbFrames(), wait);
		caseRepo = new CaseObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	public boolean setCharacteristicValueAtRow(String value) throws Exception {
		init();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.searchBar.toWebElement()));
			repo.searchBar.toWebElement().sendKeys(value);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Search: " + value);
			logger.log(e);
			return false;
		}
	}
	
	public boolean navToAddActivityThruSeachBar() throws Exception {
		init();
		try {
			
			WebDriverWait popWait = new WebDriverWait(driver, 10);			
			popWait.until(ExpectedConditions.visibilityOf(repo.searchListBox.toWebElement()));
			List <WebElement> listRows = repo.searchListBox.toWebElement().findElements(By.xpath("//*[@id='oj-listbox-results-menuSearchElem']/li"));
			int listSize = listRows.size();
			for(int x = 0; x < listSize; x++) {
				WebElement  status = driver.findElement(By.xpath("//*[@id='oj-listbox-results-menuSearchElem']/li[" + x + "]/div/span"));
				wait.until(ExpectedConditions.elementToBeClickable(status));
				if(status.getText().equalsIgnoreCase("Add Act")){
					status.click();
					break;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select Item on Search Bar");
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean setActivityType(String activityType) throws Exception{
		init();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(caseRepo.activityTypeFiled.toWebElement()));
			caseRepo.activityTypeFiled.toWebElement().sendKeys(activityType);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Select: " + activityType);
			logger.log(e);
			return false;
		}
	}
	
	public boolean clickOkBtnAtAddActivityWindow(String activityType) throws Exception{
		init();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(caseRepo.activityFieldOkBtn.toWebElement()));
			caseRepo.activityFieldOkBtn.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Click Ok Button on Add Activity Window");
			logger.log(e);
			return false;
		}
	}
	
	public boolean setServiceDateTime(String servDateTime) throws Exception{
		init();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(caseRepo.startDateDay.toWebElement()));
			caseRepo.startDateDay.toWebElement().click();
			caseRepo.startDateDay.toWebElement().sendKeys(servDateTime);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Service Date Time: " + servDateTime);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setServicePoint(String servPoint) throws Exception{
		init();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(caseRepo.servicePoint.toWebElement()));
			caseRepo.servicePoint.toWebElement().click();
			caseRepo.servicePoint.toWebElement().sendKeys(servPoint);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Service Point: " + servPoint);
			logger.log(e);
			return false;
		}
	}
	
	public boolean setFieldTaskType(String fieldTaskType) throws Exception{
		init();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(caseRepo.fieldTaskType.toWebElement()));
			caseRepo.fieldTaskType.toWebElement().click();
			caseRepo.fieldTaskType.toWebElement().sendKeys(fieldTaskType);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to set Field Task Type: " + fieldTaskType);
			logger.log(e);
			return false;
		}
	}
	
	
	public boolean clickSaveBtnFieldActivtyWindow(String fieldTaskType) throws Exception{
		init();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(caseRepo.saveBtnFieldActivity.toWebElement()));
			caseRepo.saveBtnFieldActivity.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to click save button on Add Activity Window");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP.3.1.9.A.004 - 2020-10-12 - JMalayo - Start Add
	 */
	
	/*
	 * CP.3.1.9.B.002 - 2020-10-12 - JMalayo - Start Add
	 */
	
	public boolean navToAccountInformation() throws Exception{
		init();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(caseRepo.activityTypeFiled.toWebElement()));
			caseRepo.activityTypeFiled.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Click Account Information Button");
			logger.log(e);
			return false;
		}
	}
	/*
	 * CP.3.1.9.B.002 - 2020-10-12 - JMalayo - End Add
	 */
	
}
