package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();

		Configuration.browser = "chrome";
		Configuration.baseUrl = "http://127.0.0.1:8080/";
		Configuration.browserSize = "1920x1080";

	}
}
