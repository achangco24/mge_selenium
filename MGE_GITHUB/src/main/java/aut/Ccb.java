/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * CCB
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * YYYY-MM-DD	IN		Reason text.                
 * 
 *************************************************************************************
 */
package aut;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.entity.EntityObjects;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;

public class Ccb {
	private final ElementHandler securityOverrideElement;
	private final ElementHandler usernameElement;
	private final ElementHandler passwordElement;
	private final ElementHandler loginElement;
	private final ElementHandler moreInfo;
	
	private ErrorHandle errorHandle;
	private LogFile logger;
	private WebDriver driver;
	private long defaultImplicit;
	private ScreenShot screen;
	private final EntityFrameObjects frame;
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	//protected final EntityFrameObjects frame;
	
	public EntityFrameObjects getCcbFrames() {
		return frame;
	}
	
	private final EntityObjects entityRepo;
	public EntityObjects getCcbObjects() {
		return entityRepo;
	}
	
	private final WebDriverWait wait;
	public WebDriverWait getWait() {
		return wait;
	}
	
	public Ccb(WebDriver aut, WebDriverWait wait) {
		driver = aut;
		this.wait = wait;
		
		frame = new EntityFrameObjects(driver);
		entityRepo = new EntityObjects(driver, frame, this.wait);

		//moreInfo = new ElementHandler(driver, By.id("moreInfoContainer"));
		moreInfo = new ElementHandler(driver, By.xpath("//*span[id='moreInfoContainer']"));
		
		
		securityOverrideElement = new ElementHandler(driver, By.id("overridelink"));
		usernameElement = new ElementHandler(driver, By.id("userId"));
		passwordElement=  new ElementHandler(driver, By.id("password"));
		loginElement =  new ElementHandler(driver, By.id("loginButton"));
	}
	
	public Ccb(WebDriver aut, WebDriverWait wait, long timer) {
		driver = aut;
		this.wait = wait;
		defaultImplicit = timer;
		
		frame = new EntityFrameObjects(driver);
		entityRepo = new EntityObjects(driver, frame, this.wait);
		
		moreInfo = new ElementHandler(driver, By.id("moreInfoContainer"));
		securityOverrideElement = new ElementHandler(driver, By.id("overridelink"));
		usernameElement = new ElementHandler(driver, By.id("userId"));
		passwordElement=  new ElementHandler(driver, By.id("password"));
		loginElement =  new ElementHandler(driver, By.id("loginButton"));
	}
	
	public Ccb(WebDriver aut, WebDriverWait wait, long timer, ErrorHandle errorHandle, LogFile logger,ScreenShot screen) {
		driver = aut;
		this.wait = wait;
		defaultImplicit = timer;
		this.logger = logger;
		this.errorHandle = errorHandle;
		this.screen = screen;
		frame = new EntityFrameObjects(driver);
		entityRepo = new EntityObjects(driver, frame, this.wait);
		
		//moreInfo = new ElementHandler(driver, By.id("moreInfoContainer"));
		//moreInfo = new ElementHandler(driver, By.id("infoBlockIDImage"));
		moreInfo = new ElementHandler(driver, By.id("moreInfoContainer"));
		//moreInfo = new ElementHandler(driver, By.id("details-button"));
		securityOverrideElement = new ElementHandler(driver, By.id("overridelink"));
		//securityOverrideElement = new ElementHandler(driver, By.id("proceed-link"));
		usernameElement = new ElementHandler(driver, By.id("userId"));
		passwordElement=  new ElementHandler(driver, By.id("password"));
		loginElement =  new ElementHandler(driver, By.id("loginButton"));
	}
	
	public boolean open(String url) throws Exception {
		try {
			driver.get(url);
			wait.until(ExpectedConditions.visibilityOf(moreInfo.toWebElement()));
			moreInfo.toWebElement().click();
			wait.until(ExpectedConditions.visibilityOf(securityOverrideElement.toWebElement()));
			securityOverrideElement.toWebElement().click();		
			return true;
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screen, driver, "Failed to Open CCB");
	    	return false;
	    }
	}
	
	public boolean login(String username, String password) throws Exception {
		try {
			//Enter usernameElement
			wait.until(ExpectedConditions.visibilityOf(usernameElement.toWebElement()));
			usernameElement.toWebElement().sendKeys(username);
			
			//Enter passwordElement
			wait.until(ExpectedConditions.visibilityOf(passwordElement.toWebElement()));
			passwordElement.toWebElement().sendKeys(password);
			
			//Click loginElement
			wait.until(ExpectedConditions.elementToBeClickable(loginElement.toWebElement()));
			loginElement.toWebElement().click();
			
			String checkTitle = driver.getTitle();
			if(checkTitle.equals("Login")) {
				screen.capture();
				logger.log("error", "Login Failure");
				driver.close();
				driver.quit();
				return false;
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screen, driver, "Failed to Login CCB");
	    	return false;
	
		}
	}
	
	public boolean logout() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(entityRepo.userMenuButton.toWebElement()));
			wait.until(ExpectedConditions.elementToBeClickable(entityRepo.userMenuButton.toWebElement()));
			entityRepo.userMenuButton.toWebElement().click();
			wait.until(ExpectedConditions.elementToBeClickable(entityRepo.logout.toWebElement()));
			entityRepo.logout.toWebElement().click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			logger.log(e);
			errorHandle.ExceptionHandle(screen, driver, "Failed to Logout");
		    return false;
		}
	}
	
	public long getDefaultImplicitTimer() {
		return defaultImplicit;
	}
	
	public ErrorHandle getErrorHandle() {
		return errorHandle;
	}
	
	public LogFile getLogger() {
		return logger;
	}
	
	public ScreenShot getScreen() {
		return screen;
	}
}
