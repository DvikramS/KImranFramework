package Page.InquiryPages;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.UtilityFunctions;

public class InquiryDashboardPage {

	private static String MenuInquiryDashboard="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Inquiry Dashboard')]";
	private static String InquiryDashboardAssertLabel="//*[@id='divInquiryList']/div/div/div/h1[contains(text(),'Inquiry Dashboard')]";
	private static String InquiryDashboardLoadAssert="//*[@id='divInquiryList']/div[2]/div[4]/div/div[1]/div[1]/span";
	private static String InquiryDashboardAssertLabel1;
	
	//Variables defined for VerifyDirectoryNameIsClickable
	private static String directoryAllCount="//*[@id='directoryRecords']/table/tbody/tr[1]/td[5]/a";
	private static String directoryName="//*[@id='directoryRecords']/table/tbody/tr[1]/td[1]/a";
	private static String getDirectoryCount;
	private static String InquiryDashboardAssertLabel2;
	
	//Variables defined for VerifyDirectoryNameIsClickable
	private static String CatgeoryAllCount="//*[@id='categoryRecords']/table/tbody/tr[1]/td[5]/a";
	private static String CategoryName="//*[@id='categoryRecords']/table/tbody/tr[1]/td[1]/a";
	private static String getCategoryCount;
	private static String InquiryDashboardAssertLabel3;
	
	//Variables defined for VerifyExcerptIsClickable
	private static String ExcerptText="//*[@id='divInquiryList']/div[2]/div[4]/div/div[2]/div[1]/table/tbody/tr[1]/td[3]/a";
	private static String getExcerptText;
	private static String AssertExcerptText;
	private static String InquiryDashboardAssertLabel4;
	
	//Variable defined for See All Records inquiry list
	private static String InquiryListCount="//*[@id='divInquiryList']/div[2]/div[4]/div/div/div[contains(text(),'Inquiry List')]/span";
	private static String getInquiryListCount;
	private static String InquiryListSeeAllRecords="//*[@id='divInquiryList']/div[2]/div[4]/div/div[2]/div[4]/div/a[contains(text(),'See All Records')]";
	private static String InquiryDashboardAssertLabel5;
	
	//Variables defined for Inquiry List Option
	public static String InquiryListOptionList="//*[@id='divInquiryList']/div[2]/div[4]/div/div[1]/div[3]/div/a/i";
	public static String InquiryListOptionListOptions;
	
	public static String NavigateToInquiryDashboardPage()
	{
		BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
        BasePage.driver.findElement(By.xpath(MenuInquiryDashboard)).click(); 
        try {
		 Thread.sleep(7000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(InquiryDashboardLoadAssert);
        InquiryDashboardAssertLabel1= BasePage.driver.findElement(By.xpath(InquiryDashboardAssertLabel)).getText();
        return(InquiryDashboardAssertLabel1);
	}
	
	public static String VerifyDirectoryNameIsClickable()
	{
		getDirectoryCount=BasePage.driver.findElement(By.xpath(directoryAllCount)).getText();
		BasePage.driver.findElement(By.xpath(directoryName)).click();
		try {
			 Thread.sleep(7000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	        
	        UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiryPage.SearchInquiry_InquiryListGridLoad);
	        InquiryDashboardAssertLabel2= BasePage.driver.findElement(By.xpath(SearchInquiryPage.CountOnSearchInquiryPage)).getText();
	       // System.out.println(getDirectoryCount + "   "+ InquiryDashboardAssertLabel2);
	        if(getDirectoryCount.equals(InquiryDashboardAssertLabel2))
				return("True");
			else
				return("False");	
	}
	
	public static String VerifyCategoryNameIsClickable()
	{
		getCategoryCount=BasePage.driver.findElement(By.xpath(CatgeoryAllCount)).getText();
		BasePage.driver.findElement(By.xpath(CategoryName)).click();
		try {
			 Thread.sleep(7000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	        
	        UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiryPage.SearchInquiry_InquiryListGridLoad);
	        InquiryDashboardAssertLabel3= BasePage.driver.findElement(By.xpath(SearchInquiryPage.CountOnSearchInquiryPage)).getText();
	       // System.out.println(getCategoryCount + "   "+ InquiryDashboardAssertLabel3);
	        if(getCategoryCount.equals(InquiryDashboardAssertLabel3))
				return("True");
			else
				return("False");	
	}
	
	public static String InquiryListExcerptIsClickable()
	{
		getExcerptText=BasePage.driver.findElement(By.xpath(ExcerptText)).getText();
		BasePage.driver.findElement(By.xpath(ExcerptText)).click();
		try {
			 Thread.sleep(7000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	        
	        UtilityFunctions.WaitUntilPresenceOfElement(InquiryDetailsPage.InquiryDetailPageLoadAssertPoint);
	        InquiryDashboardAssertLabel4= BasePage.driver.findElement(By.xpath(InquiryDetailsPage.InquiryTextLabel)).getText();
	        if(getExcerptText.equals(InquiryDashboardAssertLabel4))
				return("True");
			else
				return("False");	
	}
	
	//Verify Inquiry list count and on search inquiry are equal
	public static String ClickSeeAllRecordsInquiryList()
	{
		getInquiryListCount=BasePage.driver.findElement(By.xpath(InquiryListCount)).getText();
		try {
			 Thread.sleep(3000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		BasePage.driver.findElement(By.xpath(InquiryListSeeAllRecords)).click();
		try {
			 Thread.sleep(7000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	        
	        UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiryPage.SearchInquiry_InquiryListGridLoad);
	        InquiryDashboardAssertLabel5= BasePage.driver.findElement(By.xpath(SearchInquiryPage.CountOnSearchInquiryPage)).getText();
	        if(getInquiryListCount.equals(InquiryDashboardAssertLabel5))
				return("True");
			else
				return("False");	
	}
	
	public static void SelectInquiryListOptions(String OptionValue)
	{
		InquiryListOptionListOptions="//*[@id='divInquiryList']/div[2]/div[4]/div/div[1]/div[3]/div/ul/li/a[contains(text(),'"+OptionValue+"')]";
		
		BasePage.driver.findElement(By.xpath(InquiryListOptionList)).click();
		BasePage.driver.findElement(By.xpath(InquiryListOptionListOptions)).click();
		try {
			 Thread.sleep(7000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	        
	 }
	
		
	
}
