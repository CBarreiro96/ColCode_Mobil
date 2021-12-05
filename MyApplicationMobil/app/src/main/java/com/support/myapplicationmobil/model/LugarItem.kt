package com.support.myapplicationmobil.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LugarItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("Horarios")
    val horarios: String,
    @SerializedName("lugar")
    val lugar: String,
    @SerializedName("Temperatura")
    val temperatura: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("urlPicture")
    val urlPicture: String
) : Serializable