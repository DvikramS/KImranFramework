package Page.NotificationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;

import Base.BasePage;
import Page.ContactPages.SearchContactPopUpPage;
import Util.CommonFunctions;
import Util.UtilityFunctions;

public class SendNotificationPage {

	private static String MenuSendNotifications="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Send Notifications')]";
	private static String AddFilesButton="//*[@id='divFileUpload']/span/input";
	private static String SendNotificationButton="//*[@id='sendNotificaiton']";
	public static String SendNotificationHeader="//*[@id='divGroupContactNotification']/div[1]/div[1]/div/h1/div";
	private static String SendNotificationButtonOnManual=".//*[@id='divGroupContactNotification']/div/div[2]/div/div/div/form/div/div/div[7]/div/div/button";
	private static String ChannelTab="//*[@id='liChannel']/a";
	private static String ManualTab="//*[@id='liManual']/a";
	public static String ChannelSelectionPopUp="//*[@id='channelsa']/div[1]/div/div/div/span/a/i";
	private static String SelectedChannel="//*[@id='SelectedChannelList']/li/a";
	private static String TitleInput="inputTitle";
	private static String BodyText="//*[contains(@class, 'cke_wysiwyg_frame cke_reset')]";
	private static String DistributionReportButton="//*[@id='submit_form']/div/div/h3[1]/a";
	private static String NotificationSuccessMessage="html/body/div[7]/div/div/p/span";
	public static String NotificationSuccessMessageLabel="Success! Notification has been sent successfully";
	private static String GroupSelectionPopUpIcon="//*[@id='manuala']/div[1]/div[1]/div/div/span/a/i";
	private static String DirectorySelectionPopUpIcon="//*[@id='manuala']/div[1]/div[2]/div/div/span/a/i";
	private static String ContactSelectionPopUpIcon="//*[@id='manuala']/div[1]/div[3]/div/div/span/a/i";
	private static String SelectedGroup="//*[@id='SelectedGroupList']/li/a";
	private static String GeoFencingGlobeIcon="//*[@id='manuala']/div[4]/div[1]/div[2]/div/div[4]/div/div/a/i";
	private static String StartSelectDirectoryCheckboxPath="//*[@id='dataDivDirectory']/div/div/div[2]/form/div[2]/div/label/span[contains(text(),'";
	private static String EndSelectDirectoryCheckboxPath="')]/ancestor::label/div/span/input";
	private static String SelectDirectoryCheckbox;
	private static String SelectedDirectory="//*[@id='SelectedDirectoryList']/li/a";
	private static String SelectedContact="//*[@id='SelectedContactList']/li/a";
	public static String Document_SendNotificationPageLoadAssert="//*[@id='cke_editor2']";
	public static String SendNotificationButton1="//*[@id='divGroupContactNotification']/div/div[2]/div/div/div/form/div/div/div[7]/div/div/button";
	
	//Elements on Geofencing Pop-up
	private static String GeoFencingPopUpDisplayAssert=".//*[@id='selLatiLongitue']/div/div/div[2]";
	private static String SearchAddress="//*[@id='selLatiLongitue']/div/div/div[2]/div[1]/input";
	private static String SearchButtonOnGeoFencing="//*[@id='selLatiLongitue']/div/div/div[2]/div[4]/div/button";
	private static String SelectButtonOnGeoFencing="//*[@id='selLatiLongitue']/div/div/div[3]/button[2]";
	private static String CancelButtonOnGeoFencing="//*[@id='selLatiLongitue']/div/div/div[3]/button[1]";
	
	//Notification Elements under manual tab
	private static String GeoFencingCheckbox="//*[@id='manuala']/div[3]/h3/label/div/span/input";
	private static String BufferZoneLabelPath="//*[@id='manuala']/div[4]/div[2]/div[1]/label";
	public static String BufferZoneLabel="Buffer zone (miles)";
	
	//Select Channel Pop up
	private static String SelectChannelSearchBox="//*[@id='ChannelDataDiv']/div/div/div/div[2]/form/div/div/input";
	private static String SelectChannelCheckbox;
	private static String OkButtonOnChannelPopUp="//*[@id='dataDivChannel']/div/div/div[3]/button[2]";
	
