package com.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPage extends BasePage {
	protected WebDriver driver;
	
	protected By logOutLink=By.linkText("Logout");


	    public AccountDetailsPage(WebDriver driver){
	        super(driver); 
	        this.driver=driver;
	        //visit();
	    }
	    
	    public boolean isDisplayedLogOut() {
	    	return isDisplayElement(logOutLink);
	    }
	    
	    public void clickLogOut() {
	    	click(logOutLink);
	    }

}
