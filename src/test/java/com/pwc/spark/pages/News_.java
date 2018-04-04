package com.pwc.spark.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pwc.spark.PlusElement;

public class News_ extends PlusElement{
	public WebDriver driver;	
	public News_(WebDriver driver){
		this.driver= driver;
	}
	
	public By btn_createMenu  = By.cssSelector("ul.j-globalNav>li:nth-child(2)>a");
	public WebElement getCreateMenu(){
		return driver.findElement(btn_createMenu);
	}
	public By btn_createDiscussion  = By.cssSelector("#j-create-link-discussion>a");
	public WebElement getDiscussion(){
		return driver.findElement(btn_createDiscussion);
	}
}
