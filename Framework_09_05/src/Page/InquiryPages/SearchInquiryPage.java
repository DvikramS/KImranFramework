package Page.InquiryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Util.UtilityFunctions;
import Base.BasePage;

public class SearchInquiryPage {
	
	private static String MenuSearchInquiries="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Search Inquiries')]";
	
	private static String ActionDropdowns="ActionDropdownlist";
	public static String SearchInquiry_InquiryListGridLoad="//*[@id='rowBody']/td[2]";
	public static String SearchInquiryPageLoadAssert1="//*[@id='divInquiryList']/div/div/h1[contains(text(),'Search Inquiry')]";
	private static String SearchInquiryNavigationAssert;
	private static String SubmitResponse="//*[@id='divInquiryList']/div/div/div/div/a[contains(text(),'Submit Response')]";
	private static String SubmitResponse_SendResponseToInquirer="//*[@id='response']/div/div/div[2]/div[2]/div/div[1]/div/div[4]/label/div/span";
	private static String SubmitResponse_ResponseText="//*[@id='response']/div/div/div[2]/div[3]/div/div/div[3]/div";
	private static String SubmitResponse_SubmitButton="//*[@id='response']/div/div/div[3]/button[contains(text(),'Submit')]";
	private static String SearchBox="SearchTextbox";
	private static String SearchBox_Icon="//*[@id='searchIncident']/div[2]/div[1]/span[2]/i";
	private static String InquiryID_Column="//*[@id='rowBody']/td[9]";
	public static String CountOnSearchInquiryPage="//*[@id='divInquiryList']/div[2]/div[1]/div[2]/div[2]/div/div[4]/div/div[1]/div/div/span[3]";
	public static String OptionsOnInquiryListGrid="//*[@id='ddlInquirySearch']/a/i";
	public static String MineOption="//*[@id='ddlInquirySearch']/ul/li/a[contains(text(),'Mine')]";
	public static String EditFirstInquiry="//*[@id='rowBody']/td[10]/i";
	public static String SelectGridOption;
	private static String ViewAsReportButton="//*[@id='divInquiryList']/div[2]/div[1]/div[1]/div[2]/a[2]";
	private static String StartCheckboxForInquiryInGrid="//*[@id='rowBody']/td[3]/p[contains(text(),'";
	private static String EndCheckboxForInquiryInGrid="')]/ancestor::td/preceding-sibling::td[2]/label/div/span";
	
	//Advance Search Pop-up variables
	private static String AdvanceSearchButton="//*[@id='divInquiryList']/div[2]/div[1]/div/div/a[contains(text(),'Advanced Search')]";
	private static String AdvanceSearchPopUpAssert="//*[@id='submit_form']/div[1]/div/label";
	private static String KeywordsBox="//*[@id='submit_form']/div[1]/div/div/input";
	private static String SearchButton="//*[@id='advancesearch']/div/div/div/button[contains(text(),'Search')]";
	private static String ClearButton="//*[@id='advancesearch']/div/div/div/button[contains(text(),'Clear')]";
	private static String CheckboxPendingStatus="//*[@id='chkPending']";
	
	
	//Variable for Edit Inquiry Functions
	private static String SearchInquiryAssertLabel1="//*[@id='collapseTwo']/div/div[1]/div/div/label/span[contains(text(),'Send Response to Inquirer Via')]";
	private static String SearchInquiryAssertLabel2;
	private static String SearchInquiryAssertLabel3="//*[@id='divInQuiryDetail']/div/div/h1[contains(text(),'Inquiry Detail')]";
	
	//Elements on ViewAsReport 
	private static String ReportHeader="//*[@id='divInquiryList']/div[1]/div/h1[2]";
	public static String ReportHeaderLabel="Report";
	private static String InquiryTextFirstInquiry="//*[@id='divReports']/div/div[1]/div[1]/div";
	private static String InquiryTextSecondInquiry="//*[@id='divReports']/div[2]/div[1]/div[1]/div";
	private static String CloseButton="//*[@id='divInquiryList']/div[3]/div[2]/div/a[1]";
	
