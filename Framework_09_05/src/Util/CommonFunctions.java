package Util;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;

public class CommonFunctions {
    
	private static WebElement Element;
	private static Select SelectBoxPagination;
	private static int SelectOptions;
	private static WebElement DropdownList;
	private static String ElementValue;
	private static List<WebElement> lists;
	private static String winHandleBefore;
	private static WebElement iframeMsg;
	private static String getIframeText;
	private static String verifyElementPresence;
	
	public static void DoubleClickElement(String Locator)
	{
		Element=BasePage.driver.findElement(By.xpath(Locator));
		Actions action = new Actions(BasePage.driver); 
		action.moveToElement(Element).doubleClick().build().perform();
	}
	
	public static void SelectLastValueFromPaginationDropdown(String Locator)
	{
        SelectBoxPagination = new Select(BasePage.driver.findElement(By
	            .xpath(Locator)));
        SelectOptions = SelectBoxPagination.getOptions().size();
	     System.out.println(SelectOptions);
	     SelectBoxPagination.selectByIndex(SelectOptions - 1);
	}
	
	// Function return True if Value is not found in dropdown and true if value is not found
	public static String ReturnPresenceOfTextInDropdown(String Locator, String Value)
	{
		DropdownList = BasePage.driver.findElement(By.xpath(Locator));
		List<WebElement> lists = DropdownList.findElements(By.tagName("option"));
		    for(WebElement elements: lists)  
		    {
		    	ElementValue = elements.getText();
		        if(ElementValue.equals(Value))
		        {
		        	return("False");
		        }
		    }
		    return("True");
	}
	
	public static void EnterTextInIFrame(String Object, String Data){
		try{
			winHandleBefore = BasePage.driver.getWindowHandle();
			System.out.println("Window name"+ winHandleBefore);
			iframeMsg= BasePage.driver.findElement(By.xpath(Object));
			BasePage.driver.switchTo().frame(iframeMsg);             
			BasePage.driver.findElement(By.cssSelector("body")).sendKeys(Data);
			BasePage.driver.switchTo().window(winHandleBefore);
			}catch(Exception e){
				System.out.println("Text not to enter text in Iframe box");
				e.printStackTrace();
			}
	}
	
	public static String getTextFromIFrame(String Object){
		try{
			winHandleBefore = BasePage.driver.getWindowHandle();
			System.out.println("Window name"+ winHandleBefore);
			iframeMsg= BasePage.driver.findElement(By.xpath(Object));
			BasePage.driver.switchTo().frame(iframeMsg);             
			getIframeText=BasePage.driver.findElement(By.cssSelector("body")).getText();
			System.out.println(getIframeText);
			BasePage.driver.switchTo().window(winHandleBefore);
			}catch(Exception e){
				System.out.println("Text not to enter text in Iframe box");
				e.printStackTrace();
			}
		return(getIframeText);
	}
	
	//For finding current date part, to be used in calendar functions
	public static int getCurrentDate()
			{		
				Calendar cal = Calendar.getInstance();
				int val = cal.get(Calendar.DATE);
				System.out.println(val);
				return(val);
			}
	
	public static String returnElementpresence(String locator)
	{
		try{
		
				if(BasePage.driver.findElement(By.xpath(locator)).isDisplayed())
				{
					verifyElementPresence="True";
					}
				else 
					verifyElementPresence="False";
			}catch(NoSuchElementException E)
		{
				verifyElementPresence="False";	
		}
		return(verifyElementPresence);
	}
}
