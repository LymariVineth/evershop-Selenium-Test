package com.evershop.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	protected By userIcon=By.xpath("//*[@id='app']/div/div[2]/div[3]/div[3]/a");
	protected By shopLink=By.xpath("//*[contains(text(),'Shop kids')]");   //Shop kids
	protected By searchIcon=By.xpath("//*[@class='search-icon']");
	protected By searchTxt=By.xpath("//*[@placeholder='Search']");
		
    public HomePage(WebDriver driver){
        super(driver); 
        this.driver=driver;
        visit();
    }
    
    public void goToUserIcon(){
        click(userIcon);
    }
    
    public boolean isDisplayLink() {
    	return isDisplayElement(shopLink);   	
    }
    
	public void scroll() {		
		WebElement element=find(shopLink);
		scroll(element);
	}
	
	public void clickSearchIcon() {
		click(searchIcon);
	}
	
	public void searchItem(String item) {
		type(searchTxt,item);
		enter(searchTxt);
	}

}
