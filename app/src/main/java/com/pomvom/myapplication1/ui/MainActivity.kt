package com.pomvom.myapplication1.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.rememberNavController
import com.pomvom.myapplication1.ui.navigation.ApplicationNavGraph
import com.pomvom.myapplication1.ui.navigation.ApplicationNavigationActions
import com.pomvom.pomvomscan.ui.theme.ApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalAnimationApi::class) @AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            ApplicationTheme{
                val navController = rememberNavController()
                val navigationActions = remember(navController) {
                    ApplicationNavigationActions(navController)
                }

                ApplicationNavGraph(navController)
            }
        }
    }
}