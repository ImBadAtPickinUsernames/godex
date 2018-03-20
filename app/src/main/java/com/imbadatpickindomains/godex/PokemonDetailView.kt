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
        pokemonName.text = pokemonData[dexNum].name
    }

}

