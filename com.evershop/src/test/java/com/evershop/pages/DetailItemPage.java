package com.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailItemPage extends BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	
	protected By addToCartBtn=By.xpath("//*[contains(text(),'ADD TO CART')]");   //Pink
	protected By qtyTxt=By.name("qty"); //tennis rosas converse
	protected By sizeSLink=By.linkText("S");
	protected By sizeMLink=By.linkText("M");
	protected By sizeXLink=By.linkText("X");
	protected By sizeLLink=By.linkText("L");
	
	protected By color1Link=By.linkText("Purple");   //Purple
	protected By color2Link=By.linkText("Brown");   //Brown
	protected By color3Link=By.linkText("Black");   //Black
	protected By color4Link=By.linkText("Red");   //Red
	protected By color5Link=By.linkText("White");   //White
	
	protected By continueShoppingLink=By.linkText("Continue Shopping");
	protected By viewCartBtn=By.xpath("//*[contains(text(),'VIEW CART')]");
	protected By cartBtn=By.xpath("//a[@href='/cart' and @class='mini-cart-icon' ]");
	
	
	protected By xxx=By.xpath("//li[@class='selected']");
		
    public DetailItemPage(WebDriver driver){
        super(driver); 
        this.driver=driver;
        visit();
    }
    
    public boolean isDisplayBtn() {
    	return isDisplayElement(addToCartBtn);   	
    }
    
    public void addItemToCart(String qty, String size, String color) {
    	clear(qtyTxt);
    	type(qtyTxt,qty);
    	
    	if(color.equals("Purple")) {
    		click(color1Link);
    	}else {
    		if(color.equals("Brown")) {
    			click(color2Link);
    		}else {
    			if(color.equals("Black")) {
        			click(color3Link);
        		}else {
        			if(color.equals("Red")) {
            			click(color4Link);
            		}else {
            			if(color.equals("White")) {
                			click(color5Link);
                		}else {
                			System.out.println("No selecciono COLOR");
                		}
            		}
        		}
    		}
    	}     	
    	
    	
    	waitElement(xxx);
    	
    	
    	if(size.equals("S")) {
    		click(sizeSLink);
    	}else {
    		if(size.equals("M")) {
    			click(sizeMLink);
    		}else {
    			if(size.equals("X")) {
        			click(sizeXLink);
        		}else {
        			if(size.equals("L")) {
            			click(sizeLLink);
            		}else {
            			System.out.println("No selecciono tamaño");
            		}
        		}
    		}
    	}
    	
    }
    
    
    
    public void clickAddToCartBtn() {
    	try {
			waitTime();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	click(addToCartBtn);
    }
    
    public boolean isDisplayLink() {
    	return isDisplayElement(continueShoppingLink);   	
    }
    
    public void clickContinueBtn() {
    	click(continueShoppingLink);
    }
    
    public void clickCartBtn() {
    	click(viewCartBtn);
    }
}
