package Page;
import Base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Util.UtilityFunctions;

public class LoginPage extends BasePage{

	//elements with ID parameter for finding element on page
	private static String username="Username";
	private static String password="password";
	private static String loginButton="//*[@id='submit_button']";
	//private static String microsite="//*[@id='divSwitchWebiteContent']/table/tbody/tr/td/a[text()='SandBox Test']";
	private static String LoginAssertLabel1="//*[@id='divGroupGrid']/div[2]/table/thead/tr/th[1]";
	
	// Default constructor
		public LoginPage() {
			super();
		}

		// --------------------------------------------------------------------------------------------------------------------------------
		// Parameterized constructor. Will take Browser Name(IE, Mozilla, Chrome
		// etc) and the url of the applications(as set in the configuration file)
		public LoginPage(String browser, String appURL) {
			super(browser, appURL);
		}
		
		
	public static void login(String Username, String Password)
	{
		BasePage.driver.findElement(By.id(username)).sendKeys(Username);
		BasePage.driver.findElement(By.id(password)).sendKeys(Password);
		BasePage.driver.findElement(By.xpath(loginButton)).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void selectMicrosite(String Microsite) throws InterruptedException
	{
		String microsite="//*[@id='divSwitchWebiteContent']/table/tbody/tr/td/a[text()='"+ Microsite+"']";
		BasePage.driver.findElement(By.xpath(microsite)).click();
		Thread.sleep(12000);
		UtilityFunctions.WaitUntilPresenceOfElement(LoginAssertLabel1);
	}
}
