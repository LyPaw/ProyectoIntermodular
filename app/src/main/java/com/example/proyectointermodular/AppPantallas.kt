package com.example.proyectointermodular

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun AppPantallas() {
    val navController = rememberNavController()
    val entrada by navController.currentBackStackEntryAsState()
    val destino = entrada?.destination

    val titulo = when (destino?.route) {
        Rutas.MAPA -> "Mapa"
        Rutas.ALBUM -> "Álbum"
        Rutas.EXPERIENCIAS -> "Experiencias"
        Rutas.PERFIL -> "Perfil"
        else -> "Novedades"
    }

    Scaffold(
        topBar = { BarraSuperior(titulo) },
        bottomBar = {
            BarraInferior(
                destino = destino,
                onSeccionClick = { seccion -> navController.irASeccion(seccion.ruta) },
            )
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Rutas.NOVEDADES,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(Rutas.NOVEDADES) { PantallaNovedades() }
            composable(Rutas.MAPA) { PantallaMapa() }
            composable(Rutas.ALBUM) { PantallaAlbum() }
            composable(Rutas.EXPERIENCIAS) { PantallaExperiencias() }
            composable(Rutas.PERFIL) { PantallaPerfil() }
        }
    }
}
