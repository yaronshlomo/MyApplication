package com.pomvom.myapplication1.api

// To parse the JSON, install Klaxon and do:
//
//   val welcome = Welcome.fromJson(jsonString)

data class ItemModel (
    val coverImageURL: String,

    val id: Long,
    val minimumOrder: Long,
    val name: String,
    val open: Boolean
)

data class Welcome (
    val restaurants: List<ItemModel>
)