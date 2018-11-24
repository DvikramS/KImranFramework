package Util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Base.BasePage;


public class UtilityFunctions {

	// Class variables

	private static Statement stmt = null;
	private static Connection conn = null;
	private static SimpleDateFormat formatter = null;
	

	// Checks if the test case is executable or not
	public static boolean IsExecutable(String testName, ExcelUtility xls) {
		for (int rNum = 2; rNum <= xls.getRowCount("TestCases"); rNum++) {
			if (testName.equals(xls.getCellData("TestCases", "TCID", rNum))) {
				if (xls.getCellData("testCases", "RunMode", rNum).equals("Y"))
					return true;
				else
					return false;
			}// end
		}
		return false;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	// Read data from the excel file. Takes two arguments - Test Case Name and
	// XLS_Reader object. Reads the test data from the Test Data excel and
	// return the test data in 2 D object array form
	public static Object[][] getData(String TestCaseName, ExcelUtility xls) {
		// find test in the excel file
		// find number of columns in the test
		// find number of rows in the test
		// print the data of the test
		// put the data in object array

		// Get the start row index for the test data of the given Test Case name
		int testCaseStartIndex = 0;

		for (int rNum = 1; rNum <= xls.getRowCount("TestData"); rNum++) {
			if (TestCaseName.equals(xls.getCellData("TestData", 1, rNum))) {
				testCaseStartIndex = rNum;
				break;
			}// end of if
		}// end of for

		// Get the number of columns in the test data (which is available column
		// wise) for the given test case
		int testCaseDataColumnNamesStartIndex = testCaseStartIndex + 1;

		int Cols = 2;
		while (!(xls.getCellData("TestData", Cols,testCaseDataColumnNamesStartIndex).equals(""))) {
			Cols++;
		}// end of while

		int numberOfTestDataColumns = Cols - 2;

		int testCaseDataStartIndex = testCaseStartIndex + 2;

		int rows = 0;
		while (!xls.getCellData("TestData", 2, (testCaseDataStartIndex + rows))
				.equals("")) {
			rows++;
		} // end of while
		int numberofTestDataSets = rows;

		// Store the test data sets of a single test case in an array of
		// HashTable. Each HasTable will contain one test data set
		Object[][] dataSetCollection = new Object[numberofTestDataSets][1];

		Hashtable<String, String> TestDataSet = null;
		String Datakey = "'";
		String Keyvalue = "";
		int index = 0;
		for (int r = testCaseDataStartIndex; r < (testCaseDataStartIndex + numberofTestDataSets); r++) {
			TestDataSet = new Hashtable<String, String>();

			for (int c = 2; c < (numberOfTestDataColumns + 2); c++) {

				Datakey = xls.getCellData("TestData", c,
						testCaseDataColumnNamesStartIndex);
				Keyvalue = xls.getCellData("TestData", c, r);
				TestDataSet.put(Datakey, Keyvalue);

			}// end of for
				// Once all the Column Name Value pair is stored in the
				// HashTable for a row, add this Hash Table in the 2 D array of
				// Objects
			dataSetCollection[index][0] = TestDataSet;
			index++;
		}// end of for

		return dataSetCollection;

	}// end of function

	// --------------------------------------------------------------------------------------------------------------------------------

	// Converts the ArrayList to comma separated string. Take argument as Array
	// List of type string and returns a comma separated string containing all
	// the values of the Array List
	public static String convertStringArrayListToCommaSeparatedString(
			ArrayList<String> arrList) {
		StringBuilder commaSepValueBuilder = new StringBuilder();
		int arrListSize = arrList.size();

		for (int i = 0; i < arrListSize; i++) {
			commaSepValueBuilder.append(arrList.get(i));
			// if the value is not the last element of the list
			// then append the comma(,) as well
			if (i != arrListSize - 1) {
				commaSepValueBuilder.append(", ");
			}// end of if
		}// end of for

		return commaSepValueBuilder.toString();
	}// end of function

	// --------------------------------------------------------------------------------------------------------------------------------
	// Creates data base connection
	
	private static boolean connectToDatabase() {
		// Method variables
		boolean isDBConnected = false;

		// Creates connection string
		String dbURL = BasePage.TestConfiguration.getProperty("DatabaseUrl");

		Properties connectionProps = new Properties();
		connectionProps.put("user", "sa");
		connectionProps.put("password", "Passw0rd");

		System.out.println("dbURL = " + dbURL);
		try {
			//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver"); 
			conn = DriverManager.getConnection(dbURL, connectionProps);
			if (conn != null) {
				isDBConnected = true;
				stmt = conn.createStatement();
				System.out.println("database connected successfully");
			}// end of if

		}// end of try
		catch (SQLException se) {
			do {
				System.out.println("SQL STATE: " + se.getSQLState());
				System.out.println("ERROR CODE: " + se.getErrorCode());
				System.out.println("MESSAGE: " + se.getMessage());
				System.out.println();
				se = se.getNextException();
			} while (se != null);
		}// end of catch
 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isDBConnected;

	}// end of function


	// --------------------------------------------------------------------------------------------------------------------------------
/*
	// Returns the rowcount of the table name
	public static int getTableRowCount(String TableName) {

		int rowCount = -1;
		ResultSet rs = null;

		if (connectToDatabase() == true) {
			try {
				rs = stmt.executeQuery("SELECT COUNT(*) AS COUNT FROM "
						+ TableName);
				System.out.println("insiide getTableRowCount ");

				while (rs.next()) {

					rowCount = rs.getInt("COUNT");
				}// end of while

			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}

		}// end of if

		System.out.println(" rowCount = " + rowCount);
		closeDatabaseConnection();
		return rowCount;

	}// end of function

	// --------------------------------------------------------------------------------------------------------------------------------

	// Executes the query and pass the result set object containing the rows
	public static ResultSet executeSelectQuery(String Query) {
		// Method variables
		ResultSet rs = null; // To store the result set of the query

		if (connectToDatabase() == true) {

			try {
				rs = stmt.executeQuery("SELECT ShortName FROM dbo.Part");
				System.out.println(rs);
				
			} // end of try
			catch (SQLException se) {
				do {
					System.out.println("SQL STATE: " + se.getSQLState());
					System.out.println("ERROR CODE: " + se.getErrorCode());
					System.out.println("MESSAGE: " + se.getMessage());
					System.out.println();
					se = se.getNextException();
				} while (se != null);
			}// end of catch

		}// end of if
		//closeDatabaseConnection();
		return rs;

	}// end of function

	// --------------------------------------------------------------------------------------------------------------------------------
	// Closes the database connection
	private static void closeDatabaseConnection() {
		try {
			conn.close();
		}// end of if
		catch (SQLException sqlEX) {
			System.out.println("Already closed");
		}// end of else
	}// end of function

	// --------------------------------------------------------------------------------------------------------------------------------

	// Checks whether the count of rows in the database table matches the count
	// of rows on the data grid

	public static String[][] getGridData(int columnHeaderCount,
			WebElement varDataTable, String databaseTableName) {

		int recordCount = getTableRowCount(databaseTableName);
		String[][] tableData = new String[recordCount][columnHeaderCount];

		List<WebElement> rows = varDataTable.findElements(By.tagName("tr"));

		WebElement row = null;
		List<WebElement> rowCells = null;

		boolean flag = true;

		Actions act = new Actions(BasePage.driver);
		int i = 0;
		while (flag) {
			try {

				rows = varDataTable.findElements(By.tagName("tr"));
				row = rows.get(i);
				rowCells = row.findElements(By.tagName("td"));

				while (rowCells.get(0).getText().isEmpty()) {
					act.sendKeys(Keys.PAGE_DOWN).build().perform();
					Thread.sleep(2000);
					rows = varDataTable.findElements(By.tagName("tr"));
					row = rows.get(i);
					rowCells = row.findElements(By.tagName("td"));

				}

				for (int j = 0; j < columnHeaderCount; j++) {
					tableData[i][j] = rowCells.get(j).getText();

				}
				i++;

			} catch (Exception e) {

				flag = false;
				e.printStackTrace();
				System.out.println("inside exception");

			}

		}

		return tableData;

	}
*/
	// --------------------------------------------------------------------------------------------------------------------------------
	// check whether element with given XPath is present or not
	public static boolean isElementPresent(String XPath) {
		try {
			BasePage.driver.findElement(By.xpath(XPath));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// --------------------------------------------------------------------------------------------------------------------------------

	// To check whether a link is present or not
	public static boolean isLinkPresent(String XPath) {
		try {
			BasePage.driver.findElement(By.linkText(XPath));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	//

	public static Date convertStringToDate(String dateInString,
			String dateFormat) {
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return date;

	}

	// Refresh Current Browser Page
	public static void refresh() {
		BasePage.driver.navigate().refresh();
		// Insert thread .sleep
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// update results for a particular data set
	public static void reportDataSetResult(ExcelUtility xls,
			String testCaseName, int rowNum, String result) {
		xls.setCellData(testCaseName, "Results", rowNum, result);
	}

	// Take screen shot of error
	public static boolean takeScreenshot(String filename) {
		File scrFile = ((TakesScreenshot) BasePage.driver)
				.getScreenshotAs(OutputType.FILE);
		String absoluteFileName = BasePage.TestConfiguration
				.getProperty("ScreenShotPath") + "\\" + filename + ".jpg";
		try {
			FileUtils.copyFile(scrFile, new File(absoluteFileName));

			Reporter.log("<h1><br>" + BasePage.currentMethodName  + "</h1></br> <h2><br>" + filename	+ ".jpg" + "</h2></br>");
			Reporter.log("<a href='" + absoluteFileName + "'>"
					+  "<img src='" + absoluteFileName
					+ "' height='200' width='200'/> </a>");
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static void applicationWait(int timeInMilliSeconds) {

		try {
			Thread.sleep(timeInMilliSeconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkInputDataIsNotBlank(
			Hashtable<String, String> TestDataSet) {
		boolean testDataIsNotBlank = true;

		Enumeration<String> values = TestDataSet.elements();
		while (values.hasMoreElements() && testDataIsNotBlank) {
			if (values.nextElement() == "") {
				testDataIsNotBlank = false;
			}

		}
		return testDataIsNotBlank;

	}


	
	public static ArrayList<String> getDataForSorting(String [][] gridData,int columnIndex)
	{
		ArrayList<String> listOfDataForSorting = new ArrayList<String>();
		
		for(int i=0 ;i<gridData.length;i++)
		{
			listOfDataForSorting.add((gridData[i][columnIndex]).toUpperCase());
		}
		for(int i=0 ;i<gridData.length;i++)
		{
			System.out.println(listOfDataForSorting.get(i));
		}
		
		return listOfDataForSorting; 
	}

	
	
	public static boolean checkSortingOfColumn(ArrayList<String> dataForSorting,String sortType,String sortColumnName)
	{
		//Name of Columns which are in DATE format 
		String DateColumn1 ="XUpdated DateX";
		String DateColumn2 ="XCreation DateX";
		
		//Check If Column's are in date format - Go into If condition 
		if(sortColumnName.equalsIgnoreCase(DateColumn1) || sortColumnName.equalsIgnoreCase(DateColumn2))
		{
			//Logic for converting string array list into Date format
			for(int i=0;i<dataForSorting.size()-1;i++)
			{
				String dateString1 = dataForSorting.get(i);
		        String dateString2 = dataForSorting.get(i+1);
		        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm");
			    Date date1=null;
			    Date date2=null;
			    try
			    {
			    	date1 = sdf.parse(dateString1);
			    	date2 = sdf.parse(dateString2);
			        
			    	//Check Sorting for Ascending Order
			    	if (sortType.equalsIgnoreCase("ASC"))
			    	{	
			    		
			    		//logic for sorting
			    		if(date1.compareTo(date2)>0)
			    		{
			    			//Return false if data in not sorted 
			    			return false;
			            }
			    	}
			    	//Check Sorting for Descending Order
			    	else
			    	{
			    		//logic for sorting
			    		if(date1.compareTo(date2)<0)
			    		{
			    			//Return false if data in not sorted 
			    			return false;
			    		}
			            	
			    	}
			    }
			    catch (Exception e) 
			    {
			    	System.out.println("Exception  - "+e);
			    }
			    
			}
		}
		//Else condition - Check sorting for Column's are Not in date format - 
		else
		{
			//Check Sorting for Ascending Order
			if (sortType.equalsIgnoreCase("ASC"))
			{
				//logic for sorting
				for(int i=0;i<dataForSorting.size()-1;i++)
				{
					if(dataForSorting.get(i).compareTo(dataForSorting.get(i+1))>0)
					{
						//Return false if data in not sorted 
						return false;
					}
				}
			}
			//Check Sorting for Descending Order
			else
			{
				//logic for sorting
				for(int i=0;i<dataForSorting.size()-1;i++)
				{
					if(dataForSorting.get(i).compareTo(dataForSorting.get(i+1))<0)
					{
						//Return false if data in not sorted 
						return false;
					}
				}
			}
		}
		return true;
	}	
	
    public static void copyAndPasteValues(WebElement SourceLocation, WebElement DestinationLocation)
    {
           //Copy Selected Data from Source Location
           SourceLocation.sendKeys(Keys.CONTROL,"a"); 
           SourceLocation.sendKeys(Keys.CONTROL,"c"); 
           
           //Compare Source and Destination Locations are same
           if(SourceLocation.equals(DestinationLocation)) 
                  UtilityFunctions.refresh();
           
           //Clear Destination Location
           DestinationLocation.clear();
           
           //Check Destination Field clear
           if(DestinationLocation.getAttribute("value").length()!=0)
                  DestinationLocation.clear();
                  
           //for(int i=1;i<=t;i++) //to be uncommented by Yatendra
           
           //Paste Copied value into Source Location
           DestinationLocation.sendKeys(Keys.CONTROL,"v");
    }

	public static void WaitUntilPresenceOfElement(String Locater)
	{
		WebDriverWait wait = new WebDriverWait(BasePage.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locater))); 
	}

	
}// end of class

