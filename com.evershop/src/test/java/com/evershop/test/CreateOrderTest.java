package com.evershop.test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.evershop.utils.DataProviderClass;
import com.evershop.utils.Log;

public class CreateOrderTest extends BaseTest{
	@Test(testName="TC-Order-01_Añadir productos al carrito", dataProvider="addItemsToCart", dataProviderClass= DataProviderClass.class,priority=9,groups = {"Regression"})
	public void agregarProductosCarrito(Method method,String item, String qty, String size, String color) {
		Log.info("Iniciando ejecucion de caso de prueba ... TC-Order-01 ... " + method.getName());
		extentTest = extentReports.createTest("Verificar agregar productos al carrito exitosamente", "Producto agregado correctamente");
		extentTestThread.set(extentTest);
		extentTestThread.get().assignAuthor("Lymari Antuna");
		extentTestThread.get().assignCategory("Regression");
		extentTestThread.get().assignCategory("Integration");
		
		homePage.clickSearchIcon();
		Log.info("   Se visualiza input para capturar el texto a buscar ... ");
		homePage.searchItem(item);
		Log.info("   Buscamos el producto ... ");
		searchItemPage.selectItem();
		Log.info("   Click en el producto seleccionado ... ");
		Assert.assertTrue(detailItemPage.isDisplayBtn(), "Pagina Detalle del producto no esta cargada completamente....");
		Log.info("   Entramos al detalle del producto seleccionado ... ");
		detailItemPage.addItemToCart(qty, size, color); 
		Log.info("   Seleccionamos las caracteristicas de la compra ... ");
		detailItemPage.clickAddToCartBtn();
		Log.info("   Click en agregar al carrito ... ");
		Assert.assertTrue(detailItemPage.isDisplayLink(), "Seccion del carrito no esta cargada correctamente....");
		Log.info("   Producto agregado correctamente ... ");
	}
	
	
	@Test(testName="TC-Order-02_Eliminar productos del carrito", dataProvider="deleteItemsToCart", dataProviderClass= DataProviderClass.class,priority=10,groups = {"Regression"})
	public void borrarProductosCarrito(Method method,String item, String qty, String size, String color) {
		Log.info("Iniciando ejecucion de caso de prueba ... TC-Order-02 ... " + method.getName());
		extentTest = extentReports.createTest("Verificar eliminar productos del carrito exitosamente", "Producto eliminado correctamente");
		extentTestThread.set(extentTest);
		extentTestThread.get().assignAuthor("Lymari Antuna");
		extentTestThread.get().assignCategory("Regression");
		extentTestThread.get().assignCategory("Integration");
		
		homePage.clickSearchIcon();
		Log.info("   Se visualiza input para capturar el texto a buscar ... ");
		homePage.searchItem(item);
		Log.info("   Buscamos el producto ... ");
		searchItemPage.selectItem();
		Log.info("   Click en el producto seleccionado ... ");
		Assert.assertTrue(detailItemPage.isDisplayBtn(), "Pagina Detalle del producto no esta cargada completamente....");
		Log.info("   Entramos al detalle del producto seleccionado ... ");
		detailItemPage.addItemToCart(qty, size, color); 
		Log.info("   Seleccionamos las caracteristicas de la compra ... ");
		detailItemPage.clickAddToCartBtn();
		Log.info("   Click en agregar al carrito ... ");
		Assert.assertTrue(detailItemPage.isDisplayLink(), "Seccion del carrito no esta cargada correctamente....");
		Log.info("   Producto agregado correctamente ... ");
		detailItemPage.clickCartBtn();
		Assert.assertTrue(shoppingCartPage.isDisplayPage(), "Pagina no encontrada....");
		Log.info("   Entramos al carrito de compras ... ");
		shoppingCartPage.clickRemoveLink();
		Log.info("   Producto eliminado correctamente ... ");
		shoppingCartPage.clickContinueBtn();
	}
	
