package com.pomvom.myapplication1.injection

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pomvom.myapplication1.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
class ApiModule {

    /*
     * The method returns the Gson object
     * */
    @Provides
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setLenient()
        return gsonBuilder.create()
    }


    /*
     * The method returns the Cache object
     * */
    @Provides
    fun provideCache(application: Application): Cache {
        val cacheSize = (10 * 1024 * 1024).toLong() // 10 MB
        val httpCacheDirectory = File(application.cacheDir, "http-cache")
        return Cache(httpCacheDirectory, cacheSize)
    }


    /*
     * The method returns the Okhttp object
     * */
    @Provides
    fun provideOkhttpClient(cache: Cache): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.cache(cache)
        httpClient.addInterceptor(logging)
        httpClient.addNetworkInterceptor(HttpLoggingInterceptor())
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        return httpClient.build()
    }


    /*
     * The method returns the Retrofit object
     * */
  /*  @Provides
    @Singleton
    internal fun provideAppRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("http://app-test.pomvom.com/api/v1/")
            .client(okHttpClient)
            .build()
    }*/

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(context.getString(R.string.shared_preference_file), Context.MODE_PRIVATE)
    }



   /* @Provides
    @Singleton
    fun provideApiHelper(gson: Gson, okHttpClient: OkHttpClient,  @ApplicationContext context: Context): ApiHelperBase {
        return ApiHelper(gson, okHttpClient, context)
    }
*/
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .baseUrl("https://my-json-server.typicode.com/").client(okHttpClient).build()
    }

    /* The method returns the Retrofit object
    * */
    /*
     * We need the MovieApiService module.
     * For this, We need the Retrofit object, Gson, Cache and OkHttpClient .
     * So we will define the providers for these objects here in this module.
     *
     * */
  /*  @Provides
    @Singleton
    internal fun provideMovieApiService(retrofit: Retrofit): SearchService {
        return retrofit.create(SearchService::class.java)
    }*/
}
