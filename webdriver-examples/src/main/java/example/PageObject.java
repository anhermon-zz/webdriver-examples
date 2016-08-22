package example;

import org.openqa.selenium.WebDriver;

public class PageObject {

	protected WebDriver driver;

	PageObject( WebDriver driver ) {
		this.driver = driver;
	}
}
