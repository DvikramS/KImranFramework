package Page.ContactPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import Util.UtilityFunctions;
import Base.BasePage;

public class AddContactPage {
	
	private static String MenuAddContact="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[text()='Add Contact']";
    
	//Messages on Page
	public static String DuplicateContactAlertMessage="Possible duplicate contact. Do you want to edit the existing contact?";
	
	//Add contact page variable
	public static String AddContactAssertLabel1="//*[@id='collapseOne']/div/div[1]/div[1]/div/select/option[contains(text(),'Faculty')]";	// Hardcorded because of issue others is not displayed in new mircosite
	private static String AddContactAssertLabel2;
	public static String AddContactAssertLabel3="//*[@id='divAddContact']/div/div/h1[contains(text(),'Add Contact')]";
	private static String CompanyName="CompanyName";
	private static String Salutation="ddlSalutation";
	private static String Title="Designation";
	private static String FirstName="FirstName";
	private static String LastName= "LastName";
	private static String Email = "Email";
	private static String AlternateEmail="PersonalEmail";
	private static String FacebookId="FacebookId";
	private static String TwitterId="TwitterId";
	private static String Country="//*[@id='collapseThree']/div[1]/div[1]/div[1]/div/div[1]/select";
	private static String Mobile="Mobile";
	private static String DayPhone="DayPhone";
	private static String HomeNumber="HomeNumber";
	private static String SMS1="//*[@id='collapseThree']/div[1]/div[1]/div[2]/div/select";
	private static String SMS2="//*[@id='collapseThree']/div[1]/div[2]/div[2]/div/select";
	private static String SMS3="//*[@id='collapseThree']/div[1]/div[3]/div[2]/div/select";
	private static String ToggleAddress="//*[@id='aCollapseTwo']/i";
	private static String Address="Address";
	private static String city="City";
	private static String ZipCode="ZipCode";
	private static String State="//*[@id='collapseTwo']/div/div[2]/div[1]/div/select";
	private static String Latitude_Degree="Latitude_Degree";
	private static String Latitude_Minutes="Latitude_Minutes";
	private static String Latitude_Seconds="Latitude_Seconds";
	private static String Longitude_Degree="Longitude_Degree";
	private static String Longitude_Minutes="Longitude_Minutes";
	private static String Longitude_Seconds="Longitude_Seconds";
	private static String Latitude_Direction="ddlLatitudeDirection";
	private static String Longitude_Direction="ddlLongitudeDirection";
	private static String InternalNotesToggle="//*[@id='submit_form']/div/div/div[5]/h3/a/i";
	private static String Note="Note";
	private static String SaveButton="//*[@id='btnSave']";
	private static String AddContactAssertLabel4="//*[@id='step1']/div/form/div/div[1]/div/div[2]/div[2]/i";
	private static String AddContactAssertLabel5;
	static WebElement AlternateEmailBox;
	private static String DuplicateContactMessage="//*[@id='pMessage']";
	private static String CancelButtonDuplicateContactCheck="//*[@id='confirmedCancel']";
	private static String ToggleAdditionalFields="//*[@id='submit_form']/div/div/div[4]/h3/a/i";
	private static String DirectoryInDropdown;
	
	//Additional Field Text labels
	private static String GetWildField1LabelText="//*[@id='divCustomColumnContainer']/div[1]/div[1]/label/span[1]";
	private static String GetWildField2LabelText="//*[@id='divCustomColumnContainer']/div[1]/div[2]/label/span[1]";
	private static String GetWildField3LabelText="//*[@id='divCustomColumnContainer']/div[2]/div[1]/label/span[1]";
	private static String GetWildField4LabelText="//*[@id='divCustomColumnContainer']/div[2]/div[2]/label/span[1]";
	private static String GetWildField5LabelText="//*[@id='divCustomColumnContainer']/div[3]/div[1]/label/span[1]";
	private static String GetWildField6LabelText="//*[@id='divCustomColumnContainer']/div[3]/div[2]/label/span[1]";
	private static String GetWildField7LabelText="//*[@id='divCustomColumnContainer']/div[4]/div[1]/label/span[1]";
	private static String GetWildField8LabelText="//*[@id='divCustomColumnContainer']/div[4]/div[2]/label/span[1]";
	private static String GetWildField9LabelText="//*[@id='divCustomColumnContainer']/div[5]/div[1]/label/span[1]";
	private static String GetWildField10LabelText="//*[@id='divCustomColumnContainer']/div[5]/div[2]/label/span[1]";
	private static String GetWildField2MandatorySign="//*[@id='divCustomColumnContainer']/div[1]/div[2]/label/span[2]";
	
