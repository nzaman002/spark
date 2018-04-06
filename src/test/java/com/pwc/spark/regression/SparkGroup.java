package com.pwc.spark.regression;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.awt.event.InputEvent;	
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
/*import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.jna.platform.FileUtils;*/

import utility.SparkUtility;

import com.pwc.spark.Plus;
import com.pwc.spark.business.Login;
import com.pwc.spark.business.News;
import com.pwc.spark.business.CreateBlog;
import com.pwc.spark.business.CreateDiscussion;
import com.pwc.spark.business.CreateDocument;
import com.pwc.spark.business.CreateEvent;
import com.pwc.spark.business.CreateGroup;
import com.pwc.spark.business.CreateIdea;
import com.pwc.spark.business.CreatePoll;
import com.pwc.spark.data.TestData;
import com.pwc.spark.data.TestData.SelevanceBasic;

	


public class SparkGroup  {
	public Logger log = Logger.getLogger("SparkGroup");
	
	//public ExtentReports report;
	
	public Properties prop;
	public WebDriver driver=null;
	public Set<Cookie> cookiesInstance = null;
	
	
	
	@BeforeClass
	public void setup(){
		File file = new File("C:/Users/nazmaz889/Desktop/AutoM/spark/src/test/resources/config.properties");
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	//	report=new ExtentReports("C:/Users/nazmaz889/Desktop/AutoM/Reports/report.html");
		 
		 System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		   DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		   ChromeOptions options = new ChromeOptions();
		   
		 //  options.addArguments("disable-extensions");
	         options.addArguments("--start-maximized");
         capabilities.setCapability("ignoreZoomSetting", true);
         capabilities.setCapability("nativeEvents", false);
         capabilities.setCapability(ChromeOptions.CAPABILITY, options);
         
         //capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        // WebDriver driver = new ChromeDriver(capabilities);
      //   ChromeOptions options = new ChromeOptions();
       //  options.addArguments("--start-maximized");
         driver = new ChromeDriver(capabilities);
        // driver = new ChromeDriver(options);
        
         
		   String url= prop.getProperty("URL");
		
		   driver.get(url);
		
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void myChromeTest() throws IOException{
		//this.setup();
		
		// ExtentTest loggerLogin;
		// driver.manage().window().maximize();
	   String myEmailId= prop.getProperty("EMAIL");
		
		
		 
		
		try {
			//logger=report.startTest("001:Login");
			
		//	 loggerLogin=report.startTest("001:Login");
			 
			
			Login loginObject=new Login(driver);
			loginObject.login(myEmailId);
		//	loggerLogin.log(LogStatus.PASS, "Login completed successfully.");
		     cookiesInstance = driver.manage().getCookies();
		//	report.endTest(loggerLogin);
			
		} catch (Exception e1) {
			//loggerLogin.log(LogStatus.FAIL, "Login completed successfully.");
			e1.printStackTrace();
		}
		
		
		//this.createDis();
		//this.createDis();
		this.createOpenGroup();
	//this.createDoc();
	//this.createDis();
	//this.create_Blog();
	//this.create_Poll();
	
	//this.create_Event();
	//	this.createidea();
	//this.createOpenGroup();
		//this.create_Poll();
  //  this.create_Blog();
		try {
		//	this.createOpenGroup();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
		//	 this.createMemberOnlyGroup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
		// this.createPrivateGroup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		// this.createUnlistedGroup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		// this.create_ACC_CC_Private_Group();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
		//	  this.create_ACC_CC_Unlisted();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		// this.createACC_NCC_Private_Group();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		//	 this.createACC_NCC_UnlistedGroup();
		} catch (UnhandledAlertException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     //    report.flush();
		//driver.get("C:/Users/nzaman003/Desktop/Report/report.html");
         WebDriver  driver1 ;
         ChromeOptions options1 = new ChromeOptions();
         options1.addArguments("--start-maximized");
         driver1 = new ChromeDriver( options1 );
		 //  driver1.manage().window().maximize();
		 driver1.get("C:/Users/nazmaz889/Desktop/AutoM/Reports/report.html");
		 
		   
		
	}
		
	
	
	public void createOpenGroup(){
		CreateGroup createGroupObject = new CreateGroup(driver);
		
		
		//try {
			try {
			//	ExtentTest loggerCreateGroup1;
			//	loggerCreateGroup1=report.startTest("002:Create Open Group");
				String groupName=prop.getProperty("GN_NonAcc_Open");
				String url=prop.getProperty("CREATEGROUP_URL");
				int success=createGroupObject.createGrouppp(groupName , "NONACC" , " " , "OPEN" , url);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
			//	loggerCreateGroup1.log(LogStatus.PASS, "Open group is created successfully");
				String pathOfSc=	SparkUtility.captureScreenShot(driver, "openGrppass");
				
				//String img=	loggerCreateGroup1.addScreenCapture(pathOfSc);
			//	loggerCreateGroup1.log(LogStatus.INFO, "Passed", "Passed at: " + img);
				}
				else{
				//	loggerCreateGroup1.log(LogStatus.FAIL, "Open group can not be created successfully");
				
					String pathOfSc=	SparkUtility.captureScreenShot(driver, "openGrpfail");
					
				//	String img=	loggerCreateGroup1.addScreenCapture(pathOfSc);
				//	loggerCreateGroup1.log(LogStatus.INFO, "Failure", "Failed at: " + img);
					driver.close();
					 driver = new ChromeDriver();
					   driver.manage().window().maximize();
					   String url1= prop.getProperty("URL");
					   driver.get(url1);
					   String myEmailId1= prop.getProperty("EMAIL");
					   Login loginObject=new Login(driver);
						loginObject.login(myEmailId1);
					
					
					
					 
				}
			//	report.endTest(loggerCreateGroup1);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
	
	}
		
	
	public void createMemberOnlyGroup(){
		CreateGroup createGroupObject = new CreateGroup(driver);
		
		
		//try {
			try {
				//ExtentTest loggerCreateGroup2;
			//	loggerCreateGroup2=report.startTest("003:Create MemberOnly Group");
				String groupName=prop.getProperty("GN_NonAcc_MemberOnly");
				String url=prop.getProperty("CREATEGROUP_URL");
				int success=createGroupObject.createGrouppp(groupName , "NONACC" , " " , "MEMBERONLY" , url);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
			//	loggerCreateGroup2.log(LogStatus.PASS, "Member only group is created successfully");
				String pathOfSc=	SparkUtility.captureScreenShot(driver, "memberonlypass");
				
			//	String img=	loggerCreateGroup2.addScreenCapture(pathOfSc);
			//	loggerCreateGroup2.log(LogStatus.INFO, "Passed", "Passed at: " + img);
				}
				else{
				//	loggerCreateGroup2.log(LogStatus.FAIL, "Member only group can not be  created successfully");
					String pathOfSc=	SparkUtility.captureScreenShot(driver, "memberonlyfail");
					
				//	String img=	loggerCreateGroup2.addScreenCapture(pathOfSc);
					//loggerCreateGroup2.log(LogStatus.INFO, "Failed", "Failed at: " + img);
					
					driver.close();
					 driver = new ChromeDriver();
					   driver.manage().window().maximize();
					   String url1= prop.getProperty("URL");
					   driver.get(url1);
					   String myEmailId1= prop.getProperty("EMAIL");
					   Login loginObject=new Login(driver);
						loginObject.login(myEmailId1);
					
				}
			//	report.endTest(loggerCreateGroup2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			//	logger.log(LogStatus.FAIL, "Member only group can not be created");
				e.printStackTrace();
			}
			
	
	}
	
	
	
	public void createPrivateGroup(){
		CreateGroup createGroupObject = new CreateGroup(driver);
		
		
		//try {
			try {
			//	ExtentTest loggerCreateGroup3;
			//	loggerCreateGroup3=report.startTest("004:Create Private Group");
				String groupName=prop.getProperty("GN_NonAcc_Private");
				String url=prop.getProperty("CREATEGROUP_URL");
				int success=createGroupObject.createGrouppp(groupName , "NONACC" , " " , "PRIVATE" , url);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
			//	loggerCreateGroup3.log(LogStatus.PASS, "Private group is created successfully");
				String pathOfSc=	SparkUtility.captureScreenShot(driver, "privatepass");
				
			//	String img=	loggerCreateGroup3.addScreenCapture(pathOfSc);
			//	loggerCreateGroup3.log(LogStatus.INFO, "Passed", "Passed at: " + img);
				}
				else{
				//	loggerCreateGroup3.log(LogStatus.FAIL, "Private group can not be  created successfully");
					String pathOfSc=	SparkUtility.captureScreenShot(driver, "privatefail");
					
				//	String img=	loggerCreateGroup3.addScreenCapture(pathOfSc);
				//	loggerCreateGroup3.log(LogStatus.INFO, "Failed", "Failed at: " + img);
					
					driver.close();
					 driver = new ChromeDriver();
					   driver.manage().window().maximize();
					   String url1= prop.getProperty("URL");
					   driver.get(url1);
					   String myEmailId1= prop.getProperty("EMAIL");
					   Login loginObject=new Login(driver);
						loginObject.login(myEmailId1);
					
				}
			//	report.endTest(loggerCreateGroup3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			//	logger.log(LogStatus.FAIL, "Member only group can not be created");
				e.printStackTrace();
			}
			
	
	}
	
	

	
	
