package Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Page.LoginPage;
import Util.ExcelUtility;

public class BasePage {
	public static WebDriver dr = null;
	public static EventFiringWebDriver driver = null;
	public LoginPage login;

	private File file = null;
	public String Browser;
	public String AppURL;

	public static boolean IsLoggedIn = false;
	public static boolean BrowserIsClosed = true;
	public static Properties TestConfiguration = null;
	public static String currentMethodName = null;

	//Application level variables
    public static String HeaderMenuPIERPro = "//*[@id='navbar-collapse-1']/ul/li/a[contains(text(),'PIERPro')]";
	
    
    
	static {
		// initialize properties object
		TestConfiguration = new Properties();
		File f = new File(System.getProperty("user.dir")
				+ "\\src\\Config\\TestConfig.properties");

		System.out.println(f.toString());
		try {
			FileInputStream fs = new FileInputStream(f);

			TestConfiguration.load(fs);
		} catch (Exception e) {
		}

	}
	
	    static String TestDataPath= TestConfiguration.getProperty("TestInputSheetPath");
	    public static ExcelUtility xls = new ExcelUtility(System.getProperty("user.dir")+TestDataPath);
	/*public static ExcelUtility xls = new ExcelUtility(
			TestConfiguration.getProperty("TestInputSheetPath")); // imran added changes in path
     */
	
	public BasePage() {

	}

	public BasePage(String browser, String AppURL) {

		if (driver == null || BrowserIsClosed == true) {

			if (browser.equals("Mozilla")) {
				dr = new FirefoxDriver();
				dr.navigate().to(AppURL);
			} else if (browser.equals("IE")) {
				file = new File(System.getProperty("user.dir")
						+ "\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver",
						file.getAbsolutePath());

				DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
				dc.setCapability("nativeEvents", false);
				dr = new InternetExplorerDriver(dc);
				dr.navigate().to(AppURL);

			} else if (browser.equals("IE"))
            {
        	 	file = new File(System.getProperty("user.dir")+"\\..\\IE Driver\\IEDriverServer.exe");
        	    System.setProperty("webdriver.ie.driver", file.getAbsolutePath() );  

        	    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        	    
        		capabilities.setCapability("initialBrowserUrl",AppURL);
        		capabilities.setCapability("requireWindowFocus",true);
        		capabilities.setCapability("nativeEvents",true);
        		
        		 dr = new InternetExplorerDriver(capabilities);
           
        }
        else if (browser.equals("Chrome"))
        {
        	file = new File(System.getProperty("user.dir")+"\\chromedriver.exe");
        	System.setProperty("webdriver.chrome.driver", file.getAbsolutePath() );  
    	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("test-type","start-maximized");
    		capabilities.setCapability("chrome.binary",file.getAbsolutePath() );
    		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	    dr = new ChromeDriver(capabilities);
    	    dr.navigate().to(AppURL);
         }
			driver = new EventFiringWebDriver(dr);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// If browser opens successfully and there is no exception then set
			// BrowserIsClosed to false
			BrowserIsClosed = false;
			

		}

	}

}
