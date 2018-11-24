package Page.SurveyPages;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.CommonFunctions;
import Util.UtilityFunctions;

public class AddSurveyPage {

	public static String addSurveyHeader="//*[@class='sm-report-heading clearfix']/div/span";
	public static String addSurveyHeaderLabel="Add New Survey";
	private static String title ="//*[@class='form-body']/div[1]/div/input";
	public static String editSurveyHeaderLabel="Edit Survey";
	public static String EditSurveyHeader="//*[@class='sm-report-heading clearfix']/div/span[contains(text(),'"+editSurveyHeaderLabel+"')]";
	private static String commentsTextBox="//*[@class='dnnLeft']/div/div/table/tbody/tr/td/iframe";
	private static String completionMessage="//*[@class='form-group clearfix']/div/textarea";
	private static String saveButton="//*[@class='CentralMessage form-actions text-right']/a[2]";
	private static String updateButton="//*[@class='CentralMessage form-actions text-right']/a[contains(text(),'Update')]";
	
	private static String addSurveyText;
	private static String addSurveyText2;
	private static String editedSurvey1;
	
	public static String addNewSurvey(String surveyTitle, String surveyComments, String completionMessageValue)
	{
		BasePage.driver.findElement(By.xpath(title)).sendKeys(surveyTitle); 
		CommonFunctions.EnterTextInIFrame(commentsTextBox, surveyComments);
		BasePage.driver.findElement(By.xpath(completionMessage)).sendKeys(completionMessageValue); 
		BasePage.driver.findElement(By.xpath(saveButton)).click(); 
        try {
		 Thread.sleep(5000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(AddQuestionSurvey.headerAddQuestion);
        addSurveyText= BasePage.driver.findElement(By.xpath(AddQuestionSurvey.surveyName)).getText();
        return(addSurveyText);
	}
	
	public static String EditSurvey(String surveyNewTitle)
	{
		editedSurvey1=SurveyListPage.addedSurveyStart+surveyNewTitle+SurveyListPage.addedSurveyEnd;
		
		BasePage.driver.findElement(By.xpath(title)).clear();
		BasePage.driver.findElement(By.xpath(title)).sendKeys(surveyNewTitle);  
		BasePage.driver.findElement(By.xpath(updateButton)).click(); 
        try {
		 Thread.sleep(5000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(SurveyListPage.surveyListGridLoad);
        addSurveyText2=BasePage.driver.findElement(By.xpath(editedSurvey1)).getText();
        return(addSurveyText2);
	}
}
