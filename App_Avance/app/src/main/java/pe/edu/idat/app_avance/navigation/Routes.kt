package pe.edu.idat.app_avance.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.idat.app_avance.screens.PantallaInicio

object Rutas {
    const val INICIO = "inicio"
    const val DETALLE = "detalle"
    const val PERFIL = "perfil"
}

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.INICIO) {
        composable(Rutas.INICIO) {
            // Le pasamos el navController a la pantalla de inicio
            PantallaInicio(navController = navController)
        }
        composable(Rutas.DETALLE) {
            PantallaDetalle()
        }
        composable(Rutas.PERFIL) {
            PantallaPerfil()
        }
    }
}

@Composable
fun PantallaPerfil() {
    TODO("Not yet implemented")
}

@Composable
fun PantallaDetalle() {
    TODO("Not yet implemented")
}

