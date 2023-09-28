package com.zk.spookynavigation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.zk.spookynavigation.viewModels.Library
import com.zk.spookynavigation.viewModels.MainViewModel
import com.zk.spookynavigation.views.TabLayout
import com.zk.spookynavigation.ui.NavigationTestTheme

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val library: Library by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTestTheme {
                TabLayout(viewModel = viewModel)
            }
        }
    }
}

