package Page.Document;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;

import Base.BasePage;
import Util.UtilityFunctions;

public class DocumentManagementPage {

	private static String MenuDocument="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Documents')]";
	
	public static String MenuPIERPro_DNN="//*[@id='ControlNav']/li[4]/a";
	private static String MenuDocument_DNN="//*[@id='ControlNav']/li[4]/ul/ul[3]/ul[2]/li/a";
	
	private static String AddFolder="//*[@class='MenuBar']/div[5]/a[@id='addFolder']";
	public static String DocumentManagementPageLoadAssert="//*[@class='VCBox sm-VCBox']/table/tbody/tr/td/div/div/div/div[2]/table[2]/tbody/tr/td[3]/div/nobr";  //Search Result Text path
	public static String DocumentManagementPageHeaderPath="//*[@class='sm-report-heading clearfix']/div[1]";
	public static String DocumentManagementLabel="Document Management";
	private static String AddedFolderInLeftPanel="//*[@class='VCBox sm-VCBox']/table/tbody/tr/td/div/div/div/div[2]/div/table/tbody/tr/td[4]/div/nobr";
	//Path for folder added under Document Exchange Folder
	private static String StartFolderPath="//*[@class='VCBox sm-VCBox']/table/tbody/tr/td/div/div/div/div[2]/div/table/tbody/tr/td[4]/div/nobr[contains(text(),'";
	private static String EndFolderPath="')]";
	private static String AddedFolder_DMF;
	private static String AddedFolder_DMF2;
	private static String CreateButtonDocumentFileXpath="//*[@class='mnuCreateCallBack']/div/div/table/tbody/tr/td/nobr/div/a/span";
	private static String HtmlPageLink="//*[@class='cart-outer']/span[contains(text(),'Html Page')]";
	private static String CreateButtonDocumentFile="Create";
	//private static String HtmlPageLink="Html Page";
	public static String StartAddedDocumentFilePath="//tbody/tr/td/div/div[contains(text(),'";
	public static String EndAddedDocumentFilePath="')]";
	public static String AddedDocument;
	public static String AddedDocumentStatus="/ancestor::td[1]/following-sibling::td[2]/div/div"; //While using this path append StartAddedDocumentFilePath + Headline + EndAddedDocumentFilePath + AddedDocumentStatus 
	private static String NewDraftButton="/ancestor::td[1]/following-sibling::td[4]/div/div[2]/a[2]";  //While using this path append StartAddedDocumentFilePath + Headline + EndAddedDocumentFilePath +NewDraftButton
	private static String ViewApporveButton="/ancestor::td[1]/following-sibling::td[4]/div/div[2]/a[3]";  //While using this path append StartAddedDocumentFilePath + Headline + EndAddedDocumentFilePath +ViewApporveButton
	private static String NewDraftToggleButton="/ancestor::td[1]/preceding-sibling::td[2]/div[1]"; //While using this path append StartAddedDocumentFilePath + Headline + EndAddedDocumentFilePath +NewDraftToggleButton
	private static String UnArchiveButton="/ancestor::td[1]/following-sibling::td[4]/div/div[1]/a[6]";  //While using this path append StartAddedDocumentFilePath + Headline + EndAddedDocumentFilePath +UnArchiveButton
	private static String ArchiveButtonLink="/ancestor::td[1]/following-sibling::td[4]/div/div[1]/a[4]";  //While using this path append StartAddedDocumentFilePath + Headline + EndAddedDocumentFilePath +UnArchiveButton
	private static String UnPublishButton="/ancestor::td[1]/following-sibling::td[4]/div/div[1]/a[2]";  //While using this path append StartAddedDocumentFilePath + Headline + EndAddedDocumentFilePath +UnPublishButton
	private static String DeleteDocumentButton="/ancestor::td[1]/following-sibling::td[4]/div/div[1]/a[1]";  //While using this path append StartAddedDocumentFilePath + Headline + EndAddedDocumentFilePath +UnPublishButton
	public static String DeleteDocumentLabel="This will delete the document.";
	private static String NewDocumentFromDraftButton="/ancestor::td[1]/following-sibling::td[4]/div/div[2]/a[4]";  //While using this path append StartAddedDocumentFilePath + Headline + EndAddedDocumentFilePath +NewDocumentFromDraft
	private static String ManageTemplateButton="Manage Templates";
	private static String ManageSignaturesButton="Manage Signatures";
	private static String directHTMLPageNavigationPath="/DocumentManagement?Command=Core_Edit&CollectionId=26106&EntryType=File.Htm&ShowUpload=False";
	private static String EditFolderLink="//*[@id='EditFolderLink']";
	private static String ViewDescription="//*[@id='step1']/div/div[2]/h3/a";
	private static String ViewFolderOptions="//*[@id='step1']/div/div[4]/h3/a";
	private static String ViewDescriptionIframe="//*[@class='dnnLeft']/div/div/table/tbody/tr[3]/td/iframe";
	private static String SaveButton="//*[@id='step1']/div/div[8]/div/input[2]";
	private static String FolderViewTemplateLabelPath="//*[@id='threeE']/div[1]/div[1]/label";
	public static String FolderViewTemplateLabel="Folder view template:";
	private static String DocumentViewTemplatePath="//*[@id='threeE']/div[1]/div[1]/label";
	public static String DocumentViewTemplateLabel="Folder view template:";
	
