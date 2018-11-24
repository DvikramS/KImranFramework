package Page.Document;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import Page.NotificationPages.SendNotificationPage;
import Util.CommonFunctions;
import Util.UtilityFunctions;
import Base.BasePage;

public class AddDocumentPage {

	public static String PageHeader="//*[@id='lblName']";
	
	private static String HeadlineTextBox="//*[@class='portlet box blue']/div/div/div[2]/table/tbody/tr/td[2]/div/input";
	private static String TextBoxAddDocument="//*[@class='dnnLeft']/div/div/table/tbody/tr[3]/td/iframe";
	private static String TogglebuttonDraftButton="//*[@class='page-content-arrow incident-wizard']/div/h3/a[contains(text(),'Draft Notes')]/i";
	private static String DraftTextArea="//*[@class='page-content-arrow incident-wizard']/div/div/div/table/tbody/tr/td/textarea";
	private static String SaveButton_AddDocument="//*[@class='CentralMessage form-actions text-right']/a[2]";
	private static String CancelButton_AddDocument="//*[@class='CentralMessage form-actions text-right']/a[1]";
	private static String PublishButtonOnAddDocument="//*[@class='sm-report-heading clearfix']/div[2]/span[5]/a";
	private static String PublishIconOnAddDocument="//*[@class='sm-report-heading clearfix']/div[2]/span[5]/a/i";
	private static String Publish_SendButtonOnAddDocument="//*[@class='sm-report-heading clearfix']/div[2]/span[6]/a";
	private static String SubmitForApprovalButtonOnAddDocument="//*[@class='sm-report-heading clearfix']/div[2]/span[7]/a";
	private static String SubmitForApprovalIconOnAddDocument="//*[@class='sm-report-heading clearfix']/div[2]/span[7]/a/i";
	private static String MoreButtonOnAddDocument="//*[@class='sm-report-heading clearfix']/div[2]/div/a";
	private static String ApproveButtonOnAddDocument="//*[@class='sm-report-heading clearfix']/div[2]/div/ul/li[1]/a";
	private static String ApproveIconOnAddDocument="//*[@class='sm-report-heading clearfix']/div[2]/div/ul/li[1]/a/i";
	private static String MoreButtonDropDownOnAddDocument="//*[@class='sm-report-heading clearfix']/div[2]/div/a/i";
	private static String ToggleButtonProperties="//*[@class='page-content-arrow incident-wizard']/div/h3/a[contains(text(),'Properties:')]/i";
	private static String SubtitleField="//*[@id='divFolderAndSubTitle']/div/div[2]/div/input";
	private static String EmailToUserIcon="//*[@class='sm-report-heading clearfix']/div[2]/div/ul/li[8]/a/i";
	private static String SendUserToEmailSuccessfulMessage="//*[@id='divEmailSuccess']";
	private static String ArchiveIconOnAddDocument="//*[@class='sm-report-heading clearfix']/div[2]/div/ul/li[5]/a/i";
	private static String SendIconOnAddDocument="//*[@class='sm-report-heading clearfix']/div[2]/span[10]/a/i";
	private static String ContentInjectionLink="//*[@class='dnnLeft']/div/div/table/tbody/tr[2]/td[3]/div/ul[6]/li[4]/a/span";
	
	//Elements on Publish draft page
	private static String PublishDraftLabelPath="//*[@id='myModalLabel']";
	private static String PublishButton="//*[@id='mdlPublished']/div/div/div[3]/button[2]";
	private static String CancelButton="//*[@id='mdlPublished']/div/div/div[3]/button[1]";
	private static String AdvanceOptionLink="//*[@id='mdlPublished']/div/div/div[2]/table/tbody/tr[3]/td/label/a/span[1]";
	private static String CalendarButton="//*[@id='divPublishedOn']/div/div[1]/span/button/i";
	private static String CalendarDateStart="//*[@id='Body']/div[4]/div[1]/table/tbody/tr[5]/td[contains(text(),'";
	private static String CalendarDateEnd="')]";
	
	public static String ArchiveAlertMessage="This will archive the document.";
	public static String UnArchiveAlertMessage="This will unarchive the document.";
	public static String UnPublishAlertMessage="This will unpublish the following document, removing it from the external site. ";
	
