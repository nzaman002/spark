package com.pwc.spark.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatePoll_ {
	
	public WebDriver driver;	
	public CreatePoll_(WebDriver driver){
		this.driver= driver;
	}
	
	
	 public By pollTitleid  =  By.id("subject");
		public WebElement getpollTitleid(){
			return driver.findElement(pollTitleid);
		}
		
		
		 public By pollOption1Name  =  By.name("options[0].text");
			public WebElement getpollOption1(){
				return driver.findElement(pollOption1Name);
			}
			
			
			
			public By pollOption2Name  =  By.name("options[1].text");
			public WebElement getpollOption2(){
				return driver.findElement(pollOption2Name);
			}
			
			public By submitButton  =  By.id("submitButton");
			public WebElement getSubmitButton(){
				return driver.findElement(submitButton);
			}
			
			 public By selectPlace  =  By.id("js-publishbar-place-input");
				public WebElement getPlace(){
					return driver.findElement(selectPlace);
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
	
			
			
		

}
