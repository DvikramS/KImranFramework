package Page.NotificationPages;

import org.openqa.selenium.By;

import Util.UtilityFunctions;
import Base.BasePage;

public class DistributionDetailspage {

	public static String DistributionDetailPageLoad="//*[@id='collapseOne']/div/div[1]/div[1]/label";
	
	private static String RecipentsTab="//*[@id='page2tab']";
	private static String MapTab="//*[@id='page4tab']";
	private static String GeoFencingLabel="//*[@id='collapseOne']/div/div[1]/div[4]/label";
	private static String BufferValue="//*[@id='collapseOne']/div/div[1]/div[4]/div/span";
	private static String ExceptionTab="//*[@id='page3tab']";
	private static String BackButton="//*[@id='divNotificationDetail']/div/div[1]/div/span/a";
	
	//Exception Tab Variables
	private static String ExceptionTabHeader="//*[@id='page3']/div/form/div/div/div/h1/div/small";
	private static String ExceptionTabLoad="//*[@id='submit_form']/div/div/div/div[1]/table/thead/tr/th[1]";
	
	//Map Tab Variables
	private static String MapTabLoad="//*[@id='map-section']/div/div[10]/div[1]/div[1]";
	
	//Recipent Tab Variables
	private static String RecipentStartPath="//*[@id='submit_form']/div/div/div/div[2]/div[1]/table/tbody/tr/td[contains(text(),'";
	private static String RecipentEndPath="')]";
	private static String RecipentTabGridLoad="//*[@id='submit_form']/div/div/div/div[1]/table/thead/tr/th[1]";
	private static String RecipentTabAssert="//*[@id='submit_form']/div/div/div/h1/div/small";
	public static String RecipentTablabel="This distribution was sent to the following recipients";
	
	
	private static String Recipentpath;
	public static boolean RecipentPresence;
	public static String GetRecipentFullName;
	public static String GetRecipentTabAssertText;
	public static String GetRecipentPresence;
	public static String GetDistributionReportText;
	public static String GetDistributionReportText1;
	public static String GetDistributionReportText2;
	public static String GetDistributionReportText3;
	public static String GetDistributionReportText4;
	
	public static String NavigateToRecipentTab()
	{
		BasePage.driver.findElement(By.xpath(RecipentsTab)).click();
		try {
			 Thread.sleep(3000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		UtilityFunctions.WaitUntilPresenceOfElement(RecipentTabGridLoad);
		GetRecipentTabAssertText=BasePage.driver.findElement(By.xpath(RecipentTabAssert)).getText();
		return(GetRecipentTabAssertText);
	}
	
	public static DistributionDetailspage ValidateRecipentisDisplayed(String RecipentName)
	{
		Recipentpath=RecipentStartPath+RecipentName+RecipentEndPath;
		try{
		RecipentPresence=BasePage.driver.findElement(By.xpath(Recipentpath)).isDisplayed();
		if(RecipentPresence)
		{
			GetRecipentFullName=BasePage.driver.findElement(By.xpath(Recipentpath)).getText();
			GetRecipentPresence="True";
		}
		}catch(Exception E)
		{
			GetRecipentPresence="False";
			E.printStackTrace();	
		}
		System.out.println(RecipentPresence);
		System.out.println(GetRecipentFullName);
		return new DistributionDetailspage();
	}
	
	public static DistributionDetailspage NavigateToGeofencingTab()
	{
		GetDistributionReportText1=BasePage.driver.findElement(By.xpath(GeoFencingLabel)).getText();
		GetDistributionReportText2=BasePage.driver.findElement(By.xpath(BufferValue)).getText();
		BasePage.driver.findElement(By.xpath(MapTab)).click();
		try {
			 Thread.sleep(7000);
	  	 	} catch (InterruptedException e) {
				
				e.printStackTrace();
	  	 	}
	       UtilityFunctions.WaitUntilPresenceOfElement(MapTabLoad);
	       GetDistributionReportText=BasePage.driver.findElement(By.xpath(MapTabLoad)).getText();
	       return new DistributionDetailspage();
	}
	
	public static String NavigateToExceptionTab()
	{
		BasePage.driver.findElement(By.xpath(ExceptionTab)).click();
		try {
			 Thread.sleep(5000);
	  	 	} catch (InterruptedException e) {
				
				e.printStackTrace();
	  	 	}
	       GetDistributionReportText3=BasePage.driver.findElement(By.xpath(ExceptionTabHeader)).getText(); 
	       return(GetDistributionReportText3);
	}
	
	public static String ClickBackButton()
	{
		BasePage.driver.findElement(By.xpath(BackButton)).click();
	       try {
				 Thread.sleep(5000);
		  	 	} catch (InterruptedException e) {
					
					e.printStackTrace();
		  	 	}
		       UtilityFunctions.WaitUntilPresenceOfElement(DistributionReportListPage.FirstNotificationElementInDataGrid);
		       GetDistributionReportText4=BasePage.driver.findElement(By.xpath(DistributionReportListPage.NotificationHeaderPath)).getText();
		       return(GetDistributionReportText4);
	}
}
