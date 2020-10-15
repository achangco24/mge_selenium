/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Web Driver Handler
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
package ey.manila.qa.automation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHandler {
    private final String CHROME = "chrome";
    private final String IE = "ie";
    private final String GECKO = "gecko";
    private final String FIREFOX = "firefox";
	
	private String browser = "";
    private int implicitWait = 0;
    private int explicitWait = 0;
    private String webDriverPath = "";
    private Map<String, MutableCapabilities> driverOptionsMap = new HashMap<String, MutableCapabilities>();
    
    private WebDriver aut;
    
    public WebDriver getWebDriver() {
    	return aut;
    }
    
    private WebDriverWait wait;
	public WebDriverWait getWait() {
		return wait;
	}
    
    public WebDriverHandler(String browser, String webDriverPath, int implicitWait, int explicitWait) throws Exception {
        String temp = browser.toLowerCase();
        if (browser.equals(FIREFOX)) {
            temp = GECKO;
        }
        
        this.browser = temp;
        this.webDriverPath = webDriverPath;
        this.implicitWait = implicitWait;
        this.explicitWait = explicitWait;
        
        initializeWebDriver();
    }
    
    private void initializeWebDriver() throws Exception {
        System.setProperty("webdriver." + this.browser + ".driver", this.webDriverPath);
        
        addChromeDriverOptions();
        addInternetExplorerDriverOptions();
        addFirefoxDriverOptions();
        
        if (browser.equals(CHROME)) {
        	aut = new ChromeDriver((ChromeOptions)this.driverOptionsMap.get(this.browser));                                 
        } else if (browser.equals(GECKO)) {
            aut = new FirefoxDriver((FirefoxOptions)this.driverOptionsMap.get(this.browser));
        } else if (browser.equals(IE)) {
            aut = new InternetExplorerDriver((InternetExplorerOptions)this.driverOptionsMap.get(this.browser));
        } else {
            throw new Exception("Browser is not supported.");
        }
        
        setDriverProperties();
    }
    
    private void setDriverProperties() {
    	
    	aut.manage().window().maximize();
        aut.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        wait = new WebDriverWait(aut, explicitWait);
    }
    
    private void addChromeDriverOptions() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("test-type"); 
    	options.addArguments("start-maximized"); 
    	options.addArguments("--js-flags=--expose-gc"); 
    	options.addArguments("--enable-precise-memory-info"); 
    	options.addArguments("--disable-popup-blocking"); 
    	options.addArguments("--disable-default-apps"); 
    	options.addArguments("test-type=browser"); 
    	options.addArguments("disable-infobars");
    	options.setExperimentalOption("useAutomationExtension", false);
    	options.setCapability("nativeEvents", false);
    	
    	driverOptionsMap.put(CHROME, options);
    }
    
    private void addInternetExplorerDriverOptions() {
    	DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
    	caps.setCapability("nativeEvents",false);
    	caps.setCapability("ignoreZoomSetting", true);
        caps.setCapability("enablePersistentHover", true);
        caps.setCapability("ignoreProtectedModeSettings", true);
        caps.setCapability("disable-popup-blocking", true);
        caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        
        caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        //caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);     
        
   
        InternetExplorerOptions options = new InternetExplorerOptions(caps);
        driverOptionsMap.put(IE, options);
    }
    
    private void addFirefoxDriverOptions() {
    	DesiredCapabilities caps = DesiredCapabilities.firefox();
    	caps.setCapability("nativeEvents",false);
    	
    	FirefoxOptions options = new FirefoxOptions(caps);    	
    	driverOptionsMap.put(GECKO, options);
    }
}