	//Elements on Submit For approval Pop-up
	private static String SumbitForApprovalHeader=".//*[@id='mdlSubmitForApprovalAtt']/div[1]/div/div[1]/h4";
	private static String SumbitButton="//*[@id='mdlSubmitForApprovalAtt']/div[2]/button[2]";
	private static String CancelButtonOnSubmit_Approval="//*[@id='mdlSubmitForApprovalAtt']/div[2]/button[1]";
	
	//Elements on Send Draft to user
	private static String StartUsersPath=".//*[@class='ms-selectable']/ul/li/span[contains(text(),'";
	private static String EndUsersPath="')]";
	private static String SendUserHeader="//*[@id='modalLabelEmail']";
	private static String StartSelectedUsersPath="//*[@class='ms-selection']/ul/li/span[contains(text(),'";
	private static String EndSelectedUsersPath="')]";
	private static String Cancelbutton="//*[@id='mdlEmail']/div/div/div[3]/button";
	private static String Sendbutton="//*[@id='mdlEmail']/div/div/div[3]/input";
	
	//Elements on Content injection Pop-up
	private static String RecentUpdatesLink="//*[@class='modal-body sm-modal-ui incident-wizard']/div[2]/ul/li/a/strong[contains(text(),'Recent Updates')]/ancestor::a[1]";
	private static String InsertButton="//*[@id='insert']";
	private static String TriggerField="//*[@id='txtContenInjector']";
	public static String ContentInjectionLabel="${recentupdates;}";
	private static String FolderLink="//*[@class='modal-body sm-modal-ui incident-wizard']/div[2]/ul/li/a/strong[contains(text(),'Folder')]/ancestor::a[1]";
	private static String FeedLink="//*[@class='modal-body sm-modal-ui incident-wizard']/div[2]/ul/li/a/strong[contains(text(),'News Feed')]/ancestor::a[1]";
	public static String ContentInjectionPartialFolderLabel="${doctype;id:";
	private static String NewFeedDropdown="//*[@id='tab3']/div/div/div/select";
	public static String ContentInjectionPartialFeedsLabel="${feed;id:";
	
	//Labels on Page
	public static String PageHeaderLabel="New Draft";
	public static String PublishButtonOnAddDocumentLabel=" Publish";
	public static String Publish_SendButtonOnAddDocumentLabel=" Publish & send";
	public static String SubmitForApprovalButtonOnAddDocumentLabel=" Submit for Approval";
	public static String MoreButtonOnAddDocumentLabel=" More ";
	public static String ApproveButtonOnAddDocumentLabel=" Approve";
	public static String PublishDraftLabel="Publish Draft";
	public static String SendEmailToUserHeaderLabel="Send Draft to Users";
	public static String SendEmailToUserSuccessfulMessage="File sent to users.";
	
	public static String AddDocumentAssertText1;
	public static String AddDocumentAssertText2;
	public static String AddDocumentAssertText3;
	public static String AddDocumentAssertText4;
	public static String AddDocumentAssertText5;
	public static String AddDocumentAssertText6;
	private static String AddedDocumentStatusPath;
	private static String AddedDocumentStatusPath1;
	public static String GetAddDocumentButtonAssertText1;
	public static String GetAddDocumentButtonAssertText2;
	public static String GetAddDocumentButtonAssertText3;
	public static String GetAddDocumentButtonAssertText4;
	public static String GetAddDocumentButtonAssertText5;
	public static String ScheduleDocumentAssertText7;
	public static String ScheduleDocumentAssertText8;
	public static String Submit_ApprovalAssertText9;
	public static String Submit_ApprovalAssertText10;
	public static String Submit_ApprovalAssertText11;
	public static String ApprovalAssertText12;
	public static String ApprovalAssertText13;
	public static String ScheduleDate;
	public static String Select_User;
	public static String Selected_User;
	public static String GetAddDocumentAssertText14;
	public static String GetAddDocumentAssertText15;
	public static String GetAddDocumentAssertText16;
	public static String GetAddDocumentAssertText17;
	static Alert alert;
	public static String GetAddDocumentAssertText18;
	public static String ArchiveAssertText19;
	public static String ArchiveAssertText20;
	public static String AddDocumentAssertText21;
	public static String AddDocumentAssertText22;
	public static String AddDocumentAssertText23;
	public static String AddDocumentAssertText24;
	public static String AddDocumentAssertText25;
	public static String AddDocumentAssertText26;
	public static String AddDocumentAssertText27;
	public static String AddDocumentAssertText28;
	public static String AddDocumentAssertText29;
	
