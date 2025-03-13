package com.dev.rhyan.stutwear.presentation.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.dev.rhyan.stutwear.presentation.components.BottomNavigationBar
import com.dev.rhyan.stutwear.presentation.components.Screen
import com.dev.rhyan.stutwear.presentation.ui.explore.ExploreScreen
import com.dev.rhyan.stutwear.presentation.ui.favorite.FavoriteScreen
import com.dev.rhyan.stutwear.presentation.ui.home.HomeScreen
import com.dev.rhyan.stutwear.presentation.ui.login.LoginScreen
import com.dev.rhyan.stutwear.presentation.ui.profile.ProfileScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen() {

    val navhost = rememberNavController()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxSize().padding(bottom = 30.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                val screen = listOf(
                    Screen.Home,
                    Screen.Explore,
                    Screen.Data,
                    Screen.Profile
                )
                BottomNavigationBar(
                    screens = screen,
                    onScreenSelected = {
                        navhost.navigate(route = it, navOptions = navOptions {
                               launchSingleTop = true
                                popUpTo(navhost.graph.startDestinationId)
                        })
                    }
                )
            }
        }
    ) { padingvalues ->
        Column(
            modifier = Modifier.background(Color(0xFF161616))
        ) {
            NavHost(navController = navhost, startDestination = "login") {
                composable("login") {
                    LoginScreen()
                }
                composable("Home") {
                    HomeScreen()
                }
                composable("Explore") {
                    ExploreScreen()
                }
                composable("Favorite") {
                    FavoriteScreen()
                }
                composable("Profile") {
                    ProfileScreen()
                }
            }
        }
    }

}