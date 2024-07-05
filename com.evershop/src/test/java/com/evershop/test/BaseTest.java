package com.evershop.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.evershop.pages.AccountDetailsPage;
import com.evershop.pages.CheckOutPage;
import com.evershop.pages.DetailItemPage;
import com.evershop.pages.HomePage;
import com.evershop.pages.SearchItemPage;
import com.evershop.pages.ShoppingCartPage;
import com.evershop.pages.LoginPage;
import com.evershop.pages.RegisterPage;
import com.evershop.pages.ResetPaswordPage;


public class BaseTest {
	
	public ChromeDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports  extentReports;
	public ExtentTest extentTest;
	
	protected static ThreadLocal<ExtentTest> extentTestThread= new ThreadLocal<ExtentTest>();
		
	 protected HomePage homePage;
	 protected LoginPage loginPage;
	 protected RegisterPage registerPage;
	 protected AccountDetailsPage accountDetailsPage;
	 protected ResetPaswordPage resetPasswordPage;
	 protected SearchItemPage searchItemPage;
	 protected DetailItemPage detailItemPage;
	 protected ShoppingCartPage shoppingCartPage;
	 protected CheckOutPage checkOutPage;
	 
	 protected int z;

		String reportName = new SimpleDateFormat("YYYYMMddhhmmss").format(new Date());


		@BeforeTest(groups= {"Functional","Integration","Regression"})
		public void setupReport() {
			sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/"+reportName+".html");
			extentReports = new ExtentReports();
			extentReports.attachReporter(sparkReporter);
			//config ...
		}


		@BeforeMethod(groups= {"Functional","Integration","Regression"})
		public void openBrowser() {			
			ChromeOptions options =  new ChromeOptions();
			options.setBrowserVersion("125");
			driver = new ChromeDriver(options);
			homePage=new HomePage(driver);
			loginPage= new LoginPage(driver);
			registerPage=new RegisterPage(driver);
			accountDetailsPage=new AccountDetailsPage(driver);
			resetPasswordPage= new ResetPaswordPage(driver);
			searchItemPage= new SearchItemPage(driver);
			detailItemPage=new DetailItemPage(driver);
			shoppingCartPage= new ShoppingCartPage(driver);
			checkOutPage= new CheckOutPage(driver);
		}
		


		@AfterMethod (groups= {"Functional","Integration","Regression"})
		public void tearDown(ITestResult result) {
			if(result.getStatus() ==  ITestResult.FAILURE) {			
				//label fail
				extentTestThread.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ " - caso de prueba FALLADO ", ExtentColor.RED));
				//root cause
				extentTestThread.get().log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+ " - posible causa raiz ", ExtentColor.RED));
				extentTestThread.get().addScreenCaptureFromPath(captureScreenshot(result.getName())); 
				

			}else if(result.getStatus() ==  ITestResult.SKIP) {

				extentTestThread.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ " - caso de prueba SALTADO", ExtentColor.AMBER));
				

			}else if(result.getStatus() ==  ITestResult.SUCCESS) {

				extentTestThread.get().log(Status.PASS, MarkupHelper.createLabel(result.getName()+ " - caso de prueba PASADO", ExtentColor.GREEN));
				
			}
			
			if(driver!=null) {
				driver.quit();
			}

		}


		@AfterTest (groups= {"Functional","Integration","Regression"})
		public void makeReport() {
			extentReports.flush();
		}
		
		public String captureScreenshot(String fileName) {
			z=z+1;
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Screenshots/"+fileName+"_"+z+"_"+reportName+".jpg");
			String destinoImg=destFile.getAbsolutePath();
			try {
				FileUtils.copyFile(sourceFile, destFile);
			}catch(IOException e) {
				e.printStackTrace();
			}
		    return destinoImg;
		}
	
}
