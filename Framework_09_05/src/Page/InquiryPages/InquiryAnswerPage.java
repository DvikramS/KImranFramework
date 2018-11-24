package Page.InquiryPages;

import org.openqa.selenium.By;

import Base.BasePage;
import Page.Document.DocumentManagementPage;
import Util.UtilityFunctions;

public class InquiryAnswerPage {
	
	private static By MenuInquiryAnswer_FromDNN=By.xpath("//*[@id='ControlNav']/li[4]/ul/ul[1]/ul/li/a[contains(text(),'Inquiry Answers')]");
	private static By MenuInquiryAnswer=By.xpath("//*[@id='ControlNav']/li[4]/ul/ul[1]/ul/li/a[contains(text(),'Inquiry Answers')]");
	
	public static String InquiryAnswerPageLoad="//*[@id='folders']/ul/li/a";
	private static By InquiryAnswerPageHeader=By.xpath("//*[@id='divInquiryAnswer']/div/div[1]/div/h1/div[1]");
	private static By InquiryAnswerCheckbox=By.xpath("//*[@id='chkEnableInquiryAnswers']");
	private static String FirstDocumentInPreviews="//*[@id='sm-full-section']/div[2]/div/div/ul/li[1]"; 
	private static String StartInquiryAnswerFolderpath="//*[@id='folders']/ul/li/a[contains(text(),'";
	private static String EndInquiryAnswerFolderpath="')]";
	private static String InquiryAnswerSuccessMessage="html/body/div[10]/div/div/p";
	
	private static String StartInquiryAnswerDocumentpath="//*[@id='sm-full-section']/div[2]/div/div/ul/li[contains(text(),'";
	private static String EndInquiryAnswerDocumentpath="')]";
	public static String InquiryAnswerHeaderLabel="Inquiry Answers";
	public static String InquiryAnswerSuccessMessageLabel="Inquiry answers saved successfully";
	private static By SaveButton=By.xpath("//*[@id='search-btn']");
	
	private static String GetInquiryAssertText1;
	private static boolean GetInquiryAssertText2;
	private static String FolderName;
	private static String GetInquiryAssertText3;
	private static String GetPublishedDocument;
	public static String GetInquiryAssertText4;
	private static String GetInquiryAssertText5;
	private static String GetInquiryAssertText6;
	
/**************************************************Function for Inquiry Answer Page ************************************************************/	
	//Navigate to Inquiry answer page from DNN
		public static String NavigateToInquiryAnswerPageFromDNN()
		{
			 BasePage.driver.findElement(By.xpath(DocumentManagementPage.MenuPIERPro_DNN)).click();
	         BasePage.driver.findElement(MenuInquiryAnswer_FromDNN).click(); 
	         try {
			 Thread.sleep(7000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
	         
	         UtilityFunctions.WaitUntilPresenceOfElement(InquiryAnswerPageLoad);
	         GetInquiryAssertText1= BasePage.driver.findElement(InquiryAnswerPageHeader).getText();
	         return(GetInquiryAssertText1);
		}
	
		//Validate presence of Enable Inquiry answer checkbox and is checked after documents is published
		public static boolean ValidateInquiryAnswerCheckboxPresence()
		{
			GetInquiryAssertText2=BasePage.driver.findElement(InquiryAnswerCheckbox).isSelected();
			return(GetInquiryAssertText2);
			}
		
		//Validate that published document is displayed under folder
		public static String ValidatePublishedDocumentIsDisplayedInAnswer(String FolderNameValue, String DocumentNameValue)
		{
			FolderName=StartInquiryAnswerFolderpath+FolderNameValue+EndInquiryAnswerFolderpath;
			GetPublishedDocument=StartInquiryAnswerDocumentpath+DocumentNameValue+EndInquiryAnswerDocumentpath;

			BasePage.driver.findElement(By.xpath(FolderName)).click();
			UtilityFunctions.WaitUntilPresenceOfElement(FirstDocumentInPreviews);
	        GetInquiryAssertText3= BasePage.driver.findElement(By.xpath(GetPublishedDocument)).getText();
	        return(GetInquiryAssertText3);
		}
		
		public static String InquiryAnswerIsSavedSuccessfully()
		{
			BasePage.driver.findElement(SaveButton).click();
			UtilityFunctions.WaitUntilPresenceOfElement(InquiryAnswerSuccessMessage);
	        GetInquiryAssertText4= BasePage.driver.findElement(By.xpath(InquiryAnswerSuccessMessage)).getText();
	        try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        return(GetInquiryAssertText4);
		}
		
		
}
