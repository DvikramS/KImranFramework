package Page.InquiryPages;

import java.util.Calendar;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.UtilityFunctions;

public class InquiryCategoryReportPage {

	private static String MenuInquiryCategoryReport="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Inquiry Category Report')]";
	private static String InquiryCategoryReportAssertLabel1="//*[@id='divInquiryCategoryList']/div/div/div/h1[contains(text(),'Inquiry Category Report')]";
	private static String FromDateCalendarButton="//*[@id='divCreatedFromDate']/div/div/span/button";
	private static String FromDate="html/body/div[7]/div[1]/table/tbody/tr[1]/td[1]";
	private static String Date; 
	private static String ToDate;
	private static String SelectToDate="//*[@id='divCreatedToDate']/div/div/span/button";
	private static String SubmitButton="//*[@id='divInquiryCategoryList']/div/div/a[contains(text(),'Submit')]";
	private static String ClearSearchButton="//*[@id='divInquiryCategoryList']/div/div/a[contains(text(),'Clear Search')]";
	
	private static String InquiryCategoryReportLoadAssert="//*[@id='divInquiryCategoryList']/div[4]/div[2]/div[1]/table/thead/tr/th[1]";
	private static String InquiryCategoryReportAssertLabel2;
	
	private static String InquiryCategoryReportAssertLabel3;
	private static String CategoryName;
	
	private static String GetCategoryNewCount="//*[@id='rowBody']/td[2]/a";
	private static String GetCategoryCountOnInquirySearchPage;
	private static String CategoryNewCount;
	private static String SearchinquiryAssertGrid="//*[@id='rowBody']/td[1]";
	private static String CountOnSearchInquiryPage="//*[@id='divInquiryList']/div[2]/div[1]/div[2]/div[2]/div/div[4]/div/div[1]/div/div/span[3]";
	private static String CategoryNewCount1;
	
	public static String NavigateToInquiryCategoryReport()
	{
		BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
        BasePage.driver.findElement(By.xpath(MenuInquiryCategoryReport)).click(); 
        try {
		 Thread.sleep(5000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(InquiryCategoryReportLoadAssert);
        InquiryCategoryReportAssertLabel2= BasePage.driver.findElement(By.xpath(InquiryCategoryReportAssertLabel1)).getText();
        return(InquiryCategoryReportAssertLabel2);
	}
	
	public static String SearchWithDates(String CategoryValueName)
	{
		//For finding current date part, to be used in calendar functions
		Calendar cal = Calendar.getInstance();
    	int val = cal.get(Calendar.DATE);
    	System.out.println(val);
    	 
    	ToDate="//html/body/div[7]/div[1]/table/tbody/tr/td[text()='"+val+"']";
    	CategoryName="//*[@id='rowBody']/td/a[contains(text(),'"+CategoryValueName+"')]";
    	
    	BasePage.driver.findElement(By.xpath(FromDateCalendarButton)).click();
    	BasePage.driver.findElement(By.xpath(FromDate)).click();
    	BasePage.driver.findElement(By.xpath(SelectToDate)).click();
    	BasePage.driver.findElement(By.xpath(ToDate)).click();
    	BasePage.driver.findElement(By.xpath(SubmitButton)).click();
    	
    	try {
			 Thread.sleep(3000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		UtilityFunctions.WaitUntilPresenceOfElement(InquiryCategoryReportAssertLabel1);
		InquiryCategoryReportAssertLabel3=BasePage.driver.findElement(By.xpath(CategoryName)).getText();
		return(InquiryCategoryReportAssertLabel3);
		
	}
	
	public static String CategoryClickableCounts()
	{
		try {
			 Thread.sleep(3000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		CategoryNewCount=BasePage.driver.findElement(By.xpath(GetCategoryNewCount)).getText();
		BasePage.driver.findElement(By.xpath(GetCategoryNewCount)).click();
		
		try {
			 Thread.sleep(6000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		UtilityFunctions.WaitUntilPresenceOfElement(SearchinquiryAssertGrid);
		CategoryNewCount1=BasePage.driver.findElement(By.xpath(CountOnSearchInquiryPage)).getText();
		if(CategoryNewCount.equals(CategoryNewCount1))
			return("True");
		else
			return("False");
	}
}
