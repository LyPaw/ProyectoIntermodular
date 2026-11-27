package com.example.proyectointermodular

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination

@Composable
fun BarraInferior(
    destino: NavDestination?,
    onSeccionClick: (Seccion) -> Unit,
) {
    NavigationBar {
        seccionesMenu.forEach { seccion ->
            NavigationBarItem(
                selected = destino.esSeccion(seccion),
                onClick = { onSeccionClick(seccion) },
                icon = { Icon(seccion.icono, contentDescription = null) },
                label = { Text(seccion.titulo) },
            )
        }
    }
}
