package com.pwc.spark.business;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

import com.pwc.spark.pages.CreateDocument_;
import com.pwc.spark.pages.CreateIdea_;

public class CreateIdea extends CreateIdea_{
	
	public CreateIdea(WebDriver driver) {
		super(driver);
	}
	
	public int CreateIdea(String name , String description , String url , String place){
		driver.get(url);
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		getideaTitleid().clear();
		getideaTitleid().sendKeys(name);
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Keyboard keyboard1=((HasInputDevices) driver).getKeyboard();
	   // keyboard1.pressKey(Keys.TAB);
	    keyboard1.pressKey(Keys.TAB);
	    
	    keyboard1.sendKeys(description);
	    
	    try {
			Thread.sleep(2600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)", "");
	    
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
	    
	    
	    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
		 
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
			 
			//*[@id='jive-thread-messages-container']/div[3]/div/header/h1/a
			 header=driver.findElement(By.xpath(".//*[@id='jive-body-main']/div[1]/div/div[3]/header/h1"));
		  
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
