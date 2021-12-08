package com.cubidevs.dccomics.data

import com.cubidevs.dccomics.model.Superheroe
import com.cubidevs.dccomics.model.Turismo

import retrofit2.http.GET

interface ApiService {

    //@GET("ciclo4B/HolaAndroid/superheroes")

    @GET("Team-111-MisionTic/Team-111/turismos")
    //suspend fun getSuperheroes(): Superheroe
   // suspend fun getSuperheroes(): Turismo
    suspend fun getTurismos(): Turismo

}