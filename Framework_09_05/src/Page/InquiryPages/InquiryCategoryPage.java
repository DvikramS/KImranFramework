package Page.InquiryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;
import Util.UtilityFunctions;

public class InquiryCategoryPage {

	private static String MenuInquiryCategories=".//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Inquiry Categories')]";
	
	private static String InquiryCatgeoriesAssertLabel1="//*[@id='divCategoryList']/div/div/h1/div[contains(text(),'Manage Inquiry Category')]";
	private static String InquiryCategoryTableHeader="//*[@id='divCategoryList']/div[2]/div[2]/table/thead/tr/th[1]";
	private static String InquiryCatgeoriesAssertLabel2="//*[@id='divCategoryList']/div[2]/div[2]/table/tbody/tr[1]/td[1]";
	private static String InquiryCatgeoriesAssertLabel3;
	//private static String AddCategoryButton="//*[@id='divCategoryList']/div[1]/div/h1/div[2]/span/a/i";
	private static String AddCategoryButton="//*[@id='divCategoryList']/div[1]/div/h1/div[2]/span/a";
	private static String CategoryName="Category";
	private static String IsPublicCheckbox="//*[@id='form_category']/div[2]/div/div/div/span/input";
	private static String AddButton="//*[@id='add-category-modal']/div/div/div[3]/button[contains(text(),'Add')]";
	private static String InquiryCatgeoriesAssertLabel4;
	private static String InquiryCatgeoriesAssertLabel5;
	private static String SaveButton="//*[@id='add-category-modal']/div/div/div[3]/button[contains(text(),'Save')]";
	private static String Pagination="//*[@id='divCategoryList']/div[2]/div[5]/div/div[1]/div/label/select";
	static int selectOptions;
	static WebElement CheckBox1;
	private static String CheckBoxStatus;
	private static String Value;
	
	public static String NavigateToInquriyCategory()
	{
		 BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
         BasePage.driver.findElement(By.xpath(MenuInquiryCategories)).click(); 
         try {
		 Thread.sleep(5000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
         
         UtilityFunctions.WaitUntilPresenceOfElement(InquiryCategoryTableHeader);
         InquiryCatgeoriesAssertLabel3= BasePage.driver.findElement(By.xpath(InquiryCatgeoriesAssertLabel1)).getText();
         return(InquiryCatgeoriesAssertLabel3);
	}
	
	public static String AddInquiryCategory(String CategoryNameValue)
	{
		String AddedCategory="//*[@id='divCategoryList']/div[2]/div/table/tbody/tr/td[contains(text(),'"+CategoryNameValue+"')]";
		BasePage.driver.findElement(By.xpath(AddCategoryButton)).click();
		try {
			 Thread.sleep(3000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		 BasePage.driver.findElement(By.id(CategoryName)).sendKeys(CategoryNameValue);
		 BasePage.driver.findElement(By.xpath(IsPublicCheckbox)).click();
		 try {
			 Thread.sleep(2000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		 BasePage.driver.findElement(By.xpath(AddButton)).click();
		 try {
			 Thread.sleep(4000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		 
		 UtilityFunctions.WaitUntilPresenceOfElement(InquiryCatgeoriesAssertLabel2);
		 InquiryCatgeoriesAssertLabel4=BasePage.driver.findElement(By.xpath(AddedCategory)).getText();
		 return(InquiryCatgeoriesAssertLabel4);
	}
	
	public static String EditInquiryCategory(String CategoryNameValue)
	{
		String EditedCategory="//*[@id='divCategoryList']/div[2]/div/table/tbody/tr/td[contains(text(),'"+CategoryNameValue+"')]";
		String CategoryToBeEdited="//*[@id='divCategoryList']/div[2]/div[2]/table/tbody/tr[1]/td[contains(text(),'"+InquiryCatgeoriesAssertLabel4+"')]/following-sibling::td/i[1]";
		
		try {
			 Thread.sleep(4000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		BasePage.driver.findElement(By.xpath(CategoryToBeEdited)).click();
		try {
			 Thread.sleep(2000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		 BasePage.driver.findElement(By.id(CategoryName)).clear();
		 BasePage.driver.findElement(By.id(CategoryName)).sendKeys(CategoryNameValue);
		 //BasePage.driver.findElement(By.xpath(IsPublicCheckbox)).click();
		 BasePage.driver.findElement(By.xpath(SaveButton)).click();
		 try {
			 Thread.sleep(4000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		 
		 UtilityFunctions.WaitUntilPresenceOfElement(InquiryCatgeoriesAssertLabel2);
		 InquiryCatgeoriesAssertLabel5=BasePage.driver.findElement(By.xpath(EditedCategory)).getText();
		 return(InquiryCatgeoriesAssertLabel5);
	}
	
	//Function to set catgeory visibilty
	public static String SetCategoryVisibilty(String CategoryNameValue)
	{
		String CategoryCheckbox="//*[@id='divCategoryList']/div[2]/div[2]/table/tbody/tr/td[contains(text(),'"+InquiryCatgeoriesAssertLabel5+"')]/following-sibling::td/div/label/div/span/input";
		
		BasePage.driver.findElement(By.xpath(CategoryCheckbox)).click();
		try {
			 Thread.sleep(2000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		Select selectBox = new Select(BasePage.driver.findElement(By
	            .xpath(Pagination)));
	    selectOptions = selectBox.getOptions().size();
	    System.out.println(selectOptions);
	    selectBox.selectByIndex(selectOptions - 1);
		
		 try {
			 Thread.sleep(4000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		 
		 
		 CheckBox1 = BasePage.driver.findElement(By.xpath(CategoryCheckbox));

		 	Value= CheckBox1.getAttribute("value");
		    if(Value.equals("true")){
		    	CheckBoxStatus="Selected";
		    }
		    else if(Value.equals("false")) 
		    	{CheckBoxStatus="Unselected";}
		    else
		    	CheckBoxStatus="Undefined";
		/*    if(CheckBox1.isSelected()){
		    	CheckBoxStatus="Selected";
		    }
		    else 
		    	CheckBoxStatus="Unselected";
		   */ 
		    //To set category public again
		   // BasePage.driver.findElement(By.xpath(CategoryCheckbox)).click();
		    
		 return(CheckBoxStatus);
	}
}