	/********************************************************************** Function for Add Document File page *******************************************************************************************/
	
	//Function for Entering data and saving for HTML documents
	public static AddDocumentPage AddDocumentAndSubmit(String Headline, String TextValue, String DraftValue)
	{
		DocumentManagementPage.AddedDocument= DocumentManagementPage.StartAddedDocumentFilePath + Headline + DocumentManagementPage.EndAddedDocumentFilePath;
		AddedDocumentStatusPath=DocumentManagementPage.StartAddedDocumentFilePath + Headline + DocumentManagementPage.EndAddedDocumentFilePath+ DocumentManagementPage.AddedDocumentStatus;
		
		BasePage.driver.findElement(By.xpath(HeadlineTextBox)).sendKeys(Headline); 
		CommonFunctions.EnterTextInIFrame(TextBoxAddDocument, TextValue);
		BasePage.driver.findElement(By.xpath(TogglebuttonDraftButton)).click(); 
		 try {
	   		 Thread.sleep(2000);
	      	 } catch (InterruptedException e) {
	    			
	    			e.printStackTrace();
	    		}
		 BasePage.driver.findElement(By.xpath(DraftTextArea)).sendKeys(DraftValue); 
		 BasePage.driver.findElement(By.xpath(SaveButton_AddDocument)).click(); 
		 
		 try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPage.DocumentManagementPageLoadAssert);
         AddDocumentAssertText1=BasePage.driver.findElement(By.xpath(DocumentManagementPage.AddedDocument)).getText();
         AddDocumentAssertText2=BasePage.driver.findElement(By.xpath(AddedDocumentStatusPath)).getText();
         return new AddDocumentPage();
	}
	
	//When logged in user is Approver and creating a new document file
	public static AddDocumentPage ValidateButtonPresent()
	{
		
		GetAddDocumentButtonAssertText1=BasePage.driver.findElement(By.xpath(PublishButtonOnAddDocument)).getText(); 
		System.out.println(GetAddDocumentButtonAssertText1);
		GetAddDocumentButtonAssertText2=BasePage.driver.findElement(By.xpath(Publish_SendButtonOnAddDocument)).getText(); 
		GetAddDocumentButtonAssertText3=BasePage.driver.findElement(By.xpath(SubmitForApprovalButtonOnAddDocument)).getText(); 
		GetAddDocumentButtonAssertText4=BasePage.driver.findElement(By.xpath(MoreButtonOnAddDocument)).getText();
		BasePage.driver.findElement(By.xpath(MoreButtonDropDownOnAddDocument)).click();
		
		GetAddDocumentButtonAssertText5=BasePage.driver.findElement(By.xpath(ApproveButtonOnAddDocument)).getText(); 
		
		return new AddDocumentPage();
	}
	
	public static String EditDocumentAndSubmit(String Headline, String TextValue)
	{
		DocumentManagementPage.AddedDocument= DocumentManagementPage.StartAddedDocumentFilePath + Headline + DocumentManagementPage.EndAddedDocumentFilePath;
		
		BasePage.driver.findElement(By.xpath(HeadlineTextBox)).clear(); 
		BasePage.driver.findElement(By.xpath(HeadlineTextBox)).sendKeys(Headline); 
		CommonFunctions.EnterTextInIFrame(TextBoxAddDocument, TextValue);
		BasePage.driver.findElement(By.xpath(SaveButton_AddDocument)).click(); 
		 try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPage.DocumentManagementPageLoadAssert);
         AddDocumentAssertText3=BasePage.driver.findElement(By.xpath(DocumentManagementPage.AddedDocument)).getText();
         return(AddDocumentAssertText3);
	}
	
	//Function for entering data in fields for HTML document
	public static void EnterDataForNewDocument_HtmlPage(String HeadlineValue, String TextValue, String DraftValue, String SubtitleValue)
	{
		BasePage.driver.findElement(By.xpath(HeadlineTextBox)).sendKeys(HeadlineValue); 
		CommonFunctions.EnterTextInIFrame(TextBoxAddDocument, TextValue);
		
		
		BasePage.driver.findElement(By.xpath(TogglebuttonDraftButton)).click(); 
		 try {
	   		 Thread.sleep(2000);
	      	 } catch (InterruptedException e) {
	    			
	    			e.printStackTrace();
	    		}
		 BasePage.driver.findElement(By.xpath(DraftTextArea)).sendKeys(DraftValue); 
		 BasePage.driver.findElement(By.xpath(ToggleButtonProperties)).click(); 
		 try {
	   		 Thread.sleep(2000);
	      	 } catch (InterruptedException e) {
	    			
	    			e.printStackTrace();
	    		}
		 BasePage.driver.findElement(By.xpath(SubtitleField)).sendKeys(SubtitleValue);
		 
		 CommonFunctions.EnterTextInIFrame(TextBoxAddDocument, TextValue);
		 ((JavascriptExecutor) BasePage.driver).executeScript("window.scrollBy(300,0)");
		 
	}
	
	public static AddDocumentPage PublishDraft(String HeadlineValue)
	{
		DocumentManagementPage.AddedDocument= DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath;
		AddedDocumentStatusPath1=DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath+ DocumentManagementPage.AddedDocumentStatus;
		
		BasePage.driver.findElement(By.xpath(PublishIconOnAddDocument)).click(); 
		 
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        UtilityFunctions.WaitUntilPresenceOfElement(PublishDraftLabelPath);
        AddDocumentAssertText4=BasePage.driver.findElement(By.xpath(PublishDraftLabelPath)).getText(); 
        BasePage.driver.findElement(By.xpath(PublishButton)).click(); 
        try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPage.DocumentManagementPageLoadAssert);
         AddDocumentAssertText5=BasePage.driver.findElement(By.xpath(DocumentManagementPage.AddedDocument)).getText();
         AddDocumentAssertText6=BasePage.driver.findElement(By.xpath(AddedDocumentStatusPath1)).getText();
         return new AddDocumentPage();
	}
	
	public static AddDocumentPage ScheduleDocument(String HeadlineValue)
	{
		Calendar cal = Calendar.getInstance();
    	int val = cal.get(Calendar.DATE)+1;
    	System.out.println(val);
    	
    	ScheduleDate=CalendarDateStart+val+CalendarDateEnd;
    	DocumentManagementPage.AddedDocument= DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath;
		AddedDocumentStatusPath1=DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath+ DocumentManagementPage.AddedDocumentStatus;
    	
		BasePage.driver.findElement(By.xpath(PublishIconOnAddDocument)).click(); 
		 
		 try {
			Thread.sleep(2000);
		
       UtilityFunctions.WaitUntilPresenceOfElement(PublishDraftLabelPath);
       BasePage.driver.findElement(By.xpath(AdvanceOptionLink)).click();
       BasePage.driver.findElement(By.xpath(CalendarButton)).click();
       BasePage.driver.findElement(By.xpath(ScheduleDate)).click();
       BasePage.driver.findElement(By.xpath(PublishButton)).click();
		 } catch (InterruptedException e) {
				e.printStackTrace();
				BasePage.driver.findElement(By.xpath(CancelButton)).click();
			}
       try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPage.DocumentManagementPageLoadAssert);
        ScheduleDocumentAssertText7=BasePage.driver.findElement(By.xpath(DocumentManagementPage.AddedDocument)).getText();
        ScheduleDocumentAssertText8=BasePage.driver.findElement(By.xpath(AddedDocumentStatusPath1)).getText();
        return new AddDocumentPage();
	}
	
	public static AddDocumentPage SubmitForApproval(String HeadlineValue)
	{
		DocumentManagementPage.AddedDocument= DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath;
		AddedDocumentStatusPath1=DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath+ DocumentManagementPage.AddedDocumentStatus;
		
		BasePage.driver.findElement(By.xpath(SubmitForApprovalIconOnAddDocument)).click(); 
		 
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        UtilityFunctions.WaitUntilPresenceOfElement(SumbitForApprovalHeader);
        Submit_ApprovalAssertText9=BasePage.driver.findElement(By.xpath(SumbitForApprovalHeader)).getText(); 
        BasePage.driver.findElement(By.xpath(SumbitButton)).click(); 
        try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPage.DocumentManagementPageLoadAssert);
         Submit_ApprovalAssertText10=BasePage.driver.findElement(By.xpath(DocumentManagementPage.AddedDocument)).getText();
         Submit_ApprovalAssertText11=BasePage.driver.findElement(By.xpath(AddedDocumentStatusPath1)).getText();
         return new AddDocumentPage();
	}
	
	public static AddDocumentPage ApproveDocument(String HeadlineValue)
	{
		DocumentManagementPage.AddedDocument= DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath;
		AddedDocumentStatusPath1=DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath+ DocumentManagementPage.AddedDocumentStatus;
		
		BasePage.driver.findElement(By.xpath(MoreButtonDropDownOnAddDocument)).click(); 
		BasePage.driver.findElement(By.xpath(ApproveIconOnAddDocument)).click(); 	 
		 try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPage.DocumentManagementPageLoadAssert);
         ApprovalAssertText12=BasePage.driver.findElement(By.xpath(DocumentManagementPage.AddedDocument)).getText();
         ApprovalAssertText13=BasePage.driver.findElement(By.xpath(AddedDocumentStatusPath1)).getText();
         return new AddDocumentPage();
	}
	
	//CLick on send email to users , Select an user and clicks on Send
	public static AddDocumentPage SendEmailToUser(String HeadlineValue)
	{
		Select_User=StartUsersPath+BasePage.TestConfiguration.getProperty("UserName")+EndUsersPath;
		Selected_User=StartSelectedUsersPath+ BasePage.TestConfiguration.getProperty("UserName")+EndSelectedUsersPath;
				
		BasePage.driver.findElement(By.xpath(MoreButtonDropDownOnAddDocument)).click(); 
		BasePage.driver.findElement(By.xpath(EmailToUserIcon)).click(); 	 
		 try {
			Thread.sleep(3000);
		
         UtilityFunctions.WaitUntilPresenceOfElement(SendUserHeader);
         GetAddDocumentAssertText14=BasePage.driver.findElement(By.xpath(SendUserHeader)).getText(); 
         BasePage.driver.findElement(By.xpath(Select_User)).click();
         Thread.sleep(1000);
         GetAddDocumentAssertText15=BasePage.driver.findElement(By.xpath(Selected_User)).getText();
         BasePage.driver.findElement(By.xpath(Sendbutton)).click(); 
 		 Thread.sleep(8000);
 		} catch (InterruptedException e) {
 			BasePage.driver.findElement(By.xpath(Cancelbutton)).click();
 			e.printStackTrace();
 		}
          GetAddDocumentAssertText16=BasePage.driver.findElement(By.xpath(SendUserToEmailSuccessfulMessage)).getText();
          return new AddDocumentPage();
	}
	
	//Click on Archive from Add/edit document page, click on Ok on archive alert
	public static AddDocumentPage ArchiveDocument_MoreDropdown(String HeadlineValue)
	{
		DocumentManagementPage.AddedDocument= DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath;
		AddedDocumentStatusPath1=DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath+ DocumentManagementPage.AddedDocumentStatus;
		
		BasePage.driver.findElement(By.xpath(MoreButtonDropDownOnAddDocument)).click(); 
		BasePage.driver.findElement(By.xpath(ArchiveIconOnAddDocument)).click(); 	
		 try {
	 		 Thread.sleep(2000);
	 		} catch (InterruptedException e) {
	 			e.printStackTrace();
	 		} 
		alert = BasePage.driver.switchTo().alert();
		GetAddDocumentAssertText18=alert.getText();
		System.out.println(GetAddDocumentAssertText18);
		alert.accept();
		 try {
 		 Thread.sleep(8000);
 		} catch (InterruptedException e) {
 			e.printStackTrace();
 		} 
		 UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPage.DocumentManagementPageLoadAssert);
         ArchiveAssertText19=BasePage.driver.findElement(By.xpath(DocumentManagementPage.AddedDocument)).getText();
         ArchiveAssertText20=BasePage.driver.findElement(By.xpath(AddedDocumentStatusPath1)).getText();
         return new AddDocumentPage();
	}
	
	//Saving an New Draft from this document
	public static AddDocumentPage SaveDocument_NDD(String Headline)
	{
		DocumentManagementPage.AddedDocument= DocumentManagementPage.StartAddedDocumentFilePath + Headline+ "(copy)" + DocumentManagementPage.EndAddedDocumentFilePath;
		AddedDocumentStatusPath=DocumentManagementPage.StartAddedDocumentFilePath + Headline + DocumentManagementPage.EndAddedDocumentFilePath+ DocumentManagementPage.AddedDocumentStatus;
		
		 BasePage.driver.findElement(By.xpath(SaveButton_AddDocument)).click(); 
		 try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPage.DocumentManagementPageLoadAssert);
         AddDocumentAssertText21=BasePage.driver.findElement(By.xpath(DocumentManagementPage.AddedDocument)).getText();
         AddDocumentAssertText22=BasePage.driver.findElement(By.xpath(AddedDocumentStatusPath)).getText();
         return new AddDocumentPage();
	}
	
		//Click on Send button for sending document as notification
		public static String ClickOnSend()
		{
			 UtilityFunctions.WaitUntilPresenceOfElement(SendIconOnAddDocument);
			 BasePage.driver.findElement(By.xpath(SendIconOnAddDocument)).click(); 
			 try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 BasePage.driver.switchTo().frame("iPopUp");

	         UtilityFunctions.WaitUntilPresenceOfElement(SendNotificationPage.ChannelSelectionPopUp);
	         AddDocumentAssertText23=BasePage.driver.findElement(By.xpath(SendNotificationPage.SendNotificationHeader)).getText();
	         return(AddDocumentAssertText23);
		}
		
		public static AddDocumentPage ContentInjection_RecentUpdates()
		{
			
			BasePage.driver.findElement(By.xpath(ContentInjectionLink)).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			BasePage.driver.findElement(By.xpath(RecentUpdatesLink)).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//AddDocumentAssertText25=BasePage.driver.findElement(By.xpath(TriggerField)).getText();
			BasePage.driver.findElement(By.xpath(InsertButton)).click();
			 try {
				 Thread.sleep(3000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
			 AddDocumentAssertText26=CommonFunctions.getTextFromIFrame(TextBoxAddDocument);
			 
			 return new AddDocumentPage();
			
		}
		
		public static AddDocumentPage ContentInjection_Folder()
		{
			
			BasePage.driver.findElement(By.xpath(ContentInjectionLink)).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			BasePage.driver.findElement(By.xpath(FolderLink)).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//AddDocumentAssertText27=BasePage.driver.findElement(By.xpath(TriggerField)).getText();
			BasePage.driver.findElement(By.xpath(InsertButton)).click();
			 try {
				 Thread.sleep(3000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
			 AddDocumentAssertText28=CommonFunctions.getTextFromIFrame(TextBoxAddDocument);
			 
			 return new AddDocumentPage();
			
		}
		
		public static AddDocumentPage ContentInjection_Feeds(String FeedNameValue)
		{
			
			BasePage.driver.findElement(By.xpath(ContentInjectionLink)).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			BasePage.driver.findElement(By.xpath(FeedLink)).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Select Feeddropdown = new Select(BasePage.driver.findElement(By.xpath(NewFeedDropdown)));
			Feeddropdown.selectByVisibleText(FeedNameValue);
			//AddDocumentAssertText27=BasePage.driver.findElement(By.xpath(TriggerField)).getText();
			BasePage.driver.findElement(By.xpath(InsertButton)).click();
			 try {
				 Thread.sleep(3000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
			 AddDocumentAssertText29=CommonFunctions.getTextFromIFrame(TextBoxAddDocument);
			 
			 return new AddDocumentPage();
			
		}
}
