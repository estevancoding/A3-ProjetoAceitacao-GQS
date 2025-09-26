package Steps;

import org.openqa.selenium.WebDriver;
import PageObjects.FormInsurancePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SendForm_Steps {
	
	private WebDriver driver = Hooks.driver;
	FormInsurancePage form_insurance;
	
	@Given("the user acess Vehicle Insurance Page")
	public void theUserAcessVehicleInsurancePage() {
		form_insurance = new FormInsurancePage(driver);
		form_insurance.validatePageElements();
	}

	@Given("fills in all {string} data")
	public void fillsInAllEnterVehicleDataData(String tabName) {
		form_insurance.swtichToAnotherTab(tabName);
		form_insurance.fillInAllCurrentFormTab(tabName, true);
	}

	@Given("fills in incorrect {string} data")
	public void fillsInIncorrectEnterVehicleDataData(String tabName) {
		form_insurance.swtichToAnotherTab(tabName);
		form_insurance.fillInAllCurrentFormTab(tabName, false);
	}

	@When("the user sends the form")
	public void theUserSendsTheForm() {
		form_insurance.sendForm();
	}

	@When("the user switches to {string} tab")
	public void theUserSwitchesToTab (String tabName) {
		form_insurance.swtichToAnotherTab(tabName);
	}

	@Then("the user should see a confirmation message")
	public void theUserShouldSeeAConfirmationMessage() {
		form_insurance.validateSuccessMessage();
	}

	@Then("the user should see a loading image caused by incorrect data")
	public void theUserShouldSeeALoadingImage() {
		form_insurance.validateLoadingImage();
	}
}




