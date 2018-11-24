package TestCases.DocumentTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.SearchContactPopUpPage;
import Page.Document.AddDocumentPage;
import Page.Document.AddSignaturePage;
import Page.Document.AddTemplatePage;
import Page.Document.ApprovalListPage;
import Page.Document.ArchiveMessagePage;
import Page.Document.DocumentManagementPage;
import Page.Document.HomePageSettingPage;
import Page.Document.ManageSignatureList;
import Page.Document.ManageTemplateListPage;
import Page.Document.MergeSignaturePage;
import Page.InquiryPages.AddInquiryPage;
import Page.InquiryPages.InquiryDashboardPage;
import Page.NotificationPages.SendNotificationPage;
import Page.OtherModulePages.NewsAndInfoPublicPage;
import Page.OtherModulePages.PublicViewPage;
import Util.UtilityFunctions;

public class DocumentManagementTests {

	private static String GetDocumentAssertText1;
	private static String GetDocumentAssertText2;
	private static String GetDocumentAssertText3;
	private static String GetDocumentAssertText4;
	private static String GetDocumentAssertText5;
	private static String DocumentApprovalAssertText1;
	private static String DocumentApprovalAssertText2;
	private static String DocumentAssertText1;
	private static String DocumentAssertText2;
	private static String DocumentAssertText3;
	private static String TemplateAssertText4;
	private static String SignatureAssertText5;
	private static String SignatureAssertText6;
	private static String SignatureAssertText7;
	private static String SignatureAssertText8;
	private static String SignatureAssertText9;
	private static String DocumentAssertText10;
	private static String DocumentAssertText11;
	private static String DocumentAssertText12;
	private static String DocumentAssertText13;
	private static String DocumentAssertText14;
	private static String DocumentAssertText15;
	private static String DocumentAssertText17;
	private static String DocumentAssertText18;
	private static String DocumentAssertText19;
	private static String DocumentAssertText20;
	private static String DocumentAssertText21;
	private static String DocumentAssertText22;
	private static String DocumentAssertText23;
	private static String DocumentAssertText24;
	
	DocumentManagementPage DocumentManagementPageObject;
	AddDocumentPage AddDocumentPageObject;
	ApprovalListPage ApprovalListPageObject;
	MergeSignaturePage MergeSignaturePageObject;
	HomePageSettingPage HomePageSettingPageObject;
	
