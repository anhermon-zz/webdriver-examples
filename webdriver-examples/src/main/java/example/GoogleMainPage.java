package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage extends PageObject {

	/**
	 * Selectors
	 */
	private static final By SEARCH_FIELD_SELECTOR = By.xpath("//input[@name='q']");
	
	
	
	private static final String URL = "http://www.google.com";
	
	GoogleMainPage(WebDriver driver) {
		super(driver);
		//navigate to url upon initiating instance 
		driver.get(URL);
	}
	
	public void fillSearchField( String term ) {
		WebElement searchField = getSearchField();
		searchField.clear();
		searchField.sendKeys(term);
		
		//click somewhere to close the autocomplete
		Actions builder = new Actions(driver);   
		builder.moveToElement(getSearchField(), -100, 0).click().build().perform();
	}
	
	public String extractSearchTerm() {
		//fetch the value attribute from the search field
		return getSearchField().getAttribute("value");
	}

	private WebElement getSearchField() {
		int timeout = 10;
		//wait for search field to be visible and return WebElement for it
		WebElement searchField = (new WebDriverWait(driver, timeout))
				  .until(ExpectedConditions.visibilityOfElementLocated(SEARCH_FIELD_SELECTOR));
		return searchField;
	}

}
