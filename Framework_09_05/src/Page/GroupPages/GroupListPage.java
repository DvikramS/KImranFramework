package Page.GroupPages;

import org.openqa.selenium.By;

import Util.UtilityFunctions;
import Base.BasePage;

public class GroupListPage {

	private static String MenuGroups="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Groups')]";
	private static String GroupPageHeader="//*[@id='divGroup']/div[1]/div/div/div[1]/div[1]/div/h1";
	private static String AddBasicGroup="//*[@id='divGroup']/div[1]/div/div/div[1]/div[2]/span[1]/a/i";
	private static String AddSmartGroup="//*[@id='divGroup']/div[1]/div/div/div[1]/div[2]/span[2]/a/i";
	private static String GroupListGridLoad="//*[@id='tab2']/div[2]/table/thead/tr/th[2]/span";
	public static String GroupListDataLoad="//*[@id='tab2']/div[2]/table/tbody/tr[1]/td[2]";
	private static String GroupSearchBox="txtMicrositeGroupSearchTitle";
	private static String GroupSearchIcon="//*[@id='divGroup']/div[1]/div/div/div[1]/div[2]/div/button";
	private static String DeletionConfirmationMessage="//*[@id='pMessage']";
	private static String YesButtonOnConfirmation="//*[@id='confirmedOk']";
	private static String ViewDetailsButton;
	private static String EditBasicGroupButton;
	public static String ContactCountFromGrid;
	private static String EditedGroupName;
	private static String EditedDescription;
	private static String DeleteGroupButton;
	public static String DeletionLabel="Are you sure, you want to delete this group?";
	public static String DeletionSuccessMessage="html/body/div[7]/div/div/p/span";
	public static String SuccessfullDeletionLabel="Group deleted successfully.";
	public static String DeletionMessage="html/body/div[7]/div/div/p";
	private static String DeletedGroup;
	
	//Variables used for storing values and assert
	private static String GroupAssertText;
	private static String GroupAssertText1;
	public static String GroupAssertText2;
	public static String GetContactCountFromGrid;
	public static String GetFirstNameOfAssociatedContact;
	public static String GetLastNameOfAssociatedContact;
	public static String GetEditedGroupName;
	public static String GetEditedDescription;
	public static String SearchedGroupPath;
	
	public static String GroupAssertText3;
	public static String SearchAssertText1;
	public static String GetDeletionMessage;
	public static String GetSuccessfulDeletionMessage;
	public static String DeleteAssertText1;
//*********************************************Functions for Group List Page*****************************************************************************************************

	//Function navigates user to groups list page
   public static String NavigateToGroupListPage()
   {
	   try {
			 Thread.sleep(5000);
	  	 } catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	   BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
       BasePage.driver.findElement(By.xpath(MenuGroups)).click(); 
       try {
		 Thread.sleep(10000);
  	 } catch (InterruptedException e) {
			
			e.printStackTrace();
		}
       UtilityFunctions.WaitUntilPresenceOfElement(GroupListGridLoad);
       GroupAssertText = BasePage.driver.findElement(By.xpath(GroupPageHeader)).getText();
       return(GroupAssertText); 
   }
   
 
 //*********************************************Functions Related to basic group Page***************************************************************************************************** 
   //Function Click on add basic group button and navigates to add basic group page fetches the page header for validation
   public static String ClickOnAddBasicGroup()
   {
	   BasePage.driver.findElement(By.xpath(AddBasicGroup)).click();  
	   try {
			 Thread.sleep(8000);
	  	 } catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	       UtilityFunctions.WaitUntilPresenceOfElement(AddBasicGroupPage.AddBasicGroupPageLoad);
	       GroupAssertText1=BasePage.driver.findElement(By.xpath(AddBasicGroupPage.AddBasicGroupPageHeader)).getText();
	       return(GroupAssertText1);
   }
   
   //Function Fetches count against the specified group and navigates to view details page and fetches count and First & Last name for validation
   public static GroupListPage ClickOnViewBasicGroup(String BasicGroupNameValue)
   {
	   ViewDetailsButton="//*[@id='tab2']/div[2]/table/tbody/tr/td[2]/div[contains(text(),'"+BasicGroupNameValue+"')]/ancestor::td/following-sibling::td[3]/i[1]";
	   ContactCountFromGrid="//*[@id='tab2']/div[2]/table/tbody/tr/td[2]/div[contains(text(),'"+BasicGroupNameValue+"')]/ancestor::td/following-sibling::td[2]";
	   
	   UtilityFunctions.WaitUntilPresenceOfElement(ContactCountFromGrid);
	   GetContactCountFromGrid=BasePage.driver.findElement(By.xpath(ContactCountFromGrid)).getText();
	   BasePage.driver.findElement(By.xpath(ViewDetailsButton)).click();  
	   try {
			 Thread.sleep(5000);
	  	 } catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	       UtilityFunctions.WaitUntilPresenceOfElement(GroupDetailsPage.ContactsCountOnGroupDetails);
	       GetFirstNameOfAssociatedContact=BasePage.driver.findElement(By.xpath(GroupDetailsPage.FirstNameOfContact)).getText();
	       GetLastNameOfAssociatedContact=BasePage.driver.findElement(By.xpath(GroupDetailsPage.LastNameOfContact)).getText();
	       GroupAssertText2=BasePage.driver.findElement(By.xpath(GroupDetailsPage.ContactsCountOnGroupDetails)).getText();
	       return new GroupListPage();
   }
   
