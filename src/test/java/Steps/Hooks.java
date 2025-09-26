package Steps;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public static WebDriver driver;

	@Before
	public void startAutomation(Scenario scenario) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://sampleapp.tricentis.com/101/app.php");
	}
	
	@After
	public void embedScreenshot(Scenario scenario) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver.exe");
		
		if (scenario.isFailed()) {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String[] result = scenario.getId().replace(":", "_").split("features/");
			System.out.println(result[1]);
			try {
				FileUtils.copyFile(file, new File("/src/test/resources/screenshots/"+result[1]+".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		driver.close();
		driver.quit();
	}
}
