package com.cubidevs.dccomics.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TurismoItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("heigth")
    val height: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: Int,
    @SerializedName("time")
    val time: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("latitud")
    val latitud: Double,
    @SerializedName("longitud")
    val longitud: Double
): Serializable