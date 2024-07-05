package com.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
protected WebDriver driver;
	
    protected By registerLink=By.linkText("Create an account");
    protected By emailTxt=By.name("email");
    protected By passwordTxt=By.name("password");
    protected By submitBtn=By.xpath("//button[@type='submit' and @class='button primary']");
    protected By forgotPasswordLink=By.linkText("Forgot your password?");
    
    //errores
    protected By invalidCredentialsErr=By.xpath("//*[contains(text(),'Invalid email or password')]");
    protected By withOutCredentialsErr=By.xpath("//*[contains(text(),'This field can not be empty')]");   
	
    public LoginPage(WebDriver driver){
        super(driver); 
        this.driver=driver;
        //visit();
    }
    
    public void goToRegisterLink(){
        click(registerLink);
    }
    
    public void goToForgotLink(){
        click(forgotPasswordLink);
    }
    
    public boolean isLinkClickeable() {
    	return isClickeableElement(registerLink);   	
    }

    public void fillOutCredentials(String email, String password){ 
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
        submit(submitBtn);
    }
    
    public void waitInvalidCredentialsErr() {
    	waitElement(invalidCredentialsErr);
    }
    
    public String invalidCredentialsErr(){        	
    	try {
    		return getText(invalidCredentialsErr);
    	}catch(Exception e) {
    		return null;
    	}    	
    }
    
    public void waitWithOutCredentialsErr() {
    	waitElement(withOutCredentialsErr);
    }
    
    
    public String withOutCredentialsErr(){    	
    	try {
    		return getText(withOutCredentialsErr);    		
    	}catch(Exception e) {
    		return null;
    	}    	
    }
}
