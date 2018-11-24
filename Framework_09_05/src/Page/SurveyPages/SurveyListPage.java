package Page.SurveyPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import Base.BasePage;
import Page.Document.DocumentManagementPage;
import Util.CommonFunctions;
import Util.UtilityFunctions;

public class SurveyListPage {

	private static String menuSurvey="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Surveys')]";
	private static String menuSurvey_DNN="//*[@id='ControlNav']/li/ul/ul/ul/li/a[contains(text(),'Surveys')]";
	private static String headerSurveyList="//*[@class='col-md-12 incident-wizard']/h1/div[1]";
	public static String headerLabelSurveyList="Surveys";
	private static String addSurveyIcon="//*[@class='reports-config-btns form-action-btns sm-top-form-action-btns pull-right']/span/a/i";
	public static String surveyListGridLoad="//*[@class='table table-striped table-bordered table-advance table-incident']/tbody/tr[1]/td[1]";
	public static String addedSurveyStart="//*[@class='table table-striped table-bordered table-advance table-incident']/tbody/tr/td/span[contains(text(),'";
	public static String addedSurveyEnd="')]";
	private static String startEditSurveyIcon="//*[@class='table table-striped table-bordered table-advance table-incident']/tbody/tr/td/span[contains(text(),'";
	private static String endEditSurveyIcon="')]/ancestor::tr[1]/td[4]/a[1]/i";
	private static String startSurveyResponseIcon="//*[@class='table table-striped table-bordered table-advance table-incident']/tbody/tr/td/span[contains(text(),'";
	private static String endSurveyResponseIcon="')]/ancestor::tr[1]/td[4]/a[4]/i";
	private static String startSurveyDeleteIcon="//*[@class='table table-striped table-bordered table-advance table-incident']/tbody/tr/td/span[contains(text(),'";
	private static String endSurveyDeleteIcon="')]/ancestor::tr[1]/td[4]/a[2]/i";
	public static String alertDeletionText="Are you sure you want to delete this Survey?";
	
	private static String surveyAssertText;
	private static String editSurveyIcon;
	private static String surveyResponseIcon;
	private static String surveyDeleteIcon;
	public static String surveyListAssertText1;
	public static String surveyListAssertText2;
	
	public static String navigateToSurveyListPage()
	{
		 BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
         BasePage.driver.findElement(By.xpath(menuSurvey)).click(); 
         try {
		 Thread.sleep(10000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
         
         BasePage.driver.findElement(By.xpath(DocumentManagementPage.MenuPIERPro_DNN)).click();
         BasePage.driver.findElement(By.xpath(menuSurvey_DNN)).click(); 
         try {
		 Thread.sleep(8000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
         
         UtilityFunctions.WaitUntilPresenceOfElement(headerSurveyList);
         surveyAssertText= BasePage.driver.findElement(By.xpath(headerSurveyList)).getText();
         return(surveyAssertText);
	}
	
	public static String navigateToSurveyListPageFromDNN()
	{
         BasePage.driver.findElement(By.xpath(DocumentManagementPage.MenuPIERPro_DNN)).click();
         BasePage.driver.findElement(By.xpath(menuSurvey_DNN)).click(); 
         try {
		 Thread.sleep(8000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
         
         UtilityFunctions.WaitUntilPresenceOfElement(headerSurveyList);
         surveyAssertText= BasePage.driver.findElement(By.xpath(headerSurveyList)).getText();
         return(surveyAssertText);
	}
	
	public static String clickAddSurvey()
	{
		BasePage.driver.findElement(By.xpath(addSurveyIcon)).click(); 
        try {
		 Thread.sleep(5000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(AddSurveyPage.addSurveyHeader);
        surveyAssertText= BasePage.driver.findElement(By.xpath(AddSurveyPage.addSurveyHeader)).getText();
        return(surveyAssertText);
	}
	
	public static String clickEditSurvey(String surveyTitle)
	{
		editSurveyIcon=startEditSurveyIcon+surveyTitle+endEditSurveyIcon;
		BasePage.driver.findElement(By.xpath(editSurveyIcon)).click(); 
        try {
		 Thread.sleep(5000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(AddSurveyPage.EditSurveyHeader);
        surveyAssertText= BasePage.driver.findElement(By.xpath(AddSurveyPage.EditSurveyHeader)).getText();
        return(surveyAssertText);
	}
	
	public static String clickSurveyResponses(String surveyTitle)
	{
		surveyResponseIcon=startSurveyResponseIcon+surveyTitle+endSurveyResponseIcon;
		BasePage.driver.findElement(By.xpath(surveyResponseIcon)).click(); 
        try {
		 Thread.sleep(5000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(SurveyViewResponsesPage.displayedSurveyName);
        surveyAssertText= BasePage.driver.findElement(By.xpath(SurveyViewResponsesPage.displayedSurveyName)).getText();
        return(surveyAssertText);
	}
	
	public static SurveyListPage clickDeleteSurvey(String surveyTitle)
	{
		surveyDeleteIcon=startSurveyDeleteIcon+surveyTitle+endSurveyDeleteIcon;
		BasePage.driver.findElement(By.xpath(surveyDeleteIcon)).click(); 
        try {
		 Thread.sleep(2000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        Alert alert3 = BasePage.driver.switchTo().alert();
        surveyListAssertText1=alert3.getText();
		alert3.accept();
		try {
			 Thread.sleep(7000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
        UtilityFunctions.WaitUntilPresenceOfElement(headerSurveyList);
        surveyListAssertText2= CommonFunctions.returnElementpresence(addedSurveyStart+surveyTitle+addedSurveyEnd);
        return new SurveyListPage();
	}
}

