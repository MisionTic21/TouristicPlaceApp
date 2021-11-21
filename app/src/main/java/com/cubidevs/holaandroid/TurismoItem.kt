package com.cubidevs.holaandroid


import com.google.gson.annotations.SerializedName

data class TurismoItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("heigth")
    val heigth: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)