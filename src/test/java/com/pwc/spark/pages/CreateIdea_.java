package com.pwc.spark.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateIdea_ {
	
	public WebDriver driver;	
	public CreateIdea_(WebDriver driver){
		this.driver= driver;
	}
	
	
	 public By ideaTitleid  =  By.id("subject");
		public WebElement getideaTitleid(){
			return driver.findElement(ideaTitleid);
		}
		
		
		 public By selectPlace  =  By.id("js-publishbar-place-input");
			public WebElement getPlace(){
				return driver.findElement(selectPlace);
			}
			
			
			public By submitButton  =  By.id("submitButton");
			public WebElement getSubmitButton(){
				return driver.findElement(submitButton);
			}
			
			public By changeplace= By.id("js-publishbar-changePlace")	;	
			public WebElement getChangePlaceOption(){
				return driver.findElement(changeplace);
			}
	

}
