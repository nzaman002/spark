package com.pwc.spark.business;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

import com.pwc.spark.pages.CreateGroup_;
import com.pwc.spark.pages.Login_;

public class CreateGroup extends CreateGroup_ {
	public Logger log = Logger.getLogger("CreateGroup");
	public CreateGroup(WebDriver driver) {
		super(driver);
	}
	
	
	
	public int createGrouppp(String name , String accStr , String ccStr , String groupType , String url){
		
		String nameStr=name;
        int success=0;
		
		
		//driver.get("https://pwc-spark.com/edit-place.jspa?containerType=700");
        driver.get(url);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getLastCircle().click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		getgetStarted().click();
		
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 
		 
		 getGroupName().clear();
		 getGroupName().sendKeys(nameStr);
		 
		 if(accStr.equalsIgnoreCase("ACCOUNT")){
		 
		 
		             ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getAccountGroup());
		 
		              try {
				          Thread.sleep(2000);
			              } catch (InterruptedException e) {
				        e.printStackTrace();
			                            }
		 
		              ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,450)", "");
		 
		 
		                getResponsiblePartner().clear();
		                getResponsiblePartner().sendKeys("nazma.zaman");
		                try {
				          Thread.sleep(1000);
			              } catch (InterruptedException e) {
				          e.printStackTrace();
			               }
		                 Keyboard keyboard=((HasInputDevices) driver).getKeyboard();
	       
