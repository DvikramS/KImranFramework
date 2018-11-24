package Page.Document;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.CommonFunctions;
import Util.UtilityFunctions;

public class BulkArchiveDocumentPage {
	
	private static String menuBulkArchiveDocuments="//*[@id='ControlNav']/li/ul/ul/ul/li/ul/li/a[contains(text(),'Bulk Archive Documents')]";
	
	private static String headerBulkArchiveDocuments="//*[@class='page-content dashboard-content page-accordion']/div/div/h1/div";
	public static String labelHeaderBulkArchiveDocuments="Bulk Archive Documents";
	private static String selectDocumentFolderStart="//*[@class='form-group']/div/div/select/option[contains(text(),'";
	private static String selectDocumentFolderEnd="')]";
	private static String andCalendarIcon="//*[@id='step1']/div/div[1]/div/div[2]/div[2]/div/div/span/button/i";
	private static String selectAndDateStart="//*[@id='Body']/div[3]/div[1]/table/tbody/tr/td[text()='";
	private static String selectAndDateEnd="')]";
	private static String submitButton="//*[@class='form-actions fluid']/div/a[2]";
	public static String label1="Use the check boxes to select which documents you would like to archive and hit the 'Archive Now' button to commit.";
	private static String clearButton="//*[@id='Body']/div[3]/div[1]/table/tfoot/tr[2]/th";
	
	private static String archiveButton="//*[@class='table table-striped table-bordered table-advance table-incident']/thead/tr/th/input";
	public static String labelArchive="//*[@class='portlet box blue']/div/h4";
	private static String successMessageArchive="//*[@class='page-content dashboard-content page-accordion']/div/div/label";
	public static String successMessageArchiveLabel="Documents archived successfully.";
	
	private static String bulkArchiveAssetText1;
	private static String bulkArchiveAssetText2;
	private static String bulkArchiveAssetText3;
	private static String selectFolder;
	private static int getcurrentdate1;
	private static String currentdate;
	
/******************************************** Bulk Archive Documents functions************************************************************/	
	public static String navigateToBulkArchiveDocumentsPage()
	{
		 BasePage.driver.findElement(By.xpath(ApprovalListPage.MenuWebsite)).click();
         BasePage.driver.findElement(By.xpath(menuBulkArchiveDocuments)).click(); 
         try {
		 Thread.sleep(7000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
         
         UtilityFunctions.WaitUntilPresenceOfElement(headerBulkArchiveDocuments);
         bulkArchiveAssetText1= BasePage.driver.findElement(By.xpath(headerBulkArchiveDocuments)).getText();
         return(bulkArchiveAssetText1);
	}
	
	//Validate user is able to search a documents for particular dates for a folder successfully
	public static String validateSearhDocumentsOnbulkArchive(String FolderNameValue)
	{
		 selectFolder=selectDocumentFolderStart+FolderNameValue +selectDocumentFolderEnd;
		 getcurrentdate1=CommonFunctions.getCurrentDate();
		 currentdate=selectAndDateStart+getcurrentdate1+selectAndDateEnd;
		 
		 BasePage.driver.findElement(By.xpath(selectFolder)).click();
         BasePage.driver.findElement(By.xpath(andCalendarIcon)).click(); 
         try {
    		 Thread.sleep(2000);
        	 } catch (InterruptedException e) {
      			
      			e.printStackTrace();
      		}
         BasePage.driver.findElement(By.xpath(clearButton)).click(); 
         BasePage.driver.findElement(By.xpath(submitButton)).click(); 
         try {
		 Thread.sleep(7000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
         
         UtilityFunctions.WaitUntilPresenceOfElement(archiveButton);
         bulkArchiveAssetText2= BasePage.driver.findElement(By.xpath(labelArchive)).getText();
         return(bulkArchiveAssetText2);
	}
	
	//Validate user archive all documents successfully
		public static String validatebulkArchive()
		{

			 BasePage.driver.findElement(By.xpath(archiveButton)).click();
	         try {
			 Thread.sleep(5000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
	         
	         UtilityFunctions.WaitUntilPresenceOfElement(successMessageArchive);
	         bulkArchiveAssetText3= BasePage.driver.findElement(By.xpath(successMessageArchive)).getText();
	         return(bulkArchiveAssetText3);
		}
	
	
}
