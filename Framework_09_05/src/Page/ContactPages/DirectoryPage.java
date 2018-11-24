package Page.ContactPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Util.CommonFunctions;
//import Util.ErrorUtility;
import Util.UtilityFunctions;
import Base.BasePage;

public class DirectoryPage {

	 private static String MenuDirectories = "//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Directories')]";
     
	 //Directory List page variable
	 private static String LabelOnDirectoryList = "//*[@id='divDirectoyGrid']/div/div/div/div/h1[contains(text(),'Directories')]";
     private static String DirectoryAssertLabel1; 
     private static String AddButton="//*[@id='divDirectoyGrid']/div/div[1]/div/div[2]/span/div/span/a/i";
     private static String AddedDirectory;
     static Select SelectBoxPaginationDirectoryList;
     private static String PaginationDirectoryList="//*[@id='tab2']/div[5]/div/div[1]/div/label/select";
     private static String FirstDirectoryEditIcon="//*[@id='tab2']/div[2]/table/tbody/tr[1]/td[3]/i[2]";
     private static String EditDirectoryIcon;
     private static String EditedDirectory;
     private static String CheckboxDirectoryList;
     static WebElement CheckBoxDL1;
     private static String DeleteDirectoryIcon;
     private static String DirectoryDeletionMessageOnConfirmationPopup="//*[@id='pMessage']";
     public static String DirectoryDeletionMessageLabel="Are you sure, you want to delete this contact directory?";
     private static String DeletionYesButton="//*[@id='confirmedOk']";
     private static String DirectoryListGridFirstRow="//*[@id='tab2']/div[2]/table/thead/tr/th[1]";
     
     
     //Xpath Corresponds to first directory row on Directory List page
     private static String ViewContactIconOnDirectoryList="//*[@id='tab2']/div[2]/table/tbody/tr[1]/td[3]/i[1]";
     private static String EditContactIconOnDirectoryList="//*[@id='tab2']/div[2]/table/tbody/tr[1]/td[3]/i[2]";
     private static String DeleteIconOnDirectoryList="//*[@id='tab2']/div[2]/table/tbody/tr[1]/td[3]/i[3]";
     private static String AddIconOnDirectoryList="//*[@id='divDirectoyGrid']/div/div[1]/div/div[2]/span/div/span/a";
     private static String SearchBoxOnDirectoryList="//*[@id='txtDirectorySearchTitle']";
     
     //Add-Edit Directories variables
     private static String DirectoryName="Name";
     private static String CheckboxInternalDirectory ="//*[@id='submit_form']/div/div/div/div[2]/div/div/label/div/span";
     private static String WildField1="Wild1Title";
     private static String WildField1Visibilty = "//*[@id='submit_form']/div/div/div/div[3]/table/tbody/tr[1]/td[2]/div/span/input";  //Xpath Selecting field visibilty as Display only
     private static String WildField2="Wild2Title";
     private static String WildField2Visibilty = "//*[@id='submit_form']/div/div/div/div[3]/table/tbody/tr[2]/td[3]/div/span/input";  //Xpath Selecting field visibilty as Display and Require
     private static String WildField3="Wild3Title";
     private static String WildField3Visibilty = "//*[@id='submit_form']/div/div/div/div[3]/table/tbody/tr[3]/td[4]/div/span/input";  //Xpath Selecting Field visibilty as Don't Display
     private static String WildField4="Wild4Title";
     private static String WildField4Visibilty = "//*[@id='submit_form']/div/div/div/div[3]/table/tbody/tr[4]/td[2]/div/span/input";  //Xpath Selecting field visibilty as Display only
     private static String WildField5="Wild5Title";
     private static String WildField5Visibilty = "//*[@id='submit_form']/div/div/div/div[3]/table/tbody/tr[5]/td[3]/div/span/input";  //Xpath Selecting field visibilty as Display and Require
     private static String WildField6="Wild6Title";
     private static String WildField6Visibilty = "//*[@id='submit_form']/div/div/div/div[3]/table/tbody/tr[6]/td[4]/div/span/input";  //Xpath Selecting Field visibilty as Don't Display
     private static String WildField7="Wild7Title";
     private static String WildField7Visibilty = "//*[@id='submit_form']/div/div/div/div[3]/table/tbody/tr[7]/td[2]/div/span/input";  //Xpath Selecting field visibilty as Display only
     private static String WildField8="Wild8Title";
     private static String WildField8Visibilty = "//*[@id='submit_form']/div/div/div/div[3]/table/tbody/tr[8]/td[2]/div/span/input";  //Xpath Selecting field visibilty as Display only
     private static String WildField9="Wild9Title";
     private static String WildField9Visibilty = "//*[@id='submit_form']/div/div/div/div[3]/table/tbody/tr[9]/td[2]/div/span/input";  //Xpath Selecting Field visibilty as Display only
     private static String WildField10="Wild10Title";
     private static String WildField10Visibilty ="//*[@id='submit_form']/div/div/div/div[3]/table/tbody/tr[10]/td[2]/div/span/input";  //Xpath Selecting field visibilty as Display only
     private static String SaveButton = "//*[@id='divDirectoryAddEdit']/div[2]/div/div/div/div/div/div/button[contains(text(),'Save')]";
     private static String CancelButton="//*[@id='divDirectoryAddEdit']/div[2]/div/div/div/div/div/div/button[1]";
     private static String EditDirectoryLabel="//*[@id='divDirectoryAddEdit']/div[1]/div/h1/div[contains(text(),'Edit Directory')]";
     private static String RadioButtonDesignationDisplayRequire="//*[@id='submit_form']/div/div/div/table/tbody/tr[5]/td[3]/div/span/input";
     private static String RadioButtonWieldFiled5DisplayOnly=".//*[@id='submit_form']/div/div/div/div[3]/table/tbody/tr[5]/td[2]/div/span/input";
     
