package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {

	public static void main(String[] args) {
		//init driver
		WebDriver driver = new FirefoxDriver();
		//init page object
		GoogleMainPage page = new GoogleMainPage(driver);
		
		try {
			page.fillSearchField("Dummy");
			System.out.println(String.format("Search term is:%s", page.extractSearchTerm()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//driver.quit();
	}
}
