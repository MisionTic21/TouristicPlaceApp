package com.cubidevs.holaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListSuperheroesActivity : AppCompatActivity() {

    private lateinit var listSuperheroes: ArrayList<TurismoItem>
    private lateinit var superHeroesAdapter: SuperHeroesAdapter
    private lateinit var superHeroesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_superheroes)

        superHeroesRecyclerView = findViewById(R.id.superheroes_recycler_view)

    //    listSuperheroes = createMockSuperHeroes()
        listSuperheroes = loadMockSuperHeroesFromJson()
        superHeroesAdapter = SuperHeroesAdapter(listSuperheroes)

        superHeroesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = superHeroesAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockSuperHeroesFromJson(): ArrayList<TurismoItem> {
        val superHeroesString: String = applicationContext.assets.open("turismo.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val superHeroesList = gson.fromJson(superHeroesString, Turismo::class.java)
        return superHeroesList
    }

}