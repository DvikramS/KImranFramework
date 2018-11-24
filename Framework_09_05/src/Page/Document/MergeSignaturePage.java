package Page.Document;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.UtilityFunctions;

public class MergeSignaturePage {

	public static String MergeSignatureAssert="//*[@id='dvMergeSignatureList']/table/tbody/tr[1]/td[1]";
	private static String MergeSignatureHeader="//*[@class='sm-report-heading clearfix']/div";
	private static String SubmitButton="//*[@class='form-actions fluid']/div/input[2]";
	
	private static String MergeSignatureAssertText1;
	public static String MergeSignatureAssertText2;
	private static String MergeSignatureAssertText3;
	public static String MergeSignatureAssertText4;
	
	public static MergeSignaturePage MergeSignature()
	{
		BasePage.driver.findElement(By.xpath(SubmitButton)).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(ManageSignatureList.SignatureListHeader);
		MergeSignatureAssertText1=BasePage.driver.findElement(By.xpath(ManageSignatureList.SignatureLabel1)).getText();
		if(MergeSignatureAssertText1.equals(ManageSignatureList.GetManageSignatureAssertText2))
			MergeSignatureAssertText2="True";
		else
			MergeSignatureAssertText2="False";
	try{	
		if(BasePage.driver.findElement(By.xpath(ManageSignatureList.SignatureLabel2)).isDisplayed())
				{ 	
					MergeSignatureAssertText3=BasePage.driver.findElement(By.xpath(ManageSignatureList.SignatureLabel2)).getText();
					if(MergeSignatureAssertText3.equals(ManageSignatureList.GetManageSignatureAssertText3))
						MergeSignatureAssertText4="False";
					else
						MergeSignatureAssertText4="True";
				}
				}catch (Exception e)
				{
					MergeSignatureAssertText4="True";
				}
		return new MergeSignaturePage();
	}
}
