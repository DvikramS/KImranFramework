package Page.SurveyPages;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.UtilityFunctions;

public class SurveyResponsePage {

	public static String headerSurveyResponsePage="//*[@class='portlet box blue sm-border-none']/div/div/h5/span/p";
	public static String headerSurveyResponsePageLabel="Survey comments";
	
	private static String questionLabel="//*[@class='portlet box blue sm-border-none']/div[1]/div/div[1]/div/label/span";
	private static String addedAnswer1="//tbody/tr/td/label[1]";
	private static String addedAnswer2="//tbody/tr[2]/td/label[1]";
	private static String submitButton="//*[@class='portlet box blue sm-border-none']/div/div/div[2]/div/a[2]";
	
	//Elements after response submittion
	private static String surveyConifrmationAssert="//*[@id='lblSurveyList']";
	private static String completionMessage="//*[@class='portlet box blue']/div/div/div[2]";
	
	public static String surveyResponseAssertText1;
	public static String surveyResponseAssertText2;
	public static String surveyResponseAssertText3;
	public static String surveyResponseAssertText4;
	
	//Verify added question and answers on survey response page
	public static SurveyResponsePage verifyAddedQuestionAndAnswerOnResponsePage()
	{
		surveyResponseAssertText1=BasePage.driver.findElement(By.xpath(questionLabel)).getText();
		surveyResponseAssertText2=BasePage.driver.findElement(By.xpath(addedAnswer1)).getText();
		surveyResponseAssertText3=BasePage.driver.findElement(By.xpath(addedAnswer2)).getText();
		BasePage.driver.findElement(By.xpath(submitButton)).click();
		try {
			 Thread.sleep(7000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	        
	        UtilityFunctions.WaitUntilPresenceOfElement(surveyConifrmationAssert);
	        surveyResponseAssertText4= BasePage.driver.findElement(By.xpath(completionMessage)).getText();
	        return new SurveyResponsePage();
	}
}