     private static String DirectoryNameLabel="//*[@id='submit_form']/div/div/div/div[1]/div/label";
     private static String InternalDirectoryLabel="//*[@id='submit_form']/div/div/div/div[2]/div/div/label";
     private static String StandardFieldsLabel="//*[@id='submit_form']/div/div/div/table/thead/tr/th[1]";
     private static String StandardFieldsDisplayOnlyLabel="//*[@id='submit_form']/div/div/div/table/thead/tr/th[2]";
     private static String StandardFieldsDisplayandRequireLabel="//*[@id='submit_form']/div/div/div/table/thead/tr/th[3]";
     private static String StandardFieldsDontDisplayLabel="//*[@id='submit_form']/div/div/div/table/thead/tr/th[4]";
     private static String StandardFieldsOptionsLabel="//*[@id='submit_form']/div/div/div/table/thead/tr/th[5]";
     private static String CustomFieldsLabel="//*[@id='submit_form']/div/div/div/div[3]/table/thead/tr/th[1]";
     private static String CustomFieldsDisplayOnlyLabel="//*[@id='submit_form']/div/div/div/div[3]/table/thead/tr/th[2]";
     private static String CustomFieldsDisplayandRequireLabel="//*[@id='submit_form']/div/div/div/div[3]/table/thead/tr/th[3]";
     private static String CustomFieldsDontDisplayLabel="//*[@id='submit_form']/div/div/div/div[3]/table/thead/tr/th[4]";
     
     
     public static String DirectoryAssertLabel2;
     public static String DirectoryAssertLabel3;
     public static int selectOptionsDL;
     public static String CheckBoxStatus1;
     public static String Value1;
     
     //Variables for Verify icon Presence test
     public static Boolean ViewIconPresence;
     public static Boolean EditIconPresence;
     public static Boolean DeleteIconPresence;
     public static Boolean AddIconPresence;
     public static Boolean SearchBoxPresence;
    
     //Variables for VerifyLabelsOnEditDirectoryPage
     public static String GetDirectoryNameLabelText;
     public static String GetInternalDirectoryLabelText;
     public static String GetStandardFieldsLabelText;
     public static String GetStandardFieldsDisplayOnlyLabelText;
     public static String GetStandardFieldsDisplayandRequireLabelText;
     public static String GetStandardFieldsDontDisplayLabelText;
     public static String GetStandardFieldsOptionsLabelText;
     public static String GetCustomFieldsLabelText;
     public static String GetCustomFieldsDisplayOnlyLabelText;
     public static String GetCustomFieldsDisplayandRequireLabelText;
     public static String GetCustomFieldsDontDisplayLabelText;
     public static String GetSaveButtonText;
     public static String GetCancelButtonText;
     
     //Variable for Delete directory test
     public static String AssertTextForDeleteDirectory;
     private static String DeletedDirectory;
     public static Boolean DeletedDirectoryPresence;
     public static String DeletedDirectoryPresenceValue;
     
 //*********************************************************Function for Directory Page***********************************************************************************************************************
     
