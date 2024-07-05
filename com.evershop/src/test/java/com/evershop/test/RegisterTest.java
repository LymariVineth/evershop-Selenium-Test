package com.evershop.test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.evershop.utils.DataProviderClass;
import com.evershop.utils.Log;

public class RegisterTest extends BaseTest {
	
	
	@Test(testName="TC-Register-01_Registro exitoso", dataProvider="dataSuccesfullRegister", dataProviderClass= DataProviderClass.class, groups = {"Functional"},
	priority=0)
	public void registroExitoso(Method method,String fullName, String email, String password){
		Log.info(" Iniciando ejecucion de caso de prueba ... TC-Register-01 ..." + method.getName());
		extentTest = extentReports.createTest("Registro correcto de un nuevo cliente", "Registro exitoso");
		extentTestThread.set(extentTest);
		extentTestThread.get().assignAuthor("Lymari Antuna");
		extentTestThread.get().assignCategory("Regression");
		extentTestThread.get().assignCategory("Integration");
		
		homePage.goToUserIcon();
		Log.info("   Click en el Icono de login ... ");
		Assert.assertTrue(loginPage.isLinkClickeable(), "Pagina Login no esta cargada completamente....");
		loginPage.goToRegisterLink();
		Log.info("   Click en el link de registro ... ");
		Assert.assertTrue(registerPage.isFormClickeable(), "Pagina Registro no esta cargada completamente....");
		registerPage.fillOutRegisterForm(fullName,email,password);
		Log.info("   Captura información de formulario ... ");
		registerPage.clickSubmit();	
		Log.info("   Click en el botón registrar ... ");
		homePage.scroll();
		Assert.assertTrue(homePage.isDisplayLink(), "Registro de cliente no se realizo correctamente....");
		homePage.goToUserIcon();		
		Assert.assertTrue(accountDetailsPage.isDisplayedLogOut(), "Registro de cliente no se realizo correctamente....");
		Log.info("   El cliente nuevo se ha registrado correctamente ... ");
		accountDetailsPage.clickLogOut();
	}
	
	
	@Test(testName="TC-Register-02_Registro con campos obligatorios faltantes", dataProvider="dataObligatoryFields", dataProviderClass= DataProviderClass.class, groups = {"Functional","Integration"},
			priority=1)
	public void camposObligatorios(Method method,String fullName, String email, String password){	
		Log.info(" Iniciando ejecucion de caso de prueba ... TC-Register-02 ..." + method.getName());
		extentTest = extentReports.createTest("Verificar campos obligatorios en formulario de registro", "Registro con campos obligatorios");
		extentTestThread.set(extentTest);
		extentTestThread.get().assignAuthor("Lymari Antuna");
		extentTestThread.get().assignCategory("Regression");
		extentTestThread.get().assignCategory("Integration");
		
		homePage.goToUserIcon();
		Log.info("   Click en el Icono de login ... ");
		Assert.assertTrue(loginPage.isLinkClickeable(), "Pagina Login no esta cargada completamente....");
		loginPage.goToRegisterLink();
		Log.info("   Click en el link de registro ... ");
		Assert.assertTrue(registerPage.isFormClickeable(), "Pagina Registro no esta cargada completamente....");
		registerPage.fillOutRegisterForm(fullName,email,password);
		Log.info("   Captura información de formulario ... ");
		registerPage.clickSubmit();	
		Log.info("   Click en el botón registrar ... ");
		registerPage.waitObligatoryErr();		
		Assert.assertNotEquals(registerPage.obligatoryErr(), "This field can not be empty", "Hay campos obligatorios sin capturar......");
		Log.info("   Validar que no permita el registro de clientes con campos obligatorios sin capturar ... ");
	}
	
	
	@Test(testName="TC-Register-03_Formato de correo electronico valido", dataProvider="dataValidEmail", dataProviderClass= DataProviderClass.class, groups = {"Functional","Regression"},
			priority=2)
	public void correoInvalido(Method method, String fullName, String email, String password){
		Log.info(" Iniciando ejecucion de caso de prueba ... TC-Register-03 ..." + method.getName());
		extentTest = extentReports.createTest("Verificar formato de correo", "Formato de correo electronico valido");
		extentTestThread.set(extentTest);
		extentTestThread.get().assignAuthor("Lymari Antuna");
		extentTestThread.get().assignCategory("Regression");
		extentTestThread.get().assignCategory("Integration");
		
		homePage.goToUserIcon();
		Log.info("   Click en el Icono de login ... ");
		Assert.assertTrue(loginPage.isLinkClickeable(), "Pagina Login no esta cargada completamente....");
		loginPage.goToRegisterLink();
		Log.info("   Click en el link de registro ... ");
		Assert.assertTrue(registerPage.isFormClickeable(), "Pagina Registro no esta cargada completamente....");
		registerPage.fillOutRegisterForm(fullName,email,password);
		Log.info("   Captura información de formulario ... ");
		registerPage.clickSubmit();	
		Log.info("   Click en el botón registrar ... ");	
		registerPage.waitInvalidEmailErr();			
		Assert.assertNotEquals(registerPage.invalidEmailErr(), "Invalid email", "Email invalido....");	
		Log.info("   Validar que el campo Email sea invalido ... ");
	}
	
	
	@Test(testName="TC-Register-04_Contraseña segura", dataProvider="dataValidPassword", dataProviderClass= DataProviderClass.class, groups = {"Regression"},
			priority=3)
	public void contraseniaSegura(Method method,String fullName, String email, String password){
		Log.info(" Iniciando ejecucion de caso de prueba ... TC-Register-04 ..." + method.getName());
		extentTest = extentReports.createTest("Verificar contraseña segura", "Contraseña segura");
		extentTestThread.set(extentTest);
		extentTestThread.get().assignAuthor("Lymari Antuna");
		extentTestThread.get().assignCategory("Regression");
		extentTestThread.get().assignCategory("Integration");
		
		homePage.goToUserIcon();
		Log.info("   Click en el Icono de login ... ");
		Assert.assertTrue(loginPage.isLinkClickeable(), "Pagina Login no esta cargada completamente....");
		loginPage.goToRegisterLink();
		Log.info("   Click en el link de registro ... ");
		Assert.assertTrue(registerPage.isFormClickeable(), "Pagina Registro no esta cargada completamente....");
		registerPage.fillOutRegisterForm(fullName,email,password);
		Log.info("   Captura información de formulario ... ");
		registerPage.clickSubmit();	
		Log.info("   Click en el botón registrar ... ");						
		registerPage.waitInvalidPassErr();				
		Assert.assertNotEquals(registerPage.invalidPassErr(), "Password is invalid: Password must be at least 6 characters", "Password invalido....");	
		Log.info("   Validar que el campo Password sea invalido ... ");
						
	}
	
