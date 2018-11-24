package Page.ContactPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;
import Util.UtilityFunctions;

public class JoinMailingListPage {

	private static String directory="//*[@class='form-group']/div/select";
	private static String firstName="//*[@class='portlet box blue']/div[1]/div[1]/div[2]/div[2]/div[2]/input";
	private static String lastName="//*[@class='portlet box blue']/div[1]/div[1]/div[2]/div[3]/div[2]/input";
	private static String email="//*[@class='portlet box blue']/div[1]/div[1]/div[2]/div[4]/div[2]/input";
	private static String submitButton="//*[@class='portlet box blue']/div[2]/div/input[2]";
	private static String SuccessMessage="";
	public static String SuccessMessageLabel="";
	
	private static String joinMailingAssertText1;
	
	public static String joinMailingList(String directoryValue, String firstNameValue, String lastNameValue, String emailValue)
	{
		Select directorydropdown = new Select(BasePage.driver.findElement(By.xpath(directory)));
		directorydropdown.selectByVisibleText(directoryValue);
		BasePage.driver.findElement(By.xpath(firstName)).sendKeys(firstNameValue);
		BasePage.driver.findElement(By.xpath(lastName)).sendKeys(lastNameValue);
		BasePage.driver.findElement(By.xpath(email)).sendKeys(emailValue);
		BasePage.driver.findElement(By.xpath(submitButton)).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Add contact on search contact page wait");
			e.printStackTrace();
		}
	 UtilityFunctions.WaitUntilPresenceOfElement(SuccessMessage);
	 joinMailingAssertText1=BasePage.driver.findElement(By.xpath(SuccessMessage)).getText();
	 return(joinMailingAssertText1);
	}
}
