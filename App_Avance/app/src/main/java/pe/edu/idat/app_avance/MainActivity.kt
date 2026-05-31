package pe.edu.idat.app_avance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.idat.app_avance.navigation.PantallaPerfil
import pe.edu.idat.app_avance.screens.PantallaA
import pe.edu.idat.app_avance.screens.PantallaB
import pe.edu.idat.app_avance.screens.PantallaInicio
import pe.edu.idat.app_avance.screens.PantallaLogin
import pe.edu.idat.app_avance.screens.PantallaPerfil
import pe.edu.idat.app_avance.ui.theme.App_AvanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_AvanceTheme {
                val navController = rememberNavController()

                // Cambiamos el startDestination a "login" para que sea la primera pantalla
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    // 1. Registramos la pantalla de Login en el enrutador
                    composable(route = "login") {
                        PantallaLogin(navController = navController)
                    }

                    // 2. Ruta para la pantalla inicial (A)
                    composable(route = "inicio") {
                        PantallaInicio(navController = navController)
                    }

                    // 3. Ruta para la otra pantalla (B)
                    composable(route = "perfil") {
                        PantallaPerfil(navController = navController)
                    }

                    // del perfil hacia la pantalla inicio

                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
App_AvanceTheme {
        PantallaInicio(
            navController = TODO()
        )
        //PantallaLogin()
        //PantallaPerfil()
}
}
