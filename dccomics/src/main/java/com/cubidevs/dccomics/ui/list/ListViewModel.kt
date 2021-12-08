package com.cubidevs.dccomics.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cubidevs.dccomics.data.DataRepository
import com.cubidevs.dccomics.model.TurismoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    //private var superheroesLoad : MutableLiveData<ArrayList<SuperheroeItem>> = MutableLiveData()
    private var superheroesLoad : MutableLiveData<ArrayList<TurismoItem>> = MutableLiveData()
   // val onSuperheroesLoaded: LiveData<ArrayList<SuperheroeItem>> = superheroesLoad
   val onSuperheroesLoaded: LiveData<ArrayList<TurismoItem>> = superheroesLoad
    private val repository = DataRepository()

    fun getSuperheroesFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            superheroesLoad.postValue(repository.getData())
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