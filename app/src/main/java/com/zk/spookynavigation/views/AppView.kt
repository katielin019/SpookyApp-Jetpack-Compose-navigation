package com.zk.spookynavigation.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.zk.spookynavigation.R
import com.zk.spookynavigation.viewModels.MainViewModel

@Composable
fun TabLayout(viewModel: MainViewModel) {
    val tabIndex = viewModel.tabIndex.observeAsState()
}

sealed class NavigationItem(val route: String, val label: String, var icon: Int) {
    object LibraryView: NavigationItem("library_view_route", "Library", R.drawable.ic_book_2)
    object NewBookView: NavigationItem("new_book_view_route", "New Book", R.drawable.ic_add)
    object ChartsView: NavigationItem("charts_view_route", "Charts", R.drawable.ic_bar_chart)
}

@Composable
fun AppView() {
    val nav = rememberNavController()

}

@Composable
private fun NavConfiguration(navController: NavHostController) {

}

//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.ui.Modifier
//import com.tomerpacific.jetpackcomposetabs.MainViewModel
//
//@Composable
//fun TabLayout(viewModel: MainViewModel) {
//    val tabIndex = viewModel.tabIndex.observeAsState()
//    Column(modifier = Modifier.fillMaxWidth()) {
//        TabRow(selectedTabIndex = tabIndex.value!!) {
//            viewModel.tabs.forEachIndexed { index, title ->
//                Tab(text = { Text(title) },
//                    selected = tabIndex.value!! == index,
//                    onClick = { viewModel.updateTabIndex(index) },
//                    icon = {
//                        when (index) {
//                            0 -> Icon(imageVector = Icons.Default.Home, contentDescription = null)
//                            1 -> Icon(imageVector = Icons.Default.Info, contentDescription = null)
//                            2 -> Icon(imageVector = Icons.Default.Settings, contentDescription = null)
//                        }
//                    }
//                )
//            }
//        }
//
//        when (tabIndex.value) {
//            0 -> HomeScreen(viewModel = viewModel)
//            1 -> AboutScreen(viewModel = viewModel)
//            2 -> SettingsScreen(viewModel = viewModel)
//        }
//    }
//}