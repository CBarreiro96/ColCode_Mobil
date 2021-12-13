package com.example.my_application_with_fragment.model


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
    val urlPicture: String,
    @SerializedName("Latitud")
    val Latitud: Double,
    @SerializedName("Longitud")
    val Longitud: Double
) : Serializable