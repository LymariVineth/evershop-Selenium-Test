package com.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegisterPage extends BasePage {
protected WebDriver driver;
	
	protected By fullNameTxt=By.name("full_name");	
	protected By emailTxt=By.name("email");
	protected By passwordTxt=By.name("password");
	protected By signUpBtn=By.xpath("//*[@id='registerForm']/div[2]/button");

	//errores
	protected By ObligatoryErr=By.xpath("//*[contains(text(),'This field can not be empty')]");  // This field can not be empty  
	protected By invalidEmailErr=By.xpath("//*[contains(text(),'Invalid email')]");   //   Invalid email
	protected By emailUsedErr=By.xpath("//*[contains(text(),'Email is already used')]"); //    Email is already used
	protected By invalidPassErr=By.xpath("//*[contains(text(),'Password is invalid: Password must be at least 6 characters')]");   //Password is invalid: Password must be at least 6 characters   
	
	protected int x;
	protected WebElement element;

    public RegisterPage(WebDriver driver){
        super(driver); 
        this.driver=driver;
       // visit();
    }
    
    public void fillOutRegisterForm(String fullName, String email, String password){
    	if(fullName.equals("NoAplica"))
    		type(fullNameTxt,"");
    	else {
    		type(fullNameTxt,fullName);
    	}
    	if(email.equals("NoAplica"))
    		type(emailTxt,"");
    	else {
    		type(emailTxt,email);
    	}
    	if(password.equals("NoAplica"))
    		type(passwordTxt,"");
    	else {
    		type(passwordTxt,password);
    	}    	
       
    }
    
    public void clickSubmit() {
        submit(signUpBtn);
    }
    
    
    public String obligatoryErr(){   
    	try {return getText(ObligatoryErr);
    		
    	}catch(Exception e) {
    		return null;
    	}
    	
    }
    

    
    public String invalidPassErr(){        	
    	try {
    		return getText(invalidPassErr);
    	}catch(Exception e) {
    		return null;
    	}    	
    }
    
    public String emailUsedErr(){        	
    	try {
    		return getText(emailUsedErr);
    	}catch(Exception e) {
    		return null;
    	}    	
    }
    
    public String invalidEmailErr(){        	
    	try {
    		return getText(invalidEmailErr);
    	}catch(Exception e) {
    		return null;
    	}    	
    }
    
    public boolean isFormClickeable() {
    	return isDisplayElement(fullNameTxt);
    }
    
    
    
    
    
    public void waitInvalidPassErr() {
    	waitElement(invalidPassErr);
    }
    
    public void waitEmailUsedErr() {
    	waitElement(emailUsedErr);
    }
    
    public void waitInvalidEmailErr() {
    	waitElement(invalidEmailErr);
    }

    
    public void waitObligatoryErr() {
    	waitElement(ObligatoryErr);
    }
        
    				

}
