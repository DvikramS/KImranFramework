package Page.Document;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.UtilityFunctions;

public class ArchiveMessagePage {

	private static String MenuArchiveMessage="//*[@id='ControlNav']/li[9]/ul/ul[1]/ul[6]/li/ul[1]/li/a";
	private static String ArchiveMesaageHeader="//*[@class='sm-report-heading clearfix']/div";
	private static String SubmitButton="//*[@id='step1']/div/div[2]/div/a[2]";
	public static String SuccessfullMessageLabel="Archive message saved successfully";
	public static String SuccessfullMessage="//*[@class='page-content dashboard-content page-accordion']/div/div/label";
	
	public static String ArchiveMessageText1;
	public static String ArchiveMessageText2;
	
	public static String NavigateToArchiveMessagePage()
	{
		
		 BasePage.driver.findElement(By.xpath(ApprovalListPage.MenuWebsite)).click();
         BasePage.driver.findElement(By.xpath(MenuArchiveMessage)).click();
       try {
		 Thread.sleep(7000);
  	 	} catch (InterruptedException e) {
			
			e.printStackTrace();
  	 	}
       UtilityFunctions.WaitUntilPresenceOfElement(ArchiveMesaageHeader);
       ArchiveMessageText1= BasePage.driver.findElement(By.xpath(ArchiveMesaageHeader)).getText();
       return(ArchiveMessageText1);
	}
	
	public static String SaveArchiveMessage()
	{
		BasePage.driver.findElement(By.xpath(SubmitButton)).click();
	       try {
	  		 Thread.sleep(4000);
	    	 	} catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	    	 	}
	       ArchiveMessageText2= BasePage.driver.findElement(By.xpath(SuccessfullMessage)).getText();
	       return(ArchiveMessageText2);   
	}
	
	
}
