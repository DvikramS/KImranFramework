package Page.Document;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.UtilityFunctions;

public class ManageSignatureList {

	public static String SignatureListHeader="//*[@class='sm-report-heading clearfix']/div[1]";
	private static String AddSignatureIcon="//*[@class='sm-report-heading clearfix']/div/span/a/i";
	public static String StartAddedSignature="//*[@id='dvSignatureList']/table/tbody/tr/td/span[contains(text(),'";
	public static String EndAddedSignature="')]";
	private static String MergeCheckbox1="//*[@id='dvSignatureList']/table/tbody/tr[1]/td[5]/span/input";
	private static String MergeCheckbox2="//*[@id='dvSignatureList']/table/tbody/tr[2]/td[5]/span/input";
	public static String SignatureLabel1="//*[@id='dvSignatureList']/table/tbody/tr[1]/td[1]/span";
	public static String SignatureLabel2="//*[@id='dvSignatureList']/table/tbody/tr[2]/td[2]/span";
	private static String MergeButton="//*[@id='dvSignatureList']/div/div/input[1]";
	
	private static String ManageSignatureAssertText1;
	public static String GetManageSignatureAssertText2;
	public static String GetManageSignatureAssertText3;
	
	public static String ClickOnAddSignature()
	{
		BasePage.driver.findElement(By.xpath(AddSignatureIcon)).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(ManageSignatureList.SignatureListHeader);
		ManageSignatureAssertText1=BasePage.driver.findElement(By.xpath(AddSignaturePage.AddSignaturePageHeader)).getText();
		return(ManageSignatureAssertText1);
	}
	
	public static String SelectCheckboxForMergeSignature()
	{
		BasePage.driver.findElement(By.xpath(MergeCheckbox1)).click();
		BasePage.driver.findElement(By.xpath(MergeCheckbox2)).click();
		GetManageSignatureAssertText2=BasePage.driver.findElement(By.xpath(SignatureLabel1)).getText();
		GetManageSignatureAssertText3=BasePage.driver.findElement(By.xpath(SignatureLabel2)).getText();
		BasePage.driver.findElement(By.xpath(MergeButton)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(ManageSignatureList.SignatureListHeader);
		ManageSignatureAssertText1=BasePage.driver.findElement(By.xpath(MergeSignaturePage.MergeSignatureAssert)).getText();
		return(ManageSignatureAssertText1);
	}
}
