package com.imbadatpickindomains.godex

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import kotlinx.android.synthetic.main.pokedex_detail_view.*

/**
 * Created by domin on 19.03.2018.
 */

class PokemonDetailView: AppCompatActivity() {
    var pd = PokedexData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokedex_detail_view)
        val bundle = intent.extras


        fillPage(pd.getPokemonData(this), pd.getMoveData(this), bundle.getInt("dexNum")/*, this*/)
    }

    private fun fillPage(pokemonData: List<Pokemon>,pokemonMove: List<Move>, dexNum:Int /*, context: Context*/ ) {
        val name = "p" + dexNum.inc()
        val shinyName = "s" + dexNum.inc()
        val resID = resources.getIdentifier(name, "drawable", packageName)
        val resIDShiny = resources.getIdentifier(shinyName, "drawable", packageName)
        val primaryType = findViewById<ImageView>(R.id.imgPrimaryType)
        val secondaryType = findViewById<ImageView>(R.id.imgSecondaryType)
        // get pokemon name
        val pokemonHeader = "#${dexNum.inc()}   ${pokemonData[dexNum].name}"
        pokemonName.text = pokemonHeader
        // get pictures
        imgPokemon.setImageResource(resID)
        imgPokemonShiny.setImageResource(resIDShiny)
        // get primary type
        when {
            pokemonData[dexNum].types[0].name == "Normal" -> primaryType.setImageResource(R.drawable.normal)
            pokemonData[dexNum].types[0].name == "Dark" -> primaryType.setImageResource(R.drawable.dark)
            pokemonData[dexNum].types[0].name == "Psychic" -> primaryType.setImageResource(R.drawable.psychic)
            pokemonData[dexNum].types[0].name == "Poison" -> primaryType.setImageResource(R.drawable.poison)
            pokemonData[dexNum].types[0].name == "Fighting" -> primaryType.setImageResource(R.drawable.fighting)
            pokemonData[dexNum].types[0].name == "Dragon" -> primaryType.setImageResource(R.drawable.dragon)
            pokemonData[dexNum].types[0].name == "Steel" -> primaryType.setImageResource(R.drawable.steel)
            pokemonData[dexNum].types[0].name == "Ice" -> primaryType.setImageResource(R.drawable.ice)
            pokemonData[dexNum].types[0].name == "Ghost" -> primaryType.setImageResource(R.drawable.ghost)
            pokemonData[dexNum].types[0].name == "Electric" -> primaryType.setImageResource(R.drawable.electric)
            pokemonData[dexNum].types[0].name == "Water" -> primaryType.setImageResource(R.drawable.water)
            pokemonData[dexNum].types[0].name == "Fire" -> primaryType.setImageResource(R.drawable.fire)
            pokemonData[dexNum].types[0].name == "Fairy" -> primaryType.setImageResource(R.drawable.fairy)
            pokemonData[dexNum].types[0].name == "Bug" -> primaryType.setImageResource(R.drawable.bug)
            pokemonData[dexNum].types[0].name == "Ground" -> primaryType.setImageResource(R.drawable.ground)
            pokemonData[dexNum].types[0].name == "Flying" -> primaryType.setImageResource(R.drawable.flying)
            pokemonData[dexNum].types[0].name == "Rock" -> primaryType.setImageResource(R.drawable.rock)
            pokemonData[dexNum].types[0].name == "Grass" -> primaryType.setImageResource(R.drawable.grass)
        }
        // get secondary type
        if (pokemonData[dexNum].types.size == 2){
            when {
                pokemonData[dexNum].types[1].name == "Normal" -> secondaryType.setImageResource(R.drawable.normal)
                pokemonData[dexNum].types[1].name == "Dark" -> secondaryType.setImageResource(R.drawable.dark)
                pokemonData[dexNum].types[1].name == "Psychic" -> secondaryType.setImageResource(R.drawable.psychic)
                pokemonData[dexNum].types[1].name == "Poison" -> secondaryType.setImageResource(R.drawable.poison)
                pokemonData[dexNum].types[1].name == "Fighting" -> secondaryType.setImageResource(R.drawable.fighting)
                pokemonData[dexNum].types[1].name == "Dragon" -> secondaryType.setImageResource(R.drawable.dragon)
                pokemonData[dexNum].types[1].name == "Steel" -> secondaryType.setImageResource(R.drawable.steel)
                pokemonData[dexNum].types[1].name == "Ice" -> secondaryType.setImageResource(R.drawable.ice)
                pokemonData[dexNum].types[1].name == "Ghost" -> secondaryType.setImageResource(R.drawable.ghost)
                pokemonData[dexNum].types[1].name == "Electric" -> secondaryType.setImageResource(R.drawable.electric)
                pokemonData[dexNum].types[1].name == "Water" -> secondaryType.setImageResource(R.drawable.water)
                pokemonData[dexNum].types[1].name == "Fire" -> secondaryType.setImageResource(R.drawable.fire)
                pokemonData[dexNum].types[1].name == "Fairy" -> secondaryType.setImageResource(R.drawable.fairy)
                pokemonData[dexNum].types[1].name == "Bug" -> secondaryType.setImageResource(R.drawable.bug)
                pokemonData[dexNum].types[1].name == "Ground" -> secondaryType.setImageResource(R.drawable.ground)
                pokemonData[dexNum].types[1].name == "Flying" -> secondaryType.setImageResource(R.drawable.flying)
                pokemonData[dexNum].types[1].name == "Rock" -> secondaryType.setImageResource(R.drawable.rock)
                pokemonData[dexNum].types[1].name == "Grass" -> secondaryType.setImageResource(R.drawable.grass)
            }
        }

        // get buddy distance
        val buddyDistance = "Buddy Distance: " + pokemonData[dexNum].kmBuddyDistance.toString() + " km"
        buddyDistanceValue.text = buddyDistance

        // get maxCP
        val maxCpText = "Max CP: " + pokemonData[dexNum].maxCP.toString()
        maxCp.text = maxCpText

        // get stats
        val baseAttackText = "Attack: " + pokemonData[dexNum].stats.baseAttack.toString()
        val baseDefenseText = "Defence: " + pokemonData[dexNum].stats.baseDefense.toString()
        val baseStaminaText = "Stamina: " + pokemonData[dexNum].stats.baseStamina.toString()

        attackValue.text = baseAttackText
        defenseValue.text = baseDefenseText
        staminaValue.text = baseStaminaText

        // view the stats in comparision to the best/worst stats in the game
        progressBar.max = 300
        progressBar.progress = pokemonData[dexNum].stats.baseAttack
        progressBar2.max = 396
        progressBar2.progress = pokemonData[dexNum].stats.baseDefense
        progressBar3.max = 510
        progressBar3.progress = pokemonData[dexNum].stats.baseStamina

        // getting the moves from pokemon data set
        for (moveName in pokemonData[dexNum].quickMoves){
            var dmg = ""
            var type = ""
            // getting info about those moves from the move data set
            for(move in pokemonMove){
                if (moveName.name == move.name){
                    dmg = move.power.toString()
                    type = move.pokemonType.name
                }
            }
            val fastMove = moveName.name.replace("Fast", "")
            movesetsFast.append("$fastMove   $dmg   [ $type ]\n")
        }
        // getting the moves from pokemon data set
        for (moveName in pokemonData[dexNum].cinematicMoves){
            var dmg = ""
            var type = ""
            // getting info about those moves from the move data set
            for(move in pokemonMove){
                if (moveName.name == move.name){
                    dmg = move.power.toString()
                    type = move.pokemonType.name
                }
            }
            movesetsCharge.append("${moveName.name}   $dmg   [ $type ]\n")
        }

        // getting advanced details
        val attackProbabilityText = "Attack Probability: " + pokemonData[dexNum].encounter.attackProbability.toString()
        attackProbability.text = attackProbabilityText
        val baseFleeRateText = "Base Flee Rate: " + pokemonData[dexNum].encounter.baseFleeRate.toString()
        baseFleeRate.text = baseFleeRateText
        val baseCaptureRateText = "Base Capture Rate: " + pokemonData[dexNum].encounter.baseCaptureRate.toString()
        baseCaptureRate.text = baseCaptureRateText
        val dodgeProbabilityText = "Dodge Probability: " + pokemonData[dexNum].encounter.dodgeProbability.toString()
        dodgeProbability.text = dodgeProbabilityText
    }

}

