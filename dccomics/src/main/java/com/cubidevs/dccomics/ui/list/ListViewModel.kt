package com.cubidevs.dccomics.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cubidevs.dccomics.data.SuperheroesRepository
import com.cubidevs.dccomics.model.Superheroe
import com.cubidevs.dccomics.model.SuperheroeItem
import com.cubidevs.dccomics.model.Turismo
import com.cubidevs.dccomics.model.TurismoItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    //private var superheroesLoad : MutableLiveData<ArrayList<SuperheroeItem>> = MutableLiveData()
    private var superheroesLoad : MutableLiveData<ArrayList<TurismoItem>> = MutableLiveData()
   // val onSuperheroesLoaded: LiveData<ArrayList<SuperheroeItem>> = superheroesLoad
   val onSuperheroesLoaded: LiveData<ArrayList<TurismoItem>> = superheroesLoad
    private val repository = SuperheroesRepository()

    fun getSuperheroesFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            superheroesLoad.postValue(repository.getSuperheroes())
        }
    }
/*
    fun loadMockSuperHeroesFromJson(superHeroesString: InputStream?) {
        val superHeroeString = superHeroesString?.bufferedReader().use { it!!.readText() }
        Log.d("json",superHeroeString)
        val gson = Gson()
     //   superheroesLoad.value = gson.fromJson(superHeroeString, Superheroe::class.java)

          superheroesLoad.value = gson.fromJson(superHeroeString, Turismo::class.java)

    }*/
}