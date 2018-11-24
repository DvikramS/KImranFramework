package Page.ContactPages;

import org.openqa.selenium.By;

import Util.CommonFunctions;
import Util.UtilityFunctions;
import Base.BasePage;

public class EditContactPage {

	private static String ContactTabs;
	public static String EditContactAssert="//*[@id='collapseOne']/div/div[1]/div[1]/div/select/option";
	
	//Labels
	private static String ContactDirectoriesTabLabel="Contact Directories";
	private static String ContactDetailsTabLabel="Contact Detail";
	private static String GuestUserTabLabel="Guest Info";
	private static String ContactGroupTabLabel="Contact Groups";
	public static String ErrorMessagePasswordMandatory="Password is required.";
	
	//Variables of Contact Directory tab
	public static String EditContactTab="//*[@id='divViewUpdateContact']/div[2]/ul/li/a[contains(text(),'Edit Contact')]";
	private static String ContactDirectoriesTab="//*[@id='divViewUpdateContact']/div[2]/ul/li/a[contains(text(),'Contact Directories')]";
	private static String SelectDirectory;
	private static String ValidateDirectory;
	private static String SaveButtonDirectoryTab="//*[@class='tab-content']/div[4]/div/div/div/form/div/div[3]/div/a[2]";
	
	//variables for Contact Details tab
	public static String ContactDetailsTab="//*[@id='divViewUpdateContact']/div[2]/ul/li/a[contains(text(),'Edit Contact')]";
	public static String AddInquiryButton="//*[@id='btnAddInquiry']";
	public static String GuestUserEmail="//*[@id='step1']/div/form/div/div[1]/div/div[2]/div[1]/p[2]/a";
	
	//Variables for Guest User tab
	private static String PasswordTextBox="//*[@id='guestinfo']/div/form/div/div[1]/div[5]/div/input";
	private static String SaveButton="//*[@class='tab-content']/div[5]/div/form/div/div[2]/div/input[@id='btnSave']";
	private static String OkButton="html/body/div[4]/div/div/div[2]/button";
	private static String MandatoryPasswordMessage="//*[@id='spanCheckPasswordError']";
	
	//Variables for Subscription Tab
	private static String SubscriptionTabLabel="Subscriptions";
	private static String SubscriptionTab="//*[@id='divViewUpdateContact']/div/ul/li/a[contains(text(),'Subscriptions')]";
	private static String UnscubscribeAllButton="//*[@id='contactsubscription']/form/div/div[3]/div/a[contains(text(),'Unsubscribe All')]";
	private static String SavebuttonOnSubscriptionTab="//*[@id='contactsubscription']/form/div/div[3]/div/a[contains(text(),'Save')]";
	private static String CheckboxFirstEmailInChannel;
	private static String CheckboxFirstPhoneInChannel;
	private static String CheckboxFirstSMSInChannel;
	private static String ContactSubscriptionSuccessMessage="html/body/div[4]/div/div/p";
	public static String ContactSubscriptionSuccessMessageLabel="Success! Contact subscription updated successfully";
	
	//Variable for Contact Groups tab
	private static String SelectGroup;
	private static String ValidateGroup;
	private static String SaveButtonGroupTab="//*[@id='contactgroup']/div/div/div/form/div/div[4]/div/a[2]";
	private static String GetAssociatedGroup;
	
	//Variables for assert and get text
	private static String GetAssociatedDirectory;
	private static String GetGuestUserEmail;
	private static String GetGuestUserErrorMessage;
	
	//Variables for ContactSubscribeToChannel function
	public static String GetContactSubscriptionSuccessMessage;
	public static boolean IsEmailSelected;
	public static boolean IsPhoneSelected;
	public static boolean IsSMSSelected;
	
