package Page.ContactPages;

import org.openqa.selenium.By;

import Util.UtilityFunctions;
import Base.BasePage;

public class AddChannelPage {

	private static String AddChannelPageLoad="//*[@id='submit_form']/div[1]/div/div[2]/div[2]/div/div/div[1]/label[1]/div/span";  //Email enable box path
	private static String ChannelName="ChannelName";
	private static String ChannelDescription="ChannelDescription";
	private static String ChannelEnable="//*[@id='submit_form']/div[1]/div/div[1]/div[3]/div/label/div/span";
	private static String SMSEnableCheckbox="//*[@id='submit_form']/div[1]/div/div[2]/div[1]/div/div/div/label[1]/div/span";
	private static String SMSRequireCheckbox="//*[@id='submit_form']/div[1]/div/div[2]/div[1]/div/div/div/label[2]/div/span";
	private static String EmailEnableCheckbox="//*[@id='submit_form']/div[1]/div/div[2]/div[2]/div/div/div[1]/label[1]/div/span";
	private static String EmailRequireCheckbox="//*[@id='submit_form']/div[1]/div/div[2]/div[2]/div/div/div[1]/label[2]/div/span";
	private static String PhoneEnableCheckbox="//*[@id='submit_form']/div[1]/div/div[3]/div/div/div/label[1]/div/span";
	private static String PhoneRequireCheckbox="//*[@id='submit_form']/div[1]/div/div[3]/div/div/div/label[2]/div/span";
	private static String CheckboxFromEmailAddress="//*[@id='submit_form']/div[1]/div/div[2]/div[2]/div/div/div[3]/div[1]/div[1]/label/div/span";
	private static String FromEmailAddress="FromEmailAddress";
	private static String RequestReceiptOn="//*[@id=' receiptrequest']/label/div/span";
	private static String SaveButton="//*[@id='search-btn']";
	private static String CancelButton="//*[@id='submit_form']/div[3]/div/a[1]";
	
	private static String EditChannelName="//*[@id='ChannelName']";
	private static String EditChannelDescription="//*[@id='ChannelDescription']";
	
	private static String ChannelAssetText1;
	private static String ChannelAssetText2;
	private static String AddedChannel;
	private static String EditedChannel;
	
//********************************************Add/Edit Channel Functions*****************************************************************************
	
	public static String AddChannel(String ChannelNameValue, String ChannelNameDescription, String FromEmailAddressValue)
	{
		AddedChannel="//*[@id='divChannelGrid']/div[2]/table/tbody/tr/td[contains(text(),'"+ChannelNameValue+"')]";
		
		BasePage.driver.findElement(By.xpath(ChannelListPage.AddChannelIcon)).click();
		try {
			 Thread.sleep(7000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		UtilityFunctions.WaitUntilPresenceOfElement(AddChannelPageLoad);
		
		BasePage.driver.findElement(By.id(ChannelName)).sendKeys(ChannelNameValue);
		BasePage.driver.findElement(By.id(ChannelDescription)).sendKeys(ChannelNameDescription);
		BasePage.driver.findElement(By.xpath(ChannelEnable)).click();
		BasePage.driver.findElement(By.xpath(SMSEnableCheckbox)).click();
		BasePage.driver.findElement(By.xpath(SMSRequireCheckbox)).click();
		BasePage.driver.findElement(By.xpath(EmailEnableCheckbox)).click();
		BasePage.driver.findElement(By.xpath(EmailRequireCheckbox)).click();
		BasePage.driver.findElement(By.xpath(PhoneEnableCheckbox)).click();
		BasePage.driver.findElement(By.xpath(PhoneRequireCheckbox)).click();
		BasePage.driver.findElement(By.xpath(CheckboxFromEmailAddress)).click();
		BasePage.driver.findElement(By.id(FromEmailAddress)).sendKeys(FromEmailAddressValue);
		BasePage.driver.findElement(By.xpath(RequestReceiptOn)).click();
		BasePage.driver.findElement(By.xpath(SaveButton)).click();
		try {
			 Thread.sleep(8000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		 UtilityFunctions.WaitUntilPresenceOfElement(ChannelListPage.ChannelListGridDataLoad);
		 ChannelAssetText1=BasePage.driver.findElement(By.xpath(AddedChannel)).getText();
		 return(ChannelAssetText1);
	}
	
//Edit Channel 
	public static String EditChannel(String ChannelNameValue, String NewChannelNameValue, String NewChannelNameDescription)
	{
		ChannelListPage.EditChannelButton=".//*[@id='divChannelGrid']/div[2]/table/tbody/tr/td[contains(text(),'"+ChannelNameValue+"')]/following-sibling::td[6]/i[1]";
		EditedChannel="//*[@id='divChannelGrid']/div[2]/table/tbody/tr/td[contains(text(),'"+NewChannelNameValue+"')]";
		
		BasePage.driver.findElement(By.xpath(ChannelListPage.EditChannelButton)).click();
		try {
			 Thread.sleep(7000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		UtilityFunctions.WaitUntilPresenceOfElement(AddChannelPageLoad);
		
		BasePage.driver.findElement(By.id(ChannelName)).clear();
		//BasePage.driver.findElement(By.id(ChannelName)).click();
		BasePage.driver.findElement(By.xpath(EditChannelName)).sendKeys(NewChannelNameValue);
		BasePage.driver.findElement(By.id(ChannelDescription)).clear();
		//BasePage.driver.findElement(By.id(ChannelDescription)).click();
		BasePage.driver.findElement(By.xpath(EditChannelDescription)).sendKeys(NewChannelNameDescription);
		
		
		BasePage.driver.findElement(By.xpath(SMSRequireCheckbox)).click();
		BasePage.driver.findElement(By.xpath(PhoneRequireCheckbox)).click();
		BasePage.driver.findElement(By.xpath(SaveButton)).click();
		try {
			 Thread.sleep(8000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		 UtilityFunctions.WaitUntilPresenceOfElement(ChannelListPage.ChannelListGridDataLoad);
		 ChannelAssetText2=BasePage.driver.findElement(By.xpath(EditedChannel)).getText();
		 return(ChannelAssetText2);
	}
}
