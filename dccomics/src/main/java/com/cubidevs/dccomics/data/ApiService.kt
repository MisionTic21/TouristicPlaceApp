package com.cubidevs.dccomics.data

import com.cubidevs.dccomics.model.Superheroe
import retrofit2.http.GET

interface ApiService {

    @GET("ciclo4B/HolaAndroid/superheroes")
    suspend fun getSuperheroes(): Superheroe

}