package com.zk.spookynavigation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.setContent
import com.zk.spookynavigation.ui.NavigationTestTheme
import com.zk.spookynavigation.viewModels.Library
import com.zk.spookynavigation.viewModels.MainViewModel
import com.zk.spookynavigation.views.AppView

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val library: Library by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTestTheme {
                AppView()
            }
        }
    }
}

