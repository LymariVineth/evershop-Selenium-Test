package com.evershop.test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.evershop.utils.DataProviderClass;
import com.evershop.utils.Log;

public class LoginTest extends BaseTest{
	@Test(testName="TC-Login-01_Inicio de sesión exitoso:", dataProvider="dataSuccessfullLogin", dataProviderClass= DataProviderClass.class,priority=5,groups = {"Regression","Integration"})
	public void inicioSesionExitoso(Method method,String email, String password) {
		Log.info("Iniciando ejecucion de caso de prueba ... TC-Login-01 ... " + method.getName());
		extentTest = extentReports.createTest("Verificar inicio de sesión exitoso", "Inicio de sesion exitoso");
		extentTestThread.set(extentTest);
		extentTestThread.get().assignAuthor("Lymari Antuna");
		extentTestThread.get().assignCategory("Regression");
		extentTestThread.get().assignCategory("Integration");
		
		homePage.goToUserIcon();
		Log.info("   Click en el Icono de login ... ");
		Assert.assertTrue(loginPage.isLinkClickeable(), "Pagina Login no esta cargada completamente....");
		loginPage.fillOutCredentials(email,password);
		Log.info("   Captura de credenciales ... ");
		loginPage.clickSubmit();
		Log.info("   Click en el boton Sign In ... ");
		homePage.scroll();
		Assert.assertTrue(homePage.isDisplayLink(), "El login no se hizo correctamente....");
		Log.info("   El cliente se ha logueado correctamente ... ");
		homePage.goToUserIcon();			
		Assert.assertTrue(accountDetailsPage.isDisplayedLogOut(), "");
		accountDetailsPage.clickLogOut();	
						
	}
	
	@Test(testName="TC-Login-02_Inicio de sesión con credenciales incorrectas", dataProvider="dataCorrectCredentials", dataProviderClass= DataProviderClass.class,groups = "Functional",
			priority=6)
	public void credencialesCorrectas(Method method,String email, String password) {
		Log.info("Iniciando ejecucion de caso de prueba ... TC-Login-02 ..." + method.getName());
		extentTest = extentReports.createTest("Verificar que nose permita ingresar con credenciales incorrectas", "Inicio de sesión con credenciales incorrectas");
		extentTestThread.set(extentTest);
		extentTestThread.get().assignAuthor("Lymari Antuna");
		extentTestThread.get().assignCategory("Regression");
		extentTestThread.get().assignCategory("Integration");
		
		homePage.goToUserIcon();
		Log.info("   Click en el Icono de login ... ");
		Assert.assertTrue(loginPage.isLinkClickeable(), "Pagina Login no esta cargada completamente....");
		loginPage.fillOutCredentials(email,password);
		Log.info("   Captura de credenciales ... ");
		loginPage.clickSubmit();
		Log.info("   Click en el boton Sign In ... ");
		loginPage.waitInvalidCredentialsErr();	
		Assert.assertNotEquals(loginPage.invalidCredentialsErr(), "Invalid email or password", "Las credenciales que intenta ingresar no son las correctas....");	
		Log.info("   Validar que no permita ingresar a la cuenta con credenciales invalidas.... ");	
	}	
		
	@Test(testName="TC-Login-03_Credenciales en blanco", dataProvider="dataWithOutCredentials", dataProviderClass= DataProviderClass.class, groups = "Functional",
			priority=7)
	public void credencialesBlanco(Method method,String email, String password){		
		Log.info(" Iniciando ejecucion de caso de prueba ... TC-Login-03 ..." + method.getName());
		extentTest = extentReports.createTest("Verificar que no se haga login cuando no capturas credenciales", "Credenciales en blanco");
		extentTestThread.set(extentTest);
		extentTestThread.get().assignAuthor("Lymari Antuna");
		extentTestThread.get().assignCategory("Regression");
		extentTestThread.get().assignCategory("Integration");
		
		homePage.goToUserIcon();
		Log.info("   Click en el Icono de login ... ");
		Assert.assertTrue(loginPage.isLinkClickeable(), "Pagina Login no esta cargada completamente....");
		loginPage.fillOutCredentials(email,password);
		Log.info("   Captura de credenciales ... ");
		loginPage.clickSubmit();
		Log.info("   Click en el boton Sign In ... ");
		loginPage.waitWithOutCredentialsErr();				
		Assert.assertNotEquals(loginPage.withOutCredentialsErr(), "This field can not be empty", "Hay campos obligatorios sin capturar...");
		Log.info("   Validar no se ingrese a sesión cuando no capturas credenciales ... ");
	}
	
	@Test(testName="TC-Login-05_Contraseña olvidada", dataProvider="dataForgotPassword", dataProviderClass= DataProviderClass.class, groups = {"Functional","Integration"},
			priority=8)
	public void recuperarContrasenia(Method method,String email){		
		Log.info(" Iniciando ejecucion de caso de prueba ... TC-Login-05 ..." + method.getName());
		extentTest = extentReports.createTest("Verificar que no se haga login cuando no capturas credenciales", "Credenciales en blanco");
		extentTestThread.set(extentTest);
		extentTestThread.get().assignAuthor("Lymari Antuna");
		extentTestThread.get().assignCategory("Regression");
		extentTestThread.get().assignCategory("Integration");
		
		homePage.goToUserIcon();
		Log.info("   Click en el Icono de login ... ");
		Assert.assertTrue(loginPage.isLinkClickeable(), "Pagina Login no esta cargada completamente....");
		loginPage.goToForgotLink();
		Log.info("   Click en el link FORGOT YOUR PASSWORD? ... ");
		Assert.assertTrue(resetPasswordPage.isDisplayPage(), "Pagina Reset Password no esta cargada completamente....");
		resetPasswordPage.fillOutEmail(email);
		Log.info("   Captura de email ... ");
		resetPasswordPage.clickSubmit();
		Log.info("   Click en el boton Reset Password ... ");
		resetPasswordPage.waitenvioPasswordMsg();				
		Assert.assertEquals(resetPasswordPage.envioPasswordMsg(), "We have sent you an email with a link to reset your password. Please check your inbox.", "No se pudo resetear contrasenia...");		
		Log.info("   Validar que se envíe mensaje indicando que se envió un correo con el link de reinicio ... ");
	}
	

}
