package com.cubidevs.holaandroid.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cubidevs.holaandroid.R
import com.cubidevs.holaandroid.detalle.DetalleActivity
import com.cubidevs.holaandroid.model.Superheroe
import com.cubidevs.holaandroid.model.SuperheroeItem
import com.google.gson.Gson

class ListSuperheroesActivity : AppCompatActivity() {

    private lateinit var listSuperheroes: ArrayList<SuperheroeItem>
    private lateinit var superHeroesAdapter: SuperHeroesAdapter
    private lateinit var superHeroesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_superheroes)

        superHeroesRecyclerView = findViewById(R.id.superheroes_recycler_view)

    //    listSuperheroes = createMockSuperHeroes()
        listSuperheroes = loadMockSuperHeroesFromJson()
        superHeroesAdapter = SuperHeroesAdapter(listSuperheroes, onItemClicked = { onSuperheroeClicked(it) } )

        superHeroesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = superHeroesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onSuperheroeClicked(superheroe: SuperheroeItem) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("superheroe",superheroe)
        startActivity(intent)
    }

    private fun loadMockSuperHeroesFromJson(): ArrayList<SuperheroeItem> {
        val superHeroesString: String = applicationContext.assets.open("superheroes.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val superHeroesList = gson.fromJson(superHeroesString, Superheroe::class.java)
        return superHeroesList
    }

   /* private fun createMockSuperHeroes(): ArrayList<Superheroe> {
        /* Crear superheroe uno a uno
        var lista: ArrayList<Superheroe> = arrayListOf()
         var superheroe = Superheroe(
             name = "Superman",
             powers = "Super strength, flight, invulnerability, super speed, heat vision, freeze breath, x-ray vision, superhuman hearing, healing factor",
             alias = "Clark Kent, Kal-El",
             city = "Metropolis",
             facebook = "https://www.facebook.com/superman",
             occupation = "Reporter"
         )
         lista.add(superheroe)
         return lista*/

        return arrayListOf(
            Superheroe(
                name = "Superman",
                powers = "Super strength, flight, invulnerability, super speed, heat vision, freeze breath, x-ray vision, superhuman hearing, healing factor",
                alias = "Clark Kent, Kal-El",
                city = "Metropolis",
                facebook = "https://www.facebook.com/superman",
                occupation = "Reporter",
                urlPicture = "https://www.dccomics.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_Superman_20190116_5c3fc2758f6a12.25513240.jpg"
            ),
            Superheroe(
                name = "Batman",
                powers = "Exceptional martial artist, combat strategy, inexhaustible wealth, brilliant deductive skill, advanced technology",
                alias = "Bruce Wayne",
                city = "Gotham",
                facebook = "https://www.facebook.com/batman",
                occupation = "CEO of Wayne Enterprises",
                urlPicture = "https://www.dccomics.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_Batman_20190116_5c3fc4b40faec2.47318964.jpg"
            ),
            Superheroe(
                name = "Wonder Woman",
                powers = "Super strength, invulnerability, flight, combat skill, combat strategy, superhuman agility, healing factor, magic weaponry",
                alias = "Diana Prince",
                city = "Temiscira",
                facebook = "https://www.facebook.com/wonderwoman",
                occupation = "Secretary",
                urlPicture = "https://www.dccomics.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_WonderWoman_20190116_5c3fc6aa51d0e3.49076914.jpg"
            ),
            Superheroe(
                name = "Flash",
                powers = "Super speed, intangibility, superhuman agility",
                alias = "Barry Allen, Jay Garrick, Wally West",
                city = "Central City",
                facebook = "https://www.facebook.com/theflash",
                occupation = "Forensic scientist",
                urlPicture = "https://www.dccomics.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_Flash_20190116_5c3fcaaa18f0e8.03668117.jpg"
            ),
            Superheroe(
                name = "Green Lantern",
                powers = "Hard light constructs, instant weaponry, force fields, flight, durability, alien technology",
                alias = "Hal Jordan",
                city = "Coast City",
                facebook = "",
                occupation = "Test pilot",
                urlPicture = "https://www.dccomics.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_GreenLantern_20200721_5f173ad01724e2.92436411.jpg"
            )
        )
    }*/
}