	@Test(priority=1)
	public void VerifyNavigateToDocumentManagementPage()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyNavigateToDocumentManagementPage", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
			System.out.println("VerifyNavigateToDocumentManagementPage Start");
			GetDocumentAssertText1=DocumentManagementPage.NavigateToDocumentManagementPage();
			//Navigated twice because of bug 
			DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
			Assert.assertEquals(GetDocumentAssertText1, DocumentManagementPage.DocumentManagementLabel);
			System.out.println("VerifyNavigateToDocumentManagementPage ends");
	}
	
	//Verify user is able to add folder from icon
	@Test(priority=2,dataProvider = "getTestDataForVerifyAddFolderFromIcon")
	public void VerifyAddFolderFromIcon(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyAddFolderFromIcon", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyAddFolderFromIcon Test Starts"); 
		    DocumentManagementPageObject=DocumentManagementPage.CreateFolderFromIcon(TestDataSet.get("FolderNameValue"));
			Assert.assertEquals(DocumentManagementPageObject.DocumentManagementAssertText2, "Create Folder");	
			Assert.assertEquals(DocumentManagementPageObject.DocumentManagementAssertText3, TestDataSet.get("FolderNameValue"));	
			System.out.println("VerifyAddFolderFromIcon ends");
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyAddFolderFromIcon()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyAddFolderFromIcon", BasePage.xls);
		return Data;
	}
	
	
	@Test(priority=3)
	public void NavigateToDocumentApprovalListPage()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToDocumentApprovalListPage", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
			DocumentApprovalAssertText1=ApprovalListPage.NavigateToDocumentApprovalList();
			Assert.assertEquals(DocumentApprovalAssertText1, ApprovalListPage.DocumentApprovalHeaderLabel);
			System.out.println("NavigateToDocumentApprovalListPage ends");
	
	}
	
	@Test(priority=4,dataProvider = "getTestDataForVerifyDocumentApproverSelection")
	public void VerifyDocumentApproverSelection(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyDocumentApproverSelection", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("VerifyDocumentApproverSelection Test Starts");
		   ApprovalListPageObject=ApprovalListPage.SelectApproverForFolder(TestDataSet.get("FolderNameValue"));
			Assert.assertEquals(ApprovalListPageObject.DocumentApprovalListText2,ApprovalListPageObject.ApprovalListSaveSuccessfulMessageLabel);
			Assert.assertEquals(ApprovalListPageObject.GetSelectedUserText,BasePage.TestConfiguration.getProperty("UserName"));
			System.out.println("VerifyDocumentApproverSelection ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyDocumentApproverSelection()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyDocumentApproverSelection", BasePage.xls);
		return Data;
	}
	

	
	//Verify Button presence on add document
	@Test(priority=5,dataProvider = "getTestDataForVerifyButtonsPresenceOnAddDocumentPage")
	public void VerifyButtonsPresenceOnAddDocumentPage(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyButtonsPresenceOnAddDocumentPage", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
			
			System.out.println("VerifyButtonsPresenceOnAddDocumentPage Starts");
			DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
			DocumentManagementPage.NavigateToCreateDocument(TestDataSet.get("FolderNameValue"));
			AddDocumentPageObject=AddDocumentPage.ValidateButtonPresent();
			
			Assert.assertEquals(AddDocumentPageObject.GetAddDocumentButtonAssertText1, AddDocumentPageObject.PublishButtonOnAddDocumentLabel);
			Assert.assertEquals(AddDocumentPageObject.GetAddDocumentButtonAssertText2, AddDocumentPageObject.Publish_SendButtonOnAddDocumentLabel);
			Assert.assertEquals(AddDocumentPageObject.GetAddDocumentButtonAssertText3, AddDocumentPageObject.SubmitForApprovalButtonOnAddDocumentLabel);
			Assert.assertEquals(AddDocumentPageObject.GetAddDocumentButtonAssertText4, AddDocumentPageObject.MoreButtonOnAddDocumentLabel);
			Assert.assertEquals(AddDocumentPageObject.GetAddDocumentButtonAssertText5, AddDocumentPageObject.ApproveButtonOnAddDocumentLabel);
			System.out.println("VerifyButtonsPresenceOnAddDocumentPage ends");
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyButtonsPresenceOnAddDocumentPage()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyButtonsPresenceOnAddDocumentPage", BasePage.xls);
		return Data;
	}
	
		//Verify user is able to add draft document successfully
		@Test(priority=6,dataProvider = "getTestDataForVerifyAddDocumentFile")
		public void VerifyAddDocumentFile(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyAddDocumentFile", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			    System.out.println("VerifyAddDocumentFile Test Starts"); 
			    
			    AddDocumentPageObject=AddDocumentPage.AddDocumentAndSubmit(TestDataSet.get("Headline"),TestDataSet.get("TextValue"),TestDataSet.get("DraftValue"));
				Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText1, TestDataSet.get("Headline"));	
				Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText2, "Draft");	
				System.out.println("VerifyAddDocumentFile ends");
		}
		
		@DataProvider
		public Object[][] getTestDataForVerifyAddDocumentFile()
		{
			Object[][] Data = UtilityFunctions.getData("VerifyAddDocumentFile", BasePage.xls);
			return Data;
		}
		
				//Verify user is able to edit document successfully
				@Test(priority=6,dataProvider = "getTestDataForVerifyEditDocumentFile")
				public void VerifyEditDocumentFile(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyEditDocumentFile", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyEditDocumentFile Test Starts"); 
					    DocumentManagementPage.Edit_Document(TestDataSet.get("Headline"), TestDataSet.get("FolderNameValue"));
					    DocumentAssertText1=AddDocumentPage.EditDocumentAndSubmit(TestDataSet.get("NewHeadline"),TestDataSet.get("TextValue"));
						Assert.assertEquals(DocumentAssertText1, TestDataSet.get("NewHeadline"));	
						System.out.println("VerifyEditDocumentFile ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyEditDocumentFile()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyEditDocumentFile", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to edited document old draft version
				@Test(priority=7,dataProvider = "getTestDataForVerifyEditedDocumentOldVersion")
				public void VerifyEditedDocumentOldVersion(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyEditedDocumentOldVersion", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyEditedDocumentOldVersion Test Starts"); 
					    DocumentAssertText2=DocumentManagementPage.ValidateOldDraftVersion(TestDataSet.get("HeadlineValue"),TestDataSet.get("NewHeadlineValue"),TestDataSet.get("FolderNameValue"));
						Assert.assertEquals(DocumentAssertText2, TestDataSet.get("HeadlineValue"));	
						System.out.println("VerifyEditedDocumentOldVersion ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyEditedDocumentOldVersion()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyEditedDocumentOldVersion", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to add and publish document successfully
				@Test(priority=8,dataProvider = "getTestDataForVerifyPublishDocument")
				public void VerifyPublishDocument(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyPublishDocument", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyPublishDocument Test Starts"); 
					    
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						DocumentManagementPage.NavigateToCreateDocument(TestDataSet.get("FolderNameValue"));
						AddDocumentPage.EnterDataForNewDocument_HtmlPage(TestDataSet.get("HeadlineValue"),TestDataSet.get("TextValue"),TestDataSet.get("DraftValue"),TestDataSet.get("SubtitleValue"));
						AddDocumentPageObject=AddDocumentPage.PublishDraft(TestDataSet.get("HeadlineValue"));
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText4,AddDocumentPageObject.PublishDraftLabel);	
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText5,TestDataSet.get("HeadlineValue"));	
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText6,"Published");	
						System.out.println("VerifyPublishDocument ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyPublishDocument()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyPublishDocument", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to schedule document successfully
				//Issue exist on QA status displayed published 
				@Test(priority=9,dataProvider = "getTestDataForVerifyScheduleDocument")
				public void VerifyScheduleDocument(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyScheduleDocument", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyScheduleDocument Test Starts"); 
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    DocumentManagementPage.Edit_Document(TestDataSet.get("HeadlineValue"), TestDataSet.get("FolderNameValue"));
						AddDocumentPageObject=AddDocumentPage.ScheduleDocument(TestDataSet.get("HeadlineValue"));
						Assert.assertEquals(AddDocumentPageObject.ScheduleDocumentAssertText8,"Scheduled");	
						System.out.println("VerifyScheduleDocument ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyScheduleDocument()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyScheduleDocument", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to Submit for Approval document successfully
				@Test(priority=10,dataProvider = "getTestDataForVerifySubmitForApprovalDocument")
				public void VerifySubmitForApprovalDocument(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifySubmitForApprovalDocument", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifySubmitForApprovalDocument Test Starts"); 
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    DocumentManagementPage.Edit_Document(TestDataSet.get("HeadlineValue"), TestDataSet.get("FolderNameValue"));
						AddDocumentPageObject=AddDocumentPage.SubmitForApproval(TestDataSet.get("HeadlineValue"));
						Assert.assertEquals(AddDocumentPageObject.Submit_ApprovalAssertText11,"Pending approval");	
						System.out.println("VerifySubmitForApprovalDocument ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifySubmitForApprovalDocument()
				{
					Object[][] Data = UtilityFunctions.getData("VerifySubmitForApprovalDocument", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to Approve a document successfully
				@Test(priority=11,dataProvider = "getTestDataForVerifyApproveDocument")
				public void VerifyApproveDocument(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyApproveDocument", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyApproveDocument Test Starts");
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    DocumentManagementPage.Edit_Document(TestDataSet.get("HeadlineValue"), TestDataSet.get("FolderNameValue"));
						AddDocumentPageObject=AddDocumentPage.ApproveDocument(TestDataSet.get("HeadlineValue"));
						Assert.assertEquals(AddDocumentPageObject.ApprovalAssertText13,"Approved");	
						System.out.println("VerifyApproveDocument ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyApproveDocument()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyApproveDocument", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to Send Email to user a document successfully
				@Test(priority=12,dataProvider = "getTestDataForVerifySendEmailToUser_Document")
				public void VerifySendEmailToUser_Document(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifySendEmailToUser_Document", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifySendEmailToUser_Document Test Starts");
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    DocumentManagementPage.ViewAndApproveDocument(TestDataSet.get("HeadlineValue"), TestDataSet.get("FolderNameValue"));
						AddDocumentPageObject=AddDocumentPage.SendEmailToUser(TestDataSet.get("HeadlineValue"));
						Assert.assertTrue(AddDocumentPageObject.GetAddDocumentAssertText15.contains(BasePage.TestConfiguration.getProperty("UserName")));	
						Assert.assertEquals(AddDocumentPageObject.GetAddDocumentAssertText14,AddDocumentPageObject.SendEmailToUserHeaderLabel);
						Assert.assertEquals(AddDocumentPageObject.GetAddDocumentAssertText16,AddDocumentPageObject.SendEmailToUserSuccessfulMessage);
						System.out.println("VerifySendEmailToUser_Document ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifySendEmailToUser_Document()
				{
					Object[][] Data = UtilityFunctions.getData("VerifySendEmailToUser_Document", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to Archive documents from Add/Edit Document file UI from more dropdwon
				@Test(priority=13,dataProvider = "getTestDataForVerifyArchiveDocumentFromMoreDropdwon")
				public void VerifyArchiveDocumentFromMoreDropdwon(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyArchiveDocumentFromMoreDropdwon", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyArchiveDocumentFromMoreDropdwon Test Starts");
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    DocumentManagementPage.ViewAndApproveDocument(TestDataSet.get("HeadlineValue"), TestDataSet.get("FolderNameValue"));
						AddDocumentPageObject=AddDocumentPage.ArchiveDocument_MoreDropdown(TestDataSet.get("HeadlineValue"));
						Assert.assertTrue(AddDocumentPageObject.GetAddDocumentAssertText18.contains(AddDocumentPageObject.ArchiveAlertMessage));	
						Assert.assertEquals(AddDocumentPageObject.ArchiveAssertText20,"Archived");
						System.out.println("VerifyArchiveDocumentFromMoreDropdwon ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyArchiveDocumentFromMoreDropdwon()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyArchiveDocumentFromMoreDropdwon", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to UnArchive documents from document management screen, this is dependent on VerifyArchiveDocumentFromMoreDropdwon
				@Test(priority=14,dataProvider = "getTestDataForVerifyUnArchiveDocument")
				public void VerifyUnArchiveDocument(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyUnArchiveDocument", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyUnArchiveDocument Test Starts");
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    DocumentManagementPageObject=DocumentManagementPage.UnArchiveDocument(TestDataSet.get("HeadlineValue"), TestDataSet.get("FolderNameValue"));
						Assert.assertTrue(DocumentManagementPageObject.DocumentManagementAssertText6.contains(AddDocumentPageObject.UnArchiveAlertMessage));	
						Assert.assertEquals(DocumentManagementPageObject.DocumentManagementAssertText8,"False");
						System.out.println("VerifyUnArchiveDocument ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyUnArchiveDocument()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyUnArchiveDocument", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to add and publish document and Archive successfully
				@Test(priority=15,dataProvider = "getTestDataForVerifyPublishAndArchiveDocument")
				public void VerifyPublishAndArchiveDocument(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyPublishAndArchiveDocument", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyPublishAndArchiveDocument Test Starts"); 
					    
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						DocumentManagementPage.NavigateToCreateDocument(TestDataSet.get("FolderNameValue"));
						AddDocumentPage.EnterDataForNewDocument_HtmlPage(TestDataSet.get("HeadlineValue"),TestDataSet.get("TextValue"),TestDataSet.get("DraftValue"),TestDataSet.get("SubtitleValue"));
						AddDocumentPageObject=AddDocumentPage.PublishDraft(TestDataSet.get("HeadlineValue"));
						DocumentManagementPageObject=DocumentManagementPage.ArchiveDocument_DMS(TestDataSet.get("HeadlineValue"), TestDataSet.get("FolderNameValue"));
						Assert.assertEquals(DocumentManagementPageObject.DocumentManagementAssertText10,"Archived");	
						
						System.out.println("VerifyPublishAndArchiveDocument ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyPublishAndArchiveDocument()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyPublishAndArchiveDocument", BasePage.xls);
					return Data;
				}
				
				//Verify user is able Unpublish an document successfully
				@Test(priority=16,dataProvider = "getTestDataForVerifyUnPublishDocument")
				public void VerifyUnPublishDocument(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyUnPublishDocument", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyUnPublishDocument Test Starts"); 
					    
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						DocumentManagementPageObject=DocumentManagementPage.UnPublishDocument_DMS(TestDataSet.get("HeadlineValue"), TestDataSet.get("FolderNameValue"));
						Assert.assertEquals(DocumentManagementPageObject.DocumentManagementAssertText12,"Approved");	
						Assert.assertTrue(DocumentManagementPageObject.DocumentManagementAssertText11.contains(DocumentManagementPageObject.UnPublish_label));	
						System.out.println("VerifyUnPublishDocument ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyUnPublishDocument()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyUnPublishDocument", BasePage.xls);
					return Data;
				}
				
				//Verify user is able Delete a document successfully
				@Test(priority=17,dataProvider = "getTestDataForVerifyDeleteDocument_DMS")
				public void VerifyDeleteDocument_DMS(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyDeleteDocument_DMS", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyDeleteDocument_DMS Test Starts"); 
					    
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						DocumentManagementPageObject=DocumentManagementPage.DeleteDocument_DMS(TestDataSet.get("HeadlineValue"), TestDataSet.get("FolderNameValue"));
						Assert.assertEquals(DocumentManagementPageObject.DocumentManagementAssertText14,"False");	
						Assert.assertTrue(DocumentManagementPageObject.DocumentManagementAssertText13.contains(DocumentManagementPageObject.DeleteDocumentLabel));	
						System.out.println("VerifyDeleteDocument_DMS ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyDeleteDocument_DMS()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyDeleteDocument_DMS", BasePage.xls);
					return Data;
				}
				
				//Verify user is able create new draft from this document a document successfully
				@Test(priority=17,dataProvider = "getTestDataForVerifyNewDraftFromDocument_DMS")
				public void VerifyNewDraftFromDocument_DMS(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyNewDraftFromDocument_DMS", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyNewDraftFromDocument_DMS Test Starts"); 
					    
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						DocumentManagementPage.NewDocumentDraft_Document(TestDataSet.get("HeadlineValue"), TestDataSet.get("FolderNameValue"));
						AddDocumentPageObject=AddDocumentPage.SaveDocument_NDD(TestDataSet.get("HeadlineValue"));
						DocumentAssertText3=TestDataSet.get("HeadlineValue")+"(copy)";
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText21,DocumentAssertText3);	
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText22,"Draft");	
						System.out.println("VerifyNewDraftFromDocument_DMS ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyNewDraftFromDocument_DMS()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyNewDraftFromDocument_DMS", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to add template successfully
				@Test(priority=18,dataProvider = "getTestDataForVerifyAddTemplate")
				public void VerifyAddTemplate(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyAddTemplate", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyAddTemplate Test Starts"); 
					    
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						DocumentManagementPage.NavigateToManageTemplatePage();
						ManageTemplateListPage.ClickOnAddTemplate();
						TemplateAssertText4=AddTemplatePage.EnterTemplateDetailsAndSave(TestDataSet.get("TemplateNameValue"),TestDataSet.get("DescrptionValue"));
						Assert.assertEquals(TemplateAssertText4,TestDataSet.get("TemplateNameValue"));
						System.out.println("VerifyAddTemplate ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyAddTemplate()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyAddTemplate", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to add signature successfully
				@Test(priority=19,dataProvider = "getTestDataForVerifyAddSignature")
				public void VerifyAddSignature(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyAddSignature", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyAddSignature Test Starts"); 
					    
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    SignatureAssertText5=DocumentManagementPage.NavigateToManageSignaturePage();
					    SignatureAssertText6=ManageSignatureList.ClickOnAddSignature();
					    SignatureAssertText7=AddSignaturePage.EnterSignatureDetailsAndSubmit(TestDataSet.get("LabelValue"),TestDataSet.get("NameValue"),TestDataSet.get("AssociationValue"),TestDataSet.get("AddressValue"),
					    		TestDataSet.get("AddressValue2"),TestDataSet.get("CityValue"),TestDataSet.get("ZipValue"),TestDataSet.get("StateValue"),TestDataSet.get("Phone1Value"),TestDataSet.get("Phone2Value"),
					    		TestDataSet.get("FaxValue"),TestDataSet.get("EmailValue"));
						Assert.assertEquals(TemplateAssertText4,TestDataSet.get("TemplateNameValue"));
						System.out.println("VerifyAddSignature ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyAddSignature()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyAddSignature", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to merge signature successfully
				@Test(priority=20)
				public void VerifyMergeSignature()
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyMergeSignature", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyMergeSignature Test Starts"); 
					    
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    DocumentManagementPage.NavigateToManageSignaturePage();
					    SignatureAssertText8=ManageSignatureList.SelectCheckboxForMergeSignature();
					    MergeSignaturePageObject=MergeSignaturePage.MergeSignature();
						Assert.assertEquals(MergeSignaturePageObject.MergeSignatureAssertText2,"True");
						Assert.assertEquals(MergeSignaturePageObject.MergeSignatureAssertText4,"True");
						Assert.assertEquals(SignatureAssertText8,"Merge Signature");
						System.out.println("VerifyMergeSignature ends");
				}
				
				//Verify user is able to send document in notification successfully
				@Test(priority=21,dataProvider = "getTestDataForVerifySendDocumentAsNotification")
				public void VerifySendDocumentAsNotification(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifySendDocumentAsNotification", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifySendDocumentAsNotification Test Starts"); 
					    
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    DocumentManagementPage.ViewAndApproveDocument(TestDataSet.get("HeadlineValue"), TestDataSet.get("FolderNameValue"));
					    DocumentAssertText10=AddDocumentPage.ClickOnSend();
					    SendNotificationPage.SwtichToManualTab();
					    SendNotificationPage.SelectDirectory(TestDataSet.get("DirectoryNameValue"));
					    //DocumentAssertText11=SendNotificationPage.SelectContact(TestDataSet.get("FirstNameValue"), TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"));
					    //SearchContactPopUpPage.SelectFirstContactInGrid();
					    DocumentAssertText12=SendNotificationPage.EnterDataAndSendNotification(TestDataSet.get("TitleValue"), TestDataSet.get("BodyTextValue"));
					    //DocumentAssertText13=SendNotificationPage.VerifySentNotification();
						Assert.assertEquals(DocumentAssertText10,"Send Notification");
						Assert.assertEquals(DocumentAssertText11,TestDataSet.get("FirstNameValue")+ " "+TestDataSet.get("LastNameValue")+" - "+ TestDataSet.get("EmailValue"));
						Assert.assertEquals(DocumentAssertText12,"Send Notification");
						//Assert.assertEquals(DocumentAssertText13,TestDataSet.get("TitleValue"));
						System.out.println("VerifySendDocumentAsNotification ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifySendDocumentAsNotification()
				{
					Object[][] Data = UtilityFunctions.getData("VerifySendDocumentAsNotification", BasePage.xls);
					return Data;
				}
				
				@Test(priority=22)
				public void VerifyNavigationToArchiveMessagePage()
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyNavigationToArchiveMessagePage", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyNavigationToArchiveMessagePage Test Starts"); 
					    
					   
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    DocumentAssertText13=ArchiveMessagePage.NavigateToArchiveMessagePage();
					    Assert.assertEquals(DocumentAssertText13,"Archive Message");
						System.out.println("VerifyNavigationToArchiveMessagePage ends");
				}
				
				@Test(priority=23)
				public void VerifySaveArchiveMessagePage()
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifySaveArchiveMessagePage", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifySaveArchiveMessagePage Test Starts"); 
					    
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    DocumentAssertText14=ArchiveMessagePage.SaveArchiveMessage();
					    Assert.assertEquals(DocumentAssertText13,ArchiveMessagePage.SuccessfullMessageLabel);
						System.out.println("VerifySaveArchiveMessagePage ends");
				}
				
				//Verify user is able to add and publish document successfully
				@Test(priority=24,dataProvider = "getTestDataForVerifyPublishedDocumentDisplayedOnPublicView")
				public void VerifyPublishedDocumentDisplayedOnPublicView(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyPublishedDocumentDisplayedOnPublicView", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyPublishedDocumentDisplayedOnPublicView Test Starts"); 
					   
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						DocumentManagementPage.NavigateToCreateDocument(TestDataSet.get("FolderNameValue"));
						AddDocumentPage.EnterDataForNewDocument_HtmlPage(TestDataSet.get("HeadlineValue"),TestDataSet.get("TextValue"),TestDataSet.get("DraftValue"),TestDataSet.get("SubtitleValue"));
						AddDocumentPageObject=AddDocumentPage.PublishDraft(TestDataSet.get("HeadlineValue"));
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText4,AddDocumentPageObject.PublishDraftLabel);	
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText5,TestDataSet.get("HeadlineValue"));	
						Assert.assertEquals(AddDocumentPageObject.AddDocumentAssertText6,"Published");
						PublicViewPage.navigateToViewWebsite_FromDNN();
						DocumentAssertText17=PublicViewPage.switchToPublicView();
						DocumentAssertText18=NewsAndInfoPublicPage.navigateToFolder_UnderNewsAndInfo(TestDataSet.get("FolderNameValue"));
						DocumentAssertText19=NewsAndInfoPublicPage.validatePublishedDocumentHeadlinePresence(TestDataSet.get("HeadlineValue"));
						//DocumentAssertText20=PublicViewPage.switchToMainWindow_DNN();
						Assert.assertEquals(DocumentAssertText17,"Home");
						Assert.assertEquals(DocumentAssertText18,"Document Public View");
						Assert.assertEquals(DocumentAssertText19,TestDataSet.get("HeadlineValue"));
						System.out.println("VerifyPublishedDocumentDisplayedOnPublicView ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyPublishedDocumentDisplayedOnPublicView()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyPublishedDocumentDisplayedOnPublicView", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to view archive document on Public page successfully
				@Test(priority=25,dataProvider = "getTestDataForVerifyArchivedDocumentDisplayedOnPublicView")
				public void VerifyArchivedDocumentDisplayedOnPublicView(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyArchivedDocumentDisplayedOnPublicView", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyArchivedDocumentDisplayedOnPublicView Test Starts"); 
						DocumentAssertText21=NewsAndInfoPublicPage.viewArchivedDocument(TestDataSet.get("HeadlineValue"));
						DocumentAssertText20=PublicViewPage.switchToMainWindow_DNN();
						DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN_FromPublicView();
						Assert.assertEquals(DocumentAssertText21,TestDataSet.get("HeadlineValue"));
						Assert.assertTrue(DocumentAssertText20.contains("PIERPro"));
						System.out.println("VerifyArchivedDocumentDisplayedOnPublicView ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyArchivedDocumentDisplayedOnPublicView()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyArchivedDocumentDisplayedOnPublicView", BasePage.xls);
					return Data;
				}
				
				//Verify user is able to navigate to home page settings page successfully
				@Test(priority=26)
				public void VerifyNavigationToHomePageSettingsPage()
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyNavigationToHomePageSettingsPage", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyNavigationToHomePageSettingsPage Test Starts"); 
					    DocumentAssertText22=HomePageSettingPage.NavigateToHomePageSettings();
						Assert.assertEquals(DocumentAssertText22,HomePageSettingPage.homePageSettingsLabelMessage);
						System.out.println("VerifyNavigationToHomePageSettingsPage ends");
				}
				
				
				//Verify user is able to save home page settings page successfully
				@Test(priority=27)
				public void VerifySaveHomePageSettingsPage()
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifySaveHomePageSettingsPage", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifySaveHomePageSettingsPage Test Starts"); 
					    HomePageSettingPageObject=HomePageSettingPage.saveHomePageSettingPage();
						Assert.assertEquals(HomePageSettingPageObject.homePageSettingAssertText3,"Document Management");
						System.out.println("VerifySaveHomePageSettingsPage ends");
				}
				
				//Verify user is able to navigate to home page to verify content saved is displayed on home Page
				@Test(priority=28)
				public void VerifyDescriptionOnHomePage()
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyDescriptionOnHomePage", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyDescriptionOnHomePage Test Starts"); 
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
						PublicViewPage.navigateToViewWebsite_FromDNN();
						PublicViewPage.switchToPublicView();
						DocumentAssertText23=PublicViewPage.ValidateHomePageDescription();
						PublicViewPage.switchToMainWindow_DNN();
						DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN_FromPublicView();
						Assert.assertEquals(DocumentAssertText23,HomePageSettingPageObject.homePageSettingAssertText2);
						System.out.println("VerifyDescriptionOnHomePage ends");
				}
				
				//Verify user is able to view archive document on Public page successfully
				@Test(priority=29,dataProvider = "getTestDataForVerifyDocumentDescription")
				public void VerifyDocumentDescription(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyDocumentDescription", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					    System.out.println("VerifyDocumentDescription Test Starts"); 
					    DocumentManagementPage.NavigateToDocumentManagementPage_FromDNN();
					    DocumentManagementPage.EditFolderDescription(TestDataSet.get("FolderNameValue"),TestDataSet.get("FolderDescription"));
					    PublicViewPage.navigateToViewWebsite_FromDNN();
						PublicViewPage.switchToPublicView();
						NewsAndInfoPublicPage.navigateToFolder_UnderNewsAndInfo(TestDataSet.get("FolderNameValue"));
						DocumentAssertText24=NewsAndInfoPublicPage.validateDocumentDescription();
						Assert.assertEquals(DocumentAssertText24,TestDataSet.get("FolderDescription"));
						System.out.println("VerifyDocumentDescription ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyDocumentDescription()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyDocumentDescription", BasePage.xls);
					return Data;
				}
						
}
