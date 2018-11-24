package Page.SurveyPages;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.UtilityFunctions;

public class AddAnswerSurveyPage {

	public static String addAnswerHeaderLabel="Add Answer";
	public static String addAnswerHeader="//*[@class='DNNModuleContent ModPierSurveyPierSurveyC']/div/h2/span[contains(text(),'"+addAnswerHeaderLabel+"')]";
	private static String addedSurveyNameText="//*[@class='DNNModuleContent ModPierSurveyPierSurveyC']/div[1]/h1[1]/div[1]/small/span";
	private static String addedQuestionNameText="//*[@class='DNNModuleContent ModPierSurveyPierSurveyC']/div[1]/h1[2]/div[1]/small/span";
	private static String answerTextbox="//*[@class='form-group clearfix']/div/input";
	private static String saveButton="//*[@class='form-actions fluid']/div/a";
	private static String surveyListButton="//*[@class='reports-config-btns form-action-btns sm-top-form-action-btns pull-right']/span/a[1]";
	
	
	public static String addAnswerAssertText1;
	public static String addAnswerAssertText2;
	public static String addAnswerAssertText3;
	private static String addedSurvey;
	
	public static AddAnswerSurveyPage addAnswer(String SurveyAnswer1, String SurveyAnswer2, String surveyTitle)
	{
		addedSurvey=SurveyListPage.addedSurveyStart+surveyTitle+SurveyListPage.addedSurveyEnd;
		
		addAnswerAssertText1=BasePage.driver.findElement(By.xpath(addedSurveyNameText)).getText(); 
		addAnswerAssertText2=BasePage.driver.findElement(By.xpath(addedQuestionNameText)).getText(); 
		BasePage.driver.findElement(By.xpath(answerTextbox)).sendKeys(SurveyAnswer1); 
		BasePage.driver.findElement(By.xpath(saveButton)).click(); 
        try {
		 Thread.sleep(7000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        UtilityFunctions.WaitUntilPresenceOfElement(surveyListButton);
       
        // adding second answer
        BasePage.driver.findElement(By.xpath(answerTextbox)).sendKeys(SurveyAnswer2); 
		BasePage.driver.findElement(By.xpath(saveButton)).click(); 
        try {
		 Thread.sleep(7000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        UtilityFunctions.WaitUntilPresenceOfElement(surveyListButton);
        BasePage.driver.findElement(By.xpath(surveyListButton)).click(); 
        try {
   		 Thread.sleep(7000);
      	 } catch (InterruptedException e) {
    			
    			e.printStackTrace();
    		}
           UtilityFunctions.WaitUntilPresenceOfElement(SurveyListPage.surveyListGridLoad);
           addAnswerAssertText3=BasePage.driver.findElement(By.xpath(addedSurvey)).getText();
           return new AddAnswerSurveyPage();
	}
}