	//Variables for duplicate message check
	private static String GetDuplicateContactMessage;
	
	private static String GetDirectoryTextPresence;
	
	//Variables for directory and WieldField relation on Add Contact Page 
	public static String GetWildFieldName;
	public static String GetWildFieldName1;
	public static String GetWildFieldName2;
	public static String GetWildFieldName3;
	public static String GetWildFieldName4;
	public static String GetWildFieldName5;
	public static String GetWildFieldName6;
	public static String GetWildFieldName7;
	public static String GetWildFieldName8;
	public static String GetWildFieldName9;
	public static String GetWildFieldName10;
	public static String GetWildFieldMandatoryLabel1;
	
	
	//Navigate to Add Contact Page
	public static String NavigateToAddContact()
	{
		 BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
         BasePage.driver.findElement(By.xpath(MenuAddContact)).click(); 
         try {
		 Thread.sleep(5000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
         
         UtilityFunctions.WaitUntilPresenceOfElement(AddContactAssertLabel1);
         AddContactAssertLabel2= BasePage.driver.findElement(By.xpath(AddContactAssertLabel3)).getText();
         return(AddContactAssertLabel2);
	}
	
	//Adding a new contact
	public static String AddContact(String SalutationValue, String TitleValue, String FirstNameValue, String LastNameValue, String EmailValue, String AlternateEmailValue, 
			String CountryValue, String MobileValue, String DayPhoneValue, String HomePhoneValue, String NoteValue,String CompanyNameValue,String FacebookIdValue, String TwitterIdValue, String SMS1Value
			,String SMS2Value, String SMS3Value, String AddressValue, String cityValue, String ZipCodeValue, String StateValue, String Latitude_DegreeValue, String Latitude_MinutesValue, String Latitude_SecondsValue
			, String Longitude_DegreeValue, String Longitude_MinutesValue, String Longitude_SecondsValue)
	{
		String ContactName="//*[@id='step1']/div/form/div/div[1]/div/div[1]/div[1]/p[contains(text(),'"+ FirstNameValue + " " + LastNameValue +"')]";
		
		Select directorydropdown = new Select(BasePage.driver.findElement(By.xpath("//*[@id='collapseOne']/div/div[1]/div[1]/div/select")));
		//directorydropdown.selectByVisibleText(DirectoryPage.DirectoryAssertLabel2);
		directorydropdown.selectByVisibleText("Faculty");
		
		Select Salutationdropdown = new Select(BasePage.driver.findElement(By.id(Salutation)));
		Salutationdropdown.selectByVisibleText(SalutationValue);
		 BasePage.driver.findElement(By.id(CompanyName)).sendKeys(CompanyNameValue); 
		 BasePage.driver.findElement(By.id(Title)).sendKeys(TitleValue);
		 BasePage.driver.findElement(By.id(FirstName)).sendKeys(FirstNameValue);
		 BasePage.driver.findElement(By.id(LastName)).sendKeys(LastNameValue);
		 BasePage.driver.findElement(By.id(Email)).sendKeys(EmailValue);
		 BasePage.driver.findElement(By.id(AlternateEmail)).sendKeys(AlternateEmailValue);
		 BasePage.driver.findElement(By.id(FacebookId)).sendKeys(FacebookIdValue);
		 BasePage.driver.findElement(By.id(TwitterId)).sendKeys(TwitterIdValue); 
		 Select Countrydropdown = new Select(BasePage.driver.findElement(By.xpath(Country)));
		 Countrydropdown.selectByVisibleText(CountryValue);
		 System.out.println(MobileValue + "DY-" + DayPhoneValue + "HP" + HomePhoneValue);
		 BasePage.driver.findElement(By.id(Mobile)).sendKeys(MobileValue);
		 BasePage.driver.findElement(By.id(DayPhone)).sendKeys(DayPhoneValue);
		 BasePage.driver.findElement(By.id(HomeNumber)).sendKeys(HomePhoneValue);
		 Select SMS1dropdown = new Select(BasePage.driver.findElement(By.xpath(SMS1)));
		 SMS1dropdown.selectByVisibleText(SMS1Value);
		 Select SMS2dropdown = new Select(BasePage.driver.findElement(By.xpath(SMS2)));
		 SMS2dropdown.selectByVisibleText(SMS2Value);
		 Select SMS3dropdown = new Select(BasePage.driver.findElement(By.xpath(SMS3)));
		 SMS3dropdown.selectByVisibleText(SMS3Value);
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Add contact on search contact page wait");
				e.printStackTrace();
			}
		 BasePage.driver.findElement(By.xpath(ToggleAddress)).click();
		 BasePage.driver.findElement(By.id(Address)).sendKeys(AddressValue); 
		 BasePage.driver.findElement(By.id(city)).sendKeys(cityValue);
		 BasePage.driver.findElement(By.id(ZipCode)).sendKeys(ZipCodeValue); 
		 Select Statedropdown = new Select(BasePage.driver.findElement(By.xpath(State)));
		 Statedropdown.selectByVisibleText(StateValue);
		// BasePage.driver.findElement(By.id(Latitude_Degree)).sendKeys(Latitude_DegreeValue); 
		// BasePage.driver.findElement(By.id(Latitude_Minutes)).sendKeys(Latitude_MinutesValue);
		// BasePage.driver.findElement(By.id(Latitude_Seconds)).sendKeys(Latitude_SecondsValue);
		// BasePage.driver.findElement(By.id(Longitude_Degree)).sendKeys(Longitude_DegreeValue);
		// BasePage.driver.findElement(By.id(Longitude_Minutes)).sendKeys(Longitude_MinutesValue);
		// BasePage.driver.findElement(By.id(Longitude_Seconds)).sendKeys(Longitude_SecondsValue);
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Add contact on search contact page wait");
				e.printStackTrace();
			}
		 BasePage.driver.findElement(By.xpath(InternalNotesToggle)).click(); 
		 BasePage.driver.findElement(By.id(Note)).sendKeys(NoteValue);
		 try {
				Thread.sleep(2000);
			 } catch (InterruptedException e) {
				System.out.println("Add new Contact exception generated in wait");
				e.printStackTrace();
			 }
		 BasePage.driver.findElement(By.xpath(SaveButton)).click();
		 
		 try {
			Thread.sleep(5000);
		 } catch (InterruptedException e) {
			System.out.println("Add new Contact exception generated in wait");
			e.printStackTrace();
		 }
		 
		 UtilityFunctions.WaitUntilPresenceOfElement(AddContactAssertLabel4);
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Add contact on search contact page wait");
			e.printStackTrace();
		}
		 
