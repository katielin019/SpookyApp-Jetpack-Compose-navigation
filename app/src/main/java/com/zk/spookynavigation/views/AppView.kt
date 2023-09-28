package com.zk.spookynavigation.views

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zk.spookynavigation.R
import com.zk.spookynavigation.viewModels.MainViewModel

sealed class NavigationItem(val route: String, val label: String, var icon: Int) {
    object LibraryView: NavigationItem("library_view_route", "Library", R.drawable.ic_book_2)
    object NewBookView: NavigationItem("new_book_view_route", "New Book", R.drawable.ic_add)
    object ChartsView: NavigationItem("charts_view_route", "Charts", R.drawable.ic_bar_chart)
}

@Composable
fun AppView() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController) },
        bodyContent = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        })
}

//@Composable
//fun MainScreen() {
//    val navController = rememberNavController()
//    Scaffold(
//        topBar = { TopBar() },
//        bottomBar = { BottomNavigationBar(navController) },
//        content = { padding ->
//            Box(modifier = Modifier.padding(padding)) {
//                Navigation(navController = navController)
//            }
//        },
//        backgroundColor = colorResource(R.color.colorPrimaryDark) // Set background color to avoid the white flashing when you switch between screens
//    )
//}

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        NavigationItem.LibraryView,
        NavigationItem.NewBookView,
        NavigationItem.ChartsView
    )

    BottomNavigation() {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destinaton?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.label) },
                label = { Text(text = item.label) },
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
@Composable
private fun NavConfiguration(navController: NavHostController) {

}
//@Composable
//fun Navigation(navController: NavHostController) {
//    NavHost(navController, startDestination = NavigationItem.Home.route) {
//        composable(NavigationItem.Home.route) {
//            HomeScreen()
//        }
//        composable(NavigationItem.Music.route) {
//            MusicScreen()
//        }
//        composable(NavigationItem.Movies.route) {
//            MoviesScreen()
//        }
//        composable(NavigationItem.Books.route) {
//            BooksScreen()
//        }
//        composable(NavigationItem.Profile.route) {
//            ProfileScreen()
//        }
//    }
//}
//