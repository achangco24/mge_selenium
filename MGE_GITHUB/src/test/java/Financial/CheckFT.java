package Financial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Commons.CustomConditions;
import Commons.SetupEnvironment;
import aut.Ccb;
import aut.menu.custinfo.premise.Premise;
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

public class CheckFT {
	private WebDriver driver;
	private WebDriverWait wait;
	private Ccb ccb;
	private ScreenShot screenshot;
	private ErrorHandle errorHandle;
	private LogFile logger;
	private FinancialTransaction ft;
	private Premise premise;

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
		ft = null;
		logger = null;
		premise = null;
	}

	@Given("^User is on CC&B$")
	public void user_is_on_ccb() throws Throwable {
		ccb = new Ccb(driver, wait, TestConfig.implicitWait, errorHandle, logger, screenshot);
		boolean flag = ccb.open(TestConfig.azure27CCB);
		ft = new FinancialTransaction(ccb);
		Assert.assertTrue(flag, "Check FT - Exception Error in Load CC&B");
	}

	@When("^User login into CC&B with (.+) and (.+)$")
	public void user_login_into_ccb_with_and(String username, String password) throws Throwable {
		boolean flag = ccb.login(username, password);
		Assert.assertTrue(flag, "Check FT - Exception Error in Load CC&B");
		driver.navigate().refresh();
		wait.until(CustomConditions.checkWindowReadyState());
	}

	@And("^Navigate to Financial Transaction page$")
	public void navigate_to_financial_transaction_page() throws Throwable {
		boolean flag = ft.open();
		Assert.assertTrue(flag, "Check FT - Failed in Navigating to Financial Transaction Page");
	}

	@And("^Search FT ID (.+) in pop-up window$")
	public void search_ft_id_in_popup_window(String ftid) throws Throwable {
		boolean flag = ft.searchPopUpFinancialTransactionId(ftid);
		Assert.assertTrue(flag, "Check FT - Failed in Searching ID in Pop up");
	}

	@And("^From Context Menu click Premise link$")
	public void from_context_menu_click_premise_link() throws Throwable {
		ft.tabs().dashboard.switchTo();
		boolean flag = ft.clickDashBoardPremise();
		Assert.assertTrue(flag, "Check FT - Failed in Opening to Premise Page via dashboard");
	}

	@And("^Go to Premise Characteristics tab$")
	public void go_to_premise_characteristics_tab() throws Throwable {
		premise = new Premise(ccb);
		boolean flag = premise.switchToTabChar();
		Assert.assertTrue(flag, "Check FT - Failed in Opening to Premise Page via dashboard");
	}

	@Then("^Check City Code Premise Characteristics is equal to Char Type (.+) and Char Val (.+)$")
	public void check_city_code_premise_characteristics_is_equal_to_char_type_and_char_val(String charType, String charValue) throws Throwable {
		boolean flag = premise.checkCharMatch(charType, charValue);
		Assert.assertTrue(flag, "Check FT - The City Code Premise Characteristic doesn't match the City Code [" + charType + " - " + charValue + "] in the SQL Query");
	}

	@And("^Logout$")
	public void logut() throws Throwable {
		boolean flag = ccb.logout();
		Assert.assertTrue(flag, "Check FT - Failed to Logout");
		driver.close();
		driver.quit();
	}
}
