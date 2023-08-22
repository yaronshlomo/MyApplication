package com.pomvom.myapplication1.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun MainRoute (){
    val viewModel: MainScreenViewModel = hiltViewModel()

    val uiState by viewModel.viewModelState.collectAsState()
    val items by viewModel.itemsListStateFlow.collectAsStateWithLifecycle(emptyList())

    MainScreen(uiState, {viewModel.downloadItems()}, items)

}