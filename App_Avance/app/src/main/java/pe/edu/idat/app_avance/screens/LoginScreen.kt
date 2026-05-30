package pe.edu.idat.app_avance.screens


import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController

// codigo del otro iniciar sesion


@Composable  // esto es una vista la pantalla A
fun PantallaA(navController: NavController) {  // LA IDEA ES REDIRECCIONAR A LA PANTALLA B
    Column(Modifier.padding(top = 25.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Button(onClick = {
           /*   ejemplo de codigo */
        }) {
            Text(text = "Ir a la pantalla B")
        }
    }
}

@Composable
fun PantallaLogin(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF0B253A)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = " LOGIN ",
                fontSize = 40.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp),
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                horizontalArrangement = Arrangement.Center,  // Centra horizontalmente
                verticalAlignment = Alignment.CenterVertically  // Centra verticalmente
            )
            {
                // Imagen del logo
                Image(
                    painter = painterResource(id = R.drawable.ic_dialog_map), // 👈 Esta es la forma correcta
                    contentDescription = "Descripción del logo para accesibilidad",
                    modifier = Modifier.size(80.dp)
                )

                // Espacio entre la imagen y el texto
                Spacer(modifier = Modifier.width(8.dp))

                // Texto "Tech Gear Accesorios"
                Column(

                    horizontalAlignment = Alignment.CenterHorizontally, // Centra las líneas de texto

                ) {
                    // Primera línea de texto
                    Text(
                        text = "TECH GEAR",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )

                    // Segunda línea de texto
                    Text(
                        text = "ACCESSORIES",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                }

            }
            Spacer(modifier = Modifier.height(50.dp)) // Este Spacer mueve la caja hacia abajo

            Box(
                modifier = Modifier // Centra la caja en la pantalla
                    .height(450.dp)
                    .width(360.dp)// Tamaño de la caja
                    .padding(top = 20.dp)
                    .background(Color.White.copy(alpha = 0.8f))
                    .border(2.dp, Color.White, RoundedCornerShape(16.dp)) // Borde azul con esquinas redondeadas
                    .clip(RoundedCornerShape(16.dp))// Redondear las esquinas del fondo y contenido
                    .zIndex(10f)  // Asegura que este encima de la base
            )
            {
                // Aquí podrías colocar otros elementos, como el formulario de login
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // creacion de variables para las notas
                    var usuario by rememberSaveable {
                        mutableStateOf("")
                    }
                    var contraseña by rememberSaveable {
                        mutableStateOf("")
                    }

                    Text(text = "!Bienvenido de nuevo!",
                        modifier = Modifier.padding(top = 25.dp),
                        fontSize = 18.sp ,
                        color = Color.Black,
                        textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = "Inicia sesión para explorar accesorios.",
                        fontSize = 18.sp ,
                        color = Color.Black,
                        textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = usuario,
                        onValueChange = { usuario = it },
                        modifier = Modifier.width(320.dp),
                        label = { Text(text = "Usuario", color = Color.Black) },
                        maxLines = 1,
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = contraseña,
                        onValueChange = { contraseña = it },
                        modifier = Modifier.width(320.dp),
                        label = { Text(text = "Contraseña",color = Color.Black) },
                        maxLines = 1,
                        shape = RoundedCornerShape(20.dp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text

                        ))

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            navController.navigate("pantallaB")
                        },
                        modifier = Modifier
                            .width(300.dp)  // Ancho opcional
                            .height(55.dp),  // Alto opcional
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF152C40)  // Color de fondo del botón
                        )
                    ) {
                        Text(text = "INICIAR SESION",
                            fontSize = 24.sp ,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly) {
                        Text(text = "¿No tienes una cuenta?",
                            fontSize = 12.sp ,
                            color = Color.Black)

                        Text(text = "Registrate aqui",
                            fontSize = 12.sp ,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF03A696))

                    }
                    // Agrega los campos y botones dentro de la caja
                }
            }
        }
    }
}


