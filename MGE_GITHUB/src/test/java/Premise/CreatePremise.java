package Premise;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import features.TestConfig;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Commons.SetupEnvironment;
import aut.Ccb;
import aut.menu.custinfo.premise.Premise;

@RunWith(Cucumber.class)
public class CreatePremise {
	private WebDriver driver;
	private WebDriverWait wait;
	private Ccb ccb;
	private ScreenShot screenshot;
	private ErrorHandle errorHandle;
	private LogFile logger;
	private Premise premise;

	@Before
	public void initialize() {
		SetupEnvironment env = new SetupEnvironment(this.getClass().getName());
		driver = env.getDriver();		
		screenshot = env.getScreenShot();
		wait = env.getWait();
		errorHandle =env.getErrorHandle();
		logger = env.getLogger();
		logger.log(this.getClass().getName() + ": Test Start");
	}

	@After
	public void cleanup() {
		logger.log(this.getClass().getName() + ": Test End");
		driver = null;
		screenshot = null;
		wait = null;
		errorHandle = null;
		premise = null;
	}

	@Given("^User is on CC&B$")
	public void user_is_on_ccb() throws Throwable {
		ccb = new Ccb(driver, wait, TestConfig.implicitWait, errorHandle, logger, screenshot);
		boolean flag = ccb.open(TestConfig.azure27CCB);
		premise = new Premise(ccb);
		Assert.assertTrue(flag, "Create Premise - Exception Error in Load CC&B");
	}

	@When("^User login into CC&B with (.+) and (.+)$")
	public void user_login_into_application_with_something_and_something(String username, String password) throws Throwable {
		boolean flag = ccb.login(username, password);
		Assert.assertTrue(flag, "Create Premise - Error in logging in CC&B");
	}

	@And("^Logout$")
	public void logut() throws Throwable {
		boolean flag = ccb.logout();
		Assert.assertTrue(flag, "Create Premise - Failed to Logout");
		driver.close();
		driver.quit();
	}

	@Then("^Navigate to Premise Page$")
	public void navigate_to_premise_page() throws Throwable {
		boolean flag = premise.open();;
		Assert.assertTrue(flag, "Create Premise - Failed to open add Premise page");
	}

	@And("^Select PremiseType field as (.+)$")
	public void select_premisetype_field_as_something(String premiseType) throws Throwable {
		boolean flag = premise.selectPremiseTypeAs(premiseType);
		Assert.assertTrue(flag, "Create Premise - Failed to set Premise Type");
	}

	@And("^Select Premise Zip Code as (.+)$")
	public void select_zip_code_as_something(String zip) throws Throwable {
		boolean flag = premise.enterPostal(zip);
		Assert.assertTrue(flag, "Create Premise - Failed to Input ZIP code");
	}

	@And("^Select Premise CIS Code as (.+)$")
	public void select_cis_code_as_something(String cis) throws Throwable {
		boolean flag = premise.selectCIS(cis);
		Assert.assertTrue(flag, "Create Premise - Failed to set CIS code");
	}

	@And("^Set Premise Address as (.+)$")
	public void set_address_as_something(String address) throws Throwable {
		boolean flag = premise.enterAddressAtLine(1, address);
		Assert.assertTrue(flag, "Create Premise - Failed to input address");
	}

	@And("^Switch to Premise Misc Tab$")
	public void switch_to_misc_tab() throws Throwable {
		boolean flag = premise.switchToTabMisc();
		Assert.assertTrue(flag, "Create Premise - Failed to swtich to Misc Tab");
	}

	@And("^Select Premise Trend Area as (.+)$")
	public void select_trend_area_as_something(String trendArea) throws Throwable {
		boolean flag = premise.selectTrendArea(trendArea);
		Assert.assertTrue(flag, "Create Premise - Failed to set Trend Area" + trendArea);
	}

	@And("^Switch to Premise Main Tab$")
	public void switch_to_main_tab() throws Throwable {
		boolean flag = premise.switchToTabMain();
		Assert.assertTrue(flag, "Create Premise - Failed to swtich to Main Tab");
	}

	@Then("^Save Premise$")
	public void save_premise() throws Throwable {
		boolean flag = premise.savePremise();
		Assert.assertTrue(flag, "Create Premise - Failed to Save Premise");
		boolean idFlag = premise.checkIDExist();
		Assert.assertTrue(idFlag, "Create Premise - Failed to Create Premise");

	}
}