package dpu_cp001_stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Commons.SetupEnvironment;
import aut.Ccb;
import aut.controlcentral.ControlCentral;
import aut.menu.custinfo.person.Person;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import features.TestConfig;

public class DPU_C2J007_001 {
	private WebDriver driver;
	private WebDriverWait wait;
	private Ccb ccb;
	private ScreenShot screenshot;
	private ErrorHandle errorHandle;
	private LogFile logger;
	private Person person;
	private ControlCentral control;
	
	@Before
	public void initialize() {
		SetupEnvironment env = new SetupEnvironment(this.getClass().getName());
		driver = env.getDriver();		
		screenshot = env.getScreenShot();
		wait = env.getWait();
		errorHandle =env.getErrorHandler();
		logger = env.getLogger();
		logger.log(this.getClass().getName() + ": Test Start");
	}

	@After
	public void cleanup() {
		logger.log(this.getClass().getName() + ": Test End");
		screenshot = null;
		driver = null;
		wait = null;
		errorHandle = null;
		logger = null;
		person = null;
	}
	
	@Given("^DPU_C2J007 User is on CC&B$")
	public void user_is_on_ccb() throws Throwable {
		ccb = new Ccb(driver, wait, TestConfig.implicitWait, errorHandle, logger, screenshot);
		boolean flag = ccb.open(TestConfig.dpu27Pkg);
		person = new Person(ccb);
		control = new ControlCentral(ccb);
		Assert.assertTrue(flag, "DPU_C2J007 - Exception Error in Load CC&B");
	}
	
	@When("^DPU_C2J007 User login into CC&B with (.+) and (.+)$")
	public void user_login_into_ccb_with_and(String username, String password) throws Throwable {
		boolean flag = ccb.login(username, password);
		Assert.assertTrue(flag, "DPU_C2J007 - Exception Error in Load CC&B");
	}
	
	@And("^DPU_C2J007 Navigate to Control Central page$")
	public void navigate_to_control_central_page() throws Throwable {
		boolean flag = control.open();
		Assert.assertTrue(flag, "DPU_C2J007 - Failed in Navigating to Control Central Page");
	}
	
	@And("^DPU_C2J007 Select Search By as (.+)$")
	public void search_by(String search) throws Throwable {
		boolean flag = control.setSearchByAs(search);
		Assert.assertTrue(flag, "DPU_C2J007 - Failed in Selecting Search By value:  " + search);
	}
	
	@And("^DPU_C2J007 Search Account ID as (.+)$")
	public void search_by_account(String account) throws Throwable {
		boolean flag = control.setAccount(account);
		Assert.assertTrue(flag, "DPU_C2J007 - Failed in Searching Account ID:  " + account);
	}
	
	@And("^DPU_C2J007 User logout CC&B$")
	public void logut() throws Throwable {
		boolean flag = ccb.logout();
		Assert.assertTrue(flag, "DPU_C2J007 - Failed to Logout");
		driver.close();
		driver.quit();
	}
}