	public static String AssociateMultipleDirectory(String DirectoryValue)
	{
		SelectDirectory="//*[@id='collapseD2']/div[1]/div/div/div/div[2]/div/div[1]/ul/li/span[contains(text(),'"+DirectoryValue+"')]";
		ValidateDirectory="//*[@id='collapseD2']/div[1]/div/div/div/div[2]/div/div[2]/ul/li/span[contains(text(),'"+DirectoryValue+"')]";
		NavigateToContactTabs(ContactDirectoriesTabLabel);
		CommonFunctions.DoubleClickElement(SelectDirectory); 
		try {
			 Thread.sleep(3000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		BasePage.driver.findElement(By.xpath(SaveButtonDirectoryTab)).click();
		try {
			 Thread.sleep(10000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		 UtilityFunctions.WaitUntilPresenceOfElement(AddInquiryButton);
		 NavigateToContactTabs(ContactDirectoriesTabLabel);
		 GetAssociatedDirectory=BasePage.driver.findElement(By.xpath(ValidateDirectory)).getText();
		 return(GetAssociatedDirectory);
	}
	
	public static String CreateGuestuser(String PasswordValue)
	{
		NavigateToContactTabs(GuestUserTabLabel);
		BasePage.driver.findElement(By.xpath(PasswordTextBox)).sendKeys(PasswordValue);
		BasePage.driver.findElement(By.xpath(SaveButton)).click();
		try {
			 Thread.sleep(10000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		if(BasePage.driver.findElements(By.xpath(OkButton)).size() > 0)
		{
			BasePage.driver.findElement(By.xpath(OkButton)).click();
			return("False");
		}
		else
		{
			GetGuestUserEmail=BasePage.driver.findElement(By.xpath(GuestUserEmail)).getText();
			return(GetGuestUserEmail);
		}
	}
	
	//Validate mandatory error message on guest user
	public static String ValidateGuestUserPasswordMessage()
	{
		NavigateToContactTabs(GuestUserTabLabel);
		BasePage.driver.findElement(By.xpath(SaveButton)).click();
		GetGuestUserErrorMessage=BasePage.driver.findElement(By.xpath(MandatoryPasswordMessage)).getText();
		return(GetGuestUserErrorMessage);
	}
	
	//Resuable Function for navigating to different edit contact tabs
	public static void NavigateToContactTabs(String TabName)
	{
		ContactTabs="//*[@id='divViewUpdateContact']/div[2]/ul/li/a[contains(text(),'"+TabName+"')]";
		BasePage.driver.findElement(By.xpath(ContactTabs)).click();
		try {
			 Thread.sleep(4000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
	}
	
	//Contact is able to subscribe to a channel successfully
		public static EditContactPage ContactSubscribeToChannel(String ChannelNameValue)
		{
			CheckboxFirstEmailInChannel="//*[@id='submit_form']/div/div[1]/h3/a[contains(text(),'"+ChannelNameValue+"')]/ancestor::h3/following-sibling::div[1]/div[1]/div/table/tbody/tr[1]/td[3]/input";
			CheckboxFirstPhoneInChannel="//*[@id='submit_form']/div/div[1]/h3/a[contains(text(),'"+ChannelNameValue+"')]/ancestor::h3/following-sibling::div[1]/div[2]/div/table/tbody/tr[1]/td[3]/input";
			CheckboxFirstSMSInChannel="//*[@id='submit_form']/div/div[1]/h3/a[contains(text(),'"+ChannelNameValue+"')]/ancestor::h3/following-sibling::div[1]/div[3]/div/table/tbody/tr[1]/td[3]/input";

			NavigateToContactTabs(SubscriptionTabLabel);
			BasePage.driver.findElement(By.xpath(CheckboxFirstEmailInChannel)).click();
			BasePage.driver.findElement(By.xpath(CheckboxFirstPhoneInChannel)).click();
			BasePage.driver.findElement(By.xpath(CheckboxFirstSMSInChannel)).click();
			BasePage.driver.findElement(By.xpath(SavebuttonOnSubscriptionTab)).click();
			UtilityFunctions.WaitUntilPresenceOfElement(AddInquiryButton);
			//GetContactSubscriptionSuccessMessage=BasePage.driver.findElement(By.xpath(ContactSubscriptionSuccessMessage)).getText();
			//System.out.println(GetContactSubscriptionSuccessMessage);
			try {
				 Thread.sleep(5000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
			NavigateToContactTabs(SubscriptionTabLabel);
			IsEmailSelected=BasePage.driver.findElement(By.xpath(CheckboxFirstEmailInChannel)).isSelected();
			IsPhoneSelected=BasePage.driver.findElement(By.xpath(CheckboxFirstPhoneInChannel)).isSelected();
			IsSMSSelected=BasePage.driver.findElement(By.xpath(CheckboxFirstSMSInChannel)).isSelected();
			
			return new EditContactPage();
		}
		
		//Assoicate Contact Group with a contact through
		public static String AsscoiateGroupWithContactTab(String GroupNamevalue)
		{
			SelectGroup="//*[@id='collapseA2']/div[1]/div/div/div/div[2]/div/div[1]/ul/li/span[contains(text(),'"+GroupNamevalue+"')]";
			ValidateGroup="//*[@id='collapseA2']/div[1]/div/div/div/div[2]/div/div[2]/ul/li/span[contains(text(),'"+GroupNamevalue+"')]";
			NavigateToContactTabs(ContactGroupTabLabel);
			CommonFunctions.DoubleClickElement(SelectGroup); 
			try {
				 Thread.sleep(3000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
			BasePage.driver.findElement(By.xpath(SaveButtonGroupTab)).click();
			try {
				 Thread.sleep(9000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
			 UtilityFunctions.WaitUntilPresenceOfElement(AddInquiryButton);
			 NavigateToContactTabs(ContactGroupTabLabel);
			 GetAssociatedGroup=BasePage.driver.findElement(By.xpath(ValidateGroup)).getText();
			 return(GetAssociatedGroup);
		}
}
