package com.pomvom.myapplication1.api

import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import javax.inject.Inject

@ViewModelScoped
class ApiHelper @Inject constructor (listApiRetrofit: Retrofit): ApihelperBase {

    lateinit var mListService: ListService
    val listRetrofit = listApiRetrofit

    init {
        mListService = listRetrofit.create(ListService::class.java)
    }

    override suspend fun downloadList(): Welcome {
        return mListService.getList()
    }
}