package Utilities;

import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Steps.Hooks;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	private WebDriver driver = Hooks.driver;
	private WebDriverWait wait = new WebDriverWait(driver, 60);
	
	public void writeText(By element, String text) {
		
		WaitUntilElementVisible(element);
		driver.findElement(element).sendKeys(text);
	}
	
	public void selectComboOption(By element, String option) {
		
		WaitUntilElementVisible(element);
		Select combo = new Select(driver.findElement(element));
		combo.selectByVisibleText(option);
	}
	
	public void clickElement(By element) {
		
		WaitUntilElementVisible(element);
		driver.findElement(element).click();
	}
		
    protected void WaitUntilElementVisible(By element) {
    	
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

	public static String getCurrentDate(boolean isCorrectData) {
		Date currentDate = isCorrectData ? DateUtils.addMonths(new Date(), 2) : new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(currentDate);
	}
}


