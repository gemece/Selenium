package pages;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.logs.Log;

public class SearchPage extends Start {

	/**
	 * Constructor
	 */
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Web Elements
	 */
	By hotelText = By.xpath("/html/body/main/div/div[4]/div[3]/div[3]/h1");
	
	// Verify Hotel
	public SearchPage verifyHotel(String expectedText) {
		Log.info("Verifying search Hotel.");
		assertEquals(readText(hotelText), expectedText);
		return this;
	}

	
}



