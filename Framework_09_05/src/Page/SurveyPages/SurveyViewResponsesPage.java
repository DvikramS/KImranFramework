package Page.SurveyPages;

import org.openqa.selenium.By;

import Util.UtilityFunctions;
import Base.BasePage;

public class SurveyViewResponsesPage {

	public static String displayedSurveyName="//*[@class='DNNContainer_Title_h2 SpacingBottom']/div/div/div/h1/div/small/span";
	private static String firstQuestionLink="//*[@class='table table-striped table-bordered table-advance table-incident']/tbody/tr/td/a";
	private static String numberOfResponses="//*[@class='DNNContainer_Title_h2 SpacingBottom']/div/div/div/span[2]";
	
	public static String surveyResponseAssertText1;
	
	public static String validateNumberOfResponse()
	{
		BasePage.driver.findElement(By.xpath(firstQuestionLink)).click(); 
        try {
		 Thread.sleep(5000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        UtilityFunctions.WaitUntilPresenceOfElement(displayedSurveyName);
        surveyResponseAssertText1= BasePage.driver.findElement(By.xpath(numberOfResponses)).getText();
        return(surveyResponseAssertText1); 
        
	}
}
