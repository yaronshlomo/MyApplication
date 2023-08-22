package com.pomvom.myapplication1.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entities: List<MainEntity>): List<Long>

    @Query("SELECT * FROM MainTable")
    fun getListFlow(): Flow<List<MainEntity>>
}