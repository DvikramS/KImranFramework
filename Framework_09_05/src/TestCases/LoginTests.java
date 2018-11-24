package TestCases;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;

import Base.BasePage;
import Page.LoginPage;
//import Util.ErrorUtility;
import Util.UtilityFunctions;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class LoginTests {

	// Page class objects
	LoginPage loginP;
	

	@BeforeMethod
	public void setMethodName(Method method) {
		// To get the current method name on the start of the test method
		BasePage.currentMethodName = method.getName();
	}

	@AfterMethod
	public void getMethodName(Method method) {
		// Reset the method name to blank when test method ends
		BasePage.currentMethodName = null;
	}
	
	@Test(priority=1,dataProvider = "getTestDataForsuccessfulloginTest")
	public void successfulloginTest(Hashtable<String, String> TestDataSet)
	{
		if (UtilityFunctions.IsExecutable("successfulloginTest",
				BasePage.xls) != true)
			throw new SkipException("Run Mode Set to No");

		System.out.println("Inside Login Test1");
		   loginP= new LoginPage(BasePage.TestConfiguration.getProperty("Browser"),
					BasePage.TestConfiguration.getProperty("TestSiteURL"));
		   
		   loginP.login(BasePage.TestConfiguration.getProperty("UserName"),
				   BasePage.TestConfiguration.getProperty("Password"));	  
		   System.out.println("Test1 Ends");
	  }	
	
	@DataProvider
	public Object[][] getTestDataForsuccessfulloginTest() {
		Object[][] Data = UtilityFunctions.getData(
				"successfulloginTest", BasePage.xls);
		return Data;
	}

	@Test(priority=2)
	public void micrositeSelection() throws InterruptedException
	{
		if (UtilityFunctions.IsExecutable("micrositeSelection",
				BasePage.xls) != true)
			throw new SkipException("Run Mode Set to No");
		System.out.println("Inside Login Test2");	
		LoginPage.selectMicrosite(BasePage.TestConfiguration.getProperty("Microsite"));
		System.out.println("Test2 Ends");			
	}	
}