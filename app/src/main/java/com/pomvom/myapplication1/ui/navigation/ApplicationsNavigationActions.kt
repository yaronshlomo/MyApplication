/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pomvom.myapplication1.ui.navigation

import android.util.Log
import androidx.navigation.NavHostController

/**
 * Destinations used in the [CheckApp].
 */
object ApplicationsDestinations {
    const val MAIN_ROUTE = "main_route"
}

/**
 * Models the navigation actions in the app.
 */
class ApplicationNavigationActions(navController: NavHostController) {

    val navigateToMain: (String) -> Unit = {
        Log.d("Navigation", "CheckNavigationActions navigateToStart ${navController.graph}")
        navController.navigate(ApplicationsDestinations.MAIN_ROUTE) { // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            /*         popUpTo(navController.graph.findStartDestination().id) {
                     saveState = true
                 }*/ // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}
