package Page.Document;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.CommonFunctions;
import Util.UtilityFunctions;

public class ApprovalListPage {

	public static String MenuWebsite="//*[@id='ControlNav']/li[9]/a";
	private static String ApprovalList="//*[@id='ControlNav']/li/ul/ul/ul/li/ul/li/a[contains(text(),'Approval List')]";
	private static String DocumentApprovalHeader="//*[@class='row']/div/h1/div";
	public static String DocumentApprovalHeaderLabel="Document Approval";
	public static String DocumentApprovalListPageLoad="//*[@id='sm-tree']/div/ul/li/a";
	private static String StartSelectedFolderPath="//*[@id='sm-tree']/div/ul/li/a[contains(text(),'";
	private static String EndSelectedFolderPath="')]";
	private static String StartSelectUser="//*[@class='ms-selectable']/ul/li/span[contains(text(),'";
	private static String EndSelectUser="')]";
	private static String SelectUser;
	private static String StartSelectedUserPath="//*[@class='ms-selection']/ul/li/span[contains(text(),'";
	private static String EndSelectedUserPath="')]";
	private static String SelectedUser;
	private static String SavebuttonApprovalList="//*[@class='form-actions fluid']/div/a[2]";
	private static String CancelbuttonApprovalList="//*[@class='form-actions fluid']/div/a[1]";
	private static String ApprovalListSaveSuccessfulMessagePath="//*[@class='row']/div/label";
	public static String ApprovalListSaveSuccessfulMessageLabel="Approval List Settings Saved Successfully.";
	
	private static String SelectedFolder;
	
	private static String DocumentApprovalListText1;
	public static String DocumentApprovalListText2;
	public static String GetSelectedUserText;
	
	public static String NavigateToDocumentApprovalList()
	{
		 try {
			 Thread.sleep(3000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		BasePage.driver.findElement(By.xpath(MenuWebsite)).click();
        BasePage.driver.findElement(By.xpath(ApprovalList)).click(); 
        try {
		 Thread.sleep(9000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        UtilityFunctions.WaitUntilPresenceOfElement(DocumentApprovalListPageLoad);
        DocumentApprovalListText1= BasePage.driver.findElement(By.xpath(DocumentApprovalHeader)).getText();
        return(DocumentApprovalListText1);
	}
	
	public static ApprovalListPage SelectApproverForFolder(String FolderName)
	{
		SelectedFolder=StartSelectedFolderPath+FolderName+EndSelectedFolderPath;
		SelectUser=StartSelectUser+BasePage.TestConfiguration.getProperty("UserName")+EndSelectUser;
		SelectedUser=StartSelectedUserPath+BasePage.TestConfiguration.getProperty("UserName")+EndSelectedUserPath;
		
		BasePage.driver.findElement(By.xpath(SelectedFolder)).click();
		try {
			 Thread.sleep(2000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		BasePage.driver.findElement(By.xpath(SelectUser)).click();
		CommonFunctions.DoubleClickElement(SelectUser);
		GetSelectedUserText=BasePage.driver.findElement(By.xpath(SelectedUser)).getText();
		BasePage.driver.findElement(By.xpath(SavebuttonApprovalList)).click();
		 try {
			 Thread.sleep(4000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	        UtilityFunctions.WaitUntilPresenceOfElement(ApprovalListSaveSuccessfulMessagePath);
	        DocumentApprovalListText2=BasePage.driver.findElement(By.xpath(ApprovalListSaveSuccessfulMessagePath)).getText();
	        
	        return new ApprovalListPage();
	}
	
}
