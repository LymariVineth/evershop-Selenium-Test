package com.evershop.pages;

import com.evershop.test.BaseTest;
import com.evershop.utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    int time_Out=10; //es para la espera explicita

    public BasePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(Variables.timeOut));
    }

    public void setTimeOutSeconds(int time_Out){
       this.time_Out= time_Out;
    }

    public void visit(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Variables.timeOut));
        driver.get(Variables.url);
    }
    
  

    public WebElement find(By element){
        return driver.findElement(element);
    }

    public void click(By element){
        find(element).click();
    }
    
    public void clear(By element){
        find(element).clear();
    }
   

    public void submit(By element){
        find(element).submit();
    }

    public void type(By element, String text){
    	try {
        find(element).sendKeys(text);
    	}
    	catch (Exception e) {
    		find(element).sendKeys("");
    	}
    }
    
    public void type(By element, int text){
    	try {
        find(element).sendKeys(Integer.toString(text));
    	}
    	catch (Exception e) {
    		find(element).sendKeys("");
    	}
    }
    
    public void enter(By element) {
    	find(element).sendKeys(Keys.ENTER);
    }

    public boolean isDisplayElement(By locator){
        try{
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean isClickeableElement(By locator){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public void waitElement(By locator){
        	wait = new WebDriverWait(driver, Duration.ofSeconds(time_Out));
        	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        	
    }
    
    public void waitTime() throws Exception {
    	Thread.sleep(3000);
    }
    

    public String getText(By element){
        return find(element).getText();
    }
    
    public void scroll(WebElement locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", locator);
    }
    
    public void selectElement(WebElement element,String value) {
    	Select selectValue=new Select (element);
    	selectValue.selectByValue(value);
    }

}
