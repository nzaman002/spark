package com.pwc.spark.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

public class CreateDiscussion_ {
	
	public WebDriver driver;	
	public CreateDiscussion_(WebDriver driver){
		this.driver= driver;
	}
	
	
	 public By docTitleid  =  By.id("subject");
		public WebElement getdocTitleid(){
			return driver.findElement(docTitleid);
		}
		
		
		 public By selectPlace  =  By.id("js-publishbar-place-input");
			public WebElement getPlace(){
				return driver.findElement(selectPlace);
			}
			
			
			public By submitButton  =  By.id("submitButton");
			public WebElement getSubmitButton(){
				return driver.findElement(submitButton);
			}
			
			
			public By autoSavePrompt  =  By.xpath("//*[@id='autosave-prompt']");
			public WebElement getAutoSavePrompt(){
				return driver.findElement(autoSavePrompt);
			}
			
			public By changeplace= By.id("js-publishbar-changePlace")	;	
			public WebElement getChangePlaceOption(){
				return driver.findElement(changeplace);
			}
			
			public WebElement getAutoSaveDeleteButton(){
			//	 WebElement DeleteButton=this.getAutoSavePrompt().findElement(By.xpath("//*[text() = 'Delete']"));
				WebElement DeleteButton=driver.findElement(By.xpath("//*[text() = 'Delete']"));
				return DeleteButton;
			}
			
			
	
		
		
		
	// public By docDescriptionid  =  By.id("tinymce");
	// public By docDescriptionid  = By.xpath(".//*[@id='tinymce']");
	 
	
		public WebElement getdocDescriptionid(){
			
            WebElement x=driver.switchTo().activeElement();
            return x;
			
	
		 /*By tableId  =  By.id("wysiwygtext_tbl");	
		
		WebElement table= driver.findElement(tableId); 
			
			WebElement tdClass=  table.findElement(By.className("rte_wrap tiny_mce_content"));
			
			 WebElement iFrame =table.findElement(By.id("wysiwygtext_ifr"));
			
			 WebElement body= iFrame.findElement(By.id("tinymce"));
			  
			return iFrame;
			//return driver.findElement(docDescriptionid);
*/		
		
			
		}
		
		
		
		
			

}