	@Test(testName="TC-Order-04_Creación de orden exitosa", dataProvider="checkOutOrder", dataProviderClass= DataProviderClass.class,priority=11,groups = {"Regression"})
	public void ordenarProductos(Method method,String item1, String qty1, String size1, String color1, String item2, String qty2, String size2, String color2, String item3, String qty3, String size3, String color3,
			String email,String name, String phone, String address, String city, String country, String providence, String cp, String standardMethod, String expressMethod,
			String cash, String paypal, String tdc, String cardNumber, String expiryDate, String cvc) {
		Log.info("Iniciando ejecucion de caso de prueba ... TC-Order-04 ... " + method.getName());
		extentTest = extentReports.createTest("Verificar checkout de productos del carrito exitosamente", "La compra fue exitosa");
		extentTestThread.set(extentTest);
		extentTestThread.get().assignAuthor("Lymari Antuna");
		extentTestThread.get().assignCategory("Regression");
		extentTestThread.get().assignCategory("Integration");	
		
			homePage.clickSearchIcon();
			Log.info("   Se visualiza input para capturar el texto a buscar ... ");
			homePage.searchItem(item1);
			Log.info("   Buscamos el producto ... ");
			searchItemPage.selectItem();
			Log.info("   Click en el producto seleccionado ... ");
			Assert.assertTrue(detailItemPage.isDisplayBtn(), "Pagina Detalle del producto no esta cargada completamente....");
			Log.info("   Entramos al detalle del producto seleccionado ... ");
			detailItemPage.addItemToCart(qty1, size1, color1); 
			Log.info("   Seleccionamos las caracteristicas de la compra ... ");
			detailItemPage.clickAddToCartBtn();
			Log.info("   Click en agregar al carrito ... ");
			Assert.assertTrue(detailItemPage.isDisplayLink(), "Seccion del carrito no esta cargada correctamente....");
			Log.info("   Producto 1 agregado correctamente ... ");
			detailItemPage.clickContinueBtn();
			
			homePage.clickSearchIcon();
			Log.info("   Se visualiza input para capturar el texto a buscar ... ");
			homePage.searchItem(item2);
			Log.info("   Buscamos el producto ... ");
			searchItemPage.selectItem();
			Log.info("   Click en el producto seleccionado ... ");
			Assert.assertTrue(detailItemPage.isDisplayBtn(), "Pagina Detalle del producto no esta cargada completamente....");
			Log.info("   Entramos al detalle del producto seleccionado ... ");
			detailItemPage.addItemToCart(qty2, size2, color2); 
			Log.info("   Seleccionamos las caracteristicas de la compra ... ");
			detailItemPage.clickAddToCartBtn();
			Log.info("   Click en agregar al carrito ... ");
			Assert.assertTrue(detailItemPage.isDisplayLink(), "Seccion del carrito no esta cargada correctamente....");
			Log.info("   Producto 2 agregado correctamente ... ");
			detailItemPage.clickContinueBtn();
			
			homePage.clickSearchIcon();
			Log.info("   Se visualiza input para capturar el texto a buscar ... ");
			homePage.searchItem(item3);
			Log.info("   Buscamos el producto ... ");
			searchItemPage.selectItem();
			Log.info("   Click en el producto seleccionado ... ");
			Assert.assertTrue(detailItemPage.isDisplayBtn(), "Pagina Detalle del producto no esta cargada completamente....");
			Log.info("   Entramos al detalle del producto seleccionado ... ");
			detailItemPage.addItemToCart(qty3, size3, color3); 
			Log.info("   Seleccionamos las caracteristicas de la compra ... ");
			detailItemPage.clickAddToCartBtn();
			Log.info("   Click en agregar al carrito ... ");
			Assert.assertTrue(detailItemPage.isDisplayLink(), "Seccion del carrito no esta cargada correctamente....");
			Log.info("   Producto 3 agregado correctamente ... ");
			
			
			detailItemPage.clickCartBtn();
			Assert.assertTrue(shoppingCartPage.isDisplayPage(), "Pagina no encontrada....");
			Log.info("   Entramos al carrito de compras ... ");
			shoppingCartPage.clickCheckOutBtn();
			Log.info("   Click en el botón checkout ... ");	
			checkOutPage.continueToShipping(email);
			Log.info("   Logueamos al usuario para continuar con la compra ... ");	
			Assert.assertTrue(checkOutPage.isDisplayPage(), "Pagina Checkout no esta cargada correctamente....");
			Log.info("   Se despliega la pagina del formulario para iniciar con el checkout de la orden. ... ");
			checkOutPage.filloutShippingForm(name, phone, address, city, country, providence, cp, standardMethod,expressMethod);
			Log.info("   Llenamos el formulario con la información de entrega. ... ");
			checkOutPage.clickContinueOrder();
			Log.info("   Pasamos a la pantalla de metodo de pago. ... ");
			checkOutPage.selectPaymentMethod(cash, paypal, tdc, cardNumber, expiryDate, cvc);
			Log.info("   Seleccionamos el metodo de pago a utilizar. ... ");
			checkOutPage.clickPlaceOrder();
			Assert.assertTrue(checkOutPage.isDisplayElement(), "La orden no se completó correctamente....");
			Log.info("   Orden completada correctamente. ... ");
	}

}  
