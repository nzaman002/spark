package com.pwc.spark.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateGroup_ {
	public WebDriver driver;	
	public CreateGroup_(WebDriver driver){
		this.driver= driver;
	}
	
	
	 
	 public By lastCircle  =  By.id("step-2-btn");
		public WebElement getLastCircle(){
			return driver.findElement(lastCircle);
		}
		
		
		
	 public By getStarted  =  By.linkText("Get Started");
		public WebElement getgetStarted(){
				return driver.findElement(getStarted);
			}
		
		
	 public By groupName  = By.id("jive-place-name-input");
		public WebElement getGroupName(){
				return driver.findElement(groupName);
		}
		
		
	    
	 public By accountGroup  = By.name("clientGroup");
		public WebElement getAccountGroup(){
				return driver.findElement(accountGroup);
		}
		
		
		     
	 public By nonaccountGroup  = By.id("pwc-clientgroup-NO");  
			public WebElement getNonAccountGroup(){
				return driver.findElement(nonaccountGroup);
				
			}
		
		
		 
	  public By responsiblePartner  =By.id("pwc-responsible-partner");
			public WebElement getResponsiblePartner(){
					return driver.findElement(responsiblePartner);
			}
			
			
			
		    
	  public By territory  =By.className("chosen-container-single");
		  public WebElement getTerritory(){
					return driver.findElement(territory);
			}
		  
		  
	  
	  
	  public WebElement getLos(){
		  By losmainDiv= By.id("pwc-client-group-lineofservice");  
		  WebElement losmain= driver.findElement(losmainDiv);
		  WebElement los=  losmain.findElement(By.className("chosen-container-multi"));
		  los.click();
		  WebElement d=    los.findElement(By.cssSelector("li.active-result[data-option-array-index='1']"));
		  return (d);
		 
		}
	  
	  
	  public WebElement getIndustry(){
		  By industrymainDiv= By.id("pwc-client-group-industry");
		  WebElement industrymain= driver.findElement(industrymainDiv);
		  WebElement industry=  industrymain.findElement(By.className("chosen-container-multi"));
		  industry.click();
		  WebElement w=industry.findElement(By.cssSelector("li.active-result[data-option-array-index='1']"));
		  return (w);
		 
		}
	  
	 
		 
	   public By cc_yes  =By.id("pwc-clientConfidential-YES");
	          public WebElement getCC_Yes(){
					return driver.findElement(cc_yes);
			}
	          
	          public By cc_no  =By.id("pwc-clientConfidential-NO");
	          public WebElement getCC_No(){
					return driver.findElement(cc_no);
			}
		  
		 
			 
	   public By preview  =By.id("js-about-apply");
			  public WebElement getPreview(){
						return driver.findElement(preview);
				}
			  
			 
				 
		public By save  =By.id("save");
			   public WebElement getSaveButton(){
							return driver.findElement(save);
					}
		  
		  
	    
		public By openRadio  = By.id("jive-socialgroup-type-OPEN");
				public WebElement getOpenRadio(){
						return driver.findElement(openRadio);
				}
				
				
		public By memberonlyRadio  = By.id("jive-socialgroup-type-MEMBER_ONLY");
				public WebElement getMemberOnlyRadio(){
						return driver.findElement(memberonlyRadio);
				}
				
				
				
		 public By privateRadio  = By.id("jive-socialgroup-type-PRIVATE");
				public WebElement getPrivateRadio(){
						return driver.findElement(privateRadio);
				}
				
		  public By secretRadio  = By.id("jive-socialgroup-type-SECRET");
					public WebElement getSecretadio(){
							return driver.findElement(secretRadio);
					}
				
				
		 
			
			
			
	

}
