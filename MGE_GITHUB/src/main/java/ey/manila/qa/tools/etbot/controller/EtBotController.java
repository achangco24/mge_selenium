/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Et Bot Controller
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
package ey.manila.qa.tools.etbot.controller;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import ey.manila.qa.automation.WebDriverHandler;
import ey.manila.qa.spreadsheet.ExcelFile;
import ey.manila.qa.tools.etbot.aut.Gte;
import ey.manila.qa.tools.etbot.aut.constants.Properties;
import ey.manila.qa.tools.etbot.models.UserProfile;

public class EtBotController {
	private WebDriver aut;
	private Properties props;
	private Gte gte;
	
	public EtBotController(Properties props) throws Exception {
		this.props = props;
		
		//Initialize AUT WebDriver
		String browser = props.AUTCONFIG.getValue("webdriver.browser");
		String webDriverPath = props.AUTCONFIG.getValue("webdriver.path");
		int implicitTimeout = Integer.parseInt(props.AUTCONFIG.getValue("webdriver.timeout.implicit")) / 1000;
		int explicitTimeout = Integer.parseInt(props.AUTCONFIG.getValue("webdriver.timeout.explicit")) / 1000;
		
		aut = (new WebDriverHandler(browser, webDriverPath, implicitTimeout, explicitTimeout)).getWebDriver();
		aut.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
	}
	
	public void run() throws Exception {
		//1. Open GT&E
		openGte();
		
		//2. Navigate to Switch User page
		boolean isLoaded = loadSwitchUser();
		if (!isLoaded) {
			throw new Exception("Failed to load Switch User page");
		}
		
		//3. Get available User Profiles for the logged in user
		List<UserProfile> userProfiles = gte.tools.switchUser.getUserProfiles();
		
		//4. Retrieve sheet names of the Excel file to get the target GPN numbers
		ExcelFile effortTracker = new ExcelFile("C:\\Apps\\workspace\\eclipse\\oxygen\\EffortTrackerBot\\ConEd_CNV_Actual_Effort_Tracker_May_2018.xlsm");
		HashMap<String, Integer> sheets = effortTracker.getAllSheets();
		//4.1. Check if retrieved user profile is target for updating
		for (UserProfile profile : userProfiles) {
			if (sheets.containsKey(profile.getGpnNumber())) {
				//4.2. Perform processing for target profiles
			}
		}
	}
	
	private void openGte() throws Exception {
		gte = new Gte(aut, props.AUTCONFIG.getValue("app.url"));
	}
	
	private boolean loadSwitchUser() throws Exception {
		gte.tools.switchUser.load();
		return gte.tools.switchUser.isLoaded();
	}
}