	//Variables for ApplyActionDropdwon
	private static String InquiryAssoicatedCategory;
	private static String GetInquiryAssoicatedCategory;
	private static String GetInquiryAssoicatedCategoryAfter;
	private static String SelectInquirycheckbox;
	static Select ApplyActiondropdown;
	
	//Variables for ApplyActionDropdwon
	private static String InquiryAssoicatedCategory1;
	private static String GetInquiryAssoicatedCategory1;
	private static String GetInquiryAssoicatedCategory1After;
	private static String SelectInquirycheckbox1;
	static Select ApplyActiondropdown1;
	
	//Variables for Submitting multiple response
	private static String SelectInquirycheckbox3;
	private static String SelectInquirycheckbox4;
	
	//Variables for Search By Inquiry ID 
	private static String GetInquiryIDPath;
	private static String GetInquiryID;
	private static String SearchInquiryAssertLabel4;
	private static String SearchInquiryAssertLabel5;
	
	//Variables for Open Advance Search
	private static String SearchInquiryAssertLabel6;
	private static String InquiryText;
	private static String DirectoryPath;
	private static String SearchInquiryAssertLabel7;
	private static String InquiryExcerpt;
	private static String ReceivedVia="//*[@id='submit_form']/div[4]/div/div/select";
	private static String InquiryExcerpt1;
	private static String InquiryExcerpt2;
	private static String SearchInquiryAssertLabel8;
	
	private static String SearchInquiryAssertLabel9;
	private static String SearchInquiryAssertLabel10;
	private static String SearchInquiryAssertLabel11;
	private static String SearchInquiryAssertLabel12;
	public static String GetSearchInquiryAssertLabel13;
	public static String GetSearchInquiryAssertLabel14;
	public static String GetSearchInquiryAssertLabel15;
	
