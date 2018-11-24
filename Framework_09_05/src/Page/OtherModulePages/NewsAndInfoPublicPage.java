package Page.OtherModulePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Base.BasePage;
import Page.Document.ManageSignatureList;
import Util.UtilityFunctions;

public class NewsAndInfoPublicPage {

	private static By menuNewsAndInfo=By.xpath("//*[@id='menu1']/li/a[contains(text(),'News and Info')]/i");
	private static String startMenuPublishedFolder="//*[@id='menu1']/li/a[contains(text(),'";
	private static String endMenuPublishedFolder="')]";
	public static String folderHeader="//*[@class='DNNContainer_Title_h2 SpacingBottom']/h2/span";
	
	private static String startPublishedDocument="//*[@id='documentList']/li/div/p/a[contains(text(),'";
	private static String endPublishedDocument="')]";
	private static String archiveLink="//*[@id='RegisterContainer']/a/span";
	private static String startArchivedDocument="//*[@id='documentList']/li/div/p[2]/a[contains(text(),'";
	private static String endArchivedDocument="')]";
	private static String folderDescription="//*[@class='DNNContainer_Title_h2 SpacingBottom']/div/div/div/div/div[3]/span";
	private static String questionAndCommentsIcon="//*[@id='menu1']/li[4]/a[contains(text(),'Questions/Comments')]/i";
	
	
	private static String folderPublished;
	private static String documentPublished;
	private static String documentArchived;
	private static String folderAssertText1;
	private static String folderAssertText2;
	private static String folderAssertText3;
	private static String folderAssertText4;
	
	public static String navigateToFolder_UnderNewsAndInfo(String folderNameValue)
	{
		folderPublished=startMenuPublishedFolder+folderNameValue+endMenuPublishedFolder;
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//((JavascriptExecutor) BasePage.driver).executeScript("$($('.dropdown-toggle')[9]).trigger('mouseover')");
		
		((JavascriptExecutor) BasePage.driver).executeScript(
				"var obj = $('.dropdown-toggle');"+
				"var targetElement;"+
				"for(var index = 0; index < obj.length; index ++)"+
		"{"+ 

					"if($(obj[index]).text().trim() == 'News and Info')"+
						"{"+
							"targetElement = obj[index];"+
							"break;"+
						"}"+

			"}"+

			"$(targetElement).trigger('mouseover');"+
				"");
				
				
		//BasePage.driver.findElement(By.xpath(menuNewsAndInfo)).click();
		BasePage.driver.findElement(By.xpath(folderPublished)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(folderHeader);
		folderAssertText1=BasePage.driver.findElement(By.xpath(folderHeader)).getText();
		return(folderAssertText1);
	}
	
	//Validate published document is present under folder
	public static String validatePublishedDocumentHeadlinePresence(String documentName)
	{
		documentPublished=startPublishedDocument+documentName+endPublishedDocument;
		
		folderAssertText2=BasePage.driver.findElement(By.xpath(documentPublished)).getText();
		return(folderAssertText2);
	}
	
	public static String viewArchivedDocument(String HeadlineValue)
	{
		documentArchived=startArchivedDocument+HeadlineValue+endArchivedDocument;
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BasePage.driver.findElement(By.xpath(archiveLink)).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(folderHeader);
		folderAssertText3=BasePage.driver.findElement(By.xpath(documentArchived)).getText();
		return(folderAssertText3);
	}
	
	//Validate published document is present under folder
		public static String validateDocumentDescription()
		{
			folderAssertText4=BasePage.driver.findElement(By.xpath(folderDescription)).getText();
			return(folderAssertText4);
		}
		
		public static String navigateToFolder_QuestionComments(String folderNameValue)
		{
			folderPublished=startMenuPublishedFolder+folderNameValue+endMenuPublishedFolder;
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			((JavascriptExecutor) BasePage.driver).executeScript("$($($('.dropdown-toggle'))[10]).trigger('mouseover')");
			/*
			((JavascriptExecutor) BasePage.driver).executeScript(
					"var obj = $('.dropdown-toggle');"+
					"var targetElement;"+
					"for(var index = 0; index < obj.length; index ++)"+
			"{"+ 

						"if($(obj[index]).text().trim() == 'Questions/Comments')"+
							"{"+
								"targetElement = obj[index];"+
								"break;"+
							"}"+

				"}"+

				"$(targetElement).trigger('mouseover');"+
					"");
			*/
			//BasePage.driver.findElement(By.xpath(questionAndCommentsIcon)).click();
			BasePage.driver.findElement(By.xpath(folderPublished)).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			UtilityFunctions.WaitUntilPresenceOfElement(folderHeader);
			folderAssertText1=BasePage.driver.findElement(By.xpath(folderHeader)).getText();
			return(folderAssertText1);
		}
}
