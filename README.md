# Misterios y Leyendas de Jaén

App cultural sobre leyendas, lugares e historias de Jaén.

## Versión 1

Solo estructura y navegación. Cada pantalla muestra su nombre centrado en un `Text` como marcador de posición: todavía no hay contenido real, mapa, escáner QR, juegos ni formularios.

### Pantallas

| Ruta | Barra superior / etiqueta | Icono |
|---|---|---|
| `novedades` | Novedades | Home |
| `mapa` | Mapa | Map |
| `album` | Álbum | PhotoAlbum |
| `experiencias` | Experiencias | SportsEsports |
| `perfil` | Perfil | Person |

### Navegación

- `MainActivity` llama a `AppPantallas()` dentro del tema que ya traía la plantilla (`ProyectoIntermodularTheme`). No se han añadido temas ni colores.
- Un único `Scaffold` con `TopAppBar` (muestra el nombre de la pantalla actual) y `NavigationBar` (5 opciones, con la seleccionada resaltada).
- `NavHost` con `rememberNavController()`, `startDestination = Rutas.NOVEDADES` y un `composable` por ruta.
- El título se obtiene con `currentBackStackEntryAsState()`.
- `irASeccion()` usa `popUpTo`, `launchSingleTop`, `saveState` y `restoreState` para cambiar de sección sin apilar pantallas duplicadas.
- Organización y nombres inspirados en el proyecto `Intermodular`; la forma de navegar sigue la UD4 de pmdm (`object Rutas`, `NavController`, `NavHost`).

### Datos incluidos

`DatosLeyendas.kt` contiene las **30 leyendas** del fichero `leyendas_jaen.json` (v1.1), con un `data class Leyenda` y un `object DatosLeyendas`. Por ahora **no se muestran en pantalla**: están listos para la versión 2.

### Dependencias añadidas

- `androidx.navigation:navigation-compose:2.10.2`
- `androidx.compose.material:material-icons-extended`

El resto de dependencias ya venían en la plantilla. No se han añadido permisos ni librerías de cámara.

### Archivos principales

- `Rutas.kt` — constantes de las 5 rutas.
- `Secciones.kt` — lista de secciones, iconos y función `irASeccion`.
- `AppPantallas.kt` — `Scaffold` + `NavHost`.
- `BarraSuperior.kt` / `BarraInferior.kt` — barras de navegación.
- `PantallaNovedades.kt`, `PantallaMapa.kt`, `PantallaAlbum.kt`, `PantallaExperiencias.kt`, `PantallaPerfil.kt` — una pantalla por archivo.
- `DatosLeyendas.kt` — modelo y datos de las 30 leyendas.
- `MainActivity.kt` y `strings.xml` — adaptados a la app.
