package TestCases.SurveyTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.OtherModulePages.NewFeedsPage;
import Page.OtherModulePages.NewsAndInfoPublicPage;
import Page.OtherModulePages.PublicViewPage;
import Page.SurveyPages.AddAnswerSurveyPage;
import Page.SurveyPages.AddQuestionSurvey;
import Page.SurveyPages.AddSurveyPage;
import Page.SurveyPages.SurveyListPage;
import Page.SurveyPages.SurveyPublicPage;
import Page.SurveyPages.SurveyResponsePage;
import Page.SurveyPages.SurveyViewResponsesPage;
import Util.UtilityFunctions;

public class SurveyTests {

	private static String surveyAssertText1;
	private static String surveyAssertText2;
	private static String surveyAssertText3;
	private static String surveyAssertText4;
	private static String surveyAssertText5;
	private static String surveyAssertText6;
	private static String surveyAssertText7;
	private static String surveyAssertText8;
	private static String surveyAssertText9;
	private static String surveyAssertText10;
	
	AddSurveyPage AddSurveyPageObject;
	AddQuestionSurvey AddQuestionSurveyObject;
	AddAnswerSurveyPage AddAnswerSurveyPageObject;
	SurveyResponsePage SurveyResponsePageObject;
	SurveyListPage SurveyListPageObject;
	
	@Test(priority=1)
	public void verifyNavigationToSurveyListPage()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("verifyNavigationToSurveyListPage", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
			
			System.out.println("verifyNavigationToSurveyListPage starts");
			//Navigate from DNN back to ERMS survey cases run after DNN otherwise its not required
			//NewFeedsPage.navigateToNewsFeedPage_DNN();
			surveyAssertText1=SurveyListPage.navigateToSurveyListPage();
			Assert.assertEquals(surveyAssertText1, SurveyListPage.headerLabelSurveyList);
			System.out.println("verifyNavigationToSurveyListPage ends");
	
	}
	