	//Elements on UnPublish Pop-up
	private static String UnPublishButton_UnPublishPopup="//*[@id='mdlUnPublish']/div/div/div[3]/button[2]";
	private static String CancelButton_UnPublishPopup="//*[@id='mdlUnPublish']/div/div/div[3]/button[1]";
	private static String UnPublish_labelPath="//*[@id='mdlUnPublish']/div/div/div[2]/table/tbody/tr[1]/td";
	public static String UnPublish_label="This will unpublish the following document, removing it from the external site. ";
	
	
	//Add Folder PopUp Elements
	private static String CreateButton="//*[@id='CreateFolder']/div/div/div[3]/button[2]";
	private static String CancelButton="//*[@id='CreateFolder']/div/div/div[3]/button[1]";
	private static String CreateFolderLabelPath="//*[@id='CreateFolder']/div/div/div[1]/h4";
	private static String CreateFolderCrossLink="//*[@id='CreateFolder']/div/div/div[1]/button";
	private static String FolderNameInputbox="//*[@id='CreateFolder']/div/div/div[2]/div/div/div/div/input";
	
	private static String DocumentManagementAssertText1;
	public static String DocumentManagementAssertText2;
	public static String DocumentManagementAssertText3;
	public static String DocumentManagementAssertText4;
	public static String AddedDocument_DMF3;
	public static String AddedDocument_DMF4;
	public static String AddedDocument_DMF5;
	public static String AddedDocument_DMF6;
	public static String DocumentManagementAssertText6;
	public static String DocumentManagementAssertText7;
	public static String DocumentManagementAssertText8;
	public static String DocumentManagementAssertText9;
	public static String DocumentManagementAssertText10;
	public static String DocumentManagementAssertText11;
	public static String DocumentManagementAssertText12;
	public static String DocumentManagementAssertText13;
	public static String DocumentManagementAssertText14;
	public static String DocumentManagementAssertText15;
	public static String DocumentManagementAssertText16;
	public static String DocumentManagementAssertText17;
	public static String DocumentManagementAssertText18;
	public static String DocumentManagementAssertText19;
	public static String DocumentManagementAssertText20;
	
	public static String EditDocument;
	public static String ToggleButtonOfDraft;
	public static String EditedDraftVersionName;
	public static String DocumentManagementAssertText5;
	public static String View_ApproveDocument;
	public static String UnArchiveDocument;
	public static String ArchiveDocumentLink;
	public static String UnPublishLink;
	public static String DeleteDocumentLink;
	public static String NewDocumentFromDraftLink;
	static Alert alert1;
	static Alert alert2;
	static Alert alert3;
	public static String DocumentStatusPath1;
	
	
	//Navigate to document management page
	public static String NavigateToDocumentManagementPage()
	{
		 BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
         BasePage.driver.findElement(By.xpath(MenuDocument)).click(); 
         try {
		 Thread.sleep(15000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPageLoadAssert);
         
         //Navigate twice because of bug
         BasePage.driver.findElement(By.xpath(MenuPIERPro_DNN)).click();
         BasePage.driver.findElement(By.xpath(MenuDocument_DNN)).click(); 
         try {
		 Thread.sleep(8000);
    	 } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
         
         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPageLoadAssert);
         DocumentManagementAssertText1= BasePage.driver.findElement(By.xpath(DocumentManagementPageHeaderPath)).getText();
         return(DocumentManagementAssertText1);
	}
	
