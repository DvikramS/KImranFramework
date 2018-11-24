package TestCases.DocumentTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.JoinMailingListPage;
import Page.Document.AddDocumentPage;
import Page.Document.ApprovalListPage;
import Page.Document.BulkArchiveDocumentPage;
import Page.Document.DocumentManagementPage;
import Page.InquiryPages.InquiryAnswerPage;
import Page.InquiryPages.InquiryDetailsPage;
import Page.InquiryPages.PublicInquiryPage;
import Page.InquiryPages.SearchInquiryPage;
import Page.OtherModulePages.NewsAndInfoPublicPage;
import Page.OtherModulePages.PublicSearchPage;
import Page.OtherModulePages.PublicViewPage;
import Util.UtilityFunctions;

public class DocumentManagement_Continuation_Tests {

	String GetInquiryAnswerAssertText1;
	boolean GetInquiryAnswerAssertText2;
	String GetInquiryAnswerAssertText3;
	String GetInquiryAnswerAssertText4;
	String GetInquiryAnswerAssertText5;
	String GetInquiryAnswerAssertText6;
	String GetAssertText7;
	String GetAssertText8;
	String GetAssertText9;
	String GetAssertText10;
	String GetAssertText11;
	
	InquiryDetailsPage InquiryDetailsPageObject;
	AddDocumentPage AddDocumentPageObject;
	DocumentManagementPage DocumentManagementPageObject;
	
