package pages;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.logs.JSErrorLogs;
import utils.logs.Log;

public class LoginPage extends Start {
	/**
	 * Constructor
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Web Elements
	 */
	By usernameField = By.xpath("/html/body/div[2]/div[1]/div[4]/div/main/div/div[2]/form/div[1]/div[2]/label/input");
	By passwordField = By.xpath("/html/body/div[2]/div[1]/div[4]/div/main/div/div[2]/form/div[1]/div[3]/label/input");
	By loginButton = By.xpath("//*[@id=\"mainContent\"]/div/div[2]/form/div[1]/div[5]/button");
	By usernameLoginField = By.xpath("/html/body/div[2]/div[1]/header/div[1]/div[2]/div[2]/div[5]/div/button");
	By errorMessageUsernameXpath = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
	By errorMessagePasswordXpath = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div ");

	/**
	 * Page Methods
	 * @throws InterruptedException 
	 */
	public LoginPage loginBarcelo(String username, String password) throws InterruptedException {
		Log.info("Trying to login the Hotel Barcelo.");
		writeText(usernameField, username);
		waitVisibility(passwordField);
		writeText(passwordField, password);
		Thread.sleep(5000);
		click(loginButton);
		return this;
	}

	// Verify Username Condition
	public LoginPage verifyLogin(String expectedText) {
		Log.info("Verifying login.");
		assertEquals(readText(usernameLoginField), expectedText);
		return this;
	}

	// Verify Password Condition
	public LoginPage verifyLoginPassword(String expectedText) {
		Log.info("Verifying login password.");
		waitVisibility(errorMessagePasswordXpath);
		assertEquals(readText(errorMessagePasswordXpath), expectedText);
		return this;
	}

	// Verify Password Condition
	public LoginPage verifyLogError() {
		Log.info("Verifying javascript login errors.");
		assertTrue(JSErrorLogs.isLoginErrorLog(driver));
		return this;
	}
}