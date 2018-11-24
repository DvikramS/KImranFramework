package Page.Document;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.CommonFunctions;
import Util.UtilityFunctions;

public class AddTemplatePage {

	public static String AddTemplateHeader="//*[@class='sm-report-heading clearfix']/div/span";
	private static String TemplateName="//*[@class='form-group']/div/div/input";
	private static String TemplateDescription="//*[@class='dnnLeft']/div/div/table/tbody/tr[3]/td/iframe";
	private static String SaveButton="//*[@class='form-actions fluid']/div/input[2]";
	
	private static String AddedTemplateText1;
	private static String GetAddedTemplateAssertText;
	
	public static String EnterTemplateDetailsAndSave(String TemplateNameValue, String DescrptionValue)
	{
		AddedTemplateText1=ManageTemplateListPage.StartTemplateNameInGrid+ TemplateNameValue +ManageTemplateListPage.EndTemplateNameInGrid;
		
		BasePage.driver.findElement(By.xpath(TemplateName)).sendKeys(TemplateNameValue);
		CommonFunctions.EnterTextInIFrame(TemplateDescription,DescrptionValue);
		BasePage.driver.findElement(By.xpath(SaveButton)).click();
		try {
	 		 Thread.sleep(6000);
	 		} catch (InterruptedException e) {
	 			e.printStackTrace();
	 		} 
			 UtilityFunctions.WaitUntilPresenceOfElement(ManageTemplateListPage.ManageTemplateListLoad);
			 GetAddedTemplateAssertText=BasePage.driver.findElement(By.xpath(AddedTemplateText1)).getText();
	         return(GetAddedTemplateAssertText);
	}
	
}
