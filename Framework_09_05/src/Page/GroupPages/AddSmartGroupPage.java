package Page.GroupPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Util.UtilityFunctions;
import Base.BasePage;

public class AddSmartGroupPage {

	
	public static String AddSmartGroupPageLoad="//*[@id='collapseFour']/div/div/div[2]/table/thead/tr/th[1]/span";  //Path correspond to First name label in grid
	public static String AddSmartGroupPageHeader="//*[@id='dataDiv']/div/div[1]/div/h1/div";
	private static String SmartGroupName="//*[@id='collapseThree']/div[1]/div[2]/div/input";
	private static String FirstRowCondition="//*[@id='addedRows']/div/div[1]/div[1]/select";
	private static String FirstRowCriteria="//*[@id='addedRows']/div/div/div[2]/select";
	private static String FirstRowTextBox="//*[@id='addedRows']/div/div/div[3]/div/div/input";
	private static String ConditionAddButton="//*[@id='btn-add-new']/i";
	private static String SecondRowCondition="//*[@id='addedRows']/div/div[2]/div[1]/select";
	private static String SecondRowCriteria="//*[@id='addedRows']/div/div[2]/div[2]/select";
	private static String SecondRowTextBox="//*[@id='addedRows']/div/div[2]/div[3]/div/div/input";
	private static String ApplyConditionButton="//*[@id='collapseThree']/div[6]/div/a[2]";
	private static String SmartContactGridDataLoad="//*[@id='collapseFour']/div/div/div[2]/table/tbody/tr/td[1]";
	private static String SaveButton="//*[@id='search-btn']";
	private static String DeleteConditionIcon="//*[@id='btn-first-delete']/i";
	public static String AddedSmartGroup;
	private static String EditSmartgroupButton;
	private static String EditedSmartGroup;
	
	public static String GetAddedSmartGroup;
	public static String GetEditedSmartGroup;
	//**********************************Add/Edit Smart Group Functions*********************************************

	//Add a Smart Group with two condition firstname and lastname
	public static String AddSmartGroup(String SmartGroupNameValue, String Condition1, String Condition2,String ContactFirstNameValue, String ContactLastNameValue)
	{
		AddedSmartGroup="//*[@id='tab2']/div[2]/table/tbody/tr/td[2]/div[contains(text(),'"+SmartGroupNameValue+"')]";
		
		BasePage.driver.findElement(By.xpath(SmartGroupName)).clear();
		BasePage.driver.findElement(By.xpath(SmartGroupName)).sendKeys(SmartGroupNameValue);
		
		Select Condition1Dropdown = new Select(BasePage.driver.findElement(By.xpath(FirstRowCondition)));
		Condition1Dropdown.selectByVisibleText(Condition1);
		Select CriteriaDropdown = new Select(BasePage.driver.findElement(By.xpath(FirstRowCriteria)));
		CriteriaDropdown.selectByVisibleText("contains");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Add contact on search contact page wait");
			e.printStackTrace();
		}
		BasePage.driver.findElement(By.xpath(FirstRowTextBox)).sendKeys(ContactFirstNameValue);
		
		BasePage.driver.findElement(By.xpath(ConditionAddButton)).click();
		
		Select Condition2Dropdown = new Select(BasePage.driver.findElement(By.xpath(SecondRowCondition)));
		Condition2Dropdown.selectByVisibleText(Condition2);
		Select Criteria2Dropdown = new Select(BasePage.driver.findElement(By.xpath(SecondRowCriteria)));
		Criteria2Dropdown.selectByVisibleText("contains");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Add contact on search contact page wait");
			e.printStackTrace();
		}
		BasePage.driver.findElement(By.xpath(SecondRowTextBox)).sendKeys(ContactLastNameValue);
		
		BasePage.driver.findElement(By.xpath(ApplyConditionButton)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Add contact on search contact page wait");
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(SmartContactGridDataLoad);
		BasePage.driver.findElement(By.xpath(SaveButton)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Add contact on search contact page wait");
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(GroupListPage.GroupListDataLoad);
		GetAddedSmartGroup=BasePage.driver.findElement(By.xpath(AddedSmartGroup)).getText();
		return(GetAddedSmartGroup);
	}

	//Edit Smart Group, Edit name, delete first condition and add a new condition
	public static String EditSmartGroup(String SmartGroupNameValue, String NewSmartGroupNameValue, String Condition2, String EmailValue)
	{
		EditSmartgroupButton="//*[@id='tab2']/div[2]/table/tbody/tr/td[2]/div[contains(text(),'"+SmartGroupNameValue+"')]/ancestor::td/following-sibling::td[3]/i[2]";
		EditedSmartGroup="//*[@id='tab2']/div[2]/table/tbody/tr/td[2]/div[contains(text(),'"+NewSmartGroupNameValue+"')]";
		
		BasePage.driver.findElement(By.xpath(EditSmartgroupButton)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Add contact on search contact page wait");
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(SmartContactGridDataLoad);
		
		BasePage.driver.findElement(By.xpath(SmartGroupName)).clear();
		BasePage.driver.findElement(By.xpath(SmartGroupName)).sendKeys(NewSmartGroupNameValue);
		
		BasePage.driver.findElement(By.xpath(DeleteConditionIcon)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Add contact on search contact page wait");
			e.printStackTrace();
		}
		
        BasePage.driver.findElement(By.xpath(ConditionAddButton)).click();
		
		Select Condition2Dropdown = new Select(BasePage.driver.findElement(By.xpath(SecondRowCondition)));
		Condition2Dropdown.selectByVisibleText(Condition2);
		Select Criteria2Dropdown = new Select(BasePage.driver.findElement(By.xpath(SecondRowCriteria)));
		Criteria2Dropdown.selectByVisibleText("contains");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Add contact on search contact page wait");
			e.printStackTrace();
		}
		BasePage.driver.findElement(By.xpath(SecondRowTextBox)).sendKeys(EmailValue);
		
		BasePage.driver.findElement(By.xpath(ApplyConditionButton)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Add contact on search contact page wait");
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(SmartContactGridDataLoad);
		BasePage.driver.findElement(By.xpath(SaveButton)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Add contact on search contact page wait");
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(GroupListPage.GroupListDataLoad);
		GetEditedSmartGroup=BasePage.driver.findElement(By.xpath(EditedSmartGroup)).getText();
		return(GetEditedSmartGroup);
	}
}
