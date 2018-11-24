package Page.Document;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.CommonFunctions;
import Util.UtilityFunctions;

public class HomePageSettingPage {

	public static By menuHomePageSettings=By.xpath("//*[@id='ControlNav']/li[9]/ul/ul/ul/li/a/span[contains(text(),'Home Page Settings')]");
	
	private static String homePageSettingsLabel="//*[@class='home-sett']/div[2]/span";
	public static String homePageSettingsLabelMessage="Redirect home page to this URL. Disables display of home page content below.";
	private static String homePageDescription="//*[@class='DMX_EditTitle']/div/div/div/div/table/tbody/tr[3]/td/iframe";
	private static By saveButton=By.xpath("//*[@class='DNNContainer_Title_h2 SpacingBottom']/div/div[4]/div/input[2]");
	
	private static String homePageSettingAssertText1;
	public static String homePageSettingAssertText2;
	public static String homePageSettingAssertText3;
	
	//Navigate to Home Setting Page
	public static String NavigateToHomePageSettings()
	{
		 BasePage.driver.findElement(By.xpath(ApprovalListPage.MenuWebsite)).click();
         BasePage.driver.findElement(menuHomePageSettings).click(); 
         try {
		 Thread.sleep(5000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
         
         UtilityFunctions.WaitUntilPresenceOfElement(homePageSettingsLabel);
         homePageSettingAssertText1= BasePage.driver.findElement(By.xpath(homePageSettingsLabel)).getText();
         return(homePageSettingAssertText1);
	}
	
	//Save Home Page setting page
		public static HomePageSettingPage saveHomePageSettingPage()
		{
			
			 homePageSettingAssertText2=CommonFunctions.getTextFromIFrame(homePageDescription);
	         BasePage.driver.findElement(saveButton).click(); 
	         try {
			 Thread.sleep(8000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
	         
	         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPage.DocumentManagementPageLoadAssert);
	         homePageSettingAssertText3= BasePage.driver.findElement(By.xpath(DocumentManagementPage.DocumentManagementPageHeaderPath)).getText();
	         return new HomePageSettingPage();
		}
}
