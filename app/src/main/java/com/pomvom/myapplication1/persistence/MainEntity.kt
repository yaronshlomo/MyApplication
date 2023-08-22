package com.pomvom.myapplication1.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MainTable")
data class MainEntity (
    val coverImageURL: String?,
    @PrimaryKey val id: Long?,
    val minimumOrder: Long?,
    val name: String?,
    val open: Boolean?
)