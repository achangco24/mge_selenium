package Person;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Commons.SetupEnvironment;
import aut.Ccb;
import aut.menu.custinfo.person.Person;
import aut.menu.custinfo.startstop.StartStop;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import features.TestConfig;

public class CreatePerson{
	private WebDriver driver;
	private WebDriverWait wait;
	private Ccb ccb;
	private ScreenShot screenshot;
	private ErrorHandle errorHandle;
	private Person person;
	private StartStop startStop;
	LogFile logger;

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
		screenshot = null;
		wait = null;
		errorHandle = null;
		person = null;
		startStop = null;
		driver = null;
		logger = null;
	}

	@Given("^User is on CC&B$")
	public void user_is_on_ccb() throws Throwable {
		ccb = new Ccb(driver, wait, TestConfig.implicitWait, errorHandle, logger, screenshot);
		boolean flag = ccb.open(TestConfig.azure27CCB);
		person = new Person(ccb);
		Assert.assertTrue(flag, "Create Person - Exception Error in Load CC&B");
	}

	@When("^User login into CC&B with (.+) and (.+)$")
	public void user_login_into_ccb_with_and(String username, String password) throws Throwable {
		boolean flag = ccb.login(username, password);
		Assert.assertTrue(flag, "Create Person - Exception Error in Load CC&B");
	}


	@And("^Navigate to Customer Page$")
	public void navigate_to_customer_page() throws Throwable {
		boolean flag = person.open();
		Assert.assertTrue(flag, "Create Person - Failed to open add Person page");    	
	}


	@And("^Enter Person Names Table with Person Name as (.+)$")
	public void enter_person_names_table_with_person_name_as(String personName) throws Throwable {
		int personRow = 0;
		boolean flag = person.enterPersonNameAtRow(personName, personRow);
		Assert.assertTrue(flag, "Create Person - Failed to input person name: " + personName);
	}

	@And("^Select Person Contacts Table with Contact Type as (.+)$")
	public void select_person_contacts_table_with_contact_type_as(String contactType) throws Throwable {
		int personRow = 0;
		boolean flag = person.selectContactTypeAtRow(contactType, personRow);
		Assert.assertTrue(flag, "Create Person - Failed to select Contact Type: " + contactType);	
	}

	@And("^Enter Person Contacts Table with Contact Number as (.+)$")
	public void enter_person_contacts_table_with_contact_number_as(String contactNumber) throws Throwable {
		int personRow = 0;
		boolean flag = person.enterContactNumberAtRow(contactNumber, personRow);
		Assert.assertTrue(flag, "Create Person - Failed to input Conteact Number: " + contactNumber);
	}		


	@And("^Set Person Contact Table with Primary Contact as \"([^\"]*)\"$")
	public void set_person_contact_table_with_primary_contact_as_something(boolean status) throws Throwable {
		int personRow = 0;
		boolean flag = person.setContactAsPrimaryAtRow(personRow, status);
		Assert.assertTrue(flag, "Create Person - Failed to set Primary Contact");	
	}

	@And("^Set Person ID Table with ID Type as (.+)$")
	public void set_person_id_table_with_id_type_as(String idType) throws Throwable {
		int personRow = 0;
		boolean flag = person.selectPersonIdTypeAtRow(idType, personRow);
		Assert.assertTrue(flag, "Create Person - Failed to Set ID Type: " + idType);
	}

	@And("^Set Person ID Table with ID number as (.+)$")
	public void set_person_id_table_with_id_number_as(String idNumber) throws Throwable {
		int personRow = 0;
		boolean flag = person.enterPersonIdNumberAtRow(idNumber, personRow);
		Assert.assertTrue(flag, "Create Person - Failed to Enter Person ID: " + idNumber);
	}

	@And("^Set Person ID Table with Primary ID as \"([^\"]*)\"$")
	public void set_person_id_table_with_primary_id_as_something(boolean status) throws Throwable {
		int personRow = 0;
		boolean flag = person.setIdentifierAsPrimaryAtRow(personRow, status);
		Assert.assertTrue(flag, "Create Person - Failed to Set Primary ID");

	}

	@Then("^Person Contact must be Saved$")
	public void save_person_contact() throws Throwable {
		boolean personflag = person.savePerson();
		Assert.assertTrue(personflag, "Create Person - Failed to Save Person");
		
		startStop = new StartStop(ccb);
		boolean accountFlag = startStop.confirmPageLoad();
		Assert.assertTrue(accountFlag, "Create Person - Failed to Load Account Page");
		startStop.clickDashBoardCustomer();

		boolean idFlag = person.checkIDExist();
		Assert.assertTrue(idFlag, "Create Person - Failed to Create Person");
	}

	@And("^Logout$")
	public void logut() throws Throwable {
		boolean flag = ccb.logout();
		Assert.assertTrue(flag, "Create Person - Failed to Logout");
		driver.close();
		driver.quit();
	}
}
