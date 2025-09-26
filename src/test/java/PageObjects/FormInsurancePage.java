package PageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Utils;

public class FormInsurancePage extends Utils {

	WebDriver driver;

	public FormInsurancePage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	// Page Locators
	// ---Image Elements--------------
	By imgLogo = By.id("branding");
	// ---Button Elements--------------
	By buttonSend = By.id("sendemail");
	By buttonConfirm = By.xpath("//button[@class='confirm']");
	// ---Other Elements--------------
	By tabHeaders = By.xpath("//nav[@id='idealsteps-nav']//li/a");
	By sucessHeaderMessage = By.tagName("h2");

	// Enter Vehicle Data Tab Locators
	// ---Combo Elements--------------
	By comboMake = By.id("make");
	By comboModel = By.id("model");
	By comboSeats = By.id("numberofseats");
	By comboSeatsMoto = By.id("numberofseatsmotorcycle");
	By comboFuel = By.id("fuel");
	// ---TextField/TextArea Elements--------------
	By textCylinder = By.id("cylindercapacity");
	By textEngine = By.id("engineperformance");
	By textDateMfctr = By.id("dateofmanufacture");
	By textPayload = By.id("payload");
	By textWeight = By.id("totalweight");
	By textPrice = By.id("listprice");
	By textLicense = By.id("licenseplatenumber");
	By textMileage = By.id("annualmileage");
	// ---Radio Elements--------------
	By radioRightYes = By.xpath("(//*[@id='righthanddriveyes'])//parent::label");

	// Enter Insurant Data Tab Locators
	// ---Combo Elements--------------
	By comboCountry = By.id("country");
	By comboOccupation = By.id("occupation");
	// ---TextField/TextArea Elements--------------
	By textFirstName = By.id("firstname");
	By textLastName = By.id("lastname");
	By textDateBirth = By.id("birthdate");
	By textStreet = By.id("streetaddress");
	By textZipCode = By.id("zipcode");
	By textCity = By.id("city");
	By textWebsite = By.id("website");
	// ---Radio and CheckBoxes Elements--------------
	By radioMale = By.xpath("(//*[@id='gendermale'])//parent::label");
	By checkSpeeding = By.xpath("(//*[@id='speeding'])//parent::label");
	By checkSkydiving = By.xpath("(//*[@id='skydiving'])//parent::label");
	// ---Button Elements--------------
	By buttonUploadPic = By.id("open");

	// Enter Product Data Tab Locators
	// ---Combo Elements--------------
	By comboInsuranceSumy = By.id("insurancesum");
	By comboMeritRating = By.id("meritrating");
	By comboDamage = By.id("damageinsurance");
	By comboCourtesy = By.id("courtesycar");
	// ---TextField/TextArea Elements--------------
	By textDateStart = By.id("startdate");
	// ---Radio and CheckBoxes Elements--------------
	By checkEuroProtection = By.xpath("(//*[@id='EuroProtection'])//parent::label");

	// Select Price Option Tab Locators
	// ---Radio and CheckBoxes Elements--------------
	By radioUltimatePlan = By.xpath("(//*[@id='selectultimate'])//parent::label");
	// ---Image Elements------------------
	By imgLoadingProperInfo = By.id("xLoaderPrice");
	// ---TextField/TextArea Elements--------------
	By textCompleteFormerSteps = By.xpath("//div[@id='xLoaderPrice']/p");

	// Send Quote Tab Locators
	// ---TextField/TextArea Elements--------------
	By textEmail = By.id("email");
	By textPhone = By.id("phone");
	By textUsername = By.id("username");
	By textPassword = By.id("password");
	By textCnfrmPassword = By.id("confirmpassword");
	By textComments = By.id("Comments");

	
	// Testing Methods

	public void validatePageElements() {

		WaitUntilElementVisible(imgLogo);

	}

	@SuppressWarnings("unlikely-arg-type")
	public void swtichToAnotherTab(String tabName) {

		List<WebElement> allTabs = driver.findElements(tabHeaders);

		for (WebElement tab : allTabs) {
			if (tab.getText().equals(tabName)) {
				WebElement tabParentElement = (WebElement) ((JavascriptExecutor) driver)
						.executeScript("return arguments[0].parentNode;", tab);
				if (tabParentElement.getClass().equals("idealsteps-step-active")) {
					tabParentElement.isDisplayed();
				} else {
					try {
						tabParentElement.click();
					} catch (Exception e) {
						System.out.println("Aba não clicável");
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void fillInAllCurrentFormTab(String tabName, boolean isCorrectData) {
		switch (tabName) {
		case "Enter Vehicle Data":
			fillInAllVehicleData();
			break;
		case "Enter Insurant Data":
			fillInAllInsurantData();
			break;
		case "Enter Product Data":
			fillInAllProductData(isCorrectData);
			break;
		case "Select Price Option":
			fillInAllPriceOption();
			break;
		case "Send Quote":
			fillInAllSendQuote();
			break;
		default:

			break;
		}
	}

	private void fillInAllVehicleData() {

		selectComboOption(comboMake, "Honda");
		selectComboOption(comboModel, "Scooter");
		writeText(textCylinder, "2000");
		writeText(textEngine, "200");
		writeText(textDateMfctr, "12/12/2002");
		selectComboOption(comboSeats, "2");
		clickElement(radioRightYes);
		selectComboOption(comboSeatsMoto, "2");
		selectComboOption(comboFuel, "Gas");
		writeText(textPayload, "111");
		writeText(textWeight, "222");
		writeText(textPrice, "3333");
		writeText(textLicense, "12341234");
		writeText(textMileage, "100");
	}

	private void fillInAllInsurantData() {

		writeText(textFirstName, "Leonardo");
		writeText(textLastName, "Lotaif");
		writeText(textDateBirth, "12/02/1999");
		clickElement(radioMale);
		writeText(textStreet, "Avenida Paulista");
		selectComboOption(comboCountry, "Brazil");
		writeText(textZipCode, "05100112");
		writeText(textCity, "S�o Paulo");
		selectComboOption(comboOccupation, "Farmer");
		clickElement(checkSpeeding);
		clickElement(checkSkydiving);
		writeText(textWebsite, "www.google.com");
	}

	private void fillInAllProductData(boolean isCorrectData) {

		writeText(textDateStart, Utils.getCurrentDate(isCorrectData));
		selectComboOption(comboInsuranceSumy, "3.000.000,00");
		selectComboOption(comboMeritRating, "Malus 10");
		selectComboOption(comboDamage, "Full Coverage");
		clickElement(checkEuroProtection);
		selectComboOption(comboCourtesy, "Yes");
	}

	private void fillInAllPriceOption() {

		clickElement(radioUltimatePlan);

	}

	private void fillInAllSendQuote() {

		writeText(textEmail, "test@test.com");
		writeText(textPhone, "123456789");
		writeText(textUsername, "qwerty");
		writeText(textPassword, "Qwerty1");
		writeText(textCnfrmPassword, "Qwerty1");
		writeText(textComments, "Commentary");
	}

	public void sendForm() {

		clickElement(buttonSend);
	}

	public void validateSuccessMessage() {

		WaitUntilElementVisible(buttonConfirm);

		String success_message = driver.findElement(sucessHeaderMessage).getText();
		assertEquals(success_message, "Sending e-mail success!");
	}

	public void validateLoadingImage() {

		WaitUntilElementVisible(imgLoadingProperInfo);

		String loading_message = driver.findElement(textCompleteFormerSteps).getText();
		assertTrue(loading_message.contains("Please, complete"));
	}
}