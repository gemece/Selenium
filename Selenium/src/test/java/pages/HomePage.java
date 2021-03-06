package pages;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.logs.Log;

public class HomePage extends Start {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Variables
	 */
	String baseURL = "https://www.barcelo.com/es-es/";
	/**
	 * Web Elements
	 */
	By titlePage = By.xpath("/html/body/header/div/div/div/div/div/div/div/div/div[3]/div[1]/div[2]/a");
	By acceptCookies = By.id("didomi-notice-agree-button");
	By loginButton = By.xpath("/html/body/header/div/div/div/div/div/div/div/div/div[3]/div[2]/div[2]/ul/li[3]/button");
	By loginButtonPopUp = By.xpath("/html/body/div[1]/div/div/div/div/div/div[1]/div/div/div/div[4]/div/div/div/div/a");
	By searchBox = By.id("destination-fb");
	By hotelBarcelona = By.xpath(
			"/html/body/main/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/form/div[2]/div[3]/div[2]/div/ul/li[1]");
	By searchButton = By.id("fastbooking_cta_booking_home");
	By startDate = By.xpath("/html/body/main/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/form/div[2]/div[4]/div[1]/div[2]/div/div/div[1]/table[1]/tbody/tr[3]/td[1]");
	By finishDate = By.xpath("/html/body/main/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/form/div[2]/div[4]/div[1]/div[2]/div/div/div[1]/table[1]/tbody/tr[3]/td[2]");
	/**
	 * Page Methods
	 */
	
	// Go to Homepage
	public HomePage goToBarceloHotel() {
		Log.info("Opening Barcelo Website.");
		driver.get(baseURL);
		click(acceptCookies);
		return this;
	}

	// Verify HomePage
	public HomePage verifyHomePage(String expectedText) {
		Log.info("Verifying HomePage Barcelo.");
		assertEquals(readAttribute(titlePage, "aria-label"), expectedText);
		return this;
	}

	// Go to LoginPage
	public LoginPage goToLoginPage() {
		Log.info("Going to Login Page..");
		click(loginButton);
		click(loginButtonPopUp);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		return new LoginPage(driver);
	}

	// Go to Search Page
	public SearchPage goToSearchPage() throws InterruptedException {
		Log.info("Going to Search Page..");
		writeText(searchBox, "Barcelona");
		click(hotelBarcelona);
		Thread.sleep(3000);
		click(searchButton);
		return new SearchPage(driver);
	}
}
