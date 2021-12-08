package com.cubidevs.dccomics.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cubidevs.dccomics.data.SuperheroesRepository
import com.cubidevs.dccomics.model.Superheroe
import com.cubidevs.dccomics.model.SuperheroeItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var superheroesLoad : MutableLiveData<ArrayList<SuperheroeItem>> = MutableLiveData()
    val onSuperheroesLoaded: LiveData<ArrayList<SuperheroeItem>> = superheroesLoad

    private val repository = SuperheroesRepository()

    fun getSuperheroesFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            superheroesLoad.postValue(repository.getSuperheroes())
        }
    }

    fun loadMockSuperHeroesFromJson(superHeroesString: InputStream?) {
        val superHeroeString = superHeroesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        superheroesLoad.value = gson.fromJson(superHeroeString, Superheroe::class.java)
    }
}