		 AddContactAssertLabel5= BasePage.driver.findElement(By.xpath(ContactName)).getText();
         return(AddContactAssertLabel5); 
		 
	}
	
	public static String DuplicateContactCheck(String SalutationValue, String TitleValue, String FirstNameValue,String LastNameValue,String EmailValue )
	{
		AlternateEmailBox=BasePage.driver.findElement(By.id(AlternateEmail));
		
		Select directorydropdown = new Select(BasePage.driver.findElement(By.xpath("//*[@id='collapseOne']/div/div[1]/div[1]/div/select")));
		//directorydropdown.selectByVisibleText(DirectoryPage.DirectoryAssertLabel2);
		directorydropdown.selectByVisibleText("Faculty");
		
		Select Salutationdropdown = new Select(BasePage.driver.findElement(By.id(Salutation)));
		Salutationdropdown.selectByVisibleText(SalutationValue);
		
		 BasePage.driver.findElement(By.id(Title)).sendKeys(TitleValue);
		 BasePage.driver.findElement(By.id(FirstName)).sendKeys(FirstNameValue);
		 BasePage.driver.findElement(By.id(LastName)).sendKeys(LastNameValue);
		 BasePage.driver.findElement(By.id(Email)).sendKeys(EmailValue);
		 AlternateEmailBox.sendKeys(Keys.TAB);
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Add contact on search contact page wait");
				e.printStackTrace();
			}
		 GetDuplicateContactMessage= BasePage.driver.findElement(By.xpath(DuplicateContactMessage)).getText();	 
		 BasePage.driver.findElement(By.xpath(CancelButtonDuplicateContactCheck)).click();
		 UtilityFunctions.WaitUntilPresenceOfElement(AddContactAssertLabel3);
		 return(GetDuplicateContactMessage);
	}
	
	//Validates the presence of directory name in Add contact Dropdown
	public static String ValidateDirectoryNameOnContactPage(String DirectoryValueName)
	{
		DirectoryInDropdown="//*[@id='collapseOne']/div/div[1]/div[1]/div/select/option[contains(text(),'"+DirectoryValueName+"')]";
		GetDirectoryTextPresence=BasePage.driver.findElement(By.xpath(DirectoryInDropdown)).getText();
		return(GetDirectoryTextPresence);
	}
	
	public static AddContactPage ValidateWieldFieldsVisibiltyBasedOnDirectory(String FirstDirectoryName, String SecondDirectoryName)
	{  
		
		//Select a directory and check its wieldField
		Select directorydropdown = new Select(BasePage.driver.findElement(By.xpath("//*[@id='collapseOne']/div/div[1]/div[1]/div/select")));
		directorydropdown.selectByVisibleText(FirstDirectoryName);
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Add contact on search contact page wait");
				e.printStackTrace();
			}
		 BasePage.driver.findElement(By.xpath(ToggleAdditionalFields)).click();
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Add contact on search contact page wait");
				e.printStackTrace();
			}
		 GetWildFieldName=BasePage.driver.findElement(By.xpath(GetWildField1LabelText)).getText();
		 
		 directorydropdown = new Select(BasePage.driver.findElement(By.xpath("//*[@id='collapseOne']/div/div[1]/div[1]/div/select")));
		 directorydropdown.selectByVisibleText(SecondDirectoryName);
		 	try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println("Add contact on search contact page wait");
					e.printStackTrace();
				} 
		 		
		 GetWildFieldName1=BasePage.driver.findElement(By.xpath(GetWildField1LabelText)).getText(); 
		 GetWildFieldName2=BasePage.driver.findElement(By.xpath(GetWildField2LabelText)).getText();
		 GetWildFieldName3=BasePage.driver.findElement(By.xpath(GetWildField3LabelText)).getText();
		 GetWildFieldName4=BasePage.driver.findElement(By.xpath(GetWildField4LabelText)).getText();
		 GetWildFieldName5=BasePage.driver.findElement(By.xpath(GetWildField5LabelText)).getText();
		 GetWildFieldName6=BasePage.driver.findElement(By.xpath(GetWildField6LabelText)).getText();
		 GetWildFieldName7=BasePage.driver.findElement(By.xpath(GetWildField7LabelText)).getText();
		 GetWildFieldName8=BasePage.driver.findElement(By.xpath(GetWildField8LabelText)).getText();
		 GetWildFieldName9=BasePage.driver.findElement(By.xpath(GetWildField9LabelText)).getText();
		 GetWildFieldName10=BasePage.driver.findElement(By.xpath(GetWildField10LabelText)).getText();
		 GetWildFieldMandatoryLabel1=BasePage.driver.findElement(By.xpath(GetWildField2MandatorySign)).getText();
		 
		 return new AddContactPage();
	}
	
			//While editing a contact Enter Address thorugh fields and save the contact
			public static void AddAddressLocation(String Latitude_DegreeValue, String Latitude_MinutesValue, String Latitude_SecondsValue, String Longitude_DegreeValue, 
					String Longitude_MinutesValue, String Longitude_SecondsValue, String Latitude_DirectionValue, String Longitude_DirectionValue)
			{
				BasePage.driver.findElement(By.xpath(ToggleAddress)).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("Add contact on search contact page wait");
					e.printStackTrace();
				} 
				BasePage.driver.findElement(By.id(Latitude_Degree)).sendKeys(Latitude_DegreeValue); 
				BasePage.driver.findElement(By.id(Latitude_Minutes)).sendKeys(Latitude_MinutesValue);
				BasePage.driver.findElement(By.id(Latitude_Seconds)).sendKeys(Latitude_SecondsValue);
				Select Latitudedropdown = new Select(BasePage.driver.findElement(By.id(Latitude_Direction)));
				Latitudedropdown.selectByVisibleText(Latitude_DirectionValue);
				BasePage.driver.findElement(By.id(Longitude_Degree)).sendKeys(Longitude_DegreeValue);
				BasePage.driver.findElement(By.id(Longitude_Minutes)).sendKeys(Longitude_MinutesValue);
				BasePage.driver.findElement(By.id(Longitude_Seconds)).sendKeys(Longitude_SecondsValue);
				Select Longtitudedropdown = new Select(BasePage.driver.findElement(By.id(Longitude_Direction)));
				Longtitudedropdown.selectByVisibleText(Longitude_DirectionValue);
				BasePage.driver.findElement(By.xpath(SaveButton)).click();
				 
				 try {
					Thread.sleep(5000);
				 } catch (InterruptedException e) {
					System.out.println("Add new Contact exception generated in wait");
					e.printStackTrace();
				 }
				 
				 UtilityFunctions.WaitUntilPresenceOfElement(AddContactAssertLabel4);
				
			}
}
