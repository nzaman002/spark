package com.pwc.spark.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateBlog_ {
	public WebDriver driver;	
	public CreateBlog_(WebDriver driver){
		this.driver= driver;
	}
	
	
	public By docTitleid  =  By.id("subject");
		public WebElement getdocTitleid(){
			return driver.findElement(docTitleid);
		}
		
		
			
	public By submitButton  =  By.id("submitButton");
			public WebElement getSubmitButton(){
				return driver.findElement(submitButton);
			}
			
			public WebElement getAutoSaveDeleteButton(){
				//	 WebElement DeleteButton=this.getAutoSavePrompt().findElement(By.xpath("//*[text() = 'Delete']"));
					WebElement DeleteButton=driver.findElement(By.xpath("//*[text() = 'Delete']"));
					return DeleteButton;
				}
			
			
	
		
		
		
	
		



}
