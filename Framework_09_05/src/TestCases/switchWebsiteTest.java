package TestCases;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import Page.*;
import Util.UtilityFunctions;
import Base.BasePage;

public class switchWebsiteTest {
	
	SwitchWebsitePage SwitchW;
	
	
	@Test
    public void switchWebsite()
	{
		SwitchW = new SwitchWebsitePage();
    	if (UtilityFunctions.IsExecutable("switchWebsite",
				BasePage.xls) != true)
			throw new SkipException("Run Mode Set to No");
    	System.out.println("Inside SwitchWebsite Test3");
    	try {
			SwitchW.selectMircosite();
			System.out.println("SwitchWebsite Test Ends");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	


}
