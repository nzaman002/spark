package com.pwc.spark.business;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;

import org.apache.log4j.Logger;
import com.pwc.spark.pages.Login_;
import com.pwc.spark.pages.News_;

public class News extends News_{
	public Logger log = Logger.getLogger("Login");
	public News(WebDriver driver) {
		super(driver);
	}
	public void createDiscussion(HashMap<String, String> data){
		//waitForElementToDisplay(driver,getCreateMenu());
		Actions act = new Actions(driver);
		act.moveToElement(getCreateMenu()).doubleClick().build().perform();
		 
		
		getCreateMenu().sendKeys(Keys.ENTER);
		waitForElementToDisplay(driver,getDiscussion());
		getDiscussion().click();
		getDiscussion().sendKeys(Keys.ENTER);
		System.out.println("News Completed");
	}
}
