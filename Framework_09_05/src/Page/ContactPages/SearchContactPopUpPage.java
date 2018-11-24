package Page.ContactPages;

import org.openqa.selenium.By;

import Base.BasePage;

public class SearchContactPopUpPage {

	public static String SearchContactPopUpLoadAssertLabel="//*[@id='divContact']/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]";
	public static String ContactHeader="//*[@id='divContact']/div[2]/div/div/h3[contains(text(),'Contacts')]";
	public static String SearchByFirstName="FirstName";
	public static String SearchByLastName="LastName";
	public static String SearchByEmail="Email";
	public static String SearchButton="//*[@id='search-btn']";
	public static String OkButton="//*[@id='divContactPopUp']/div/div[3]/button[contains(text(),'Ok')]";
	//Xpath for selecting first contact displayed in contact grids
	public static String SelectFirstContact="//*[@id='divContact']/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr/td[1]/div/span/input";
	public static String CancelButton="//*[@id='divContactPopUp']/div/div[3]/button[1]";
	
	
	public static void SearchContact(String FirstNameValue, String LastNameValue, String EmailValue)
	{
		BasePage.driver.findElement(By.id(SearchByFirstName)).sendKeys(FirstNameValue);
		BasePage.driver.findElement(By.id(SearchByLastName)).sendKeys(LastNameValue);
		BasePage.driver.findElement(By.id(SearchByEmail)).sendKeys(EmailValue);
		BasePage.driver.findElement(By.xpath(SearchButton)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void SelectFirstContactInGrid()
	{
		BasePage.driver.findElement(By.xpath(SelectFirstContact)).click();
		BasePage.driver.findElement(By.xpath(SearchContactPopUpPage.OkButton)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
