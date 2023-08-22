package com.pomvom.myapplication1.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pomvom.myapplication1.api.ItemModel
import com.pomvom.myapplication1.persistence.MainEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UiStateModel(var list: List<ItemModel> = ArrayList())

@HiltViewModel class MainScreenViewModel @Inject constructor(mainScreenRepository: MainScreenRepository) : ViewModel() {

    private val TAG = MainScreenViewModel::class.java.simpleName
    val mRepository = mainScreenRepository

    val viewModelState = MutableStateFlow(UiStateModel())

    val itemsListStateFlow: Flow<List<MainEntity>> = mRepository.getListFromDbAsFlow().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    init {
        viewModelScope.launch {
            val list = mRepository.getListFromDbAsFlow()

        }

    }

    fun downloadItems() {
        viewModelScope.launch {
            val items = mRepository.downloadList()
            val array = ArrayList<MainEntity>()
            items.restaurants.forEach {
                array.add(MainEntity(it.coverImageURL, it.id, it.minimumOrder, it.name, it.open))
            }
            mRepository.saveList(array)
            Log.d(TAG, "downloadItems $items")
        }
    }


}