	@Test(testName="TC-Register-06_Correo electrónico unico", dataProvider="dataSuccesfullRegister", dataProviderClass= DataProviderClass.class, groups = {"Integration"},
			priority=4)
	public void correoUnico(Method method,String fullName, String email, String password) {
		Log.info("Iniciando ejecucion de caso de prueba ... TC-Register-06 ..." + method.getName());
		extentTest = extentReports.createTest("Verificar correo electronico único", "Correo electrónico único");
		extentTestThread.set(extentTest);
		extentTestThread.get().assignAuthor("Lymari Antuna");
		extentTestThread.get().assignCategory("Regression");
		extentTestThread.get().assignCategory("Integration");
		
		homePage.goToUserIcon();
		Log.info("   Click en el Icono de login ... ");
		Assert.assertTrue(loginPage.isLinkClickeable(), "Pagina Login no esta cargada completamente....");
		loginPage.goToRegisterLink();
		Log.info("   Click en el link de registro ... ");
		Assert.assertTrue(registerPage.isFormClickeable(), "Pagina Registro no esta cargada completamente....");
		registerPage.fillOutRegisterForm(fullName,email,password);
		Log.info("   Captura información de formulario ... ");
		registerPage.clickSubmit();	
		Log.info("   Click en el botón registrar ... ");
		registerPage.waitEmailUsedErr();				
		Assert.assertNotEquals(registerPage.emailUsedErr(), "Email is already used", "No se realizo el registro porque el email ya existe....");	
		Log.info("   Validar que no se inserten 2 usuario con el mismo correo.... ");					
	}
 }
