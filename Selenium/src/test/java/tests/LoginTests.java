package tests;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;

public class LoginTests extends StartTest {

	/*@Test(priority = 0, description = "Invalid login Scenario with username and password.")
	public void invalidLoginTest(Method method) throws InterruptedException {
		// ExtentReports Description
		startTest(method.getName(), "Invalid login Scenario with username and password.");

		homePage.goToBarceloHotel().goToLoginPage().loginBarcelo("gmasuocre@etsinf.upv.es", "acg12345")
				.verifyLogin("Guillermo");
	}*/

	@Test(priority = 0, description = "Succesfull login Scenario with username and password.")
	public void succesfullLoginTest(Method method) throws InterruptedException {
		// ExtentReports Description
		startTest(method.getName(), "Succesfull login Scenario with username and password.");

		homePage.goToBarceloHotel().goToLoginPage().loginBarcelo("gmuocre@etsinf.upv.es", "acg12345")
				.verifyLogin("Guillermo");
	}

}