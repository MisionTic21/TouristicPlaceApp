package com.cubidevs.dccomics.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cubidevs.dccomics.model.Superheroe
import com.cubidevs.dccomics.model.SuperheroeItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var superheroesLoad : MutableLiveData<ArrayList<SuperheroeItem>> = MutableLiveData()
    val onSuperheroesLoaded: LiveData<ArrayList<SuperheroeItem>> = superheroesLoad

    fun loadMockSuperHeroesFromJson(superHeroesString: InputStream?) {
        val superHeroeString = superHeroesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        superheroesLoad.value = gson.fromJson(superHeroeString, Superheroe::class.java)
    }
}