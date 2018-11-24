package Page;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Base.BasePage;

public class SwitchWebsitePage {

	public static String userDropdown = "html/body/div[3]/div[1]/div[2]/ul/li/a/i";
	private static String switchWebsiteOption = ".//*[@id='linkSwitchWebsite']";
	private static String selectWebsite1= "//*[@id='divSwitchWebiteContent']/table/tbody/tr/td/a[contains(text(),'"+ BasePage.TestConfiguration.getProperty("Microsite") +"')]";
	private static String cancelButton ="//*[@id='divSwitchSite']/div/div/div/button[contains(text(),'Cancel')]";
    
	
	public void selectMircosite() 
    {  
    	try {
    		BasePage.driver.findElement(By.xpath(userDropdown)).click();
    		BasePage.driver.findElement(By.xpath(switchWebsiteOption)).click();
    		Thread.sleep(2000);
    		System.out.println("Microsite -" + selectWebsite1);
    		BasePage.driver.findElement(By.xpath(selectWebsite1)).click();
    		Thread.sleep(7000);
    	} catch(Exception e)
    	  {
    		System.out.println("Exception :: " + e);
    		BasePage.driver.findElement(By.xpath(cancelButton)).click();
    	    }
    }
}
