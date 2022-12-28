package com.wmccd.navigationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wmccd.navigationdemo.screens.Home
import com.wmccd.navigationdemo.screens.Profile
import com.wmccd.navigationdemo.screens.Welcome
import com.wmccd.navigationdemo.ui.theme.NavigationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = NavRoutes.Home.route)
    {
        composable(NavRoutes.Home.route) {
            Home(navHostController = navHostController)
        }
        composable(NavRoutes.Welcome.route + "/{userName}") { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: ""
            Welcome(navHostController = navHostController, userName)
        }
        composable(NavRoutes.Profile.route) {
            Profile()
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationDemoTheme {
        MainScreen()
    }
}