	//Verify that user is able to add an survey and add question successfully
	@Test(priority=2,dataProvider = "getTestDataForverifyAddSurveyandQuestionSuccessfully")
	public void verifyAddSurveyandQuestionSuccessfully(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("verifyAddSurveyandQuestionSuccessfully", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("verifyAddSurveyandQuestionSuccessfully Test Starts");
		    surveyAssertText2=SurveyListPage.clickAddSurvey();
		    surveyAssertText3=AddSurveyPage.addNewSurvey(TestDataSet.get("surveyTitle"), TestDataSet.get("surveyComments"), TestDataSet.get("completionMessage"));
		    AddQuestionSurveyObject=AddQuestionSurvey.addQuestion(TestDataSet.get("surveyQuestionValue"));
		   
			Assert.assertEquals(surveyAssertText2,AddSurveyPage.addSurveyHeaderLabel);	
			Assert.assertEquals(surveyAssertText3,TestDataSet.get("surveyTitle"));	
			Assert.assertEquals(AddQuestionSurveyObject.addQuestionSurveyText2 ,AddQuestionSurveyObject.addAnswerLabel);	
			Assert.assertEquals(AddQuestionSurveyObject.addQuestionSurveyText3, AddAnswerSurveyPage.addAnswerHeaderLabel);	
			System.out.println("verifyAddSurveyandQuestionSuccessfully ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForverifyAddSurveyandQuestionSuccessfully()
	{
		Object[][] Data = UtilityFunctions.getData("verifyAddSurveyandQuestionSuccessfully", BasePage.xls);
		return Data;
	}
	
	//Verify that user is able to add survey answer successfully and validated added survey on survey list page
		@Test(priority=3,dataProvider = "getTestDataForverifyAddSurveyAnswerSuccessfully")
		public void verifyAddSurveyAnswerSuccessfully(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("verifyAddSurveyAnswerSuccessfully", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			    System.out.println("verifyAddSurveyAnswerSuccessfully Test Starts");
			    AddAnswerSurveyPageObject=AddAnswerSurveyPage.addAnswer(TestDataSet.get("SurveyAnswer1"), TestDataSet.get("SurveyAnswer2"), TestDataSet.get("surveyTitle"));
				Assert.assertEquals(AddAnswerSurveyPageObject.addAnswerAssertText1,TestDataSet.get("surveyTitle"));	
				Assert.assertEquals(AddAnswerSurveyPageObject.addAnswerAssertText2,TestDataSet.get("surveyQuestionValue"));	
				Assert.assertEquals(AddAnswerSurveyPageObject.addAnswerAssertText3 ,TestDataSet.get("surveyTitle"));	
				System.out.println("verifyAddSurveyAnswerSuccessfully ends");	
		}
		
		@DataProvider
		public Object[][] getTestDataForverifyAddSurveyAnswerSuccessfully()
		{
			Object[][] Data = UtilityFunctions.getData("verifyAddSurveyAnswerSuccessfully", BasePage.xls);
			return Data;
		}
		

				//Verify that user is able to navigate to edit an survey successfully
						@Test(priority=4,dataProvider = "getTestDataForverifyEditSurvey")
						public void verifyEditSurvey(Hashtable<String, String> TestDataSet)
						{
							//Check for runmode
							if (UtilityFunctions.IsExecutable("verifyEditSurvey", BasePage.xls)!=true)
								throw new SkipException("Run Mode Set to No");
							
							    System.out.println("verifyEditSurvey Test Starts");
							    //SurveyListPage.navigateToSurveyListPageFromDNN();
							    SurveyListPage.clickEditSurvey(TestDataSet.get("surveyTitle"));
							    surveyAssertText5=AddSurveyPage.EditSurvey(TestDataSet.get("surveyNewTitle"));
								Assert.assertEquals(surveyAssertText5,TestDataSet.get("surveyNewTitle"));	
								System.out.println("verifyEditSurvey ends");
						
						}
						
						@DataProvider
						public Object[][] getTestDataForverifyEditSurvey()
						{
							Object[][] Data = UtilityFunctions.getData("verifyEditSurvey", BasePage.xls);
							return Data;
						}
						
						//Verify that user is able to navigate to survey from edit website successfully and assert the created survey
						@Test(priority=5,dataProvider = "getTestDataForverifyNewSurveyIsDisplayed")
						public void verifyNewSurveyIsDisplayed(Hashtable<String, String> TestDataSet)
						{
							//Check for runmode
							if (UtilityFunctions.IsExecutable("verifyNewSurveyIsDisplayed", BasePage.xls)!=true)
								throw new SkipException("Run Mode Set to No");
							
							    System.out.println("verifyNewSurveyIsDisplayed Test Starts");
							    PublicViewPage.navigateToEditWebsite();
							    NewsAndInfoPublicPage.navigateToFolder_QuestionComments(TestDataSet.get("folderNameValue"));
							    surveyAssertText4=SurveyPublicPage.validateSurveyIsDisplayed(TestDataSet.get("surveyNewTitle"));
								Assert.assertEquals(surveyAssertText4,TestDataSet.get("surveyNewTitle"));	
								System.out.println("verifyNewSurveyIsDisplayed ends");
						
						}
						
						@DataProvider
						public Object[][] getTestDataForverifyNewSurveyIsDisplayed()
						{
							Object[][] Data = UtilityFunctions.getData("verifyNewSurveyIsDisplayed", BasePage.xls);
							return Data;
						}
				
						//Verify that user question and answer and are correctly displayed and user is able to submit response
						@Test(priority=6,dataProvider = "getTestDataForverifySubmitSurveyResponse")
						public void verifySubmitSurveyResponse(Hashtable<String, String> TestDataSet)
						{
							//Check for runmode
							if (UtilityFunctions.IsExecutable("verifySubmitSurveyResponse", BasePage.xls)!=true)
								throw new SkipException("Run Mode Set to No");
							
							    System.out.println("verifySubmitSurveyResponse Test Starts");
							    surveyAssertText6=SurveyPublicPage.addSurveyResponse(TestDataSet.get("surveyNewTitle"));
							    SurveyResponsePageObject=SurveyResponsePage.verifyAddedQuestionAndAnswerOnResponsePage();
								Assert.assertEquals(surveyAssertText6,SurveyResponsePage.headerSurveyResponsePageLabel);
								Assert.assertEquals(SurveyResponsePageObject.surveyResponseAssertText1,TestDataSet.get("surveyQuestionValue"));
								Assert.assertEquals(SurveyResponsePageObject.surveyResponseAssertText2,TestDataSet.get("SurveyAnswer1"));
								Assert.assertEquals(SurveyResponsePageObject.surveyResponseAssertText3,TestDataSet.get("SurveyAnswer2"));
								Assert.assertEquals(SurveyResponsePageObject.surveyResponseAssertText4,TestDataSet.get("completionMessage"));
								System.out.println("verifySubmitSurveyResponse ends");
						
						}
						
						@DataProvider
						public Object[][] getTestDataForverifySubmitSurveyResponse()
						{
							Object[][] Data = UtilityFunctions.getData("verifySubmitSurveyResponse", BasePage.xls);
							return Data;
						}
						
						//Verify that Number of survey responses received
						@Test(priority=7,dataProvider = "getTestDataForverifySurveyResponses")
						public void verifySurveyResponses(Hashtable<String, String> TestDataSet)
						{
							//Check for runmode
							if (UtilityFunctions.IsExecutable("verifySurveyResponses", BasePage.xls)!=true)
								throw new SkipException("Run Mode Set to No");
							
							    System.out.println("verifySurveyResponses Test Starts");
							    SurveyListPage.navigateToSurveyListPageFromDNN();
							    surveyAssertText7=SurveyListPage.clickSurveyResponses(TestDataSet.get("surveyNewTitle"));
							    surveyAssertText8=SurveyViewResponsesPage.validateNumberOfResponse();
								Assert.assertEquals(surveyAssertText7,TestDataSet.get("surveyNewTitle"));
								Assert.assertEquals(surveyAssertText8,"1");
								System.out.println("verifySurveyResponses ends");
						
						}
						
						@DataProvider
						public Object[][] getTestDataForverifySurveyResponses()
						{
							Object[][] Data = UtilityFunctions.getData("verifySurveyResponses", BasePage.xls);
							return Data;
						}
					
						//Verify that Number of survey responses received
						@Test(priority=8,dataProvider = "getTestDataForverifySurveyDeletion")
						public void verifySurveyDeletion(Hashtable<String, String> TestDataSet)
						{
							//Check for runmode
							if (UtilityFunctions.IsExecutable("verifySurveyDeletion", BasePage.xls)!=true)
								throw new SkipException("Run Mode Set to No");
							
							    System.out.println("verifySurveyDeletion Test Starts");
							    SurveyListPage.navigateToSurveyListPageFromDNN();
							    SurveyListPageObject=SurveyListPage.clickDeleteSurvey(TestDataSet.get("surveyNewTitle"));
								Assert.assertEquals(SurveyListPageObject.surveyListAssertText1,SurveyListPageObject.alertDeletionText);
								Assert.assertEquals(SurveyListPageObject.surveyListAssertText2,"False");
								System.out.println("verifySurveyDeletion ends");
						
						}
						
						@DataProvider
						public Object[][] getTestDataForverifySurveyDeletion()
						{
							Object[][] Data = UtilityFunctions.getData("verifySurveyDeletion", BasePage.xls);
							return Data;
						}
}
