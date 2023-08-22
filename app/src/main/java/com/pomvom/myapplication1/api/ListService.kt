package com.pomvom.myapplication1.api

import retrofit2.http.GET

interface ListService {

    @GET("gilgoldzweig/SampleTest/db")
    suspend fun getList(): Welcome
}