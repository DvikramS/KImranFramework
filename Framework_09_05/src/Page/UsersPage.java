package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Base.BasePage;
import Util.UtilityFunctions;

public class UsersPage {

	private static String MenuAdminsitraton ="//*[@id='navbar-collapse-1']/ul/li/a[contains(text(),'Administration')]";
	
	//User List Page variables
	private static String MenuUserList = "//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/ul/li/a[contains(text(),'User List')]";
	private static String UserListAssertLabel1= "//*[@id='divUser']/div[2]/div[1]/div/div/div/h1/div[contains(text(),'User Profile for Site')]";
	private static String AddButton="//*[@id='divUser']/div[2]/div[1]/div[2]/div/a/i";
	private static String UserListAssertLabel2;
	
	//Add user 1st screen variables
	private static String AddUserAssertLabel1="//*[@id='step1']/div/div[2]/div[2]/label/a[contains(text(),'Check Availability')]";
	private static String LoginName="LoginName";
	private static String Passwword="Password";
	private static String ConfirmPasswword="ConfirmPassword";
	private static String Association="OrganizationalUnit";
	private static String Title="Title";
	private static String FirstName="GivenName";
	private static String LastName="FamilyName";
	private static String Email="Email";
	private static String Country="//*[@id='step1']/div/div[7]/div[2]/div/select";
	private static String mobile="MobilePhone";
	private static String Save="//*[@id='btnSaveAndAuth']";
	
	//Add user 2nd Screen variables(Role Assignment screen)
	private static String AddUserAssertLabel2= "//*[@id='step4']/div/div/div/div/h4[contains(text(),'PIERPro')]"; 
	private static String RoleMicrositeAdminCheckbox="//*[@id='step4']/div/div/div[2]/div/div[1]/div[1]/ul/li[4]/label/span[contains(text(),'MicroSite Admin')]/preceding-sibling::div/span";
	private static String SelectWebsite="//*[@id='step4']/div/div/div[5]/div/div[1]/div[1]/select";
	private static String SelectRole="//*[@id='step4']/div/div/div[5]/div/div[1]/div[2]/div/select";
	private static String AddWebsiteRoleButton="//*[@id='step4']/div/div/div[5]/div/div[1]/div[2]/div/div/a/i";
	private static String AddUserAssertLabel3;
	private static String SaveButton="//*[@id='btnViewFeature']";
	
	
	//Summary screen variables
	private static String AddUserSummaryAssertLabel4="//*[@id='MyWizard']/ul/li[contains(text(),'Summary')]";
	private static String AddUserSummaryAssertLabel5="//*[@id='step5']/div[1]/div/div";
	private static String AddUserSummaryAssertLabel6;
	private static String AddUserSummaryAssertLabel7="//*[@id='step5']/div[2]/div/div";
	private static String AddUserSummaryAssertLabel8;
	private static String AddUserSummaryAssertLabel9="//*[@id='step5']/div[3]/div/div";
	private static String AddUserSummaryAssertLabel10;
	private static String AddUserSummaryAssertLabel11="//*[@id='step5']/div[4]/div/div";
	private static String AddUserSummaryAssertLabel12;
	private static String AddUserSummaryAssertLabel13="//*[@id='step5']/div[6]/div/div";
	private static String AddUserSummaryAssertLabel14;
	private static String FinishButton=".//*[@id='btnBack']";
	private static String AddUserSummaryAssertLabel15=".//*[@id='divUser']/div[2]/div[1]/div[1]/div/div[1]/h1/div[contains(text(),'User Profile for Site')]";
	private static String AddUserSummaryAssertLabel16;
	
