package com.pwc.spark.business;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.apache.log4j.Logger;
import com.pwc.spark.pages.CreateDiscussion_;



public class CreateDiscussion extends CreateDiscussion_{
	public Logger log = Logger.getLogger("CreateDiscussion");
	
	public CreateDiscussion(WebDriver driver) {
		super(driver);
	}
	
	public int CreateDocument(String name , String description , String url , String place){
	//driver.get("https://pwc-spark.com/document/create.jspa?containerType=14&containerID=1");
		driver.get(url);
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*if(getAutoSaveDeleteButton()!=null){
			
			 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getAutoSaveDeleteButton());
		}*/
		
		
		 try {
			 WebElement deletebutton1= null;
			 
		  //   header=driver.findElement(By.xpath("//*[@id=jive-body-main']/div[1]/div/div[5]/header/h1"));
			 deletebutton1=getAutoSaveDeleteButton();
		   //*[@id='jive-body-main']/div[1]/div/div[5]/header/h1
		    if( deletebutton1!=null)
		   { 
		    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getAutoSaveDeleteButton());
		   }
		   }
			
		    
		  catch (NoSuchElementException e) {
		   e.printStackTrace();
		 }
		 
	getdocTitleid().clear();
	getdocTitleid().sendKeys(name);
	try {
		Thread.sleep(600);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Keyboard keyboard1=((HasInputDevices) driver).getKeyboard();
    keyboard1.pressKey(Keys.TAB);
    keyboard1.sendKeys(description);
    keyboard1.pressKey(Keys.ENTER);
    keyboard1.pressKey(Keys.ENTER);
    keyboard1.sendKeys(description);
    
    
    try {
		Thread.sleep(600);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
    
   // getPlace().sendKeys("Test17");
    
    try {
		 WebElement changePlace= null;
		 changePlace=getChangePlaceOption();
	  
	    if( changePlace!=null)
	   { 
	    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getChangePlaceOption());
	    	  try {
	  			Thread.sleep(1600);
	  		} catch (InterruptedException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	    	  
	    	  
	   }
	   }
		
	    
	  catch (NoSuchElementException e) {
	   e.printStackTrace();
	 }
    
    getPlace().sendKeys(place);
    try {
		Thread.sleep(1600);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    keyboard1.pressKey(Keys.DOWN);
    try {
		Thread.sleep(1600);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    keyboard1.pressKey(Keys.ENTER);
    try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
    
    try {
		Thread.sleep(600);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
   // WebElement x=driver.switchTo().activeElement();
    
	//x.clear();
	//x.sendKeys("MyAutoDocDescription");
	 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1300)", "");
	 
	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getSubmitButton());
	 
	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 
	 boolean present=false;
	 try {
		 WebElement header= null;
		 
	  //   header=driver.findElement(By.xpath("//*[@id=jive-body-main']/div[1]/div/div[5]/header/h1"));
	     header=driver.findElement(By.xpath(".//*[@id='jive-body-main']/div[1]/div/div[5]/header/h1"));
	   //*[@id='jive-body-main']/div[1]/div/div[5]/header/h1
	    if( header!=null)
	   { 
	    	if (header.getText().equalsIgnoreCase(name)){
		    present=true;
	   }
	   }
		
	    
	 } catch (NoSuchElementException e) {
	   e.printStackTrace();
	 }
	 
	if(present) 
	return 1;
	else
	return 0;
	
	
	
	
	

}
	
}
