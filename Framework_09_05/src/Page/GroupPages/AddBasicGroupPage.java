package Page.GroupPages;

import org.openqa.selenium.By;

import Util.UtilityFunctions;
import Base.BasePage;

public class AddBasicGroupPage {

	private static String BasicGroupName="Name";
	private static String BasicGroupDescription="Description";
	private static String SaveAndAssoicateButton="//*[@id='btnSave']";
	public static String AddBasicGroupPageLoad="//*[@id='submit_form']/div/div/div[3]/div/div[2]/div[2]/table/thead/tr/th[2]/span"; //Path corresponds to First Name in grid
	public static String AddBasicGroupPageHeader="//*[@id='divGroup']/div[1]/div/h1";
	private static String SubmitButtonOnBasicGroupPage="//*[@class='form-actions fluid']/div/input[@id='btnSave']";
	
	
	
//**********************************Add Basic Group Functions*********************************************
	
	//Enter details and Save group
	public static void AddBasicGroup(String BasicGroupNameValue, String Description)
	{
		System.out.println("Inside Add basic Details");
		BasePage.driver.findElement(By.id(BasicGroupName)).clear();
		BasePage.driver.findElement(By.id(BasicGroupName)).sendKeys(BasicGroupNameValue);
		BasePage.driver.findElement(By.id(BasicGroupDescription)).sendKeys(Description);
		BasePage.driver.findElement(By.xpath(SaveAndAssoicateButton)).click();
		try {
			 Thread.sleep(5000);
	    	 } catch (InterruptedException e) {
	  			e.printStackTrace();
	  		}
		UtilityFunctions.WaitUntilPresenceOfElement(AssociateContactToGroupPage.GridLoadAssert);
	}
	
	public static void EditBasicGroup(String BasicGroupNameValue, String Description)
	{
		BasePage.driver.findElement(By.id(BasicGroupName)).clear();
		BasePage.driver.findElement(By.id(BasicGroupName)).sendKeys(BasicGroupNameValue);
		BasePage.driver.findElement(By.id(BasicGroupDescription)).clear();
		BasePage.driver.findElement(By.id(BasicGroupDescription)).sendKeys(Description);
		BasePage.driver.findElement(By.xpath(SubmitButtonOnBasicGroupPage)).click();
		try {
			 Thread.sleep(9000);
	    	 } catch (InterruptedException e) {
	  			e.printStackTrace();
	  		}
		UtilityFunctions.WaitUntilPresenceOfElement(GroupListPage.GroupListDataLoad);
	}
}
