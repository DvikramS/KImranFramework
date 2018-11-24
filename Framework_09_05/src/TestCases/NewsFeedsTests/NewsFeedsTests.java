package TestCases.NewsFeedsTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.InquiryPages.SearchInquiryPage;
import Page.OtherModulePages.NewFeedsPage;
import Util.UtilityFunctions;

public class NewsFeedsTests {

	private static String getNewsFeedAssertsText1;
	
	NewFeedsPage NewFeedsPageObject;
	
	@Test(priority=1)
	public void verifyNavigateToNewsFeedsPage()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("verifyNavigateToNewsFeedsPage", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
			
			System.out.println("verifyNavigateToNewsFeedsPage starts");
			getNewsFeedAssertsText1=NewFeedsPage.navigateToNewsFeedPage();
			Assert.assertEquals(getNewsFeedAssertsText1, "Feed List");
			System.out.println("verifyNavigateToNewsFeedsPage ends");
	
	}
	
	@Test(priority=2,dataProvider = "getTestDataForVerifyAddNewsFeed", dependsOnMethods = { "verifyNavigateToNewsFeedsPage" })
	public void verifyAddNewsFeed(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("verifyAddNewsFeed", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("verifyAddNewsFeed Test Starts");
		   	NewFeedsPageObject=NewFeedsPage.addFeed(TestDataSet.get("FeedURLValue"));	
			Assert.assertEquals(NewFeedsPageObject.feedsAssertText2 ,TestDataSet.get("FeedURLValue"));	
			Assert.assertEquals(NewFeedsPageObject.feedsAssertText3 ,TestDataSet.get("FeedTitleValue"));	
			Assert.assertEquals(NewFeedsPageObject.feedsAssertText4 ,TestDataSet.get("FeedDescritpionLValue"));	
			Assert.assertTrue(NewFeedsPageObject.feedsAssertText5.contains(NewFeedsPageObject.addFeedSuccessMessageLabel));	
			Assert.assertEquals(NewFeedsPageObject.feedsAssertText6 ,TestDataSet.get("FeedURLValue"));
			System.out.println("verifyAddNewsFeed ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyAddNewsFeed()
	{
		Object[][] Data = UtilityFunctions.getData("verifyAddNewsFeed", BasePage.xls);
		return Data;
	}
	
	
	@Test(priority=3,dataProvider = "getTestDataForverifyAddNewsAggregateFeed")
	public void verifyAddNewsAggregateFeed(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("verifyAddNewsAggregateFeed", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("verifyAddNewsAggregateFeed Test Starts");
		   	NewFeedsPageObject=NewFeedsPage.addAggregateFeed(TestDataSet.get("aggregateFeedTitleValue"), TestDataSet.get("aggregateFeedDescriptionValue"),
		   			TestDataSet.get("feedTitleValue"));	
			Assert.assertEquals(NewFeedsPageObject.feedsAssertText9 ,TestDataSet.get("aggregateFeedTitleValue"));	
			Assert.assertEquals(NewFeedsPageObject.feedsAssertText10 ,TestDataSet.get("aggregateFeedDescriptionValue"));	
			Assert.assertEquals(NewFeedsPageObject.feedsAssertText11 ,TestDataSet.get("feedTitleValue"));	
			Assert.assertTrue(NewFeedsPageObject.feedsAssertText8.contains(NewFeedsPageObject.addFeedAggregateSuccessMessageLabel));	
			System.out.println("verifyAddNewsAggregateFeed ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForverifyAddNewsAggregateFeed()
	{
		Object[][] Data = UtilityFunctions.getData("verifyAddNewsAggregateFeed", BasePage.xls);
		return Data;
	}
}
