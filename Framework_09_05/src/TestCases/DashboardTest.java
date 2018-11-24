package TestCases;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import Util.UtilityFunctions;
import Base.BasePage;

public class DashboardTest {

	@Test(priority=1)
	public void selectInquiriestab() throws InterruptedException
	{
		if (UtilityFunctions.IsExecutable("selectInquiriestab",
				BasePage.xls) != true)
			throw new SkipException("Run Mode Set to No");

		
		System.out.println("Inside Dashboard Test4");
		BasePage.driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li/a[contains(text(),'PIERPro')]")).click();
		BasePage.driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[4]/ul/ul/ul/li/a[text()='Dashboard']")).click();
		Thread.sleep(7000);
		BasePage.driver.findElement(By.xpath("//*[@id='divDashboard']/div[2]/ul/li/a/div[contains(text(),'Inquiries')]")).click();
		
		try {
			Thread.sleep(10000);
			System.out.println("Test4 Ends");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void selectContacttab() throws InterruptedException
	{
		if (UtilityFunctions.IsExecutable("selectContacttab",
				BasePage.xls) != true)
			throw new SkipException("Run Mode Set to No");
		System.out.println("Inside Dashboard Test5");
		BasePage.driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li/a[contains(text(),'PIERPro')]")).click();
		BasePage.driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[4]/ul/ul/ul/li/a[text()='Dashboard']")).click();
		Thread.sleep(7000);
		BasePage.driver.findElement(By.xpath("//*[@id='divDashboard']/div[2]/ul/li/a/div[contains(text(),'Contacts')]")).click();
		
		try {
			Thread.sleep(10000);
			System.out.println("Test5 Ends");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
		@Test(priority=3, groups = {"Dashboard"})
		public void selectExcerpttab() throws InterruptedException
		{
			if (UtilityFunctions.IsExecutable("selectExcerpttab",
					BasePage.xls) != true)
				throw new SkipException("Run Mode Set to No");
			System.out.println("Inside Dashboard Test6");
			BasePage.driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li/a[contains(text(),'PIERPro')]")).click();
			BasePage.driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[4]/ul/ul/ul/li/a[text()='Dashboard']")).click();
			Thread.sleep(10000);
			BasePage.driver.findElement(By.xpath("//*[@id='divDashboard']/div[3]/div[1]/div/div[2]/div[1]/table/tbody/tr/td[3]/a")).click();
			
			try {
				Thread.sleep(10000);
				System.out.println("Test6 Ends");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
			@Test(priority=4, groups = {"Dashboard"})
			public void selectContact() throws InterruptedException
			{
				if (UtilityFunctions.IsExecutable("selectExcerpttab",
						BasePage.xls) != true)
					throw new SkipException("Run Mode Set to No");
				System.out.println("Inside Dashboard Test7");
				try {
				BasePage.driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li/a[contains(text(),'PIERPro')]")).click();
				BasePage.driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[4]/ul/ul/ul/li/a[text()='Dashboard']")).click();
				Thread.sleep(7000);
				BasePage.driver.findElement(By.xpath("//*[@id='divDirectoryGrid']/div[2]/table/tbody/tr/td/div[contains(text(),'Others')]123")).click();
				//BasePage.driver.navigate().back();
				
				
					Thread.sleep(10000);
					System.out.println("Test7 Ends");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Taking Screenshot for test7");
					UtilityFunctions.takeScreenshot("SelectContact");
				}
				
			}
				@Test(priority=5, groups = {"Dashboard"})
				public void selectContactGroup() throws InterruptedException
				{
					System.out.println("Inside Dashboard Test8");
					System.out.println("End Test8");
	             }
}
