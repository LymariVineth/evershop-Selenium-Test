package com.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	protected By emailTxt=By.name("email");
	protected By continueToShippingBtn=By.xpath("//*[contains(text(),'Continue to shipping')]"); 
	
	protected By contactLbl=By.xpath("//*[contains(text(),'Shipping Address')]");   
	protected By fullNameTxt=By.name("address[full_name]");
	protected By telephoneTxt=By.name("address[telephone]");
	protected By addressTxt=By.name("address[address_1]");
	protected By cityTxt=By.name("address[city]");
	protected By countrySelect=By.name("address[country]");    // United States
	protected By provinceSelect=By.name("address[province]");    // California
	protected By cpTxt=By.name("address[postcode]");
	protected By standardCheck=By.xpath("//*[@id='checkoutShippingAddressForm']/div[1]/div[6]/div/div/div/div[1]/label/span[1]");      //Standar Delivery
	protected By expressCheck=By.xpath("//*[@id='checkoutShippingAddressForm']/div[1]/div[6]/div/div/div/div[2]/label/span[1]");      //Express Delivery
	protected By continueBtn=By.xpath("//*[contains(text(),'Continue to payment')]"); 
	
	protected By cashOption=By.xpath("//*[@id='checkoutPaymentForm']/div[3]/div[1]/div/div/div/div[1]/a");      // cash
	protected By paypalOption=By.xpath("//*[@id='checkoutPaymentForm']/div[3]/div[2]/div/div/div/div[1]/a");     // paypal
	protected By tdcOption=By.xpath("//*[@id='checkoutPaymentForm']/div[3]/div[3]/div/div/div/div[1]/a");      // tdc
	
	protected By cardNumberTxt=By.xpath("//div[2]/span/input");   //4242 4242 4242 4242
	protected By cardExpiryTxt=By.xpath("//span[1]/span/span/input");  // 04/24
	protected By cvcTxt=By.xpath("//span[2]/span/span/input");   // 242
	
	protected By orderBtn=By.xpath("//*[contains(text(),'Place Order')]"); 
	protected By checoutSuccessLbl=By.xpath("//*[contains(text(),'Contact information')]"); 
	
	
	
	
	
		
    public CheckOutPage(WebDriver driver){
        super(driver); 
        this.driver=driver;
        visit();
    }
    
    public boolean isDisplayPage() {
    	return isDisplayElement(contactLbl);   	
    }
    
    public void continueToShipping(String email) {
    	type(emailTxt,email);
    	click(continueToShippingBtn);
    }
    
    public void filloutShippingForm(String name, String phone, String address, String city, String country, String providence, String cp, String standardMethod, String expressMethod) {
    	type(fullNameTxt,name);
    	type(telephoneTxt,phone);
    	type(addressTxt,address);
    	type(cityTxt,city);
    	type(countrySelect,country);
    	type(provinceSelect,providence);
    	type(cpTxt,cp);
    	scroll();
    	if(standardMethod.equals("Si")) {    		
    		click(standardCheck);
    	}else if(expressMethod.equals("Si")) {
    		click(expressCheck);
    	}
    	else {
    		System.out.println("No aplica metodo..");
    	}	
    }
    
    public void clickContinueOrder() {
    	click(continueBtn);
    }
    
    public void selectPaymentMethod(String cash, String paypal, String tdc, String cardNumber, String expiryDate, String cvc) {
    	
    	if(cash.equals("Si")) {
    		click(cashOption);
    	}else if(paypal.equals("Si")) {
    		click(paypalOption);
    	}else if(tdc.equals("Si")) {
    		click(tdcOption);
    		type(cardNumberTxt,cardNumber);
    		type(cardExpiryTxt,expiryDate);
    		type(cvcTxt,cvc);
    	}
    	else {
    		System.out.println("No aplica metodo de pago..");
    	}	
    }
    
    public void clickPlaceOrder() {
    	click(orderBtn);
    }
    
    public boolean isDisplayElement() {
    	return isDisplayElement(checoutSuccessLbl);   	
    }
    
    public void scroll() {		
		WebElement element=find(standardCheck);
		scroll(element);
	}
}
