package com.cubidevs.dccomics.data

class SuperheroesRepository {

    suspend fun getSuperheroes() = ApiFactory.retrofit.getTurismos() // .getSuperheroes()

}