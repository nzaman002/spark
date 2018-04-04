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
import com.pwc.spark.pages.CreatePoll_;

public class CreatePoll extends CreatePoll_ {
	
	public CreatePoll(WebDriver driver) {
		super(driver);
	}
	
	public int CreatePoll(String name , String description , String url , String place , String option1 , String option2){
		
		driver.get(url);
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			 WebElement deletebutton1= null;
			 deletebutton1=getAutoSaveDeleteButton();
		  
		    if( deletebutton1!=null)
		   { 
		    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getAutoSaveDeleteButton());
		   }
		   }
			
		    
		  catch (NoSuchElementException e) {
		   e.printStackTrace();
		 }*/
		
		getpollTitleid().clear();
		getpollTitleid().sendKeys(name);
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Keyboard keyboard1=((HasInputDevices) driver).getKeyboard();
	    keyboard1.pressKey(Keys.TAB);
	    keyboard1.sendKeys(description);
	    
	    getpollOption1().clear();
	    getpollOption1().sendKeys(option1);
	    try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    getpollOption2().clear();
	    getpollOption2().sendKeys(option2);
	    
	    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
	    
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
			 
			//*[@id='jive-thread-messages-container']/div[3]/div/header/h1/a
		     header=driver.findElement(By.xpath(".//*[@id='j-poll']/header/h1"));
		  
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
		
		
		
		

	    
	    
	    
	    
	   // return 1 ;
	    
	    
		
	}








}