	//Navigate to document management page Once user is inside DNN
		public static String NavigateToDocumentManagementPage_FromDNN()
		{
			 BasePage.driver.findElement(By.xpath(MenuPIERPro_DNN)).click();
	         BasePage.driver.findElement(By.xpath(MenuDocument_DNN)).click(); 
	         try {
			 Thread.sleep(8000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
	         
	         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPageLoadAssert);
	         DocumentManagementAssertText1= BasePage.driver.findElement(By.xpath(DocumentManagementPageHeaderPath)).getText();
	         return(DocumentManagementAssertText1);
		}
	
		public static String NavigateToDocumentManagementPage_FromDNN_FromPublicView()
		{
			 BasePage.driver.findElement(By.xpath(MenuPIERPro_DNN)).click();
	         BasePage.driver.findElement(By.xpath(MenuDocument_DNN)).click(); 
	         try {
			 Thread.sleep(8000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
	        try{ 
	         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPageLoadAssert);
	         DocumentManagementAssertText1= BasePage.driver.findElement(By.xpath(DocumentManagementPageHeaderPath)).getText();
	        }catch(Exception E)
	        {
	        	NavigateToDocumentManagementPage_FromDNN();
	        }
	        return(DocumentManagementAssertText1);
		}
		
	//Add a folder from Add folder icon adjacent to folder tab
	public static DocumentManagementPage CreateFolderFromIcon(String FolderNameValue)
	{	
		AddedFolder_DMF=StartFolderPath+FolderNameValue+EndFolderPath;
		BasePage.driver.findElement(By.xpath(AddFolder)).click(); 
        try {
        	Thread.sleep(3000);
		 	DocumentManagementAssertText2=BasePage.driver.findElement(By.xpath(CreateFolderLabelPath)).getText(); 
		 	BasePage.driver.findElement(By.xpath(FolderNameInputbox)).sendKeys(FolderNameValue);
		 	BasePage.driver.findElement(By.xpath(CreateButton)).click();
		 	Thread.sleep(6000);
       	 
            UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPageLoadAssert);
            DocumentManagementAssertText3=BasePage.driver.findElement(By.xpath(AddedFolder_DMF)).getText();
        } catch (InterruptedException e) {
        	BasePage.driver.findElement(By.xpath(CancelButton)).click();
 			e.printStackTrace();
 		}    
            return new DocumentManagementPage();      
	}
	
	//Open create document document screen 
	public static void NavigateToCreateDocument(String FolderNameValue)
	{
		AddedFolder_DMF2=StartFolderPath+FolderNameValue+EndFolderPath;
		BasePage.driver.findElement(By.xpath(AddedFolder_DMF2)).click();
		try {
				Thread.sleep(10000);
				
				//new Actions(BasePage.driver).moveToElement(BasePage.driver.findElement(By.xpath(CreateButtonDocumentFileXpath))).build().perform();
				/*
				WebElement element = BasePage.driver.findElement(By.xpath(CreateButtonDocumentFileXpath));
				Locatable hoverItem = (Locatable) element;
				Mouse mouse = ((HasInputDevices) BasePage.driver).getMouse();
				mouse.mouseMove(hoverItem.getCoordinates()); 
				*/
				/*
				Actions action = new Actions(BasePage.driver);
				WebElement mainMenu = BasePage.driver.findElement(By.linkText(CreateButtonDocumentFile));
				action.moveToElement(mainMenu).moveToElement(BasePage.driver.findElement(By.xpath(HtmlPageLink))).click().build().perform();
				*/
				
				/* Fetching Microsite Name from URl
				String currentUrl = BasePage.driver.getCurrentUrl();
				System.out.println(currentUrl);
				int UrlLength=currentUrl.length();
				String getURLSubString=currentUrl.substring(7, UrlLength);
				System.out.println(getURLSubString);
				int SubStringLength=getURLSubString.length();
				String segments[] = getURLSubString.split("/");
				// Grab the last segment
				String document1 = segments[1];
				System.out.println(document1);
				*/
				//Currently not able to navigate to create document HTML page file from hover hence using direct URL navigation
				//BasePage.driver.get( BasePage.TestConfiguration.getProperty("DNN_Microsite_Url") + directHTMLPageNavigationPath);
				//System.out.println(BasePage.TestConfiguration.getProperty("DNN_Microsite_Url") + directHTMLPageNavigationPath);
				//((JavascriptExecutor) BasePage.driver).executeScript("$($('.cart-menu-top-item .cart-txt')[2]).trigger('mouseover')");
				
				((JavascriptExecutor) BasePage.driver).executeScript(
						"var obj = $('.cart-menu-top-item .cart-txt');"+
						"var targetElement;"+
						"for(var index = 0; index < obj.length; index ++)"+
				"{"+ 

							"if($(obj[index]).text().trim() == 'Create')"+
								"{"+
									"targetElement = obj[index];"+
									"break;"+
								"}"+

					"}"+

					"$(targetElement).trigger('mouseover');"+
						"");
				//BasePage.driver.findElement(By.linkText(CreateButtonDocumentFile)).click();
				Thread.sleep(1000);
				//BasePage.driver.findElement(By.xpath(CreateButtonDocumentFileXpath)).click();
				BasePage.driver.findElement(By.xpath(HtmlPageLink)).click();
				Thread.sleep(7000);
				
			} catch (Exception e) {
				System.out.println("Inside exception of create");
				e.printStackTrace();
			}
		 UtilityFunctions.WaitUntilPresenceOfElement(AddDocumentPage.PageHeader);
	}
	
	//Edit a document using New draft option
	public static void Edit_Document(String HeadlineValue,String FolderNameValue)
	{
		EditDocument=StartAddedDocumentFilePath + HeadlineValue + EndAddedDocumentFilePath +NewDraftButton;
		AddedDocument_DMF3=StartFolderPath+FolderNameValue+EndFolderPath;
		
		BasePage.driver.findElement(By.xpath(AddedDocument_DMF3)).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		BasePage.driver.findElement(By.xpath(EditDocument)).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UtilityFunctions.WaitUntilPresenceOfElement(AddDocumentPage.PageHeader);
	}
	
	public static String ValidateOldDraftVersion(String HeadlineValue, String NewHeadlineValue,String FolderNameValue)
	{
		ToggleButtonOfDraft=StartAddedDocumentFilePath + NewHeadlineValue + EndAddedDocumentFilePath +NewDraftToggleButton;
		EditedDraftVersionName=StartAddedDocumentFilePath + HeadlineValue + EndAddedDocumentFilePath;
		AddedDocument_DMF4=StartFolderPath+FolderNameValue+EndFolderPath;
		
		BasePage.driver.findElement(By.xpath(AddedDocument_DMF4)).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(EditedDraftVersionName);
		BasePage.driver.findElement(By.xpath(ToggleButtonOfDraft)).click();
		DocumentManagementAssertText5=BasePage.driver.findElement(By.xpath(EditedDraftVersionName)).getText();
		return(DocumentManagementAssertText5);
	}
	
	//Edit a document using View Approve option
		public static void ViewAndApproveDocument(String HeadlineValue,String FolderNameValue)
		{
			View_ApproveDocument=StartAddedDocumentFilePath + HeadlineValue + EndAddedDocumentFilePath +ViewApporveButton;
			AddedDocument_DMF3=StartFolderPath+FolderNameValue+EndFolderPath;
			
			BasePage.driver.findElement(By.xpath(AddedDocument_DMF3)).click();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			BasePage.driver.findElement(By.xpath(View_ApproveDocument)).click();
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			UtilityFunctions.WaitUntilPresenceOfElement(AddDocumentPage.PageHeader);
		}
		
		//Unarchive a document
		public static DocumentManagementPage UnArchiveDocument(String HeadlineValue,String FolderNameValue)
		{
			UnArchiveDocument=StartAddedDocumentFilePath + HeadlineValue + EndAddedDocumentFilePath +UnArchiveButton;
			AddedDocument_DMF3=StartFolderPath+FolderNameValue+EndFolderPath;
			DocumentStatusPath1=DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath+ DocumentManagementPage.AddedDocumentStatus;
			
			BasePage.driver.findElement(By.xpath(AddedDocument_DMF3)).click();
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			BasePage.driver.findElement(By.xpath(UnArchiveDocument)).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			alert1 = BasePage.driver.switchTo().alert();
			DocumentManagementAssertText6=alert1.getText();
			System.out.println(DocumentManagementAssertText6);
			alert1.accept();
			
			try {
		 		 Thread.sleep(8000);
		 		} catch (InterruptedException e) {
		 			e.printStackTrace();
		 		} 
				 UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPageLoadAssert);
		         DocumentManagementAssertText7=BasePage.driver.findElement(By.xpath(DocumentStatusPath1)).getText();
		         if(DocumentManagementAssertText7.equals("Archived"))
		        	 DocumentManagementAssertText8="True";
		         else
		        	 DocumentManagementAssertText8="False";
		         return new DocumentManagementPage();
		}
		
