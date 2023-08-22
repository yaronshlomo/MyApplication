package com.pomvom.myapplication1.persistence

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pomvom.myapplication1.api.ItemModel

class DataConverter {
    @TypeConverter
    fun fromCountryLangList(countryLang: List<ItemModel?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<ItemModel?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toCountryLangList(countryLangString: String?): List<ItemModel>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<ItemModel?>?>() {}.type
        return gson.fromJson(countryLangString, type)
    }
}