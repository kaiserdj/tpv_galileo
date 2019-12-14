
# TPV – Galileo
![tpv-galileo-1](https://i.imgur.com/LoLkU6A.png)
# 1. Descripción y análisis del proyecto

El objetivo del proyecto es realizar una aplicación grafica con java y mysql, que simule el funcionamiento de una caja de supermercado y todo lo relacionado con ella. Artículos, categorías, etc. Además, deberá disponer de un terminal de venta.

El software deberá acceder al sistema de inventario para consultar precio.

El software deberá generar el ticket y conectar con el sistema de ventas para registrar la venta.

# 2. Base de datos

Los datos se almacenan en una base de datos MYSQL, se a generado una base de datos de ejemplo alojada en un servidor externo(la cual también esta en formato .sql en el proyecto para poderla importar)

## 2.1 Diseño base de datos

La base de datos cuenta con un total de 6 tablas.
* Categorias
* Det_Factura
* Factura
* Productos
* usuarios

-> Tabla Categorias: Sus columnas son:
* Id: Clave primaria de la categoria.
* Nombre: Nombre identificativo de la categoría, para mostrarlo en el terminal de ventas.
* Imagen: Link de una imagen descriptiva de la categoría en cuestión, alojada en un servidor externo .

![tpv-galileo-2](https://i.imgur.com/2H9NW3D.png)

-> Tabla det_factura: Sus columnas son:
* Id: Clave primaria de la columna.
* Id_Factura: Clave foránea a la tabla Factura, indica la factura a la que corresponde.
* Id_Producto: Clave foránea a la tabla Producto, indica el producto al que corresponde.
* Cantidad: Cantidad de dicho producto en la factura correspondiente.

![tpv-galileo-3](https://i.imgur.com/rWQvBCs.png)

-> Tabla Factura: Sus columnas son:
* Id: Clave primaria de la columna.
* Id_Usuario: Clave foránea a la tabla Usuarios, indica el usuario que a creado la factura.
* Fecha: Fecha concreta de la creación de la factura.
* Cerrado: Estado de la factura: 
	* 0 -> En creación
	* 1 -> Factura cerrada o terminada
	* -1 -> Factura cancelada

![tpv-galileo-4](https://i.imgur.com/XCI4ha2.png)

-> Tabla Productos: Sus columnas son:
* Id: Clave primaria de la columna.
* Nombre: Nombre del producto
* Precio: Precio de la unidad/kg del producto
* Id_Usuario: Clave foránea a la tabla Categorias, indica la categoria a la que corresponde.
* Stock: Cantidad de la que se dispone
* Iva: Iva del producto
* Imagen: Link de una imagen descriptiva del producto en cuestión, alojada en un servidor externo .

![tpv-galileo-5](https://i.imgur.com/jXcJx44.png)

-> Tabla usuarios: Sus columnas son:
* Id: Clave primaria de la columna.
* Nombre: Nombre del usuario
* Contraseña: Contraseña del usuario

![tpv-galileo-6](https://i.imgur.com/HsbHYUI.png)

## 2.2 Diagrama E/R base de datos

![tpv-galileo-7](https://i.imgur.com/RvX2Dn3.png)

# 3. Desarrollo del proyecto

El proyecto cuenta con las siguientes clases:

* Login: Inicio de sesión y configuración de la base de datos.

* Terminal: Menú principal que permite gestionar las ventas.

* Categorías: Es un objeto categorías relacionado con la tabla categorías de la base de datos

* Conexión: Métodos para ayudar a realizar conexiones y modificaciones de la base de datos

* Factura: Objeto con métodos para la creación y gestión de una factura

* Producto: Es un objeto producto relacionado con la tabla productos de la base de datos

* Ticket: Ventana que se abre al finalizar una factura, con información del ticket.

* Utilidades: Métodos para ayudar a realizar funciones de otros métodos.

# 4. Manual de uso

Al iniciar el programa se abre el Login
![tpv-galileo-8](https://i.imgur.com/qOcjdxp.png)

En el que se debe introducir un usuario y contraseña, que debe estar en la tabla usuarios de la base de datos,
también se puede cambiar de base de datos dando a Configuración.

![tpv-galileo-9](https://i.imgur.com/CFXevnw.png)

Donde se debe rellenar con los datos necesarios para iniciar sesión en la base de datos que se desee.
Una vez iniciada sesión se abrirá el terminal
![tpv-galileo-10](https://i.imgur.com/H3lFSmg.png)
En el cual automáticamente o carga la ultima factura, si dicha factura no fue cerrada o cancelada. O abre una nueva factura, luego puede introducir los productos seleccionando la categoría que se desee y pulsando en el producto.
![tpv-galileo-11](https://i.imgur.com/CLwP9eM.png)
Otra opción es pulsando en la pestaña Código producto en la cual salen todos los productos con sus códigos, en la que puede introducir un código manualmente o pulsar en la tabla el producto que se desee.

Para cancelar la factura se debe dar al botón Cancelar Factura y automáticamente se cancela dicha factura y se genera una nueva.

Para finalizar una factura se debe dar al botón Terminar Factura y  automáticamente se le mostrara una ventana con información importante de la factura y para poderla imprimir.

![tpv-galileo-12](https://i.imgur.com/TJBkX9U.png)

Para imprimir la factura se debe introducir la dirección donde se desee guardar y un nombre.pdf
