package Page.Document;

import org.openqa.selenium.By;

import Base.BasePage;
import Util.UtilityFunctions;

public class AddSignaturePage {

	public static String AddSignaturePageHeader="//*[@class='pull-left']/span";
	private static String Label="//*[@class='form-body']/div[1]/div[1]/div/input";
	private static String Name="//*[@class='form-body']/div[1]/div[2]/div/input";
	private static String Association="//*[@class='form-body']/div[2]/div[1]/div/input";
	private static String Address="//*[@class='form-body']/div[2]/div[2]/div/input";
	private static String Address2="//*[@class='form-body']/div[3]/div[1]/div/input";
	private static String City="//*[@class='form-body']/div[3]/div[2]/div/input";
	private static String State="//*[@class='form-body']/div[4]/div[1]/div/input";
	private static String Phone1="//*[@class='form-body']/div[5]/div[1]/div/input";
	private static String Phone2="//*[@class='form-body']/div[5]/div[2]/div/input";
	private static String Fax="//*[@class='form-body']/div[6]/div[1]/div/input";
	private static String Email="//*[@class='form-body']/div[6]/div[2]/div/input";
	private static String Zip="//*[@class='form-body']/div[4]/div[2]/div/input";
	private static String SubmitButton="//*[@class='form-actions fluid']/div/input[2]";
	
	private static String AddSignatureAssertText1;
	private static String AddedSignature;
	
	public static String EnterSignatureDetailsAndSubmit(String LabelValue,String NameValue,String AssociationValue,String AddressValue,String AddressValue2,
			String CityValue,String ZipValue,String StateValue,String Phone1Value,String Phone2Value,String FaxValue, String EmailValue)
	{
		AddedSignature=ManageSignatureList.StartAddedSignature+LabelValue+ManageSignatureList.EndAddedSignature;
		
		BasePage.driver.findElement(By.xpath(Label)).sendKeys(LabelValue);
        BasePage.driver.findElement(By.xpath(Name)).sendKeys(NameValue); 
        BasePage.driver.findElement(By.xpath(Association)).sendKeys(AssociationValue);
        BasePage.driver.findElement(By.xpath(Address)).sendKeys(AddressValue);
        BasePage.driver.findElement(By.xpath(Address2)).sendKeys(AddressValue2);
        BasePage.driver.findElement(By.xpath(City)).sendKeys(CityValue);
        BasePage.driver.findElement(By.xpath(Zip)).sendKeys(ZipValue);
        BasePage.driver.findElement(By.xpath(State)).sendKeys(StateValue);
        BasePage.driver.findElement(By.xpath(Phone1)).sendKeys(Phone1Value);
        BasePage.driver.findElement(By.xpath(Phone2)).sendKeys(Phone2Value);
        BasePage.driver.findElement(By.xpath(Fax)).sendKeys(FaxValue);
        BasePage.driver.findElement(By.xpath(Email)).sendKeys(EmailValue);
        BasePage.driver.findElement(By.xpath(SubmitButton)).click();
        try {
		 Thread.sleep(9000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        UtilityFunctions.WaitUntilPresenceOfElement(ManageSignatureList.SignatureListHeader);
        AddSignatureAssertText1= BasePage.driver.findElement(By.xpath(AddedSignature)).getText();
        return(AddSignatureAssertText1);
	}
}