		//Archive a document from Document Management screen
		public static DocumentManagementPage ArchiveDocument_DMS(String HeadlineValue,String FolderNameValue)
		{
			ArchiveDocumentLink=StartAddedDocumentFilePath + HeadlineValue + EndAddedDocumentFilePath +ArchiveButtonLink;
			AddedDocument_DMF3=StartFolderPath+FolderNameValue+EndFolderPath;
			DocumentStatusPath1=DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath+ DocumentManagementPage.AddedDocumentStatus;
			
			BasePage.driver.findElement(By.xpath(AddedDocument_DMF3)).click();
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			BasePage.driver.findElement(By.xpath(ArchiveDocumentLink)).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			alert2 = BasePage.driver.switchTo().alert();
			DocumentManagementAssertText9=alert2.getText();
			System.out.println(DocumentManagementAssertText9);
			alert2.accept();
			
			try {
		 		 Thread.sleep(8000);
		 		} catch (InterruptedException e) {
		 			e.printStackTrace();
		 		} 
				 UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPageLoadAssert);
				 DocumentManagementAssertText10=BasePage.driver.findElement(By.xpath(DocumentStatusPath1)).getText();
		         return new DocumentManagementPage();
		}
		
		public static DocumentManagementPage UnPublishDocument_DMS(String HeadlineValue,String FolderNameValue)
		{
			UnPublishLink=StartAddedDocumentFilePath + HeadlineValue + EndAddedDocumentFilePath +UnPublishButton;
			AddedDocument_DMF3=StartFolderPath+FolderNameValue+EndFolderPath;
			DocumentStatusPath1=DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath+ DocumentManagementPage.AddedDocumentStatus;
			
			BasePage.driver.findElement(By.xpath(AddedDocument_DMF3)).click();
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			BasePage.driver.findElement(By.xpath(UnPublishLink)).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			DocumentManagementAssertText11=BasePage.driver.findElement(By.xpath(UnPublish_labelPath)).getText();
			System.out.println(DocumentManagementAssertText11);
			BasePage.driver.findElement(By.xpath(UnPublishButton_UnPublishPopup)).click();
			
			try {
		 		 Thread.sleep(8000);
		 		} catch (InterruptedException e) {
		 			e.printStackTrace();
		 		} 
				 UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPageLoadAssert);
				 DocumentManagementAssertText12=BasePage.driver.findElement(By.xpath(DocumentStatusPath1)).getText();
		         return new DocumentManagementPage();
		}
		
		//Delete a document from Document Management screen
				public static DocumentManagementPage DeleteDocument_DMS(String HeadlineValue,String FolderNameValue)
				{
					DeleteDocumentLink=StartAddedDocumentFilePath + HeadlineValue + EndAddedDocumentFilePath +DeleteDocumentButton;
					AddedDocument_DMF3=StartFolderPath+FolderNameValue+EndFolderPath;
					DocumentStatusPath1=DocumentManagementPage.StartAddedDocumentFilePath + HeadlineValue + DocumentManagementPage.EndAddedDocumentFilePath+ DocumentManagementPage.AddedDocumentStatus;
					
					BasePage.driver.findElement(By.xpath(AddedDocument_DMF3)).click();
					try {
						Thread.sleep(6000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					BasePage.driver.findElement(By.xpath(DeleteDocumentLink)).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					alert3 = BasePage.driver.switchTo().alert();
					DocumentManagementAssertText3=alert3.getText();
					System.out.println(DocumentManagementAssertText13);
					alert3.accept();
					
					try {
				 		 Thread.sleep(8000);
				 		} catch (InterruptedException e) {
				 			e.printStackTrace();
				 		} 
						 UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPageLoadAssert);
						 
						 try{
							 if(BasePage.driver.findElement(By.xpath(DocumentStatusPath1)).isDisplayed())
								 DocumentManagementAssertText14="False";
						 else
							 DocumentManagementAssertText14="False";
						 }catch(Exception e1)
						 {
							 DocumentManagementAssertText14="False";
						 }
				         return new DocumentManagementPage();
				}
				
				
				//Click on NewDraftFromDocument a document using New draft option and user navigates to Add/Edit document page
				public static void NewDocumentDraft_Document(String HeadlineValue,String FolderNameValue)
				{
					NewDocumentFromDraftLink=StartAddedDocumentFilePath + HeadlineValue + EndAddedDocumentFilePath +NewDocumentFromDraftButton;
					AddedDocument_DMF3=StartFolderPath+FolderNameValue+EndFolderPath;
					
					BasePage.driver.findElement(By.xpath(AddedDocument_DMF3)).click();
					try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					BasePage.driver.findElement(By.xpath(NewDocumentFromDraftLink)).click();
					try {
						Thread.sleep(7000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UtilityFunctions.WaitUntilPresenceOfElement(AddDocumentPage.PageHeader);
				}
				
				//Click on manage template button from Document Management screen
				public static String NavigateToManageTemplatePage()
				{
					BasePage.driver.findElement(By.linkText(ManageTemplateButton)).click();
					try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UtilityFunctions.WaitUntilPresenceOfElement(ManageTemplateListPage.ManageTemplateListLoad);
					DocumentManagementAssertText15=BasePage.driver.findElement(By.xpath(ManageTemplateListPage.ManageTemplateListLoad)).getText();
					return(DocumentManagementAssertText15);
				}
				
				//Click on manage signature button from Document Management screen
				public static String NavigateToManageSignaturePage()
				{
					BasePage.driver.findElement(By.linkText(ManageSignaturesButton)).click();
					try {
						Thread.sleep(7000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UtilityFunctions.WaitUntilPresenceOfElement(ManageSignatureList.SignatureListHeader);
					DocumentManagementAssertText16=BasePage.driver.findElement(By.xpath(ManageSignatureList.SignatureListHeader)).getText();
					return(DocumentManagementAssertText16);
				}
				
				//Folder edit description
				public static String EditFolderDescription(String FolderNameValue, String FolderDescription)
				{
					AddedDocument_DMF5=StartFolderPath+FolderNameValue+EndFolderPath;
					
					BasePage.driver.findElement(By.xpath(AddedDocument_DMF5)).click();
					try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					BasePage.driver.findElement(By.xpath(EditFolderLink)).click();
					try {
						Thread.sleep(7000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UtilityFunctions.WaitUntilPresenceOfElement(ViewDescription);
					BasePage.driver.findElement(By.xpath(ViewDescription)).click();
					BasePage.driver.findElement(By.xpath(ViewDescriptionIframe)).sendKeys(FolderDescription);
					BasePage.driver.findElement(By.xpath(SaveButton)).click();
					 try {
						 Thread.sleep(8000);
				    	 } catch (InterruptedException e) {
				  			
				  			e.printStackTrace();
				  		}
				         
				         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPage.DocumentManagementPageLoadAssert);
				         DocumentManagementAssertText17= BasePage.driver.findElement(By.xpath(DocumentManagementPage.DocumentManagementPageHeaderPath)).getText();
				         return(DocumentManagementAssertText17);
					
				}
			
				//Folder Options, verify labels and save
				public static DocumentManagementPage FolderOptionLabels(String FolderNameValue)
				{
					AddedDocument_DMF6=StartFolderPath+FolderNameValue+EndFolderPath;
					
					BasePage.driver.findElement(By.xpath(AddedDocument_DMF6)).click();
					try {
						Thread.sleep(7000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					BasePage.driver.findElement(By.xpath(EditFolderLink)).click();
					try {
						Thread.sleep(7000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UtilityFunctions.WaitUntilPresenceOfElement(ViewDescription);
					BasePage.driver.findElement(By.xpath(ViewFolderOptions)).click();
					DocumentManagementAssertText18=BasePage.driver.findElement(By.xpath(FolderViewTemplateLabelPath)).getText();
					DocumentManagementAssertText19=BasePage.driver.findElement(By.xpath(DocumentViewTemplatePath)).getText();
					BasePage.driver.findElement(By.xpath(SaveButton)).click();
					 try {
						 Thread.sleep(8000);
				    	 } catch (InterruptedException e) {
				  			
				  			e.printStackTrace();
				  		}
				         
				         UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPage.DocumentManagementPageLoadAssert);
				         DocumentManagementAssertText20= BasePage.driver.findElement(By.xpath(DocumentManagementPage.DocumentManagementPageHeaderPath)).getText();
				         return new DocumentManagementPage();
					
				}
			
				
				
}
