package pe.edu.idat.app_avance.screens

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPerfil(navController: NavHostController) {
    Column( /* modifier = Modifier.padding(top = 16.dp) */)
    {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Mi Perfil") },
                    actions = {
                        // Este bloque se alinea automáticamente a la derecha
                        IconButton(onClick = {  navController.navigate("inicio")
                        }) {
                            Icon(
                                imageVector = Icons.Default.Clear, // Asegúrate de importar androidx.compose.material.icons.filled.Person
                                contentDescription = "Perfil de usuario"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            // Tu contenido principal va aquí dentro
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding) // Crucial para que el contenido no se meta debajo de la barra
            )
            {
                Row ( modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.star_on),
                        contentDescription = "Imagen redonda",
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )


                }
                Column ( modifier = Modifier.fillMaxWidth()
                    .padding(start = 35.dp, end = 25.dp , top = 30.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start

                ) {
                    Spacer(modifier = Modifier.width(20.dp))
                    detallesPerfil("Nombre" , "Jacob"  )
                    Spacer(modifier = Modifier.width(20.dp))
                    detallesPerfil("Apellido" , "Caycho")
                    Spacer(modifier = Modifier.width(20.dp))
                    detallesPerfil("Celular" , "955029009")
                    Spacer(modifier = Modifier.width(20.dp))
                    detallesPerfil("Distrito" , "SJL")
                    Spacer(modifier = Modifier.width(40.dp))

                    Button(
                        onClick = {
                            // Aquí colocas la acción que quieras que pase al presionar
                            navController.navigate("login")
                        }
                    ) {
                        // Este es el texto que se verá dentro del botón
                        Text(text = "Cerrar Sesion",
                            color = Color.Red,
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold)
                    }
                }
            }


        }
    }
}


@Composable
fun detallesPerfil(etiqueta: String, valor: String ) {
    Row(modifier = Modifier.padding(5.dp)) {
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = Icons.Default.Person, // Elige el diseño (Person, Star, Home, etc.)
            contentDescription = "Icono de Perfil", // Texto descriptivo para accesibilidad
            modifier = Modifier.size(50.dp), // Cambia el tamaño del icono aquí
            tint = Color.Gray // Cambia el color del icono
        )

        Column {
            Text(text = etiqueta,
                fontSize = 20.sp,                // Tamaño independiente
                fontWeight = FontWeight.Bold,)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = valor,
                color = Color.Black,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic)
        }
    }
}