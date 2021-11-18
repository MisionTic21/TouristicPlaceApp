package com.cubidevs.holaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListSuperheroesActivity : AppCompatActivity() {

    private lateinit var listSuperheroes: ArrayList<Superheroe>
    private lateinit var superHeroesAdapter: SuperHeroesAdapter
    private lateinit var superHeroesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_superheroes)

        superHeroesRecyclerView = findViewById(R.id.superheroes_recycler_view)

        listSuperheroes = createMockSuperHeroes()
        superHeroesAdapter = SuperHeroesAdapter(listSuperheroes)

        superHeroesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = superHeroesAdapter
            setHasFixedSize(false)
        }
    }

    private fun createMockSuperHeroes(): ArrayList<Superheroe> {
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
                occupation = "Reporter"
            ),
            Superheroe(
                name = "Batman",
                powers = "Exceptional martial artist, combat strategy, inexhaustible wealth, brilliant deductive skill, advanced technology",
                alias = "Bruce Wayne",
                city = "Gotham",
                facebook = "https://www.facebook.com/batman",
                occupation = "CEO of Wayne Enterprises"
            ),
            Superheroe(
                name = "Wonder Woman",
                powers = "Super strength, invulnerability, flight, combat skill, combat strategy, superhuman agility, healing factor, magic weaponry",
                alias = "Diana Prince",
                city = "Temiscira",
                facebook = "https://www.facebook.com/wonderwoman",
                occupation = "Secretary"
            ),
            Superheroe(
                name = "Flash",
                powers = "Super speed, intangibility, superhuman agility",
                alias = "Barry Allen, Jay Garrick, Wally West",
                city = "Central City",
                facebook = "https://www.facebook.com/theflash",
                occupation = "Forensic scientist"
            ),
            Superheroe(
                name = "Green Lantern",
                powers = "Hard light constructs, instant weaponry, force fields, flight, durability, alien technology",
                alias = "Hal Jordan",
                city = "Coast City",
                facebook = "",
                occupation = "Test pilot"
            )
        )
    }
}