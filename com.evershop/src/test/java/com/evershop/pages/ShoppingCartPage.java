package com.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	
	protected By pageLbl=By.xpath("//*[contains(text(),'Order summary')]");   
	protected By removeLink=By.xpath("//*[contains(text(),'Remove')]"); 
	protected By continueShoppingBtn=By.xpath("//*[contains(text(),'CONTINUE SHOPPING')]");
	protected By checkOutBtn=By.xpath("//a[@href='/checkout' and @class='button primary']"); 
	
		
    public ShoppingCartPage(WebDriver driver){
        super(driver); 
        this.driver=driver;
        visit();
    }
    
    public boolean isDisplayPage() {
    	return isDisplayElement(pageLbl);   	
    }
    
    public void clickRemoveLink() {
    	click(removeLink);   	
    }
    
    public void clickContinueBtn() {
    	click(continueShoppingBtn);   	
    }
    
    public void clickCheckOutBtn() {
    	click(checkOutBtn);   	
    }
}
