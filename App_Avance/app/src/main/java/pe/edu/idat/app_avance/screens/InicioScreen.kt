package pe.edu.idat.app_avance.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController



@Composable  // LA IDEA ES REDIRECCIONAR A LA PANTALLA B
fun PantallaB(navController: NavController) {  // esto genera una variable para usarse de guia
    Column(Modifier.padding(top = 25.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Button(onClick = {
            navController.navigate("pantallaA")

        }, colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4CAF50), // Color de fondo del botón (Verde en este caso)
            contentColor = Color.White,         // Color del texto o iconos dentro del botón

            // Opcional: Colores para cuando el botón está desactivado (enabled = false)
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.LightGray
        )

        ) {
            Text(text = "Ir a la pantalla A")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaInicio(navController: NavHostController) { // 👈 Este es tu contenedor padre único

    var itemSeleccionado by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(top = 16.dp),
                title = {
                    Row {Text("HOLA JACOB, BIENVENIDO",
                        style = MaterialTheme.typography.titleMedium) }
                },
                actions = {
                    // Este bloque se alinea automáticamente a la derecha
                    IconButton(onClick = {
                        navController.navigate("pantallaA")

                    }) {
                        Icon(
                            imageVector = Icons.Default.Person, // Asegúrate de importar androidx.compose.material.icons.filled.Person
                            contentDescription = "Perfil de usuario"
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                // BOTÓN 0: INICIO  -- CASA - INICIO
                NavigationBarItem(
                    selected = itemSeleccionado == 0,
                    onClick = { itemSeleccionado = 0 },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    label = { Text("Inicio") }
                )
                // BOTÓN 1: CATÁLOGO  -- CATEGORIAS
                NavigationBarItem(
                    selected = itemSeleccionado == 1,
                    onClick = { itemSeleccionado = 1 },
                    icon = { Icon(Icons.Default.Star, contentDescription = "Catálogo") },
                    label = { Text("Catálogo") }
                )
                // BOTÓN 2: CARRITO  -- CARRITO
                NavigationBarItem(
                    selected = itemSeleccionado == 2,
                    onClick = { itemSeleccionado = 2 },
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito") },
                    label = { Text("Carrito") }
                )
                // BOTÓN 3: FAVORITOS  -- PRODUCTOS
                NavigationBarItem(
                    selected = itemSeleccionado == 3,
                    onClick = { itemSeleccionado = 3 },
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favoritos") },
                    label = { Text("Favoritos") }
                )
            }
        }
    ) { innerPadding ->

        // El Box ocupa el centro y le pasa los márgenes (innerPadding) a las pantallas
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // EL INTERRUPTOR MÁGICO: Llama a la función limpia de cada pantalla
            when (itemSeleccionado) {
                0 -> VistaInicio()     // 👈 Llama al bloque de código de Inicio
                1 -> VistaCatalogo()   // 👈 Llama al bloque de código de Catálogo
                2 -> VistaCarrito()    // 👈 Llama al bloque de código de Carrito
                3 -> VistaFavoritos()  // 👈 Llama al bloque de código de Favoritos
            }
        }
    }
}

@Composable
fun VistaInicio() {
    Text(text = "DESCUBRE Y AAPROVECHA DESCUENTOS ")
}