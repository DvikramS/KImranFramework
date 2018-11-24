package Page.ContactPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;
import Util.UtilityFunctions;

public class ImportContactPage {
	private static String MenuImportContact="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Import Contacts')]";
	private static String ImportContactHeader="//*[@id='divImportContact']/div[1]/div/h1";
	private static String LookUpMasterCode="//*[@id='fileUploadForm']/div[1]/div/div/div/div[1]/p[2]/a";
	private static String LookupDetails="//*[@id='myModalLabel']";
	private static String LookupTypeDropdown="//*[@id='ddlLoopup']";
	private static String LookupSearch="//*[@id='lookupdetail']/div/div/div[2]/div[1]/div[2]/div/div[1]/span[1]/input";
	private static String OkButton="//*[@id='lookupdetail']/div/div/div[3]/a";
	private static String LookupDataGrid="//*[@id='lookupdetail']/div/div/div[2]/div[3]/div/div[2]/table/tbody/tr[1]/td[1]";
	private static String SearchIcon="//*[@id='lookupdetail']/div/div/div[2]/div[1]/div[2]/div/div[1]/span[2]/i";
	private static String CountryNameResult="//*[@id='lookupdetail']/div/div/div[2]/div[3]/div/div[2]/table/tbody/tr[1]/td[2]";
	
	private static String ImportContactAssertLabel1;
	private static String ImportContactAssertLabel2;
	
	//Page Labels for Assertion
	public static String ImportContactHeaderLabel="Import Contact";
	
	public static String NavigateToImportContactPage()
	{
		try {
			 Thread.sleep(5000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	        
		BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
        BasePage.driver.findElement(By.xpath(MenuImportContact)).click(); 
        try {
		 Thread.sleep(7000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(LookUpMasterCode);
        ImportContactAssertLabel1= BasePage.driver.findElement(By.xpath(ImportContactHeader)).getText();
        return(ImportContactAssertLabel1);
	}
	
	public static String VerifyLookupMasterCode(String LookupValue, String SearchValue)
	{
		BasePage.driver.findElement(By.xpath(LookUpMasterCode)).click();
		try {
			 Thread.sleep(2000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	        UtilityFunctions.WaitUntilPresenceOfElement(LookupDetails);
	       try{
	        Select Salutationdropdown = new Select(BasePage.driver.findElement(By.xpath(LookupTypeDropdown)));
			Salutationdropdown.selectByVisibleText(LookupValue);
			UtilityFunctions.WaitUntilPresenceOfElement(LookupDataGrid);
			BasePage.driver.findElement(By.xpath(LookupSearch)).sendKeys(SearchValue);
			BasePage.driver.findElement(By.xpath(SearchIcon)).click();
			ImportContactAssertLabel2=BasePage.driver.findElement(By.xpath(CountryNameResult)).getText();
			BasePage.driver.findElement(By.xpath(OkButton)).click();
	       }catch(Exception e)
	       {
	    	   BasePage.driver.findElement(By.xpath(OkButton)).click(); 
	       }
			return(ImportContactAssertLabel2);
	}
	
}
