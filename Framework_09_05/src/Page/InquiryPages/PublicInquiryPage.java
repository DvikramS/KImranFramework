package Page.InquiryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Util.UtilityFunctions;
import Base.BasePage;

public class PublicInquiryPage {

	private static String categoryDropdown="//*[@class='form-body']/div/div/select";
	private static String firstName="//*[@class='form-body']/div[3]/div/input";
	private static String lasttName="//*[@class='form-body']/div[4]/div/input";
	private static String email="//*[@class='form-body']/div[5]/div/input";
	private static String Question="//*[@class='form-body']/div[15]/div/textarea";
	private static String SubmitButton="//*[@class='form-actions fluid']/div/input[2]";
	private static String SuccessMessage="//*[@class='portlet box blue']/div/div[1]";
	public static String SuccessMessageLabel="Your Inquiry has been registered with us.";
	
	private static String publicInquiryAssert1;
	
	public static String createInquiry(String CategoryValue, String firstNameValue,String LastNameValue,String emailValue,String questionValue)
	{
		Select Categorydropdown = new Select(BasePage.driver.findElement(By.xpath(categoryDropdown)));
		Categorydropdown.selectByVisibleText(CategoryValue);
		BasePage.driver.findElement(By.xpath(firstName)).sendKeys(firstNameValue);
		BasePage.driver.findElement(By.xpath(lasttName)).sendKeys(LastNameValue);
		BasePage.driver.findElement(By.xpath(email)).sendKeys(emailValue);
		BasePage.driver.findElement(By.xpath(Question)).sendKeys(questionValue);
		BasePage.driver.findElement(By.xpath(SubmitButton)).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Add contact on search contact page wait");
			e.printStackTrace();
		}
	 UtilityFunctions.WaitUntilPresenceOfElement(SuccessMessage);
	 publicInquiryAssert1=BasePage.driver.findElement(By.xpath(SuccessMessage)).getText();
	 return(publicInquiryAssert1);
	}
}
