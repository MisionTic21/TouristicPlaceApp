package com.cubidevs.dccomics.data

class DataRepository {

    suspend fun getData() = ApiFactory.retrofit.getTurismos() // .getSuperheroes()

}