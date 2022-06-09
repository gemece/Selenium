package tests;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;

public class SearchTests extends StartTest{
	
	@Test(priority = 0, description = "Succesfull search hotel in the page")
	public void succesSearchTest(Method method) throws InterruptedException {
		// ExtentReports Description
		startTest(method.getName(), "Succesfull search hotel in the page.");	
		
		homePage.goToBarceloHotel().goToSearchPage().verifyHotel("Occidental Barcelona 1929");
	}

}