	//Elements on Search Directory search POpUp
	private static String DirectorySearchBox="//*[@id='DirectoryDataDiv']/div/div/div/div[2]/form/div/div/input";
	private static String OkButton_DirectorySearchBox="//*[@id='dataDivDirectory']/div/div/div[3]/button[2]";
	private static String CancelButton_DirectorySearchBox="//*[@id='dataDivDirectory']/div/div/div[3]/button[1]";
	private static String ContactNameOnGridStartPath="//*[@id='rowBody']/td[contains(text(),'";
	private static String ContactNameOnGridEndPath="')]";
	
	//Elements on Contact Details Popup
	private static String ContactDetailsGridDataLoad="//*[@id='rowBody']/td[2]"; //Xpath for Firstname of first contact
	private static String ContactLastNameOnGrid="//*[@id='rowBody']/td[3]";
	private static String CancelButton="//*[@id='contactDetails']/div/div/div[4]/button";
	private static String FirstNameOfContact;
	private static String LastNameOfContact;
	
	//Elements in Select Group Popup
	private static String SelectGroupSearchBox="//*[@id='divGroupContactNotification']/div[2]/div/div/div/div[2]/div/div[1]/div/input";
	private static String SelectGroupCheckbox;
	private static String OkButtonOnGroupPopUp="//*[@id='divGroupContactNotification']/div[2]/div/div/div/div[3]/button[2]";
	private static String RecordSearchIcon="//*[@id='DivTreeViewModal']/div/div/div[2]/div/div[1]/div/span/i[2]";
	private static String SendNotificationAssertText;
	private static String SendNotificationAssertText1;
	private static String SendNotificationAssertText2;
	public static String SendNotificationAssertText3;
	public static String SendNotificationAssertText4;
	public static String GetSendNotificationAssertText5;
	public static String GetSendNotificationAssertText6;
	public static String SendNotificationAssertText7;
	public static String SendNotificationAssertText8;
	public static String SendNotificationAssertText9;
	public static String SendNotificationAssertText10;
	public static String SendNotificationAssertText11;
	
	public static String NavigateToSendNotificationPage()
	{
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
        BasePage.driver.findElement(By.xpath(MenuSendNotifications)).click(); 
       try {
		 Thread.sleep(9000);
  	 	} catch (InterruptedException e) {
			
			e.printStackTrace();
  	 	}
       UtilityFunctions.WaitUntilPresenceOfElement(DistributionReportButton);
       SendNotificationAssertText= BasePage.driver.findElement(By.xpath(SendNotificationHeader)).getText();
       return(SendNotificationAssertText);
	}
	
