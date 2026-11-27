package com.example.proyectointermodular

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhotoAlbum
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination

data class Seccion(
    val ruta: String,
    val titulo: String,
    val icono: ImageVector,
)

val seccionesMenu = listOf(
    Seccion(Rutas.NOVEDADES, "Novedades", Icons.Default.Home),
    Seccion(Rutas.MAPA, "Mapa", Icons.Default.Map),
    Seccion(Rutas.ALBUM, "Álbum", Icons.Default.PhotoAlbum),
    Seccion(Rutas.EXPERIENCIAS, "Experiencias", Icons.Default.SportsEsports),
    Seccion(Rutas.PERFIL, "Perfil", Icons.Default.Person),
)

fun NavDestination?.esSeccion(seccion: Seccion): Boolean =
    this?.route == seccion.ruta

fun NavController.irASeccion(ruta: String) {
    navigate(ruta) {
        popUpTo(Rutas.NOVEDADES) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}
