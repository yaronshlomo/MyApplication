package com.pomvom.myapplication1.ui.main

import com.pomvom.myapplication1.api.ApiHelper
import com.pomvom.myapplication1.api.ApihelperBase
import com.pomvom.myapplication1.api.Welcome
import com.pomvom.myapplication1.persistence.AppDatabase
import com.pomvom.myapplication1.persistence.MainEntity
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class MainScreenRepository @Inject constructor(apiHelperBase: ApiHelper, database: AppDatabase) {

    var mApiHelper: ApihelperBase = apiHelperBase
    private val mAppDatabase = database

    suspend fun downloadList(): Welcome{
        return mApiHelper.downloadList()
    }

    suspend fun saveList(list: List<MainEntity>){
        mAppDatabase.mainDao().insert(list)
    }

    fun getListFromDbAsFlow(): Flow<List<MainEntity>> {
       return mAppDatabase.mainDao().getListFlow()
    }
}