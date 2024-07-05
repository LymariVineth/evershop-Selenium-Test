# evershop-Selenium-Test
Examen de Selenium
Este examen lo realicé con la pagina web https://demo.evershop.io y tiene los siguientes puntos a considerar:
1.- Hubo test que debido a la funcionalidad de la pagina no existían por lo que los omití. A continuación los describo:
a)Registro de Nuevo Clientes: 
       TC-Registe-05 (Confirmación de contraseña): Este no lo tomé en cuenta porque solo se usaba 1 sola contraseña y no había campo para confirmar contraseña.
b)Login de Usuarios: 
       TC-Login-04 (Correo electrónico no registrado): No existía como tal un mensaje de error en particular para éste test, si en el dado caso se pusiera un email que nunca se ha dado de alta en el registro entraría esa validación dentro del test TC-Login-02 (Inicio de sesión con credenciales incorrectas) ya que practicamente arroja el mismo mensaje.
c)Creación de Ordenes: 
      TC-Order-03 (Modificar cantidad de productos en el carrito): Para éste test, en la sección del carrito no se podía realizar una modificación de la cantidad del producto antes de proceder al pago. No existía esa funcionalidad.

2.- Generé 3 testng.xml. Uno para cada caso. Solamente hay que modificar en el caso de querer ejecutar cierto grupo de test.