	//Function for searching and selecting a channel
	public static String SelectChannel(String ChannelNameValue)
	{
		SelectChannelCheckbox="//*[@id='ChannelDataDiv']/div/div/div/div[2]/form/div[2]/div/label/span[contains(text(),'"+ChannelNameValue+"')]/ancestor::label/div/span/input";
		BasePage.driver.findElement(By.xpath(ChannelSelectionPopUp)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		BasePage.driver.findElement(By.xpath(SelectChannelSearchBox)).sendKeys(ChannelNameValue);
		BasePage.driver.findElement(By.xpath(SelectChannelSearchBox)).sendKeys(Keys.ENTER);
		BasePage.driver.findElement(By.xpath(SelectChannelCheckbox)).click();
		BasePage.driver.findElement(By.xpath(OkButtonOnChannelPopUp)).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		SendNotificationAssertText1=BasePage.driver.findElement(By.xpath(SelectedChannel)).getText();
		return(SendNotificationAssertText1);
	}
	
	//Currently Success message
	public static String EnterDataAndSendNotification(String TitleValue, String BodyTextValue)
	{
		BasePage.driver.findElement(By.id(TitleInput)).sendKeys(TitleValue);
		CommonFunctions.EnterTextInIFrame(BodyText, BodyTextValue);
		try {
			 Thread.sleep(5000);
	  	 	} catch (InterruptedException e) {
				
				e.printStackTrace();
	  	 	}
		((JavascriptExecutor) BasePage.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//BasePage.driver.findElement(By.xpath(SendNotificationButtonOnManual)).click();
		BasePage.driver.findElement(By.xpath(SendNotificationButton)).click();
		//SendNotificationAssertText3=BasePage.driver.findElement(By.xpath(NotificationSuccessMessage)).getText();
		//System.out.println(SendNotificationAssertText3);
		try {
			 Thread.sleep(9000);
	  	 	} catch (InterruptedException e) {
				
				e.printStackTrace();
	  	 	}
	       /*while(!BasePage.driver.findElement(By.xpath(DistributionReportButton)).isEnabled())
	       {
	    	   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	       }*/
	       SendNotificationAssertText= BasePage.driver.findElement(By.xpath(SendNotificationHeader)).getText();
	       return(SendNotificationAssertText);
	}
	
	public static String VerifySentNotification()
	{
		BasePage.driver.findElement(By.xpath(DistributionReportButton)).click();
		try {
			 Thread.sleep(9000);
	  	 	} catch (InterruptedException e) {
				
				e.printStackTrace();
	  	 	}
	       UtilityFunctions.WaitUntilPresenceOfElement(DistributionReportListPage.FirstNotificationElementInDataGrid);
	       SendNotificationAssertText2=BasePage.driver.findElement(By.xpath(DistributionReportListPage.FirstNotificationElementInDataGrid)).getText();  
	       return(SendNotificationAssertText2);
	}
	
	public static SendNotificationPage VerifyContactInPopUp()
	{
		try {
		BasePage.driver.findElement(By.xpath(SelectedChannel)).click();
		
			 Thread.sleep(3000);
	  	 	
	       UtilityFunctions.WaitUntilPresenceOfElement(ContactDetailsGridDataLoad);
	       SendNotificationAssertText3=BasePage.driver.findElement(By.xpath(ContactDetailsGridDataLoad)).getText();
	       SendNotificationAssertText4=BasePage.driver.findElement(By.xpath(ContactLastNameOnGrid)).getText();
	       BasePage.driver.findElement(By.xpath(CancelButton)).click();
		} catch (InterruptedException e) {
			BasePage.driver.findElement(By.xpath(CancelButton)).click();
			e.printStackTrace();
  	 	}
	       return new SendNotificationPage();
	}
	
	public static void SwtichToManualTab()
	{
		BasePage.driver.findElement(By.xpath(ManualTab)).click();
		try {
			 Thread.sleep(2000);
	  	 	} catch (InterruptedException e) {
				
				e.printStackTrace();
	  	 	}
		
	}
	
	public static String SelectGeofencingCheckbox()
	{
		BasePage.driver.findElement(By.xpath(GeoFencingCheckbox)).click();
		try {
			 Thread.sleep(2000);
	  	 	} catch (InterruptedException e) {
				
				e.printStackTrace();
	  	 	}
		GetSendNotificationAssertText5=BasePage.driver.findElement(By.xpath(BufferZoneLabelPath)).getText();
		return(GetSendNotificationAssertText5);
	}
	
	//Function for selecting a group
	public static String SelectGroup(String GroupNameValue)
	{
		SelectGroupCheckbox="//*[@id='divGroupContactNotification']/div[2]/div/div/div/div[2]/div/div[2]/div/ul/li/a/span/span[contains(text(),'"+GroupNameValue+"')]/ancestor::span/ancestor::a/i[1]";
		BasePage.driver.findElement(By.xpath(GroupSelectionPopUpIcon)).click();
		try {
			Thread.sleep(2000);
		
		BasePage.driver.findElement(By.xpath(SelectGroupSearchBox)).sendKeys(GroupNameValue);
		BasePage.driver.findElement(By.xpath(SelectGroupSearchBox)).sendKeys(Keys.ENTER); 
		BasePage.driver.findElement(By.xpath(RecordSearchIcon)).click();
		BasePage.driver.findElement(By.xpath(SelectGroupCheckbox)).click();
		BasePage.driver.findElement(By.xpath(OkButtonOnGroupPopUp)).click();
			Thread.sleep(4000);
		
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		GetSendNotificationAssertText6=BasePage.driver.findElement(By.xpath(SelectedGroup)).getText();
		return(GetSendNotificationAssertText6);
	}
	
	public static SendNotificationPage VerifySelectedGroupContactInPopUp() 
	{
		try {
				BasePage.driver.findElement(By.xpath(SelectedGroup)).click();
				Thread.sleep(3000);
				UtilityFunctions.WaitUntilPresenceOfElement(ContactDetailsGridDataLoad);
				SendNotificationAssertText7=BasePage.driver.findElement(By.xpath(ContactDetailsGridDataLoad)).getText();
				SendNotificationAssertText8=BasePage.driver.findElement(By.xpath(ContactLastNameOnGrid)).getText();
				BasePage.driver.findElement(By.xpath(CancelButton)).click();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				BasePage.driver.findElement(By.xpath(CancelButton)).click();
				try{
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
				      }
				
				e.printStackTrace();
			}
	       return new SendNotificationPage();
	}
	
	public static void SelectLocationFromGeofencingPopUp(String AddressValue)
	{
		
				BasePage.driver.findElement(By.xpath(GeoFencingGlobeIcon)).click();
		try {
				Thread.sleep(3000);
				UtilityFunctions.WaitUntilPresenceOfElement(GeoFencingPopUpDisplayAssert);
				BasePage.driver.findElement(By.xpath(SearchAddress)).sendKeys(AddressValue);
				BasePage.driver.findElement(By.xpath(SearchButtonOnGeoFencing)).click();
				Thread.sleep(6000);
				BasePage.driver.findElement(By.xpath(SelectButtonOnGeoFencing)).click();
	         }catch(Exception E)
				{
	        	 	BasePage.driver.findElement(By.xpath(CancelButtonOnGeoFencing)).click();
	        	 	E.printStackTrace();
					}
		
	}
	
	//Function for selecting a Directory
		public static String SelectDirectory(String DirectoryNameValue)
		{
			SelectDirectoryCheckbox=StartSelectDirectoryCheckboxPath+DirectoryNameValue+EndSelectDirectoryCheckboxPath;
			BasePage.driver.findElement(By.xpath(DirectorySelectionPopUpIcon)).click();
			try {
				Thread.sleep(2000);
			BasePage.driver.findElement(By.xpath(DirectorySearchBox)).sendKeys(DirectoryNameValue);
			BasePage.driver.findElement(By.xpath(DirectorySearchBox)).sendKeys(Keys.ENTER);
			BasePage.driver.findElement(By.xpath(SelectDirectoryCheckbox)).click();
			BasePage.driver.findElement(By.xpath(OkButton_DirectorySearchBox)).click();
			
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				BasePage.driver.findElement(By.xpath(CancelButton_DirectorySearchBox)).click();
				e1.printStackTrace();
			}
			SendNotificationAssertText1=BasePage.driver.findElement(By.xpath(SelectedDirectory)).getText();
			return(SendNotificationAssertText1);
		}
	
		//Functions clicks on selected directory and Verify contact presence 
		public static SendNotificationPage VerifySelectedDirectoryContactInPopUp(String ContactFirstNameValue,String ContactLastNameValue) 
		{
			FirstNameOfContact=ContactNameOnGridStartPath+ContactFirstNameValue+ContactNameOnGridEndPath;
			LastNameOfContact=ContactNameOnGridStartPath+ContactLastNameValue+ContactNameOnGridEndPath;
			
			try {
					BasePage.driver.findElement(By.xpath(SelectedDirectory)).click();
					Thread.sleep(3000);
					UtilityFunctions.WaitUntilPresenceOfElement(ContactDetailsGridDataLoad);
					SendNotificationAssertText9=BasePage.driver.findElement(By.xpath(FirstNameOfContact)).getText();
					SendNotificationAssertText10=BasePage.driver.findElement(By.xpath(LastNameOfContact)).getText();
					BasePage.driver.findElement(By.xpath(CancelButton)).click();
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					BasePage.driver.findElement(By.xpath(CancelButton)).click();
					try{
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
					      }
					
					e.printStackTrace();
				}
		       return new SendNotificationPage();
		}
		
		//Function for selecting a Contact
				public static String SelectContact(String FirstNameValue, String LastNameValue, String EmailValue)
				{
					BasePage.driver.findElement(By.xpath(ContactSelectionPopUpIcon)).click();
					try {
						Thread.sleep(2000);
						//SearchContactPopUpPage.SearchContact(FirstNameValue, LastNameValue, EmailValue);
						BasePage.driver.findElement(By.id(SearchContactPopUpPage.SearchByFirstName)).sendKeys(FirstNameValue);
						BasePage.driver.findElement(By.id(SearchContactPopUpPage.SearchByLastName)).sendKeys(LastNameValue);
						//BasePage.driver.findElement(By.id(SearchByEmail)).sendKeys(EmailValue);
						BasePage.driver.findElement(By.xpath(SearchContactPopUpPage.SearchButton)).click();
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						SearchContactPopUpPage.SelectFirstContactInGrid();
					} catch (InterruptedException e1) {
						BasePage.driver.findElement(By.xpath(SearchContactPopUpPage.CancelButton)).click();
						e1.printStackTrace();
					}
					SendNotificationAssertText11=BasePage.driver.findElement(By.xpath(SelectedContact)).getText();
					return(SendNotificationAssertText11);
				}
}
