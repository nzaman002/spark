package com.pwc.spark.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pwc.spark.PlusElement;

public class Login_ extends PlusElement{
	public WebDriver driver;	
	public Login_(WebDriver driver){
		this.driver= driver;
	}
	public By inp_email  = By.xpath(".//*[@type='email']");
	public WebElement getEmail(){
		return driver.findElement(inp_email);
	}
	public By btn_login  = By.id("ctl00_phCenter_btnSubmitx");
	public WebElement getLogin(){
		return driver.findElement(btn_login);
	}
}
