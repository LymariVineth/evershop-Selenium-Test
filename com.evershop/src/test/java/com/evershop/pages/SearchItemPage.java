package com.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchItemPage extends BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	protected By itemLink=By.xpath("//div[3]/div/div[2]/div/div/div[2]/a ");   
	
	
	         //Nike revolution 5
	//div[3]/div/div[2]/div/div/div[2]/a          Coated glitter chuck taylor all star
    //div[3]/div/div[2]/div/div/div[2]/a          Lite racer
		
    public SearchItemPage(WebDriver driver){
        super(driver); 
        this.driver=driver;
        visit();
    }
    
    public void selectItem() {
		click(itemLink);		
	}
}
