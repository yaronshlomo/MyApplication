package com.pomvom.myapplication1.injection

import android.content.Context
import com.pomvom.myapplication1.persistence.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule{

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = AppDatabase.invoke(context)
}