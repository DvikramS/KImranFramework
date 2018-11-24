package Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import Base.BasePage;

import com.google.common.base.Function;
import com.thoughtworks.selenium.Wait;

public class ErrorUtility {
	private static Map<ITestResult,List> verificationFailuresMap = new HashMap<ITestResult,List>();
	private static Map<ITestResult,List> skipMap = new HashMap<ITestResult,List>();

	
	     public static void addVerificationFailure(Throwable e) {
				List verificationFailures = getVerificationFailures();
				verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);
				verificationFailures.add(e);
			}
		  
		  public static List getVerificationFailures() {
				List verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
				return verificationFailures == null ? new ArrayList() : verificationFailures;
			}
		 
		  public static WebElement fluentWait(final By Locator){
		        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(BasePage.driver)
		                .withTimeout(30, TimeUnit.SECONDS)

		                .pollingEvery(5, TimeUnit.SECONDS)

		        .ignoring(org.openqa.selenium.NoSuchElementException.class);
		        WebElement f = wait.until(
		                new Function<WebDriver, WebElement>() {
		                    public WebElement apply(WebDriver driver) {
		                        return driver.findElement(Locator);
		                    }
		                }
		        );
		        return  f;
		    };
}
