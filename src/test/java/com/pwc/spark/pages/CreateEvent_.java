package com.pwc.spark.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateEvent_ {
	
	public WebDriver driver;	
	public CreateEvent_(WebDriver driver){
		this.driver= driver;
	}
	
	public By eventTitleid  =  By.id("subject");
	public WebElement geteventTitleid(){
		return driver.findElement(eventTitleid);
	}
	
	public By eventLocationid  =  By.id("event-location");
	public WebElement geteventLocationid(){
		return driver.findElement(eventLocationid);
	}
	
	public By eventAttendeeid  =  By.id("max-attendees");
	public WebElement geteventAttendeeid(){
		return driver.findElement(eventAttendeeid);
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

}
