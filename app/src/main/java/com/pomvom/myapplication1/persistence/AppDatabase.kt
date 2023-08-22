package com.pomvom.myapplication1.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = arrayOf(MainEntity::class), version = 1)
//@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mainDao(): MainDao

    companion object {
        private val DATABASE_NAME = "pomvom_database"

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        fun buildDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME).build()
    }
}
