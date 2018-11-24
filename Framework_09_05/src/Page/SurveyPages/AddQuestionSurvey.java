package Page.SurveyPages;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.UtilityFunctions;

public class AddQuestionSurvey {

	public static String headerAddQuestion="//*[@class='DNNContainer_Title_h2 SpacingBottom']/div/div/div/h2/span";
	private static String questionTextbox="//*[@class='portlet box blue']/div/div/div[1]/div/input";
	private static String saveButon="//*[@class='form-actions fluid']/div/a";
	public static String surveyName="//*[@class='sm-report-heading clearfix']/div/small/span";
	
	private static String addAnswerButton="//*[@class='col-sm-12 text-right']/a[contains(text(),'Add Answer')]";
	public static String addAnswerLabel="Add Answer";
	
	
	public static String addQuestionSurveyText1;
	public static String addQuestionSurveyText2;
	public static String addQuestionSurveyText3;
	
	public static AddQuestionSurvey addQuestion(String surveyQuestionValue)
	{
		addQuestionSurveyText1=BasePage.driver.findElement(By.xpath(surveyName)).getText();
        BasePage.driver.findElement(By.xpath(questionTextbox)).sendKeys(surveyQuestionValue); 
        BasePage.driver.findElement(By.xpath(saveButon)).click();
        try {
		 Thread.sleep(5000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(addAnswerButton);
        addQuestionSurveyText2= BasePage.driver.findElement(By.xpath(addAnswerButton)).getText();
        BasePage.driver.findElement(By.xpath(addAnswerButton)).click();
        try {
   		 Thread.sleep(5000);
      	 } catch (InterruptedException e) {
    			
    			e.printStackTrace();
    		}
           
           UtilityFunctions.WaitUntilPresenceOfElement(AddAnswerSurveyPage.addAnswerHeader);
           addQuestionSurveyText3= BasePage.driver.findElement(By.xpath(AddAnswerSurveyPage.addAnswerHeader)).getText();
           return new AddQuestionSurvey();
	}
}
