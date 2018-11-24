package Page.OtherModulePages;

import org.openqa.selenium.By;

import Base.BasePage;
import Page.Document.DocumentManagementPage;
import Util.CommonFunctions;
import Util.UtilityFunctions;

public class NewFeedsPage {

	private static By menuNewFeeds_DNN=By.xpath("//*[@id='ControlNav']/li/ul/ul/ul/li/a[contains(text(),'News Feeds')]");
	private static By menuNewFeeds=By.xpath("//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'News Feeds')]");
	
	//Elements for Feed list tab
	private static String feedListTab="//*[@id='litab1']/a";
	private static By addFeeds=By.xpath("//*[@id='litab2']/a");
	private static By addAggregateFeedTab=By.xpath("//*[@id='litab4']/a");
	private static By aggregateFeedListTab=By.xpath("//*[@id='litab3']/a");
	private static String feedListAssertGridLoad="//*[@id='feedList']/table/tbody/tr/td[1]/a";
	private static String addedFeedURL="//*[@id='feedList']/table/tbody/tr/td[2]/a";
	private static String addedFeedTitle="//*[@id='feedList']/table/tbody/tr/td[1]/a";
	private static String addedFeedDescription="//*[@id='feedList']/table/tbody/tr/td[2]/p";
	
	
	//Elements for Add Feed tab
	private static String feedURLLabel="//*[@id='feed-url']/div[1]/div/label";
	private static By feedURL=By.xpath("//*[@id='feed-url']/div[1]/div/div/input");
	private static By nextButton=By.xpath("//*[@id='btnSubmit-feed-url']");
	private static By addFeedUrl=By.xpath(".//*[@id='feed-details']/div[1]/div/div/a");
	private static String title="//*[@id='f_title']";
	private static By description=By.xpath("//*[@id='f_description']");
	private static By submitButton=By.xpath("//*[@id='feed-details']/div[5]/div/input[1]");
	
	public static String addFeedSuccessMessage="html/body/div[4]/div/div/p";
	public static String addFeedSuccessMessageLabel="Feed added successfully.";
	
	
	//Elements for Add Aggregate Feed list
	private static String titleLabel="//*[@id='tab4']/div/div[1]/label";
	private static By aggregateTitle=By.xpath("//*[@id='tab4']/div/div[1]/div/div/input");
	private static By aggregateDescription=By.xpath("//*[@id='tab4']/div/div[2]/div/div/div/textarea");
	private static String aggregateAvailableStart="//*[@id='ms-my_multi_select2']/div[1]/ul/li/span[contains(text(),'";
	private static String aggregateAvailableEnd="')]";
	private static String aggregateSelectedStart="//*[@id='ms-my_multi_select2']/div[2]/ul/li/span[contains(text(),'";
	private static String aggregateSelectedEnd="')]";
	private static By aggregateSubmitbutton=By.xpath("//*[@id='tab4']/div/div[4]/div/input[1]");
	public static String addFeedAggregateSuccessMessageLabel="Feed aggregate added successfully.";
	
	//Elements for Aggregate Feed list
	private static String aggregateListTitleStart="//*[@id='feedAggregateList']/table/tbody/tr/td/a[contains(text(),'";
	private static String aggregateListTitleEnd="')]";
	private static String aggregateListDescriptionStart="//*[@id='feedAggregateList']/table/tbody/tr/td[contains(text(),'";
	private static String aggregateListDescriptionEnd="')]";
	private static String aggregateFeedTitleStart="//*[@id='feedAggregateList']/table/tbody/tr/td[contains(text(),'";
	private static String aggregateFeedTitleEnd="')]";
	
	private static String availableFeed;
	private static String selectedFeed;
	private static String addedAggregateFeedTitle;
	private static String addedAggregateFeedDescription;
	private static String addedAggregateTitle;
	
	private static String feedsAssertText1;
	public static String feedsAssertText2;
	public static String feedsAssertText3;
	public static String feedsAssertText4;
	public static String feedsAssertText5;
	public static String feedsAssertText6;
	public static String feedsAssertText7;
	
	public static String feedsAssertText8;
	public static String feedsAssertText9;
	public static String feedsAssertText10;
	public static String feedsAssertText11;
	public static String feedsAssertText12;
	
