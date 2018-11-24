package Page.SurveyPages;

import org.openqa.selenium.By;

import Util.UtilityFunctions;
import Base.BasePage;

public class SurveyPublicPage {

	private static String headerSurveyPage="//*[@class='DNNContainer_Title_h2 SpacingBottom']/h2/span";
	private static String headerSurveyPageLabel="ListSurvey";
	private static String addedSurveyStart="//*[@class='portlet box blue']/div/div/div/ul/li/a[contains(text(),'";
	private static String addedSurveyEnd="')]";
	
	private static String surveyPublicAssertText1;
	private static String surveyPublicAssertText2;
	private static String addedSurvey;
	
	// Validate added survey is displayed on from on survey page
	public static String validateSurveyIsDisplayed(String surveyTitle)
	{
		addedSurvey=addedSurveyStart+surveyTitle+addedSurveyEnd;
		surveyPublicAssertText1=BasePage.driver.findElement(By.xpath(addedSurvey)).getText(); 
		return(surveyPublicAssertText1);
	}
	
	public static String addSurveyResponse(String surveyNewTitle)
	{
		addedSurvey=addedSurveyStart+surveyNewTitle+addedSurveyEnd;
		BasePage.driver.findElement(By.xpath(addedSurvey)).click(); 
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(SurveyResponsePage.headerSurveyResponsePage);
		surveyPublicAssertText2=BasePage.driver.findElement(By.xpath(SurveyResponsePage.headerSurveyResponsePage)).getText();
		return(surveyPublicAssertText2);
	}
	
}
