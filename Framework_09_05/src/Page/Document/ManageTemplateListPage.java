package Page.Document;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.UtilityFunctions;

public class ManageTemplateListPage {

	public static String ManageTemplateListLoad="//*[@class='DNNContainer_Title_h2 SpacingBottom']/div/div/div[2]/h1/div";
	public static String AddTemplateIcon="//*[@class='reports-config-btns form-action-btns sm-top-form-action-btns pull-right']/span/a/i";
	public static String StartTemplateNameInGrid="//*[@id='dvHtmlDetail']/table/tbody/tr/td[1]/span[contains(text(),'";
	public static String EndTemplateNameInGrid="')]";
	
	
	private static String ManageTemplateAssertText; 
	
	
	public static String ClickOnAddTemplate()
	{
		BasePage.driver.findElement(By.xpath(AddTemplateIcon)).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(AddTemplatePage.AddTemplateHeader);
		ManageTemplateAssertText=BasePage.driver.findElement(By.xpath(AddTemplatePage.AddTemplateHeader)).getText();
		return(ManageTemplateAssertText);
	}
}
