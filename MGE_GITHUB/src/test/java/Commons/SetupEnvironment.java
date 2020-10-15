package Commons;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.automation.WebDriverHandler;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import features.TestConfig;

public class SetupEnvironment {
	private WebDriverHandler driverHandler;
	private WebDriver driver;
	private WebDriverWait wait;
	private ScreenShot screenshot;
	private ErrorHandle errorHandle;
	private ErrorHandle errorHandler;
	private String screenshotRoot = "";
	private LogFile logger;
	private long defaultImplicit = TestConfig.implicitWait;
	
	public SetupEnvironment(String screenFolderName){
		try {
			driverHandler = new WebDriverHandler(TestConfig.browser, TestConfig.webDriverPath, TestConfig.implicitWait, TestConfig.explicitWait);
			driver = driverHandler.getWebDriver();
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			screenshotRoot = "\\" + "ScreenShots";
			screenshot = new ScreenShot(driver, TestConfig.screenshotNameTemplate, TestConfig.screenshotExtension, screenshotRoot + "\\"  + screenFolderName + timeStamp);
			wait = driverHandler.getWait();
	    	LocalDate localDate = LocalDate.now();
	    	String curDate = DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate);
			logger = new LogFile("Logs" + "\\" + "logs" + curDate + "S.txt" , true);
			errorHandler = new ErrorHandle(logger);
			errorHandle = new ErrorHandle();
		} catch (Exception e) {
			Assert.assertTrue(false, e.getStackTrace().toString());
		}	
	}
		
	public WebDriverHandler getDriverHandler() {
		return driverHandler;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public ScreenShot getScreenShot() {
		return screenshot;
	}
	
	public WebDriverWait getWait() {
		return wait;
	}
	
	public ErrorHandle getErrorHandle() {
		return errorHandle;
	}
	
	public ErrorHandle getErrorHandler() {
		return errorHandler;
	}
	
	public LogFile getLogger() {
		return logger;
	}
	
}
