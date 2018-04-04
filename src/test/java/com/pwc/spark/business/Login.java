package com.pwc.spark.business;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

import org.apache.log4j.Logger;
import com.pwc.spark.pages.Login_;

public class Login extends Login_{
	public Logger log = Logger.getLogger("Login");
	public Login(WebDriver driver) {
		super(driver);
	}
	public void login(String email){
		//driver.manage().window().maximize();
		
		//String email = data.get("Email");
		getEmail().sendKeys(email);
		getLogin().click();
		System.out.println("Login Completed!");
	}
}
