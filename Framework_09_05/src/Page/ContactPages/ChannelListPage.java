package Page.ContactPages;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.UtilityFunctions;

public class ChannelListPage {

	private static String MenuChannels="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/ul/li/a[contains(text(),'Channels')]";
	private static String ChannelListPageGridDisplay="//*[@id='divChannelGrid']/div[2]/table/thead/tr/th[1]"; //Grid's xpath 
	private static String ChannelListPageHeader="//*[@id='divChannel']/div/div[1]/div/h1/div[1]";
	public static String AddChannelIcon="//*[@id='divAddChannel']/span/a/i";
	public static String ChannelListGridDataLoad="//*[@id='divChannelGrid']/div[2]/table/tbody/tr[1]/td[1]";
	public static String EditChannelButton;
	public static String DeleteChannelButton;
	private static String DeleteChannelConfirmationBoxMessage="//*[@id='pMessage']";
	public static String DeleteChannelConfirmationLabel="Are you sure, you want to delete this Channel?";
	private static String YesButton="//*[@id='confirmedOk']";
	private static String DeleteConfirmationMessage="html/body/div[7]/div/div/p";
	public static String DeleteMessageLabel="Channel deleted successfully.";
	
	private static String ChannelAsserttext;
	public static String ChannelDeleteAsserttext1;
	public static String ChannelDeleteAsserttext2;
	
	public static String NavigateToChannelListPage()
	{
		
		 try {
			 Thread.sleep(3000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
        BasePage.driver.findElement(By.xpath(MenuChannels)).click(); 
        try {
		 Thread.sleep(8000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        if(BasePage.driver.findElement(By.xpath(ChannelListGridDataLoad)).getSize()!= null)
        {
        	UtilityFunctions.WaitUntilPresenceOfElement(ChannelListGridDataLoad);
        }
        else
        	UtilityFunctions.WaitUntilPresenceOfElement(ChannelListPageGridDisplay);
        ChannelAsserttext= BasePage.driver.findElement(By.xpath(ChannelListPageHeader)).getText();
        return(ChannelAsserttext);
	}
	
	//Delete a Channel
	public static ChannelListPage DeleteChannel(String ChannelNameValue)
	{
		DeleteChannelButton="//*[@id='divChannelGrid']/div[2]/table/tbody/tr/td[contains(text(),'"+ChannelNameValue+"')]/following-sibling::td[6]/i[2]";
		BasePage.driver.findElement(By.xpath(DeleteChannelButton)).click(); 
		 try {
	   		 Thread.sleep(2000);
	      	 } catch (InterruptedException e) {
	    			
	    			e.printStackTrace();
	    		}
        ChannelDeleteAsserttext1=BasePage.driver.findElement(By.xpath(DeleteChannelConfirmationBoxMessage)).getText();
        BasePage.driver.findElement(By.xpath(YesButton)).click(); 
        ChannelDeleteAsserttext2=BasePage.driver.findElement(By.xpath(DeleteConfirmationMessage)).getText();
        try {
   		 Thread.sleep(7000);
      	 } catch (InterruptedException e) {
    			
    			e.printStackTrace();
    		}
           UtilityFunctions.WaitUntilPresenceOfElement(ChannelListPageGridDisplay);
           
           return new ChannelListPage();
	}
	
}
