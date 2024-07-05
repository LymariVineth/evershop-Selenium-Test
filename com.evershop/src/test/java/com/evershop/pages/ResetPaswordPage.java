package com.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPaswordPage  extends BasePage {
	protected WebDriver driver;
	protected By resetBtn=By.xpath("//button[@type='submit' and @class='button primary']");
	protected By emailTxt=By.name("email");
    protected By envioPasswordMsg=By.xpath("//p[@class='text-center text-success']");   //We have sent you an email with a link to reset your password. Please check your inbox.
    protected By forgotPage=By.xpath("//*[contains(text(),'Enter your email address')]");
    
	
	public ResetPaswordPage(WebDriver driver){
        super(driver); 
        this.driver=driver;
       // visit();
    }
	
	public boolean isDisplayPage() {
		return isDisplayElement(forgotPage);
	}
	
	 public void fillOutEmail(String email){
	        type(emailTxt,email);
	    }
	 
	 public void clickSubmit() {
	        submit(resetBtn);
	    }
	 
	    public void waitenvioPasswordMsg() {
	    	waitElement(envioPasswordMsg);
	    }
	    
	    
	    public String envioPasswordMsg(){    	
	    	try {
	    		return getText(envioPasswordMsg);    		
	    	}catch(Exception e) {
	    		return null;
	    	}    	
	    }
}