	public void createUnlistedGroup(){
		CreateGroup createGroupObject = new CreateGroup(driver);
		
		
		//try {
			try {
			//	ExtentTest loggerCreateGroup4;
			//	loggerCreateGroup4=report.startTest("005:Create Unlisted Group");
				String groupName=prop.getProperty("GN_NonAcc_Unlisted");
				String url=prop.getProperty("CREATEGROUP_URL");
				int success=createGroupObject.createGrouppp(groupName , "NONACC" , " " , "UNLISTED" , url);
				
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
			//	loggerCreateGroup4.log(LogStatus.PASS, "Unlisted group is created successfully");
				String pathOfSc=	SparkUtility.captureScreenShot(driver, "unlistedpass");
				
			//	String img=	loggerCreateGroup4.addScreenCapture(pathOfSc);
			//	loggerCreateGroup4.log(LogStatus.INFO, "Passed", "Passed at: " + img);
				}
				else{
				//	loggerCreateGroup4.log(LogStatus.FAIL, "Unlisted group can not be created successfully");	
					String pathOfSc=	SparkUtility.captureScreenShot(driver, "unlistedfailed");
					
				//	String img=	loggerCreateGroup4.addScreenCapture(pathOfSc);
					//loggerCreateGroup4.log(LogStatus.INFO, "Failed", "Failed at: " + img);
					driver.close();
					 driver = new ChromeDriver();
					   driver.manage().window().maximize();
					   String url1= prop.getProperty("URL");
					   driver.get(url1);
					   String myEmailId1= prop.getProperty("EMAIL");
					   Login loginObject=new Login(driver);
						loginObject.login(myEmailId1);
					
				}
			//	report.endTest(loggerCreateGroup4);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			//	logger.log(LogStatus.FAIL, "Member only group can not be created");
				e.printStackTrace();
			}
			
	
	}
	
	/*
	
	public void create_ACC_CC_Private_Group(){
		CreateGroup createGroupObject = new CreateGroup(driver);
		
		
		//try {
			try {
				ExtentTest loggerCreateGroup5;
				loggerCreateGroup5=report.startTest("006:Create Account Client Confidential Private Group");
				String groupName=prop.getProperty("GN_ACC_CC_Private");
				String url=prop.getProperty("CREATEGROUP_URL");
				int success=createGroupObject.createGrouppp(groupName , "ACCOUNT" , "CC" , "PRIVATE" , url);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
				loggerCreateGroup5.log(LogStatus.PASS, "Account Client Confidential Private Group is created successfully");
				String pathOfSc=	SparkUtility.captureScreenShot(driver, "acc_cc_pri_pass");
				
				String img=	loggerCreateGroup5.addScreenCapture(pathOfSc);
				loggerCreateGroup5.log(LogStatus.INFO, "Passed", "Passed at: " + img);
				}
				else{
					
					loggerCreateGroup5.log(LogStatus.FAIL, "Account Client Confidential Private Group can not be created successfully");
					String pathOfSc=	SparkUtility.captureScreenShot(driver, "acc_cc_pri_fail");
					
					String img=	loggerCreateGroup5.addScreenCapture(pathOfSc);
					loggerCreateGroup5.log(LogStatus.INFO, "Fail", "Failed at: " + img);
					driver.close();
					 driver = new ChromeDriver();
					   driver.manage().window().maximize();
					   String url1= prop.getProperty("URL");
					   driver.get(url1);
					   String myEmailId1= prop.getProperty("EMAIL");
					   Login loginObject=new Login(driver);
						loginObject.login(myEmailId1);
					
				}
				report.endTest(loggerCreateGroup5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			//	logger.log(LogStatus.FAIL, "Member only group can not be created");
				e.printStackTrace();
			}
			
	
	}
	
	
	
	public void create_ACC_CC_Unlisted(){
		CreateGroup createGroupObject = new CreateGroup(driver);
		
		
		//try {
			try {
				ExtentTest loggerCreateGroup6;
				loggerCreateGroup6=report.startTest("007:Create Account Client Confidential Unlisted Group");
				String groupName=prop.getProperty("GN_ACC_CC_Unlisted");
				String url=prop.getProperty("CREATEGROUP_URL");
				int success=createGroupObject.createGrouppp(groupName , "ACCOUNT" , "CC" , "UNLISTED" , url);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
				loggerCreateGroup6.log(LogStatus.PASS, "Account Client Confidential Unlisted group is created successfully");
                String pathOfSc=	SparkUtility.captureScreenShot(driver, "acc_cc_un_pass");
				
				String img=	loggerCreateGroup6.addScreenCapture(pathOfSc);
				loggerCreateGroup6.log(LogStatus.INFO, "Passed", "Passed at: " + img);
				}
				else{
					loggerCreateGroup6.log(LogStatus.FAIL, "Account Client Confidential Unlisted group can not be created successfully");
					String pathOfSc=	SparkUtility.captureScreenShot(driver, "acc_cc_un_fail");
					
					String img=	loggerCreateGroup6.addScreenCapture(pathOfSc);
					loggerCreateGroup6.log(LogStatus.INFO, "Failed", "Failed at: " + img);
					driver.close();
					 driver = new ChromeDriver();
					   driver.manage().window().maximize();
					   String url1= prop.getProperty("URL");
					   driver.get(url1);
					   String myEmailId1= prop.getProperty("EMAIL");
					   Login loginObject=new Login(driver);
						loginObject.login(myEmailId1);
					
				}
				report.endTest(loggerCreateGroup6);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			//	logger.log(LogStatus.FAIL, "Member only group can not be created");
				e.printStackTrace();
			}
			
	
	}
	
	
	public void createACC_NCC_Private_Group(){
		CreateGroup createGroupObject = new CreateGroup(driver);
		
		
		//try {
			try {
				ExtentTest loggerCreateGroup7;
				loggerCreateGroup7=report.startTest("008:Create Account Non Client Confidentail Private Group");
				String groupName=prop.getProperty("GN_ACC_NCC_Private");
				String url=prop.getProperty("CREATEGROUP_URL");
				int success=createGroupObject.createGrouppp(groupName , "ACCOUNT" , "NCC" , "PRIVATE" , url);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
				loggerCreateGroup7.log(LogStatus.PASS, "Create Account Non Client Confidentail Private group is created successfully");
				 String pathOfSc=	SparkUtility.captureScreenShot(driver, "acc_ncc_pri_pass");
					
					String img=	loggerCreateGroup7.addScreenCapture(pathOfSc);
					loggerCreateGroup7.log(LogStatus.INFO, "Passed", "Passed at: " + img);
				}
				else{
					loggerCreateGroup7.log(LogStatus.FAIL, " Account Non Client Confidentail Private group can not be created successfully");
					 String pathOfSc=	SparkUtility.captureScreenShot(driver, "acc_ncc_pri_fail");
						
						String img=	loggerCreateGroup7.addScreenCapture(pathOfSc);
						loggerCreateGroup7.log(LogStatus.INFO, "Failed", "Failed at: " + img);
						driver.close();
						 driver = new ChromeDriver();
						   driver.manage().window().maximize();
						   String url1= prop.getProperty("URL");
						   driver.get(url1);
						   String myEmailId1= prop.getProperty("EMAIL");
						   Login loginObject=new Login(driver);
							loginObject.login(myEmailId1);
						
				}
				report.endTest(loggerCreateGroup7);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			//	logger.log(LogStatus.FAIL, "Member only group can not be created");
				e.printStackTrace();
			}
			
	
	}
	
	
	public void createACC_NCC_UnlistedGroup(){
		CreateGroup createGroupObject = new CreateGroup(driver);
		
		
		//try {
			try {
				ExtentTest loggerCreateGroup8;
				loggerCreateGroup8=report.startTest("009:Create Account Non Client Confidentail Unlisted Group");
				String groupName=prop.getProperty("GN_ACC_NCC_Unlisted");
				String url=prop.getProperty("CREATEGROUP_URL");
				int success=createGroupObject.createGrouppp(groupName , "ACCOUNT" , "NCC" , "UNLISTED" , url);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
				loggerCreateGroup8.log(LogStatus.PASS, "Account Non Client Confidential Unlisted group is created successfully");
				 String pathOfSc=	SparkUtility.captureScreenShot(driver, "acc_ncc_un_pass");
					
					String img=	loggerCreateGroup8.addScreenCapture(pathOfSc);
					loggerCreateGroup8.log(LogStatus.INFO, "Passed", "Passed at: " + img);
				}
				else{
					loggerCreateGroup8.log(LogStatus.FAIL, "Account Non Client Confidential Unlisted group can not be  created successfully");
                    String pathOfSc=	SparkUtility.captureScreenShot(driver, "acc_ncc_un_fail");
                    System.out.println("path of the screenshot is"+ pathOfSc);
					
                    String img =loggerCreateGroup8.addScreenCapture(pathOfSc);
                    loggerCreateGroup8.log(LogStatus.INFO, "Failure", "Failed at: " + img);
                	driver.close();
					 driver = new ChromeDriver();
					   driver.manage().window().maximize();
					   String url1= prop.getProperty("URL");
					   driver.get(url1);
					   String myEmailId1= prop.getProperty("EMAIL");
					   Login loginObject=new Login(driver);
						loginObject.login(myEmailId1);
					
				}
				report.endTest(loggerCreateGroup8);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			//	logger.log(LogStatus.FAIL, "Member only group can not be created");
				e.printStackTrace();
			}
			
	
	}
	
	
	
	
	public void createDoc(){
		CreateDiscussion createDiscussionObject = new CreateDiscussion(driver);
		
		
					try {
				ExtentTest loggerCreateDiscussion;
				loggerCreateDiscussion=report.startTest("002: Create a document");
			    String docname=prop.getProperty("DOC_NAME");
			    String docDescription=prop.getProperty("DESCRIPTION");
			    String url= prop.getProperty("CREATEDOC_URL");
			    String place= prop.getProperty("PLACE");
			    		
				int success=createDiscussionObject.CreateDocument(docname , docDescription , url , place);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
					loggerCreateDiscussion.log(LogStatus.PASS, "Document has been created successfully.");
					  String pathOfSc=	SparkUtility.captureScreenShot(driver, "createdocpass");
	                  System.out.println("path of the screenshot is"+ pathOfSc);
						
	                    String img =loggerCreateDiscussion.addScreenCapture(pathOfSc);
	                    loggerCreateDiscussion.log(LogStatus.INFO, "Pass", "Passed at: " + img);
					
				}
				else{
					loggerCreateDiscussion.log(LogStatus.FAIL, "Document could not be created successfully");
                    String pathOfSc=	SparkUtility.captureScreenShot(driver, "createdocfail");
                    System.out.println("path of the screenshot is"+ pathOfSc);
					
                    String img =loggerCreateDiscussion.addScreenCapture(pathOfSc);
                    loggerCreateDiscussion.log(LogStatus.INFO, "Failure", "Failed at: " + img);
				}
				report.endTest(loggerCreateDiscussion);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
	
	}
	
	
	
	public void createDis(){
		CreateDocument createDisObject = new CreateDocument(driver);
		
		
		
			try {
				ExtentTest loggerCreateDocument;
				loggerCreateDocument=report.startTest("003 : Create a discussion");
			    String disname=prop.getProperty("DIS_NAME");
			    String description = prop.getProperty("DESCRIPTION");
			    String url= prop.getProperty("CREATEDIS_URL");
			    String place= prop.getProperty("PLACE");
				int success=createDisObject.CreateDisc(disname , description , url , place);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
					loggerCreateDocument.log(LogStatus.PASS, "Discussion has been created successfully");
					String pathOfSc=	SparkUtility.captureScreenShot(driver, "createdispass");
	                   System.out.println("path of the screenshot is"+ pathOfSc);
						
	                  String img =loggerCreateDocument.addScreenCapture(pathOfSc);
	                  loggerCreateDocument.log(LogStatus.INFO, "Passed", "Passed at: " + img);
				}
				else{
					loggerCreateDocument.log(LogStatus.FAIL, "Discussion could not be created successfully");
                   String pathOfSc=	SparkUtility.captureScreenShot(driver, "createdisfail");
                   System.out.println("path of the screenshot is"+ pathOfSc);
					
                  String img =loggerCreateDocument.addScreenCapture(pathOfSc);
                  loggerCreateDocument.log(LogStatus.INFO, "Failure", "Failed at: " + img);
				}
				report.endTest(loggerCreateDocument);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
	
	}
	
	
	public void create_Blog(){
		CreateBlog createBlogObject = new CreateBlog(driver);
		
		
		
			try {
				ExtentTest loggerCreateBlog;
				loggerCreateBlog=report.startTest("004 : Create a blog");
		        String name=prop.getProperty("BLOG_NAME");
		        String description= prop.getProperty("DESCRIPTION");
		        String url= prop.getProperty("CREATEBLOG_URL");
			    String place= prop.getProperty("PLACE");
		        
				int success=createBlogObject.CreateBlog(name , description, url , place);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
					loggerCreateBlog.log(LogStatus.PASS, "Blog has been created successfully");
					String pathOfSc=	SparkUtility.captureScreenShot(driver, "createblogpass");
                    System.out.println("path of the screenshot is"+ pathOfSc);
					
                    String img =loggerCreateBlog.addScreenCapture(pathOfSc);
                    loggerCreateBlog.log(LogStatus.INFO, "Failure", "Passed at: " + img);
				}
				else{
					loggerCreateBlog.log(LogStatus.FAIL, "Blog can not be  created successfully");
                    String pathOfSc=	SparkUtility.captureScreenShot(driver, "createblogfail");
                    System.out.println("path of the screenshot is"+ pathOfSc);
					
                    String img =loggerCreateBlog.addScreenCapture(pathOfSc);
                    loggerCreateBlog.log(LogStatus.INFO, "Failure", "Failed at: " + img);
				}
				report.endTest(loggerCreateBlog);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
	
	}
	
	
	
	public void create_Poll(){
		CreatePoll createPollObject = new CreatePoll(driver);
		
		
		
			try {
				ExtentTest loggerCreatePoll;
				loggerCreatePoll=report.startTest("005 : Create a poll");
		        String name=prop.getProperty("POLL_NAME");
		        String description= prop.getProperty("DESCRIPTION");
		        String url= prop.getProperty("CREATEPOLL_URL");
			    String place= prop.getProperty("PLACE");
			    String option1=prop.getProperty("POLL_OPTION1");
			    String option2=prop.getProperty("POLL_OPTION2");
		        
				int success=createPollObject.CreatePoll(name , description, url , place , option1 , option2);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
					loggerCreatePoll.log(LogStatus.PASS, "Poll has been created successfully");
					String pathOfSc=	SparkUtility.captureScreenShot(driver, "createpollpass");
                    System.out.println("path of the screenshot is"+ pathOfSc);
					
                    String img =loggerCreatePoll.addScreenCapture(pathOfSc);
                    loggerCreatePoll.log(LogStatus.INFO, "Failure", "Passed at: " + img);
				}
				else{
					loggerCreatePoll.log(LogStatus.FAIL, "Poll can not be  created successfully");
                    String pathOfSc=	SparkUtility.captureScreenShot(driver, "createpollfail");
                    System.out.println("path of the screenshot is"+ pathOfSc);
					
                    String img =loggerCreatePoll.addScreenCapture(pathOfSc);
                    loggerCreatePoll.log(LogStatus.INFO, "Failure", "Failed at: " + img);
				}
				report.endTest(loggerCreatePoll);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
	
	}
	
	
	
	
	
	public void create_Event(){
		CreateEvent createEventObject = new CreateEvent(driver);
		
		
		
			try {
				ExtentTest loggerCreateEvent;
				loggerCreateEvent=report.startTest("006 : Create an event");
		        String name=prop.getProperty("EVENT_NAME");
		        String description= prop.getProperty("DESCRIPTION");
		        String url= prop.getProperty("CREATEEVENT_URL");
			    String place= prop.getProperty("PLACE");
			    String location=prop.getProperty("EVENT_LOCATION");
			    String attendee=prop.getProperty("EVENT_ATTENDIES");
		        
				int success=createEventObject.CreateEvent(name , description, url , place , location ,attendee);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
					loggerCreateEvent.log(LogStatus.PASS, "Event has been created successfully");
					String pathOfSc=	SparkUtility.captureScreenShot(driver, "createeventpass");
                    System.out.println("path of the screenshot is"+ pathOfSc);
					
                    String img =loggerCreateEvent.addScreenCapture(pathOfSc);
                    loggerCreateEvent.log(LogStatus.INFO, "Failure", "Passed at: " + img);
				}
				else{
					loggerCreateEvent.log(LogStatus.FAIL, "Event can not be  created successfully");
                    String pathOfSc=	SparkUtility.captureScreenShot(driver, "createeventfail");
                    System.out.println("path of the screenshot is"+ pathOfSc);
					
                    String img =loggerCreateEvent.addScreenCapture(pathOfSc);
                    loggerCreateEvent.log(LogStatus.INFO, "Failure", "Failed at: " + img);
				}
				report.endTest(loggerCreateEvent);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
	
	}
	
	
	public void createidea(){
		CreateIdea createIdeaObject = new CreateIdea(driver);
		
		
					try {
				ExtentTest loggerCreateIdea;
				loggerCreateIdea=report.startTest("007: Create an idea");
			    String ideaname=prop.getProperty("IDEA_NAME");
			    String ideaDescription=prop.getProperty("DESCRIPTION");
			    String url= prop.getProperty("CREATEIDEA_URL");
			    String place= prop.getProperty("PLACE");
			    		
				int success=createIdeaObject.CreateIdea(ideaname , ideaDescription , url , place);
				 
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(success==1){
					loggerCreateIdea.log(LogStatus.PASS, "Idea has been created successfully.");
					  String pathOfSc=	SparkUtility.captureScreenShot(driver, "createideapass");
	                  System.out.println("path of the screenshot is"+ pathOfSc);
						
	                    String img =loggerCreateIdea.addScreenCapture(pathOfSc);
	                    loggerCreateIdea.log(LogStatus.INFO, "Pass", "Passed at: " + img);
					
				}
				else{
					loggerCreateIdea.log(LogStatus.FAIL, "Idea could not be created successfully");
                    String pathOfSc=	SparkUtility.captureScreenShot(driver, "createideafail");
                    System.out.println("path of the screenshot is"+ pathOfSc);
					
                    String img =loggerCreateIdea.addScreenCapture(pathOfSc);
                    loggerCreateIdea.log(LogStatus.INFO, "Failure", "Failed at: " + img);
				}
				report.endTest(loggerCreateIdea);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
	
	}
	
	
	
	*/
	
	
}
