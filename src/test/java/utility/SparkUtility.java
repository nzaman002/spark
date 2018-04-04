package utility;


import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SparkUtility {
	
	public static String captureScreenShot(WebDriver ldriver , String screenShotName){
		 
		  // Take screenshot and store as a file format
		  File src= ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		  String s=null;
		try {
		  // now copy the  screenshot to desired location using copyFile method
		 
		 FileUtils.copyFile(src, new File("C:/Users/nzaman003/Desktop/screenshot/"+screenShotName+".png"));
		  s="C:/Users/nzaman003/Desktop/screenshot/"+screenShotName+".png" ;
		// return s;
		       }
		 
		catch (IOException e)
		 
		{
		 
		System.out.println(e.getMessage());
		 
		    }
		return s;
		 
		}

}
