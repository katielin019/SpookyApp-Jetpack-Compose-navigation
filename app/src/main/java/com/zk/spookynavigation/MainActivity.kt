package com.zk.spookynavigation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.zk.spookynavigation.ViewModels.Library
import com.zk.spookynavigation.Views.TabLayout
import com.zk.spookynavigation.ui.NavigationTestTheme

class MainActivity : AppCompatActivity() {

    private val library: Library by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTestTheme {
                TabLayout(viewModel = library)
            }
        }
    }
}

