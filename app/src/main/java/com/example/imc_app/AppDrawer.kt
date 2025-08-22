package com.example.imc_app
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imc_app.ui.theme.BackGround
import com.example.imc_app.ui.theme.Green
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer(viewModel: MainViewModel) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val items = listOf("Home", "Info")

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = Color(0xFF272727)  ) {
                Spacer(modifier = Modifier.height(12.dp))

                NavigationDrawerItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "App Name",
                            tint = Color(0xFFE91E63) // Rosa fuerte llamativo
                        )
                    },
                    label = {
                        Text(
                            "BMI - IMC",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFE91E63) // Rosa vibrante
                            )
                        )
                    },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("home")
                    }
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Opciones de navegación con estilo artístico
                val colors = listOf(Color(0xFF4CAF50), Color(0xFF03A9F4))
                val icons = listOf(Icons.Default.Home, Icons.Default.Info)
                val routes = listOf("home", "info")

                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        icon = {
                            Icon(
                                imageVector = icons[index],
                                contentDescription = item,
                                tint = colors[index % colors.size] // Colores alternados
                            )
                        },
                        label = {
                            Text(
                                text = item,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.Medium,
                                    color = colors[index % colors.size]
                                )
                            )
                        },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate(routes[index])
                        }
                    )
                }
            }
        }
    ) {

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar( // 👈 centrado
                    title = { Text("IMC APP") },
                    navigationIcon = {
                        IconButton(
                            onClick = { scope.launch { drawerState.open() } }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Abrir menú",
                                tint = Color.White // 👈 color del ícono
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Green, // 👈 color de fondo
                        titleContentColor = Color.White, // 👈 color del texto
                        navigationIconContentColor = Color.White // 👈 color del ícono
                    )
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("home") {
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = BackGround),
                        viewModel = viewModel
                    )
                }
                composable("info") {
                    InfoScreen()
                }
            }
        }
    }
}