	public static String NavigateToUserList()
	{
        BasePage.driver.findElement(By.xpath(MenuAdminsitraton)).click(); 
        BasePage.driver.findElement(By.xpath(MenuUserList)).click(); 
        try {
		 Thread.sleep(5000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(UserListAssertLabel1);
        UserListAssertLabel2= BasePage.driver.findElement(By.xpath(UserListAssertLabel1)).getText();
        return(UserListAssertLabel2);
	}
	
	public static String AddUser(String LoginNameValue, String PasswordValue, String ConfirmPasswordValue, String AssociationValue, String TitleValue, String FirstNameValue, String LastNameValue, String EmailValue
			,String CountryValue, String MobileValue, String RoleValue )
	{   
		String VerifyAddedRole="//*[@id='step4']/div/div/div[5]/div/div[2]/table/tbody/tr/td[contains(text(),'"+ BasePage.TestConfiguration.getProperty("Microsite") +"')]/following-sibling::td[contains(text(),'Microsite Admin')]";
		
		BasePage.driver.findElement(By.xpath(AddButton)).click();
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(AddUserAssertLabel1);
		
		BasePage.driver.findElement(By.id(LoginName)).sendKeys(LoginNameValue);
		BasePage.driver.findElement(By.id(Passwword)).sendKeys(PasswordValue);
		BasePage.driver.findElement(By.id(ConfirmPasswword)).sendKeys(ConfirmPasswordValue);
		BasePage.driver.findElement(By.id(Association)).sendKeys(AssociationValue);
		BasePage.driver.findElement(By.id(Title)).sendKeys(TitleValue);
		BasePage.driver.findElement(By.id(FirstName)).sendKeys(FirstNameValue);
		BasePage.driver.findElement(By.id(LastName)).sendKeys(LastNameValue);
		BasePage.driver.findElement(By.id(Email)).sendKeys(EmailValue);
		Select Countrydropdown = new Select(BasePage.driver.findElement(By.xpath(Country)));
		Countrydropdown.selectByVisibleText(CountryValue);
		BasePage.driver.findElement(By.id(mobile)).sendKeys(MobileValue);
		BasePage.driver.findElement(By.xpath(Save)).click();
		
		System.out.println("First Screen of user Passed");
		//2nd Screen
		UtilityFunctions.WaitUntilPresenceOfElement(AddUserAssertLabel2);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BasePage.driver.findElement(By.xpath(RoleMicrositeAdminCheckbox)).click();
		Select Websitedropdown = new Select(BasePage.driver.findElement(By.xpath(SelectWebsite)));
		Websitedropdown.selectByVisibleText(BasePage.TestConfiguration.getProperty("Microsite"));
		Select Roledropdown = new Select(BasePage.driver.findElement(By.xpath(SelectRole)));
		Roledropdown.selectByVisibleText("Microsite Admin");
		BasePage.driver.findElement(By.xpath(AddWebsiteRoleButton)).click();
		
		try {
			Thread.sleep(3000);
			AddUserAssertLabel3=BasePage.driver.findElement(By.xpath(VerifyAddedRole)).getText();
			Assert.assertEquals(AddUserAssertLabel3, RoleValue);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BasePage.driver.findElement(By.xpath(SaveButton)).click();
		System.out.println("Second Screen of user Passed");
		//Summary Screen of user
		UtilityFunctions.WaitUntilPresenceOfElement(AddUserSummaryAssertLabel4);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		AddUserSummaryAssertLabel6=BasePage.driver.findElement(By.xpath(AddUserSummaryAssertLabel5)).getText();
		Assert.assertEquals(AddUserSummaryAssertLabel6, LoginNameValue);
		
		AddUserSummaryAssertLabel8=BasePage.driver.findElement(By.xpath(AddUserSummaryAssertLabel7)).getText();
		Assert.assertEquals(AddUserSummaryAssertLabel8, FirstNameValue);
		
		AddUserSummaryAssertLabel10=BasePage.driver.findElement(By.xpath(AddUserSummaryAssertLabel9)).getText();
		Assert.assertEquals(AddUserSummaryAssertLabel10, LastNameValue);
		
		AddUserSummaryAssertLabel12=BasePage.driver.findElement(By.xpath(AddUserSummaryAssertLabel11)).getText();
		Assert.assertEquals(AddUserSummaryAssertLabel12, EmailValue);
		
		AddUserSummaryAssertLabel14=BasePage.driver.findElement(By.xpath(AddUserSummaryAssertLabel13)).getText();
		Assert.assertEquals(AddUserSummaryAssertLabel14, MobileValue);
	
		BasePage.driver.findElement(By.xpath(FinishButton)).click();
		
		System.out.println("Summary Screen of user Passed");
		try {
			Thread.sleep(5000);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		UtilityFunctions.WaitUntilPresenceOfElement(AddUserSummaryAssertLabel15);
		AddUserSummaryAssertLabel16= BasePage.driver.findElement(By.xpath(AddUserSummaryAssertLabel15)).getText();
         return(AddUserSummaryAssertLabel16);
	}
}