     //Navigate to Directories list Page
     public static String NavigateToDirectoryList()
     {
    	 try {
			 Thread.sleep(5000);
	  	 } catch (InterruptedException e) {
				
				e.printStackTrace();
			}
    	 
         BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
         BasePage.driver.findElement(By.xpath(MenuDirectories)).click(); 
         try {
		 Thread.sleep(5000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
         DirectoryAssertLabel1 = BasePage.driver.findElement(By.xpath(LabelOnDirectoryList)).getText();
         return(DirectoryAssertLabel1);  
       }
     
     // Add a new directory with One Wild Field
     public static String AddDirectory(String DirectorynameValue, String WildField)
     {
    	 AddedDirectory="//*[@id='tab2']/div[2]/table/tbody/tr/td/div[contains(text(),'"+DirectorynameValue+"')]";
         BasePage.driver.findElement(By.xpath(AddButton)).click();
         
         try{
        	//Wait for add directory page to load
        	 Thread.sleep(5000);
         }catch(Exception e)
             {
            	 System.out.println(e);
             }
         BasePage.driver.findElement(By.id(DirectoryName)).sendKeys(DirectorynameValue);
         BasePage.driver.findElement(By.xpath(CheckboxInternalDirectory)).click();
         BasePage.driver.findElement(By.id(WildField1)).sendKeys(WildField);
         BasePage.driver.findElement(By.xpath(WildField1Visibilty)).click();
         BasePage.driver.findElement(By.xpath(SaveButton)).click();

         //Wait for directories list page to load
         try{
         Thread.sleep(8000);
         } catch(Exception e)
         {
        	 System.out.println(e);
         }
         UtilityFunctions.WaitUntilPresenceOfElement(LabelOnDirectoryList);
         DirectoryAssertLabel2= BasePage.driver.findElement(By.xpath(AddedDirectory)).getText();
         return(DirectoryAssertLabel2);
     }
     
     //Add a new Directory with 10 Wild Fields
     public static String AddDirectory10WildFields(String DirectorynameValue, String WildField1Value, String WildField2Value, String WildField3Value, String WildField4Value, String WildField5Value,
    		 String WildField6Value, String WildField7Value, String WildField8Value, String WildField9Value, String WildField10Value)
     {
    	 AddedDirectory="//*[@id='tab2']/div[2]/table/tbody/tr/td/div[contains(text(),'"+DirectorynameValue+"')]";
         BasePage.driver.findElement(By.xpath(AddButton)).click();
         
         try{
        	//Wait for add directory page to load
        	 Thread.sleep(5000);
         }catch(Exception e)
             {
            	 System.out.println(e);
             }
         BasePage.driver.findElement(By.id(DirectoryName)).sendKeys(DirectorynameValue);
         //BasePage.driver.findElement(By.xpath(CheckboxInternalDirectory)).click();
         BasePage.driver.findElement(By.id(WildField1)).sendKeys(WildField1Value);
         BasePage.driver.findElement(By.xpath(WildField1Visibilty)).click();
         BasePage.driver.findElement(By.id(WildField2)).sendKeys(WildField2Value);
         BasePage.driver.findElement(By.xpath(WildField2Visibilty)).click();
         BasePage.driver.findElement(By.id(WildField3)).sendKeys(WildField3Value);
         BasePage.driver.findElement(By.xpath(WildField3Visibilty)).click();
         BasePage.driver.findElement(By.id(WildField4)).sendKeys(WildField4Value);
         BasePage.driver.findElement(By.xpath(WildField4Visibilty)).click();
         BasePage.driver.findElement(By.id(WildField5)).sendKeys(WildField5Value);
         BasePage.driver.findElement(By.xpath(WildField5Visibilty)).click();
         BasePage.driver.findElement(By.id(WildField6)).sendKeys(WildField6Value);
         BasePage.driver.findElement(By.xpath(WildField6Visibilty)).click();
         BasePage.driver.findElement(By.id(WildField7)).sendKeys(WildField7Value);
         BasePage.driver.findElement(By.xpath(WildField7Visibilty)).click();
         BasePage.driver.findElement(By.id(WildField8)).sendKeys(WildField8Value);
         BasePage.driver.findElement(By.xpath(WildField8Visibilty)).click();
         BasePage.driver.findElement(By.id(WildField9)).sendKeys(WildField9Value);
         BasePage.driver.findElement(By.xpath(WildField9Visibilty)).click();
         BasePage.driver.findElement(By.id(WildField10)).sendKeys(WildField10Value);
         BasePage.driver.findElement(By.xpath(WildField10Visibilty)).click();
         BasePage.driver.findElement(By.xpath(SaveButton)).click();

         //Wait for directories list page to load
         try{
         Thread.sleep(8000);
         } catch(Exception e)
         {
        	 System.out.println(e);
         }
         UtilityFunctions.WaitUntilPresenceOfElement(LabelOnDirectoryList);
         
         //Select Pagination option to display list of Directories added
         SelectBoxPaginationDirectoryList = new Select(BasePage.driver.findElement(By
 	            .xpath(PaginationDirectoryList)));
         selectOptionsDL = SelectBoxPaginationDirectoryList.getOptions().size();
 	     System.out.println(selectOptionsDL);
 	     SelectBoxPaginationDirectoryList.selectByIndex(selectOptionsDL - 1);
 		
 		 try {
 			 Thread.sleep(4000);
 	    	 } catch (InterruptedException e) {
 	  			
 	  			e.printStackTrace();
 	  		}
         DirectoryAssertLabel2= BasePage.driver.findElement(By.xpath(AddedDirectory)).getText();
         return(DirectoryAssertLabel2);
     }
     
     //Edit a Directory name, Directory Status and wild field5 name & visibilty
     public static DirectoryPage EditDirectory(String DirectoryNameValue, String NewDirectoryNameValue, String WieldField5NewValue)
     {
    	  
    	 EditDirectoryIcon="//*[@id='tab2']/div[2]/table/tbody/tr[1]/td[1]/div[contains(text(),'"+DirectoryNameValue+"')]/ancestor::td/following-sibling::td[2]/i[2]";
    	 EditedDirectory="//*[@id='tab2']/div[2]/table/tbody/tr[1]/td[1]/div[contains(text(),'"+ NewDirectoryNameValue +"')]";
    	 
    	 BasePage.driver.findElement(By.xpath(EditDirectoryIcon)).click();
    	 try {
 			 Thread.sleep(4000);
 	    	 } catch (InterruptedException e) {
 	  			
 	  			e.printStackTrace();
 	  		}
    	 UtilityFunctions.WaitUntilPresenceOfElement(EditDirectoryLabel);
    	 BasePage.driver.findElement(By.id(DirectoryName)).clear();
    	 BasePage.driver.findElement(By.id(DirectoryName)).sendKeys(NewDirectoryNameValue);
    	 BasePage.driver.findElement(By.xpath(CheckboxInternalDirectory)).click();
    	 BasePage.driver.findElement(By.xpath(RadioButtonDesignationDisplayRequire)).click();
    	 BasePage.driver.findElement(By.id(WildField5)).clear();
    	 BasePage.driver.findElement(By.id(WildField5)).sendKeys(WieldField5NewValue);
    	 BasePage.driver.findElement(By.xpath(RadioButtonWieldFiled5DisplayOnly)).click();
    	 BasePage.driver.findElement(By.xpath(SaveButton)).click();
    	 
    	//Wait for directories list page to load
         try{
         Thread.sleep(5000);
         } catch(Exception e)
         {
        	 System.out.println(e);
         }
         UtilityFunctions.WaitUntilPresenceOfElement(LabelOnDirectoryList);
         DirectoryAssertLabel3= BasePage.driver.findElement(By.xpath(EditedDirectory)).getText();
         
         return new DirectoryPage();
     }
     
     //Function verifies whether a directory is public or not 
     public static String CheckVisibiltyOfDirectory(String DirectoryNameValue)
     {
    	 CheckboxDirectoryList="//*[@id='tab2']/div[2]/table/tbody/tr/td/div[contains(text(),'"+DirectoryNameValue+"')]/ancestor::td/following-sibling::td[1]/label/div/span/input";
    	 try{
    	 CheckBoxDL1 = BasePage.driver.findElement(By.xpath(CheckboxDirectoryList));
    	 Value1= CheckBoxDL1.getAttribute("value");
		    if(Value1.equals("false")){
		    	CheckBoxStatus1="Public";
		    }
		    else if(Value1.equals("true")) 
		    	{CheckBoxStatus1="Private";}
		    else
		    	CheckBoxStatus1="Undefined";
    	 }catch(Exception e) 
    	 {
    		 System.out.println("Error generated---");
    	 }
		System.out.println(CheckBoxStatus1);    
		 return(CheckBoxStatus1);
     }
    
     //Function verifies presence of View, Edit, Delete, Add and SearchBox on directory list UI
     public static DirectoryPage VerifyPresenceOfActionIcons()
    {
    	ViewIconPresence=BasePage.driver.findElement(By.xpath(ViewContactIconOnDirectoryList)).isDisplayed();
    	EditIconPresence=BasePage.driver.findElement(By.xpath(EditContactIconOnDirectoryList)).isDisplayed();
    	DeleteIconPresence=BasePage.driver.findElement(By.xpath(DeleteIconOnDirectoryList)).isDisplayed();
    	AddIconPresence=BasePage.driver.findElement(By.xpath(AddIconOnDirectoryList)).isDisplayed();
    	SearchBoxPresence=BasePage.driver.findElement(By.xpath(SearchBoxOnDirectoryList)).isDisplayed();
    	
    	return new DirectoryPage();
    }
     
     //Function for verifying Label on Add/Edit directory Page
     public static DirectoryPage VerifyLabelsOnEditDirectoryPage()
     {
    	 BasePage.driver.findElement(By.xpath(FirstDirectoryEditIcon)).click();
    	 try {
 			 Thread.sleep(4000);
 	    	 } catch (InterruptedException e) {
 	  			
 	  			e.printStackTrace();
 	  		}
    	 UtilityFunctions.WaitUntilPresenceOfElement(CheckboxInternalDirectory);
    	 GetDirectoryNameLabelText=BasePage.driver.findElement(By.xpath(DirectoryNameLabel)).getText();
    	 GetInternalDirectoryLabelText=BasePage.driver.findElement(By.xpath(InternalDirectoryLabel)).getText();
    	 GetStandardFieldsLabelText=BasePage.driver.findElement(By.xpath(StandardFieldsLabel)).getText();
    	 GetStandardFieldsDisplayOnlyLabelText=BasePage.driver.findElement(By.xpath(StandardFieldsDisplayOnlyLabel)).getText();
    	 GetStandardFieldsDisplayandRequireLabelText=BasePage.driver.findElement(By.xpath(StandardFieldsDisplayandRequireLabel)).getText();
    	 GetStandardFieldsDontDisplayLabelText=BasePage.driver.findElement(By.xpath(StandardFieldsDontDisplayLabel)).getText();
    	 GetStandardFieldsOptionsLabelText=BasePage.driver.findElement(By.xpath(StandardFieldsOptionsLabel)).getText();
    	 GetCustomFieldsLabelText=BasePage.driver.findElement(By.xpath(CustomFieldsLabel)).getText();
    	 GetCustomFieldsDisplayOnlyLabelText=BasePage.driver.findElement(By.xpath(CustomFieldsDisplayOnlyLabel)).getText();
    	 GetCustomFieldsDisplayandRequireLabelText=BasePage.driver.findElement(By.xpath(CustomFieldsDisplayandRequireLabel)).getText();
    	 GetCustomFieldsDontDisplayLabelText=BasePage.driver.findElement(By.xpath(CustomFieldsDontDisplayLabel)).getText();
    	 GetSaveButtonText=BasePage.driver.findElement(By.xpath(SaveButton)).getText();
    	 GetCancelButtonText=BasePage.driver.findElement(By.xpath(CancelButton)).getText();
    	 
    	 return new DirectoryPage();
     }
     
     //Delete a directory based on Directory name provided in paramter
     public static DirectoryPage DeleteDirectory(String DirectoryNameValue)
     {
    	 DeleteDirectoryIcon="//*[@id='tab2']/div[2]/table/tbody/tr[1]/td[1]/div[contains(text(),'"+DirectoryNameValue+"')]/ancestor::td/following-sibling::td[2]/i[3]";
    	 DeletedDirectory="//*[@id='tab2']/div[2]/table/tbody/tr/td[1]/div[contains(text(),'"+DirectoryNameValue+"')]";
    	 
    	 CommonFunctions.SelectLastValueFromPaginationDropdown(PaginationDirectoryList);
    	 try{
             Thread.sleep(4000);
             } catch(Exception e)
             {
            	 System.out.println(e);
             }
    	 BasePage.driver.findElement(By.xpath(DeleteDirectoryIcon)).click();
    	 AssertTextForDeleteDirectory=BasePage.driver.findElement(By.xpath(DeleteDirectoryIcon)).getText();
    	 BasePage.driver.findElement(By.xpath(DeletionYesButton)).click();
    	 
    	 try{
             Thread.sleep(5000);
             } catch(Exception e)
             {
            	 System.out.println(e);
             }
    	 UtilityFunctions.WaitUntilPresenceOfElement(DirectoryListGridFirstRow);
    	 CommonFunctions.SelectLastValueFromPaginationDropdown(PaginationDirectoryList);
    	 try{
             Thread.sleep(6000);
             } catch(Exception e)
             {
            	 System.out.println(e);
             }
    	try{
    		DeletedDirectoryPresence=BasePage.driver.findElement(By.xpath(DeletedDirectory)).isDisplayed(); 
    		if(DeletedDirectoryPresence)
    		{
    			DeletedDirectoryPresenceValue="True";
    		}
    	} catch (NoSuchElementException ex) { 
    		DeletedDirectoryPresenceValue="False"; 
        }
    	 return new DirectoryPage();
     }
     
}
