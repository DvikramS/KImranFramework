package Page.OtherModulePages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Page.Document.DocumentManagementPage;
import Util.UtilityFunctions;
import Base.BasePage;

public class PublicViewPage {
	
	private static By menuViewWebsite=By.xpath("//*[@id='navbar-collapse-1']/ul/li[4]/ul/ul[3]/ul[10]/li/a");
	private static By menuViewWebsiteFromDNN=By.xpath("//*[@id='ControlNav']/li[4]/ul/ul[3]/ul[10]/li/a");
	private static String editWebsiteFromDNN="//*[@id='ControlNav']/li[4]/ul/ul[3]/ul[7]/li/a";
	
	//Elements on home page
	private static By MenuHomePage=By.xpath("//*[@id='menu1']/li[1]/a[contains(text(),'Home')]");
	private static String MenuHomePageLoad="//*[@id='menu1']/li[1]/a";
	private static String homePageDescription="//*[@class='DNNContainer_Title_h2 SpacingBottom']/div/div/div/div/div[6]/div";
	//private static WebElement MenuViewWebsite= BasePage.driver.findElement(By.xpath(""));
	
	
	//Variable for asserting text
	public static String addPublicViewAssertText;
	public static String addPublicViewAssertText1;
	public static String addPublicViewAssertText2;
	public static String addPublicViewAssertText3;
	public static String addPublicViewAssertText4;
	public static String baseWindow;
	public static String newBaseWindow;
	public static Set<String> window_ids;
	static int cntr=0;
	static int cntr1=0;
	
	
	public static String navigateToViewWebsite()
	{
		 BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
         BasePage.driver.findElement(menuViewWebsite).click(); 
         try {
		 Thread.sleep(5000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
         
         UtilityFunctions.WaitUntilPresenceOfElement(MenuHomePageLoad);
         addPublicViewAssertText= BasePage.driver.findElement(MenuHomePage).getText();
         return(addPublicViewAssertText);
	}
	
	public static void navigateToViewWebsite_FromDNN()
	{
		try {
			 Thread.sleep(4000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		 BasePage.driver.findElement(By.xpath(DocumentManagementPage.MenuPIERPro_DNN)).click();
         BasePage.driver.findElement(menuViewWebsiteFromDNN).click(); 
         try {
		 Thread.sleep(5000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
	}
	
	public static String switchToPublicView()
	{
		baseWindow = BasePage.driver.getWindowHandle();
		System.out.println("Base window" + baseWindow);
		window_ids=BasePage.driver.getWindowHandles();
        Iterator<String> iterate=window_ids.iterator();
        for(;cntr<window_ids.size();cntr++)
        {
        	System.out.println(window_ids);
        	
        	String window_name=iterate.next();
        	System.out.println(window_name);
        	if(window_name.equals(baseWindow))
        		System.out.println("Same window");
        	else 
        		{
        			BasePage.driver.switchTo().window(window_name);
            		System.out.println(window_name);
            		try {
            			Thread.sleep(5000);
            		} catch (InterruptedException e) {
            			e.printStackTrace();
            		}
        			UtilityFunctions.WaitUntilPresenceOfElement(MenuHomePageLoad);
        			
        		}
        }
        addPublicViewAssertText1=BasePage.driver.findElement(MenuHomePage).getText();
        return(addPublicViewAssertText1);     
	}
	
	
	
	public static String switchToMainWindow_DNN()
	{
		BasePage.driver.close();
		BasePage.driver.switchTo().window(baseWindow);
		
        addPublicViewAssertText2=BasePage.driver.findElement(By.xpath(DocumentManagementPage.MenuPIERPro_DNN)).getText();
        return(addPublicViewAssertText2);     
	}
	
	public static String ValidateHomePageDescription()
	{
		 try {
			 Thread.sleep(3000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		addPublicViewAssertText3=BasePage.driver.findElement(By.xpath(homePageDescription)).getText();
        return(addPublicViewAssertText3);     
	}
	
	public static String navigateToEditWebsite()
	{
		BasePage.driver.findElement(By.xpath(DocumentManagementPage.MenuPIERPro_DNN)).click();
        BasePage.driver.findElement(By.xpath(editWebsiteFromDNN)).click(); 
        try {
		 Thread.sleep(8000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(MenuHomePageLoad);
        addPublicViewAssertText= BasePage.driver.findElement(MenuHomePage).getText();
        return(addPublicViewAssertText);
	}
}
