19:39 29/5/2026
Bien empezaremos maquetando la raiz con el conocimiento que tenemos 
>  toma en cuenta que el backend lo haremos con el init , solo centremonos en el jetpack compsoe


> la estructura del proyecto seria generar un inicio , conectarlo con la pantalla principal
y realizar la pantalla inicial con un bottom panel que tenga 5 puntos alineados
los cuales serian 

Botón		Pantalla			Qué mostraría
Login		LoginnScreen 		Validacion de los datos
Inicio		HomeScreen			Bienvenida, productos destacados, ofertas
Categorías	CategoriasScreen	Audífonos, cargadores, cables, fundas, teclados, mouse
Productos	ProductosScreen		Lista completa de productos usando LazyColumn o LazyVerticalGrid
Carrito		CarritoScreen		Productos seleccionados, cantidad, total
Perfil		PerfilScreen		Datos del usuario, cerrar sesión

---------------
ideas para la pantalla inicioBienvenido, Juan 👋

Buscar accesorio tecnológico...

Categorías rápidas:
[Audífonos] [Cargadores] [Cables] [Fundas]

Productos destacados:
- Audífonos Bluetooth
- Cargador rápido 20W
- Teclado mecánico
- Mouse gamer

Ofertas del día:
- Cable USB-C con 20% de descuento
-------------------------------------
division de pantallas

ui/
 ├── LoginScreen.kt
 ├── HomeScreen.kt
 ├── CategoriasScreen.kt
 ├── ProductosScreen.kt
 ├── CarritoScreen.kt
 ├── PerfilScreen.kt
 └── MainScreen.kt
 
 ---------------------------
 



