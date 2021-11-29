package com.support.myapplicationmobil.model


import com.google.gson.annotations.SerializedName

data class LugarItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)