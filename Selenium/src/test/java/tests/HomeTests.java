package tests;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;


public class HomeTests extends StartTest {
	
	@Test(priority = 0, description = "Validation of home page Hotel Barcelo.")
	public void validHomeTest_validHomePage(Method method) {
		// ExtentReports Description
		startTest(method.getName(), "Valid home page of Hotels Barcelo");
		
		homePage.goToBarceloHotel().verifyHomePage("Barceló Hotel Group");
	}

}