	                     keyboard.pressKey(Keys.ENTER);
	       
		 
		 
		
	                     getTerritory().click();
		                 try {
				          Thread.sleep(1000);
			               } catch (InterruptedException e) {
				            e.printStackTrace();
			                }
		                 Keyboard keyboard2=((HasInputDevices) driver).getKeyboard();
		                 keyboard2.pressKey(Keys.ENTER);
		                 try {
				           Thread.sleep(1000);
			                 } catch (InterruptedException e) {
				             e.printStackTrace();
			               }
	
		    
		                 getLos().click();
			            try {
					     Thread.sleep(1000);
				            } catch (InterruptedException e) {
					       e.printStackTrace();
				          }
			    
			   
			              ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,450)", "");
			 
			              getIndustry().click();
			 
			              try {
					      Thread.sleep(1000);
				          } catch (InterruptedException e) {
					        e.printStackTrace();
				           }
			   
			               if (accStr.equalsIgnoreCase("ACCOUNT")){
			               ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)", "");
			    
			                     if(ccStr.equalsIgnoreCase("CC")){
			                     ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getCC_Yes());
			                     }
			                     else{
			                     ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getCC_No());
			                     }
			                     
			                     if(groupType.equalsIgnoreCase("PRIVATE")){
			                     ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getPrivateRadio());
			                     }
			                     else{
			                     ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getSecretadio());
			                     }
			                                                       }
				 
				                    try {
						            Thread.sleep(1000);
					                } catch (InterruptedException e) {
						            e.printStackTrace();
					                }
				                 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)", "");
				             //    String parentWindowHandler = driver.getWindowHandle();
				 
				             //    try {
									((JavascriptExecutor)driver).executeScript("arguments[0].click();", getPreview());
									//Set<String> handles = driver.getWindowHandles(); 
					             //   int handlesize= handles.size();
					              // String subWindowHandler= null;
					             //   System.out.println("size is " + handlesize);
					                
					               //  Iterator<String> iterator = handles.iterator();
					              //   while (iterator.hasNext()){
					               //      subWindowHandler = iterator.next();
					               //  }
					                // driver.switchTo().window(subWindowHandler);
					               //  Keyboard keyboard9=((HasInputDevices) driver).getKeyboard();
					                // By cancel  =  By.;
					               //  driver.findElement(By.xpath("//*[@value='OK']")).click();
					      	       
				                  //   keyboard9.pressKey(Keys.ENTER);
				                     //driver.switchTo().window(parentWindowHandler);
				                    /* try {
									       Thread.sleep(1000);
								            } catch (InterruptedException e4) {
									        e4.printStackTrace();
								            }
				                     keyboard9.pressKey(Keys.ESCAPE);
				                     try {
									       Thread.sleep(500);
								            } catch (InterruptedException e4) {
									        e4.printStackTrace();
								            }
				                     By cancel  =  By.id("cancel");
				             		
				             		WebElement v=	 driver.findElement(cancel);
				             		((JavascriptExecutor)driver).executeScript("arguments[0].click();", v);
				             		 Alert alert=driver.switchTo().alert();
				                     alert.dismiss();*/
				                 //}
				             		
				                     
								// catch (UnhandledAlertException e ) {
									// TODO Auto-generated catch block
									//e1.printStackTrace();
									
				                //     Alert alert=driver.switchTo().alert();
				                  //   alert.accept();
									
									
								//}
				                 /*String subWindowHandler = null;
				                 Set<String> handles = driver.getWindowHandles(); 
				                int handlesize= handles.size();
				                System.out.println("size is " + handlesize);
				                
				                 Iterator<String> iterator = handles.iterator();
				                 while (iterator.hasNext()){
				                     subWindowHandler = iterator.next();
				                 }
				                 driver.switchTo().window(subWindowHandler);
				                 Keyboard keyboard9=((HasInputDevices) driver).getKeyboard();
				      	       
			                     keyboard9.pressKey(Keys.ENTER);
			                     driver.switchTo().window(parentWindowHandler);
			                     keyboard9.pressKey(Keys.ENTER);*/
				                 
				                 
			                     
				                 
				                		 
				                 
				                
				 
				 
				                try {
						       Thread.sleep(1000);
					            } catch (InterruptedException e) {
						        e.printStackTrace();
					            }
			                   
				                
				                
				                
				 
				             ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getSaveButton());
				             try {
									Thread.sleep(4000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
				             
				             boolean present;
							 try {
							    //driver.findElement(By.className("j-placeHeaderWrap"));
								 getSaveButton();
							    present = true;
							 } catch (NoSuchElementException e) {
							    present = false;
							 }
							 if(present){
							// By grpmainDiv= By.className("j-placeHeaderWrap");  
							//  WebElement grpmain= driver.findElement(grpmainDiv);
							//  WebElement grpd=  grpmain.findElement(By.className("j-placeTitle"));
							//String newGroupCreated =  grpd.getText();
							 
						//	if( newGroupCreated.contains(nameStr)&&newGroupCreated.contains(groupType)){
								success=0;
								System.out.println("it has reached this line");
						//	}
							 }
							 else{
									success=1; 
								 }
				                
			                     
			                    /* keyboard9.pressKey(Keys.ENTER);
			                     try {
								       Thread.sleep(1000);
							            } catch (InterruptedException e) {
								        e.printStackTrace();
							            }
			                     keyboard9.pressKey(Keys.TAB);
			                     keyboard9.pressKey(Keys.ENTER);*/
			                     
			                     
			                     
			                     
				            
				               
				             
				             
				            
								
				             
			    
			    }

			    
	
			    else{
			    	
			    	//create non account group
			    	
			    	            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getNonAccountGroup());
					 
					             try {
							      Thread.sleep(2000);
						          } catch (InterruptedException e) {
							      e.printStackTrace();
						          }
					 
					             ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,450)", "");
					 
					 
					
					 
					
				                   getTerritory().click();
					               try {
							        Thread.sleep(1000);
						             } catch (InterruptedException e) {
							       e.printStackTrace();
						               }
					             Keyboard keyboard1=((HasInputDevices) driver).getKeyboard();
					             keyboard1.pressKey(Keys.ENTER);
					             try {
							     Thread.sleep(1000);
						         } catch (InterruptedException e) {
							     e.printStackTrace();
						         }
				
					    
					            getLos().click();
						        try {
								Thread.sleep(1000);
							    } catch (InterruptedException e) {
								e.printStackTrace();
							    }
						    
						   
						       ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,450)", "");
						 
						       getIndustry().click();
						 
						       try {
								Thread.sleep(1000);
							   } catch (InterruptedException e) {
								e.printStackTrace();
							}
						       
						       if(groupType.equalsIgnoreCase("OPEN")){
						    	   ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getOpenRadio());   
						       }
						       
						       else if(groupType.equalsIgnoreCase("MEMBERONLY")){
						    	   ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getMemberOnlyRadio());
						    	   
						       }
						       
						       else if(groupType.equalsIgnoreCase("PRIVATE")){
						    	   ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getPrivateRadio());
						    	   
						       }
						       
						       else if(groupType.equalsIgnoreCase("UNLISTED")){
						    	   ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getSecretadio());   
						       }
						   
						   
							
							 
							 try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)", "");
							 
							 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getPreview());
								
							 
							 
							 try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
						    
							 
							 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getSaveButton());
							// Alert alert=driver.switchTo().alert();
		                   //  alert.accept();
							 
							 try {
									Thread.sleep(4000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							 boolean present;
							 try {
								 getSaveButton();
							  //  driver.findElement(By.className("j-placeHeaderWrap"));
							    present = true;
							 } catch (NoSuchElementException e) {
							    present = false;
							 }
							 if(present){
							// By grpmainDiv= By.className("j-placeHeaderWrap");  
							//  WebElement grpmain= driver.findElement(grpmainDiv);
							 // WebElement grpd=  grpmain.findElement(By.className("j-placeTitle"));
						//	String newGroupCreated =  grpd.getText();
							 
							//if( newGroupCreated.contains(nameStr)&&newGroupCreated.contains(groupType)){
								success=0;
								//System.out.println("it has reached this line");
							//}
							 }
							 else{
								success=1; 
							 }
			    	
			    }
		 return success;
			    
	}
		 
		 
		
		
		
		
	}	
		
	