	public static String NavigateToSearchInquiry()
	{
		try {
			 Thread.sleep(2000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
        BasePage.driver.findElement(By.xpath(MenuSearchInquiries)).click(); 
        try {
		 Thread.sleep(5000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiry_InquiryListGridLoad);
        SearchInquiryNavigationAssert= BasePage.driver.findElement(By.xpath(SearchInquiryPageLoadAssert1)).getText();
        return(SearchInquiryNavigationAssert);
	}
	
	//Click on Edit Inquiry based on Inquiry text
	public static String EditInquiry(String QuestionValue)
	{
		String ClickEditInquiry=".//*[@id='rowBody']/td[3]/p[contains(text(),'"+ QuestionValue +"')]/ancestor::td/following-sibling::td/i";
		BasePage.driver.findElement(By.xpath(ClickEditInquiry)).click();
		
		try {
			 Thread.sleep(5000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiryAssertLabel1);
		SearchInquiryAssertLabel2=BasePage.driver.findElement(By.xpath(SearchInquiryAssertLabel3)).getText();
        return(SearchInquiryAssertLabel2);		
	}
	
	    //Click on Edit first Inquiry in list
		public static String EditFirstInquiry()
		{
			BasePage.driver.findElement(By.xpath(EditFirstInquiry)).click();
			
			try {
				 Thread.sleep(5000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
			
			UtilityFunctions.WaitUntilPresenceOfElement(InquiryDetailsPage.InquiryDetailPageLoadAssertPoint);
			SearchInquiryAssertLabel2=BasePage.driver.findElement(By.xpath(SearchInquiryAssertLabel3)).getText();
	        return(SearchInquiryAssertLabel2);		
		}
	
	public static String ApplyDropdownAction(String ActionNameValue, String InquiryText)
	{
		InquiryAssoicatedCategory="//*[@id='rowBody']/td/p[contains(text(),'"+InquiryText+"')]/ancestor::td/following-sibling::td[1]";
		SelectInquirycheckbox="//*[@id='rowBody']/td/p[contains(text(),'"+InquiryText+"')]/ancestor::td/preceding-sibling::td[2]/label/div/span";
		
		try {
			 Thread.sleep(3000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		GetInquiryAssoicatedCategory=BasePage.driver.findElement(By.xpath(InquiryAssoicatedCategory)).getText();
		System.out.println("Category::"+ GetInquiryAssoicatedCategory);
		
		 try {
			 Thread.sleep(3000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		//Selecting an inquiry for apply action
		 BasePage.driver.findElement(By.xpath(SelectInquirycheckbox)).click(); 
		
		if(GetInquiryAssoicatedCategory.equals(ActionNameValue))
			System.out.println("Action cannot be performed as attribute is already assoicated");
		else
		{
			ApplyActiondropdown = new Select(BasePage.driver.findElement(By.id(ActionDropdowns)));
			ApplyActiondropdown.selectByVisibleText(ActionNameValue);
		}
		
		 try {
			 Thread.sleep(5000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		
		GetInquiryAssoicatedCategoryAfter=BasePage.driver.findElement(By.xpath(InquiryAssoicatedCategory)).getText();
		System.out.println("Category::"+ GetInquiryAssoicatedCategoryAfter);
		 
		return(GetInquiryAssoicatedCategoryAfter);
		/*if(GetInquiryAssoicatedCategoryAfter.equals(ActionName))
			return("True");
		else
			return("False");
		*/
	}	
	
	
	public static String ApplyDropdownActionRemove(String ActionNameValue, String InquiryText)
	{
		InquiryAssoicatedCategory1="//*[@id='rowBody']/td/p[contains(text(),'"+InquiryText+"')]/ancestor::td/following-sibling::td[1]";
		SelectInquirycheckbox1="//*[@id='rowBody']/td/p[contains(text(),'"+InquiryText+"')]/ancestor::td/preceding-sibling::td[2]/label/div/span";
		
		GetInquiryAssoicatedCategory1=BasePage.driver.findElement(By.xpath(InquiryAssoicatedCategory1)).getText();
		System.out.println("Category::"+ GetInquiryAssoicatedCategory1);
		//Selecting an inquiry for apply action
		 BasePage.driver.findElement(By.xpath(SelectInquirycheckbox1)).click(); 
		
		if(GetInquiryAssoicatedCategory1.equals(ActionNameValue))
		{
			//ApplyActiondropdown1 = new Select(BasePage.driver.findElement(By.xpath("//*[@id='ActionDropdownlist']/optgroup[3])]")));
			//ApplyActiondropdown1.selectByVisibleText(ActionNameValue);
			//*[@id='ActionDropdownlist']/optgroup[3]/option[contains(text(),'AssistanceNew')]
			BasePage.driver.findElement(By.xpath("//*[@id='ActionDropdownlist']/optgroup[3]/option[contains(text(),'AssistanceNew')]")).click();
		}
		else
		{
			System.out.println("Action cannot be performed as attribute is not assoicated");	
		}
		
		 try {
			 Thread.sleep(5000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		
		GetInquiryAssoicatedCategory1After=BasePage.driver.findElement(By.xpath(InquiryAssoicatedCategory1)).getText();
		System.out.println("Category::"+ GetInquiryAssoicatedCategory1After);
		
		 if(GetInquiryAssoicatedCategory1After.isEmpty())
		 {
			 GetInquiryAssoicatedCategory1After="Blank";
		 }
		
		return(GetInquiryAssoicatedCategory1After);
		/*if(GetInquiryAssoicatedCategoryAfter.equals(ActionName))
			return("True");
		else
			return("False");
		*/
	}
	
	public static void MultipleResponseForInquiry(String FirstInquiryText, String SecondInquiryText, String ResponseTextValue)	
	{
		SelectInquirycheckbox3="//*[@id='rowBody']/td/p[contains(text(),'"+FirstInquiryText+"')]/ancestor::td/preceding-sibling::td[2]/label/div/span";
		SelectInquirycheckbox4="//*[@id='rowBody']/td/p[contains(text(),'"+SecondInquiryText+"')]/ancestor::td/preceding-sibling::td[2]/label/div/span";
		
		 BasePage.driver.findElement(By.xpath(SelectInquirycheckbox3)).click(); 
		 BasePage.driver.findElement(By.xpath(SelectInquirycheckbox4)).click(); 
		 BasePage.driver.findElement(By.xpath(SubmitResponse)).click(); 
		 
		 try {
			 Thread.sleep(3000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		 BasePage.driver.findElement(By.xpath(SubmitResponse_SendResponseToInquirer)).click(); 
		 BasePage.driver.findElement(By.xpath(SubmitResponse_ResponseText)).sendKeys(ResponseTextValue); 
		 BasePage.driver.findElement(By.xpath(SubmitResponse_SubmitButton)).click();
		 
		//Some time for Search inquiry grid to load so that after cases won't fail
		 try {
			 Thread.sleep(7000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	}
	
	//Search inquiry based on inquiry ID from search box present at top
	public static String SearchInquiryByID_SearchBox(String QuestionValue)	
	{
		GetInquiryIDPath="//*[@id='rowBody']/td[3]/p[contains(text(),'"+ QuestionValue+"')]/ancestor::td/following-sibling::td[6]"; 
		GetInquiryID = BasePage.driver.findElement(By.xpath(GetInquiryIDPath)).getText();
		
		BasePage.driver.findElement(By.id(SearchBox)).sendKeys(GetInquiryID);
		BasePage.driver.findElement(By.xpath(SearchBox_Icon)).click();
		
		try {
			 Thread.sleep(8000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiry_InquiryListGridLoad);
		SearchInquiryAssertLabel4=BasePage.driver.findElement(By.xpath(InquiryID_Column)).getText();
		if(GetInquiryID.equals(SearchInquiryAssertLabel4))
			return("True");
		else
			return("False");
        
	}
	
	public static String OpenAdvanceSearchPopUp()
	{
		try {
			 Thread.sleep(4000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		BasePage.driver.findElement(By.xpath(AdvanceSearchButton)).click();
		
		try {
			 Thread.sleep(3000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		UtilityFunctions.WaitUntilPresenceOfElement(AdvanceSearchPopUpAssert);
		SearchInquiryAssertLabel6=BasePage.driver.findElement(By.xpath(AdvanceSearchPopUpAssert)).getText();
		return(SearchInquiryAssertLabel6);
	}
	
	public static String SearchUsingKeyword(String KeywordValue)
	{
		InquiryText="//*[@id='rowBody']/td[3]/p[contains(text(),'"+KeywordValue+"')]";
		
		BasePage.driver.findElement(By.xpath(KeywordsBox)).sendKeys(KeywordValue);
		BasePage.driver.findElement(By.xpath(SearchButton)).click();
		
		try {
			 Thread.sleep(8000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiry_InquiryListGridLoad);
		SearchInquiryAssertLabel6=BasePage.driver.findElement(By.xpath(InquiryText)).getText();
		if(SearchInquiryAssertLabel6.contains(KeywordValue))
		   return("True");
		else
		   return("False");
	}
	
	public static void ClearAdvanceSearch()
	{
		BasePage.driver.findElement(By.xpath(AdvanceSearchButton)).click();
		
			try {
				Thread.sleep(2000);
				} catch (InterruptedException e) {
	  			
	  				e.printStackTrace();
	  			}
		
			UtilityFunctions.WaitUntilPresenceOfElement(AdvanceSearchPopUpAssert);
			BasePage.driver.findElement(By.xpath(ClearButton)).click();
	}
	
	
	public static void SearchUsingDirectory(String DirectoryValue, String QuestionValue)
	{
		DirectoryPath="//*[@id='directory']/option[contains(text(),'"+DirectoryValue+"')]";
		//InquiryExcerpt="//*[@id='rowBody']/td/p[contains(text(),'"+QuestionValue+"')]";
		
		BasePage.driver.findElement(By.xpath(DirectoryPath)).click();
		BasePage.driver.findElement(By.xpath(SearchButton)).click();
		
		try {
			 Thread.sleep(5000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		//UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiry_InquiryListGridLoad);
		//SearchInquiryAssertLabel7=BasePage.driver.findElement(By.xpath(InquiryExcerpt)).getText();
		//return(SearchInquiryAssertLabel7);
	}
	
	public static String SearchUsingReceivedVia(String ReceivedViaValue, String QuestionValue)
	{
		
		
		InquiryExcerpt1="//*[@id='rowBody']/td/p[contains(text(),'"+QuestionValue+"')]";
		
		Select directorydropdown = new Select(BasePage.driver.findElement(By.xpath(ReceivedVia)));
		directorydropdown.selectByVisibleText(ReceivedViaValue);
		
		BasePage.driver.findElement(By.xpath(SearchButton)).click();
		
		try {
			 Thread.sleep(5000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiry_InquiryListGridLoad);
		SearchInquiryAssertLabel7=BasePage.driver.findElement(By.xpath(InquiryExcerpt1)).getText();
		return(SearchInquiryAssertLabel7);
	}
	
	public static String SearchUsingStatus(String ActionNameValue, String InquiryText)
	{
		InquiryExcerpt2="//*[@id='rowBody']/td/p[contains(text(),'"+InquiryText+"')]";
		
		BasePage.driver.findElement(By.xpath(CheckboxPendingStatus)).click();
		BasePage.driver.findElement(By.xpath(SearchButton)).click();
		
		try {
			 Thread.sleep(5000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiry_InquiryListGridLoad);
		SearchInquiryAssertLabel8=BasePage.driver.findElement(By.xpath(InquiryExcerpt2)).getText();
		return(SearchInquiryAssertLabel8);
	}
	
	public static String InquiriesAssignedToMine(String QuestionValue)
	{
		InquiryText="//*[@id='rowBody']/td[3]/p[contains(text(),'"+QuestionValue+"')]";
		
		BasePage.driver.findElement(By.xpath(OptionsOnInquiryListGrid)).click(); 
		BasePage.driver.findElement(By.xpath(MineOption)).click(); 
		 try {
			 Thread.sleep(3000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		 SearchInquiryAssertLabel9=BasePage.driver.findElement(By.xpath(InquiryText)).getText(); 
		 return(SearchInquiryAssertLabel9);
	}
	
	public static void SelectOptionFromInquiryGrid(String OptionValue)
	{
		SelectGridOption="//*[@id='ddlInquirySearch']/ul/li/a[contains(text(),'"+OptionValue+"')]";
		BasePage.driver.findElement(By.xpath(OptionsOnInquiryListGrid)).click(); 
		BasePage.driver.findElement(By.xpath(SelectGridOption)).click(); 
		 try {
			 Thread.sleep(3000);
	   	 } catch (InterruptedException e) {		
	 			e.printStackTrace();
	 		}
		 UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiry_InquiryListGridLoad); 
	}
	
	public static SearchInquiryPage ViewAsReportButton(String FirstInquiryValue, String SecondInquiryValue)
	{
		SearchInquiryAssertLabel11=StartCheckboxForInquiryInGrid+FirstInquiryValue+EndCheckboxForInquiryInGrid;
		SearchInquiryAssertLabel12=StartCheckboxForInquiryInGrid+SecondInquiryValue+EndCheckboxForInquiryInGrid;
		try {
			 Thread.sleep(2000);
	   	 } catch (InterruptedException e) {		
	 			e.printStackTrace();
	 		}
		BasePage.driver.findElement(By.xpath(SearchInquiryAssertLabel11)).click(); 
		BasePage.driver.findElement(By.xpath(SearchInquiryAssertLabel12)).click(); 
		BasePage.driver.findElement(By.xpath(ViewAsReportButton)).click();
		try {
			 Thread.sleep(2000);
	   	 } catch (InterruptedException e) {		
	 			e.printStackTrace();
	 		}
		GetSearchInquiryAssertLabel15=BasePage.driver.findElement(By.xpath(ReportHeader)).getText();
		GetSearchInquiryAssertLabel13=BasePage.driver.findElement(By.xpath(InquiryTextFirstInquiry)).getText(); 
		GetSearchInquiryAssertLabel14=BasePage.driver.findElement(By.xpath(InquiryTextSecondInquiry)).getText();
		
		BasePage.driver.findElement(By.xpath(CloseButton)).click();
		try {
			 Thread.sleep(5000);
	   	 } catch (InterruptedException e) {		
	 			e.printStackTrace();
	 		}
		 UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiry_InquiryListGridLoad); 
		return new SearchInquiryPage();
	}
}