 //Function Fetches count against the specified group and navigates to view details page and fetches count and First & Last name for validation
   public static GroupListPage EditBasicgroup(String BasicGroupNameValue, String NewBasicGroupNameValue, String NewDescription)
   {
	   EditBasicGroupButton="//*[@id='tab2']/div[2]/table/tbody/tr/td[2]/div[contains(text(),'"+BasicGroupNameValue+"')]/ancestor::td/following-sibling::td[3]/i[2]";
	   ContactCountFromGrid="//*[@id='tab2']/div[2]/table/tbody/tr/td[2]/div[contains(text(),'"+BasicGroupNameValue+"')]/ancestor::td/following-sibling::td[2]";
	   
	   EditedGroupName="//*[@id='tab2']/div[2]/table/tbody/tr/td[2]/div[contains(text(),'"+NewBasicGroupNameValue+"')]";
	   EditedDescription="//*[@id='tab2']/div[2]/table/tbody/tr/td[3]/div[contains(text(),'"+NewDescription+"')]";
	   
	   UtilityFunctions.WaitUntilPresenceOfElement(ContactCountFromGrid);
	  // GetContactCountFromGrid=BasePage.driver.findElement(By.xpath(ContactCountFromGrid)).getText();
	   BasePage.driver.findElement(By.xpath(EditBasicGroupButton)).click();  
	   try {
			 Thread.sleep(5000);
	  	 } catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	       UtilityFunctions.WaitUntilPresenceOfElement(AddBasicGroupPage.AddBasicGroupPageLoad);
	       //GetFirstNameOfAssociatedContact=BasePage.driver.findElement(By.xpath(GroupDetailsPage.FirstNameOfContact)).getText();
	       //GetLastNameOfAssociatedContact=BasePage.driver.findElement(By.xpath(GroupDetailsPage.LastNameOfContact)).getText();
	      // GroupAssertText2=BasePage.driver.findElement(By.xpath(GroupDetailsPage.ContactsCountOnGroupDetails)).getText();
	       
	       AddBasicGroupPage.EditBasicGroup(NewBasicGroupNameValue,NewDescription);
	       GetEditedGroupName=BasePage.driver.findElement(By.xpath(EditedGroupName)).getText();
	       GetEditedDescription=BasePage.driver.findElement(By.xpath(EditedDescription)).getText();
	       return new GroupListPage();
   }

 //*********************************************Functions Related to smart group Page*****************************************************************************************************
   
 //Function Click on add smart group button and navigates to add smart group page fetches the page header for validation
   public static String ClickOnAddSmartGroup()
   {
	   BasePage.driver.findElement(By.xpath(AddSmartGroup)).click();  
	   try {
			 Thread.sleep(8000);
	  	 } catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	       UtilityFunctions.WaitUntilPresenceOfElement(AddSmartGroupPage.AddSmartGroupPageLoad);
	       GroupAssertText3=BasePage.driver.findElement(By.xpath(AddSmartGroupPage.AddSmartGroupPageHeader)).getText();
	       return(GroupAssertText3);
   }
   

   //Function to Search a group on list page from Search box
   public static String SearchGroup(String GroupName)
   {
	   SearchedGroupPath="//*[@id='tab2']/div[2]/table/tbody/tr/td[2]/div[contains(text(),'"+GroupName+"')]";
	   
	   BasePage.driver.findElement(By.id(GroupSearchBox)).sendKeys(GroupName);
	   BasePage.driver.findElement(By.xpath(GroupSearchIcon)).click();  
	   try {
			 Thread.sleep(8000);
	  	 } catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	       UtilityFunctions.WaitUntilPresenceOfElement(GroupListDataLoad);
	       SearchAssertText1= BasePage.driver.findElement(By.xpath(SearchedGroupPath)).getText();
	       BasePage.driver.findElement(By.id(GroupSearchBox)).clear();
	       return(SearchAssertText1);
   }
   
   //Validate group deletion
   public static GroupListPage DeleteGroup(String GroupName)
   {
	   DeleteGroupButton="//*[@id='tab2']/div[2]/table/tbody/tr/td[2]/div[contains(text(),'"+GroupName+"')]/ancestor::td/following-sibling::td[3]/i[3]";
	   DeletedGroup="//*[@id='tab2']/div[2]/table/tbody/tr/td[2]/div[contains(text(),'"+GroupName+"')]";
	   
	   BasePage.driver.findElement(By.xpath(DeleteGroupButton)).click(); 
	   GetDeletionMessage=BasePage.driver.findElement(By.xpath(DeletionConfirmationMessage)).getText();
	   
	   BasePage.driver.findElement(By.xpath(YesButtonOnConfirmation)).click();
	   UtilityFunctions.WaitUntilPresenceOfElement(DeletionSuccessMessage);
	   GetSuccessfulDeletionMessage=BasePage.driver.findElement(By.xpath(DeletionConfirmationMessage)).getText();
	   System.out.println(GetSuccessfulDeletionMessage);
	   try {
			 Thread.sleep(5000);
	  	 } catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	       UtilityFunctions.WaitUntilPresenceOfElement(GroupListDataLoad);
	      
	       try {
	    	   if(BasePage.driver.findElement(By.xpath(YesButtonOnConfirmation)).isDisplayed())
	    		   DeleteAssertText1="False";
	    	   else
	    		   DeleteAssertText1="True";
		  	 } catch (Exception e) {
					
		  		 DeleteAssertText1="True";
				}
	       
	       return new GroupListPage();
   }
  
}