	/**************************************************Function for News Feeds Pages ************************************************************/		
	//Navigate to New feeds page from DNN
			public static String navigateToNewsFeedPage_DNN()
			{
				 BasePage.driver.findElement(By.xpath(DocumentManagementPage.MenuPIERPro_DNN)).click();
		         BasePage.driver.findElement(menuNewFeeds_DNN).click(); 
		         try {
				 Thread.sleep(7000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
		         
		         UtilityFunctions.WaitUntilPresenceOfElement(feedListTab);
		         feedsAssertText1= BasePage.driver.findElement(By.xpath(feedListTab)).getText();
		         return(feedsAssertText1);
			}
		
			//Navigate to New feeds page 
			public static String navigateToNewsFeedPage()
			{
				 BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
		         BasePage.driver.findElement(menuNewFeeds).click(); 
		         try {
				 Thread.sleep(7000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
		         
		         UtilityFunctions.WaitUntilPresenceOfElement(feedListTab);
		         feedsAssertText1= BasePage.driver.findElement(By.xpath(feedListTab)).getText();
		         return(feedsAssertText1);
			}
			
		public static NewFeedsPage addFeed(String feedURLValue)
		{
			 BasePage.driver.findElement(addFeeds).click(); 
	         try {
			 Thread.sleep(2000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
	         UtilityFunctions.WaitUntilPresenceOfElement(feedURLLabel);
	         BasePage.driver.findElement(feedURL).sendKeys(feedURLValue);
	         BasePage.driver.findElement(nextButton).click(); 
	         try {
				 Thread.sleep(5000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
		         UtilityFunctions.WaitUntilPresenceOfElement(title);
		         feedsAssertText2= BasePage.driver.findElement(addFeedUrl).getText();
		         //feedsAssertText3= BasePage.driver.findElement(By.xpath(title)).getText();
		        // feedsAssertText4= BasePage.driver.findElement(description).getText();
		         BasePage.driver.findElement(submitButton).click(); 
		        
		         UtilityFunctions.WaitUntilPresenceOfElement(addFeedSuccessMessage);
		         feedsAssertText5= BasePage.driver.findElement(By.xpath(addFeedSuccessMessage)).getText();
		         try {
					 Thread.sleep(3000);
			    	 } catch (InterruptedException e) {
			  			
			  			e.printStackTrace();
			  		} 
		         UtilityFunctions.WaitUntilPresenceOfElement(feedListAssertGridLoad);
		         feedsAssertText3= BasePage.driver.findElement(By.xpath(addedFeedTitle)).getText();
			     feedsAssertText4= BasePage.driver.findElement(By.xpath(addedFeedDescription)).getText();
		         feedsAssertText6= BasePage.driver.findElement(By.xpath(addedFeedURL)).getText();
		         
		         return new NewFeedsPage();
		}
		
		public static NewFeedsPage addAggregateFeed(String aggregateFeedTitleValue, String aggregateFeedDescriptionValue, String feedTitleValue)
		{
		     availableFeed=aggregateAvailableStart+feedTitleValue+aggregateAvailableEnd;
		     selectedFeed=aggregateSelectedStart+feedTitleValue+aggregateSelectedEnd;
		     addedAggregateFeedTitle=aggregateListTitleStart+aggregateFeedTitleValue +aggregateListTitleEnd;
		     addedAggregateFeedDescription=aggregateListDescriptionStart+aggregateFeedDescriptionValue +aggregateListDescriptionEnd;
		     addedAggregateTitle=aggregateFeedTitleStart+ feedTitleValue+ aggregateFeedTitleEnd;
		     
			 BasePage.driver.findElement(addAggregateFeedTab).click(); 
	         try {
			 Thread.sleep(2000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
	         UtilityFunctions.WaitUntilPresenceOfElement(titleLabel);
	         BasePage.driver.findElement(aggregateTitle).sendKeys(aggregateFeedTitleValue);
	         BasePage.driver.findElement(aggregateDescription).sendKeys(aggregateFeedDescriptionValue);
	         CommonFunctions.DoubleClickElement(availableFeed);
	         BasePage.driver.findElement(aggregateSubmitbutton).click(); 
		        
		         UtilityFunctions.WaitUntilPresenceOfElement(addFeedSuccessMessage);
		         feedsAssertText8= BasePage.driver.findElement(By.xpath(addFeedSuccessMessage)).getText();
		         try {
					 Thread.sleep(3000);
			    	 } catch (InterruptedException e) {
			  			
			  			e.printStackTrace();
			  		} 
		         UtilityFunctions.WaitUntilPresenceOfElement(addedAggregateFeedDescription);
		         feedsAssertText9= BasePage.driver.findElement(By.xpath(addedAggregateFeedTitle)).getText();
			     feedsAssertText10= BasePage.driver.findElement(By.xpath(addedAggregateFeedDescription)).getText();
		         feedsAssertText11= BasePage.driver.findElement(By.xpath(addedAggregateTitle)).getText();
		         
		         return new NewFeedsPage();
		}
		
}