	//Verify that user is able to navigate from DNN to Inquiry successfully
	@Test(priority=1)
	public void VerifyNavigationToInquiryAnswers()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyNavigationToInquiryAnswers", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
			System.out.println("VerifyNavigateToDocumentManagementPage Start");
			GetInquiryAnswerAssertText1=InquiryAnswerPage.NavigateToInquiryAnswerPageFromDNN();
			Assert.assertEquals(GetInquiryAnswerAssertText1,InquiryAnswerPage.InquiryAnswerHeaderLabel);
			System.out.println("VerifyNavigationToInquiryAnswers ends");
	}
	
	//Verify Inquiry answer checkbox is displayed and is Selected
		@Test(priority=2)
		public void VerifyInquiryAnswerCheckboxIsSelected()
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyInquiryAnswerCheckboxIsSelected", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
				System.out.println("VerifyInquiryAnswerCheckboxIsSelected Start");
				GetInquiryAnswerAssertText2=InquiryAnswerPage.ValidateInquiryAnswerCheckboxPresence();
				Assert.assertTrue(GetInquiryAnswerAssertText2);
				System.out.println("VerifyInquiryAnswerCheckboxIsSelected ends");
		}
	
	//Verify published document is displayed under Folder
		@Test(priority=3,dataProvider = "getTestDataForVerifyPublishedDocumentIsDisplayed")
		public void VerifyPublishedDocumentIsDisplayed(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyPublishedDocumentIsDisplayed", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			    System.out.println("VerifyPublishedDocumentIsDisplayed Test Starts"); 
			    GetInquiryAnswerAssertText3=InquiryAnswerPage.ValidatePublishedDocumentIsDisplayedInAnswer(TestDataSet.get("FolderNameValue"),TestDataSet.get("HeadlineValue"));	
				Assert.assertEquals(GetInquiryAnswerAssertText3, TestDataSet.get("HeadlineValue"));	
				System.out.println("VerifyPublishedDocumentIsDisplayeds ends");
		}
		
		@DataProvider
		public Object[][] getTestDataForVerifyPublishedDocumentIsDisplayed()
		{
			Object[][] Data = UtilityFunctions.getData("VerifyPublishedDocumentIsDisplayed", BasePage.xls);
			return Data;
		}
		
		//Verify Inquiry Answer page is saved successfully
		@Test(priority=4)
		public void VerifyInquiryAnswerPageSavedSuccessfully()
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("VerifyInquiryAnswerPageSavedSuccessfully", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
					
					 System.out.println("VerifyInquiryAnswerPageSavedSuccessfully Test Starts"); 
					 GetInquiryAnswerAssertText4=InquiryAnswerPage.InquiryAnswerIsSavedSuccessfully();	
					 Assert.assertTrue(InquiryAnswerPage.GetInquiryAssertText4.contains(InquiryAnswerPage.InquiryAnswerSuccessMessageLabel));	
					 System.out.println("VerifyInquiryAnswerPageSavedSuccessfully ends");
				}
		
		//Verify published document is displayed under answer dropdown on inquiry details page
		@Test(priority=5,dataProvider = "getTestDataForVerifyInquiryAnswerInDropdown")
		public void VerifyInquiryAnswerInDropdown(Hashtable<String, String> TestDataSet)
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("VerifyInquiryAnswerInDropdown", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
					
					System.out.println("VerifyInquiryAnswerInDropdown Test Starts"); 
					SearchInquiryPage.NavigateToSearchInquiry();
				    SearchInquiryPage.EditFirstInquiry();
				    InquiryDetailsPageObject=InquiryDetailsPage.ValidateAnswerInInquiryAnswerDropdown(TestDataSet.get("HeadlineValue"));	
					Assert.assertEquals(InquiryDetailsPageObject.InquiryDetailsAssertlabel3, TestDataSet.get("HeadlineValue"));	
					Assert.assertTrue(InquiryDetailsPageObject.InquiryDetailsAssertlabel4.contains(TestDataSet.get("TextValue")));
					System.out.println("VerifyInquiryAnswerInDropdown ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyInquiryAnswerInDropdown()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyInquiryAnswerInDropdown", BasePage.xls);
					return Data;
				}	
				
				//Verify user is able to do content injection for recent updates successfully in a new document
				@Test(priority=6,dataProvider = "getTestDataForVerifyContentInjectionRecentUpdates")
				public void VerifyContentInjectionRecentUpdates(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyContentInjectionRecentUpdates", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyContentInjectionRecentUpdates Test Starts"); 
					   
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						DocumentManagementPage.NavigateToCreateDocument(TestDataSet.get("FolderNameValue"));
						AddDocumentPage.EnterDataForNewDocument_HtmlPage(TestDataSet.get("HeadlineValue"),TestDataSet.get("TextValue"),TestDataSet.get("DraftValue"),TestDataSet.get("SubtitleValue"));
						AddDocumentPageObject=AddDocumentPage.ContentInjection_RecentUpdates();
						AddDocumentPageObject=AddDocumentPage.PublishDraft(TestDataSet.get("HeadlineValue"));
						//Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText25,AddDocumentPageObject.ContentInjectionLabel);	
						Assert.assertTrue(AddDocumentPageObject.AddDocumentAssertText26.contains(AddDocumentPageObject.ContentInjectionLabel));	
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText5,TestDataSet.get("HeadlineValue"));	
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText6,"Published");
						System.out.println("VerifyContentInjectionRecentUpdates ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyContentInjectionRecentUpdates()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyContentInjectionRecentUpdates", BasePage.xls);
					return Data;
				}		
				
				//Verify user is able to do content injection for folder updates successfully in a new document
				@Test(priority=6,dataProvider = "getTestDataForVerifyContentInjectionFolder")
				public void VerifyContentInjectionFolder(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyContentInjectionFolder", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyContentInjectionFolder Test Starts"); 
					   
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						DocumentManagementPage.NavigateToCreateDocument(TestDataSet.get("FolderNameValue"));
						AddDocumentPage.EnterDataForNewDocument_HtmlPage(TestDataSet.get("HeadlineValue"),TestDataSet.get("TextValue"),TestDataSet.get("DraftValue"),TestDataSet.get("SubtitleValue"));
						AddDocumentPageObject=AddDocumentPage.ContentInjection_Folder();
						AddDocumentPageObject=AddDocumentPage.PublishDraft(TestDataSet.get("HeadlineValue"));
						//Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText25,AddDocumentPageObject.ContentInjectionLabel);	
						Assert.assertTrue(AddDocumentPageObject.AddDocumentAssertText28.contains(AddDocumentPageObject.ContentInjectionPartialFolderLabel));	
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText5,TestDataSet.get("HeadlineValue"));	
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText6,"Published");
						System.out.println("VerifyContentInjectionFolder ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyContentInjectionFolder()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyContentInjectionFolder", BasePage.xls);
					return Data;
				}	
				
				//Verify user is able to do content injection for news feeds  successfully in a new document
				@Test(priority=7,dataProvider = "getTestDataForVerifyContentInjectionFeeds")
				public void VerifyContentInjectionFeeds(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyContentInjectionFeeds", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyContentInjectionFeeds Test Starts"); 
					   
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						DocumentManagementPage.NavigateToCreateDocument(TestDataSet.get("FolderNameValue"));
						AddDocumentPage.EnterDataForNewDocument_HtmlPage(TestDataSet.get("HeadlineValue"),TestDataSet.get("TextValue"),TestDataSet.get("DraftValue"),TestDataSet.get("SubtitleValue"));
						AddDocumentPageObject=AddDocumentPage.ContentInjection_Feeds(TestDataSet.get("FeedNameValue"));
						AddDocumentPageObject=AddDocumentPage.PublishDraft(TestDataSet.get("HeadlineValue"));
						//Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText25,AddDocumentPageObject.ContentInjectionLabel);	
						Assert.assertTrue(AddDocumentPageObject.AddDocumentAssertText29.contains(AddDocumentPageObject.ContentInjectionPartialFeedsLabel));	
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText5,TestDataSet.get("HeadlineValue"));	
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText6,"Published");
						System.out.println("VerifyContentInjectionFeeds ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyContentInjectionFeeds()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyContentInjectionFeeds", BasePage.xls);
					return Data;
				}
				
				
				//Verify user is navigate to folder options and assert the field value and saves 
				@Test(priority=8,dataProvider = "getTestDataForVerifyFolderOptionLabels")
				public void VerifyFolderOptionLabels(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyFolderOptionLabels", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyFolderOptionLabels Test Starts"); 
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    DocumentManagementPageObject=DocumentManagementPage.FolderOptionLabels(TestDataSet.get("FolderNameValue"));
					
						Assert.assertEquals(DocumentManagementPageObject.DocumentManagementAssertText18,DocumentManagementPageObject.FolderViewTemplateLabel);
						Assert.assertEquals(DocumentManagementPageObject.DocumentManagementAssertText19,DocumentManagementPageObject.DocumentViewTemplateLabel);
						System.out.println("VerifyFolderOptionLabels ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyFolderOptionLabels()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyFolderOptionLabels", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to add and publish document successfully
				@Test(priority=9,dataProvider = "getTestDataForVerifySearchOnPublicView")
				public void VerifySearchOnPublicView(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifySearchOnPublicView", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifySearchOnPublicView Test Starts"); 
					   
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						PublicViewPage.navigateToViewWebsite_FromDNN();
						PublicViewPage.switchToPublicView();
						NewsAndInfoPublicPage.navigateToFolder_UnderNewsAndInfo(TestDataSet.get("FolderNameValue"));
						GetInquiryAnswerAssertText6=PublicSearchPage.SearchResult(TestDataSet.get("HeadlineValue"));
						//DocumentAssertText20=PublicViewPage.switchToMainWindow_DNN();
						Assert.assertEquals(GetInquiryAnswerAssertText6,TestDataSet.get("HeadlineValue"));
						System.out.println("VerifySearchOnPublicView ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifySearchOnPublicView()
				{
					Object[][] Data = UtilityFunctions.getData("VerifySearchOnPublicView", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to add inquiry from public page successfully
				@Test(priority=10,dataProvider = "getTestDataForVerifyAddInquiryPublicPage")
				public void VerifyAddInquiryPublicPage(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyAddInquiryPublicPage", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyAddInquiryPublicPage Test Starts");
						NewsAndInfoPublicPage.navigateToFolder_QuestionComments(TestDataSet.get("FolderNameValue"));
						GetAssertText7=PublicInquiryPage.createInquiry(TestDataSet.get("CategoryValue"), TestDataSet.get("firstNameValue"), TestDataSet.get("LastNameValue"), 
								TestDataSet.get("emailValue"), TestDataSet.get("questionValue"));
						PublicViewPage.switchToMainWindow_DNN();
						Assert.assertEquals(GetAssertText7,PublicInquiryPage.SuccessMessageLabel);
						System.out.println("VerifyAddInquiryPublicPage ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyAddInquiryPublicPage()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyAddInquiryPublicPage", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to subscribe contact from public page successfully
				@Test(priority=11,dataProvider = "getTestDataForVerifySubscribeContactPublicPage")
				public void VerifySubscribeContactPublicPage(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifySubscribeContactPublicPage", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifySubscribeContactPublicPage Test Starts");
						NewsAndInfoPublicPage.navigateToFolder_QuestionComments(TestDataSet.get("FolderNameValue"));
						GetAssertText8=JoinMailingListPage.joinMailingList(TestDataSet.get("directoryValue"), TestDataSet.get("firstNameValue"), TestDataSet.get("LastNameValue"), 
								TestDataSet.get("emailValue"));
						PublicViewPage.switchToMainWindow_DNN();
						Assert.assertEquals(GetAssertText8,JoinMailingListPage.SuccessMessageLabel);
						System.out.println("VerifySubscribeContactPublicPage ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifySubscribeContactPublicPage()
				{
					Object[][] Data = UtilityFunctions.getData("VerifySubscribeContactPublicPage", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to search documents for particular documents successfully
				@Test(priority=12,dataProvider = "getTestDataForVerifyDocumentCreation")
				public void VerifyDocumentCreation(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyDocumentCreation", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
						//DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();	
					try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					    System.out.println("VerifyDocumentCreation Test Starts");
					    DocumentManagementPage.CreateFolderFromIcon(TestDataSet.get("FolderNameValue"));
					    ApprovalListPage.NavigateToDocumentApprovalList();
					    ApprovalListPage.SelectApproverForFolder(TestDataSet.get("FolderNameValue"));
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						DocumentManagementPage.NavigateToCreateDocument(TestDataSet.get("FolderNameValue"));
						AddDocumentPage.EnterDataForNewDocument_HtmlPage(TestDataSet.get("HeadlineValue"),TestDataSet.get("TextValue"),TestDataSet.get("DraftValue"),TestDataSet.get("SubtitleValue"));
						AddDocumentPageObject=AddDocumentPage.PublishDraft(TestDataSet.get("HeadlineValue"));
						Assert.assertEquals(GetAssertText11,BulkArchiveDocumentPage.successMessageArchiveLabel);
						System.out.println("VerifyDocumentCreation ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyDocumentCreation()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyDocumentCreation", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to subscribe contact from public page successfully
				@Test(priority=13)
				public void VerifyNavigationToBulkArchivepage()
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyNavigationToBulkArchivepage", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyNavigationToBulkArchivepage Test Starts");
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						GetAssertText9=BulkArchiveDocumentPage.navigateToBulkArchiveDocumentsPage(); 
						Assert.assertEquals(GetAssertText9,BulkArchiveDocumentPage.labelHeaderBulkArchiveDocuments);
						System.out.println("VerifyNavigationToBulkArchivepage ends");
				}
				
				//Verify user is able to search documents for particular documents successfully
				@Test(priority=14,dataProvider = "getTestDataForVerifySearchDocumentsBulkArchive")
				public void VerifySearchDocumentsBulkArchive(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifySearchDocumentsBulkArchive", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifySearchDocumentsBulkArchive Test Starts");
					    GetAssertText10=BulkArchiveDocumentPage.validateSearhDocumentsOnbulkArchive(TestDataSet.get("FolderNameValue")); 
						Assert.assertEquals(GetAssertText10,BulkArchiveDocumentPage.label1);
						System.out.println("VerifySearchDocumentsBulkArchive ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifySearchDocumentsBulkArchive()
				{
					Object[][] Data = UtilityFunctions.getData("VerifySearchDocumentsBulkArchive", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to search documents for particular documents successfully
				@Test(priority=15)
				public void VerifyArchiveDocument()
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyArchiveDocument", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyArchiveDocument Test Starts");
					    GetAssertText11=BulkArchiveDocumentPage.validatebulkArchive(); 
						Assert.assertEquals(GetAssertText11,BulkArchiveDocumentPage.successMessageArchiveLabel);
						System.out.println("VerifyArchiveDocument ends");
				}
				
				
}
