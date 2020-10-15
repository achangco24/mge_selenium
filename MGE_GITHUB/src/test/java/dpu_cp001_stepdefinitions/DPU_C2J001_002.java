package dpu_cp001_stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Commons.SetupEnvironment;
import aut.Ccb;
import aut.menu.custinfo.premise.Premise;
import aut.menu.custinfo.startstop.StartStop;
import aut.menu.financial.adjustment.Adjustment;
import aut.menu.financial.ft.FinancialTransaction;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import features.TestConfig;

public class DPU_C2J001_002 {
	private WebDriver driver;
	private WebDriverWait wait;
	private Ccb ccb;
	private ScreenShot screenshot;
	private ErrorHandle errorHandle;
	private LogFile logger;
	private Adjustment adjustment;

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
		adjustment = null;
	}

	@Given("^DPU_C2J001 User is on CC&B$")
	public void user_is_on_ccb() throws Throwable {
		ccb = new Ccb(driver, wait, TestConfig.implicitWait, errorHandle, logger, screenshot);
		boolean flag = ccb.open(TestConfig.dpu27Pkg);
		adjustment = new Adjustment(ccb);
		Assert.assertTrue(flag, "DPU_C2J001 - Exception Error in Load CC&B");
	}
	
	@When("^DPU_C2J001 User login into CC&B with (.+) and (.+)$")
	public void user_login_into_ccb_with_and(String username, String password) throws Throwable {
		boolean flag = ccb.login(username, password);
		Assert.assertTrue(flag, "DPU_C2J001 - Exception Error in Load CC&B");
	}

	@And("^DPU_C2J001 Navigate to Adjustment page$")
	public void navigate_to_financial_transaction_page() throws Throwable {
		boolean flag = adjustment.open();
		Assert.assertTrue(flag, "DPU_C2J001 - Failed in Navigating to Adjustment Page");
	}
	
	@And("^DPU_C2J001 Enter Service Agreement ID with SA ID as (.+)$")
	public void enter_service_agreement_id_with_said(String said) throws Throwable {
		boolean flag = adjustment.setSAID(said);
		Assert.assertTrue(flag, "DPU_C2J001 - Failed in setting SA ID to Adjustment Page");
	}
	
	@And("^DPU_C2J001 Enter Adjustment Type with Adjustment Type as (.+)$")
	public void enter_adjustment_type_with_sa_adjtype(String adjtype) throws Throwable {
		boolean flag = adjustment.setAdjustmentType(adjtype);
		Assert.assertTrue(flag, "DPU_C2J001 - Failed in setting Adjustment Type to Adjustment Page");
	}
	
	@And("^DPU_C2J001 Enter Adjustment Amount with Adjustment Amount as (.+)$")
	public void enter_adjustment_amount_with_amount(String amount) throws Throwable {
		boolean flag = adjustment.enterAmount(amount);
		Assert.assertTrue(flag, "DPU_C2J001 - Failed in setting Adjustment Amount to Adjustment Page");
	}
	
	@Then("^DPU_C2J001 Adjustment record is saved$")
	public void save_adjustment_record() throws Throwable {
		boolean flag = adjustment.saveAdjustment();
		Assert.assertTrue(flag, "DPU_C2J001 - Failed to save Adjustment");
	}
	
	@Then("^DPU_C2J001 Adjustment record is deleted$")
	public void delete_adjustment_record() throws Throwable {
		boolean flag = adjustment.deleteAdjustment();
		Assert.assertTrue(flag, "DPU_C2J001 - Failed to delete Adjustment");
	}
	
	@And("^DPU_C2J001 User logout CC&B$")
	public void logut() throws Throwable {
		boolean flag = ccb.logout();
		Assert.assertTrue(flag, "DPU_C2J001 - Failed to Logout");
		driver.close();
		driver.quit();
	}

}
