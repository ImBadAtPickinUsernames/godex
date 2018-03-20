package com.imbadatpickindomains.godex

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.pokedex_detail_view.*

/**
 * Created by domin on 19.03.2018.
 */

class PokemonDetailView: AppCompatActivity() {
    var ma = MainActivity()
    var pd = PokedexData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokedex_detail_view)

        val bundle = intent.extras
        fillPage(pd.getPokemonData(this), bundle.getInt("dexNum"))
    }

    private fun fillPage(pokemonData: List<Pokemon>, dexNum:Int) {
        val name = "p" + dexNum.inc()
        val shinyName = "s" + dexNum.inc()
        val resID = resources.getIdentifier(name, "drawable", packageName)
        val resIDShiny = resources.getIdentifier(shinyName, "drawable", packageName)

        pokemonName.text = pokemonData[dexNum].name

        // pictures
        imgPokemon.setImageResource(resID)
        imgPokemonShiny.setImageResource(resIDShiny)
        // text - stats
        attackValue.text = pokemonData[dexNum].stats.baseAttack.toString()
        defenceValue.text = pokemonData[dexNum].stats.baseDefense.toString()
        staminaValue.text = pokemonData[dexNum].stats.baseStamina.toString()
        progressBar.max = 300
        progressBar.progress = pokemonData[dexNum].stats.baseAttack
        progressBar2.max = 396
        progressBar2.progress = pokemonData[dexNum].stats.baseDefense
        progressBar3.max = 510
        progressBar3.progress = pokemonData[dexNum].stats.baseStamina

        for (item in pokemonData[dexNum].quickMoves){
            movesetsFast.append(item.name + "\n")
        }

        for (item in pokemonData[dexNum].cinematicMoves){
            movesetsCharge.append(item.name + "\n")
        }

        buddyDistanceValue.text = pokemonData[dexNum].kmBuddyDistance.toString()

    }

}

